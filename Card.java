package cs410.uno;

public class Card{
    private String color;
    private String value;


    //constructor for normal card
    public  Card( String color , String value) {
        if (isValidColor(color) || color.equals("WILD")) {
        this.color = color;
        this.value = value;
    }
    else{
        throw new IllegalArgumentException("invalid color" + color);
        }
    }
    public String getColor(){
        return color;
    }
    public String getValue(){
        return value;
    }

    @Override
    public String toString(){

        if (isWildCard()){

        }
        return color + " " + value;

        //return isWildCard() ? "Wild" : color + " " + value;
    }

    public boolean isPlayableOn(Card topCard) {
        if (isWildCard()) {
            //wild is always playable
            return true;
        }

        if (topCard.isWildCard()) {
            // if top card is a wild,then treat it as the declared color

            return color.equals(topCard.getValue()) || value.equals(topCard.getValue());

        }
        else {
            return  color.equals(topCard.getColor()) || value.equals(topCard.getValue());
        }

    }

    //


    public boolean isWildCard(){
        return "WILD".equals(color);
        //return color != null && color.equals("WILD");
    }
    public boolean isSpecialCard(){
        return value.equals("SKIP") || value.equals("REVERSE") || value.equals("DRAW TWO");

    }
    // we have to set effective color for wild card
    public void setEffectiveColor (String newColor){
        //set the effective color of wild card
        if (isWildCard()){
            color = newColor;
        }
    }
//validate if the color is valid red, yellow , green or blue
private  boolean isValidColor(String color){
        return color.equalsIgnoreCase("red") ||
                color.equalsIgnoreCase("yellow")
                || color.equalsIgnoreCase("green")
                || color.equalsIgnoreCase("blue");
}

}
