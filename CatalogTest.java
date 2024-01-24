package cs410.webfilmz;
/*

        Author : Professor Ryan Culpepper

        Student name : Abdi Abera
        Subject: cs410
        Date : 10/12/2023

        */
/*
 *
 * ADD YOUR Catalog TESTS TO THIS FILE
 *
 */

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatalogTest {
    final Catalog catalog = getCatalog();

    // Makes a known small catalog for testing
    static Catalog getCatalog() {
        Catalog catalog = new Catalog();
        catalog.add("The Terminator", "James Cameron", "SciFi", 1984);
        catalog.add("The Princess Bride", "Rob Reiner", "Romance", 1987);
        catalog.add("The City of Lost Children", "Jean-Pierre Jeunet", "SciFi", 1995);
        catalog.add("Titanic", "James Cameron", "Romance", 1997);
        catalog.add("Memento", "Christopher Nolan", "Thriller", 2000);
        catalog.add("Amelie", "Jean-Pierre Jeunet", "Romance", 2001);
        catalog.add("Inception", "Christopher Nolan", "SciFi", 2010);
        catalog.add("The Martian", "Ridley Scott", "SciFi", 2015);
        catalog.add("Oppenheimer", "Christopher Nolan", "Bio" ,2023);
        return catalog;
    }
    private class JustLikesOneGenre implements ILikeFilm {
        private String likedGenre;

        JustLikesOneGenre(String likedGenre) {
            this.likedGenre = likedGenre;
        }

        // Do any of the films the user liked have the given director/genre?
        public boolean isLikedDirector(String director) {

            return false;
        }

        public boolean isLikedGenre(String Genre) {
            return this.likedGenre.equals(Genre);
        }
    }
        @Test
        void getRecommendationsByGenre() {

            String likedGenre = "Romance";

            assertEquals(
                    Set.of(catalog.findByTitle("The Princess Bride"), catalog.findByTitle("Titanic"),
                            catalog.findByTitle("Amelie")),
                    catalog.getRecommendationsByGenre(
                            new JustLikesOneGenre(likedGenre)));
        }
}