/*  CIS 203 Computer Science II
    Assignment 3: Letter Inventory Test Client, TestLI.java
    12 February 2019 L. Grabowski
 
    This program tests the LetterInventory class, as developed
    in Assignment 3.
 
    Compilation: in the same directory as LetterInventory.java,
        javac *.java
        or compile explicitly with
        javac TestLI.java LetterInventory.java
    Run:
        java TestLI <testChoice>
        where <testChoice> is one of the choices listed in the main method
        [NOTE: details of how to run the tests have been omitted deliberately
        to encourage students to understand the test client code.]
    Success:
        Test results are displayed
*/

import java.util.*;

public class TestLI {

    public static int score = 0;
    public static int total = 0;

    public static void main (String [] args) {
        int choice = Integer.parseInt(args[0]);
        if (choice == 1)
            testConstructorAndToString();
        else if (choice == 2)
	    testGet();
        else if (choice == 3)
            testSet();
	else if (choice == 4)
            testSize();
	else if (choice == 5)
            testIsEmpty();
        else if (choice == 6)
            testEquals();
        else if (choice == 7)
            testAdd();
        else if (choice == 8)
            testSubtract();
        else  if (choice == 9)
            testAnagrams();
        else
	runAll(); 

    }

    public static void testConstructorAndToString() {
        System.out.println("Testing constructor and toString()... ");
        total += 4;
        Random rand = new Random();
        rand.setSeed(13);
        String result = "";
        int length = rand.nextInt(400);
        for (int i = 0; i < length; i++)
            result = result + (char) (rand.nextInt(128));
        LetterInventory li = new LetterInventory(result);
        if (li.toString().equals("[aaaabcdeefghjlnnnnopqqrrrssssuwxyyzz]")) {
            score+=2;
            System.out.println("PASS");
        }
        else System.out.println("FAIL");
        li = new LetterInventory("12#$");
        if (li.toString().equals("[]")) {
            score+= 1;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        li = new LetterInventory("");
        if (li.toString().equals("[]")) {
            score+= 1;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        report();
    }
    
    public static void testGet() {
        System.out.println("\nTesting get()... ");
        total += 3;
        LetterInventory li = new LetterInventory("zzttsloiuflwefoiusfdhk");
        if (li.get('f') == 3) {
            score++;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        if (li.get('a') == 0) {
            score++;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        if (li.get('W') == 1) {
            score++;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        report();
    }
    
     public static void testSet() {
        System.out.println("\nTesting set()... ");
        total += 4;
        LetterInventory li = new LetterInventory("zzttsloiuflwefoiusfdhk");
        li.set('z', 0);
        if (li.toString().equals("[defffhiiklloossttuuw]")) {
            score++;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        li.set('A',5);
        if (li.toString().equals("[aaaaadefffhiiklloossttuuw]")) {
            score++;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        try {
            li.set('*',2);
            System.out.println("FAIL");
        } catch (IllegalArgumentException e) {
            score++;
            System.out.println("PASS");
        }
        try {
            li.set('f',-2);
            System.out.println("FAIL");
        } catch (IllegalArgumentException e) {
            score++;
            System.out.println("PASS");
        }
        report();
    } 
    
    public static void testSize() {
        System.out.println("\nTesting size()... ");
        total += 6;
        LetterInventory li = new LetterInventory("eoiuweTYSLE&*(&(*");
        if (li.size() == 11) {
            score++;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        li.set('o',4);
        if (li.size() == 14) {
            score+=2;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        li.set('e',1);
        if (li.size() == 12) {
            score+=2;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        li = new LetterInventory("");
        if (li.size() == 0) {
            score++;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        report();
    }
    
    public static void testIsEmpty() {
        System.out.println("\nTesting isEmpty()... ");
        total += 3;
        LetterInventory li = new LetterInventory("");
        if (li.isEmpty()) {
            score++;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        li.set('C', 5);
        if (!li.isEmpty()) {
            score++;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        li.set('C', 0);
        if (li.isEmpty()) {
            score++;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        report();
    }
    
    public static void testEquals() {
        System.out.println("\nTesting equals()... ");
        total += 5;
        LetterInventory l1 = new LetterInventory("weuweroi&&WEWE>>");
        LetterInventory l2 = new LetterInventory("eeeeioruwwww");
        if (l1.equals(l2) && l2.equals(l1)) {
            score+=2;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        l1.set('e',3); l1.set('i',2);
        if (!l1.equals(l2) && !l2.equals(l1)) {
            score++;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        l1 = new LetterInventory("");
        l2 = new LetterInventory("");
        if (l1.equals(l2) && l2.equals(l1)) {
            score++;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        if (!l1.equals(new Scanner(System.in))) {
            score++;
            System.out.println("PASS");
        } else  System.out.println("FAIL");
        report();
    }
    
    public static void testAdd() {
        System.out.println("\nTesting add()... ");
        total += 3;
        LetterInventory l1 = new LetterInventory("qqwwwrt");
        LetterInventory l2 = new LetterInventory("wwwrtqq");
        LetterInventory l3 = l1.add(l2);
        if (l3.toString().equals("[qqqqrrttwwwwww]") &&
            l1.toString().equals("[qqrtwww]") &&
            l2.toString().equals("[qqrtwww]") &&
            l3.size() == 14) {
            score += 2;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        l3 = l1.add(new LetterInventory(""));
        if (l3.toString().equals(l1.toString())) {
            score++;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        report();
    }
    
    public static void testSubtract() {
        System.out.println("\nTesting subtract()... ");
        total += 6;
        LetterInventory l1 = new LetterInventory("aabqqwwwrt");
        LetterInventory l2 = new LetterInventory("wwwrtqq");
        LetterInventory l3 = l1.subtract(l2);
        if (l3.toString().equals("[aab]") &&
            l1.toString().equals("[aabqqrtwww]") &&
            l2.toString().equals("[qqrtwww]") &&
            l3.size() == 3) {
            score+=2;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        l3 = l1.subtract(l1);
        if (l3.toString().equals("[]") &&
            l1.toString().equals("[aabqqrtwww]") &&
            l3.size() == 0) {
            score+=2;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        l3 = l2.subtract(l1);
        if (l3 == null &&
            l1.toString().equals("[aabqqrtwww]") &&
            l2.toString().equals("[qqrtwww]")) {
            score+=2;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        report();
    }
    
    public static void testAnagrams() {
        System.out.println("\nTesting anagrams()... ");
        total += 2;
        if (LetterInventory.anagrams("TA MED", "mated")) {
            score++;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        if (!LetterInventory.anagrams("TAM MED", "mated")) {
            score++;
            System.out.println("PASS");
        } else System.out.println("FAIL");
        report();
    }
    
    public static void report() {
        System.out.println("score/total = " + score + "/" + total);
    } 
    
    public static void runAll() {
        testConstructorAndToString();
        testGet();
        testSet();
        testSize();
        testIsEmpty();
        testEquals();
        testAdd();
        testSubtract();
        testAnagrams();
        double finalSc = score;
        finalSc = finalSc / total;
        finalSc *= 35;
        System.out.println("Final score: " + Math.round(finalSc));
	} 
}
