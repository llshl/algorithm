package All;

class Keyy {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int len = key.length;
        int[][] expandedLock = createExpandedLock(len,lock);
 
        for(int t=0;t<4;t++) {
        	key = rotateKey(key);
	        for(int x=0;x<=expandedLock.length-len;x++) {
	        	for(int y=0;y<=expandedLock.length-len;y++) {
	        		
	        		for(int i=0;i<len;i++) {
	        			for(int j=0;j<len;j++) {
	        				expandedLock[x+i][y+j] += key[i][j];
	        			}
	        		}
	        		if(isOpen(expandedLock,x,y,len,lock)) {
	        			answer = true;
	        			return answer;
	        		}
	        		for(int i=0;i<len;i++) {
	        			for(int j=0;j<len;j++) {
	        				expandedLock[i+x][j+y] -= key[i][j];
	        			}
	        		}
	        	}
	        }
        }
        return answer;
    }

	private boolean isOpen(int[][] expandedLock, int x, int y, int len, int[][] lock) { 	//확장된 자물쇠 배열에서 key크기만큼만 다 1인지 확인하는것
		boolean flag = true; 
		int lockLen = lock.length;
		for(int i=0;i<lockLen;i++) {	//x부터 key의 크기만큼
			for(int j=0;j<lockLen;j++) {
				if(expandedLock[i+len-1][j+len-1] == 0) {	//한번이라도 0 나오면 false로 
					flag = false;
					break;
				}
				if(expandedLock[i+lockLen-1][j+lockLen-1] == 2) {	//한번이라도 2 나오면 false로
					flag = false;
					break;
				}
			}
			if(flag == false) {
				break;
			}
		}
		return flag;
	}

	private int[][] createExpandedLock(int len, int[][] lock) {
		int expandSize = len*2+lock.length-2;
		int[][] returnArr = new int[expandSize][expandSize];
		for(int i=0;i<lock.length;i++) {
			for(int j=0;j<lock.length;j++) {
				returnArr[i+len-1][j+len-1] = lock[i][j]; 
			}
		}
		return returnArr;
	}

	private int[][] rotateKey(int[][] key) {
		int[][] rotated = new int[key.length][key[0].length];
		 for(int i=0;i<key.length;i++) {
			 for(int j=0;j<key[i].length;j++) {
				 rotated[i][j] = key[j][key.length-1-i];
			 }
		 }
		return rotated;
	}
	public void show(int[][] expandedLock, int len, int[][] lock) {
		for(int i=len-1;i<len-1+lock.length;i++) {
			for(int j=len-1;j<len-1+lock.length;j++) {
				System.out.print(expandedLock[i][j]);
			}
			System.out.println("");
		}
	}
}

public class 자물쇠와열쇠 {

	public static void main(String[] args) {
		Keyy s = new Keyy();
		int[][] key = {{0,0,0},{1,0,0},{0,1,1}};
		int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};
		System.out.println(s.solution(key, lock));
	}

}
