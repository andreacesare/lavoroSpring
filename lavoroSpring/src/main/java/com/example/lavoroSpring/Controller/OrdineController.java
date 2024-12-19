package com.example.lavoroSpring.Controller;

import com.example.lavoroSpring.DTO.OrdineDTO;
import com.example.lavoroSpring.DTO.OrdineDTOstring;
import com.example.lavoroSpring.Entity.Impiegato;
import com.example.lavoroSpring.Service.OrdineService;
import jakarta.persistence.Entity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/impiegato")
    public List<OrdineDTOstring> ordinixImpiegato(@RequestParam("id") Integer id) {
        return ordineService.ordinixImpiegato(id);
    }
    @GetMapping("/febbraio")
    public List<OrdineDTOstring> febbraio() {
        return ordineService.ordiniFebbraio();
    }
    @GetMapping("/spesa")
    public List<Map.Entry<String,Double>> ClientiSpesa(){
        return ordineService.ClientiSpesa();
    }

    @GetMapping("/livelli")
    public List<Map.Entry<Integer,Long>> livelliOrdini(){
        return ordineService.livelliOrdini();
    }
    @GetMapping("/impiegatisoldi")
    public List<Map.Entry<Impiegato,Double>> impiegatiSoldiTot(){
        return ordineService.impiegatiSoldiTot();
    }
    @GetMapping("livellisoldi")
    public List<Map.Entry<Integer,Double>> livelliSoldiTot(){
        return ordineService.livelliSoldiTot();
    }
    @GetMapping("/impiegatiordini")
    public List<Map.Entry<Impiegato,Long>> impiegatiOrdini(){
        return ordineService.impiegatiOrdini();
    }
}
