/**
 * The interface for all train objects
 */
public interface TrainInterface {
  /** Maximum permissible weight of a train. Modifiers are redundant. */
  public static final double MAX_PERMISSIBLE_WEIGHT = 200;

  /**
   * A factory method for building a train from the description in a file.
   *
   * of errors finding and opening the file (dealt with here in this
   * method) from the handling of formatting errors in the description
   * of the train data (handled in the constructor). It also
   * simplifies testing the constructor.
   *
   * @param trainDataPath file containing a description of a TrainInterface obj
   * @throws IOException problem opening or reading the named file
   * @throws ParseException if contents of the file are improperly formatted
   */
  // public static TrainInterface trainFromFile(String trainDataPath)
  //     throws IOException,
  //            ParseException;

  /**
   * A TrainInterface "constructor"; the required signature.
   *
   * Read the train description  from the contents and fill in our train.
   *
   * @param inputFileNameForErrorReporting name of the data file; for
   * exception messages
   * @param trainDataFileContents          the contents to build the train from
   * @throws ParseException if the contents
   */
  // public TrainInterface(String inputFileNameForErrorReporting,
  //                       Scanner trainDataFileContents) throws ParseException;

  /**
   * Get the name of this train.
   *
   * @return name of the train
   */
  public String name();

  /**
   * Is this train empty?
   *
   * @return true if this train is empty; false otherwise
   */
  public boolean isEmpty();

  /**
   * Get the number of cars currently in the train.
   *
   * @return length of the train
   */
  public int length();

  /**
   * Get the current weight of cars in the train
   *
   * @return total weight of all cars in the train
   */
  public double weight();

  /**
   * Is this the train with the given name?
   *
   * @param maybeName the name to check this train for
   * @return true if the name matches the name of the train; false otherwise
   */
  public boolean hasName(String maybeName);

  /**
   * Check whether or not the named car is part of this train.
   *
   * @param maybeCarName name of the car to check this train for
   * @return true if the named car is in the train; false otherwise.
   */
  public boolean hasCar(String maybeCarName);

  /**
   * Add a new car to the rear end of the train.
   *
   * @param carWeight      the weight of the new car
   * @param carID          new car's identifier
   * @param carDescription new car's description (can be empty)
   * @return true if the car could be legally inserted into the train
   * (safe weight, no matching ID in this train); false otherwise
   */
  public boolean addCar(double carWeight, String carID, String carDescription);

  /**
   * Remove just the named car from this train.
   *
   * @param carID the car to remove
   * @return true if the car _was_ in the train and has been removed;
   * false otherwise
   */
  public boolean removeCar(String carID);

  /**
   * Remove from the named car to the end of the train.
   *
   * @param carID the id of the first car to decouple from
   * @return true if the car _was_ in the train and has been removed;
   * false otherwise
   */
  public boolean decoupleCar(String carID);

  /**
   * Would it be safe to attach the given train to the back of this
   * one? It is safe if the total weight of the joined train would be
   * less than or equal to the safe weight given in the assignment.
   *
   * @param otherTrain the TrainInterface to check for adding on to ours
   * @return true if the combined weight is legal; false otherwise
   */
  public boolean safeToJoin(TrainInterface otherTrain);

  /**
   * If it is safe, join the other train's cars onto the end of our
   * train. It is safe if the total weight of the joined train is at
   * or under the safe weight given in the assignment.
   *
   * @param otherTrain
   * @return true if trains were joined; false otherwise
   * @postcondition (return true && otherTrain ' .isEmpty () == true) ||
   *                (return false && otherTrain' == otherTrain && this' == this)
   */
  public boolean join(TrainInterface otherTrain);


  /**
   * Generates a _string_ containing all of the information about the
   * train. The format of the string is as follows:
   *
   * <TrainName>
   *   <Car1Weight> <Car1ID> <Car1Description>
   *   <Car2Weight> <Car2ID> <Car2Description>
   *   <Car3Weight> <Car3ID> <Car3Description>
   * ...
   *
   * Where the first column is right aligned and 5 characters wide
   * with up to 3 digits before the decimal point and one digit after;
   * second column is left aligned and as wide as the widest
   * identifier in the train; third column is left aligned and is the
   * rest of the line.
   *
   * @return a formatted, multi-line string describing the train.
   */
  public String toString();
}
