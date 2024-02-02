import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] numArray = new int[N];

        // 올바른 반복문 조건 사용
        for (int i = 0; i < N; i++) {
            numArray[i] = scanner.nextInt();
        }

        // 배열을 오름차순으로 정렬
        Arrays.sort(numArray);

        // 정렬된 결과 출력
        for (int i = 0; i < N; i++) {
            System.out.println(numArray[i]);
        }
    }
}
