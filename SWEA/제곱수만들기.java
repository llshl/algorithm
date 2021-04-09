package temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ����������� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int end = (int)Math.sqrt(10000000);
		boolean[] prime = new boolean[end+1];
		List<Integer> list = new ArrayList<>();
		for(int i=2;i<=end;i++) {
			for(int j=i*i;j<=end;j+=i) {
				prime[j] = true;	//true�� �Ҽ� �ƴ�
			}
		}
		for(int i=2;i<=end;i++) {
			if(!prime[i]) {		//�Ҽ��ΰ͸� list�� ����
				list.add(i);
			}
		}
		//10000000�� �����ٱ����� �Ҽ��� list�� ����
		int T = sc.nextInt();
	    for(int t=1;t<=T;t++){
	        int N = sc.nextInt();
	        long answer = 1;
	        for(int a : list) {
	        	//10000000�����ٱ��� �Ҽ��� �� ���ʿ� �����Ƿ� N���� a�� Ŀ���� ��
	        	if(a>N || N==1) {
	        		break;
	        	}
	        	//� �Ҽ��� ������ �������� ��� �������ִ��� Ȯ��
	        	int cnt = 0;
        		while(N%a==0) {
        			cnt++;
        			N = N/a;
        		}
        		//����Ƚ���� Ȧ�����̸� �ѹ��� �������־�� �������� �ǹǷ� �ش� �� ���ϰ� ���� �ݺ�
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
