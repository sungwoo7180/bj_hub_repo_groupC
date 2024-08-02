import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstArray = new int[5];
        int arraySum = 0;
        for ( int i = 0 ; i < 5 ; i++ ) {
            firstArray[i] = scanner.nextInt();
            arraySum += firstArray[i];
        }
        Arrays.sort(firstArray);
        System.out.println(arraySum/5);
        System.out.println(firstArray[firstArray.length/2]);

    }
}
