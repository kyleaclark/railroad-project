import java.util.ArrayList;
import java.util.Scanner;

public class Train {
	
	private String engineerName;
	
	private ArrayList<FreightCar> transporter = new ArrayList<FreightCar>();
	
	private Engine motor;
	
	private double maxFreightCarLoad; //NEEDED FOR CALLING METHODS OUTSIDE OF MAIN WHICH REQUIRE VARIABLE VALUE
	
	private final static int OIL_DENSITY = 55;
	private final static double OIL_VALUE = 7.85;
	private final static int COAL_DENSITY = 69;
	private final static double COAL_VALUE = 50;
	private final static int SOYBEANS_DENSITY = 47;
	private final static double SOYBEANS_VALUE = 2.72;
	private final static int LINSEED_DENSITY = 32;
	private final static double LINSEED_VALUE = 0.07;
	private final static int OATS_DENSITY = 27;
	private final static double OATS_VALUE = 1.30;
		
	
	public Train(String engineerName, Engine motor)
	{
		this.engineerName = engineerName;
		this.motor = motor;  
	}
	
	public String getEngineerName()
	{
		return this.engineerName;
	}
	
	public void deleteFreightCar(int id)
	{
		int i = 0;

		for(FreightCar auto : transporter)
		{
			if(auto.getID() == id)
			{
				transporter.remove(i);
				break;
			}
			i++;
		}	
	}
	
	public void changeLoadFactor(int id, double loadFactor)
	{	
		int i = 0;

		for(FreightCar auto : transporter)
		{
			i++;
			if(auto.getID() == id)
			{
				auto.setLoadFactor(loadFactor);
				break;
			}
		}
	}
	
	public double computeTotalTrainWeight()
	{
		double totalWeight = 0;		
		
		for(FreightCar auto : transporter)
		{
			totalWeight += auto.computeTotalWeight();
		}
		
		return totalWeight;
	}
	
	public double computeTotalTrainValue()
	{
		double totalValue = 0;		
		
		for(FreightCar auto : transporter)
		{
			totalValue += auto.computeTotalValue();
		}
		
		return totalValue;
	}
	
	public void setMaxFreightCarLoad(double maxFreightCarLoad)
	{
		this.maxFreightCarLoad = maxFreightCarLoad;
	}
	
	public double getMaxFreightCarLoad()
	{
		return maxFreightCarLoad;
	}
	
	public static String promptEngineerName(Scanner keyboard)
	{
		System.out.println("ENTER NAME OF THE TRAIN ENGINEER: ");
		String engineerName = keyboard.next();
		return engineerName;
	}
	
	public static double promptPullingCapacity(Scanner keyboard)
	{
		System.out.println("ENTER ENGINE DESCRIPTION (PULLING CAPACITY) OF THE TRAIN: ");
		double pullingCapacity = keyboard.nextDouble();
		return pullingCapacity;
	}
	
	public static void promptMenuOptions(Train track, Scanner keyboard)
	{
		String menuOption = " ";
		
		do
		{
			menuOption = " ";
			System.out.println("\nENTER A MENU OPTION: A, B, C, D, E, F");
			System.out.println("(A) ADD FREIGHT CAR");
			System.out.println("(B) DISPLAY A COMPLETE CHARACTERISTIC DESCRIPTION OF THE TRAIN, ENGINE, & CARS + " +
					"(WITHOUT THE COMPUTED QUANTITIES LIKE WEIGHT & VALUE)");
			System.out.println("(C) DISPLAY A BRIEF SUMMARY IDENTIFYING EACH FREIGHT CAR (ID #), INCLUDING ITS WEIGHT & VALUE, AND IF ANY + " +
					"FREIGHT CAR HAS WEIGHT GREATHER THAN THE MAXIMUM ALLOWED");
			System.out.println("(D) DISPLAY THE TOTAL WEIGHT & VALUE OF THE TRAIN, AS WELL AS THE NUMBER OF CARS, AND IF THE TOTAL WEIGHT + " +
					"OF THE TRAIN IS GREATER THAN THE PULLING CAPACITY OF THE ENGINE");
			System.out.println("(E) START A NEW TRAIN & ENGINE");
			System.out.println("(F) EXIT THE PROGRAM");
			
			do {
				menuOption = keyboard.next(); 
			}while((menuOption.equalsIgnoreCase("A") == false) && (menuOption.equalsIgnoreCase("B") == false) &&
				   (menuOption.equalsIgnoreCase("C") == false) && (menuOption.equalsIgnoreCase("D") == false) &&
				   (menuOption.equalsIgnoreCase("E") == false) && (menuOption.equalsIgnoreCase("F") == false));
			
			if(menuOption.equalsIgnoreCase("A") == true)
			{
				track.addFreightCar(keyboard);
			}
			else if(menuOption.equalsIgnoreCase("B") == true)
			{
				track.promptDisplayDescription();
			}
			else if(menuOption.equalsIgnoreCase("C") == true)
			{
				track.promptDisplaySummary();
			}
			else if(menuOption.equalsIgnoreCase("D") == true)
			{
				track.promptDisplayReport();
			}
			else if(menuOption.equalsIgnoreCase("E") == true)
			{
				track = track.startNewTrainAndEngine(keyboard);
			}
			else if(menuOption.equalsIgnoreCase("F") == true)
			{
				break;
			}
		}while(1 > 0); //EXITS ON BREAK FOR MENU OPTION "F"
				
	}
	
