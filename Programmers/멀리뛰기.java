package All;

import java.util.Scanner;

class Jump {
    public long solution(int n) {
        final int num = 1234567;
        long[] dp = new long[n];
        dp[0] = 1;
        if(n==1) {
        	return dp[0];
        }
        dp[1] = 2;
        if(n==2) {
        	return dp[1];
        }
        for(int i=2;i<n;i++) {
        	dp[i] = (dp[i-1]%num + dp[i-2]%num)%num;
        }
        return dp[n];
    }
}

public class ¸Ö¸®¶Ù±â {

	public static void main(String[] args) {
		Jump s = new Jump();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(s.solution(N));

	}

}
