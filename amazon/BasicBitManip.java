package amazon;

public class BasicBitManip {
	public static void main(String[] args) {
		BasicBitManip bbm = new BasicBitManip();
        String result = bbm.intToBinary(5);
		System.out.println(result);
		
		int a = 1;
		int b = 1; 
		int intResult = a & b;
		System.out.println(intResult);
		
		a = 0;
		b = 1;
		intResult = a | b;
		System.out.println(intResult);
		
		intResult = b << 3; 
		System.out.println(intResult);
		
		a = 64;
		System.out.println(a);		
		intResult = a >> 3;
		System.out.println(intResult);
		
		// set a given bit to 1
		a = 0; 
		a = a | (1 << 1);
		System.out.println(a);
		System.out.println(bbm.intToBinary(a));
		
		// set a given bit to 0
		a = 15;  // first 4 bits
		System.out.println(bbm.intToBinary(a));
		a = a & ~(1 << 1);
		System.out.println(bbm.intToBinary(a));
		
		// Determine if a bit is set
		a = 15;  // first 4 bits
		if ( (a & ( 1 << 2)) != 0  ) {
			System.out.println("bit 3 is set");
		} else {
			System.out.println("bit 3 is not set");
		}
		
	}
	
	public BasicBitManip() {}
	
	public String intToBinary( int theInt) {
		String ret = "";
	
		for( int i = 31; i >= 0; i-- ) {
			if( (theInt & (1 << i)) != 0 ) {
			ret += "1"; // the ith bit is set
			} else {
			ret += "0"; // the ith bit is NOT set
			}
			if ( i % 8 == 0) { ret += " "; 
			}
		}
			return ret;
	}
	

}
