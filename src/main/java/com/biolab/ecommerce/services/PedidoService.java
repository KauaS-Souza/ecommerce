package com.biolab.ecommerce.services;

import com.biolab.ecommerce.DTOs.PedidoDTO;
import com.biolab.ecommerce.entites.Pedido;
import com.biolab.ecommerce.entites.Usuario;
import com.biolab.ecommerce.entites.enums.StatusPedido;
import com.biolab.ecommerce.repositories.PedidoRepository;
import com.biolab.ecommerce.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PedidoService {

    public final PedidoRepository pedidoRepository;
    public final UsuarioRepository usuarioRepository;

    public PedidoService(PedidoRepository pedidoRepository, UsuarioRepository usuarioRepository) {
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public String criarPedido(PedidoDTO dto){
        Usuario u = usuarioRepository.findById(dto.getIdCliente()).orElseThrow();
        Pedido p = new Pedido();
        p.setCliente(u);
        p.setMomento(Instant.now());
        p.setStatus(StatusPedido.AGUARDADO_PAGAMENTO);
        pedidoRepository.save(p);
        return "Pedido criado com sucesso";
    }
}
