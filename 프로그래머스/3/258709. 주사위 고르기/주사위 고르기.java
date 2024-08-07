import java.util.*;

class Solution {
    static List<Integer> diceA;
    static List<Integer> diceB;
    static boolean[] d;
    static int[][] dicee;
    static int max;
    static int[] ans;
    
    static public void perm(List<Integer> sumDice, List<Integer> dice, int sum, int cnt, int end) {
        if(cnt == end) {
            sumDice.add(sum);
            return;
        }
        
        for(int i = 0; i < 6; i++) {
            perm(sumDice, dice, sum + dicee[dice.get(cnt)][i], cnt + 1, end);
        }
    }
    
    static public void comb(int start, int end, int len, int cnt) {
        if (cnt == end) {
            diceA.clear();
            diceB.clear();
            //계산
            for (int i = 0; i < len; i++) {
                if(d[i]) {
                    diceA.add(i);
                }
                else {
                    diceB.add(i);
                }
            }
            // 주사위 나누기 끝
            List<Integer> sumA = new ArrayList<>();
            List<Integer> sumB = new ArrayList<>();
            
            perm(sumA, diceA, 0, 0, end);
            perm(sumB, diceB, 0, 0, end);
            
            sumA.sort(Comparator.reverseOrder());
            sumB.sort(Comparator.reverseOrder());
            
            int count = 0;
            for(int i = 0; i < sumA.size(); i++) {
                for(int j = 0; j < sumB.size(); j++) {
                    if(sumA.get(i) > sumB.get(j)) {
                        count += sumB.size() - j;
                        break;
                    }
                }
            }
            
            if(count > max) {
                max = count;
                for(int i = 0; i < diceA.size(); i++) {
                    ans[i] = diceA.get(i) + 1;
                }
            }
            
            return;
        }
        
        for(int i = start; i < len; i++) {
            d[i] = true;
            comb(i + 1, end, len, cnt + 1);
            d[i] = false;
        }
    }
    
    public int[] solution(int[][] dice) {
        int[] answer = {};
        
        int len = dice.length;
        diceA = new ArrayList<>();
        diceB = new ArrayList<>();
        d = new boolean[len];
        max = 0;
        ans = new int[len / 2];
        
        dicee = dice;
        
        comb(0, len / 2, len, 0);
        
        return ans;
    }
}