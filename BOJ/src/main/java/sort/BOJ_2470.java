package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2470 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] ph = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            ph[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(ph, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        int sum = Integer.MAX_VALUE;
        int index = 1;
        for(int i=1; i<n; i++) {
            if(sum > Math.abs(ph[i]+ph[i-1])){
                sum = Math.abs(ph[i]+ph[i-1]);
                index = i;
            }
        }

        if(ph[index]>ph[index-1])
            System.out.println(ph[index-1]+" "+ph[index]);
        else
            System.out.println(ph[index]+" "+ph[index-1]);
    }
}
