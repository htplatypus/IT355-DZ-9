package org.example.consumerdemo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "country")
public class Country implements Serializable {
    @Id
    @Column(name = "country_id", nullable = false)
    private Integer id;

    @Column(name = "country_iso_code", length = 10)
    private String countryIsoCode;

    @Column(name = "country_name", length = 200)
    private String countryName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

}