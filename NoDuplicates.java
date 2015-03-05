import java.util.*;

public class Duplicates {

	public static void main(String[] args)
	{
		System.out.print("+----------------------------------------------------------------------------+\n"
                + "|Application Name: No Duplicates Array                                       |\n" 
                + "|Class Name:       Duplicates.java                                           |\n"
                + "|Author/Creator:   Susan Taylor                                              |\n" 
                + "|Description:      Write an application that inputs 20 numbers, each of      |\n"
                + "|                  which is between 10 and 100, inclusive. As each number is |\n"
                + "|                  read, display it only if it is not a duplicate of a       |\n"
                + "|                  number already read.                                      |\n"
                + "+----------------------------------------------------------------------------+\n\n\n");
	
		//Create Scanner object
		Scanner input = new Scanner(System.in);
		
		//Declare variables
		int[] array = new int[20];
		boolean isDuplicate;
		
		//Loops through array 20 times
		for(int count = 0; count < array.length; count++)
		{
			isDuplicate = false;
			
			System.out.print("\nPlease enter a number between 10 and 100: ");
			array[count] = input.nextInt();
			
			//Check condition for number entered to be between 10 and 100 inclusively
			while(array[count] < 10 || array[count] > 100)
			{
				System.out.print("Number out of range, please enter a number between 10 and 100: ");
				array[count] = input.nextInt();
			}
			
			System.out.print(count+1 + ": ");
			
			//Loops through entire array pulling single element out for checking
			for(int i = 0; i <= count; i++)
			{	
				//Loops through entire array checking single element against all elements
				for(int index = i; index >= 0; index--)
				{			
					//Compares array indexes to find duplicates
					//Does not compare same array index values
					if((array[index] == array[i]) && (i!=index))
					{
						isDuplicate = true;
						break; //Ends if statement if duplicate is found
					}
				}

			//Duplicate values are not printed
			if(isDuplicate==true)
			{
				//Resets isDuplicate boolean for next loop
				isDuplicate=false;
			}
			else
				System.out.print(array[i] + " "); //Prints non-duplicate values only
			}
		}
		input.close(); //Closes Scanner
	}
}


		


