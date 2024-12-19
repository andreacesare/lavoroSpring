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
import java.util.NoSuchElementException;

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


}
