#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int randomInRange; 
int random;

void show() {
    printf("This is a number choice game.\n");
    printf("You have 10 chances And 3 hints to complete the game.\n");
}

void numbergen() {
    srand(time(0));
    randomInRange = rand() % 100 + 1; 
}

void showAnswer() {
    printf("The answer is %d\n", randomInRange);
    printf("Thank you for playing this game...");
    exit(0);
}

void hint1(int n){
    switch(n){
      printf("Hint is-- ");
      case 1:if(randomInRange<50)
      printf("Number is less then 50");
      else{
      printf("Number is greater then 50");}
      break;
      case 2:if(randomInRange%5==0){
        printf("number can multiply by 5");
      }else{
      printf("Not multiple by 5");}
      break;
      case 3:if(randomInRange%3==0){
      printf("Number can multiply by 3");}
      else{
      printf("Not multiple by 3");}
      break;
      default:printf("now you can Chooses:- Show Answer");
    }
 
}
int game() {
  numbergen();
    
    int randomNumber = rand();
    int count=0;
    int chance=10;
    int ch;
    int n=1;
    int op;
    while(count<10){
     printf("\nIf you continue play this game press (""1"") And if you want show ans or hint press(""2"").");
      printf("\n1.Continue\n2.Option\n");
      scanf("%d",&op);
      switch(op){
        case 1:{
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
        }break;
      case 2:{printf("\nIf you show the ans press(""1"") And if you want a hint press (""2"")");
        printf("\n1.Show Answer\n2.Hint\n");
        scanf("%d",&ch);
      if(ch==1){
        showAnswer();}
        if(ch==2){
        hint1(n);
        n++;
      }
      }break;
    }
}
return 0;
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
        printf("Thank you for playing this game . ");
      exit(0);
    }
  }
  return 0;
}