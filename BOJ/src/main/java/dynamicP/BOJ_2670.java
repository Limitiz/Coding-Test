package dynamicP;

import java.io.*;

public class BOJ_2670 {
	static double[] sequence;
	static double max = 0;
	static int n;
	
	public static void main(String[] args) throws IOException{
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		sequence = new double[n];
		for(int i=0; i<n; i++) sequence[i] = Double.parseDouble(br.readLine());

		//dp
		dp(0,1);
		System.out.printf("%.3f", max);
		
	}
	
	public static void dp(int i, double result) {
		if(i == n) return;
		
		max = Math.max(max, result);
		dp(i+1, 1); //안곱하고 넘어감
		dp(i+1, result*sequence[i]); //곱하고 넘어감
	}
}
