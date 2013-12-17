
public class Trapezoid extends Container {

	private double width;
	private double height;
	private double upperLength;
	private double lowerLength;
	
	public Trapezoid(double width, double height, double upperLength, double lowerLength, double thickness, double density)
	{
		super(thickness, density);
		this.width = width;
		this.height = height;
		this.upperLength = upperLength;
		this.lowerLength = lowerLength;
	}
	
	public double getWidth()
	{
		return this.width;
	}
	
	public double getHeight()
	{
		return this.height;
	}
	
	public double getUpperLength()
	{
		return this.upperLength;
	}
	
	public double getLowerLength()
	{
		return this.lowerLength;
	}
	
	public double computeInteriorVolume()
	{
		double t = super.getThickness(); //get thickness from container class		
		return (1/2) * (upperLength - (2 * t) + lowerLength - (2 * t)) * (width - (2 * t)) * (height - t);
	}
	
	public double computeExteriorVolume()
	{		
		return (1/2) * (upperLength + lowerLength) * width * height;
	}
	
	public String toString()
	{
		String output = null;
		output = "CONTAINER TYPE: HOPPER (TRAPEZOID)";
		output = output + "\nWIDTH: " + width;
		output = output + "\nHEIGHT: " + height;
		output = output + "\nUPPER LENGTH: " + upperLength;
		output = output + "\nLOWER LENGTH: " + lowerLength;
		output = output + "\nTHICKNESS: " + super.getDensity();
		output = output + "\nDENSITY: " + super.getThickness();
		output = output + "\nINTERIOR VOLUME: " + computeInteriorVolume();
		output = output + "\nEXTERIOR VOLUME: " + computeExteriorVolume();		
		return output;
	}
}
