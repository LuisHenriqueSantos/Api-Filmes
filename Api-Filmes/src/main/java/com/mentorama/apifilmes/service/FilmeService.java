package com.mentorama.apifilmes.service;

import com.mentorama.apifilmes.entities.Filme;
import com.mentorama.apifilmes.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService implements IFilmeService {

    private final FilmeRepository filmeRepository = FilmeRepository.getInstance();

    public List<Filme> findAll(String filme) {
        if (filme != null) {
            return filmeRepository.findAll(filme);
        }
        return filmeRepository.findAll();
    }

    public Filme findById(Integer id) {
        return filmeRepository.findById(id);
    }

    public Integer add(final Filme filme) {
        if (filme.getNotaFilme() == null || filme.getNotaFilme() < 1 || filme.getNotaFilme() > 5) {
            throw new IllegalArgumentException("A nota do filme deve ser um número inteiro entre 1 e 5.");
        }
        
        if (filmeRepository.existsByNomeAnoDiretor(filme.getNome(), filme.getAno(), filme.getNomeDiretor())) {
            throw new IllegalArgumentException("Filme já cadastrado com o mesmo Nome, Ano e Diretor.");
        }
        
        if (filme.getId() == null) {
            filme.setId(filmeRepository.count() + 1);
        } else {
            if (filmeRepository.findById(filme.getId()) != null) {
                throw new IllegalArgumentException("ID do filme já existe.");
            }
        }

        filmeRepository.add(filme);
        return filme.getId();
    }

    public void update(final Filme filme) {
        if (filme.getId() == null || filmeRepository.findById(filme.getId()) == null) {
            throw new IllegalArgumentException("Filme com o ID informado não existe.");
        }
        
        if (filme.getNotaFilme() == null || filme.getNotaFilme() < 1 || filme.getNotaFilme() > 5) {
            throw new IllegalArgumentException("A nota do filme deve ser um número inteiro entre 1 e 5.");
        }
        
        List<Filme> all = filmeRepository.findAll();
        for (Filme f : all) {
            if (!f.getId().equals(filme.getId()) &&
                    f.getNome().equalsIgnoreCase(filme.getNome()) &&
                    f.getAno().equals(filme.getAno()) &&
                    f.getNomeDiretor().equalsIgnoreCase(filme.getNomeDiretor())) {
                throw new IllegalArgumentException("Já existe outro filme com o mesmo Nome, Ano e Diretor.");
            }
        }

        filmeRepository.update(filme);
    }

    public void delete(Integer id) {
        filmeRepository.delete(id);
    }
}
