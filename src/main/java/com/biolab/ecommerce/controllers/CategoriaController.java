package com.biolab.ecommerce.controllers;

import com.biolab.ecommerce.DTOs.CategoriaDTO;
import com.biolab.ecommerce.services.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> criarCategoria(@Valid @RequestBody CategoriaDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCat(@PathVariable long id){
        // Status code 200
        return ResponseEntity.ok().body(service.buscarCatId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCat(@PathVariable long id){
        service.delete(id); // Status code 204
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> listCat(){
        return ResponseEntity.ok().body(service.listCat());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterarCat(@PathVariable long id, @RequestBody CategoriaDTO dto){
        return ResponseEntity.ok().body(service.alterarCat(id, dto));
    }

}
