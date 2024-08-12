class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int s = 0;
        int e = 0;
        int sum = sequence[0];
        int len = sequence.length;
        
        while(s != sequence.length) {
            if(sum < k && e == sequence.length - 1) {
                break;
            }
            else if(sum < k) {
                e++;
                sum += sequence[e];
            }
            else if(sum > k) {
                sum -= sequence[s];
                s++;
            }
            else if(sum == k){
                if(e - s < len) {
                    answer[0] = s;
                    answer[1] = e;
                    len = e - s;
                }
                
                if(e == sequence.length - 1) {
                    break;
                }
                else {
                    e++;
                    sum += sequence[e];
                }
            }
        }
        
        return answer;
    }
}