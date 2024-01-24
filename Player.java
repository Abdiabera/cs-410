package cs410.uno;

import java.util.ArrayList;
import java.util.List;


public class Player{
    private String name;
    List <Card> hand;

    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<>();
    }
    public String getName(){
        return name;

    }
    public List<Card> getHand(){

        return hand;
    }
    public void drawCard(Card card){
        hand.add(card);

    }
    public Card playCard(Card card ){
        if (hand.contains(card) ){
            hand.remove(card);
            return card;


        }
        return null ; // this is used to handle invalid play

    }
    //additional methods for managing the player's

    //checks if players hand has only card remaining
    public boolean hasUno(){
        return hand.size() == 1;

    }
    //add multple cards to the players hand
    public void addCardsToHand(List <Card> cards){
        hand.addAll(cards);
    }

    public List <Card> findPlayableCards(Card topCard){

        List <Card> playableCards = new ArrayList<>();
        for (Card card : hand){
            if (card.isPlayableOn(topCard)){
                playableCards.add(card);
               //hand.remove(card);
            }
        }
        return playableCards;
    }
}