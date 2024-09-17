
import java.util.*;
// import javax.crypto.Mac;

class mystack {

    int size = 10;
    int top = -1;
    int[] stack = new int[size];

    void push() {
        int n;
        if (top == size - 1) {
            System.out.println("Your stack is full");
        } else {
            System.out.println("Enter yout Element-: ");
            Scanner scan = new Scanner(System.in);
            n = scan.nextInt();
            top++;
            stack[top] = n;
        }
    }

    void pop() {
        int n;
        if (top == -1) {
            System.out.println("Your stack is empty.");
        } else {
            n = stack[top];
            System.out.println("Poped element is -  " + n);
            top--;
        }
    }

    int display() {
        if (top == -1) {
            System.out.println("Your stack is empty.");
        } else {
            System.out.println("This is your element- ");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
        return 0;
    }
}

class StackJava{

    public static void main(String[] args) {
        int ch;
        mystack M = new mystack();
        do {

            System.out.println("-----------STACK manu-----------");
            System.out.println("1.PUSH\n2.POP\n3.DISPLAY\n4.EXIT");
            System.out.println("--------------------------------");
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your choise:- ");
            ch = scan.nextInt();
            switch (ch) {
                case 1:
                    M.push();
                    break;
                case 2:
                    M.pop();
                    break;
                case 3:
                    M.display();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choise.");
            }
        } while (ch != 4);
    }
}