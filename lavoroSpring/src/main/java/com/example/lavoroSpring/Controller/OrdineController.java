package com.example.lavoroSpring.Controller;

import com.example.lavoroSpring.DTO.OrdineDTO;
import com.example.lavoroSpring.DTO.OrdineDTOstring;
import com.example.lavoroSpring.Service.OrdineService;
import jakarta.persistence.Entity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/saveOrdine")
    public OrdineDTOstring saveOrdine(@RequestBody OrdineDTO ordineDTO) {
        return ordineService.saveOrdine(ordineDTO);
    }

    @PutMapping("/updateOrdine/{id}")
    public OrdineDTOstring updateOrdine(@PathVariable("id") Integer id, @RequestBody OrdineDTO ordineDTO) {
        return ordineService.updateOrdine(id, ordineDTO);
    }

    @DeleteMapping("/deleteOrdine/{id}")
    public OrdineDTOstring deleteOrdine(@PathVariable("id") Integer id) {
        return ordineService.deleteOrdine(id);
    }


}
