package com.example.lavoroSpring.Service;

import com.example.lavoroSpring.Converter.ImpiegatoConverter;
import com.example.lavoroSpring.DTO.ImpiegatoDTO;
import com.example.lavoroSpring.DTO.ImpiegatoDTOstring;
import com.example.lavoroSpring.Entity.Impiegato;
import com.example.lavoroSpring.Entity.Ordine;
import com.example.lavoroSpring.Repository.ImpiegatoRepository;
import com.example.lavoroSpring.Repository.OrdineRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ImpiegatoService {
    private final OrdineRepository ordineRepository;
    private ImpiegatoRepository impiegatoRepository;
    public ImpiegatoService(ImpiegatoRepository impiegatoRepository, OrdineRepository ordineRepository) {
        this.impiegatoRepository = impiegatoRepository;
        this.ordineRepository = ordineRepository;
    }

    public ImpiegatoDTOstring getImpiegatoById(Integer id) {
        Impiegato impiegato=impiegatoRepository.findById(id).orElseThrow(()->new NoSuchElementException("Impiegato non trovato"));
        return ImpiegatoConverter.impiegatoDTOstring(impiegato);
    }

    public List<ImpiegatoDTOstring> getAllImpiegati() {
        List<Impiegato> list = impiegatoRepository.findAll();
        List<ImpiegatoDTOstring> listString = list.stream().map(ImpiegatoConverter::impiegatoDTOstring).toList();
        return listString;
    }

    public ImpiegatoDTOstring saveImpiegato(ImpiegatoDTO impiegatoDTO) {
        Impiegato impiegato=new Impiegato();
        if(impiegato.getId()!=null) impiegato.setId(impiegatoDTO.getId());
        impiegato.setNome(impiegatoDTO.getNome());
        impiegato.setCognome(impiegatoDTO.getCognome());
        impiegato.setLivello(impiegatoDTO.getLivello());
        impiegatoRepository.save(impiegato);
        return ImpiegatoConverter.impiegatoDTOstring(impiegato);

    }

    public ImpiegatoDTOstring deleteImpiegato(Integer id) {
        Impiegato impiegato = impiegatoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Impiegato non trovato"));
        ImpiegatoDTOstring impiegatoDTOstring = ImpiegatoConverter.impiegatoDTOstring(impiegato);
        if (impiegato.getOrdini() != null) {
            for(Ordine ordine : impiegato.getOrdini()) {
                ordineRepository.delete(ordine);
            }
        }
        impiegatoRepository.delete(impiegato);
        return impiegatoDTOstring;
    }

    public ImpiegatoDTOstring updateImpiegato(Integer id,ImpiegatoDTO impiegatoDTO) {
        Impiegato impiegato=impiegatoRepository.findById(id).orElseThrow(()->new NoSuchElementException("Impiegato non trovato"));
        impiegato.setNome(impiegatoDTO.getNome()!=null?impiegatoDTO.getNome(): impiegato.getNome());
        impiegato.setCognome(impiegatoDTO.getCognome()!=null?impiegatoDTO.getCognome(): impiegato.getCognome());
        impiegato.setLivello(impiegatoDTO.getLivello()!=null?impiegatoDTO.getLivello(): impiegato.getLivello());
        return ImpiegatoConverter.impiegatoDTOstring(impiegato);
        }



}
