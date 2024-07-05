class Solution {
    public String solution(String new_id) {
        // 1단계
        new_id = new_id.toLowerCase();
        
        StringBuilder sb = new StringBuilder();
        // 2단계
        for (char c : new_id.toCharArray()) {
            if (Character.isLetterOrDigit(c) || c == '-' || c == '_' || c == '.'){
                sb.append(c);
            }
        }
        // 3단계
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i) == '.' && sb.charAt(i - 1) == '.') {
                sb.deleteCharAt(i);
                i--;
            }
        }
        // 4단계
        if (sb.length() > 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }
        // 5단계
        if (sb.length() == 0) {
            sb.append("a");
        }
        // 6단계
        if (sb.length() >= 16) {
            sb.setLength(15);
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }
        // 7단계
        while (sb.length() < 3) {
            sb.append(sb.charAt(sb.length() - 1));
        }
        return sb.toString();
    }
}