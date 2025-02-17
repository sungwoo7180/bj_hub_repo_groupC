import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Backjoon10431sol1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 20크기의 int 형 배열 선언 or 21 크기
        // 2차원 배열로 해야겠네 input 다 받고 출력
        // 1. 열 숫자로 받고 그만큼 for 문
        // 2. String 으로 한 줄 받음 -> split 으로 나누고 나눈 값에 Int 형으로 형 변환 해서 배열에 넣기
        //
        int a = scanner.nextInt();
        scanner.nextLine();     // 버퍼
        int[][] lineUpArr = new int[a][20];
        String[] inputData = new String[a];

        for ( int i = 0 ; i < a ; i++ ) {
            inputData[i] = scanner.nextLine();
            String[] lineUp = inputData[i].split(" ");
            lineUp = Arrays.copyOfRange(lineUp, 1, lineUp.length);  // 첫번째 index 값을 제외한 나머지 값들을 저장
            for ( int num = 0 ; num < 20 ; num++ ) {
                lineUpArr[i][num] = parseInt(lineUp[num]);
            }
        }

        // solve1) 주어진대로 무식하게 배열에서 한칸씩 옮겨주기
        for ( int i = 0 ; i < a ; i++ ) {
            int moveCount = 0;          // 학생들이 이동한 수
            int[] countArray = new int[20];

            for ( int num = 0 ; num < 20 ; num++ ) {    // num = 몇번째 학생
                int position = 0;           // 기존에 학생들 비교 index
                countArray[num] = lineUpArr[i][num];
                // 삽입한 후에 비교해주는 연산
                while ( position < num  && countArray[position] < countArray[num]) {
                    position++;
                }
                moveCount += num - position;
                // 틀린 풀이 => 배열을 한칸씩 옮길때 누구를 먼저 옮길지 잘 정해야 함.
//                if( position != num ) {
//                    int temp1 = countArray[num];
//                    int temp2 = position;
//                    while ( position != num ) {
//                        countArray[position+1] = countArray[position];
//                        position++;
//                    }
//                    countArray[temp2] = temp1;
//                }
                // while 문으로 solve
//                if (position != num) {
//                    int temp = countArray[num];  // 이동할 값을 임시로 저장
//
//                    // 뒤에서부터 한 칸씩 값을 밀어내기 (num -> position)
//                    int index = num;
//                    while (index > position) {
//                        countArray[index] = countArray[index - 1];  // 한 칸씩 뒤로 밀어냄
//                        index--;
//                    }
//
//                    // 빈 자리에 임시로 저장한 값을 삽입
//                    countArray[position] = temp;
//                }

                // 학생들을 뒤로 밀어내기 위한 작업
                if ( position != num ) {
                    int temp = countArray[num];

                    // 위치부터 num까지 한 칸씩 뒤로 밀기
                    for (int j = num; j > position; j--) {
                        countArray[j] = countArray[j - 1];
                    }

                    // 삽입할 위치에 학생 삽입
                    countArray[position] = temp;
                }
            }
            System.out.println(i+1 + " " + moveCount);
        }
    }
}
