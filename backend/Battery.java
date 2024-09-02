/**
 * Represents the battery of an electric car, managing its charge level.
 * The battery charge can be consumed for car operations and recharged when
 * needed.
 */
class Battery {
  
  private int chargeLevel;

  /**
   * Maximum level to which the battery can be charged.
   */
  static final int MAX_CHARGE_LEVEL = 100;

  /**
   * Minimum (empty) level of the battery.
   */
  static final int MIN_CHARGE_LEVEL = 0;

  /**
   * Constructs a Battery instance with a specified charge level.
   *
   * @param chargeLevel the initial charge level of the battery.
   */
  public Battery(int chargeLevel) { this.chargeLevel = chargeLevel; }

  /**
   * Consumes a specified amount of energy from the battery.
   * Ensures that the battery's charge level does not fall below the minimum
   * level.
   *
   * @param amount the amount of energy to consume.
   */
  public void consumeEnergy(int amount) {
    // to make sure that the battery level is not lower than zero.
    chargeLevel = Math.max(chargeLevel - amount, MIN_CHARGE_LEVEL);
  }

  /**
   * Recharges the battery by a specified amount.
   * Ensures that the battery's charge level does not exceed the maximum level.
   *
   * @param amount the amount of energy to add to the battery's charge.
   */
  public void recharge(int amount) {
    /* Implementation to recharge battery
     * the battery level is full at 100, so it cannot be recharged with
     *  more amount of power than the max level.
     */
    chargeLevel = Math.min(chargeLevel + amount, MAX_CHARGE_LEVEL);
  }

  /**
   * Checks if the battery is empty.
   *
   * @return true if the battery's charge level is at or below the minimum
   *     level, false otherwise.
   */
  public boolean isBatteryEmpty() {
    // check if the battery is empty
    return chargeLevel <= MIN_CHARGE_LEVEL;
  }

  /**
   * Retrieves the current charge level of the battery.
   *
   * @return the current charge level of the battery.
   */
  public int getChargeLevel() { return chargeLevel; }
}