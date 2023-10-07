package blackjack;
/*This class will create the cards in a deck
 * It will deal also assign value to the cards
 * @author Anam Ahsan
 * @param n, to get rank from array
 * @param s, to get suit from array
 */
public class RandomCard {
   
   private int num;
   private int suit;
   private int value;
   
   //Array for each rank and suit
   String [] nums = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
   String [] suits =  {"Hearts","Diamonds", "Clovers", "Spades"};
   
   //Assigning each suit to a rank
   public RandomCard (int n, int s) {
      this.num = s;
      this.suit = n;
      }
   
   //Return a single card with suit and rank
   public String toString() {
      return nums[num] + " of " + suits[suit];
   }
   
   //Gets value for each rank and suit
   public int getValue() {
      if (num <=8) {
         value = num + 2;
      }
      else if (num > 8 && num < 12) {
         value = 10;
      }
      else if (num == 12) {
         value = 11;
      }
      return value;   
   }
   
   //Sets value 
   public void setValue(int set) {
      value = set;
   }
}
/*@return Created card with suit and rank  
 * 
 */