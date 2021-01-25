import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Application {
    public static void main(String[] args) {


        List<Card> generatedDeck = Card.generateDeck();

        // print out list of 52 cards
        System.out.println(generatedDeck.size());

        Card[] communityCards = new Card[5];
        Card[] p1 = new Card[2];
        Card[] p2 = new Card[2];

        ArrayList<Card> totalCardP1 = new ArrayList<>();
        ArrayList<Card> totalCardP2 = new ArrayList<>();

        for(int i = 0; i< 5; i++) {
            communityCards[i] = generatedDeck.remove(Rng.nextInt(0, generatedDeck.size()-1));
        }

        System.out.println(communityCards.length);

        for(int i = 0; i < 2; i++) {
            p1[i] = generatedDeck.remove(Rng.nextInt(0, generatedDeck.size()-1));
        }

        for(int i = 0; i < 2; i++) {
            p2[i] = generatedDeck.remove(Rng.nextInt(0, generatedDeck.size()-1));
        }

        for(int i = 0; i < 7; i++) {
            if(i <= 4) {
                totalCardP1.add(communityCards[i]);
                totalCardP2.add(communityCards[i]);
            }
            else{
                totalCardP1.add(p1[i - 5]);
                totalCardP2.add(p2[i - 5]);
            }
        }

        // 7 checks out!
        System.out.println(totalCardP1.size());
        System.out.println(totalCardP2.size());


        ArrayList<PokerHand> p1PossibleHands = new ArrayList<>();
        choose5Cards(totalCardP1, 0, new ArrayList<Card>(), p1PossibleHands);

        System.out.println(p1PossibleHands.size());

        ArrayList<PokerHand> p2PossibleHands = new ArrayList<>();
        choose5Cards(totalCardP2, 0, new ArrayList<Card>(), p2PossibleHands);

        System.out.println(p1PossibleHands.size());

        PokerHand p1Best = chooseBestHand(p1PossibleHands);
        PokerHand p2Best = chooseBestHand(p2PossibleHands);


        //define a variable of the TYPE Suit
        //Suit cardSuit = Suit.DIAMONDS;
        //FaceValue cardValue = FaceValue.ACE;

        //we're using the new keyword to "instantiate" a PlayingCard object
        //when we use the new keyword, it calls the constructor method
        //we haven't defined a constructor, so it just calls the automatic default that does nothing
        //we get back a reference to the object (which is on the heap)
        //that reference is what's stored inside of aceOfDiamonds
        //PlayingCard aceOfDiamonds = new PlayingCard();

        //this no longer works now that we have a non-default constructor, the default goes away
        //now we have to instantiate with the data already provided
        //the advantage is that it is impossible to build a playing card object
        //without supplying all the of information necessary to describe the card
        //Card aceOfDiamonds = new Card( FaceValue.ACE, cardSuit );

        //so now we can call non-static methods
        //NOT on PlayingCard, but instead on aceOfDiamonds
        //aceOfDiamonds.setCardValue( FaceValue.ACE );
        //aceOfDiamonds.setCardSuit( Suit.DIAMONDS );

        //System.out.println( aceOfDiamonds.getCardValue() );
        //System.out.println( aceOfDiamonds.getCardSuit() );

        //this doesn't work because these methods are not static:
//        PlayingCard.setCardValue( FaceValue.ACE );
//        PlayingCard.setCardSuit( Suit.DIAMONDS );


        //                   straight flush vs 4 of a kind
        //                   2D  3D 4D 5D  6D  7S  7D  7C  7H  8S
        //int[] bothHands = { 1, 5, 9, 13, 17, 20, 21, 22, 23, 24  };
        int [] bothHands = {28, 44, 40, 36, 32, 29,45,41,37,33};
        Card[] hand1Cards = new Card[5];
        Card[] hand2Cards = new Card[5];

        for( int i = 0; i < bothHands.length; i++ ){
            if( i < 5 ){
                hand1Cards[i] = new Card(bothHands[i]);
            } else {
                hand2Cards[i-5] = new Card(bothHands[i]);
            }
        }

        PokerHand hand1 = new PokerHand(hand1Cards);
        PokerHand hand2 = new PokerHand(hand2Cards);

        //test suit and face value counts
        Map<FaceValue,Integer> valueCountsH1 = p1Best.countFaceValues();
        Map<FaceValue,Integer> valueCountsH2 = p2Best.countFaceValues();

        Map<Suit, Integer> suitCountsH1 = p1Best.countSuits();
        Map<Suit, Integer> suitCountsH2 = p2Best.countSuits();

        System.out.println("Player 1: \n");
        for( FaceValue key : valueCountsH1.keySet() ){
            System.out.println( key + ": " + valueCountsH1.get(key) );
        }

        for( Suit key : suitCountsH1.keySet() ){
            System.out.println( key + ": " + suitCountsH1.get(key) );
        }

        System.out.println("\nPlayer 2: \n");
        for( FaceValue key : valueCountsH2.keySet() ){
            System.out.println( key + ": " + valueCountsH2.get(key) );
        }

        for( Suit key : suitCountsH2.keySet() ){
            System.out.println( key + ": " + suitCountsH2.get(key) );
        }


        int hand1WinsResult = p1Best.compareTo(p2Best);

        if( hand1WinsResult < 0 ){
            //should see this
            System.out.println("player 1 wins");
        } else if( hand1WinsResult > 0 ){
            System.out.println( "player 2 wins");
        } else {
            System.out.println("tie!");
        }

    }

    //player one's cards are 0-4
    //player two's cards are 5-9
    public static boolean playerOneWins( int[] bothHands ){
        Card[] hand1Cards = new Card[5];
        Card[] hand2Cards = new Card[5];

        for( int i = 0; i < bothHands.length; i++ ){
            if( i < 5 ){
                hand1Cards[i] = new Card(bothHands[i]);
            } else {
                hand2Cards[i-5] = new Card(bothHands[i]);
            }
        }

        PokerHand hand1 = new PokerHand(hand1Cards);
        PokerHand hand2 = new PokerHand(hand2Cards);
        throw new UnsupportedOperationException();
    }

    //generates an array of size 10 representing 2 hands of poker
    //the values are 0-51
    //the suit is value%4            (0-spades, 1-diamonds, 2-clubs, 3-hearts)
    //the card is value/4 + 2       J = 11, Q = 12, K = 13, A = 14
    public static int[] generatePokerHands(){
        int [] cards = new int[10];
        for( int i = 0; i < 10; i++ ){
            int card = Integer.MIN_VALUE;

            while( card == Integer.MIN_VALUE ){
                card = Rng.nextInt(0,51);
                for( int j = 0; j < i; j++ ){
                    if( cards[j] == card ) card = Integer.MIN_VALUE;
                }

            }
            cards[i] = card;
        }

        Arrays.sort(cards, 0, 4);
        Arrays.sort(cards, 5, 9);

        return cards;
    }


    public static void choose5Cards(ArrayList<Card> possible, int nextIndex,
                                    ArrayList<Card> currentlySelected, ArrayList<PokerHand> allHands)  {

        int numChosenCards = currentlySelected.size();
        int numRemainingCards = 5 - numChosenCards;
        int amountAvailbleCards = possible.size() - nextIndex;

        if(currentlySelected.size() == 5) {
            ArrayList<Card> copy = new ArrayList<>();
            for(Card selected: currentlySelected){
                copy.add(selected);
            }
            allHands.add(new PokerHand(copy.toArray(new Card[5])));
            //currentlySelected.clear();
            return;
        }

        if(amountAvailbleCards < numRemainingCards) {
            return;
        }

        currentlySelected.add(possible.get(nextIndex));

        choose5Cards(possible, nextIndex + 1, currentlySelected, allHands);

        currentlySelected.remove(currentlySelected.size()-1);

        choose5Cards(possible, nextIndex + 1, currentlySelected, allHands);

    }

    public static PokerHand chooseBestHand(List<PokerHand> allHands) {

        // out of the possible 21 combos, find the best and worst from p1 and p2's hands

        while(allHands.size() > 1) {
            int score = allHands.get(0).compareTo(allHands.get(1));

            if(score < 0) {
                allHands.remove(1);
            }
            else{
                allHands.remove(0);
            }
        }
        return allHands.get(0);
    }

    public static List<Card> generateAllPossibleBestHands(Card[] communityCards, List<Card> deck) {


        List<PokerHand> allPossibleHands = new ArrayList<>();
        for(int i = 0; i < deck.size(); i++) {
            for(int j = i + 1; i < deck.size(); i++) {

                List<Card> newCards = new ArrayList<>();
                newCards.add(deck.get(i));
                newCards.add(deck.get(j));

                for(Card card: communityCards) {
                    newCards.add(card);
                }
                ArrayList<Card> newPossibleHands = new ArrayList<>();
                choose5Cards(newCards, 0, new ArrayList<>(), newPossibleHands);
            }

        }
    }

}
