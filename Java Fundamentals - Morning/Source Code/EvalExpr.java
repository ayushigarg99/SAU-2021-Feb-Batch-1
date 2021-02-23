package Assignments;

import java.util.Scanner;

public class EvalExpr {
	public static void main(String args[]) {
		
	    System.out.println(eval("-5+8*6"));
	    System.out.println(eval("(55+9)%9"));
	    System.out.println((int)(eval("20+ -3*5/8")));
	    System.out.println(eval("5+15/3*2-8%3"));
	    
	}
	
public static double eval(final String str) {
	    return new Object() {
	        int pos = -1, ch;

	        void nextChar() {
	            ch = (++pos < str.length()) ? str.charAt(pos) : -1;
	        }

	        boolean select(int charToSelect) {
	            while (ch == ' ') nextChar();
	            if (ch == charToSelect) {
	                nextChar();
	                return true;
	            }
	            return false;
	        }

	        double eval() {
	            nextChar();
	            double x = evalExpression();
	            return x;
	        }
	        
	        double evalExpression() {
	            double x = evalTerm();
	            for (;;) {
	                if      (select('+')) x += evalTerm(); // addition
	                else if (select('-')) x -= evalTerm(); // subtraction
	                else return x;
	            }
	        }

	        double evalTerm() {
	            double x = evalFactor();
	            for (;;) {
	                if      (select('*')) x *= evalFactor(); 
	                else if (select('/')) x /= evalFactor();
	                else if (select('%')) x %= evalFactor();
	                else return x;
	            }
	        }

	        double evalFactor() {
	            if (select('+')) return evalFactor(); 
	            if (select('-')) return -evalFactor(); 

	            double x;
	            int startPos = this.pos;
	            if (select('(')) { // parentheses
	                x = evalExpression();
	                select(')');
	            } else if ((ch >= '0' && ch <= '9') || ch == '.') {
	                while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
	                x = Double.parseDouble(str.substring(startPos, this.pos));
	            } else {
	                throw new RuntimeException("Unexpected: " + (char)ch);
	            }
	            return x;
	        }
	    }.eval();
	}
}