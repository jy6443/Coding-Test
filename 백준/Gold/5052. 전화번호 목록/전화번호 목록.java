import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int t, n;
    public static String answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        t = Integer.parseInt(line);
        for (int i = 0; i < t; i++) {
            line = br.readLine();
            n = Integer.parseInt(line);
            Trie trie = new Trie();
            answer = "YES";
            for (int j = 0; j < n; j++) {
                line = br.readLine();
                if (!trie.insert(line)) {
                    answer = "NO";
                }
            }
            System.out.println(answer);
        }

    }
    static class TrieNode{
        Map<Character,TrieNode> children = new HashMap<>();
        boolean isLeaf = false;
    }
    static class Trie{
        TrieNode root = new TrieNode();

        public boolean insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.isLeaf) {
                    return false;
                }
                cur = cur.children.computeIfAbsent(c, key -> new TrieNode());
            }
            if (!cur.children.isEmpty()) {
                return false;
            }
            cur.isLeaf = true;
            return true;
        }
    }
}