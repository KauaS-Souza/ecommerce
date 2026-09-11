package com.biolab.ecommerce.services;

import com.biolab.ecommerce.DTOs.CategoriaDTO;
import com.biolab.ecommerce.entites.Categoria;
import com.biolab.ecommerce.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public String criar(CategoriaDTO dto){

        Categoria categoria = new Categoria();

        categoria.setNome(dto.getNome());

        categoriaRepository.save(categoria);
        return "Categoria salva  com sucesso!!";
    }

    public CategoriaDTO buscarCatId(long id){

        Categoria categoria = categoriaRepository.findById(id).orElseThrow();
        CategoriaDTO dto = new CategoriaDTO();

        dto.setId(categoria.getId());
        dto.setNome(categoria.getNome());

        return dto;
    }

    public String delete(long id){
        categoriaRepository.deleteById(id);

        return "Excluido com sucesso!!";
    }

    public List<CategoriaDTO> listCat(){
        return categoriaRepository.findAll().stream()
                .map(categoria -> new CategoriaDTO(
                        categoria.getId(), categoria.getNome()
                ))
                .toList();
    }

    public String alterarCat(long id, CategoriaDTO dto){

        Categoria categoria = categoriaRepository.findById(id).orElseThrow();

        categoria.setNome(dto.getNome());

        categoriaRepository.save(categoria);

        return "Alterações feita com secesso!";
    }

}
