package com.explore.featuredemo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
@Entity
public class Team implements Serializable {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    private String location;


    @OneToMany(
            cascade = CascadeType.ALL)
    @JoinColumn(name = "teamToId")
    private Set<Player> setOfPlayer;//=new HashSet<>();

    public Team() {
    }

    public Team(String name, String location, Set<Player> setOfPlayer) {
        this.name = name;
        this.location = location;
//        this.setOfPlayer = setOfPlayer;
    }

    public Set<Player> getSetOfPlayer() {
        return setOfPlayer;
    }

    public void setSetOfPlayer(Set<Player> setOfPlayer) {
        this.setOfPlayer = setOfPlayer;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
