
import java.util.*;
class Star {

    public static void main(String[] args) {
        int n, i, j;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter new number");
        n = scan.nextInt();
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        for (int h = 1; h <= n; h++) {
            for (int o = 1; o <= h; o++) {
                System.out.print(" ");
            }
            for (int m = 1; m <= 2 * (n - h) - 1; m++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
