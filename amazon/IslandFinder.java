package amazon;

/*
 * IslandFinder counts the pieces of land in a world of water. 
 * The world is an 100 x 100 grid. 
 */
public class IslandFinder {
	    public static int ARRAY_SIZE = 100;
	   // Status of a square, init to UNKNOWN=0, Mark as VISITED=1 once we visit it
	    public static int UNKNOWN = 0;
	    public static int VISITED = 1;
	    public static int WATER = 3;
	    public static int LAND = 4;
	    int[][] world = null; // To be initialized from outside
		int[][] visited = new int[ARRAY_SIZE][ARRAY_SIZE]; 
		
		int islandCount = 0;  // Number of islands we find. 

		public IslandFinder()  {
			// Initialized the visited array to UNKNOWN 
			for (int i=0; i<ARRAY_SIZE-1; i++) {
				for (int j=0; j<ARRAY_SIZE-1; j++) {
					 visited[i][j] = UNKNOWN; 
				}
			}
		}
		
		void setWorld(int[][] world) throws IllegalArgumentException {
			if (world == null) {
				throw new IllegalArgumentException("Error - world is null");  
				// TODO Also check size
			}
			this.world = world; 
		}
		
		/*
		 * Count the pieces of land in this watery world
		 */
		public void findIslands() {
		// walk the world and find land
		// 0 = water
		// 1 = land
		for (int i=0; i<ARRAY_SIZE-1; i++) { 
		  for (int j=0; j<ARRAY_SIZE-1; j++) {
			//System.out.println("i,j=" + i + ", " + j);
		    if (world[i][j] == WATER) {  // it's water
		      // continue walking
		    } else if (world[i][j] == LAND) {
		    	 if (visited[i][j] == UNKNOWN) {
			    	 // It's land and we haven't been here before, so we found a new island.
			    	 System.out.println("Found land at " + i + ", " + j);
			    	 islandCount++; 
			         exploreIsland( i, j);
		    	 }
		    } else {
		      // log error and throw IslandFinderException
		    }
		  } // end for j
		}  // end for i
	  }
		
		 /*
		  * Walk around the island and mark all land squares as visited. 
		  */
		 private void exploreIsland(int i, int j) { 
		  // System.out.println("isOutOfBounds=" + isOutOfBounds(i,j));
		   if (isOutOfBounds(i,j)) { // Do a bounds check to make sure we didn't walk off the end of the world
			   return ;
		   } else if (visited[i][j] == VISITED) { // check if we've been here before
			   return;
		   } else if (world[i][j] == LAND)  { // this is new land  and not visited yet
			   // mark as visited and continue exploring
			   visited[i][j] = VISITED;
			   // try the 4 compass directions
			   // Check boundary conditions
			   //go left
			   exploreIsland(i-1, j); 
			   // go right
			   exploreIsland(i+1, j);
			   // go up 
			   exploreIsland(i, j+1);
			   // go down
			   exploreIsland(i, j-1);
		   }
		 }	    

		 /*
		  * Returns true if we walked past the edge of the array.
		  * Otherwise false
		  */
		 boolean isOutOfBounds(int i, int j) {
			 if (((0 <= i) && (i < ARRAY_SIZE)) &&  ((0 <= j) && (j < ARRAY_SIZE))) {
				 return false;
			 }
			
			 // If we got here, we're out of bounds
			 return true;
		 }

		 int getIslandCount() {
			 return islandCount; 
		 }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
	  // The world is an NxN grid of land and water. 
	  int[][] world = new int[ARRAY_SIZE][ARRAY_SIZE];
		
      // This main is going to serve as a little test program 
		for (int i=0; i<ARRAY_SIZE; i++) {
			for (int j=0; j<ARRAY_SIZE; j++) {
				 world[i][j] = WATER; 
			}
		}
		
		// Add a few islands 
		world[10][10] = LAND; 
		world[10][11] = LAND; 
		world[11][11] = LAND; 
		
		world[20][20] = LAND; 
		world[20][21] = LAND; 
		world[21][21] = LAND; 
		
		IslandFinder islandFinder = new IslandFinder();
		islandFinder.setWorld(world);
		islandFinder.findIslands();
		
		System.out.println("I found " + islandFinder.getIslandCount() + " islands"); 
		
		
		
	}

}
