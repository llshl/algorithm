package All;

class 학교간다 {
    public int solution(int m, int n, int[][] puddles) {
    	int[][] dp = new int[n+1][m+1];
    	int num = 1000000007;
    	for(int i=0;i<=n;i++) {
    		for(int j=0;j<=m;j++) {
    			dp[i][j] = 0;
    		}
    	}
    	for(int i=0;i<puddles.length;i++) {
    		dp[puddles[i][1]][puddles[i][0]] = -1;
    	}
    	dp[1][1] = 1;
    	for(int i=1;i<=n;i++) {
    		for(int j=1;j<=m;j++) {
    			if(dp[i][j] != -1) {
    				if(dp[i-1][j] != -1) {
    					dp[i][j] += dp[i-1][j]%num;
    				}
    				if(dp[i][j-1] != -1) {
    					dp[i][j] += dp[i][j-1]%num;
    				}
    			}
    		}
    	}
    	for(int i=1;i<=n;i++) {
    		for(int j=1;j<=m;j++) {
    			System.out.print(dp[i][j]+"  ");
    		}
    		System.out.println("");
    	}
		return dp[n][m];
    }
}

public class 등굣길 {

	public static void main(String[] args) {
		학교간다 s = new 학교간다();
		int[][] water = {{2,2}};
		System.out.println(s.solution(4, 3, water));
	}
}
