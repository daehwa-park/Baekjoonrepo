import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        int count = 1; // 몇번째 차례인지
        int num = 2; // 번호
        
        Set<String> set = new HashSet<>();
        set.add(words[0]); //첫번째는 무조건 성공
        
        for(int i = 1; i < words.length; i++) {
            if(words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)){
                answer[0] = num;
                answer[1] = count;
                break;
            }
            else if(set.contains(words[i])) {
                answer[0] = num;
                answer[1] = count;
                break;
            }
            else if(words[i].length() == 1) {
                answer[0] = num;
                answer[1] = count;
                break;
            }
            
            num++;
            set.add(words[i]);
            
            if(num == n + 1) {
                num = 1;
                count++;
            }
            
        }
        
        
        return answer;
    }
}