	public void addFreightCar(Scanner keyboard)
	{
		String ownerName = null; //CAR OWNER NAME
		int id = 0; //CAR ID NUMBER
		double baseFrameWeight = 0; //BASE FRAME WEIGHT -- DENSITY X THICKNESS
		double wheels = 0; //WEIGHT OF WHEELS WILL BE ADDED TO BASE FRAME WEIGHT
		String shape = null; //TANK, BOX, HOPPER
		String contentsType = null; //OIL, COAL, SOYBEANS, LINSEED, OATS
		int contentsDensity = 0; //CONTENTS DENSITY
		double contentsValue = 0; //CONTENTS VALUE
		double loadFactor = 0; //PERCENTAGE CONTAINER FULL OF CONTENTS
		Container holder = null;
		Contents holdings = null;
		
		//PROMPT FOR CAR OWNER NAME
		System.out.println("ENTER THE CAR OWNER NAME: ");
		ownerName = keyboard.next();
		
		//PROMPT FOR CAR ID NUMBER
		System.out.println("ENTER THE CAR ID NUMBER (INTEGER ONLY): ");
		id = keyboard.nextInt();
		
		System.out.println("ENTER THE WEIGHT OF THE CAR WHEELS: ");
		wheels = keyboard.nextDouble();
		
		//PROMPT FOR CONTAINER SHAPE TYPE
		System.out.println("ENTER THE SHAPE OF THE FREIGHT CAR: TANK (CYLINDRICAL), BOX (RECTANGULAR), HOPPER (TRAPEZOIDAL)");
		do {
			shape = keyboard.next(); 
			if((shape.equalsIgnoreCase("TANK") == false) && (shape.equalsIgnoreCase("BOX") == false) && (shape.equalsIgnoreCase("HOPPER") == false))
			{
				System.out.println("INVALID ENTRY: ENTER TANK, BOX, OR HOPPER");
			}
		}while((shape.equalsIgnoreCase("TANK") == false) && (shape.equalsIgnoreCase("BOX") == false) && (shape.equalsIgnoreCase("HOPPER") == false));
		
		
		//PROMPT FOR DIMENSIONS APPROPRIATE TO CONTAINER SHAPE TYPE
		if(shape.equalsIgnoreCase("TANK") == true)
		{
			System.out.println("ENTER THE HEIGHT OF THE TANK: ");
			double height = keyboard.nextDouble();
			System.out.println("ENTER THE RADIUS OF THE TANK: ");
			double radius = keyboard.nextDouble();
			System.out.println("ENTER THE THICKNESS OF THE TANK: ");
			double thickness = keyboard.nextDouble();
			System.out.println("ENTER THE DENSITY OF THE TANK: ");
			double density = keyboard.nextDouble();
			holder = new Cylinder(height, radius, thickness, density);
		}
		else if(shape.equalsIgnoreCase("BOX") == true)
		{
			System.out.println("ENTER THE WIDTH OF THE BOX: ");
			double width = keyboard.nextDouble();
			System.out.println("ENTER THE HEIGHT OF THE BOX: ");
			double height = keyboard.nextDouble();
			System.out.println("ENTER THE LENGTH OF THE BOX: ");
			double length = keyboard.nextDouble();
			System.out.println("ENTER THE THICKNESS OF THE BOX: ");
			double thickness = keyboard.nextDouble();
			System.out.println("ENTER THE DENSITY OF THE BOX: ");
			double density = keyboard.nextDouble();
			holder = new Rectangle(width, height, length, thickness, density);
		}
		else if(shape.equalsIgnoreCase("HOPPER") == true)
		{
			System.out.println("ENTER THE WIDTH OF THE HOPPER: ");
			double width = keyboard.nextDouble();
			System.out.println("ENTER THE HEIGHT OF THE HOPPER: ");
			double height = keyboard.nextDouble();
			System.out.println("ENTER THE UPPER LENGTH OF THE HOPPER: ");
			double upperLength = keyboard.nextDouble();
			System.out.println("ENTER THE LOWER LENGTH OF THE HOPPER: ");
			double lowerLength = keyboard.nextDouble();
			System.out.println("ENTER THE THICKNESS OF THE HOPPER: ");
			double thickness = keyboard.nextDouble();
			System.out.println("ENTER THE DENSITY OF THE HOPPER: ");
			double density = keyboard.nextDouble();
			holder = new Trapezoid(width, height, upperLength, lowerLength, thickness, density);
		}
		
		//CONTENTS MENU DISPLAY
		System.out.println("CONTENTS        DENSITY (LBS PER CUBIC FOOT)     VALUE ($ PER LB)");
		System.out.println("OIL             " + OIL_DENSITY + "                               " + OIL_VALUE);
		System.out.println("COAL            " + COAL_DENSITY + "                               " + COAL_VALUE);
		System.out.println("SOYBEANS        " + SOYBEANS_DENSITY + "                               " + SOYBEANS_VALUE);
		System.out.println("LINSEED         " + LINSEED_DENSITY + "                               " + LINSEED_VALUE);
		System.out.println("OATS            " + OATS_DENSITY + "                               " + OATS_VALUE);
		System.out.println("\nENTER CONTENTS: OIL, COAL, SOYBEANS, LINSEED, OR OATS");
		
		//PROMPT FOR THE CONTENTS TYPE
		do {
			contentsType = keyboard.next(); 
			if((contentsType.equalsIgnoreCase("OIL") == false) && (contentsType.equalsIgnoreCase("COAL") == false) && (contentsType.equalsIgnoreCase("SOYBEANS") == false)
					&& (contentsType.equalsIgnoreCase("LINSEED") == false) && (contentsType.equalsIgnoreCase("OATS") == false))
			{
				System.out.println("INVALID ENTRY: ENTER OIL, COAL, SOYBEANS, LINSEED, OR OATS");
			}
		}while((contentsType.equalsIgnoreCase("OIL") == false) && (contentsType.equalsIgnoreCase("COAL") == false) && (contentsType.equalsIgnoreCase("SOYBEANS") == false)
				&& (contentsType.equalsIgnoreCase("LINSEED") == false) && (contentsType.equalsIgnoreCase("OATS") == false));
		
		//SET THE DENSITY & VALUE OF THE CONTENTS BASED ON THE CONTENTS TYPE SELECTION
		if(contentsType.equalsIgnoreCase("OIL") == true)
		{
			contentsDensity = OIL_DENSITY;
			contentsValue = OIL_VALUE;
		}
		else if(contentsType.equalsIgnoreCase("COAL") == true)
		{
			contentsDensity = COAL_DENSITY;
			contentsValue = COAL_VALUE;
		}
		else if(contentsType.equalsIgnoreCase("SOYBEANS") == true)
		{
			contentsDensity = SOYBEANS_DENSITY;
			contentsValue = SOYBEANS_VALUE;
		}
		else if(contentsType.equalsIgnoreCase("LINSEED") == true)
		{
			contentsDensity = LINSEED_DENSITY;
			contentsValue = LINSEED_VALUE;
		}
		else if(contentsType.equalsIgnoreCase("OATS") == true)
		{
			contentsDensity = OATS_DENSITY;
			contentsValue = OATS_VALUE;
		}
		
		holdings = new Contents(contentsType, contentsDensity, contentsValue);
		
		System.out.println("ENTER THE LOAD FACTOR (PERCENTAGE OF THE CONTAINER FULL OF CONTENTS)");
		loadFactor = keyboard.nextDouble();
		
		//CALCULATE BASE FRAME WEIGHT -- DENSITY X THICKNESS
		baseFrameWeight = (holder.getDensity() * holder.getThickness()) + wheels;
		
		transporter.add(new FreightCar(ownerName, id, baseFrameWeight, loadFactor, holder, holdings));
	}
	
