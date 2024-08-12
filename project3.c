#include<stdio.h>
#include<stdlib.h>
#define max 10
int stack[max],top=-1;
void push();
void pop();
void display2();
void display();
int main(){
    int ch;
    do{
    printf("\n---------------STACK-----------------\n");
    printf("\n1.PUSH\n2.POP\n3.DISPLAY\n4.EXIT\n4.DISPLAY2");
    printf("\n---------------------------------------\n");
    printf("\n Enter your choise- ");
    scanf("%d",&ch);
    switch(ch){
        case 1:push();break;
        case 2:pop();break;
        case 3:display();break;
        case 4:exit(0);break;
        case 5: display2();break;
        default :printf("ERROR!!!!!!!!!!!!!");
    }
    }while(ch != 4);
    return 0;
}


void push(){
    int n;
    if(top==max-1)
    printf("Your Stack is full");
    else{
        printf("Enter your element- ");
        scanf("%d",&n);
         top++;
        stack[top]=n;
       
    }
}

void pop(){
    int n;
    if(top==-1){
        printf("Your stack is empty.");
    }else{
        n=stack[top];
        top--;
        printf("Your poped element is %d ",n);
        }
}

void display(){
    if(top==-1){
        printf("Your stack is empty.");
    }
    else{
        printf("Your element are- ");
        for (int k=top;k>=0;k--)
        printf("%d\t",stack[k]);
    }
}
