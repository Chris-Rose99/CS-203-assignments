import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.Scanner;

/**
 * The driver for the TrainManager system. A read-evaluate-print loop (REPL)
 * for working with trains. Programmed to use the {@link TrainInterface} so
 * any implementation of a train should work.
 *
 * Note: it is not uncommon for the input/output handling of a program to
 * account for half (or more) of the code. This code is long but it is very
 * well commented and it handles user input adequately (still has shortcomings).
 */
public class TrainManager {
  // title and version information; displayed to user
  public static final String title = "TrainManager";
  public static final String version = "1.0";

  // the prompt displayed in the REPL; non-final so it could be changed
  private static String prompt = "... ";

  // Command names - note: it is assumed that no two commands share any prefix
  // Kept as constants to ease internationalization
  private static final String QUIT = "quit";
  private static final String HELP = "help";
  private static final String TRAINS = "trains";
  private static final String LIST = "list";
  private static final String SIZE = "size";
  private static final String WEIGHT = "weight";
  private static final String ADD = "add";
  private static final String REMOVE = "remove";
  private static final String FIND = "find";
  private static final String DECOUPLE = "decouple";
  private static final String CHECK = "check";
  private static final String JOIN = "join";

  // -----------------------------------------------------------------------
  // non static fields
  // -----------------------------------------------------------------------
  // the list of trains currently being managed
  private TrainInterface myTrains[];
  // the number of slots in array being used
  private int myTrainCount;

  // -----------------------------------------------------------------------
  // Static functions
  // -----------------------------------------------------------------------

  /**
   * Print a formatted usage message for the program to the standard error
   * stream.
   */
  public static void usage() {
    System.err.println("TrainManager <trainDataFileName>+");
    System.err.println("    where <trainDataFileName> names a properly formatted train data file");
    System.err.println("          and + means one or more such names appear");
  }

  /**
   * Check for enough arguments and halt if they are not there. Create a
   * TrainManager object and run it otherwise.
   */
  public static void main(String[] args) throws IOException, ParseException {
    if (args.length == 0) {
      usage();
      System.exit(1); // non-zero exit if there is a problem
    }
    System.out.println(String.format("%s - %s", title, version));
    TrainManager tm = new TrainManager(args);
    int retCode = tm.run();
    if (retCode != 0)
      System.exit(retCode);
    System.out.println(String.format("%s - %s: terminating", title, version));
  }

