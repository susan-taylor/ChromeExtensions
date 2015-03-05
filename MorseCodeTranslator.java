import java.util.*;

public class MorseCode {

	public static void main(String[] args)
	{
		  System.out.print("+----------------------------------------------------------------------------+\n"
	                + "|Application Name: Morse Code Translator                                     |\n" 
	                + "|Class Name:       MorseCode.java                                            |\n"
	                + "|Author/Creator:   Susan Taylor                                              |\n" 
	                + "|Description:      A program that reads an English language phrase and       |\n"
	                + "|                  encodes the phrase into Morse code. Or reads a phrase in  |\n"
	                + "|                  Morse code and converts the phrase into English.          |\n"
	                + "+----------------------------------------------------------------------------+\n\n");
	
		  //Create Scanner object
		  Scanner input = new Scanner(System.in);
	
		  //Declare variables
		  String userResponse = "";
		  String english = "English";
		  String morse = "Morse-Code";
		  String morseChars = "";
		  String morseMultiWords = "";
		  String morseWords = "";
		  String phrase = "";
		  String answer = "";
		  int loop = 0;
		  
		  //Initiate arrays
		  final String[] englishArray = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
		 						   "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
		 						   "Y", "Z", " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
			 
		  final String[] morseArray = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
		 				    	 ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
		 				    	 "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", " ", 
		 				    	 ".----", "..---", "...--", "....-", ".....", "-....", "--...", 
		 				    	 "---..", "----.", "-----"};
	
		  //while loop - This loops as long as the user wishes to enter phrases
		  while(loop == 0)
		  {
			  //Requests and reads user input
			  System.out.print("\nWould you like to enter a phrase in English or in Morse-code? ");
			  userResponse = input.next();	
		      
			  //Ensures user enters valid response
			  while(!(userResponse.equalsIgnoreCase(english) || userResponse.equalsIgnoreCase(morse)))
			  {
				  System.out.println("\nInvalid response. \nPlease enter 'English' or 'Morse-code'.\n");
				  System.out.print("Would you like to enter a phrase in English or in Morse-code? ");
				  userResponse = input.next();
			  }
		      //if-statement executes if users inputs 'English'
			  if(userResponse.equalsIgnoreCase(english))
			  {
				  
				  //Requests and reads user input
				  System.out.print("\nPlease enter your English phrase: ");
				  input.nextLine();
				  phrase = input.nextLine();
				  phrase = phrase.toUpperCase();

				  //Ensures user do not enter anything other than a-z and 0-9					  
				  while((phrase.matches(".*[\\p{Punct}].*")))
				  {
					  System.out.print("\nInvalid response.");
					  System.out.print("\nPlease enter your English phrase: ");
					  phrase = input.nextLine();
					  phrase = phrase.toUpperCase();
				  }
					  
				  //Reads input
				  System.out.println("\nYou entered: " + phrase);
				  System.out.print("In morse code, this is: ");
				  
				  //Nested for-loop that does the English-to-Morse translation
				  for(int count = 0; count < phrase.length(); count++ )
				  {
					  for(int index = 0; index < englishArray.length; index++) 
					  {
						  if(phrase.substring(count, (count+1)).equals(englishArray[index]))
							  System.out.print(morseArray[index] + " "); 
					  } 
				  } 
			  }
			  //Else-if statement executes if user inputs 'morse'
			  else if(userResponse.equalsIgnoreCase(morse))
			  {
				  //Requests and reads user input
				  System.out.print("\nPlease enter your Morse-code phrase: ");
				  input.nextLine();
				  phrase = input.nextLine();
				  
				  //Ensures user do not enter anything other than '.' or '-'					  
				  while((phrase.matches(".*[\\w\\p{Punct}&&[^.-]].*")))
				  {
					  System.out.print("\nInvalid response.");
					  System.out.print("\nPlease enter your Morse-code phrase: ");
					  phrase = input.nextLine();
				  }
				  
				  //Splits entered phrase into separate words for processing
				  String[] morseMultipleWords = phrase.split("   ");
				  
				  System.out.println("\nYou entered: " + phrase);
				  System.out.print("In English, this is: ");
				  
				  for(int i = 0; i < morseMultipleWords.length; i++)
				  {
					  //Stores current word into a variable
					  morseMultiWords = morseMultipleWords[i];
					  
					  //Splits already split word into individual morse 'characters' for processing
					  String[] morseCharacters = morseMultiWords.split(" ");
				  
					  //Loops through the current character   
					  for(int j = 0; j < morseCharacters.length; j++)
					  {
						  morseChars += morseCharacters[j];
						  
						  //Translates characters from morse to English and builds the word
						  //back up in English
						  for(int index = 0; index < morseArray.length; index++) 
						  { 
							  if(morseChars.equals(morseArray[index])) 
								  morseWords += englishArray[index]; //Builds English word
						  }
						  morseChars = "";
					  }
					  morseWords += " "; //Adds a space in-between words
					  morseMultiWords = "";  
				  }
				  System.out.println(morseWords); //Prints out English translation
			  }
			  loop++;
			  
			  //Requests and reads user input
			  System.out.print("\n\nWould you like to enter another phrase? (Y or N): ");
			  answer = input.next();
			  
			  //Ensures user input is valid
			  while(!(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N")))
				{
					System.out.print("\nIncorrect input. Please enter either 'Y' or 'N'. ");
					answer = input.next();	
				}
			  //Loops program until user does not want to translate anything else
			  if(answer.equalsIgnoreCase("Y"))
			  {
				  morseWords = "";
				  loop = 0;
			  }
			  else
				  {
				  	//Ends program
				  	System.out.println("Program ended.");
			  		input.close();
				  }
		  }
	}
}
