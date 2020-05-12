package com.pranavlari.Collections;

import java.util.ArrayList;

public class Team<T extends Player> {
    private String name;
    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addPlayer(T player) {
        if(members.contains(player)) {
            System.out.println(player.getName()+" is already on the team");
        }
        else if(player.getTeam() != null) {
            System.out.println("Player is already on a team!!");
        }
        else {
            members.add(player);
            player.setTeam(this.name);
        }
    }

    public void removePlayer(T player) {
        if(members.contains(player)) {
            members.remove(player);
            System.out.println(player.getName()+" removed from "+this.name);
        }
        else {
            System.out.println("Player is not on the team");
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<T> getMembers() {
        return members;
    }
}
