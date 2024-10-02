abstract class RocketType {
    protected Rocket rocket;

    public RocketType(Rocket rocket) {
        this.rocket = rocket;
    }

    abstract void create();
}

class LightRocket extends RocketType {

    public LightRocket(Rocket rocket) {
        super(rocket);
    }

    @Override
    void create() {
        System.out.println("Creating Light Rocket...");
        rocket.setFuelConsumptionRate(10);
        rocket.setFuel(rocket.getFuel() + 20);
        rocket.setSpeed(rocket.getSpeed() + 500);
    }
}

class HeavyRocket extends RocketType {

    public HeavyRocket(Rocket rocket) {
        super(rocket);
    }

    @Override
    void create() {
        System.out.println("Creating Heavy Rocket...");
        rocket.setFuelConsumptionRate(15);
        rocket.setFuel(rocket.getFuel() + 50);
        rocket.setSpeed(rocket.getSpeed() + 200);
    }
}

class RocketFactory {
    public static RocketType createRocket(String type, Rocket rocket) {
        switch (type.toLowerCase()) {
            case "light":
                return new LightRocket(rocket);
            case "heavy":
                return new HeavyRocket(rocket);
            default:
                throw new IllegalArgumentException("Unknown rocket type");
        }
    }
}
