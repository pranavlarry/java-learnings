package com.pranavlari.Collections;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Actor tom = new Actor("Tom Cruise",50);
        Actor rebecca = new Actor("Rebecca Ferguson",38);


        Actor rdj = new Actor("Robert Downey Jr ",48);
        Actor rdj2 = new Actor("Robert Downey Jr ",48);

        Actor chris = new Actor("Chris Evens ",48);
        HashSet<Actor> actors = new HashSet<>();

        actors.addAll(Arrays.asList(rdj,chris));
        Movie avengers = new Movie("Avengers",new String[]{"Action","Thriller"},actors);

        actors = new HashSet<>();
        actors.addAll(Arrays.asList(tom,rebecca));
        Movie mi = new Movie("Mission Imposible",new String[]{"Action","Adventure"},actors);

        actors = new HashSet<Actor>();
        actors.add(tom);
        Movie jr = new Movie("Jack Reacher",new String[]{"Action"},actors);

        actors = new HashSet<Actor>();
        actors.add(rebecca);
        Movie tgs = new Movie("The Great ShowMan",new String[]{"Drama"},actors);

        //union
        HashSet<Movie> tomAndRebecca= new HashSet<>(rebecca.getMovies());
        tomAndRebecca.addAll(tom.getMovies());
        System.out.println("Union: \n ==========");
        printSet(tomAndRebecca);

        //intersection
        HashSet<Movie> tomOrRebecca= new HashSet<>(rebecca.getMovies());
        tomOrRebecca.retainAll(tom.getMovies());
        System.out.println("\n Intersection: \n ==========");
        printSet(tomOrRebecca);

        //difference
        HashSet<Movie> rebeccaMinusTom= new HashSet<>(rebecca.getMovies());
        rebeccaMinusTom.removeAll(tom.getMovies());
        System.out.println("\n Rebecca - tom: \n ==========");
        printSet(rebeccaMinusTom);

        HashSet<Actor> testActors = new HashSet<>();
        testActors.addAll(Arrays.asList(rdj,rdj2));
        Movie testMovie = new Movie("Test Movie",new String[]{"Romance"},testActors);
        System.out.println("\n Duplicate entries due to not overriding equals and hashcode");
        printSet(testMovie.getActors());

        tom.addMovie(new Movie("Mission Imposible",new String[]{"Adventure"},actors));
        System.out.println("\n No duplicates");
        printSet(tom.getMovies());

    }

    private static void printSet(Set<?> set) {
        set.forEach(s->{
            if(s instanceof Actor) {
                System.out.println(((Actor) s).getName());
            }

            else if(s instanceof Movie) {
                System.out.println(((Movie) s).getName());
            }
        });
    }
}
