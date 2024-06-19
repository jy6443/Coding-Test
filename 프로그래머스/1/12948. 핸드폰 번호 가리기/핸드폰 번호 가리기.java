class Solution {
    public String solution(String phone_number) {
        String number =  phone_number.substring(phone_number.length()-4);
        String star = "";
        for(int i=0; i<phone_number.length()-4;i++){
            star += '*';
        }
        return star+number;
    }
}