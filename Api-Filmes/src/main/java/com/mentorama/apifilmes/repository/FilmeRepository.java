package com.mentorama.apifilmes.repository;

import com.mentorama.apifilmes.entities.Filme;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FilmeRepository {

    private static FilmeRepository filmeRepository;

    public static FilmeRepository getInstance() {
        if (filmeRepository == null) {
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
                .filter(f -> f.getNome().toLowerCase().contains(filme.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Filme findById(Integer id) {
        return this.filmes.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public int count() {
        return filmes.size();
    }

    public void add(Filme filme) {
        filmes.add(filme);
    }

    public void update(Filme filme) {
        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getId().equals(filme.getId())) {
                filmes.set(i, filme);
                return;
            }
        }
    }

    public void delete(Integer id) {
        filmes.removeIf(f -> f.getId().equals(id));
    }

    public boolean existsByNomeAnoDiretor(String nome, Integer ano, String diretor) {
        return filmes.stream().anyMatch(f -> 
                f.getNome().equalsIgnoreCase(nome) && 
                f.getAno().equals(ano) &&
                f.getNomeDiretor().equalsIgnoreCase(diretor)
        );
    }
}
