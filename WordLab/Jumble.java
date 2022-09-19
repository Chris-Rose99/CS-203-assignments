/* Chris Rose
203 Assignment 1.0
Dr. Grabowski */
import java.util.*;

public class Jumble {
    // array of strings representing the solutions
    private String [] solutions;
    // array of strings representing the problems
    private String [] problems;

    // constructs Jumble puzzle
    public Jumble(String [] a) {
	solutions = new String [a.length];
	for (int i = 0; i < a.length; i++) {
	    solutions[i] = a[i].toUpperCase();
	}
	problems = new String [solutions.length];
	for (int i = 0; i < solutions.length; i++) {
	    JString wj = new JString(solutions[i]);
	    problems[i] = wj.permute();
	}
    }

    // shows the jumbled words
    public void show() {
	for (int i = 0; i < problems.length; i++) {
	    System.out.println("" + problems[i]);
	}
    }

    // shows the solutions to the problems
    public void solve() {
	System.out.println();
	for (int i = 0; i < problems.length; i++) {
	    System.out.println("" + problems[i] + "-->" + solutions[i]);
	}
    }
}
	    
	
	
