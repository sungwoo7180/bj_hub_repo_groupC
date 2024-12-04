import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // 입력 : 국가수와 알고 싶은 국가 번호
        int tryNumber = scanner.nextInt();
        int countryNumber = scanner.nextInt();
//        System.out.println(tryNumber);
//        System.out.println(countryNumber);

        // 메달 데이터 저장
        int[][] medalArray = new int[tryNumber][4];

        int index = 0;
        // 입력처리
        for (int i = 0; i < tryNumber; i++) {
            // 각 국가의 메달 데이터 입력
            int countryId = scanner.nextInt();
            int gold = scanner.nextInt();
            int silver = scanner.nextInt();
            int bronze = scanner.nextInt();

            medalArray[i][0] = countryId;
            medalArray[i][1] = gold;
            medalArray[i][2] = silver;
            medalArray[i][3] = bronze;
        }

        // 테스트 출력
//        for (int i = 0; i < tryNumber; i++) {
//            System.out.println("Country: " + medalArray[i][0] +
//                    ", Gold: " + medalArray[i][1] +
//                    ", Silver: " + medalArray[i][2] +
//                    ", Bronze: " + medalArray[i][3]);
//        }

        // 람다 표현식으로 2차원 배열 정렬
        Arrays.sort(medalArray, (a, b) -> {
            if (b[1] != a[1]) return b[1] - a[1]; // 금메달 비교
            if (b[2] != a[2]) return b[2] - a[2]; // 은메달 비교
            return b[3] - a[3]; // 동메달 비교
        });

        // 람다 표현식 X, 익명 클래스로 구현
//        Arrays.sort(medalArray, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] a, int[] b) {
//                if (b[1] != a[1]) {
//                    return b[1] - a[1]; // 금메달 비교
//                }
//                if (b[2] != a[2]) {
//                    return b[2] - a[2]; // 은메달 비교
//                }
//                return b[3] - a[3]; // 동메달 비교
//            }
//        });
        int number = 0;
        while (countryNumber != medalArray[number][0]) {
            number++;
        }
        System.out.println(number);




        // 잘못된 접근, 잘못된 문법
//        while(tryNumber!=0) {
//            String inputData = scanner.nextLine().trim();
//            medalArray[index][] = inputData.split(" ");
//            tryNumber--;
//            index++;
//        }
    }
}
