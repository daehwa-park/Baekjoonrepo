class Solution {
    static public boolean check(char[][] nboard, int ocnt, int xcnt) {
        int[][] win = {{0,4,8}, {0,1,2}, {0,3,6}, {2,5,8}, {6,7,8},
                       {2,4,6}, {1,4,7}, {3,4,5}};
        boolean owin = false;
        boolean xwin = false;
        for(int i = 0; i < win.length; i++) {
            if(nboard[win[i][0] / 3][win[i][0] % 3] == 'O' &&
              nboard[win[i][1] / 3][win[i][1] % 3] == 'O' &&
              nboard[win[i][2] / 3][win[i][2] % 3] == 'O') {
                owin = true;
            }
            if(nboard[win[i][0] / 3][win[i][0] % 3] == 'X' &&
              nboard[win[i][1] / 3][win[i][1] % 3] == 'X' &&
              nboard[win[i][2] / 3][win[i][2] % 3] == 'X') {
                xwin = true;
            }
        }
        if(owin && xwin) {
            return false;
        }
        else if(ocnt > xcnt && !owin && xwin) {
            return false;
        }
        else if(ocnt == xcnt && owin && !xwin) {
            return false;
        }
        
        return true; 
    }
    
    public int solution(String[] board) {
        int answer = 0;
        
        char[][] nboard = new char[board.length][];
        for(int i = 0; i < board.length; i++) {
            nboard[i] = board[i].toCharArray();
        }
        
        // o가 먼저 놓기 때문에 무조건 o의 개수가 같거나 많아야 한다 차이 1
        // 개수가 3 : 2 까지 상관없음
        // 3이상은 확인 필요
        
        int ocnt = 0;
        int xcnt = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(nboard[i][j] == 'O') {
                    ocnt++;
                }
                else if(nboard[i][j] == 'X') {
                    xcnt++;
                }
            }
        }
        if(ocnt < xcnt || ocnt - xcnt > 1) {
            answer = 0;
        }
        else {
            if(check(nboard, ocnt, xcnt)) {
                answer = 1;
            }
        }
        
        return answer;
    }
}