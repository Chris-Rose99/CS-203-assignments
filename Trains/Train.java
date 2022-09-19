/* Christopher Rose
Assignment 05
Dr.Grabowski 

If it wasn't obvious I don't understand this assignment to the point where I couldn't even ask for help. I'll do what I can, but I'll definitely have to go to you or a tutor for help understanding what this was supposed to be*/

import java.lang.*;

public class Train implements TrainInterface {

    // constructs a train
    public Train() {
	ListNode list = new ListNode(null);
	double weight = 0.0;
	int size = 0;
    }

    // loads the train with cars
    public static void loadTrain(String) {
	
    }

    // quits the program
    public void quit() {
	System.exit(0);
    }

    // prints list of instructions
    public void help() {
	System.out.println("quit: Terminate the program.");
	System.out.println("help: List valid commands");
	System.out.println("trains: Prints out the names of all the trains");
	System.out.println("list: Print out current contents of the named train");
	System.out.println("weight: Display the total weight of the named train");
	System.out.println("size: Display the length of the named train");
	System.out.println("add: Adds the given car to the named train");
	System.out.println("remove: Remove the car from the train");
	System.out.println("decouple: Remove all cars from the named car to the end of the train");
	System.out.println("find: Give the train name (if any) containing the named car");
	System.out.println("check: Check if the two trains combined weight is less than or equal to 200 tons");
	System.out.println("join: Attach the cars of train 2 to the end of train 1 ");
    }

    // gives the names of all the trains
    public String trains() {
	// dont understand
    }

    // Lists all the cars in the train
    public String list(Train name) {
	String cars = "";
	ListNode current = name;
	while (current != null) {
	    cars = cars + ", " + current.data;
	    current = current.next;
	}
	return cars;
    }

    // returns weight of the cars
    public double weight(Train name) {
	double mass = 0;
	ListNode current = list;
	while (current != null) {
	    
	}
	
    }

    // returns size of the train
    public int size(Train name) {
	int size = 0;
	ListNode current = list;
	while (current != null) {
	    size++;
	    current = current.next;
	}
	return size;
    }

    // adds a car to the end of the train
    public void add() {
	
    }

    // removes a car from the train
    public void remove() {
	
    }

    // removes a string of cars from the train
    public void decouple() {
	
    }

    // finds trains with a certain car in them
    public void find() {
	
    }

    // checks to see if the weight of two trains will go over 200 tons
    public String check(Train one, Train two) {
	if ()
    }

    // combines train one and train two together
    public void join(Train one, Train two) {
	ListNode current = one.list;
	while (current.next != null) {
	    current = current.next;
	}
	current.next = two.list; 
    }

}
