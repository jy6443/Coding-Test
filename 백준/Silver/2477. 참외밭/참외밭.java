import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        List<int[]> arr = new ArrayList<>();
        int ny = 0, nx =0;
        arr.add(new int[]{ny, nx});
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (dir == 1) {
                nx += num;
            } else if (dir == 2) {
                nx -= num;
            } else if (dir == 3) {
                ny += num;
            } else {
                ny -= num;
            }
            arr.add(new int[]{nx, ny});
        }
        int asum = 0;
        int bsum = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            asum += (arr.get(i)[0] * arr.get(i+1)[1]);
            bsum += (arr.get(i)[1] * arr.get(i+1)[0]);
        }
        int answer = Math.abs(asum - bsum) / 2;
        System.out.println(answer * k);
    }
}