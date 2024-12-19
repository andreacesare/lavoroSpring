package com.example.lavoroSpring.Service;

import com.example.lavoroSpring.Converter.OrdineConverter;
import com.example.lavoroSpring.DTO.OrdineDTOstring;
import com.example.lavoroSpring.Entity.Ordine;
import com.example.lavoroSpring.Repository.OrdineRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrdineService {
    private final OrdineRepository ordineRepository;
    public OrdineService(OrdineRepository ordineRepository) {
        this.ordineRepository = ordineRepository;
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
}
