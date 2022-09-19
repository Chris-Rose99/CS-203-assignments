// Stuart Reges
// 9/6/00
// Modified L. Grabowski 2/04/2019
// CritterMain provides method main for a simple simulation program.

public class CritterMain {
    public static void main(String[] args) {
        CritterFrame frame = new CritterFrame();

	frame.add(25, Bird.class);
	frame.add(25, Frog.class);
	frame.add(25, Mouse.class);
	frame.add(25, Turtle.class);
	frame.add(1, Wolf.class);
        frame.start();
    }
}
