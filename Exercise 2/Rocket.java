import java.util.List;
import java.util.ArrayList;

public class Rocket {
    private double fuel;
    private double altitude;
    private double speed;
    private double orbit;
    private int stage;
    private boolean orbitAchieved;
    private double fuelConsumptionRate;
    private List<Observer> observers = new ArrayList<>();

    public Rocket(double fuel, double altitude, double speed, double orbit, int stage) {
        this.fuel = fuel;
        this.altitude = altitude;
        this.speed = speed;
        this.orbit = orbit;
        this.stage = stage;
        this.orbitAchieved = false;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void update(int seconds) {
        for (int i = 0; i < seconds; i++) {
            if (fuel <= 0) {
                notifyObservers("Mission Failed due to insufficient fuel.");
                break;
            }

            fuel -= fuelConsumptionRate;
            altitude += 10;
            speed += 1000;

            if ((int) (altitude / 50) + 1 > stage) {
                stage = (int) (altitude / 50) + 1;
                notifyObservers(String.format("Stage %d complete. Entering Stage %d.", stage - 1, stage));
            }

            if (altitude >= orbit) {
                orbitAchieved = true;
                notifyObservers("Orbit achieved! Mission Successful.");
                break;
            }

            notifyObservers(String.format("Fuel: %.2f%%, Altitude: %.2f km, Speed: %.2f km/h", fuel, altitude, speed));
        }
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setFuelConsumptionRate(double fuelConsumptionRate) {
        this.fuelConsumptionRate = fuelConsumptionRate;
    }

    public double getAltitude() {
        return altitude;
    }

    public double getSpeed() {
        return speed;
    }

    public int getStage() {
        return stage;
    }

    public boolean isOrbitAchieved() {
        return orbitAchieved;
    }
}
