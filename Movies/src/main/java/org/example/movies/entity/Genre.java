package org.example.movies.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @Column(name = "genre_id", nullable = false)
    private Integer id;

    @Column(name = "genre_name", length = 100)
    private String genreName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

}