	//DISPLAY A COMPLETE CHARACTERISTIC DESCRIPTION OF THE TRAIN, ENGINE, & CARS 
	//(WITHOUT THE COMPUTED QUANTITIES LIKE WEIGHT & VALUE)
	public void promptDisplayDescription()
	{		
		System.out.println("TRAIN ENGINEER NAME: " + getEngineerName());
		System.out.printf("ENGINE PULLING CAPACITY: %.2f%n", motor.getPullingCapacity());
		
		for(FreightCar auto : transporter)
		{
			System.out.println(auto.toString("B"));
		}		
	}
	
	//DISPLAY A BRIEF SUMMARY IDENTIFYING EACH FREIGHT CAR (ID #), INCLUDING ITS WEIGHT & VALUE, 
	//AND IF ANY FREIGHT CAR HAS WEIGHT GREATHER THAN THE MAXIMUM ALLOWED
	public void promptDisplaySummary()
	{
		for(FreightCar auto : transporter)
		{
			System.out.println(auto.toString("C"));
			if(auto.computeTotalWeight() > maxFreightCarLoad)
			{
				System.out.println("\nWARNING: TOTAL WEIGHT OF FREIGHT CAR HAS EXCEEDED MAXIMUM ACCEPTABLE LOAD FOR A SINGLE CAR!");
			}
		}	
	}
	
