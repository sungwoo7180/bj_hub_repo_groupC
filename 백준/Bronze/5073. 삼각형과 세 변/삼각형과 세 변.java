import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int first_input_number;
//        int second_input_number;
//        int third_input_number;
        boolean loop = true;
        int[] arrayNum = new int[3];
        String[] arrayStr = new String[1000];

        int loopNum = 0;
        while (loop) {

//            first_input_number = scanner.nextInt();
//            second_input_number = scanner.nextInt();
//            third_input_number = scanner.nextInt();
            // 1. 삼각형의 조건을 만족하는지 판단
            // 가장 큰 변이 뭔지 찾기
            // 3개의 변수 보다는 배열을 썼을때 정렬을 쓰기 좋아보임.
            // java 에서 제공하는 정렬을 쓰지 않고 내가 구현해 보기.

            arrayNum[0] = scanner.nextInt();
            arrayNum[1] = scanner.nextInt();
            arrayNum[2] = scanner.nextInt();

            // 0. 종료 조건
            if (arrayNum[0] == 0 && arrayNum[1] == 0 && arrayNum[2] == 0) {
                break;
            }
            
            // 1. 삼각형 조건 맞는지
            Arrays.sort(arrayNum);
            // 향상된 for 문 쓰기, debug 용
//            System.out.println(arrayNum[0]);
//            System.out.println(arrayNum[1]);
//            System.out.println(arrayNum[2]);

            if ( arrayNum[2] >= arrayNum[0] + arrayNum[1]) {
//                System.out.println("Invalid");
                arrayStr[loopNum] = "Invalid";
            } else if ( arrayNum[0] == arrayNum[1] && arrayNum[1] ==  arrayNum[2] ) {
//                System.out.println("Equilateral");
                arrayStr[loopNum] = "Equilateral";
            } else if ( arrayNum[0] == arrayNum[1] || arrayNum[1] ==  arrayNum[2] ) {
//                System.out.println("Isosceles");
                arrayStr[loopNum] = "Isosceles";
            } else {
//                System.out.println("Scalene");
                arrayStr[loopNum] = "Scalene";
            }
            loopNum++;
        }

        for ( String str : arrayStr) {
            if (str != null) {  // null 값은 출력하지 않음
                System.out.println(str);
            }
        }
//        System.out.println(first_input_number);
//        System.out.println(second_input_number);
//        System.out.println(third_input_number);


    }
}
