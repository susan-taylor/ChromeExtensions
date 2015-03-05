import java.util.*;

public class Blackjack {

	public static void main(String[] args)
	{
		System.out.print("+----------------------------------------------------------------------------+\n"
                + "|Application Name: Blackjack Game                                             |\n" 
                + "|Class Name:       Blackjack.java                                             |\n"
                + "|Author/Creator:   Susan Taylor                                               |\n" 
                + "|Description:      A program that lets the user play a variation of Blackjack |\n"
                + "|                  against the computer. In this version, two six-sided die   |\n"
                + "|                  are used instead of cards. The statistics are displayed    |\n"
                + "|                  when the user chooses to exit.                             |\n"
                + "+-----------------------------------------------------------------------------+\n\n\n");
		
		//Declare variables
		int die1, die2;
		final int MAX_SCORE = 21;
		int userScore = 0, pcScore = 0; //each dice roll score
		int userTotal = 0, pcTotal = 0; //running total
		int userWins= 0, userLosses = 0; //statistics for user
		int pcWins = 0, pcLosses = 0; //statistics for PC
		int gamesPlayed = 0; //number of games played
		String decision = "y";
		String answer = "";
		String yes = "y";
		String no  = "n";
		
		//Create Scanner object
		Scanner input = new Scanner(System.in);
		
		//Create Random object
		Random generator = new Random();
		
		//While loop, executes if conditions are met
		while(decision.equalsIgnoreCase(yes) && userTotal <= MAX_SCORE)
		{
			die1 = generator.nextInt(6) + 1;
			die2 = generator.nextInt(6) + 1;
			pcScore = die1 + die2;
			
			//Read input from user
			System.out.print("Player 1, would you like to roll the dice? (Y/N): ");
			answer = input.next();
			System.out.println();
			
			//Executes if user enters 'y'
			if(answer.equalsIgnoreCase(yes))
				{						
					die1 = generator.nextInt(6) + 1;
					die2 = generator.nextInt(6) + 1;
					userScore = die1 + die2;
				
					//Displays user's roll to user
					System.out.println("You rolled " + userScore + ".");
				
					//userTotal and pcTotal store a running total
					userTotal += userScore;
					pcTotal += pcScore;
				
					//Displays user's current total
					System.out.println("Your current total is " + userTotal + ".\n");
				}
		
			//Executes when user does not choose to roll the die again
			//or if the user's total exceeds 21
			if(answer.equalsIgnoreCase(no) || userTotal > MAX_SCORE)
			{
				gamesPlayed++;
				System.out.println("ROUND " + gamesPlayed + " RESULTS");
				System.out.println("Player 1's total = " + userTotal);
				System.out.println("Computer's total = " + pcTotal + "\n");

				//Calculates the winner of the round
				if(pcTotal > 0 && userTotal > 0)
				{
					if(pcTotal <= 21 && userTotal <= 21)
					{
						if(pcTotal > userTotal)
						{
							pcWins++;
							userLosses++;
						}
						else if(pcTotal < userTotal)
							{
							userWins++;
							pcLosses++;
							}
						else
						{
							pcWins++;
							userLosses++;
						}
					}
					if(pcTotal > 21 || userTotal > 21)
					{
						if(userTotal <= 21 && pcTotal > 21)
						{
							userWins++;
							pcLosses++;
						}
						else if(pcTotal <= 21 && userTotal > 21)
						{
							pcWins++;
							userLosses++;
						}
						else if(pcTotal > 21 && userTotal > 21)
							{
								userLosses++;
								pcLosses++;
							}
					}
				}
				else
				{}
							
				//Asks user if they wish to continue playing at the end of each round
				System.out.print("Would you like to keep on playing? (Y/N): ");
				decision = input.next();
				System.out.println();
				
				//If user enters 'y' to keep playing, the totals reset so the loop can repeat
				if(decision.equalsIgnoreCase(yes))
					{
						userTotal = 0;
						pcTotal = 0;
					}
			}	
		}
		
		//Close program if user selects option to quit
		if(answer.equalsIgnoreCase(no) || decision.equalsIgnoreCase(no))
		{
			//Displays the statistics of the game
			System.out.println("\t Total Games Played: " + gamesPlayed + "\n"
					 + "Computer Wins: \t" + pcWins + "\t"
					 + "Computer Losses: " + pcLosses + "\n"
					 + "Player 1 Wins: \t" + userWins + "\t"
					 + "Player 1 Losses: " + userLosses);
			input.close();
		}
		else
			decision = "y";
		}
}
