package blackjack;
import java.util.ArrayList;
import java.util.Arrays;
/*This class will create a hand of card for dealer and player
 * It will deal also get value for both hands
 * @author Anam Ahsan
 * @param Deck
 */
public class Hand {

   ArrayList<RandomCard> hand;//represents the dealer's hand
   public int handvalue = 0;//value of the dealer's hand (starts at 0)
   public RandomCard[] aHand;//used to convert the dealer's hand to an array
   
   //Hand() instantiates a Deck and uses and array and ArrayList to store the cards and values of each card
   Hand(Deck deck){
      hand = new ArrayList<>();
      aHand = new RandomCard[]{};
      
      //Draw two cards for one hand
      for(int i=0; i<2; i++){
          hand.add(deck.drawOne());
      }
      //Gets value of each card
      aHand = hand.toArray(aHand);
      for(int i=0; i<aHand.length; i++){
          handvalue += aHand[i].getValue();
      }   
   }
}
/*@return Instantiates deck to be used in game 
 * 
 */