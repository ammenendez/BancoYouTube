package br.ufs.tep.bancoyoutube;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ammenendez on 31/08/16.
 */
public class Livro extends RealmObject {
    @PrimaryKey
    private int id;
    private String titulo;
    private String autor;
    private int ano;

    public String getTitulo() {
        return titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
