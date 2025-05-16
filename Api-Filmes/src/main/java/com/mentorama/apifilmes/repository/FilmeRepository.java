package com.mentorama.apifilmes.repository;

import com.mentorama.apifilmes.entities.Filme;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FilmeRepository {
    
    private static FilmeRepository filmeRepository;
    
    public static FilmeRepository getInstance(){
        if(filmeRepository == null){
            filmeRepository = new FilmeRepository();
        }
        return filmeRepository;
    }
    
    private final List<Filme> filmes;

    public FilmeRepository() {
        this.filmes = new LinkedList<>();
    }
    
    public List<Filme> findAll() {
        return filmes;
    }

    public List<Filme> findAll(String filme) {
        return filmes.stream()
                .filter(msg -> msg.getNome().contains(filme))
                .collect(Collectors.toList());
    }
    
    public Filme fildById(Integer id){
        return this.filmes.stream()
                .filter(fil -> fil.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public int cout(){
        return filmes.size();
    }

    public void update(Filme filme){
        filmes.stream()
                .filter(fil -> fil.getId().equals(filme.getId()))
                .forEach(fil -> fil.setNome(filme.getNome()));
    }

    public void delete(Integer id){
        filmes.removeIf(fil -> fil.getId().equals(id));
    }
    
}
