import java.util.*;

public class SentenceGenerator {
	
	public static void main(String[] args)
	{
		  System.out.print("+----------------------------------------------------------------------------+\n"
	                + "|Application Name: Random Sentence Generator using Arrays                    |\n" 
	                + "|Class Name:       SentenceGenerator.java                                    |\n"
	                + "|Author/Creator:   Susan Taylor                                              |\n" 
	                + "|Description:      A program that uses the random number generator and four  |\n"
	                + "                   String arrays to create random sentences.                 |\n"
	                + "+----------------------------------------------------------------------------+\n\n");
		  
		//Create Random object
		Random generator = new Random();
		
		//Create Scanner object
		Scanner input = new Scanner(System.in);
		
		//Declare variables
		String exit = "no";
		String doNotExit = "yes";
		String userResponse;
		String article = "", noun = "", verb = "", prep = "";
		String sentence;
		
		//Requests and reads user input
		System.out.print("Would you like to create 20 sentences? (Yes or No): ");
		userResponse = input.next();		
		
		//While loop to ensure the user does not enter anything other than 'yes' or 'no'
		while(!(userResponse.equalsIgnoreCase(exit) || userResponse.equalsIgnoreCase(doNotExit)))
		{
			System.out.println("\nIncorrect input. Please enter either 'Yes' or 'No'.");
			System.out.print("Would you like to create 20 sentences? (Yes or No): ");
			userResponse = input.next();	
		}
		
		//While loop executes only if user wants to create sentences
		while((userResponse.equalsIgnoreCase(doNotExit)))
		{	
			System.out.println();
			
			//String array declarations
			String[] articleArray = {"the", "one", "some", "any", "an", "no"};
			String[] nounArray = {"boy", "girl", "dog", "house", "car", "town", "book", "candy", "Texas", "moon", "sun"};
			String[] verbArray = {"drove", "jumped", "ran", "walked", "works", "knows", "skipped"};
			String[] prepArray = {"from", "over", "under", "on", "for", "at"};
		
			//Creates 20 sentences
			for(int count = 0; count < 20; count++)
			{
				//Generates word from article array
				for(int index = 0; index < 2; index++)
				{
					//Generates a random number based on the length of the array
					int number = generator.nextInt(articleArray.length);
					
					//Uses the random number to select an article from the array
					article = articleArray[number];
					
					//Makes the first letter of the article a capital letter
					String articleCapital = article.substring(0, 1).toUpperCase();
					article = articleCapital + article.substring(1);
				}
				
				//Starts building sentence using the generated article
				sentence = article + " ";
						
				for(int index = 0; index < 2; index++)
				{
					int number = generator.nextInt(nounArray.length);
					noun = nounArray[number];
				}
				
				//Concatenates the generated noun to the sentence
				sentence += noun + " ";
						
				for(int index = 0; index < 2; index++)
				{
					int number = generator.nextInt(verbArray.length);
					verb = verbArray[number];
				}
			
				//Concatenates the generated verb to the sentence
				sentence += verb + " ";
				
				for(int index = 0; index < 2; index++)
				{
					int number = generator.nextInt(prepArray.length);
					prep = prepArray[number];
				}
				
				//Concatenates the generated preposition to the sentence
				sentence += prep + " ";
				
				for(int index = 0; index < 2; index++)
				{
					int number = generator.nextInt(articleArray.length);
					article = articleArray[number];
				}
				
				//Concatenates the generated article to the sentence
				sentence += article + " ";
			
				for(int index = 0; index < 2; index++)
				{
					int number = generator.nextInt(nounArray.length);
					noun = nounArray[number];
				}
			
				//Concatenates the generated noun to the sentence
				sentence += noun + ".";
				
				//Prints completed sentence
				System.out.println(count+1 + ") " + sentence);
			}
			
			//Requests and reads user input
			System.out.print("\nWould you like to create more sentences? (Yes or No): ");
			userResponse = input.next();
			
			//While loop to ensure the user does not enter anything other than 'yes' or 'no'
			while(!(userResponse.equalsIgnoreCase(exit) || userResponse.equalsIgnoreCase(doNotExit)))
			{
				System.out.println("Incorrect input. Please enter either 'Yes' or 'No'.");
				System.out.print("\nWould you like to create more sentences? (Yes or No): ");
				userResponse = input.next();
			}
		}
		//Executes if user does not want to create more sentences and enters 'no' when asked
		if((userResponse.equalsIgnoreCase(exit)))
		{
			System.out.println("Program closed.");
			input.close(); //Closes Scanner object
		}	
	}
}
