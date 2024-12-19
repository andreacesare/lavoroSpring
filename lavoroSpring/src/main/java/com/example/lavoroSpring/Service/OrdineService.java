package com.example.lavoroSpring.Service;

import com.example.lavoroSpring.Converter.OrdineConverter;
import com.example.lavoroSpring.DTO.OrdineDTO;
import com.example.lavoroSpring.DTO.OrdineDTOstring;
import com.example.lavoroSpring.Entity.Impiegato;
import com.example.lavoroSpring.Entity.Ordine;
import com.example.lavoroSpring.Repository.ImpiegatoRepository;
import com.example.lavoroSpring.Repository.OrdineRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class OrdineService {
    private final OrdineRepository ordineRepository;
    private final ImpiegatoRepository impiegatoRepository;

    public OrdineService(OrdineRepository ordineRepository, ImpiegatoRepository impiegatoRepository) {
        this.ordineRepository = ordineRepository;
        this.impiegatoRepository = impiegatoRepository;
    }

    public OrdineDTOstring getOrdineById(int id) {
        Ordine ordine=ordineRepository.findById(id).orElseThrow(()->new NoSuchElementException("Ordine non trovato"));
        return OrdineConverter.toDTOString(ordine);
    }

    public List<OrdineDTOstring> getAllOrdini() {
        List<Ordine> list=ordineRepository.findAll();
        List<OrdineDTOstring> listString=list.stream().map(OrdineConverter::toDTOString).toList();
        return listString;
    }

    public OrdineDTOstring saveOrdine(OrdineDTO ordineDTO) {
        Ordine ordine=new Ordine();
        ordine.setCliente(ordineDTO.getCliente());
        ordine.setData(ordineDTO.getData());
        ordine.setImporto(ordineDTO.getImporto());
        Impiegato impiegato=impiegatoRepository.findById(ordineDTO.getImpiegato().getId()).orElseThrow(()->new NoSuchElementException("Impiegato non trovato"));
        ordine.setImpiegato(impiegato);
        ordineRepository.save(ordine);
        return OrdineConverter.toDTOString(ordine);
    }

    public OrdineDTOstring updateOrdine(Integer id,OrdineDTO ordineDTO) {
        Ordine ordine=ordineRepository.findById(id).orElseThrow(()->new NoSuchElementException("Ordine non trovato"));
        ordine.setCliente(ordineDTO.getCliente()!=null?ordineDTO.getCliente():ordine.getCliente());
        ordine.setData(ordineDTO.getData()!=null?ordineDTO.getData():ordine.getData());
        ordine.setImporto(ordineDTO.getImporto()!=null?ordineDTO.getImporto():ordine.getImporto());
        if(ordineDTO.getImpiegato()!=null){
              Impiegato impiegato=impiegatoRepository.findById(ordineDTO.getImpiegato().getId()).orElseThrow(()->new NoSuchElementException("Impiegato non trovato"));
              ordine.setImpiegato(impiegato);
              ordineRepository.save(ordine);
              impiegatoRepository.save(impiegato);
        }
        return OrdineConverter.toDTOString(ordine);
    }

    public OrdineDTOstring deleteOrdine(Integer id) {
        Ordine ordine=ordineRepository.findById(id).orElseThrow(()->new NoSuchElementException("Ordine non trovato"));
        OrdineDTOstring ordineDTOstring=OrdineConverter.toDTOString(ordine);
        ordine.getImpiegato().getOrdini().remove(ordine);
        impiegatoRepository.save(ordine.getImpiegato());
        ordineRepository.delete(ordine);
        return ordineDTOstring;
    }

    public List<OrdineDTOstring> ordinixImpiegato(Integer id) {
        List<Ordine> ordini=ordineRepository.findAll();
        List<OrdineDTOstring> ordiniString=ordini.stream()
                .filter(o->o.getImpiegato().getId().equals(id))
                .map(OrdineConverter::toDTOString)
                .distinct()
                .toList();
        return ordiniString;
    }

    public List<OrdineDTOstring> ordiniFebbraio(){
        List<Ordine> ordini=ordineRepository.findAll();
        List<OrdineDTOstring> lista=ordini.stream()
                .filter(o->o.getData()!=null&&o.getData().getMonthValue()==2)
                .map(OrdineConverter::toDTOString).toList();
        return lista;
    }

    public List<Map.Entry<String,Double>> ClientiSpesa(){
        List<Ordine> ordini=ordineRepository.findAll();
        Map<String,Double> clienti=ordini.stream().filter(o->o.getCliente()!=null).collect(Collectors.groupingBy(Ordine::getCliente,Collectors.summingDouble(Ordine::getImporto)));
        return clienti.entrySet().stream().sorted((e1,e2)->e2.getValue().compareTo(e1.getValue())).collect(Collectors.toList());
    }

    public List<Map.Entry<Integer,Long>> livelliOrdini(){
        List<Ordine> ordini=ordineRepository.findAll();

        Map<Integer,Long> lista=ordini.stream().filter(o->o.getId()!=0).collect(Collectors.groupingBy(o->o.getImpiegato().getLivello(),Collectors.counting()));

        List<Impiegato> impiegati = impiegatoRepository.findAll();

        Map<Integer, Long> lista2 = impiegati.stream()
                .map(Impiegato::getLivello)
                .distinct()
                .collect(Collectors.toMap(
                        livello -> livello,
                        livello -> lista.getOrDefault(livello, 0L)
                ));
        return lista2.entrySet().stream().collect(Collectors.toList());
    }

    public List<Map.Entry<Impiegato,Double>> impiegatiSoldiTot(){
        List<Ordine> ordini=ordineRepository.findAll();
        Map<Impiegato,Double> lista=ordini.stream().collect(Collectors.groupingBy(Ordine::getImpiegato,Collectors.summingDouble(Ordine::getImporto)));
        return lista.entrySet().stream().collect(Collectors.toList());
    }
    public List<Map.Entry<Integer,Double>> livelliSoldiTot(){
        List<Ordine> ordini=ordineRepository.findAll();
        Map<Integer,Double> lista=ordini.stream().collect(Collectors.groupingBy(o->o.getImpiegato().getLivello(),Collectors.summingDouble(Ordine::getImporto)));
        return lista.entrySet().stream().collect(Collectors.toList());
    }

    public List<Map.Entry<Impiegato,Long>> impiegatiOrdini(){
        List<Ordine> ordini=ordineRepository.findAll();
        Map<Impiegato,Long> lista=ordini.stream().filter(o->o.getId()!=0).collect(Collectors.groupingBy(Ordine::getImpiegato,Collectors.counting()));
        List<Impiegato> impiegati=impiegatoRepository.findAll();
        Map<Impiegato,Long> lista2=impiegati.stream()
                .collect(Collectors.toMap(impiegato->impiegato,impiegato->lista.getOrDefault(impiegato,0L)));
        return lista2.entrySet().stream().collect(Collectors.toList());

    }


}
