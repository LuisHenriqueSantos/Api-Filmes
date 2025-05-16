package com.mentorama.apifilmes.entities;

public class Filme {

    private Integer id; 
    private String nome; 
    private String nomeDiretor; 
    private Integer ano; 
    private Integer notaFilme;

    public Filme(){
    }

    public Filme(Integer id, String nome, String nomeDiretor, Integer ano, Integer notaFilme) {
        this.id = id;
        this.nome = nome;
        this.nomeDiretor = nomeDiretor;
        this.ano = ano;
        this.notaFilme = notaFilme;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getNotaFilme() {
        return notaFilme;
    }

    public void setNotaFilme(Integer notaFilme) {
        this.notaFilme = notaFilme;
    }
}
