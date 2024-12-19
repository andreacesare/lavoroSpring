package com.example.lavoroSpring.Controller;

import com.example.lavoroSpring.DTO.ImpiegatoDTOstring;
import com.example.lavoroSpring.Service.ImpiegatoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
