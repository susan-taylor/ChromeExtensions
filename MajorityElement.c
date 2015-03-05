/*---------------------------------------------------*/
/*  Name: Susan Taylor                               */
/*                                                   */
/*  A program that checks to see if a majority       */
/*  element in an array exists. If it does, it prints*/
/*  the value of the majority element. Otherwise, it */
/*  prints "no majority".                            */
/*                                                   */
/*****************************************************/

#include <stdio.h>
#include <math.h>

//function that loops through the array to check for the majority element
int checkMajority(int majority[], int size)
{
	int j=0;
	int k=0;
	int maxOccurrence;
	int majorityValue;
	
	for(j; j < size; j++)
	{			
		for(k; k < size; k++)
		{						
			if((majority[j] == majority[k]))
			{
				//value is incremented if duplicate is found
				maxOccurrence++;
			
					//if 4 duplicates are found, the majority has been found
					//and the loop breaks
					if(maxOccurrence == 4) 
					{
						majorityValue = majority[k];
						return majorityValue;
					}
			}
		}
		maxOccurrence=0;
		k=0;
	}
	
	//if statement to return either a 0 or the majorityValue to the main function
	if(maxOccurrence < 4)
		return -1;
}

int main(void)
{
	int i=0;
	int j=0;
	int const size=7;
	int number;
	int majority[size];
	int majorityValue;
	
	//prompt user for values
	printf("Enter 7 numbers:\n");
	
	//populates array with user values
	for(i; i < size; i++)
	{
		scanf("%i", &number);
		majority[i] = number;	
	}
		
	//calls to checkMajority function and stores result in variable	
	majorityValue = checkMajority(majority, size);
	
	//if statement to print correct message to user
	if(majorityValue < 0)
		printf("No majority.");
	else
		printf("Majority = %i.", majorityValue);

  return 0;
}
