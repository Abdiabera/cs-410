package cs410.uno;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void testDraw() {

        //ccreate deck
        Deck deck = new Deck(1,1,1);
        Card card = new Card("red" , "0");
        deck.add(card);

        //check
        assertEquals(card , deck.draw());
    }

    @Test
    void testDrawCards() {

        Deck deck = new Deck(1,1,1);
        Card cardb = new Card("red", "0");
        Card cardc = new Card("yellow", "1");
        deck.add(cardb);
        deck.add(cardc);

        assertEquals(2, deck.drawCards(2).size());
    }

    @Test
    void testIsEmpty() {

        Deck emptyDec = new Deck(0,0,0);
        Deck nonEmpty = new Deck(1,1,1);

        assertTrue(emptyDec.isEmpty());
        assertFalse(nonEmpty.isEmpty());


    }

    @Test
    void testShuffle() {

        Deck deck = new Deck(1,1,1);

        Card cardb = new Card("red", "0");
        Card cardc = new Card("yellow", "1");
        deck.add(cardb);
        deck.add(cardc);

        Deck theSHufleddeck = new Deck(1,1,1);
        theSHufleddeck.add(cardb);
        theSHufleddeck.add(cardc);

        deck.shuffle();
        assertFalse(deck.draw().equals(theSHufleddeck.draw()));
    }

    @Test
    void testAdd() {

        Deck deck = new Deck(1,1,1);

        Card card = new Card("red" , "0");

        deck.add(card);
        assertFalse(deck.isEmpty());
    }

    @Test
    void testPeekTopCard() {

        Deck deck = new Deck(1,1,1);
        Card card = new Card("red", "0");
        deck.add(card);

        assertEquals(card , deck.peekTopCard());
    }

    @Test
    void testClear() {

        Deck deck = new Deck(1,1,1);

        Card card = new Card("red" , "0");
        deck.add(card);
        assertFalse(deck.isEmpty());
        deck.clear();
        assertTrue(deck.isEmpty());
    }
    @Test
    void testSize(){
        Deck deck = new Deck(3,3,3);
        int initSize = deck.size();
        assertEquals(initSize, deck.size());
        //now simulate drawing card
        deck.draw();
        assertEquals(initSize -1, deck.size());
        //now clear the deck
        deck.clear();
        assertEquals(0, deck.size());



    }

}