package com.explore.featuredemo.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Player implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long playerId;

    private String name;

    private String position;

   // private long teamToId;

   /* @ManyToOne(fetch = FetchType.LAZY)
    private Team team;
*/
  /*  public Team getTeam() {
        return team;
    }
*/
    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

   /* public void setTeam(Team team) {
        this.team = team;
    }
*/



    /*public long getTeamToId() {
        return teamToId;
    }

    public void setTeamToId(long teamToId) {
        this.teamToId = teamToId;
    }
*/

    public Player() {
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    public Player(String name, String position, long teamToId) {
        //this.teamToId = teamToId;
        this.name = name;
        this.position = position;
    }
}
