import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 배열의 크기와 요소 입력
        int firstNumber = scanner.nextInt();
        int[] firstArray = new int[firstNumber];
        for(int i=0 ; i < firstNumber ; i++) {
            firstArray[i] = scanner.nextInt();
        }

        // 두 번째 배열의 크기와 요소 입력
        int secondNumber = scanner.nextInt();
        int[] secondArray = new int[secondNumber];
        for(int i=0 ; i < secondNumber ; i++) {
            secondArray[i] = scanner.nextInt();
        }
        // 여기서 두 배열을 함수 호출
        Arrays.sort(firstArray);

        // 두 배열 비교.
        matchArrayFunction(firstArray, secondArray);
    }

    static void matchArrayFunction(int[] firstArray, int[] secondArray) {
        // 매칭 결과를 저장하는 배열
        int[] matchArray = new int[secondArray.length];
        int index = 0;

        // 두 번째 배열 순회
        for ( int num2 :  secondArray  ) {
            boolean found = binarySearch(firstArray, num2, 0, firstArray.length - 1); // 이진 탐색 함수 호출

            // 매칭 결과를 기록
            matchArray[index] = found ? 1 : 0;
            index++; // 다음 인덱스로 이동
        }
        // 매칭 결과 출력
        for (int result : matchArray) {
            System.out.println(result);
        }
    }

    // 재귀 이진 탐색 함수 (메모리 효율적)
    static boolean binarySearch(int[] array, int target, int low, int high) {
        if (low > high) {
            return false; // 탐색 범위가 유효하지 않으면 false
        }

        int mid = low + (high - low) / 2; // 중간 인덱스 계산

        if (array[mid] == target) {
            return true; // 요소를 찾은 경우 true 반환
        } else if (array[mid] < target) {
            return binarySearch(array, target, mid + 1, high); // 오른쪽 부분 탐색
        } else {
            return binarySearch(array, target, low, mid - 1); // 왼쪽 부분 탐색
        }
    }
}
