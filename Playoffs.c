/*---------------------------------------------------*/ 
/*  Name: Susan Taylor                               */ 
/*                                                   */ 
/*  A program that simulates a championship between  */ 
/*  two teams - Team 1 and Team 2. The program       */
/*  prompts the user to enter a value between 0 and  */
/*  100, which is used by the program as the percent */
/*  chance that Team 1 will win each game played.    */
/*  The program runs until one team has one 10 more  */
/*  playoffs than the other team and is declared the */
/*  winner of the championship.                      */
/*****************************************************/ 
 
#include <stdio.h> 
#include <stdlib.h>
#include <math.h> 
#include <time.h> 

int main(void){
    
    int userWinPercent = 0;
    int userInput;
    char ch;

    //prompt user for the percent chance that Team 1 will win a game 
    printf("Please enter the percentage chance that Team 1 will win: "); 
  
    //while loop that validates user input
    while(scanf("%d", &userWinPercent) != 1 || userWinPercent < 0 || userWinPercent > 100){
       while ((ch = getchar()) != '\n')
          putchar(ch);
       printf(" This not a valid input.\n");
       printf("Please enter an integer value between 0 and 100: ");
    }
  
   printf("Assignment written by Susan Taylor\n");
   srand(time(NULL)); //seed the pseudo-random number generator
   playChampionship(userWinPercent); //call playChampionship function   
}

//function that sets up the number boundaries for the random number generator
int generateRandom(int lBound, int uBound){
    return rand() % (uBound - lBound) + lBound;
}

//function that simulates a single game play 
int playGame(userWinPercent){ 

    //generates a number between 1 and 100
    int num1 = generateRandom(0, 100);  

    //if generated number is less than the percent chance entered by user, 
    //than Team 1 wins the game. Otherwise, Team 2 wins the game.
    if(num1 < userWinPercent)
        return(1); //Team One wins 
    else
        return(2); //Team One loses
}  
 
//function that simulates a playoff
int playPlayOff(userWinPercent){ 

    int teamOneMatchWin = 0;
    int teamTwoMatchWin = 0;

    //loop that runs until one team has won four games
    while(teamOneMatchWin < 4 && teamTwoMatchWin < 4){
       if(playGame(userWinPercent)== 1)
          teamOneMatchWin++;
       else
          teamTwoMatchWin++;
    }
    
    //return different value depending on what team wins the playoff
    if(teamOneMatchWin >= 4)
         return(1); //Team One wins 
    else
         return(2); //Team One loses
} 
 
//function that simulates a championship
int playChampionship(userWinPercent){  

    int teamOnePlayoffWin = 0;
    int teamTwoPlayoffWin = 0;

    //loop that runs until one team has won 10 more playoffs than the opposing team
    //returns a different value depending on what team wins the championship
    while(teamOnePlayoffWin - teamTwoPlayoffWin != 10 && teamTwoPlayoffWin - teamOnePlayoffWin != 10){
       if(playPlayOff(userWinPercent)== 1){
          printf("1");
          teamOnePlayoffWin++;
       }
       else{
          printf("2");
          teamTwoPlayoffWin++;
       }
    }

    //print statement to user on standard output device
    if(teamOnePlayoffWin - teamTwoPlayoffWin == 10)
       printf("\nTeam 1 wins the championship!\n");
    else
       printf("\nTeam 2 wins the championship!\n");
}
