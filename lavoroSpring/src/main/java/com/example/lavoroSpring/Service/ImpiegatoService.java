package com.example.lavoroSpring.Service;

import com.example.lavoroSpring.Converter.ImpiegatoConverter;
import com.example.lavoroSpring.DTO.ImpiegatoDTOstring;
import com.example.lavoroSpring.Entity.Impiegato;
import com.example.lavoroSpring.Repository.ImpiegatoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ImpiegatoService {
    private ImpiegatoRepository impiegatoRepository;
    public ImpiegatoService(ImpiegatoRepository impiegatoRepository) {
        this.impiegatoRepository = impiegatoRepository;
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
}
