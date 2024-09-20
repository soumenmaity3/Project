import java.util.*;
/*example like
 * let length=4
 * let elements are=
 * 1
 * 2
 * 3
 * 4
 * 5
 * ***output****
 * sum is = 15
 * sum of array is- 12
 * missing number is = 3
 */
class MissingNumber {
    public static void main(String[] args) throws Exception {
        int[] lerge;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your array length- ");
        int length = scanner.nextInt();
        lerge = new int[length];
        System.out.println("Enter elements of array- ");
        for (int i = 0; i < lerge.length; i++) {
            lerge[i] = scanner.nextInt();
        }
        int max = lerge[0];
        for (int i = 1; i < lerge.length; i++) {
            if (lerge[i] > max) {
                max = lerge[i];
            }
        }
        int sum = 0;
        int n = max;
        sum = ((n * (n + 1)) / 2);
        System.out.println("Your ans is-" + sum);
        int sumOfArray = 0;
        for (int i = 0; i < lerge.length; i++) {
            sumOfArray += lerge[i];
        }
        System.out.println("The sum of the array is: " + sumOfArray);
        if((sum-sumOfArray)!=0){
        System.out.println("missing number is- "+(sum-sumOfArray));}
        else
            System.out.println("missing number is not find");
    }
}