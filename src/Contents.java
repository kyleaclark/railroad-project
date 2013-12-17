
public class Contents {

	private String material;
	private double density; //weight per volume i.e. lbs per cubic inch
	private double value; //cost per weight i.e. $ per lb
	
	public Contents(String material, double density, double value)
	{
		this.material = material;
		this.density = density;
		this.value = value;
	}
	
	public String getMaterial()
	{
		return material;
	}
	
	public double getDensity()
	{
		return density;
	}
	
	public double getValue()
	{
		return value;
	}
	
	public String toString()
	{
		return "CONTENTS TYPE: " + material + "\nDENSITY: " + density + " \nVALUE: " + value;
	}
}
