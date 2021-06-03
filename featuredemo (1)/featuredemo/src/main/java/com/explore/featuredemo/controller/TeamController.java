package com.explore.featuredemo.controller;

import com.explore.featuredemo.model.Player;
import com.explore.featuredemo.model.Team;
import com.explore.featuredemo.repository.PlayerRepository;
import com.explore.featuredemo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.*;


@RestController
@RequestMapping(value = "api/team")
public class TeamController {


    @Autowired
    private TeamRepository teamRepository;


    @Autowired
    private PlayerRepository playerRepository;


//    @PostConstruct
//    public void init() {
//        List<Team> list = new ArrayList<>();
//
//        Team team = new Team();
//        team.setLocation("Harlem");
//        team.setName("Globetrotters");
//        list.add(team);
//
//        Team team2 = new Team();
//        team2.setLocation("Washington");
//        team2.setName("Generals");
//        list.add(team2);
//
//        teamRepository.saveAll(list);
//    }


    @PostConstruct
    public void init() {

        List<Team> list = new ArrayList<>();

        Team team = new Team();
        team.setLocation("Harlem");
        team.setName("Globetrotters");
        Set<Player> setOfPlayer1TO3 = new HashSet<>();
        Player player1 = new Player("chandranshu", "center", 1);
        Player player2 = new Player("chandranshu", "center", 1);
        Player player3 = new Player("chandranshu", "center", 1);
        setOfPlayer1TO3.add(player1);
        setOfPlayer1TO3.add(player2);
        setOfPlayer1TO3.add(player3);
        //playerRepository.saveAll(setOfPlayer1TO3);
        list.add(team);

        Team team2 = new Team();
        team2.setLocation("Washington");
        team2.setName("Generals");
        Set<Player> setOfPlayer4TO6 = new HashSet<>();
        Player player4 = new Player("chandranshu", "forward", 2);
        Player player5 = new Player("chandranshu", "forward", 2);
        Player player6 = new Player("chandranshu", "forward", 2);
        setOfPlayer4TO6.add(player4);
        setOfPlayer4TO6.add(player5);
        setOfPlayer4TO6.add(player6);
        //playerRepository.saveAll(setOfPlayer4TO6);
        team2.setSetOfPlayer(setOfPlayer4TO6);
        list.add(team2);


        Team team3 = new Team();

        team3.setLocation("Washington");
        team3.setName("Generals");
        list.add(team3);


        Team team4 = new Team();
        //team4.setId(3l);
        team4.setLocation("Washington");
        team4.setName("Generals");
        list.add(team4);

        teamRepository.saveAll(list);
        //return list;
    }


    @GetMapping("/teamsdata")
    public Iterable<Team> getTeams() {
        return teamRepository.findAll();
    }

    @GetMapping(value = "/teams/{id}")
    public Optional<Team> getTeamsById(@PathVariable long id) {
        return teamRepository.findById(id);
    }


}
