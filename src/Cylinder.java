
public class Cylinder extends Container {
	
	private double height;
	private double radius;
	private static final double PI = 3.14;
	
	public Cylinder(double height, double radius, double thickness, double density)
	{
		super(thickness, density);
		this.height = height;
		this.radius = radius;
	}
	
	public double getHeight()
	{
		return this.height;
	}
	
	public double getRadius()
	{
		return this.radius;
	}
	
	public double computeInteriorVolume()
	{
		double t = super.getThickness(); //get thickness from container class
		return PI * ((radius - t)*(radius - t)) * (height - (2 * t));
	}
	
	public double computeExteriorVolume()
	{
		return PI * (radius*radius) * height;
	}
	
	public String toString()
	{
		String output = null;
		output = "CONTAINER TYPE: TANK (CYLINDER)";
		output = output + "\nHEIGHT: " + height;
		output = output + "\nRADIUS: " + radius;
		output = output + "\nTHICKNESS: " + super.getDensity();
		output = output + "\nDENSITY: " + super.getThickness();
		output = output + "\nINTERIOR VOLUME: " + computeInteriorVolume();
		output = output + "\nEXTERIOR VOLUME " + computeExteriorVolume();
		return output;
	}

}
