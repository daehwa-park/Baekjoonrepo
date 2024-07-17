class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int i = 1; i <= yellow / 2 + 1; i++) {
            if (yellow % i == 0) {
                int w = yellow / i;
                
                if (((i + 2) * 2) + ((w + 2) * 2) - 4 == brown) {
                    answer[0] = w + 2;
                    answer[1] = i + 2;
                    break;
                }
            }
        }
        
        return answer;
    }
}