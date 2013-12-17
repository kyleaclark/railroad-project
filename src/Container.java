
public abstract class Container {

	public double thickness;
	public double density;
	
	public Container(double thickness, double density)
	{
		this.thickness = thickness;
		this.density = density;
	}
	
	public double getThickness()
	{
		return thickness;
	}
	
	public double getDensity()
	{
		return density;
	}
	
	public abstract double computeInteriorVolume();
	
	public abstract double computeExteriorVolume();
	
	public double computeWallWeight()
	{
		double wallVolume = 0; //exterior volume - interior volume
		double wallWeight = 0; //wall density * wall volume
		double interiorVolume = computeInteriorVolume();
		double exteriorVolume = computeExteriorVolume();
		
		wallVolume = exteriorVolume - interiorVolume;
		
		wallWeight = density * wallVolume;
		
		return wallWeight;
	}
	
	public abstract String toString();
}
