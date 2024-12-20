package com.example.lavoroSpring.DTO;

import com.example.lavoroSpring.Entity.Ordine;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImpiegatoDTOstring {
    private Integer id;
    private String nome;
    private String cognome;
    private Integer livello;
    private List<String> ordini=new ArrayList<>();

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getCognome(){
        return cognome;
    }
    public void setCognome(String cognome){
        this.cognome = cognome;
    }
    public Integer getLivello(){
        return livello;
    }
    public void setLivello(Integer livello){
        this.livello = livello;
    }
    public List<String> getOrdini(){
        return ordini;
    }
    public void setOrdini(List<String> ordini){
        this.ordini = ordini;
    }

    public String toString(){
        return id+"\t "+nome+"\t "+cognome+"\tlivello: "+livello;
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        ImpiegatoDTOstring that = (ImpiegatoDTOstring) o;
        return Objects.equals(id, that.id);
    }

    public int hashCode(){
        return Objects.hash(id);

    }


}
