package stack;

import java.io.*;
import java.util.Stack;

public class BOJ_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String s = br.readLine();
            if (s.charAt(0) == '.') break;
            Stack<Character> balance = new Stack<>();
            boolean flag = true;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[')
                    balance.push(c);
                else if (c == ')') {
                    if(balance.isEmpty() || balance.peek() != '('){
                        flag = false;
                        break;
                    }
                    else balance.pop();
                }
                else if(c==']'){
                    if (balance.isEmpty() || balance.peek() !=  '['){
                        flag = false;
                        break;
                    }
                    else balance.pop();
                }
            }
            if(balance.isEmpty() && flag)
                System.out.println("yes");
            else
                System.out.println("no");
        }
        br.close();
    }
}
