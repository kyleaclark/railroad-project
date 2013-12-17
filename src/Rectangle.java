
public class Rectangle extends Container {

	private double width;
	private double height;
	private double length;
	
	public Rectangle(double width, double height, double length, double thickness, double density)
	{
		super(thickness, density);
		this.width = width;
		this.height = height;
		this.length = length;
	}
	
	public double getWidth()
	{
		return this.width;
	}
	
	public double getHeight()
	{
		return this.height;
	}
	
	public double getLength()
	{
		return this.length;
	}
	
	public double computeInteriorVolume()
	{
		double t = super.getThickness(); //get thickness from container class
		return (length * (2 * t)) * (width - (2 * t)) * (height - (2 * t));
	}

	public double computeExteriorVolume()
	{
		return length * width * height;
	}
	
	public String toString()
	{
		String output = null;
		output = "CONTAINER TYPE: BOX (RECTANGLE)";
		output = output + "\nWIDTH: " + width;
		output = output + "\nHEIGHT: " + height;
		output = output + "\nLENGTH: " + length;
		output = output + "\nTHICKNESS: " + super.getDensity();
		output = output + "\nDENSITY: " + super.getThickness();
		output = output + "\nINTERIOR VOLUME: " + computeInteriorVolume();
		output = output + "\nEXTERIOR VOLUME: " + computeExteriorVolume();
		return output;
	}
}
