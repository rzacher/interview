package com.amazon;

public class DPCoinChange {
	public DPCoinChange() {
		
	}
	
	public int makeChange(int amount, int[] val) {
		int n = val.length;
		
		int[][] solution = new int[n+1][amount+1];
		
		for (int i=1; i<=n; i++) {
			for (int cents=0; cents<=amount; cents++) {
				if ( ((i-1) == 0) || (cents==0)) {
					solution[i-1][cents] = 0;
				}
				
				if (val[i-1] > amount) { // can't use this coin
					solution[i-1][cents] = 0;
				} else {
				   if (val[i-1] < cents) {
					   solution[i][cents] = 1 + solution[i-1][cents-val[i-1]]
						   + solution[i-1][cents];
				   } else {
					   solution[i][cents] = solution[i-1][cents];
				   }
				}
				System.out.println(n + " " + cents + " " +  solution[i][cents]);
			}	
		}
		return solution[n][amount];
	} // end makeChange
	
	
	
	public static void main(String[] args) {
		int[] val = {1,2,3};
		int amount = 5; 
		DPCoinChange dp = new DPCoinChange();
		int result = dp.makeChange(amount, val);
		System.out.println(result);
		
		
	}

}
