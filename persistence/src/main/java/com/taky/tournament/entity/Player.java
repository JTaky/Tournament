package com.taky.tournament.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import java.util.Set;

/**
 * @author onitavskyi
 */
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column( name = "PLAYER_ID" )
    private Long id;

    @Column( name = "NAME" )
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "players", cascade = CascadeType.ALL)
    private Set<Tournament> tournaments;

    public String getName() {
        return name;
    }

    public Player setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
