/*---------------------------------------------------*/
/*  Name: Susan Taylor                               */
/*                                                   */
/* A program that enumerates all the amounts that    */
/* can be paid using a specified number of coina.    */
/* The program only uses pennies, nickels, dimes &   */
/* & quarters as coins. It reads the number of coins */
/* from the user & print all the amounts that can be */
/* paid using only n coins.                          */
/*                                                   */
/*****************************************************/

#include <stdio.h>

//function that takes an amount x in cents & finds the minimum
//number of coins required for x cents.
void find_coins(int coinValue, int *penniesPtr, int *nickPtr, int *dimePtr, int *qtrPtr)
{	
	//computes the number of pennies, nickels, dimels & quarters needed for x cents
	*qtrPtr = coinValue / 25;
	
	*dimePtr = (coinValue % 25) / 10;
	
	*nickPtr = ((coinValue % 25) % 10) / 5;

	*penniesPtr = (((coinValue % 25) % 10) % 5) / 1;
	
	return;
}

int main()
{
 	int coins=0;
 	int maxAmount=0;
 	int const quarter=25;
 	int quarterAmount, dimeAmount, nickelAmount, pennyAmount;
	int *penniesPtr, *nickPtr, *dimePtr, *qtrPtr; //pointers
	int i, j;
	
	//pointer assignment
	penniesPtr = &pennyAmount;
	nickPtr = &nickelAmount;
	dimePtr = &dimeAmount;
	qtrPtr = &quarterAmount;
	 
	//Requests input from user & reads input
 	printf("Enter the number of coins:\n");
 	scanf("%d", &coins);
 	
 	//The max cent amount made from the # of coins entered by user
 	maxAmount = quarter * coins;
 	
	//loop that iterates through from 1 cent to maxAmount of cents
	for(j=1; j < maxAmount+1; j++)
	{ 		 		
	 	//calls to function
	 	find_coins(j, penniesPtr, nickPtr, dimePtr, qtrPtr);
	 			 		
	 	//if statement to check that the amount of coins is equal to the sum of the number needed for x cents
	 	if(coins == (pennyAmount + nickelAmount + dimeAmount + quarterAmount))
	 	{
	 	 	printf("\t%d cents:\t%d quarters    %d dimes   %d nickels   %d pennies\n", j, quarterAmount, dimeAmount, nickelAmount, pennyAmount);	
	 	}
	}
 	  
  return 0;
}
