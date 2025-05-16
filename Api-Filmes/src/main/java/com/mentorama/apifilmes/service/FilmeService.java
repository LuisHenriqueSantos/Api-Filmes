package com.mentorama.apifilmes.service;

import com.mentorama.apifilmes.entities.Filme;
import com.mentorama.apifilmes.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService implements IFilmeService{

    private FilmeRepository filmeRepository = FilmeRepository.getInstance();

    public List<Filme> findAll(String filme) {
        if(filme != null){
            return filmeRepository.findAll(filme);
        }
        return filmeRepository.findAll();
    }
    
    public Filme findById(Integer id){
        return filmeRepository.findById(id);
    }

    public Integer add(final Filme filme){
        if(filme.getId() == null){
            filme.setId(filmeRepository.cout() + 1);
        }
        filmeRepository.add(filme);
        return filme.getId();
    }

    public void update(final Filme filme){
        filmeRepository.update(filme);
    }

    public void delete(Integer id){
        filmeRepository.delete(id);
    }
    
}
