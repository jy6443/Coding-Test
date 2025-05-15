import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();
        for (int idx = 0; idx < str.length(); idx++) { // 10^6
            if (stack.size() < 4) {
                stack.push(str.charAt(idx));
            } else {
                Character now = str.charAt(idx);
                Character c3 = stack.pop();
                Character c2 = stack.pop();
                Character c1 = stack.pop();
                if (c1 == 'P' && c2 == 'P' && c3 == 'A' && now == 'P') {
                    stack.push('P');
                } else {
                    stack.push(c1);
                    stack.push(c2);
                    stack.push(c3);
                    stack.push(now);
                }
            }
        }
        if (stack.size() == 1 && stack.pop() == 'P' || (stack.size() == 4 && stack.pop() == 'P' && stack.pop() == 'A' && stack.pop() == 'P' && stack.pop() == 'P')) {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}