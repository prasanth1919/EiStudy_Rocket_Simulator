// Command Pattern Interface
interface Command {
    void execute();
}

// Command Pattern for Launch
class LaunchCommand implements Command {
    private RocketLaunchSimulator simulator;

    public LaunchCommand(RocketLaunchSimulator simulator) {
        this.simulator = simulator;
    }

    @Override
    public void execute() {
        try {
            simulator.launch();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Command Pattern for Start Checks
class StartChecksCommand implements Command {
    private RocketLaunchSimulator simulator;

    public StartChecksCommand(RocketLaunchSimulator simulator) {
        this.simulator = simulator;
    }

    @Override
    public void execute() {
        simulator.startChecks();
    }
}

// Command Pattern for Fast Forward
class FastForwardCommand implements Command {
    private RocketLaunchSimulator simulator;
    private int seconds;

    public FastForwardCommand(RocketLaunchSimulator simulator, int seconds) {
        this.simulator = simulator;
        this.seconds = seconds;
    }

    @Override
    public void execute() {
        simulator.fastForward(seconds);
    }
}
