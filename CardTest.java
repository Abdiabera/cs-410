package cs410.uno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void testGetColor() {

        //now create a card with a known clor and value

        Card card = new Card("red" , "5");


        //this checks if getColor() method return a correct color

        assertEquals( "red" , card.getColor());

    }

    @Test
    void testGetValue() {

        //this used to create a card with known clor and vlaue

        Card card = new Card("yellow", "Skip");

        //this checks getValue() and returns

        assertEquals("Skip", card.getValue());

    }

    @Test
    void testToString() {
        // this create card

        Card card = new Card("green", "Wild");
        //checking if the toString returns an expected string

        assertEquals("green Wild", card.toString());
    }

    @Test
    void testIsPlayableOn() {
        // now create card  color and value
        Card card = new Card("blue", "8");

        //create topCard

        Card topCard =  new Card("blue", "5");

        //check ISPlayable()
        assertTrue(card.isPlayableOn(topCard));



    }

    @Test
    void testIsWildCard() {

        //create WildCard
        Card wildCard = new Card("WILD", " DRAW Four");

        //checks if wildcard() method is correctly identifies

        assertTrue(wildCard.isWildCard());



    }

    @Test
    void testIsSpecialCard() {

        //let we create special card
        Card specialCards = new Card("red", "Skip");

        //check spcialcard

        assertFalse(specialCards.isSpecialCard());

    }

    @Test
    void setEffectiveColor() {

        //create wild card

        Card wildCard = new Card("WILD", "Wild");

        //set an effective color for the wild color

        wildCard.setEffectiveColor("blue");

        //check correctly set

        assertEquals("blue" , wildCard.getColor());


    }
}