
public class FreightCar extends RollingStock {
	
	private double loadFactor; //What percentage of the container is full
	private Container holder; 
	private Contents holdings;
	
	public FreightCar(String ownerName, int id, double baseFrameWeight, double loadFactor, Container holder, Contents holdings)
	{
		super(ownerName, id, baseFrameWeight);
		this.loadFactor = loadFactor;
		this.holder = holder;
		this.holdings = holdings;
	}
	
	public double getLoadFactor()
	{
		return this.loadFactor;
	}
	
	public void setLoadFactor(double loadFactor)
	{
		this.loadFactor = loadFactor;
	}
	
	public double computeTotalWeight()
	{
		double wallWeight = holder.computeWallWeight();
		double materialWeight = holdings.getDensity();
		materialWeight = materialWeight * ((loadFactor/100) * holder.computeInteriorVolume());
		return getBaseFrameWeight() + wallWeight + materialWeight; //baseFrame, walls, contents
	}
	
	public double computeTotalValue()
	{
		return computeTotalWeight() * holdings.getValue(); //weight of contents * price per lb
	}
	
	public String toString(String display)
	{
		String output = "";
		
		if(display.equals("B"))
		{
			output = "CAR OWNER NAME: " + super.getOwnerName();
			output = output + "\nCAR ID NUMBER: " + super.getID();
			output = output + "\nCAR BASE FRAME WEIGHT: " + super.getBaseFrameWeight();
			output = output + holder.toString() + "\n";
			output = output + holdings.toString();
		}
		if(display.equals("C"))
		{
			output = output + "\nCAR ID NUMBER: " + super.getID();
			output = output + "\nCAR WEIGHT: " + computeTotalWeight();
			output = output + "\nCAR VALUE: " + computeTotalValue();
		}
		
		return output;
	}
}
