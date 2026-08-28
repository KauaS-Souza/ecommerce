package com.biolab.ecommerce.controllers.Usuario;

import com.biolab.ecommerce.DTOs.PedidoDTO;
import com.biolab.ecommerce.services.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> saveOrder(@RequestBody PedidoDTO dto){
        return ResponseEntity.ok(service.criarPedido(dto));
    }
}
