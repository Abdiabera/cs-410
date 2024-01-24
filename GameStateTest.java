package cs410.uno;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameStateTest {

    @Test
    void testStartGame() {

        /*Create new Game state with 2 players, 7 initialCard ,
         2 digitisCard, 2 specialCard and 2, 2 WildCard
         */

        GameState gameState = GameState.startGame(2, 7, 2, 2, 2);

        //gamestste is not null
        assertNotNull(gameState);
        //now check no of players
        assertEquals(2, gameState.players.size());
        //check cards in each players hand
        for (Player player : gameState.players) {
            assertEquals(7, player.getHand().size());
        }
        //now check in drawpile the numbers of cards
        int theExpectedDrawPIle = 92 - 1; // Total cards -card to discardPILE
        assertEquals(theExpectedDrawPIle, gameState.getDrawPile().size());
        //now check the numbers of cards on discardpile
        assertEquals(1, gameState.getDisCardPile().size());

    }

    @Test
    void testIsGameOver() {
        //let we create a gamestate with 2 playera and init their hans
        List<Player> players = new ArrayList<>();
        players.add(new Player("player1"));
        players.add(new Player("player2"));
        //players1 hand is empty
        players.get(0).addCardsToHand(new ArrayList<>());
        //players2 hand is empty
        players.get(1).addCardsToHand(new ArrayList<>());
        GameState gameState = new GameState(players, new Deck(1, 1, 1),
                new Deck(0, 0, 0));
        //check if game is over and hand is empty
        assertTrue(gameState.isGameOver());

    }

    @Test
    void runOneTurn() {

        // Create a game state with 3 players, initialize hands, and set a special card on the discard pile
        List<Player> players = new ArrayList<>();
        players.add(new Player("playerA"));
        players.add(new Player("playerB"));
        players.add(new Player("playerC"));
        Deck discardPile = new Deck(0, 0, 0);
        discardPile.add(new Card("red", "3"));
        //this player 1's turn
        players.get(0).addCardsToHand(new ArrayList<>());
        players.get(0).drawCard(new Card("red", "3"));
        players.get(1).drawCard(new Card("red", "5"));
        players.get(2).drawCard(new Card("red", "6"));
        // now setup for intial game
        Deck drawPile = new Deck(2, 1, 1);
        drawPile.add(new Card("blue", "7"));
        // GameState gameState = GameState.startGame(3,0,2,1,1);
        GameState gameState = new GameState(players, drawPile, discardPile);
        gameState.runOneTurn();

        /*gameState.players.get(0).drawCard(new Card("red", "4")); // The top card is "red 3"
        gameState.players.get(1).drawCard(new Card("red", "5")); // PlayerB has a playable card
        gameState.players.get(2).drawCard(new Card("yellow", "7")); // PlayerC has an unplayable card
        gameState.getDisCardPile().add(new Card("red", "3"));
         */

        assertEquals(0, gameState.players.get(0).getHand().size()); // Player 1's hand size after playing
        //gameState.updatePlayerOrder();
        assertEquals(1, gameState.players.get(1).getHand().size()); // Player 2's hand size after drawing
        //gameState.updatePlayerOrder();
        assertEquals(1, gameState.players.get(2).getHand().size()); // Player 3's hand size after drawing
    }

    @Test
    void testHandleSpecialCardEffect() {
        //let we test for skip
        Player playerA = new Player("Player A");
        Player playerB = new Player("Player B");
        Player playerC = new Player("Player C");
        ArrayList<Player> players = new ArrayList<>();
        players.add(playerA);
        players.add(playerB);
        players.add(playerC);

        GameState gameState = new GameState(players,
                new Deck(1, 1, 1), new Deck(0, 0, 0));
        //test for "SKIP"
        gameState.handleSpecialCardEffect(new Card("red", "SKIP"));
        //now the "SKIP" card skip next player turn
        assertEquals(0, gameState.currentPlayerIndex);
        gameState.updatePlayerOrder(); //then move to next player
        assertEquals(2, gameState.currentPlayerIndex);
        //now test for "REVERSE" special card

        gameState.handleSpecialCardEffect(new Card("yellow", "REVERSE"));
        //the "REVERSE" reverses the order of players
        assertEquals(2, gameState.currentPlayerIndex);
        gameState.updatePlayerOrder();//now move to next player
        assertEquals(1, gameState.currentPlayerIndex);
        gameState.updatePlayerOrder();
        //the current player index should be 0 after reversing
        assertEquals(0, gameState.currentPlayerIndex);
        //testing for  the "DRAW TWO"
        gameState.handleSpecialCardEffect(new Card("green", "DRAW TWO"));

        //it must two card for the next player
        gameState.updatePlayerOrder();
        assertEquals(2, playerC.getHand().size());

    }

    @Test
    void testNextPlayer() {
        //let we create with 4 players
        List<Player> players = new ArrayList<>();
        players.add(new Player("playerA"));
        players.add(new Player("playerB"));
        players.add(new Player("playerC"));
        players.add(new Player("playerD"));
        GameState gameState = new GameState(players,
                new Deck(1, 1, 1),
                new Deck(1, 1, 1));

        //this the test for the NextPlayer
        assertEquals("playerB", gameState.getNextPlayer().getName());
        gameState.updatePlayerOrder();// this mean move to next
        //expected playerC
        assertEquals("playerC", gameState.getNextPlayer().getName());

        //now in reverse order testing for NextPlayer
        gameState.handleSpecialCardEffect(new Card("yellow", "REVERSE")); //its reversing order
        gameState.updatePlayerOrder();
        assertEquals("playerD", gameState.getNextPlayer().getName()); // the playerD must next
        gameState.updatePlayerOrder(); //now move to next
        assertEquals("playerC", gameState.getNextPlayer().getName()); //playerC must next

    }

    @Test
    void testRefreshDPIlefromDiscarpile() {
        // create game state
        GameState gameState = new GameState(new ArrayList<>(),
                new Deck(1, 1, 1),
                new Deck(2, 0, 1));

        gameState.getDrawPile().add(new Card("red", "3"));//this is topcard in drawPile
        gameState.getDisCardPile().add(new Card("green", "5")); //topcard in DiscardPile
        gameState.refreshDPileFromDisPile();
        //assert the topcard from discradpile is now in drawpile
        assertEquals("red", gameState.getDrawPile().peekTopCard().getColor());

    }

    @Test
    void testGetDrawPile() {
        Deck drawPile = new Deck(0, 0, 0);
        drawPile.add(new Card("red", "1"));
        drawPile.add(new Card("blue", "2"));
        drawPile.add(new Card("yellow", "3"));

        GameState gameState = new GameState(new ArrayList<>(), drawPile
                , new Deck(0, 0, 0));
        //now let we access drawpile
        Deck retrievedDPile = gameState.getDrawPile();
        //check retrievedDPile null
        assertNotNull(retrievedDPile);

        //now check retrivedDPile contains expected number of cards
        assertEquals(3, gameState.getDrawPile().size());


    }

    @Test
    void testGetDisCardPile() {
        //create a gamesate

        Deck discardpiles = new Deck(0,0,0);
        discardpiles.add(new Card("red", "5"));
        discardpiles.add(new Card("blue", "8"));
        discardpiles.add(new Card("green", "3"));

        GameState gameState = new GameState(new ArrayList<>(), new Deck(0,0,0), discardpiles);

        //now let we access discardPile contian some cards
        Deck retrievedDisCPile= gameState.getDisCardPile();
        //discardpile is not null
        assertNotNull(retrievedDisCPile);
        //check if the reteved discardpile conatins expected cards
        assertEquals(3, gameState.getDisCardPile().size());

    }
}