  // -----------------------------------------------------------------------
  // Constructor
  // -----------------------------------------------------------------------
  /**
   * Construct train manager with trains loaded from the listed file names
   *
   * @param trainNames array of train data file names.
   */
  public TrainManager(String[] trainNames) {
    myTrains = new TrainInterface[trainNames.length];
    myTrainCount = 0;
    for (int t = 0; t < myTrains.length; t++) {
      String trainFileName = trainNames[t];
      try {
        myTrains[myTrainCount] = Train.trainFromFile(trainFileName);
        myTrainCount++;
      } catch (IOException e) {
        e.printStackTrace();
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }
  }

  // -----------------------------------------------------------------------
  // run for executing the program object; the REPL
  // -----------------------------------------------------------------------
  /**
   * Run the program with standard input and standard output.
   */
  int run() {
    return run(System.in, System.out);
  }

  /**
   * Using the given input and output sources, run an interactive command
   * session.
   *
   * @param in  stream source of input
   * @param out stream sink for output
   * @return expected return code for the main method
   */
  int run(InputStream in, PrintStream out) {
    if (myTrainCount > 0) {
      String prompt = "... ";
      Scanner keyboard = new Scanner(in);
      if (out != null) out.print(prompt);
      while (keyboard.hasNextLine()) {
        String command = keyboard.next();
        command = command.trim();

        if (command.isEmpty())
          continue;

        // if output is going somewhere weird, make sure prompt line is terminated
        if ((out != null) && (out != System.out))
          out.println();

        if (QUIT.startsWith(command)) {
          break;
        } else if (HELP.startsWith(command)) {
          displayCommandMenu(out);
        }
        if (TRAINS.startsWith(command)) {
          displayAllTrainNames(out);
        } else if (LIST.startsWith(command)) {
          String trainName = getTrainName(out, keyboard);
          displayDetailOf(out, trainName);
        } else if (SIZE.startsWith(command)) {
          String trainName = getTrainName(out, keyboard);
          displaySizeOf(out, trainName);
        } else if (WEIGHT.startsWith(command)) {
          String trainName = getTrainName(out, keyboard);
          displayWeightOf(out, trainName);
        } else if (ADD.startsWith(command)) {
          String trainName = getTrainName(out, keyboard);
          addCarTo(out, trainName, keyboard);
        } else if (REMOVE.startsWith(command)) {
          String trainName = getTrainName(out, keyboard);
          String carToRemove = getCarID(out, keyboard);
          removeFrom(out, trainName, carToRemove);
        } else if (FIND.startsWith(command)) {
          String carToFind = getCarID(out, keyboard);
          displayTrainContaining(out, carToFind);
        } else if (DECOUPLE.startsWith(command)) {
          String trainName = getTrainName(out, keyboard);
          String carToDecoupleFrom = getCarID(out, keyboard);
          decoupleFrom(out, trainName, carToDecoupleFrom);
        } else if (CHECK.startsWith(command)) {
          String headTrainName = getTrainName(out, keyboard);
          String tailTrainName = getTrainName(out, keyboard);
          checkJoinabilityOf(out, headTrainName, tailTrainName);
        } else if (JOIN.startsWith(command)) {
          String headTrainName = getTrainName(out, keyboard);
          String tailTrainName = getTrainName(out, keyboard);
          joinEm(out, headTrainName, tailTrainName);
        } else {
        }

        if (out != null) out.print(prompt);
      }
    } else {
      System.err.println("No trains successfully loaded; TrainManager terminating.");
      return 2;
    }
    return 0;
  }

  // -----------------------------------------------------------------------
  // Utility functions used by command implementations
  // -----------------------------------------------------------------------
  /**
   * Read the train name from in. If there is nothing waiting, prompt the user
   * and then fetch the name.
   *
   * Needs interactive testing.
   *
   * @param out      output stream (nullable) for prompt
   * @param keyboard inptut scanner
   * @return
   */
  private String getTrainName(PrintStream out, Scanner keyboard) {
    if (keyboard.hasNext())
      return keyboard.next();

    if (out != null)
      out.print("Train Name? ");

    return keyboard.next();
  }

  /**
   * Read the car ID from keyboard. If there is nothing waiting, prompt the
   * user and then fetch the ID.
   *
   * Needs interactive testing.
   *
   * @param out      output stream (nullable) for prompt
   * @param keyboard inptut scanner
   * @return a ID of a car(?)
   */
  private String getCarID(PrintStream out, Scanner keyboard) {
    if (keyboard.hasNext())
      return keyboard.next();

    if (out != null)
      out.print("Car ID? ");

    return keyboard.next();
  }

  /**
   * Find train in the managed collection by its name.
   *
   * @param trainName the name of the train to find
   * @return reference to the train if it is found; null if no such train
   */
  private TrainInterface findTrainByName(String trainName) {
    TrainInterface train = null;
    for (int t = 0; t < myTrainCount; t++) {
      if (myTrains[t].hasName(trainName))
        train = myTrains[t];
    }
    return train;
  }

  /**
   * Find train in the managed collection by a car it contains.
   *
   * @param carID the carID of the train to find
   * @return reference to the train if it is found; null if no such train
   */
  private TrainInterface findTrainContaining(String carID) {
    TrainInterface train = null;
    for (int t = 0; t < myTrainCount; t++) {
      if (myTrains[t].hasCar(carID))
        train = myTrains[t];
    }
    return train;
  }

  // -----------------------------------------------------------------------
  // Command implementations
  // -----------------------------------------------------------------------
  /**
   * Display all of the train names, one at a time, on the output stream.
   *
   * @param out stream to display on; null means no output
   * @implNote query only; safe to skip if out == null
   */
  private void displayAllTrainNames(PrintStream out) {
    if (out == null)
      return;

    for (int t = 0; t < myTrainCount; t++) {
      out.println(myTrains[t].name());
    }
  }

  /**
   * Display all of the cars of the given train.
   *
   * @param out where to display results
   * @param trainName name of train to display.
   * @implNote query only; safe to skip if out == null
   */
  private void displayDetailOf(PrintStream out, String trainName) {
    if (out == null)
      return;
    TrainInterface train = findTrainByName(trainName);
    if (train != null)
      out.println(train);
    else
      out.println(String.format("%s not found", trainName));
  }

  /**
   * Try to display name of train containing given car, if one exists.
   *
   * @param out         where to display results
   * @param carIDToFind ID of the car
   * @implNote query only; safe to skip if out == null
   */
  private void displayTrainContaining(PrintStream out, String carIDToFind) {
    if (out == null)
      return;
    TrainInterface train = findTrainContaining(carIDToFind);

    if (train != null)
      out.println(String.format("%s contains %s", train.name(), carIDToFind));
    else
      out.println(String.format("Car %s not found", carIDToFind));

  }

  /**
   * Display the name of the train (if it exists) along with its total weight in
   * tons.
   *
   * @param out       where to print output.
   * @param trainName name of train to display on
   * @implNote query only; safe to skip if out == null
   */
  private void displaySizeOf(PrintStream out, String trainName) {
    if (out == null)
      return;
    TrainInterface train = findTrainByName(trainName);
    if (train != null)
      out.println(String.format("%s has %d cars", train.name(), train.length()));
    else
      out.println(String.format("%s not found", trainName));
  }

  /**
   * Display the name of the train (if it exists) along with its total weight in
   * tons.
   *
   * @param out       where to print output.
   * @param trainName name of train to display on
   * @implNote query only; safe to skip if out == null
   */
  private void displayWeightOf(PrintStream out, String trainName) {
    if (out == null)
      return;
    TrainInterface train = findTrainByName(trainName);
    if (train != null)
      out.println(String.format("%s %5.1f", train.name(), train.weight()));
    else
      out.println(String.format("%s not found", trainName));
  }

  /**
   * Remove the named car from the named train.
   *
   * @param out stream to print progress messages
   * @param trainName train to which a car is to be added
   * @param keyboard the input from which the car data is read
   * @return true if the car was added; false otherwise
   * @implNote on success, the train is lengthened by one car
   */
  private boolean addCarTo(PrintStream out, String trainName, Scanner keyboard) {
    // cannot skip if out is null (changes the train)
    boolean carAdded = false;
    String resultsToDisplay = "";
    TrainInterface train = findTrainByName(trainName);
    if (train != null) {
      String carDataLine = keyboard.nextLine().trim();
      Scanner carScanner = new Scanner(carDataLine);

      // read one car out of the line
      double weight = carScanner.nextDouble();
      String id = carScanner.next();
      String description = "";
      if (carScanner.hasNext())
        description = carScanner.nextLine(); // rest of the line

      if (train.addCar(weight, id, description)) {
        carAdded = true;
        resultsToDisplay = String.format("Added %s to train %s; new total weight %5.1f", id, train.name(), train.weight());
      } else
        resultsToDisplay = String.format("Unable to add car %s to train %s; over weight at %5.1f", id, train.name(), train.weight() + weight);
    } else {
      // do we want to clean up the keyboard?
      resultsToDisplay = String.format("%s not found", trainName);
    }

    if (out != null)
      out.println(resultsToDisplay);
    return carAdded;
  }

  /**
   * Remove the named car from the named train.
   *
   * @param out stream to print progress messages
   * @param trainName train from which a car is to be removed
   * @param carIDToRemove car to remove
   * @return true if the car was in (and is no longer in) the train; false otherwise
   * @implNote on success, the train is shortened by one car
   */
  private boolean removeFrom(PrintStream out, String trainName, String carIDToRemove) {
    // cannot skip if out is null (changes the train)
    boolean carRemoved = false;
    String resultsToDisplay = "";
    TrainInterface train = findTrainByName(trainName);
    if (train != null) {
      if (train.removeCar(carIDToRemove)) {
        // all is well
        carRemoved = true;
        resultsToDisplay = String.format("Removed car %s from train %s; new total weight %5.1f", carIDToRemove, train.name(), train.weight());
      } else {
        // train okay, car missing
        resultsToDisplay = String.format("Unable to remove car %s from train %s; not present", carIDToRemove, train.name());
      }
    } else {
      resultsToDisplay = String.format("%s not found", trainName);
    }

    if (out != null)
      out.println(resultsToDisplay);
    return carRemoved;
  }

  /**
   * Remove the named car and others behind it from the named train.
   *
   * @param out stream to print progress messages
   * @param trainName train from which a car is to be decoupled
   * @param carIDToDecoupleFrom car to decouple from
   * @return true if the car was in (and is no longer in) the train; false otherwise
   * @implNote on success, the train is shortened by everything at and after the
   * named car
   */
  private boolean decoupleFrom(PrintStream out, String trainName, String carIDToDecoupleFrom) {
    // cannot skip if out is null (changes the train)
    boolean carDecoupled = false;
    String resultsToDisplay = "";
    TrainInterface train = findTrainByName(trainName);
    if (train != null) {
      if (train.decoupleCar(carIDToDecoupleFrom)) {
        // all is well
        carDecoupled = true;
        resultsToDisplay = String.format("Decoupled from car %s in train %s; new total weight %5.1f", carIDToDecoupleFrom, train.name(), train.weight());
      } else {
        // train okay, car missing
        resultsToDisplay = String.format("Unable to decouple car %s from train %s; not present", carIDToDecoupleFrom, train.name());
      }
    } else {
      resultsToDisplay = String.format("%s not found", trainName);
    }

    if (out != null)
      out.println(resultsToDisplay);
    return carDecoupled;
  }

  /**
   * Named subexpression for combined weight of two trains
   * @param headTrain one of the trains
   * @param tailTrain the other train
   * @return combined weight
   */
  private double combinedWeight(TrainInterface headTrain, TrainInterface tailTrain) {
    return headTrain.weight() + tailTrain.weight();
  }

  /**
   * Safe to join the two named trains? Safe means that both
   * trains exist and the combined weight would be at or below the maximum
   * weight.
   *
   * @param out where to display the progress messages
   * @param headTrainName name of train to be in the front
   * @param tailTrainName name of train to be in the rear
   * @implNote query only; safe to skip if out == null
   */
  private void checkJoinabilityOf(PrintStream out, String headTrainName, String tailTrainName) {
    if (out == null)
      return; // output only query
    String resultsToDisplay = "";
    TrainInterface headTrain = findTrainByName(headTrainName);
    TrainInterface tailTrain = findTrainByName(tailTrainName);

    if (headTrain == null) {
      resultsToDisplay += String.format("Head train %s not found\n", headTrainName);
    }

    if (tailTrain == null) {
      resultsToDisplay += String.format("Tail train %s not found\n", tailTrainName);
    }

    if ((headTrain != null) && (tailTrain != null)) {
      double combinedWeight = combinedWeight(headTrain, tailTrain);
      if (headTrain.safeToJoin(tailTrain))
        resultsToDisplay = String.format("Safe to join %s behind %s; new total weight would be %5.1f\n", tailTrain.name(), headTrain.name(), combinedWeight);
      else
        resultsToDisplay = String.format("Unsafe to join %s behind %s; new total weight would be %5.1f\n", tailTrain.name(), headTrain.name(), combinedWeight);
    }
    out.print(resultsToDisplay);
  }

  /**
   * Join the two named trains (if it is safe to do so). Safe means that both
   * trains exist and the combined weight would be at or below the maximum
   * weight.
   *
   * @param out where to display the progress messages
   * @param headTrainName name of train to be in the front
   * @param tailTrainName name of train to be in the rear
   * @implNote on success, tail train will be empty
   */
  private boolean joinEm(PrintStream out, String headTrainName, String tailTrainName) {
    boolean joined = false;
    String resultsToDisplay = "";
    TrainInterface headTrain = findTrainByName(headTrainName);
    TrainInterface tailTrain = findTrainByName(tailTrainName);

    if (headTrain == null) {
      resultsToDisplay += String.format("Head train %s not found\n", headTrainName);
    }

    if (tailTrain == null) {
      resultsToDisplay += String.format("Tail train %s not found\n", tailTrainName);
    }

    if ((headTrain != null) && (tailTrain != null)) {
      double combinedWeight = combinedWeight(headTrain, tailTrain);
      if (headTrain.join(tailTrain)) {
        joined = true;
        resultsToDisplay = String.format("Joined %s behind %s; new total weight %5.1f\n", tailTrain.name(), headTrain.name(), combinedWeight);
      } else
        resultsToDisplay = String.format("Unsafe to join %s behind %s; new total weight would be %5.1f\n", tailTrain.name(), headTrain.name(), combinedWeight);
    }
    if (out != null)
      out.print(resultsToDisplay);
    return joined;
  }

  /**
   * Print the manager menu to the output stream (if there is one).
   *
   * NOTE: If internationalization were actually a priority, we should make sure
   * that the usage messages are in variables somewhere, too. The reason for
   * having the text come from a fixed set of variables is the files used to
   * initialize those variables can be sent out to translation services and as
   * long as everything is in the right order, the initialization should be fine
   * and work in the new language. This does not handle languages with a
   * different display direction unless IO routines are also tunable. Further,
   * it is assumed that the string type being used is Unicode clean (UTF-16+ or
   * variable width).
   *
   * @param out where to print the menu; null means no output is to be
   *            generated.
   * @implNote query only; safe to skip if out == null
   */
  private void displayCommandMenu(PrintStream out) {
    if (out == null)
      return;

    out.print(String.format("%10s %s\n", QUIT, ""));
    out.print(String.format("%10s %s\n", "", "Terminate the program."));
    out.print(String.format("%10s %s\n", HELP, ""));
    out.print(String.format("%10s %s\n", "", "List valid commands."));
    out.print(String.format("%10s %s\n", TRAINS, ""));
    out.print(String.format("%10s %s\n", "", "Print out the names of all of the trains"));
    out.print(String.format("%10s %s\n", LIST, "<train-name>"));
    out.print(String.format("%10s %s\n", "", "Print out current contents of the named train"));
    out.print(String.format("%10s %s\n", SIZE, "<train-name>"));
    out.print(String.format("%10s %s\n", "", "Display the length of the named train"));
    out.print(String.format("%10s %s\n", WEIGHT, "<train-name>"));
    out.print(String.format("%10s %s\n", "", "Display the total weight of the named train"));
    out.print(String.format("%10s %s\n", ADD, "<train-name> <weight> <car-id> <description>"));
    out.print(String.format("%10s %s\n", "", "Adds the given car to the named train"));
    out.print(String.format("%10s %s\n", REMOVE, "<train-name> <car-id>"));
    out.print(String.format("%10s %s\n", "", "Remove the car from the train (car goes away)"));
    out.print(String.format("%10s %s\n", DECOUPLE, "<train-name> <car-id>"));
    out.print(String.format("%10s %s\n", "", "Remove all cars from the named car to the end of the train from the train (all of the decoupled cars go away)"));
    out.print(String.format("%10s %s\n", FIND, "<car-id>"));
    out.print(String.format("%10s %s\n", "", "Give the train name (if any) containing the named car"));
    out.print(String.format("%10s %s\n", CHECK, "<train-name-1> <train-name-2>"));
    out.print(String.format("%10s %s\n", "", "Check whether or not the two trains combined weight is less than or equal to 200 tons"));
    out.print(String.format("%10s %s\n", JOIN, "<train-name-1> <train-name-2>"));
    out.print(String.format("%10s %s\n", "", "Attach the cars of train 2 to the end of train 1. Train 2 is no longer a valid train."));
  }

  // -----------------------------------------------------------------------
  // Testing interface
  // -----------------------------------------------------------------------
  /**
   * UNIT TESTING CONSTRUCTOR Make an empty manager with the given number of
   * train slots
   *
   * @param maxNumberOfTrains number of slots in the train array
   */
  TrainManager(int maxNumberOfTrains) {
    myTrains = new TrainInterface[maxNumberOfTrains];
    myTrainCount = 0;
  }

  /**
   * UNIT TESTING POPULATOR Add the train if possible
   *
   * @param train train to add (if it fits)
   * @return true if it was possible to add the given train; false otherwise
   */
  boolean addTrain(TrainInterface train) {
    if (myTrainCount < myTrains.length) {
      myTrains[myTrainCount++] = train;
      return true;
    }
    return false;
  }
}
