import java.util.Scanner;

public class Time 
{
	public static void main(String[] args)
	{
		System.out.print("+----------------------------------------------------------------------------+\n"
                + "|Application Name: Time Converter                                            |\n" 
                + "|Class Name:       Time.java                                                 |\n"
                + "|Author/Creator:   Susan Taylor                                              |\n" 
                + "|Description:      A program that reads two times in military format         |\n"
                + "|                  (example: 0900, 1730) and prints the number of hours and  |\n"
                + "|                  minutes between the two times.                            |\n"
                + "+----------------------------------------------------------------------------+\n\n\n");
		
		//Declare variables
		int startTime, endTime, startHour, endHour, startMin, endMin;
		String quit;
		String choice = ("y");
		String exit = ("n");
		
		//Create Scanner object
		Scanner input = new Scanner(System.in);
		
		//While loop continues if user does not enter 'n' or 'N' when
		//given the option
		while(!choice.equalsIgnoreCase(exit))
		{
			//Read first time input
			System.out.print("Enter first time: ");
			startTime = input.nextInt();
		
			//Read second time input
			System.out.print("Enter second time: ");
			endTime = input.nextInt();
			
			//Calculate hours and minutes from times entered
			startHour = startTime / 100;

			startMin = startTime % 100;

            endHour = endTime / 100;

            endMin = endTime % 100;
			
			if(startTime < endTime)
			{
				//startTime < endTime && startHour == endHour
				if (startHour == endHour)
					System.out.println("Elapsed time: " 
	            				  	+ (endHour - startHour) 
	            				  	+ " hours " 
	            				  	+ Math.abs(endMin - startMin) 
	            				  	+ " minutes");
			
				else //startTime < endTime && startHour != endHour 
					
					//startTime < endTime && startHour != endHour && startMin == endMin
					if(startMin == endMin)
					{
					System.out.println("Elapsed time: " 
								    + (endHour - startHour + 24) % 24
								    + " hours " 
								    + Math.abs(endMin - startMin) 
								    + " minutes");
					}
					else //startTime < endTime && startHour != endHour && startMin != endMin
					{
						//startTime < endTime && startHour != endHour && startMin != endMin && endMin == 0
						if(endMin == 0) 
						{
						endMin = 60;
						System.out.println("Elapsed time: " 
							    		+ (endHour - startHour + 23) % 24
							    		+ " hours " 
							    		+ Math.abs(endMin - startMin) 
							    		+ " minutes");
						}
						
						//startTime < endTime && startHour != endHour && startMin != endMin && endMin != 0
						else
						{
							System.out.println("Elapsed time: " 
								    		+ (endHour - startHour + 24) % 24
								    		+ " hours " 
								    		+ Math.abs(endMin - startMin) 
								    		+ " minutes");
						}
					}	
				} 
			//startTime > endTime && startHour == endHour
			else if (startHour == endHour) 
				{	
					//startTime > endTime && startHour == endHour && startMin > endMin
					if(startMin > endMin)
						System.out.println("Elapsed time: " 
							  	    	+ (endHour - startHour + 23) 
							  	    	+ " hours " 
							  	    	+ Math.abs(60 - (startMin - endMin))
							  	    	+ " minutes");
				}
					//startTime > endTime && startHour != endHour
					else 
					{	
						//startTime > endTime && startHour != endHour && startMin > endMin
						if(startMin > endMin) 
							System.out.println("Elapsed time: " 
										+ (endHour - startHour + 23) 
										+ " hours " 
										+ Math.abs(60 - (startMin - endMin)) 
										+ " minutes");
						
						//startTime > endTime && startHour != endHour && startMin < endMin
						else 
						System.out.println("Elapsed time: " 
						  	    		+ (endHour - startHour + 24) 
						  	    		+ " hours " 
						  	    		+ Math.abs(startMin - endMin)
						  	    		+ " minutes");
					}
			
			//Display two possible answers if the start time is equal to the end time
			if(startTime == endTime)
			{
				System.out.println("Elapsed time: 0 hours or 24 hours");
			}
			
			//Read input from user
			System.out.print("Do you want to quit? (Y/N): ");
			quit = input.next();
			System.out.println();
		
			//Close program if user selects option to quit
			if(quit.equalsIgnoreCase(choice))
			{
				System.out.println("Program closed.");
				System.exit(0);
				input.close();
			}
		}
	}	
}
