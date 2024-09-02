/**
 * Represents the speed meter of the car while driving. It can be increased
 * when pressing on the gas pedal or decreased when pressing on the brake pedal.
 */
class Speedometer {
  int currentSpeed;

  /**
   * Maximum speed that the car can reached.
   */
  static final int MAX_SPEED = 220;

  /**
   * Minimum speed that the car can reached.
   */
  static final int MIN_SPEED = 0;

  /**
   * Increases the speed of the car when pressing on the gas pedal. And ensures
   * that the car can maximum reaches the maximum speed and cannot surpass it.
   * @param pressure represents the prussure given by the driver to increase 
   * the speed.
   */
  public void increaseSpeed(int pressure) {
    /**
     * Ensuring that speed does not go more than 220 km/h.
     */
    currentSpeed = Math.min(currentSpeed + pressure, MAX_SPEED);
  }

  /**
   * Decreases the speed of the car when pressing on the brake pedal. And 
   * ensures that the car cannot get lower speed than the minimum speed.
   * @param pressure represents the prussure given by the driver to decrease 
   * the speed.
   */
  public void decreaseSpeed(int pressure) {
    /**
     * Ensuring that speed does not go below zero.
     */
    currentSpeed = Math.max(currentSpeed - pressure, MIN_SPEED);
  }

  /**
   * Retrieves the current speed of the car. 
   * @return the current speed of the car. 
   */
  public int getCurrentSpeed() {
    return currentSpeed;
  }
}