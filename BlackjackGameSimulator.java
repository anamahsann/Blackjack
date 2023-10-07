package blackjack;
import java.util.Scanner;
import java.util.ArrayList;
/*This program will instantiate a game of blackjack
 * BlackjackGameSimulator will ask the user if they want to play 
 * It will evaluate their choice and ask how much they want to bet
 * It will ask to play another game until the user says indicates no
 * @author Anam Ahsan
 */
public class BlackjackGameSimulator {

	public static void main(String[] args) {
	      
		int bet;        //variable for bet
		String choice;  //variable for user choice
		
		ArrayList<Player> cardList = new ArrayList<>();  //Array to hold instances of games
		
		Scanner theChoice = new Scanner(System.in);
		System.out.println("Would you like to play?");   //Ask user to play game
		choice = theChoice.next();                       //User input of choice
		
	   //Evaluates user choice 
	   switch (choice) {
	     //If yes, will ask user for bet
        case "Yes":
           boolean game = true;
           while(game) {
              Scanner theBet = new Scanner(System.in);
              System.out.println("How much would you like to bet?");
              bet = theBet.nextInt();
              Player player = new Player(bet); //Instantiate new player
              cardList.add(player);            //Add new player to array      

              System.out.println(cardList.get(0) + "\n");  //Print game 
       
              Scanner theGame = new Scanner(System.in);
              //Ask user if they want to play again
              System.out.println("Do you want to play again?");  
              String doOver = theGame.next();
                 //Evaluate user response to start new game 
                 switch (doOver){
                    case "Yes":
                       game = true;
                       break;
                    case "No":
                       game = false;
                       break;
                 }//End of Switch doOver   
           }//End of While
        //If user does not want to play, exit program 
        case "No":
           System.out.print("\nUntil next time!");
           break;
	   }//End of Switch
   }//End Main
}//End Class

/*@return Displays games 
 * 
 */
