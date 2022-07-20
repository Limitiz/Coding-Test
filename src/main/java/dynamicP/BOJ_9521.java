package dynamicP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9521 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] source = br.readLine().toCharArray();
        char[] target = br.readLine().toCharArray();
        int max = 0;
        int index = 0;

        if(source[0] == target[0]){max = 1; index = 1;}
        else index = 0;

        for(int i=1; i<source.length; i++){
            for(int j=index; j<=i; j++){
                if(target[i] == source[j]){
                    max++;
                    index = j+1;
                    break;
                }
            }
        }

        System.out.println(max);
    }

}
