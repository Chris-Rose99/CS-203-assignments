/*
    CIS 203 Computer Science II
    NgramMain.java
    Client code for NgramSolver class
    Updated by L. Grabowski 30 March 2019
*/

import java.util.*;
import java.io.*;

public class NgramMain {
    public static final int LINE_BREAK = 65;

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to the CSE143 Ngram Solver.  You specify");
        System.out.println("the file to sample, the ngram size, and the");
        System.out.println("desired number of characters of output.");
        System.out.println();

        // open the text file
        Scanner console = new Scanner(System.in);
        System.out.print("What is the name of the text file? ");
        Scanner input = new Scanner(new File(console.nextLine()));
        String text = "";
        while (input.hasNext())
            text += " " + input.next();

        // construct solver object
        System.out.print("What value of n do you want to use? ");
        int n = console.nextInt();
        NgramSolver solver = new NgramSolver(n, text.toString());

        // produce random output
        System.out.print("How many characters of output do you want? ");
        int length = console.nextInt();
        System.out.println();
        generateText(solver, length);
    }

    // Parameter: solver -- NgramSolver object,
    //            length -- the length of the generated text, in characters
    // Precondition: solver and length exist, length has value > 0
    public static void generateText(NgramSolver solver, int length) {
        String current = "";
        int column = 0;
        int total = 0;
        boolean done = false;
        while (!done) {
            if (solver.contains(current)) {
                char next = solver.randomChar(current);
                if (next == ' ' && column >= LINE_BREAK) {
                    System.out.println();
                    column = 0;
                } else {
                    System.out.print(next);
                    column++;
                }
		current = (current + next).substring(1);
                total++;
                if (total >= length && next == '.')
                    done = true;
            } else {
                current = solver.randomStart();
                System.out.print(current);
                column += current.length();
                total += current.length();
                if (total >= length && current.endsWith("."))
                    done = true;
            }
        }
        System.out.println();
    }
}
