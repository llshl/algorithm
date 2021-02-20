package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

class Stage{
	private int index;
	private int value;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Stage(int index, int value) {
		super();
		this.index = index;
		this.value = value;
	}
	
}

public class Å¸°Ù³Ñ¹ö {

	public static Queue<Stage> save = new LinkedList<>();
	public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		int answer = 0;
		//bfs(numbers,target);
		Queue<Stage> q = new LinkedList<>();
		q.add(new Stage(0,numbers[0]));
		q.add(new Stage(0,numbers[0]*(-1)));
		while(!q.isEmpty()) {
			Stage stage = q.poll();
			
			int now = stage.getIndex();
			int value = stage.getValue();
			if(now == numbers.length-1) {
				if(value == target) {
					answer++;
				}
				continue;
			}
			q.add(new Stage(now+1, value+numbers[now+1]));
			q.add(new Stage(now+1, value+numbers[now+1]*(-1))); 
		}
		
		System.out.println(answer);
	}
}
