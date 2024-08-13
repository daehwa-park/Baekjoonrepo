class Solution {
    
    static int[] seq;
    static int[][] pimap = {{1,1,1},{5,1,1},{25,5,1}}; // [곡][광]
    static int min = Integer.MAX_VALUE;
    
    public void perm(String[] minerals, int[] picks, int cnt, int end) { // 중복순열
        if(cnt == end) {
            int pi = 0;
            
            int index = 0;
            int pcount = 0;
            for(String mine : minerals) {
                if(index == seq.length) break;
                
                if(mine.equals("diamond")) {
                    pcount++;
                    pi += pimap[seq[index]][0];
                } else if(mine.equals("iron")) {
                    pcount++;
                    pi += pimap[seq[index]][1];
                } else {
                    pcount++;
                    pi += pimap[seq[index]][2];
                }
                
                if(pcount == 5) {
                    pcount = 0;
                    index++;
                }
            }
            
            min = Math.min(min, pi);
            
            return;
        }
        
        for(int i = 0; i < 3; i++) {
            if (picks[i] == 0) continue;
            picks[i]--;
            seq[cnt] = i;
            perm(minerals, picks, cnt + 1, end);
            picks[i]++;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
    
        int mlen = minerals.length;
        int plen = picks[0] + picks[1] + picks[2];
        
        seq = new int[plen];
        
        perm(minerals, picks, 0, plen);
        
        return min;
    }
}