import java.util.Arrays;
import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            arr[i] = number;
        }
        Arrays.sort(arr);
        int answer = 0;
        loof: for (int i = n-1; i > -1; i--) {
            int target = arr[i];
            for (int j = 0; j < n; j++) {
                int first = arr[j];
                int needed = target - first;
                int left = 0;
                int right = n - 1;
                while (left <= right) {
                    if (arr[left] + arr[right] == needed) {
                        answer = target;
                        break loof;
                    } else if (arr[left] + arr[right] < needed) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        System.out.println(answer);

    }
}
