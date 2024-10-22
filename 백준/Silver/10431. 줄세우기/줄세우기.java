import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 테스트 케이스의 수 입력
        int testCases = scanner.nextInt();

        // 각 테스트 케이스 처리
        for (int t = 0; t < testCases; t++) {
            int testCaseNumber = scanner.nextInt();  // 테스트 케이스 번호 입력

            int[] heights = new int[20];  // 20명의 학생 키를 저장할 배열
            for (int i = 0; i < 20; i++) {
                heights[i] = scanner.nextInt();  // 학생들의 키 입력
            }

            int moveCount = 0;  // 학생들이 이동한 총 횟수

            // 삽입 정렬을 사용하여 이동 횟수 계산
            for (int i = 1; i < 20; i++) {
                int current = heights[i];  // 현재 학생의 키
                int j = i - 1;

                // 현재 학생보다 키가 큰 학생들을 뒤로 이동
                while (j >= 0 && heights[j] > current) {
                    heights[j + 1] = heights[j];  // 한 칸씩 뒤로 이동
                    j--;
                    moveCount++;  // 이동 횟수 증가
                }

                // 현재 학생을 올바른 위치에 삽입
                heights[j + 1] = current;
            }

            // 결과 출력 (테스트 케이스 번호와 이동 횟수)
            System.out.println(testCaseNumber + " " + moveCount);
        }

        scanner.close();  // Scanner 닫기
    }
}
