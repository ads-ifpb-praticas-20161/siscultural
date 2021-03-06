/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.siscultural.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Classe que representa uma localidade
 * @author Natarajan Rodrigues && Victor Hugo
 */
@Entity
public class Locality implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;             //identificador numérico

    @Size(min = 1, max = 150, message = "Não pode ser nulo. Valor máximo - 150 caracteres")
    @NotNull(message = "Insira a descrição da localidade")
    private String description; //descrição textual que descreve nominalmente da localidade;

    @Size(min = 1, max = 400, message = "Não pode ser nulo. Valor máximo - 400 caracteres")
    @NotNull(message = "Insira o endereço (rua/avenida/travessa/etc, nº, bairro.")
    private String address;     //texto indicando o endeço da localidade

    @Size(min = 1, max = 200, message = "Não pode ser nulo. Valor máximo - 200 caracteres")
    @NotNull(message = "Insira o nome da cidade da localidade.")
    private String city;        //a cidade

    @Column(name = "state_name")
    @Size(min = 2, max = 40, message = "Não pode ser nulo. Valor máximo - 40 caracteres")
    @NotNull(message = "Insira o estado da localidade.")
    private String state;       //o estado

    public Locality() {
    }

    public Locality(String description, String address, String city, String state) {
        this.description = description;
        this.address = address;
        this.city = city;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
}
