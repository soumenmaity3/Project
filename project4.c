#include <stdio.h>
#include <stdlib.h>

#define SIZE 100

int queue[SIZE], front = -1, rear = -1;

void insert();
void display();
void delete();

int main() {
    int ch;
    do {
        printf("\n---------------QUEUE-------------\n");
        printf("\n1. INSERT\n2. DISPLAY\n3. DELETE\n4. EXIT");
        printf("\n---------------------------------\n");
        printf("Enter your choice - ");
        scanf("%d", &ch);

        switch (ch) {
            case 1:
                insert();
                break;
            case 2:
                display();
                break;
            case 3:
                delete();
                break;
            case 4:
                exit(0);
            default:
                printf("Invalid choice. Please try again.\n");
                break;
        }
    } while (ch != 4);

    return 0;
}

void insert() {
    int n;
    if (rear == SIZE - 1) {
        printf("Your queue is full.\n");
    } else {
        printf("Enter your element: ");
        scanf("%d", &n);

        if (front == -1) front = 0;  

        rear++;
        queue[rear] = n;
    }
}

void display() {
    if (front == -1 || front > rear) {
        printf("Your queue is empty.\n");
    } else {
        printf("Your elements are: ");
        for (int i = front; i <= rear; i++) {
            printf("%d ", queue[i]);
        }
        printf("\n");
    }
}

void delete() {
    if (front == -1 || front > rear) {
        printf("Your queue is empty.\n");
    } else {
        printf("Your deleted element is %d\n", queue[front]);
        front++;
        if (front > rear) {  
            front = rear = -1;
        }
    }
}
