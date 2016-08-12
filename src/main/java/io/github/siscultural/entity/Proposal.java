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
public class Proposal implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String groupOrArtist; 
    private String releaseText;
    private int duration; //in minutes - default 60min
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Presentation> presentations;

    public Proposal() {
        
        presentations = new ArrayList<>();
    }

    public Proposal(String name, String groupOrArtist, String releaseText, int duration) {

        this.name = name;
        this.groupOrArtist = groupOrArtist;
        this.releaseText = releaseText;
        this.duration = duration;
        this.presentations = new ArrayList<>();
    }

    public List<Presentation> getPresentations() {
        return Collections.unmodifiableList(presentations);
    }

    public void setPresentations(List<Presentation> presentations) {
        this.presentations = presentations;
    }
    
    public boolean addPresentation(Presentation presentation){
        
        return presentations.add(presentation);
    }
    
    public boolean removePresentation(Presentation presentation){
        
        return presentations.remove(presentation);
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

    public String getGroupOrArtist() {
        return groupOrArtist;
    }

    public void setGroupOrArtist(String groupOrArtist) {
        this.groupOrArtist = groupOrArtist;
    }

    public String getReleaseText() {
        return releaseText;
    }

    public void setReleaseText(String releaseText) {
        this.releaseText = releaseText;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + new Long(id).hashCode();
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
        final Proposal other = (Proposal) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
