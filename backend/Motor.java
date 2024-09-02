/**
 * Represents the abstract class of any type motor (benzine / electric)
 * the car motor can be turned on / off and increases the power while driving
 * to increase the speed of the car based on the given pressure.
 */
abstract class Motor {
  int powerLevel;

  /**
   * Represents turning on the motor of the car.
   */
  public abstract void turnOn();

  /**
   * Represents turning off the motor of the car.
   */
  public abstract void turnOff();

  /**
   * Represents increasnig the power of the motor in order to increase the 
   * speed of the car while the car is turned on.
   * @param pressure based on the given pressure by the driver the speed of
   * the car can be increased.
   */
  public abstract void increasePower(int pressure);
}