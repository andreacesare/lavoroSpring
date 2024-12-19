package com.example.lavoroSpring.Controller;

import com.example.lavoroSpring.DTO.ImpiegatoDTO;
import com.example.lavoroSpring.DTO.ImpiegatoDTOstring;
import com.example.lavoroSpring.Service.ImpiegatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/impiegato")
public class ImpiegatoController {
    private final ImpiegatoService impiegatoService;
    public ImpiegatoController(ImpiegatoService impiegatoService) {
        this.impiegatoService = impiegatoService;
    }

    @GetMapping("/getImpiegatoById/{id}")
    public ImpiegatoDTOstring getImpiegatoById(@PathVariable("id") Integer id) {
        return impiegatoService.getImpiegatoById(id);
    }

    @GetMapping("")
    public List<ImpiegatoDTOstring> getAllImpiegato() {
        return impiegatoService.getAllImpiegati();
    }

    @PostMapping("/saveImpiegato")
    public ImpiegatoDTOstring saveImpiegato(@RequestBody ImpiegatoDTO impiegatoDTO) {
        return impiegatoService.saveImpiegato(impiegatoDTO);
    }

    @DeleteMapping("/deleteImpiegato/{id}")
    public ImpiegatoDTOstring deleteImpiegato(@PathVariable("id") Integer id) {
        return impiegatoService.deleteImpiegato(id);
    }

    @PutMapping("/updateImpiegato/{id}")
    public ImpiegatoDTOstring updateImpiegato(@PathVariable("id") Integer id, @RequestBody ImpiegatoDTO impiegatoDTO) {
        return impiegatoService.updateImpiegato(id, impiegatoDTO);
    }

    @GetMapping("/cliente")
    public List<ImpiegatoDTOstring> impiegatixCliente(@RequestParam("id") String id) {
        return impiegatoService.impiegatiXCliente(id);
    }
}
