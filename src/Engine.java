
public class Engine {

	private double pullingCapacity; //max weight it can haul; description of engine
	
	public Engine(double pullingCapacity)
	{
		this.pullingCapacity = pullingCapacity;
	}
	
	public double getPullingCapacity()
	{
		return this.pullingCapacity;
	}
}
