package com.example.lavoroSpring.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name="impiegati")
public class Impiegato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cognome;
    private Integer livello;
    @OneToMany(mappedBy = "impiegato")
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
        return id+" "+nome+" "+cognome+" livello: "+livello;
    }

    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass() != o.getClass()) return false;
        Impiegato i = (Impiegato)o;
        return id==i.id;
    }

    public int hashCode(){
        return Objects.hash(id);
    }
}
