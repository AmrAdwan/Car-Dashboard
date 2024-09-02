/**
 * Represents the gas container class, which is reponsible of the gas level
 * in the container. It is reponsible of the consumption, refilling of the
 * the gas.
 */
class GasContainer {
  private int gasLevel;

  /**
   * Maximum level of gas in the container
   */
  static final int MAX_GAS_LEVEL = 100;

  /**
   * Minimum level of gas in the container
   */
  static final int MIN_GAS_LEVEL = 0;

  /**
   * Constructs a GasContainer instance with a specified gas level.
   * @param gasLevel the initial level of gas in the container.
   */
  public GasContainer(int gasLevel) { this.gasLevel = gasLevel; }

  /**
   * Calculates the gas consumption of the car while driving. It ensures
   * that the consumption cannot be lower than the minimum volum of the
   * container.
   * @param amount represents the gas amount that is being consumed.
   */
  public void consumeGas(int amount) {
    /*
     * To make sure that the tank is not lower than zero.
     */
    gasLevel = Math.max(gasLevel - amount, MIN_GAS_LEVEL);
  }

  /**
   * Responsible of refilling of the gas container and makes sure that the
   * gas level cannot be more than the maximum volume of the container.
   * @param amount
   */
  public void refillGas(int amount) {
    /* the gas container is full at 100, so it cannot be filled with
     *  more amount of gas.
     */
    gasLevel = Math.min(gasLevel + amount, MAX_GAS_LEVEL);
  }

  /**
   * Checks whether the gas container is empty or not.
   * @return true if the container is empty.
   */
  public boolean isGasEmpty() { return gasLevel <= MIN_GAS_LEVEL; }

  /**
   * Retrieves the gas level in the container.
   * @return the current level of the gas in the container.
   */
  public int getGasLevel() { return gasLevel; }
}