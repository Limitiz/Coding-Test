package dynamicP;

import java.util.Scanner;

public class B15988 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int input[] = new int[t];
        int max = 0;
        for(int i=0; i<t; i++) {
            input[i] = sc.nextInt();
            max = Math.max(max, input[i]);
        }

        long com[] = new long[max];
        com[0]=1; com[1]=2; com[2]=4;
        for(int i=3;i<max;i++) {
            com[i] = com[i - 1] + com[i - 2] + com[i - 3];
            com[i] %= 1000000009;
        }

        for(int i=0; i<t; i++)
            System.out.println(com[input[i]-1]);
        sc.close();
    }
}
