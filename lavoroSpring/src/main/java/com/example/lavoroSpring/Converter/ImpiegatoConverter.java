package com.example.lavoroSpring.Converter;

import com.example.lavoroSpring.DTO.ImpiegatoDTOstring;
import com.example.lavoroSpring.Entity.Impiegato;
import com.example.lavoroSpring.Entity.Ordine;

public class ImpiegatoConverter {

    public static ImpiegatoDTOstring impiegatoDTOstring(Impiegato impiegato) {
        ImpiegatoDTOstring impiegatoDTOstring = new ImpiegatoDTOstring();
        impiegatoDTOstring.setId(impiegato.getId());
        impiegatoDTOstring.setNome(impiegato.getNome());
        impiegatoDTOstring.setCognome(impiegato.getCognome());
        if(impiegato.getLivello()!=null) impiegatoDTOstring.setLivello(impiegato.getLivello());
        if (impiegato.getOrdini() != null) {
            for (Ordine o : impiegato.getOrdini()) {
                impiegatoDTOstring.getOrdini().add(o.toString());
            }
        }
        return impiegatoDTOstring;
    }
}
