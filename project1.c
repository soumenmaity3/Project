#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
    srand(time(0));
    int random;
    int randomNumber = rand();
    int count=0;
    int randomInRange = rand() % 100+1;
    do{
      printf("\nEnter a number (0 to 100):- ");
      scanf("%d",&random);
      if(randomInRange> random){
        printf("Enter higher number.\n");
        count++;
        printf("Your are faild (%d)\n",count);
      }else if(randomInRange<random){
        printf("Enter lower number.\n");
        count++;
        printf("Your are faild (%d)\n",count);
      }
      else{
        printf("Congrats.....\n");
      }
    }while (randomInRange!=random);
    

    return 0;
}
