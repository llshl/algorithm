package Graph;

import java.util.Arrays;
class Solution2 {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int INF = 987654321;
        int win,lose;
        int[][] fight = new int[n+1][n+1];
        
        for(int i=1;i<=n;i++) {
        	Arrays.fill(fight[i], INF); 
        }
        
        for(int i=0;i<fight.length;i++) {
        	fight[i][i] = 0;
        }
   
//        for(int i=0;i<n;i++) {
//        	fight[results[i][0]][results[i][1]] = 1;
//        }
        for(int[] result:results){
            win=result[0];
            lose=result[1];
            fight[win][lose]=1;
        }
        
        for(int k=1;k<=n;k++) {
        	for(int i=1;i<=n;i++) {
        		for(int j=1;j<=n;j++) {
        			if(fight[i][j] > fight[i][k] + fight[k][j]) {	//대충 끊어진 애들을 어디 거쳐서 이어주는 작업
        				fight[i][j] = fight[i][k] + fight[k][j];
        			}
        		}
        	}
        }
       
        
        boolean[] flag = new boolean[n+1];
        Arrays.fill(flag, true);
        for(int i=1;i<=n;i++) {
        	for(int j=1;j<=n;j++) {
        		if(i==j) {
        			continue;
        		}
        		if(fight[i][j] == INF && fight[j][i] == INF) {
        			flag[i] = false;
        			break;
        		}
        	}
        }
        
        for(int i=1;i<flag.length;i++) {
        	if(flag[i]) {
        		answer++;
        	}
        }
        return answer;
    }
}

public class 순위 {

	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int n = 5;
		int[][] results = {{3,5},{4,2},{4,5},{5,1},{5,2}};
		int answer = sol.solution(n, results);
		System.out.println(answer);

	}

}
