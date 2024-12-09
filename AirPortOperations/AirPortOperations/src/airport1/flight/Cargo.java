package airport1.flight;

public class Cargo {
	private double weight;
	private String type; // Premium or Standard
    
    public Cargo(double weight, String type) {
        this.weight = weight;
        this.type = type;
    }
	
	public Cargo(double weight)
	{
		this.weight = weight;
	}
	
	void setWeight(double weight)
	{
		this.weight = weight;
	}
	
	double getWeight()
	{
		return this.weight;
	}
	
	String getType()
	{
		return this.type;
	}
	
}
