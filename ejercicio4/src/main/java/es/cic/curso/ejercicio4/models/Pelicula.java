package es.cic.curso.ejercicio4.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "El título no puede estar vacío")
    @Size(min = 1, max = 100, message = "El título debe tener entre 1 y 100 caracteres")
    private String titulo;

    @Min(value = 1900, message = "El año debe ser como mínimo 1900")
    private int ano;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;
    
    public Pelicula() {
    }

    public Pelicula(Long id, String titulo, int ano, Director director) {
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.director = director;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}