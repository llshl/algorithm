package All;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Job{
	int requestTime;
	int processTime;
	public Job(int requestTime, int processTime) {
		super();
		this.requestTime = requestTime;
		this.processTime = processTime;
	}
}

class Disk {
    public int solution(int[][] jobs) {
        LinkedList<Job> waiting = new LinkedList<>();
        PriorityQueue<Job> processing = new PriorityQueue<>(new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				return o1.processTime - o2.processTime;	//처리시간 오름차순
			}
        });
        for(int i=0;i<jobs.length;i++) {
        	waiting.add(new Job(jobs[i][0], jobs[i][1])); 
        }
        Collections.sort(waiting, new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				return o1.requestTime - o2.requestTime;	//요청시간 오름차순
			}
        });
        
        int cnt = 0;	//프로세스 개수
        int time = 0;
        int answer = 0;
        while(cnt < jobs.length) {
        	//대기리스트에 뭔가 있고 && 요청이 된 작업을 진행큐에 넣는다
        	while(!waiting.isEmpty() && waiting.peek().requestTime <= time) {
        		processing.add(waiting.poll());
        	}
        	
        	if(!processing.isEmpty()) {
        		Job temp = processing.poll();
        		time += temp.processTime;	//처리시간을 누적
        		answer += time - temp.requestTime;
        		cnt++;	//작업 하나 완료
        	}
        	else {
        		time++;	//
        	}
        }
        		
        return answer/cnt;
    }
}

public class 디스크컨트롤러 {

	public static void main(String[] args) {
		Disk s = new Disk();
		int[][] temp = {{0,3},{1,9},{2,6}};
		System.out.println(s.solution(temp));

	}

}
