package blackjack;
import java.util.Scanner;
/*This class will get/set the bets to use in game
 * It will deal a hand to both dealer and player
 * It will run one entire game and evaluate winner and loser
 * It will end loop once game has ended
 * @author Anam Ahsan
 * @param bet is the bet placed by the player 
 */
public class Player {
   public int bet;         //private variable to evaluate bet
   static int money = 10; //User money that they are playing with
   static int newBet = 0; //User bet for each game 
   public Player(int bet){
      setBet(bet);      
   }

   //Get Bet
   public int getBet() {
      return this.bet;
   }

   //Determine if bet is valid input and then assign to private variable and static variable to be used in game
   public void setBet(int bet) {
      if (bet <= money) {
         this.bet = bet;
         newBet = bet;
      }
      else {
         System.out.println("Error! You can't afford to play!");
         this.bet = 0;
         System.exit(0);
      }
   }
      
   //Runs one whole game of blackjack with user and dealer 
   public String toString() {
      String str = "";
      Deck deck = new Deck(); //Creates Deck of Card
      Hand player = new Hand(deck);  //Deals a hand to player from same deck
      Hand dealer = new Hand(deck); //Deals a hand to dealer from same deck
      
      //Displays player's hand and half of dealer's hand
      System.out.println("Player has: " + player.hand + " This equals to: " + player.handvalue);
      System.out.println("Dealer has: " + dealer.aHand[0]);
      boolean playing = true; //True while one game being played
      
      //Executes round of game, evaluating player hand to ask whether player wants to Hit or Stay  
      while (playing) {
         
         if (player.handvalue == 21) {
            money += newBet;
            System.out.println("You Win! You now have: $" + money);
            playing = false;
         }
      
         if (player.handvalue > 21) {
            money -= newBet;
            System.out.println("You Lose! You now have: $" + money);
            playing = false;
         }
      
         //Ask player it they want to hit or stay 
         if (player.handvalue < 21) {
            Scanner theHit = new Scanner(System.in);
            System.out.println("Do you want to hit or stay? ");
            String option = theHit.next();
         
            //Evaluates player option 
            switch(option) {
            //Draws player another card and ask if they want another hit and evaluates if they have won or lost bet
            case "H":
               int m = 1;
               m++;
               player.hand.add(deck.drawOne());
               player.aHand = player.hand.toArray(player.aHand);
               player.handvalue += player.aHand[m].getValue();
            
               System.out.println("Player has: " + player.hand + " This equals to: " + player.handvalue);
            
               if(player.handvalue == 21) {
                  money += newBet;
                  System.out.println("You Win! You now have: $" + money);
                  playing = false;
               }
               else if(player.handvalue > 21) {
                  money -= newBet;
                  System.out.println("You Lose! You now have: $" + money);
                  playing = false;
               }
               else if(player.handvalue < 21) {
                  playing = true;
               }
               break;
         
            //Displays dealer's hand and draws card until points over 17 and evaluates if player has won or lost bet    
            case "S":

               System.out.println("Dealer has: " + dealer.hand + " This equals to: " + dealer.handvalue);          
            
               if(dealer.handvalue == 21) {
                  money -= newBet;
                  System.out.println("You Lose! You now have: $" + money);
                  playing = false;
               }
            
               else if(dealer.handvalue > 21) {
                  money += newBet;
                  System.out.println("You Win! You now have: $" + money);
                  playing = false;
               }
            
               else if(dealer.handvalue < 17) {
                  dealer.hand.add(deck.drawOne());
                  dealer.aHand = dealer.hand.toArray(dealer.aHand);
                  dealer.handvalue += dealer.aHand[2].getValue();
                  System.out.println("Dealer has: " + dealer.hand + "This equals to: " + dealer.handvalue);
               
                  if(dealer.handvalue > 21) {
                     money += newBet;
                     System.out.println("You Win! You now have: $" + money);
                     playing = false;
                  }
                  else if(dealer.handvalue == 21) {
                     money -= newBet;
                     System.out.println("You Lose! You now have: $" + money);
                     playing = false;
                  }
                  else if(dealer.handvalue < 21) {
                     if(dealer.handvalue < player.handvalue) {
                        money += newBet;
                        System.out.println("You Win! You now have: $" + money);
                        playing = false;
                     }
                     else {
                        money -= newBet;
                        System.out.println("You Lose! You now have: $" + money);
                        playing = false;
                     }
                  }                  
               }           
            
            else if(dealer.handvalue < 21) {
               if(dealer.handvalue < player.handvalue) {
                  money += newBet;
                  System.out.println("You Win! You now have: $" + money);
                  playing = false;
               }
               else {
                  money -= newBet;
                  System.out.println("You Lose! You now have: $" + money);
                  playing = false;
               }
            }            
            break;
         }//End Switch()
      }//End of If-statement
   }//End of While Statement       
   return str;
}
}
/*@return Runs games and evaluates outcomes, total money - bet
 * 
 */
