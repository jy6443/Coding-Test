import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        answer = 0;
        recur(r,c,0,0,(1 << n), (1 << n), n);
        System.out.println(answer);

    }
    public static void recur(int y, int x, int start_y, int start_x,  int end_y, int end_x, int temp) {
        if (temp == 0) {
//            if (y == start_y && x == start_x) {
//                answer += 0;
//            } else if (y == start_y && x == end_x) {
//                answer += 1;
//            } else if (y == end_y && x == start_x) {
//                answer += 2;
//            } else {
//                answer += 3;
//            }
            return;
        }
        int mid_y = (start_y + end_y) / 2;
        int mid_x = (start_x + end_x) / 2;
        if (start_y <= y && y < mid_y && start_x <= x && x < mid_x) { // 좌상
            answer += 0;
            recur(y,x,start_y,start_x,mid_y,mid_x, temp - 1);
        } else if (start_y <= y && y < mid_y && mid_x <= x && x < end_x) { // 우상
            answer += (1 << temp) * (1 << temp) / 4;
            recur(y,x,start_y,mid_x,mid_y,end_x, temp - 1);
        } else if (mid_y <= y && y < end_y && start_x <= x && x < mid_x) { // 좌하
            answer += 2 * ((1 << temp) * (1 << temp) / 4);
            recur(y,x,mid_y,start_x,end_y, mid_x, temp - 1);
        } else { // 우하
            answer += 3 * ((1 << temp) * (1 << temp) / 4);
            recur(y,x,mid_y,mid_x,end_y,end_x, temp - 1);
        }
    }
}