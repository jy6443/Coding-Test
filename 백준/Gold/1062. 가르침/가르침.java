
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
        int k = Integer.parseInt(st.nextToken());
        String[] strList = new String[n];
        Set<Character> charList = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            strList[i] = str;
        }
        if (k < 5) {
            System.out.println(0);
        } else {
            Set<Character> set = new HashSet<Character>();
            insert(set);
            answer = loop(set, strList);
            setting(set, strList, charList);
            List<Character> list = new ArrayList<>(charList);
            bt(k, set, list, strList, 0);
            System.out.println(answer);
        }
    }
    public static void bt(int k, Set<Character> set, List<Character> list, String[] strList, int temp) {
        if (set.size() == k || set.size() == (list.size() + 5)) {
            answer = Math.max(answer, loop(set, strList));
            return ;
        }
        for (int i = temp; i < list.size(); i++) {
            if (!set.contains(list.get(i))) {
                set.add(list.get(i));
                bt(k, set, list, strList, i+1);
                set.remove(list.get(i));
            }
        }
    }
    public static void setting(Set<Character> set, String[] strList, Set<Character> charList) {
        for (String str : strList) {
            for (int i = 0; i < str.length(); i++) {
                if (!set.contains(str.charAt(i)) && !charList.contains(str.charAt(i))) {
                    charList.add(str.charAt(i));
                }
            }
        }
    }
    public static void insert(Set<Character> set) {
        set.add('a');
        set.add('c');
        set.add('i');
        set.add('n');
        set.add('t');
    }
    public static int loop(Set<Character> set, String[] strList) {
        int cnt = 0;
        for (String str : strList) {
            boolean flag = true;
            for (int i = 0; i < str.length(); i++) {
                if (!set.contains(str.charAt(i))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        return cnt;
    }
}

