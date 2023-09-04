class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")) {
            int ones = 0;
            answer[0]++;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') {
                    answer[1]++;
                }else  {
                    ones++;
                }
            }
            
            s = Integer.toBinaryString(ones);
        }
        
        return answer;
    }
}