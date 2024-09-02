/**
 * Represents a car, capable of being either electric or benzine-powered.
 * This class manages the car's operational state, including its power source,
 * speed, and radio.
 */
public class Car {
  private boolean isElectric;

  /**
   * For electric cars only
   */
  private Battery battery;

  /**
   * For both electric and benzine cars
   */
  private SmallBattery smallBattery;

  /**
   * For benzine cars only
   */
  private GasContainer gasContainer;
  private Motor motor;

  private Speedometer speedometer;
  private boolean isCarRunning;
  private boolean isRadioOn;

  /**
   * Constants for initial charge and gas levels
   */
  private static final int INITIAL_BATTERY_CHARGE = 100;
  private static final int INITIAL_SMALL_BATTERY_CHARGE = 50;
  private static final int INITIAL_GAS_LEVEL = 100;

  /**
   * Constructs a new Car instance, specifying its type (electric or benzine)
   * and initializing components.
   * @param isElectric True if the car is electric, false if the car is
   *     benzine-powered.
   */
  public Car(boolean isElectric) {
    this.isElectric = isElectric;
    this.speedometer = new Speedometer();
    this.smallBattery = new SmallBattery(INITIAL_SMALL_BATTERY_CHARGE);
    if (isElectric) {
      this.battery = new Battery(INITIAL_BATTERY_CHARGE);
      this.motor = new ElectricMotor(battery);
    } else {
      this.gasContainer = new GasContainer(INITIAL_GAS_LEVEL);
      this.motor = new BenzineMotor(gasContainer);
    }
  }

  /**
   * Toggles the car's power state. If the car is off, it attempts to start it.
   * If the car is on, it turns it off.
   */
  public void press() {
    // Simulate pressing the start button
    if (!isCarRunning) {
      start();
    } else {
      turnOff();
    }
  }

  /**
   * Attempts to start the car, checking the appropriate power source's energy
   * level.
   */
  private void start() {
    if (isElectric) {
      if (!battery.isBatteryEmpty()) {
        motor.turnOn();

        /**
         * Set to true when the car starts
         */
        isCarRunning = true;
        System.out.println("Electric car has started.");
      } else {
        System.out.println("Cannot start the car. The battery is empty.");
      }
    } else {
      if (!gasContainer.isGasEmpty()) {
        motor.turnOn();

        /**
         * Set to true when the car starts
         */
        isCarRunning = true;
        System.out.println("Benzine car has started.");
      } else {
        System.out.println("Cannot start the car. The gas container is empty.");
      }
    }
  }

  /**
   * Turns off the car and updates its state accordingly.
   */
  private void turnOff() {
    motor.turnOff();
    isCarRunning = false;
    System.out.println("Car has been turned off.");
  }

  /**
   * Attempts to accelerate the car by increasing power based on the pressure
   * applied to the gas pedal.
   * @param pressure The amount of pressure applied to the gas pedal, affecting
   *     acceleration.
   */
  public void pressGasPedal(int pressure) {
    if (motor instanceof ElectricMotor) {
      if (!battery.isBatteryEmpty()) {
        motor.increasePower(pressure);
      } else {
        /**
         * if there is no energy turn off the car.
         */
        press();
      }
    } else if (motor instanceof BenzineMotor) {
      if (!gasContainer.isGasEmpty()) {
        motor.increasePower(pressure);
      } else {
        /**
         * if there is no enough fuel turn off the car.
         */
        press();
      }
    }
    speedometer.increaseSpeed(pressure);
  }

  /**
   * Applies the brake, decreasing the car's speed based on the pressure applied
   * to the brake pedal.
   * @param pressure The amount of pressure applied to the brake pedal.
   */
  public void pressBrakePedal(int pressure) {
    speedometer.decreaseSpeed(pressure);
  }

  /**
   * Turns the radio on if the small battery has enough charge.
   */
  public void turnOnRadio() {
    if (!smallBattery.isBatteryEmpty()) {
      System.out.println("Radio is turned on.");

      /**
       * Set the radio state to on
       */
      isRadioOn = true;

      /**
       * Consume battery energy
       */
      smallBattery.consumeEnergy(1);
    } else {
      System.out.println(
          "Cannot turn on the radio. The small battery is empty.");
    }
  }

  /**
   * Turns the radio off.
   */
  public void turnOffRadio() {
    /**
     * Turn off the radio
     */
    isRadioOn = false;
    System.out.println("Radio is turned off.");
  }

  public boolean isRadioOn() { return isRadioOn; }

  public int getSpeed() { return speedometer.getCurrentSpeed(); }

  public boolean isElectric() { return isElectric; }

  public Battery getBattery() {
    return battery; 
  }

  public GasContainer getGasContainer() {
    return gasContainer; 
  }

  public boolean isCarRunning() { return isCarRunning; }

  // Method to update car's state
  public void update() {
    if (isCarRunning) {
      // Car is running, recharge the small battery
      smallBattery.recharge(1);
    } else if (isRadioOn) {
      // Car is not running, but radio is on, consume energy from small battery
      smallBattery.consumeEnergy(1); 
    }
  }

  public SmallBattery getSmallBattery() { return smallBattery; }
}
