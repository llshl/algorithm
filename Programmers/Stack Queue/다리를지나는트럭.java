package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

class Truck{
	private int time;
	private int weight;
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Truck(int time, int weight) {
		super();
		this.time = time;
		this.weight = weight;
	}
	
}

class Solution2 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> q = new LinkedList<>();
        Queue<Truck> bridge = new LinkedList<>();
        for(int i=0;i<truck_weights.length;i++) {
        	q.add(new Truck(0,truck_weights[i])); 	//time이랑 bridge_length랑 같으면 다리통과됨
        }
        int totalWeight = 0;
        
       	while(!q.isEmpty()) {
       		if(!bridge.isEmpty() && bridge.peek().getTime() == bridge_length) {	//선두의 트럭이 다리를 다 건넜다면
	       		Truck truck = bridge.poll();									//다리에서 트럭 poll
	       		totalWeight -= truck.getWeight();								//나간 트럭의 무게만큼 현재 무게 빼줌
	       	}
	       	if(totalWeight + q.peek().getWeight() <= weight) {					//무게가 여유있어서 다리에 더 진입할수있다면
	       		Truck truck = q.poll();											//대기큐(q)에서 하나빼서 다리큐에 넣음
	       		totalWeight += truck.getWeight();
	       		bridge.add(truck);	//다리 진입
	       	}
	       	for(int i=0;i<bridge.size();i++) {		//다리위에있는 모든 트럭의 거리를 1씩 늘린다
	       		Truck truck = bridge.poll();		//poll해서 값 수정 후 다시 add(앞에서 빼고 뒤로 다시 넣기)
	       		truck.setTime(truck.getTime()+1);
	       		bridge.add(truck);
	       	}
	       answer++;
        }
       	//q가 비는순간 탈출하기에 마지막으로 다리에 진입한 차가 빠져나오는데 걸리는 시간인 bridge_length를 더함
        return answer+bridge_length;
    }
}

public class 다리를지나는트럭 {

	//+1해줘야 다리에서 완전히나간다
	public static void main(String[] args) {
		Solution2 solution = new Solution2();
//		int bridge_length = 2;
//		int weight = 10;
//		int[] truck_weights = {7,4,5,6};
		int bridge_length = 5;
		int weight = 5;
		int[] truck_weights = {2,2,2,2,1,1,1,1,1};
		int answer = -1;
		answer = solution.solution(bridge_length,weight,truck_weights);
		System.out.println(answer);
	}

}
