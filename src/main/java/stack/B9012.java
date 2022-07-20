package stack;

import java.io.*;
import java.util.Stack;

public class B9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        while(n-->0) { //n-->0 = (n--;) + (n > 0;)
            String s = reader.readLine();
            Stack<Character> vps = new Stack<>();
            boolean flag = true;
            for(int i=0; i<s.length(); i++)
            if (s.charAt(i) == '(')
                vps.push('(');
            else if(s.charAt(i) == ')'){
                if (vps.empty() || vps.peek() == ')') {
                    flag = false;
                    break;
                }
                else
                    vps.pop();
            }
            if(flag && vps.empty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}