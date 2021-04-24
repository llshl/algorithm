package All;

import java.util.HashSet;

class MOVE{
	int a;
	int b;
	public MOVE(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
}

class SLEEP {
    public int solution(String dirs) {
       int answer = 0;       
       int x = 5;
       int y = 5;
       HashSet<String> set = new HashSet<>();
       
       for(int i=0;i<dirs.length();i++) {
    	   
	        if(dirs.charAt(i)=='U') {
	       		if(inBound(x-1,y)) {
	       			String beforeX = String.valueOf(x);
	       			String beforeY = String.valueOf(y);
	       			String afterX = String.valueOf(--x);
	       			String afterY = String.valueOf(y);
	       			String key1 = beforeX+beforeY+afterX+afterY;
	       			String key2 = afterX+afterY+beforeX+beforeY;
	       			if(set.contains(key1)) {
	       				continue;
	       			}
	       			else {
	       				set.add(key1);
	       				set.add(key2);
	       				answer++;
	       			}
	       		}
	       	}
	       	else if(dirs.charAt(i)=='D') {
	       		if(inBound(x+1,y)) {
	       			String beforeX = String.valueOf(x);
	       			String beforeY = String.valueOf(y);
	       			String afterX = String.valueOf(++x);
	       			String afterY = String.valueOf(y);
	       			String key1 = beforeX+beforeY+afterX+afterY;
	       			String key2 = afterX+afterY+beforeX+beforeY;
	       			if(set.contains(key1)) {
	       				continue;
	       			}
	       			else {
	       				set.add(key1);
	       				set.add(key2);
	       				answer++;
	       			}
	       		}
	       	}
			else if(dirs.charAt(i)=='R') {	
				if(inBound(x,y+1)) {
	       			String beforeX = String.valueOf(x);
	       			String beforeY = String.valueOf(y);
	       			String afterX = String.valueOf(x);
	       			String afterY = String.valueOf(++y);
	       			String key1 = beforeX+beforeY+afterX+afterY;
	       			String key2 = afterX+afterY+beforeX+beforeY;
	       			if(set.contains(key1)) {
	       				continue;
	       			}
	       			else {
	       				set.add(key1);
	       				set.add(key2);
	       				answer++;
	       			}
	       		}
			}
			else if(dirs.charAt(i)=='L') {
				if(inBound(x,y-1)) {
	       			String beforeX = String.valueOf(x);
	       			String beforeY = String.valueOf(y);
	       			String afterX = String.valueOf(x);
	       			String afterY = String.valueOf(--y);
	       			String key1 = beforeX+beforeY+afterX+afterY;
	       			String key2 = afterX+afterY+beforeX+beforeY;
	       			if(set.contains(key1)) {
	       				continue;
	       			}
	       			else {
	       				set.add(key1);
	       				set.add(key2);
	       				answer++;
	       			}
	       		}
			}
       }
       return set.size()/2;
   }

	private boolean inBound(int x, int y) {
		if(x>=0&&y>=0&&x<=10&&y<=10) {
			return true;
		}
		return false;
	}
}

public class 방문길이 {

	public static void main(String[] args) {
		SLEEP s = new SLEEP();
		String dirs = "ULURRDLLU";
		System.out.print(s.solution(dirs));

	}

}
