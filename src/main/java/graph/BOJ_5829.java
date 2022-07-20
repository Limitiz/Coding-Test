package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_5829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken())+1;
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int matrix[][] = new int[n][2];
        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        char direc[] = new char[m];
        String s = br.readLine();
        for(int i=0; i<m; i++)
            direc[i] = s.charAt(2*i);
        boolean check[] = new boolean[n];

        ArrayList<Integer> list = new ArrayList<>();
        int v = 1; int count = 0;
        check[1] = true; list.add(1);
        for(int i=k; i>0; i--){
            for (int j = 0; j < m; j++) {
                if (direc[j] == 'L')
                    v = matrix[v][0];
                else
                    v = matrix[v][1];
            }
            if(check[v]) break;
            check[v] = true;
            list.add(v);
        }

        for(int i=0; i<list.size(); i++){
            if(list.get(i)==v)
                break;
            count++;
        }

        if(k<=count)
            System.out.println(list.get(k));
        else{
            k -= count;
            k %= list.size()-count;
            System.out.println(list.get(count+k));
        }

        br.close();
    }
}
