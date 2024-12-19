package com.example.lavoroSpring.DTO;

import com.example.lavoroSpring.Entity.Impiegato;

import java.time.LocalDate;
import java.util.Objects;

public class OrdineDTOstring {
    private Integer id;
    private String cliente;
    private LocalDate data;
    private Integer importo;
    private String impiegato;

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
    public String getImpiegato(){
        return impiegato;
    }
    public void setImpiegato(String impiegato){
        this.impiegato = impiegato;
    }


    public String toString(){
        return id+" "+cliente+" "+data+" "+importo;
    }



    public int hashCode(){
        return Objects.hash(id);
    }
}
