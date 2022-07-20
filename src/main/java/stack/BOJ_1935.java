package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        double val[] = new double[n];
        for(int i=0; i<n; i++)
            val[i] = Double.parseDouble(br.readLine());

        Stack<Double> operand = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'A')
                operand.push(val[c-'A']);
            else{
                double num1 = operand.pop();
                double num2 = operand.pop();
                if(c=='+')
                    operand.push(num2+num1);
                else if(c=='-')
                    operand.push(num2-num1);
                else if(c=='*')
                    operand.push(num2*num1);
                else if(c=='/')
                    operand.push(num2/num1);
            }
            System.out.println(operand.peek());
        }

        System.out.printf("%.2f",operand.pop());
        br.close();
    }
}
