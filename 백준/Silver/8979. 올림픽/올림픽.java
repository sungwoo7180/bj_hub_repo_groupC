import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 입력: 국가 수와 등수를 알고 싶은 국가 번호
        int n = scanner.nextInt(); // 국가 수
        int k = scanner.nextInt(); // 등수를 알고 싶은 국가 번호

        // 메달 데이터를 저장할 배열
        int[][] medalArray = new int[n][4];

        for (int i = 0; i < n; i++) {
            medalArray[i][0] = scanner.nextInt(); // 국가 번호
            medalArray[i][1] = scanner.nextInt(); // 금메달 수
            medalArray[i][2] = scanner.nextInt(); // 은메달 수
            medalArray[i][3] = scanner.nextInt(); // 동메달 수
        }

        // 정렬: 금 > 은 > 동 기준 내림차순
        Arrays.sort(medalArray, (a, b) -> {
            if (b[1] != a[1]) return b[1] - a[1]; // 금메달 비교
            if (b[2] != a[2]) return b[2] - a[2]; // 은메달 비교
            return b[3] - a[3]; // 동메달 비교
        });

        // 등수 계산
        int rank = 1; // 초기 등수
        int targetIndex = 0; // K번 국가의 배열 인덱스

        for (int i = 0; i < n; i++) {
            if (medalArray[i][0] == k) {
                targetIndex = i;
                break;
            }
        }

        // 목표 국가보다 잘한 국가 수를 기준으로 등수 계산
        for (int i = 0; i < targetIndex; i++) {
            if (medalArray[i][1] > medalArray[targetIndex][1]
                || (medalArray[i][1] == medalArray[targetIndex][1]
                    && medalArray[i][2] > medalArray[targetIndex][2])
                || (medalArray[i][1] == medalArray[targetIndex][1]
                    && medalArray[i][2] == medalArray[targetIndex][2]
                    && medalArray[i][3] > medalArray[targetIndex][3])) {
                rank++;
            }
        }

        // 결과 출력
        System.out.println(rank);
    }
}
