package com.project0.esprit.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="authorads")
public class Authorads {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    
    
    @JsonManagedReference
    @ManyToMany(mappedBy = "authors")
    private Set<Adsinses> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Adsinses> getBooks() {
        return books;
    }

    public void setBooks(Set<Adsinses> books) {
        this.books = books;
    }
}
