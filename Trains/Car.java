/**
 * Class representing one car a train.
 *
 * A train contains a sequence of Car objects, each (but the last) pointing to
 * the next Car back in the train. A Car has a weight, an identifier, and a
 * description, all immutable (set once in the constructor) and a reference to
 * the next car in it's current train.
 */
class Car {
  // All the descriptive fields of the Car are final (immutable)
  // So they can be public.
  public final double weightInTons;
  public final String uniqueID;     // required; system constraint is it's unique
  public final String description;  // can be blank

  public Car next;                  // next car back in the train

  /**
   * Construct the described train Car and have it point at the given next Car.
   */
  public Car(double weightInTons, String uniqueID, String description, Car next) {
    this.weightInTons = weightInTons;
    this.uniqueID = uniqueID;
    this.description = description;
    this.next = next;
  }

  /**
   * Construct the described Car, pointing at no other Car.
   */
  public Car(double weightInTons, String uniqueID, String description) {
    this(weightInTons, uniqueID, description, null);
  }
}
