/**
 * Represents the inheretance class of the Motor class for benzine motor cars
 * the car motor can be turned on / off and increases the power while driving
 * to increase the speed of the car based on the given pressure.
 */
class BenzineMotor extends Motor {

  private boolean isRunning;
  private GasContainer gasContainer;

  /**
   * Constructs a BenzineMotor instance with a specified the gas container
   * *level.
   * @param gasContainer the initial gas amount in the gas container.
   */
  public BenzineMotor(GasContainer gasContainer) {
    this.gasContainer = gasContainer;
  }

  /**
   * Turns the motor on if the gas container is not empty and makes the
   * isRunnung variable true indicating that the car is running. Otherwise
   * the car cannot be turned on.
   */
  @Override
  public void turnOn() {
    /**
     * Check if there is enough gas in the gas container to start the motor.
     */
    if (!gasContainer.isGasEmpty()) {
      isRunning = true;
      System.out.println("Benzine motor is now on.");
    } else {
      System.out.println("Cannot start benzine motor due to low fuel.");
    }
  }

  /**
   * Turns the motor off and makes the isRunnung variable false indicating that
   * the car is turned off.
   */
  @Override
  public void turnOff() {
    isRunning = false;
    System.out.println("Benzine motor is now off.");
  }

  /**
   * Represents increasnig the power of the motor in order to increase the
   * speed of the car while the car is turned on.
   * @param pressure based on the given pressure by the driver the speed of
   * the car can be increased.
   */
  @Override
  public void increasePower(int pressure) {
    /**
     * Calculate how much additional power is needed based on the pressure.
     */
    int powerIncrease = calculatePowerIncrease(pressure);

    /**
     * Check if the motor is running and if there's enough fuel to increase
     * the power.
     */
    if (isRunning && !gasContainer.isGasEmpty()) {
      /**
       * Consume fuel from the gas container. The amount consumed could be
       * proportional to the power increase or pressure, depending on the
       * design.
       */
      gasContainer.consumeGas(powerIncrease);

      /**
       * Increase power output of the motor.
       */
      System.out.println("Benzine motor power increased. Current fuel level: " +
                         gasContainer.getGasLevel());
    } else {
      System.out.println("Not enough fuel to increase power.");
    }
  }

  /**
   * Calcultes the power increament based on the given pressure by the driver.
   * @return the calculation of the speed increament.
   */
  private int calculatePowerIncrease(int pressure) {
    /**
     * Placeholder for actual calculation
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
