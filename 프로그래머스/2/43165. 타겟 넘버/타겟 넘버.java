class Solution {
    static int ans = 0;
    static int[] numarr;
    
    static public void dfs(int cnt, int num, int target, int end) {
        if(cnt == end) {
            if(num == target) {
                ans++;
            }
            return;
        }
        
        dfs(cnt + 1, num - numarr[cnt], target, end);
        dfs(cnt + 1, num + numarr[cnt], target, end);
    }
    
    public int solution(int[] numbers, int target) {
        numarr = numbers;
        
        dfs(0, 0, target, numbers.length);
        
        return ans;
    }
}