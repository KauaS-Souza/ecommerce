package com.biolab.ecommerce.services;

import com.biolab.ecommerce.DTOs.UsuarioDTO;
import com.biolab.ecommerce.entites.Usuario;
import com.biolab.ecommerce.entites.enums.Role;
import com.biolab.ecommerce.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Usuarioservice {

    private final UsuarioRepository repo;

    public Usuarioservice(UsuarioRepository repo) {
        this.repo = repo;
    }

    public String criar(UsuarioDTO u){

        Usuario usuario = new Usuario();

        usuario.setEmail(u.getEmail());
        usuario.setNome(u.getNome());
        usuario.setSenha(u.getSenha());
        usuario.setTelefone(u.getTelefone());
        usuario.setRoles(Role.USER);

        repo.save(usuario);

        return "Usuario criado com sucesso!!";
    }

}
