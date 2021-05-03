package All;


class KT {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int now = 1;		//������ġ �ε���
        int index  = 0;	//������ �迭 �ε���
        while(true) {
        	if(now > n) {
        		break;
        	}
        	if(index < stations.length && now >= stations[index]-w) {
        		now = stations[index]+w+1;
        		index++;
        	}
        	else{	//������ �������� ���� �ĺ��ʹ� �׳� ��� 2w+1����ŭ �̵��� �ϸ� �ȴ�
        		now += (2*w+1);
        		answer++;
        	}
        }
        return answer;
    }
}

public class ��������ġ {

	public static void main(String[] args) {
		KT s = new KT();
		int n = 16;
		int[] stations = {9};
		int w = 2;
		System.out.println(s.solution(n, stations, w));
	}

}
