package com.example.lavoroSpring.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="ordini")
public class Ordine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cliente;
    private LocalDate data;
    private Integer importo;
    @ManyToOne()
    @JoinColumn(name="idimpiegato")
    private Impiegato impiegato;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public String getCliente(){
        return cliente;
    }
    public void setCliente(String cliente){
        this.cliente = cliente;
    }
    public LocalDate getData(){
        return data;
    }
    public void setData(LocalDate data){
        this.data = data;
    }
    public Integer getImporto(){
        return importo;
    }
    public void setImporto(Integer importo){
        this.importo = importo;
    }
    public Impiegato getImpiegato(){
        return impiegato;
    }
    public void setImpiegato(Impiegato impiegato){
        this.impiegato = impiegato;
    }


    public String toString(){
        return id+" "+cliente+" "+data+" $"+importo;
    }

    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass() != o.getClass()) return false;
        Ordine ordine = (Ordine)o;
        return id==ordine.id;
    }

    public int hashCode(){
        return Objects.hash(id);
    }

}
