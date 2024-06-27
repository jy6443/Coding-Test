class Solution {
    public long solution(int price, int money, int count) {
        long amount = (long)price * (long)count * ((long)count + 1) / 2 - (long)money;
        if (amount < 0) {
            amount = 0;
        }
        return amount;
    }
}