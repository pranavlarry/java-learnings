package com.pranavlari.Collections;

public abstract class Player {
    private String name;
    private String team = null;

    public Player(String name) {
        this.name = name;
    }

    public void setTeam(String name) {
        this.team = name;
    }

    public String getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }
}
