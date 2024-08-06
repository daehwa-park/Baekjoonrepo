import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s = "";
        
        while(n / k != 0 || n % k != 0) {
            s = (n % k) + s;
            n /= k;
        }
        // 진수 변환
        // Integer.toString(n,k)로 바로 진수 변환 가능
        
        System.out.print(s);
        
        StringTokenizer st = new StringTokenizer(s, "0");
        while(st.hasMoreTokens()) {
            if(isPrime(Long.parseLong(st.nextToken()))) {
                answer++;
            }
        }
        
        
        return answer;
    }
    
    public boolean isPrime(long num) {
        boolean p = true;
        
        if (num == 1) {
            return false;
        }
        for(int i = 2; i < (long)Math.sqrt(num) + 1 ; i++) {
            if (num % i == 0) {
                p = false;
                break;
            }
        }
        return p;
    }
}