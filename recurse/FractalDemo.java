/*  CIS 203 Computer Science II
    Assignment 6
    FractalDemo.java -- Client for Fractal class
    Updated 03/21/2019, L. Grabowski
 
    The program creates and displays a Fractal object, using
    the "level", and integer specified by the user at
    the command line
*/
public class FractalDemo {

    public static void main (String [] args) {
        Fractal f = new Fractal(Integer.parseInt(args[0]));
        System.out.print(f);
    }


}
