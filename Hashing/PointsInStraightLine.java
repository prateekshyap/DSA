/*https://practice.geeksforgeeks.org/problems/points-in-straight-line/1#*/

class GfG
    {
    	int maxPoints(int X[],int Y[],int N) {
	    int A[]  = new int[N];
         int B[] = new int[N];
int n=N;
            System.arraycopy( X, 0, A, 0, X.length );
System.arraycopy( Y, 0, B, 0, B.length );
	    HashMap<Double,Integer> hashMap = new HashMap<>();	    
	    if (A == null || B == null)
	        return -1;	    
	    if (n == 0)
	        return 0;
	    int x1, y1, x2, y2;
	    int val;
	    int max = 0;
	    
	    for (int i = 0; i < n; i++) {
	        
	        x1 = A[i];
	        y1 = B[i];
	        hashMap.clear();
	        
	        for (int j = 0; j < n; j++) {
	            
	            if (i == j)
	                continue;
	            
	            x2 = A[j];
	            y2 = B[j];
	            
	            double slope = y2 - y1;
	            int den = x2 - x1;
	            
	            if (den == 0)
	                slope = Double.POSITIVE_INFINITY;
	            else
    	            slope = slope / den;
	            
	            val = 1;
	            
	            if (hashMap.containsKey(slope)) {
	                val = hashMap.get(slope) + 1;
	            }
	            
	            hashMap.put(slope, val);
	            
	        }
	        
	        for (Map.Entry<Double, Integer> entry : hashMap.entrySet()) {
    	        val = entry.getValue();
    	        max = Math.max(max, val);
	        }
	    }
	    
	    return max + 1;
	}
    }

