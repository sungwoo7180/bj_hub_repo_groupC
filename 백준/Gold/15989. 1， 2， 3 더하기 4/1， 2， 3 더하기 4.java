import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCaseNumber = scanner.nextInt();
        int[] testCaseArray = new int[testCaseNumber];

        // 입력 받기
        for (int i = 0; i < testCaseNumber; i++) {
            testCaseArray[i] = scanner.nextInt();
        }

        // 각 테스트 케이스 처리
        for (int n : testCaseArray) {
            int count = 0;

            // 1. 1로만 이루어진 경우
            count = 1;

            // 2. 1과 2로 이루어진 경우
            for (int k2 = 1; k2 <= n / 2; k2++) {
                int remaining = n - 2 * k2; // 남은 값
                if (remaining >= 0) {
                    count++;
                }
            }

            // 3. 1, 2, 3으로 이루어진 경우
            for (int k3 = 1; k3 <= n / 3; k3++) {
                for (int k2 = 0; k2 <= (n - 3 * k3) / 2; k2++) {
                    int remaining = n - 3 * k3 - 2 * k2; // 남은 값
                    if (remaining >= 0) {
                        count++;
                    }
                }
            }

            // 결과 출력
            System.out.println(count);
        }

        scanner.close();
    }
}