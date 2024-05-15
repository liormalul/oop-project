package project_ZOO;

/**
 * 
 * @author orian azuri 
 * orian.azuri@s.afeka.ac.il
 *
 */
public class Cervus extends Animal {

	static final int LifeSpan = 10;
	static final float maxLengthOfTheRays = 50;
	static final float minLengthOfTheRays = 0;
	static final int PROMOTES_FOOD = 4;
	protected Gender genderCervus;
	protected double lengthOfTheRays;

	public Cervus() {
		super();
	}

	public Cervus(String name, Gender genderCervus, int age, double lengthOfTheRays) {
		super(name, age, -1);
		setLengthOfTheRays(lengthOfTheRays);
		this.genderCervus = genderCervus;
	}

	public double getLengthOfTheRays() {
		return lengthOfTheRays;
	}

	public void setLengthOfTheRays(double lengthOfTheRays) {

		this.lengthOfTheRays = lengthOfTheRays;
	}

	public Gender getGenderCervus() {
		return genderCervus;
	}

	public void setGenderCervus(Gender genderCervus) {
		this.genderCervus = genderCervus;
	}

	@Override
	public String toString() {
		return "Cervus: name is " + name + " age is " + age + " years, length of the rays is " + lengthOfTheRays
				+ " cm and happiness is " + super.happiness + "\n";

	}

	@Override
	public String makeNoise() {
		return "OhOhOh";
	}

	@Override
	public Number feed() {
		return this.age * Cervus.PROMOTES_FOOD;
	}

}
