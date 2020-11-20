package com.Echallenge.Dev.classe;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String libelle;

    public Role(int i, String libelle) {
        this.id = i ;
        this.libelle = libelle ;
    }

    public Role() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
