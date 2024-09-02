/**
 * Represents the inheretance class of the Motor class for electric cars
 * the car motor can be turned on / off and increases the power while driving
 * to increase the speed of the car based on the given pressure.
 */
class ElectricMotor extends Motor {

  private boolean isRunning;
  private Battery battery;

  /**
   * Constructs a ElectricMotor instance with a specified charge level.
   * @param battery the initial charge level of the battery.
   */
  public ElectricMotor(Battery battery) { this.battery = battery; }

  /**
   * Turns the motor on if the battery level is not empty and makes the
   * isRunnung variable true indicating that the car is running. Otherwise
   * the car cannot be turned on.
   */
  @Override
  public void turnOn() {
    /**
     * Check if there's enough battery charge to start the motor.
     */
    if (!battery.isBatteryEmpty()) {
      isRunning = true;
      System.out.println("Electric motor is now on.");
    } else {
      System.out.println("Cannot start electric motor due to low battery.");
    }
  }

  /**
   * Turns the motor off and makes the isRunnung variable false indicating that
   * the car is turned off.
   */
  @Override
  public void turnOff() {
    isRunning = false;
    System.out.println("Electric motor is now off.");
  }

  /**
   * Represents increasnig the power of the motor in order to increase the
   * speed of the car while the car is turned on.
   * @param pressure based on the given pressure by the driver the speed of
   * the car can be increased.
   */
  @Override
  public void increasePower(int pressure) {
    int powerIncrease = calculatePowerIncrease(pressure);
    if (isRunning && battery.getChargeLevel() - powerIncrease >= 0) {
      /**
       * Consume battery charge for increasing power.
       */
      battery.consumeEnergy(powerIncrease);
      System.out.println(
          "Electric motor power increased. Current battery level: " +
          battery.getChargeLevel());
    } else {
      System.out.println("Not enough battery to increase power.");
    }
  }

  /**
   * Calcultes the power increament based on the given pressure by the driver.
   * @return the calculation of the speed increament.
   */
  private int calculatePowerIncrease(int pressure) {
    /**
     * This can be adjusted to a more realistic calculation.
     */
    return pressure / 4;
  }

  /**
   * Retrieves the value of isRunning variable, which indicates if the car's
   * current state.
   * @return the state of the car motor (on / off).
   */
  public boolean isRunning() { return isRunning; }
}
