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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author onitavskyi
 */
@Entity
public class Tournament {

    @Id
    @Column( name = "TOURNAMENT_ID" )
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column( name = "NAME" )
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinTable( name = "TOURNAMENT_PLAYER",
            joinColumns = { @JoinColumn( name = "TOURNAMENT_ID" ) },
            inverseJoinColumns = { @JoinColumn( name = "PLAYER_ID" )}
    )
    private Set<Player> players;

    @Temporal(TemporalType.DATE)
    private Date tournamentStartDate;

    @Temporal(TemporalType.DATE)
    private Date tournamentEndDate;

    public String getName() {
        return name;
    }

    public Tournament setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Player> getPlayers(){
        return players;
    }

    public Tournament addPlayer(Player player){
        if(players == null)
            players = new HashSet<Player>();
        players.add(player);
        return this;
    }

    public Date getTournamentStartDate() {
        return tournamentStartDate;
    }

    public Tournament setTournamentStartDate(Date tournamentStartDate) {
        this.tournamentStartDate = tournamentStartDate;
        return this;
    }

    public Date getTournamentEndDate() {
        return tournamentEndDate;
    }

    public Tournament setTournamentEndDate(Date tournamentEndDate) {
        this.tournamentEndDate = tournamentEndDate;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", players=" + players +
                ", tournamentStartDate=" + tournamentStartDate +
                ", tournamentEndDate=" + tournamentEndDate +
                '}';
    }
}
