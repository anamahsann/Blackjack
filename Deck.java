package blackjack;
import java.util.ArrayList;
import java.util.Collections;
/*This class will create a deck
 * It will shuffle the deck
 * It hold method to draw a single card 
 * @author Anam Ahsan
 */
public class Deck {

   private ArrayList<RandomCard> deck;//represents a deck of cards
   
   //Creates a deck of cards 
   Deck() {
      deck = new ArrayList<RandomCard>();
      for(int i=0; i<4; i++){
         for(int j=1; j<=12; j++){
            deck.add(new RandomCard(i,j));
         }        
      }
      //Shuffles deck of cards
      Collections.shuffle(deck);
   }
   //Draws a single card from deck 
   public RandomCard drawOne(){
      return deck.remove(0);
   }
}
/*@return A deck of shuffled cards 
 * 
 */