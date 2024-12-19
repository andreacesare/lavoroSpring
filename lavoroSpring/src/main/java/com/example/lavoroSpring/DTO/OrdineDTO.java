package com.example.lavoroSpring.DTO;

import com.example.lavoroSpring.Entity.Impiegato;
import com.example.lavoroSpring.Entity.Ordine;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.Objects;

public class OrdineDTO {
    private Integer id;
    private String cliente;
    private LocalDate data;
    private Integer importo;
    private Integer impiegato;

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
    public Integer getImpiegato(){
        return impiegato;
    }
    public void setImpiegato(Integer impiegato){
        this.impiegato = impiegato;
    }


    public String toString(){
        return id+"\t"+cliente+"\t"+data+"\t"+importo;
    }

    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass() != o.getClass()) return false;
        OrdineDTO ordine = (OrdineDTO)o;
        return id==ordine.id;
    }

    public int hashCode(){
        return Objects.hash(id);
    }
}
