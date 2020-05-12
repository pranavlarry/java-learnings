package com.pranavlari.Collections;

import java.util.HashSet;
import java.util.Set;

public class Actor {

    private final String name;
    private final int age;
    private Set<Movie> movies;

    public Actor(String name, int age) {
        this.name = name;
        this.age = age;
        movies = new HashSet<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Set<Movie> getMovies() {
        return movies;
    }
}
