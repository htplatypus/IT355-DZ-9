package org.example.movies.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "language_role")
public class LanguageRole {
    @Id
    @Column(name = "role_id", nullable = false)
    private Integer id;

    @Column(name = "language_role", length = 20)
    private String languageRole;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguageRole() {
        return languageRole;
    }

    public void setLanguageRole(String languageRole) {
        this.languageRole = languageRole;
    }

}