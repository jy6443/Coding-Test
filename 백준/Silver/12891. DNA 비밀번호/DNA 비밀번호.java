import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int s, p;
    public static Map<Character, Integer> cc;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        String dna = br.readLine();
        int[] num = new int[4];
        int[] map = new int[4];
        cc = new HashMap<>();
        cc.put('A', 0);
        cc.put('C', 1);
        cc.put('G', 2);
        cc.put('T', 3);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            num[i] = Integer.parseInt(st.nextToken()); // A C G T
        }
        int ans = 0;
        for (int i = 0; i < p; i++) {
            char c = dna.charAt(i);
            if (c != 'A' && c != 'C' && c != 'G' && c != 'T') {
                System.out.println(ans);
                return;
            } else {
                int idx = cc.get(c);
                map[idx]++;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (map[i] < num[i]) {
                ans--;
                break;
            }
        }
        ans++;
        int left = 0;
        int right = p;
        while (right < s) {
            char lc = dna.charAt(left);
            char rc = dna.charAt(right);
            int lidx = cc.get(lc);
            int ridx = cc.get(rc);
            map[lidx]--;
            map[ridx]++;
            for (int idx = 0; idx < 4; idx++) {
                if (map[idx] < num[idx]) {
                    ans--;
                    break;
                }
            }
            ans++;
            left++;
            right++;
        }
        System.out.println(ans);
    }
}