package com.example.informator.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Blob;

@Entity
@Table(name = "equipment")
public class Equipment {


    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min = 0, max = 105)
    private String name;

    @Size(min = 0, max = 2500)
    private String description;

    @Lob
    private byte[] image;

    public Equipment() {
    }

    public Equipment(String name, String description, byte[] image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName(String name) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


}
