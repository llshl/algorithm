package Greedy;

public class 주식가격 {

	public static void main(String[] args) {
		int[] prices = {1,2,3,2,3};
        int[] answer = new int[prices.length];
        int cnt=0;
        for(int i=0;i<prices.length;i++){
            for(int j=i;j<prices.length;j++) {
            	if(j==prices.length-1) {
            		break;
            	}
                if(prices[i]>prices[j]){
                    break;
                }
                cnt++;
            }
            answer[i] = cnt;
            cnt = 0;
        } 
        for(int i=0;i<5;i++) {
        	System.out.println(answer[i]);
        }
	}
}
