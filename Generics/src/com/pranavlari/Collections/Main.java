package com.pranavlari.Collections;

public class Main {

    public static void main(String[] args) {
	    Team<FootballPlayer> barca = new Team<>("Barcelona");
	    Team<FootballPlayer> real = new Team<>("Real");
	    Team<CricketPlayer> india = new Team<>("India");
	    Team<CricketPlayer> eng = new Team<>("England");

	    FootballPlayer messi = new FootballPlayer("Messi");
	    FootballPlayer suarez = new FootballPlayer("Suarez");
	    FootballPlayer ronaldo = new FootballPlayer("Ronaldo");
	    FootballPlayer hazard = new FootballPlayer("Hazard");

	    barca.addPlayer(messi);
	    barca.addPlayer(suarez);
	    real.addPlayer(ronaldo);
	    real.addPlayer(hazard);

	    CricketPlayer sachin = new CricketPlayer("Sachin");
	    CricketPlayer dhoni = new CricketPlayer("Dhoni");
	    CricketPlayer root = new CricketPlayer("Root");
	    CricketPlayer stocks = new CricketPlayer("Ben Stocks");

	    india.addPlayer(sachin);
	    india.addPlayer(dhoni);
	    india.removePlayer(dhoni);
		india.removePlayer(dhoni);
	    eng.addPlayer(root);
	    eng.addPlayer(stocks);

	    barca.getMembers().forEach(player-> System.out.println(player.getName()));
    }
}
