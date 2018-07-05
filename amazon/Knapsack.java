package com.amazon;


// Solve the knapsack problem using dynamic programming

public class Knapsack {
 
	int best = 0;
	
	public Knapsack(int n) {
		//table = new int[n+1][n+1];
	}
		
	public int fillKnapSack(int weight, int[] wt, int[] val, int n) {
		
		int table[][] = new int[n+1][weight+1];
		
		for (int i=1; i<=n; i++) {
			for (int w=0; w<=weight; w++) {
				System.out.println(i + " " + w + " wgt" + weight +  " wt:"  + wt[i-1] );

				if ((i==0) || (w==0)) {
					table[i][w] = 0;
				} else if (wt[i-1] <= w){
				    // consider case with i and without i
				    // first include
					int a = table[i-1][w - wt[i-1]];
					int b = table[i-1][w];
					int c = val[i-1];
				    table[i][w] = Math.max(c + a, b);
			    } else {
			    	table[i][w] = table[i-1][w];
			    }
			} // end for w
	   } // end for i
	   return table[n][weight];
	} // end fillKnapsack
	
	public int knapSack(int W, int wt[], int val[], int n)
	{
		int i, w;
		int K[][] = new int[n+1][W+1];
		
		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++)
		{
			for (w = 0; w <= W; w++)
			{
				if (i==0 || w==0)
					K[i][w] = 0;
				else if (wt[i-1] <= w)
					K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]], K[i-1][w]);
				else
					K[i][w] = K[i-1][w];
			}
		}
		
		return K[n][W];
	}
	
	int findBest() {
		return best; 
	}
	public static void main(String[] args) {
		int weight = 50;
		int[] val = {60, 100, 120};
		int[] wt = {10,20,30};
		int n = 3; 
		Knapsack ks = new Knapsack(n);
		int result = ks.fillKnapSack(weight, wt, val, n); 
		System.out.println(result);
		
	}

}
