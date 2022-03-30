public class Blackjack {
    String[] cards={"ace","two","three","four","five","six","seven","eight","nine","ten","jack","queen","king"};
    int[] value={11,2,3,4,5,6,7,8,9,10,10,10,10};
    public int parseCard(String card) {
        int result=0;
        for(int i=0;i< cards.length;i++){
            if(card.equals(cards[i])){
                result=value[i];
            }
        }
        return result;
        //throw new UnsupportedOperationException("Please implement the Blackjack.parseCard method");
    }

    public boolean isBlackjack(String card1, String card2) {
        if(parseCard(card1)+parseCard(card2)==21)
            return true;
        return false;
        // throw new UnsupportedOperationException("Please implement the Blackjack.isBlackjack method");
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        String result="P";
        if(isBlackjack==true){
            if(dealerScore<10)
                result="W";
            else
                result="S";
        }return result;
        // throw new UnsupportedOperationException("Please implement the Blackjack.largeHand method");
    }

    public String smallHand(int handScore, int dealerScore) {
        String result="H";
        if(handScore>=17)result="S";
        else if(handScore<=11)result="H";
        else if(handScore>11 && handScore<17){
            if(dealerScore>=7)result="H";
            else result="S";
        }
        return result;
        // throw new UnsupportedOperationException("Please implement the Blackjack.smallHand method");
    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }
}
