import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<char[][]> data = new ArrayList<>();
        while (true) {
            String line = br.readLine();
            if (line.equals("end")) {
                break;
            }
            char[][] tic = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    tic[i][j] = line.charAt(3*i+j);
                }
            }
            data.add(tic);
        }
        for (int i = 0; i < data.size(); i++) {
            if (test(data.get(i))) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }
        }
    }
    public static boolean test(char[][] tic) {
        int x = 0, o = 0, n = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tic[i][j] == 'O') {
                    o++;
                } else if (tic[i][j] == 'X') {
                    x++;
                } else {
                    n++;
                }
            }
        }
        if (x != o && x != (o + 1)) {
            return false;
        }
        int x_total_cnt = 0;
        int o_total_cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (tic[i][0] == 'O' && tic[i][1] == 'O' && tic[i][2] == 'O') {
                o_total_cnt++;
            }
            if (tic[i][0] == 'X' && tic[i][1] == 'X' && tic[i][2] == 'X') {
                x_total_cnt++;
            }
            if (tic[0][i] == 'O' && tic[1][i] == 'O' && tic[2][i] == 'O') {
                o_total_cnt++;
            }
            if (tic[0][i] == 'X' && tic[1][i] == 'X' && tic[2][i] == 'X') {
                x_total_cnt++;
            }
        }

        if (tic[0][0] == 'O' && tic[1][1] == 'O' && tic[2][2] == 'O') {
            o_total_cnt++;
        }
        if (tic[0][0] == 'X' && tic[1][1] == 'X' && tic[2][2] == 'X') {
            x_total_cnt++;
        }
        if (tic[0][2] == 'O' && tic[1][1] == 'O' && tic[2][0] == 'O') {
            o_total_cnt++;
        }
        if (tic[0][2] == 'X' && tic[1][1] == 'X' && tic[2][0] == 'X') {
            x_total_cnt++;
        }

        if (x > o && x_total_cnt > 0 && o_total_cnt == 0) {
            return true;
        }
        if (x == o && x_total_cnt == 0 && o_total_cnt > 0) {
            return true;
        }
        if (n == 0 && x_total_cnt == 0 && o_total_cnt == 0) {
            return true;
        }
        return false;
    }
}