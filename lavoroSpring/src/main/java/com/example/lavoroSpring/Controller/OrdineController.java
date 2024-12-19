package com.example.lavoroSpring.Controller;

import com.example.lavoroSpring.DTO.OrdineDTOstring;
import com.example.lavoroSpring.Service.OrdineService;
import jakarta.persistence.Entity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ordine")
public class OrdineController {
    private final OrdineService ordineService;
    public OrdineController(OrdineService ordineService) {
        this.ordineService = ordineService;
    }

    @GetMapping("/getOrdineById/{id}")
    public OrdineDTOstring getOrdineById(@PathVariable("id") Integer id) {
        return ordineService.getOrdineById(id);
    }

    @GetMapping("")
    public List<OrdineDTOstring> getAllOrdine() {
        return ordineService.getAllOrdini();
    }
}
