import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println(solve(a, b, c));
    }
    public static long solve(int a, int turn, int c) {
        if (turn == 1) {
            return a % c;
        }
        long result = solve(a, turn / 2, c) % c;
        if (turn % 2 == 0) {
            return (result * result) % c;
        } else {
            return (result * (solve(a, turn / 2 + 1, c) % c)) % c;
        }
    }
}