package com.mentorama.apifilmes.service;

import com.mentorama.apifilmes.entities.Filme;

import java.util.List;

public interface IFilmeService {

    List<Filme> findAll(String filme);
    Filme findById(Integer id);
    void update(final Filme filme);
    void delete(Integer id);
    Integer add(final Filme filme);
}
