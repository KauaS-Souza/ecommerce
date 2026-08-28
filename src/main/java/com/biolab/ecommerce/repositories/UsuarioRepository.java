package com.biolab.ecommerce.repositories;

import com.biolab.ecommerce.entites.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
