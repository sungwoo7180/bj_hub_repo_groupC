import java.util.Arrays;
import java.util.Scanner;

public class Java {
    public static void main(String[] args) {
        // Solve 1 : 2개의 기준으로 2차원 배열 정렬 후 위를 기준으로 rank 측정 알고리즘[시간 복잡도 : O(n * log n)]
        // 1-1 몇 명인지 숫자 N 받음
        // 1-2 몸무게 키 받음 <- 2차원 배열로 N 행 4 열 ( 3번째 속성은 rank , 4번째 속성은 원래의 index )
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] people = new int[N][3]; // 몸무게, 키, 원래 인덱스 저장
        for (int i = 0 ; i < N ; i++) {
            people[i][0] = sc.nextInt(); // 몸무게
            people[i][1] = sc.nextInt(); // 키
            people[i][2] = i; // 원래 인덱스
        }

        // 2. 몸무게와 키 기준으로 정렬 (몸무게 -> 키 오름차순) , 맨 위에 있는 집단이 rank 1 그리고 rank 1은 여러명일 수도 있다.
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        // 3. rank 계산
        int[] rank = new int[N];
        Arrays.fill(rank, 1); // 초기 등수는 모두 1

        for (int i = 0 ; i < N ; i++) {
            for (int j = i + 1 ; j < N ; j++) {
                // i보다 j가 더 크다면 i의 rank 증가
                if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    rank[people[i][2]]++;
                }
            }
        }

        // 4. 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < N ; i++) {
            sb.append(rank[i]).append(" ");
        }
        System.out.println(sb.toString().trim());

        // solve 2
//        // 1. 입력 처리
//        int N = sc.nextInt();
//        int[][] people = new int[N][2]; // 몸무게, 키 저장
//        int[] rank = new int[N]; // 등수 저장
//
//        for (int i = 0; i < N; i++) {
//            people[i][0] = sc.nextInt(); // 몸무게
//            people[i][1] = sc.nextInt(); // 키
//            rank[i] = 1; // 초기 등수는 모두 1
//        }
//
//        // 2. 등수 계산
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if (i != j && people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
//                    rank[i]++;
//                }
//            }
//        }
//
//        // 3. 결과 출력
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < N; i++) {
//            sb.append(rank[i]).append(" ");
//        }
//        System.out.println(sb.toString().trim());
    }
    
}



