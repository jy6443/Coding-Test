import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = 0;
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            trie.insert(line);
        }
        System.out.println(trie.answer());
    }
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }
    static class Trie {
        TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                cur = cur.children.computeIfAbsent(c, k -> new TrieNode());
            }
        }
        public int count(TrieNode node) {
            if (node.children.isEmpty()) {
                return 1;
            }
            int cnt = 0;
            for (TrieNode child : node.children.values()) {
                cnt += count(child);
            }
            return cnt;
        }
        public int answer() {
            return count(root);
        }
    }
}