	//DISPLAY THE TOTAL WEIGHT & VALUE OF THE TRAIN, AS WELL AS THE NUMBER OF CARS, 
	//AND IF THE TOTAL WEIGHT OF THE TRAIN IS GREATER THAN THE PULLING CAPACITY OF THE ENGINE
	public void promptDisplayReport()
	{
		double trainTotalWeight = 0;
		double trainTotalValue = 0;
		int numberOfCars = 0;
		
		for(FreightCar auto : transporter)
		{
			trainTotalWeight += auto.computeTotalWeight();
			trainTotalValue += auto.computeTotalValue();
			numberOfCars++;
		}
		
		System.out.println("TOTAL NUMBER OF CARS IN TRAIN: " + numberOfCars);
		System.out.println("TOTAL WEIGHT OF TRAIN: " + trainTotalWeight);
		System.out.println("TOTAL VALUE OF TRAIN: " + trainTotalValue);
		
		if(trainTotalWeight > motor.getPullingCapacity())
		{
			System.out.println("WARNING: TOTAL WEIGHT OF TRAIN (" + trainTotalWeight + ") EXCEEDS ENGINE PULLING CAPACITY (" + motor.getPullingCapacity() + ")");
		}
	}
	
	//START NEW TRAIN & ENGINE
	public Train startNewTrainAndEngine(Scanner keyboard)
	{
		int tempID = 0;
		int i = 0;
		
		//START NEW TRAIN
		System.out.println("NEW TRAIN INITIATED\n\n");
		
		FreightCar auto = null;
		while(transporter.isEmpty() == false)
		{
			auto = transporter.get(i);
		    tempID = auto.getID();
			deleteFreightCar(tempID);
			i++;
		}
		
		//CURRENT RAILROAD CONDITIONS = MAXIMUM ACCEPTABLE LOAD FOR A SINGLE CAR
		System.out.println("DESCRIBE CURRENT RAIL CONDITIONS (INPUT MAXIMUM ACCEPTABLE LOAD FOR A SINGLE CAR): ");
		double maxFreightCarLoad = keyboard.nextDouble();
		
		//ENGINEER NAME
		String engineerName = promptEngineerName(keyboard);
		
		//ENGINGE PULLING CAPACITY
		double pullingCapacity = promptPullingCapacity(keyboard);
		
		//CONSTRUCT NEW ENGINE OBJECT
		Engine mainMotor = new Engine(pullingCapacity);
		
		//CONSTRUCT NEW TRAIN OBJECT
		Train track = new Train(engineerName, mainMotor);
		
		//SET THE TRAIN OBJECT MAX FREIGHT CAR LOAD VALUE
		track.setMaxFreightCarLoad(maxFreightCarLoad);
		
		return track;
	}

	public static void main(String[] args)
	{	
		Scanner keyboard = new Scanner(System.in);
		
		//CURRENT RAILROAD CONDITIONS = MAXIMUM ACCEPTABLE LOAD FOR A SINGLE CAR
		System.out.println("DESCRIBE CURRENT RAIL CONDITIONS (INPUT MAXIMUM ACCEPTABLE LOAD FOR A SINGLE CAR): ");
		double maxFreightCarLoad = keyboard.nextDouble();
		
		//ENGINEER NAME
		String engineerName = promptEngineerName(keyboard);
		
		//ENGINGE PULLING CAPACITY
		double pullingCapacity = promptPullingCapacity(keyboard);
		
		//CONSTRUCT NEW ENGINE OBJECT
		Engine mainMotor = new Engine(pullingCapacity);
		
		//CONSTRUCT NEW TRAIN OBJECT
		Train track = new Train(engineerName, mainMotor);
		
		//SET THE TRAIN OBJECT MAX FREIGHT CAR LOAD VALUE
		track.setMaxFreightCarLoad(maxFreightCarLoad);
		
		//LOOPS UNTIL USER CHOOSES TO EXIT
		promptMenuOptions(track, keyboard);
				
	}
	
}
