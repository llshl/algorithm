package temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 제곱수만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int end = (int)Math.sqrt(10000000);
		boolean[] prime = new boolean[end+1];
		List<Integer> list = new ArrayList<>();
		for(int i=2;i<=end;i++) {
			for(int j=i*i;j<=end;j+=i) {
				prime[j] = true;	//true면 소수 아님
			}
		}
		for(int i=2;i<=end;i++) {
			if(!prime[i]) {		//소수인것만 list에 넣음
				list.add(i);
			}
		}
		//10000000의 제곱근까지의 소수를 list에 넣음
		int T = sc.nextInt();
	    for(int t=1;t<=T;t++){
	        int N = sc.nextInt();
	        long answer = 1;
	        for(int a : list) {
	        	//10000000제곱근까지 소수를 다 볼필요 없으므로 N보다 a가 커지면 끝
	        	if(a>N || N==1) {
	        		break;
	        	}
	        	//어떤 소수로 나누어 떨어지면 몇번 나눌수있는지 확인
	        	int cnt = 0;
        		while(N%a==0) {
        			cnt++;
        			N = N/a;
        		}
        		//나눈횟수가 홀수번이면 한번더 나눌수있어야 제곱수가 되므로 해당 수 곱하고 다음 반복
        		if(cnt%2==1) {
        			answer *= a;
        		}
        	}
	        if(N>1) {
	        	answer *= N;
	        }
	        System.out.println("#"+t+" "+answer);
        }
	}
}
