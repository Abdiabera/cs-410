package cs410.uno;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {



    @Test
    void testGetName() {

        // we have to crate player abdi
        Player player = new Player("Abdi");

        // we have to create a lsit of cards to add the players hand

        assertEquals("Abdi", player.getName());
    }


    @Test
    void testGetHand() {

        Player player = new Player("Bob");

        // we have to make sure that the players hand isnot null

        assertNotNull(player.getHand());

        assertEquals(0, player.getHand().size());
    }

    @Test
    void testDrawCard() {

        // create player


        Player player = new Player("Charlie");
        // create card to be drawn

        Card card = new Card("red" , "5");

        //add card to players hand


        player.drawCard(card);

        //check if players hand contain drawncard

        assertTrue(player.getHand().contains(card));

    }

    @Test
    void testPlayCard() {

        //create player

        Player player = new Player("David");

        //create card to be played

        Card card = new Card("green", "7");

        // now draw the card
        player.drawCard(card);

        //check if if its removed from the hnd

        Card playedCard = player.playCard(card);

        assertNotNull(playedCard);
        assertEquals(card, playedCard);
        assertFalse(player.getHand().contains(card));

        //
        Card invalidC = new Card("blue" , "2");
        Card notInHandPlayer = player.playCard(invalidC);
        assertNull(notInHandPlayer);
    }

    @Test
    void testHasUno() {
        //create new player

        Player player = new Player("Eve");

        // the player must not have Uno
        assertFalse(player.hasUno());


        //add cards

        player.drawCard(new Card("yellow" , "3"));

        assertTrue(player.hasUno());
        //again add more and see the status

        player.drawCard(new Card("blue" , "9"));

        assertFalse(player.hasUno());
        }

    @Test
    void testAddCardsToHand() {

    Player player = new Player("Frank");


        List<Card> cardsTo = new ArrayList<>();

        cardsTo.add(new Card("green", "2"));
        cardsTo.add(new Card("red", "Skip"));

        //again add card to players hand

        player.addCardsToHand(cardsTo);
        assertEquals(cardsTo.size(), player.getHand().size());

        for (Card card : cardsTo) {

            assertTrue(player.getHand().contains(card));
        }
    }

    @Test
    void testFindPlayableCards() {

        // let we create player


        Player player = new Player("Grace");

        //create topcard
        Card topCard = new Card("red" , "3");

        //Now let we create lsit of cards should be played

        List<Card> playableCard = new ArrayList<>();
        playableCard.add(new Card("red", "5"));
        playableCard.add(new Card("green", "3"));
        playableCard.add(new Card("blue", "3"));
        //Now let we create lsit of cards should not be played

        List<Card> nonPlayableCards = new ArrayList<>();
        nonPlayableCards.add(new Card("yellow", "7"));
        nonPlayableCards.add(new Card("green", "Skip"));
        player.addCardsToHand(playableCard);
        player.addCardsToHand(nonPlayableCards);
        // Find and check playable cards

        List<Card> foundPLayableC = player.findPlayableCards(topCard);

        // now assert only playable

        assertEquals(playableCard.size(), foundPLayableC.size());
        for (Card card : playableCard){

            assertTrue(foundPLayableC.contains(card));

        }
    }
}