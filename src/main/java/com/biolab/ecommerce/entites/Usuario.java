package com.biolab.ecommerce.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
// Substitui os getters e setters;
@Data
// Substitui o construtor com todos os argumentos;
@AllArgsConstructor
// Substitui o construtor vazio;
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String nome;
    @NotBlank @Email
    @Column(length = 150, unique = true)
    private String email;
    @Column(length = 20)
    private String telefone;
    @NotBlank @Size(min = 6)
    @Column(length = 150)
    private String senha;
    private String[] roles;

}
