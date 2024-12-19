package com.example.lavoroSpring.Converter;

import com.example.lavoroSpring.DTO.OrdineDTOstring;
import com.example.lavoroSpring.Entity.Ordine;

public class OrdineConverter {

    public static OrdineDTOstring toDTOString(Ordine ordine){
        OrdineDTOstring ordineDTOstring = new OrdineDTOstring();
        ordineDTOstring.setId(ordine.getId());
        ordineDTOstring.setData(ordine.getData());
        ordineDTOstring.setCliente(ordine.getCliente());
        ordineDTOstring.setImporto(ordine.getImporto());
        ordineDTOstring.setImpiegato(ordine.getImpiegato().getNome()+" "+ordine.getImpiegato().getCognome()+" "+ordine.getImpiegato().getLivello());
        return ordineDTOstring;
    }
}
