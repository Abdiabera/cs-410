package cs410.uno;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.awt.Color.yellow;


public class Deck {

    //this is pur special
    public static final String SKIP = "Skip";
    public static final String REVERSE = "Reverse";

    public static final String DRAW_TWO = "Draw Two";

    private List <Card> cards;

    public Deck(int countDigitCardsPerColor,
                int countSpecialCardsPerColor,int countWildCards){

        cards = new ArrayList<>();
        initializedDeck( countDigitCardsPerColor, countSpecialCardsPerColor, countWildCards);

        shuffle();
    }
    public Card draw(){
        //if card is not empty
        if (!cards.isEmpty()){
            return cards.remove(cards.size() - 1);
        }

        return null ; //there is no card in deck
    }
    // this used to draw specific number of card from deck and returns
    public List<Card> drawCards(int count){
        List<Card> drawnCards = new ArrayList<>();
        for (int i = 0 ; i < count; i++){
            Card card = draw();
            if (card != null){
                drawnCards.add(card);

            }
        }
        return drawnCards;

    }
    public boolean isEmpty(){

        return cards.isEmpty();
    }
    /*this place used to create and initialize deck. taking
    the parameters to determine the number of cards and special cards and wild cards color in the deck
     */
    private void initializedDeck(int countDigitCardsPerColor, int countSpecialCardsPerColor,int countWildCards){
        String[] colors = {"red", "yellow", "green" , "blue"};
        String[] values = { "0","1","2","3","4","5","6","7","8","9",
                "SKIP","REVERSE","DRAW TWO"};
        for (String color : colors){
            for (String value : values){
                //add the specified number of digits and special cards per color
                int count = value.matches("\\d") ? countDigitCardsPerColor :countSpecialCardsPerColor;
                for (int i = 0 ; i<count; i++){
                    if (!color.equals("WILD")){
                    cards.add(new Card(color,value));

                }
            }
            }
        }
        //add the specified number of wild cards
        for (int i = 0; i<countWildCards; i++){
            cards.add(new Card("WILD", "Wild"));
        }
    }

    public void shuffle(){

        Collections.shuffle(cards);
    }
    public  void add(Card card){
        cards.add(card);
    }
    // this used to retrive top card from the deck
    public Card peekTopCard(){

        if (!cards.isEmpty()){
            return cards.get(cards.size() - 1);
        }
        return  null;
    }
    //This remove all cards from deck
    public void clear(){
        cards.clear();
    }
    public int size(){
        return  cards.size();
    }

    }
