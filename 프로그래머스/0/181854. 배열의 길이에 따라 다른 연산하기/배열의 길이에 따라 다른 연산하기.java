class Solution {
    public int[] solution(int[] arr, int n) {
        int l = arr.length;
        int[] answer = new int[l];
        if (l % 2 == 0) {
            for (int i=0; i<l; i++) {
                if(i % 2 == 1) {
                    answer[i] = arr[i] + n;
                } else {
                    answer[i] = arr[i];
                }
            }
        } else {
            for (int i=0; i<l; i++) {
                if(i % 2 == 0) {
                    answer[i] = arr[i] + n;
                } else {
                    answer[i] = arr[i];
                }
            }
        }
        return answer;
    }
}