package All;


class KT {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int now = 1;		//현재위치 인덱스
        int index  = 0;	//기지국 배열 인덱스
        while(true) {
        	if(now > n) {
        		break;
        	}
        	if(index < stations.length && now >= stations[index]-w) {
        		now = stations[index]+w+1;
        		index++;
        	}
        	else{	//마지막 기지국을 지난 후부터는 그냥 계속 2w+1씩만큼 이동만 하면 된다
        		now += (2*w+1);
        		answer++;
        	}
        }
        return answer;
    }
}

public class 기지국설치 {

	public static void main(String[] args) {
		KT s = new KT();
		int n = 16;
		int[] stations = {9};
		int w = 2;
		System.out.println(s.solution(n, stations, w));
	}

}
