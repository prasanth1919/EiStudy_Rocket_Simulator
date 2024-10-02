abstract class RocketDecorator extends RocketType {
    protected RocketType decoratedRocket;

    public RocketDecorator(RocketType decoratedRocket) {
        super(decoratedRocket.rocket);
        this.decoratedRocket = decoratedRocket;
    }

    @Override
    public void create() {
        decoratedRocket.create();
    }
}

class ExtraFuelRocket extends RocketDecorator {
    public ExtraFuelRocket(RocketType decoratedRocket) {
        super(decoratedRocket);
    }

    @Override
    public void create() {
        super.create();
        System.out.println("Adding extra fuel to the rocket...");
        rocket.setFuel(rocket.getFuel() + 30);
    }
}
