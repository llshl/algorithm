package All;

class LAND {
    public long solution(int[][] land, int P, int Q) {
    	//가장 높은지점과 가장 낮은지점을 범위로 설정하자
    	long answer = Long.MAX_VALUE;
    	int top = 0;
    	int bottom = 1000000001;
    	for(int i=0;i<land.length;i++) {
    		for(int j=0;j<land[0].length;j++) {
    			top = Math.max(land[i][j], top);
    			bottom = Math.min(land[i][j], bottom);
    		}
    	}
    	
    	int left = bottom;
    	int right = top;
    	int mid = -1;
    	
    	while(left<=right) {
    		
    		mid = (left+right)/2;
    		System.out.println("left: "+left);
    		System.out.println("mid: "+mid);
    		System.out.println("right: "+right);
    		int cost1 = getCost(land,mid,P,Q);
    		int cost2 = getCost(land,mid+1,P,Q);
    		System.out.println("cost1: "+cost1);
    		System.out.println("cost2: "+cost2);
    		if(cost1>cost2) {
    			left = mid+1;
    		}else if(cost1<cost2) {
    			right = mid;
    		}else {
    			answer = cost1;
    			break;
    		}
    		if(left==right) {
    			answer = Math.min(cost1, cost2); 
    			break;
    		}
    	}
        return answer;
    }

	private int getCost(int[][] land, int stage, int P, int Q) {
		int stageSum = 0;
		for(int i=0;i<land.length;i++) {
    		for(int j=0;j<land[0].length;j++) {
    			int choice = land[i][j]-stage;
    			if(choice>0) {
    				//땅 삭제
    				stageSum += choice*Q;
    			}
    			else if(choice==0) {
    				//유지
    				continue;
    			}
    			else {
    				
    				//땅추가
    				stageSum += ((-1)*(choice*P));
    			}
    		}
    	}
		return stageSum;
	}
}


public class 지형편집 {

	public static void main(String[] args) {
		LAND s = new LAND();
//		int[][] land = {{4,4,3},{3,2,2},{2,1,0}};
		int[][] land = {{1,2},{2,3}};
		int p = 3;
		int q = 2;
		System.out.println(s.solution(land, p, q));
	}
}
