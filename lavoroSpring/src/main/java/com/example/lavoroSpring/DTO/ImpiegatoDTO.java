package com.example.lavoroSpring.DTO;

import com.example.lavoroSpring.Entity.Impiegato;
import com.example.lavoroSpring.Entity.Ordine;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImpiegatoDTO {
    private Integer id;
    private String nome;
    private String cognome;
    private Integer livello;
    private List<Ordine> ordini=new ArrayList<>();

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
    public List<Ordine> getOrdini(){
        return ordini;
    }
    public void setOrdini(List<Ordine> ordini){
        this.ordini = ordini;
    }

    public String toString(){
        return id+"\t "+nome+"\t "+cognome+"\tlivello: "+livello;
    }

    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass() != o.getClass()) return false;
        ImpiegatoDTO i = (ImpiegatoDTO)o;
        return id==i.id;
    }

    public int hashCode(){
        return Objects.hash(id);
    }
}
