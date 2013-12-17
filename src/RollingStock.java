
public abstract class RollingStock {

	private String ownerName; //i.e. B&O, Reading, Pennsylvania, ShortLine
	private int id; //unique identification number
	private double baseFrameWeight; //including wheels
	
	public RollingStock(String ownerName, int id, double baseFrameWeight)
	{
		this.ownerName = ownerName;
		this.id = id;
		this.baseFrameWeight = baseFrameWeight;
	}
	
	public String getOwnerName()
	{
		return this.ownerName;
	}
	
	public int getID()
	{
		return this.id;
	}
	
	public void setID(int id)
	{
		this.id = id;
	}
	
	public double getBaseFrameWeight()
	{
		return baseFrameWeight;
	}

}
