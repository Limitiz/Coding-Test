package bruteForce_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
    static int[] a;
    static int n;
    static int max, min;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        int[] op = new int[4]; //op[0]= +, op[1]= -, op[2]= *, op[3]= /'
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++)
            op[i] = Integer.parseInt(st.nextToken());

        dfs(0,a[0], op);

        System.out.println(max+"\n"+min);
    }

    public static void dfs(int index, int tmp, int[] op){
        if(index == n-1){
            max = max>tmp ? max : tmp;
            min = min<tmp ? min : tmp;
            return;
        }

       if(op[0] !=0) {
           op[0]--;
           dfs(index+1, tmp + a[index+1], op);
           op[0]++;
       }
       if(op[1] != 0){
           op[1]--;
           dfs(index+1, tmp - a[index+1], op);
           op[1]++;
       }
        if(op[2] !=0) {
            op[2]--;
            dfs(index+1, tmp * a[index+1], op);
            op[2]++;
        }
        if(op[3] != 0) {
            op[3]--;
            dfs(index+1, tmp / a[index+1], op);
            op[3]++;
        }
    }
}
