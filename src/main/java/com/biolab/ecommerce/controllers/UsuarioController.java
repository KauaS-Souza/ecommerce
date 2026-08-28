package com.biolab.ecommerce.controllers.Usuario;

import com.biolab.ecommerce.DTOs.UsuarioDTO;
import com.biolab.ecommerce.services.Usuarioservice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final Usuarioservice service;

    public UsuarioController(Usuarioservice service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody UsuarioDTO dto){

        return ResponseEntity.ok(service.criar(dto));
    }
}
