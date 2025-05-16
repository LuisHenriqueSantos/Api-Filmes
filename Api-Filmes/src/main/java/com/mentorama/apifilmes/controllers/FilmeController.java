package com.mentorama.apifilmes.controllers;


import com.mentorama.apifilmes.entities.Filme;
import com.mentorama.apifilmes.service.IFilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    private List<Filme> filmes;
    
    @Autowired
    private IFilmeService filmeService;
    
    public FilmeController(){
        this.filmes = new LinkedList<>();
    }
    
    @GetMapping
    public List<Filme> findAll(@RequestParam(required = false) String filme){
        return filmeService.findAll(filme);
    }

    @GetMapping("/{id}")
    public Filme findById(@PathVariable("id") Integer id){
        return filmeService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody final Filme filme){
        Integer id = filmeService.add(filme);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody final Filme filme){
        filmeService.update(filme);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        filmeService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    
}
