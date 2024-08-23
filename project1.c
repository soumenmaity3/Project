#include <stdio.h>
#include <stdlib.h>
#include <time.h>


int show(){
  printf("This is a number choise game.\n");
    printf("You have 10 chance to complete this game. Lets play....");
}
int game() {
    srand(time(0));
    int random;
    int randomNumber = rand();
    int count=0;
    int chance=10;
    char ch;
    int randomInRange = rand() % 100+1;
    while(count<10){
      printf("\nEnter a number (0 to 100):- ");
      scanf("%d",&random);
      if(randomInRange> random){
        printf("Enter higher number.\n");
        count++;
        printf("Your are faild (%d/%d)\n",count,chance);
      }else if(randomInRange<random){
        printf("Enter lower number.\n");
        count++;
        printf("Your are faild (%d/%d)\n",count,chance);
      }
      else{
        printf("Congrats.....\n");
      }
      if(count == 10){
        printf("Game Over. Right number is- %d",randomInRange);
        printf("\nThank you for playing.");
      }
    }
}

int main(){
  show();
  game();
  while(1){
    char ch;
    printf("\n\n\nPlay again?(y/n)- ");
    scanf(" %c",&ch);
    if(ch=='y'){
      game();
    }else{
      exit(0);
    }
  }
  return 0;
}
