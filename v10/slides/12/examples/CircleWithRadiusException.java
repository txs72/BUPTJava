public class CircleWithRadiusException {
  /** The radius of the circle */
  private double radius;

  /** The number of the objects created */
  private static int numberOfObjects = 0;

  /** Construct a circle with radius 1 */
  public CircleWithRadiusException() {
    this(1.0);
  }

  /** Construct a circle with a specified radius */
  public CircleWithRadiusException(double newRadius) {
    try {
      setRadius(newRadius);
      numberOfObjects++;
    }
    catch (InvalidRadiusException ex) {
      ex.printStackTrace();
    }
  }

  /** Return radius */
  public double getRadius() {
    return radius;
  }

  /** Set a new radius */
  public void setRadius(double newRadius)
      throws InvalidRadiusException {
    if (newRadius >= 0)
      radius =  newRadius;
    else
      throw new InvalidRadiusException(newRadius);
  }

  /** Return numberOfObjects */
  public static int getNumberOfObjects() {
    return numberOfObjects;
  }

  /** Return the area of this circle */
  public double findArea() {
    return radius * radius * 3.14159;
  }
}

