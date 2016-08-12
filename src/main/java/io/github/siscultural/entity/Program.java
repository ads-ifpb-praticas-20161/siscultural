/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.siscultural.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Natarajan Rodrigues && Victor Hugo
 */
@Entity
public class Program implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long    id;
    private String  name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private List<Presentation> presentations;

    public Program() {
        
        this.presentations = new ArrayList<>();        
    }

    public Program(String name) {
        
        this.name = name;
        this.presentations = new ArrayList<>();        
    }

    public void setProposals(List<Presentation> presentations) {
        this.presentations = presentations;
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Presentation> getRubrics() {
        
        return Collections.unmodifiableList(presentations);
    }
    
    public boolean addRubric(Presentation presentation){
        
        return this.presentations.add(presentation);
    }
    
    public boolean removeRubric(Presentation presentation){
        
        return this.presentations.remove(presentation);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + new Long(id).hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Program other = (Program) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
            
}
