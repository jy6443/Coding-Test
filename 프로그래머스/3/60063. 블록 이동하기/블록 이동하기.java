import java.util.*;
class Solution {
    public int[][] dir;
    public int N;
    public int solution(int[][] board) {
        int answer = -1;
        dir = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
        
        N = board.length;
        
        Set<String> visit = new HashSet<>();
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0,0,0,1,0}); // y,x,y,x,time
        visit.add("0,0,0,1");

        while(!q.isEmpty()){
            int[] out = q.remove();
            int ay = out[0], ax = out[1], by = out[2], bx = out[3], time = out[4];
            // System.out.println(ay+","+ ax+ "|" + by +","+ bx);
            
            if((ay == N-1 && ax == N-1) || (by == N-1 && bx == N-1)){
                answer = time;
                break;
            }
            
            // 동서남북
            for(int[] d : dir){
                int any = ay + d[0], anx = ax + d[1];
                int bny = by + d[0], bnx = bx + d[1];
                if(check(any,anx,board) && check(bny,bnx,board)){
                    String v = any + "," + anx + "," + bny + "," + bnx;
                    if(!visit.contains(v)) {
                        visit.add(v);
                        q.add(new int[] {any,anx,bny,bnx,time+1});
                    }
                    
                }
            }
            // 대각선
            if(ay == by) { // 가로
                for(int i : new int[] {-1,1}){
                    if(check(ay+i,ax,board) && check(by+i,bx,board)){
                        String v1 = (ay+i) + "," + ax + "," + ay + "," + ax;
                        String v2 = (by+i) + "," + bx + "," + by + "," + bx;
                        if(!visit.contains(v1)){
                            visit.add(v1);
                            q.add(new int[] {ay,ax,ay+i,ax,time+1});
                        }
                        if(!visit.contains(v2)){
                            visit.add(v2);
                            q.add(new int[] {by,bx,by+i,bx,time+1});
                        }
                    }
                }
            }
            if(ax == bx) { // 세로
                for(int i : new int[] {-1,1}){
                    if(check(ay,ax+i,board) && check(by,bx+i,board)){
                        String v1 = ay + "," + (ax+i) + "," + ay + "," + ax;
                        String v2 = by + "," + (bx+i) + "," + by + "," + bx;
                        if(!visit.contains(v1)){
                            visit.add(v1);
                            q.add(new int[] {ay,ax+i,ay,ax,time+1});
                        }
                        if(!visit.contains(v2)){
                            visit.add(v2);
                            q.add(new int[] {by,bx+i,by,bx,time+1});
                        }
                    }
                }
            }
        }
        return answer;
    }
    public boolean check(int y, int x, int[][] board){
        return 0 <= y && y < N && 0 <= x && x < N && board[y][x] == 0;
    }
}
        
    