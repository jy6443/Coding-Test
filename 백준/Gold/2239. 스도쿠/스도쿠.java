import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] sudoku = new int[9][9];
        List<int[]> empty = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                int v = Integer.parseInt(line.charAt(j) + "");
                sudoku[i][j] = v;
                if (sudoku[i][j] == 0) {
                    empty.add(new int[]{i, j});
                }
            }
        }
        flag = false;
        find(0,sudoku,empty);

    }
    public static void find(int dep, int[][] sudoku, List<int[]> empty) {
        if (flag) {
            return;
        }
        if (dep == empty.size()) {
            flag = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(sudoku[i][j]);
                }
                System.out.println();
            }
            return;
        }
        int y = empty.get(dep)[0], x = empty.get(dep)[1];
        for (int i = 1; i <= 9; i++) {
            if (vertical(i, x, sudoku) && horizontal(i, y, sudoku) && group(i, y, x, sudoku)) {
                sudoku[y][x] = i;
                find(dep + 1, sudoku, empty);
                sudoku[y][x] = 0;
            }
        }
    }
    public static boolean group(int i, int y, int x, int[][] sudoku) {
        int y_step = y / 3, x_step = x / 3;
        for (int j = y_step * 3; j < y_step * 3 + 3; j++) {
            for (int k = x_step * 3; k < x_step * 3 + 3; k++) {
                if (sudoku[j][k] == i) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean horizontal(int i, int y, int[][] sudoku) {
        for (int j = 0; j < 9; j++) {
            if (sudoku[y][j] == i) {
                return false;
            }
        }
        return true;
    }
    public static boolean vertical(int i, int x, int[][] sudoku) {
        for (int j = 0; j < 9; j++) {
            if (sudoku[j][x] == i) {
                return false;
            }
        }
        return true;
    }
}