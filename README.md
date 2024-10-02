# EiStudy_Rocket_Simulator
🚀 
Rocket Launch Simulator
Welcome to the Rocket Launch Simulator! This is a fun terminal-based simulation where you can experience launching a rocket into space, separating its stages, and reaching orbit. The simulation is real-time (or fast-forwarded if you're in a hurry!) and gives you updates on how your mission is going.

Features :
1. Pre-Launch Checks: Make sure everything is ready for launch with a simple command.
2. Live Updates: See real-time updates on your rocket's fuel, altitude, speed, and stage.
3. Stage Separation: Watch as the rocket automatically separates stages every 50 km of altitude gain.
4. Orbit Achievement: Celebrate when your rocket successfully reaches its target orbit!
5. Fast Forward: Skip the waiting by fast-forwarding through the simulation.
6. Observer Notifications: Behind the scenes, the rocket sends updates to different observers (like a display and a logger).

Getting Started
What You Need:
Java 8 or higher installed on your machine. You can check if it's installed by running:
bash
Copy java -version and paste

Running the Simulator:
Clone the Project:
bash
Copy code
git clone https://github.com/your-username/rocket-launch-simulator.git
cd rocket-launch-simulator
Compile the Java Files: Before you run the simulator, you need to compile it. In your terminal, run:

bash
Copy code
javac *.java
Start the Simulation: Now you're ready to launch your rocket! Run:

bash
Copy code
java RocketLaunchSimulator

How to Play
When you start the simulator, it will ask you to input some details about your rocket:

-Fuel percentage: Enter a value between 0 and 100 (e.g., 80 for 80% fuel).
-Orbit distance: How high you want your rocket to go (in kilometers).
-Starting altitude: The altitude from where your rocket starts (in kilometers).
-Initial speed: The speed of your rocket at launch (in kilometers per hour).
-Rocket type: Choose between "light" and "heavy" rockets. Light rockets use less fuel, but heavy rockets carry more.
-Extra fuel: Want to play it safe? You can add extra fuel to your rocket if you say "yes."

Commands You Can Use
*start_checks: This command runs pre-launch checks to make sure everything is good to go.
*launch: Start the launch and see real-time updates.
*fast_forward X: Skip ahead by X seconds (e.g., fast_forward 5 to jump 5 seconds into the future).
*exit: Want to quit? Just type exit.

Example Walkthrough:
Here’s an example of what it might look like:

bash
Copy code
+Enter the initial fuel percentage (0 to 100): 80
+Enter the target orbit distance (in km): 200
+Enter the starting altitude (in km): 10
+Enter the initial speed (in km/h): 1000
+Enter the rocket type (light or heavy): light
+Do you want to add extra fuel? (yes or no): yes
+All systems are 'Go' for launch.
+Enter a command (start_checks, launch, fast_forward X, or exit): launch
+After launching, you'll see updates about your rocket’s status, and once it reaches the orbit, you’ll get a message saying the mission was successful!
