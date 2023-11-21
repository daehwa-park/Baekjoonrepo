import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        List<Integer> ham = new ArrayList<>();
        
        for(int i = 0; i < ingredient.length; i++) {
            ham.add(ingredient[i]);
            if((ham.size() - 1) >= 3 && ham.get(ham.size() - 1) == 1) {
                //check
                if(ham.get(ham.size() - 2) == 3 && ham.get(ham.size() - 3) == 2 && ham.get(ham.size() - 4) == 1) {
                    answer++;
                    ham.remove(ham.size() - 1);
                    ham.remove(ham.size() - 1);
                    ham.remove(ham.size() - 1);
                    ham.remove(ham.size() - 1);
                }
            }
            
        }
        
        return answer;
    }
}