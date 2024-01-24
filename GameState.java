package cs410.uno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameState {

    List<Player> players;
   private Deck drawPile;
     private Deck disCardPile;
    int currentPlayerIndex;
    private boolean reverseOrder;
    private boolean skipNextplayer;

    //Constructor to initilize
   public GameState(List<Player> players, Deck drawPile, Deck disCardPile) {
        this.players = players;
        this.drawPile = drawPile;
        this.disCardPile = disCardPile;
        this.currentPlayerIndex = 0;
        this.reverseOrder = false;
        this.skipNextplayer = false;

    }

    //this place is facotory method to start new game

    public static GameState startGame(int countPlayers,
                                      int countInitialCardsPerPlayer,
                                      int countDigitCardsPerColor,
                                      int countSpecialCardsPerColor,
                                      int countWildCards) {
        List<Player> players = new ArrayList<>();
        Deck drawPile = new Deck(countDigitCardsPerColor,
                countSpecialCardsPerColor, countWildCards);

        Deck disCardPile = new Deck(0, 0, 0);

        //we have to initialize and deal with intial hands

        for (int i = 0; i < countPlayers; i++) {

            Player player = new Player("Player" + (i + 1));
            List<Card> initialHand = drawPile.drawCards(countInitialCardsPerPlayer);
            player.addCardsToHand(initialHand);
            players.add(player);
        }
        Card initCard = drawPile.draw();
        disCardPile.add(initCard);

        // now create and return to newgame state

        return new GameState(players, drawPile, disCardPile);


    }
    // then check if the game is over by checking if the player hand is empty

    public boolean isGameOver (){
        for (Player player : players){

            if (player.getHand().isEmpty()){
                return true;
            }
        }
        return false;
    }

    // this is RunOneTurn game ,  handling special card effect
    public void runOneTurn (){
       if(isGameOver()){
           return;
       }
        Player currentPlayer = players.get(currentPlayerIndex);
        Card topCard = disCardPile.peekTopCard();
        List <Card>  playableCards = currentPlayer.findPlayableCards(topCard);
       // List <Card> inhandCardofPlayer =  currentPlayer.getHand();

        if (!playableCards.isEmpty()){
        //if (playableCards != null){
            //we have to choose card
            Card playedCard = currentPlayer.playCard(playableCards.get(0));
            disCardPile.add(playedCard);
            //currentPlayer.getHand().remove(playedCard);
           //inhandCardofPlayer.remove(playedCard);
            handleSpecialCardEffect(playedCard);
            currentPlayer.hand.remove(playedCard);
        }
        else {

            Card drawnCard = drawPile.draw();
            currentPlayer.drawCard(drawnCard);

            if (drawnCard.isPlayableOn(topCard)){
                Card playedCard = currentPlayer.playCard(drawnCard);
                disCardPile.add(playedCard);
                handleSpecialCardEffect(playedCard);
                currentPlayer.hand.remove(playedCard);
            }
            else {
                // now if it remains in the players hand, the drawn card is not playable
                System.out.println(("There is not playable card, so it remains in your hand!"));
            }
        }

        // this move the next player in a circle
        updatePlayerOrder();

    }

    // This place is to handle special card effect for example Skip, Reverse,  and Draw Two
    // based on played card

    public void handleSpecialCardEffect(Card card){

       if (card.isSpecialCard()){
           switch (card.getValue()){

               case "SKIP":
                   skipNextplayer = true;
                   break;
               case "REVERSE":

                   reverseOrder =! reverseOrder;
                   break;
               case "DRAW TWO":
                   Player nextPlayer = getNextPlayer();
                   List<Card> drawnCards = drawPile.drawCards(2);
                   nextPlayer.addCardsToHand(drawnCards);
                   currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
                   break;
           }
       }

        /*if (card.isSpecialCard()){
            if (card.getValue().equals("SKIP")){
                skipNextplayer = true;

            }
            else if ( card.getValue().equals("REVERSE")){
                reverseOrder = !reverseOrder;

            } else if (card.getValue().equals("DRAW TWO")) {
                // Then Impelemtn Draw Two effect by drawing two cards for the next player
                Player nextPlayer  = getNextPlayer();
                List <Card> drawnCards = drawPile.drawCards(2);
                nextPlayer.addCardsToHand(drawnCards);
                // current player index  to the next index in player circular, by wrapping around to 0 this is if it reach the end
                currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
               // skipNextplayer = true;
            }
        }

         */
    }
    // Then get the next player
   public Player getNextPlayer(){
        int nextPlayerIndex ;
        if (reverseOrder){
            nextPlayerIndex = (currentPlayerIndex - 1 +  players.size()) % players.size();

        }
        else {
            nextPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
        return  players.get(nextPlayerIndex);
    }
    // then we have to update players orders based on skip and reveres effect
    void updatePlayerOrder(){


       if (skipNextplayer){
           skipNextplayer = false;
           currentPlayerIndex = (currentPlayerIndex + 2) % players.size();
           return;

       }
       /*Updating the currentplayerindex
       it checks the vlue of reverseorder then if its true it decrement
       unless increments number of players
        */
       currentPlayerIndex = reverseOrder ? ( currentPlayerIndex - 1 + players.size())%players.size()
               : (currentPlayerIndex +1) % players.size();
       /* if (skipNextplayer){
            skipNextplayer = false;
            return;
        }
        if (reverseOrder){
            currentPlayerIndex = (currentPlayerIndex - 1 + players.size()) % players.size();

        }
        else {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }*/
    }
    // we have to refresh the drawpile from discardpile if its empyt
    public void refreshDPileFromDisPile(){
        if (drawPile.isEmpty()){
            //this gets top card of discardpile
            Card topDiscard = disCardPile.peekTopCard();
            disCardPile.clear();//clear
            disCardPile.shuffle();//shuffle discarded cards
            drawPile.add(topDiscard); // this used to add topcard to the new drawpile
        }
    }
    public  Deck getDrawPile(){

       return drawPile;
    }
    public  Deck getDisCardPile(){

       return disCardPile;
    }

    }

