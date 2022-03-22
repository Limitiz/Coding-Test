package dynamicP;

import java.io.*;

public class BOJ_2670 {
	public static void main(String[] args) throws IOException{
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
        double max = 0;
		
		double[] sequence = new double[n];
		for(int i=0; i<n; i++) sequence[i] = Double.parseDouble(br.readLine());

		//dp
		for(int i = 1; i < n; i++) {
			sequence[i] = Math.max(sequence[i], sequence[i-1] * sequence[i]);
			max = Math.max(max, sequence[i]);
		}
		System.out.printf("%.3f", max);
		
	}
}
