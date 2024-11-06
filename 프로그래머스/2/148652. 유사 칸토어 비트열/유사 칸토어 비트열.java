class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        
        for(long i = l - 1; i < r; i++) {
            if(i % 5 == 2 || i / 5 == 2) {
                continue;
            }
            boolean b = false;
            long tmp = i;
            while(tmp / 5 > 5) {
                tmp /= 5;
                if(tmp % 5 == 2 || tmp / 5 == 2) {
                    b = true;
                    break;
                }
            }
            
            if(!b) {
                answer++;
            }
            
        }
        
        return answer;
    }
}