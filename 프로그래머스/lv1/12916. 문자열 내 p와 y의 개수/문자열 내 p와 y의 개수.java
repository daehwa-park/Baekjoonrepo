class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int nump = 0;
        int numy = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'P' || c == 'p') {
                nump++;
            }
            else if(c == 'Y' || c == 'y') {
                numy++;
            }
        }
        
        if(nump != numy) {
            answer = false;
        }

        return answer;
    }
}