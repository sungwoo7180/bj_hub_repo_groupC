import java.util.Scanner;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {

        // 1. 규칙 파악
        // 1 일때 ( 총 1개 ) => 1
        // 2 ~ 7 ( 총 6개 ) => 2
        // 8 ~ 19  ( 총 12개 ) => 3
        // 20 ~ 37    ( 총 18개 ) => 4
        // 38 ~         ( 총 24 개 ) => 5

        Scanner scanner = new Scanner(System.in);

        int inputNumber = scanner.nextInt();
        int i=0;
//        int shortestDistance;
        if(inputNumber == 1) {
            System.out.println(1);
        } else {
            while(true) {
                if( 3*pow(i,2) - 3*i + 1 < inputNumber &&  inputNumber <= 3*pow(i,2) + 3*i + 1) {
                    System.out.println(i + 1);
                    break;
                }
                i++;
            }
        }
    }
}
