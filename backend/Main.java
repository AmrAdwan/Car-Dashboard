import java.util.Scanner;

/**
 * Main class for running the interactive car simulation.
 * Allows users to choose between an electric or benzine car and perform various
 * actions like accelerating, braking, and toggling the car's and radio's power
 * state.
 */
public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    /**
     * Letting the user choose the type of car
     */
    System.out.println("Select the type of car:");
    System.out.println("1. Electric Car");
    System.out.println("2. Benzine Car");
    System.out.print("Enter choice (1 or 2): ");
    boolean isElectric = scanner.nextInt() == 1;
    Car car = new Car(isElectric);

    /**
     * Displaying the initial status of the car
     */
    displayStatus(car);

    boolean running = true;
    while (running) {
      System.out.println("\nOptions:");
      System.out.println("'A' - Accelerate");
      System.out.println("'B' - Brake");
      System.out.println("'R' - Toggle Radio On/Off");
      System.out.println("'T' - Toggle Car On/Off");
      if (!isElectric) {
        System.out.println("'F' - Refill Fuel");
      } else if (isElectric) {
        System.out.println("'F' - Recharge Battery");
      }
      System.out.println("'X' - Exit");
      System.out.print("Enter choice: ");
      String choice = scanner.next();

      /**
       * Case handling for acceleration, braking, and other car functionalities
       */
      switch (choice.toUpperCase()) {
      case "A":
        if (car.isCarRunning()) {
          System.out.print("Enter pressure to accelerate: ");
          int pressure = scanner.nextInt();
          car.pressGasPedal(pressure);
        } else {
          System.out.println(
              "The car is not running. Please start the car first.");
        }
        break;
      case "B":
        if (car.isCarRunning()) {
          car.pressBrakePedal(10); // Arbitrary pressure for braking
        } else {
          System.out.println(
              "The car is not running. Please start the car first.");
        }
        break;
      case "R":
        if (car.isRadioOn()) {
          car.turnOffRadio();
        } else {
          car.turnOnRadio();
        }
        break;
      case "T":
        car.press(); // Toggle car's state (on/off)
        break;
      case "F":
        if (!isElectric) {
          System.out.print("Enter amount of fuel to refill: ");
          int fuelAmount = scanner.nextInt();
          car.getGasContainer().refillGas(fuelAmount);
        } else {
          System.out.print("Enter amount of energy to recharge the battery: ");
          int chargeAmount = scanner.nextInt();
          car.getBattery().recharge(chargeAmount);
        }
        break;
      case "X":
        running = false;
        break;
      default:
        System.out.println("Invalid choice. Please try again.");
        break;
      }
      /**
       * Updating the car's state and displaying the current status
       */
      car.update();
      displayStatus(car);
    }

    scanner.close();

    /**
     * Ensure the car is turned off when the program is terminated
     */
    if (car.isCarRunning()) {
      car.press();
    }
    System.out.println("Application terminated.");
  }

  /**
   * Displays the current status of the car, including speed, battery level (for
   * electric cars), fuel level (for benzine cars), and the charge level of the
   * small battery.
   * @param car The car object whose status is to be displayed.
   */
  private static void displayStatus(Car car) {
    // Displaying speedometer and fuel/energy levels
    System.out.println("Current speed: " + car.getSpeed() + " km/h");

    if (car.isElectric()) {
      System.out.println("Battery level: " + car.getBattery().getChargeLevel());
    } else {
      System.out.println("Fuel level: " + car.getGasContainer().getGasLevel());
    }

    // Using getChargeLevel() method from SmallBattery class
    System.out.println(
        "Small battery level: " + car.getSmallBattery().getChargeLevel() + "%");
  }
}