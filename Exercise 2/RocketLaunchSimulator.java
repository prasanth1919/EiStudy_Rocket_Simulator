import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.InputMismatchException;

public class RocketLaunchSimulator {
    private static final Logger LOGGER = Logger.getLogger(RocketLaunchSimulator.class.getName());
    private Rocket rocket;
    private boolean preLaunchChecksComplete = false;

    public RocketLaunchSimulator(double fuel, double orbit, double altitude, double speed) {
        this.rocket = new Rocket(fuel, altitude, speed, orbit, 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            double fuel = getValidFuelInput(scanner);

            System.out.print("Enter the target orbit distance (in km): ");
            double orbit = scanner.nextDouble();
            if (orbit <= 0) throw new IllegalArgumentException("Orbit distance must be positive!");

            System.out.print("Enter the starting altitude (in km): ");
            double altitude = scanner.nextDouble();
            if (altitude < 0) throw new IllegalArgumentException("Altitude cannot be negative!");

            System.out.print("Enter the initial speed (in km/h): ");
            double speed = scanner.nextDouble();
            if (speed < 0) throw new IllegalArgumentException("Speed cannot be negative!");

            String rocketTypeInput = getValidRocketTypeInput(scanner);

            RocketLaunchSimulator simulator = new RocketLaunchSimulator(fuel, orbit, altitude, speed);
            RocketType rocketType = RocketFactory.createRocket(rocketTypeInput, simulator.rocket);
            rocketType.create();

            String addExtraFuel = getValidYesNoInput(scanner, "Do you want to add extra fuel? (yes or no): ");
            if (addExtraFuel.equals("yes")) {
                RocketType extraFuelRocket = new ExtraFuelRocket(rocketType);
                extraFuelRocket.create();
            }

            simulator.start();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            LOGGER.log(Level.SEVERE, "An exception occurred", e);
        }
    }

    private static double getValidFuelInput(Scanner scanner) {
        double fuel;
        while (true) {
            try {
                System.out.print("Enter the initial fuel percentage (0 to 100): ");
                fuel = scanner.nextDouble();
                if (fuel < 0 || fuel > 100) {
                    System.out.println("Invalid fuel percentage. Please enter a value between 0 and 100.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number for fuel percentage.");
                scanner.next();
            }
        }
        return fuel;
    }

    private static String getValidYesNoInput(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.next().toLowerCase();
            if (input.equals("yes") || input.equals("no")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
        return input;
    }

    private static String getValidRocketTypeInput(Scanner scanner) {
        String input;
        while (true) {
            System.out.print("Enter the rocket type (light or heavy): ");
            input = scanner.next().toLowerCase();
            if (input.equals("light") || input.equals("heavy")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'light' or 'heavy'.");
            }
        }
        return input;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            try {
                System.out.println("Enter a command (start_checks, launch, fast_forward X, or exit):");
                input = scanner.nextLine();

                Command command = null;
                if (input.equals("exit")) {
                    LOGGER.info("Exiting the simulator.");
                    break;
                } else if (input.equals("start_checks")) {
                    command = new StartChecksCommand(this);
                } else if (input.equals("launch")) {
                    if (preLaunchChecksComplete) {
                        command = new LaunchCommand(this);
                    } else {
                        System.out.println("Pre-launch checks not complete. Please type start_checks first.");
                    }
                } else if (input.startsWith("fast_forward")) {
                    String[] parts = input.split(" ");
                    if (parts.length == 2) {
                        int seconds = Integer.parseInt(parts[1]);
                        command = new FastForwardCommand(this, seconds);
                    } else {
                        System.out.println("Invalid fast_forward command. Use: fast_forward X");
                    }
                } else {
                    System.out.println("Invalid command.");
                }

                if (command != null) {
                    command.execute();
                }

            } catch (NumberFormatException e) {
                LOGGER.log(Level.WARNING, "Invalid number format in fast_forward command.", e);
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "An unexpected error occurred.", e);
            }
        }
        scanner.close();
    }

    public void startChecks() {
        System.out.println("All systems are 'Go' for launch.");
        preLaunchChecksComplete = true;
        LOGGER.info("Pre-launch checks completed successfully.");
    }

    public void launch() throws InterruptedException {
        System.out.println("Launch initiated!");
        rocket.addObserver(new DisplayObserver());
        rocket.addObserver(new LoggerObserver());
        while (rocket.getFuel() > 0 && !rocket.isOrbitAchieved()) {
            rocket.update(1);
            Thread.sleep(1000);
        }

        if (rocket.isOrbitAchieved()) {
            System.out.println("Orbit achieved! Mission Successful.");
        } else {
            System.out.println("Mission Failed due to insufficient fuel.");
        }
    }

    public void fastForward(int seconds) {
        System.out.println("Fast forwarding " + seconds + " seconds.");
        rocket.update(seconds);
        displayStatus();
    }

    private void displayStatus() {
        System.out.printf("Stage: %d, Fuel: %.2f%%, Altitude: %.2f km, Speed: %.2f km/h%n",
                rocket.getStage(), rocket.getFuel(), rocket.getAltitude(), rocket.getSpeed());
    }
}
