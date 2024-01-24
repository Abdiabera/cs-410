package cs410.webfilmz;
/*

        Author : Professor Ryan Culpepper

        Student name : Abdi Abera
        Subject: cs410
        Date : 10/12/2023

        */
/*
 *
 * ADD YOUR User TESTS TO THIS FILE
 *
 */

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

 class UserTest {

     @Test
     void yourFirstTestCase() {
         return;
     }


     @Test
     void getRecommendationsNewReleases() {
         Catalog catalog = BaseCatalogTest.getCatalog();

         User alice = new User();
         alice.addWatched(catalog.findByTitle("The Martian"));

         Set<Film> expectedRecommendation =
                 Set.of(
                         catalog.findByTitle("Oppenheimer"),
                         catalog.findByTitle("Inception"));

         Set<Film> actualRecommendation = alice.getAllRecommendations(catalog, 3).get("New Releases");

         assertTrue(actualRecommendation.containsAll(expectedRecommendation));
         assertTrue(expectedRecommendation.containsAll(actualRecommendation));


     }

     @Test
     void getRecommendationsByDirector() {
         Catalog catalog = BaseCatalogTest.getCatalog();
         User alice = new User();

         Film amelie = catalog.findByTitle("Amelie");
         alice.addWatched(amelie);
         alice.addLiked(amelie);

         // this used to create expected recommendation
         Set<Film> expectedRecommendation = new HashSet<>();
         expectedRecommendation.add(catalog.findByTitle("The City of Lost Children"));

         assertEquals(expectedRecommendation, alice.getRecommendationsByDirector(catalog));

     }

     @Test
     void getRecommendationsByGenre() {

         Catalog catalog = BaseCatalogTest.getCatalog();
         User alice = new User();

         Film amelie = catalog.findByTitle("Amelie");
         alice.addWatched(amelie);
         alice.addLiked(amelie);

         // this used to create expected recommendation
         Set<Film> expectedRecommendation = new HashSet<>();
         expectedRecommendation.add(catalog.findByTitle("The Princess Bride"));
         expectedRecommendation.add(catalog.findByTitle("Titanic"));
         assertEquals(expectedRecommendation, alice.getRecommendationsByGenre(catalog));


     }
 }