package com.biolab.ecommerce.repositories;

import com.biolab.ecommerce.entites.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
