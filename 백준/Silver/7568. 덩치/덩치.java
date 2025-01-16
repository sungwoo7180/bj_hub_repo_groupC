import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 입력 처리
        int N = sc.nextInt();
        int[][] people = new int[N][2]; // 몸무게, 키 저장
        int[] rank = new int[N]; // 등수 저장

        for (int i = 0; i < N; i++) {
            people[i][0] = sc.nextInt(); // 몸무게
            people[i][1] = sc.nextInt(); // 키
            rank[i] = 1; // 초기 등수는 모두 1
        }

        // 2. 등수 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    rank[i]++;
                }
            }
        }

        // 3. 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(rank[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
