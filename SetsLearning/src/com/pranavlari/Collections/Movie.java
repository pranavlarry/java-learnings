package com.pranavlari.Collections;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Movie {
    private final String name;
    private final String[] genre;
    private final Set<Actor> actors;

    public Movie(String name, String[] genre, HashSet<Actor> actors) {
        this.name = name;
        this.genre = genre;
        this.actors = actors;
        for(Actor actor: actors) {
            actor.addMovie(this);
        }
    }

    public String getName() {
        return name;
    }

    public String[] getGenre() {
        return genre;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
