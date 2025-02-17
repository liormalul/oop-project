package project_ZOO;

public abstract class Carnivore extends Animal {

	protected final double PROMOTES_FOOD_MALE = 0.02;
	protected final double PROMOTES_FOOD_FEMALE = 0.03;
	static final int LifeSpan = 15;
	static final float MIN_WEIGHT_LION_OR_TIGER = (float) 1.5;

	protected float weightCarnivore;
	protected Gender genderCarnivore;
	protected int food;

	public Carnivore() {

		super();
	}

	public Carnivore(String name, Gender gender, int age, float weight) {
		super(name, age, -1);
		this.genderCarnivore = gender;
		setWeightCarnivore(weight);
	}

	public float getWeightCarnivore() {
		return weightCarnivore;
	}

	public void setWeightCarnivore(float weightCarnivore) {

		this.weightCarnivore = weightCarnivore;
	}

	public Gender getGenderCarnivore() {
		return genderCarnivore;
	}

	public void setGenderCarnivore(Gender genderCarnivore) {
		this.genderCarnivore = genderCarnivore;
	}

	public abstract String TheTypeOfCarnivore();

	public String toString() {
		return "name is " + this.name + ", age " + this.getAge() + " years, weight " + this.weightCarnivore
				+ " Kg, gender is " + this.genderCarnivore + " and happiness is " + super.happiness;
	}

}
