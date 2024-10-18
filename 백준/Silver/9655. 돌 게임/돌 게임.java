import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputNum = scanner.nextInt();

        if(inputNum % 2 == 1 ) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
