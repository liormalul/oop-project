package project_ZOO;

public class Lion extends Carnivore {

	static final float MAX_WEIGHT_LION = 260;

	public Lion() {

	}

	public Lion(String name, Gender gender, int age, float weight) {
		super(name, gender, age, weight);

	}

	@Override
	public String makeNoise() {
		return "ROAR";
	}

	@Override
	public String TheTypeOfCarnivore() {
		return "lion";
	}

	@Override
	public Number feed() {
		if (this.genderCarnivore == Gender.MALE)
			food = (int) (this.weightCarnivore * this.age * this.PROMOTES_FOOD_MALE);
		else
			food = (int) (this.weightCarnivore * this.age * this.PROMOTES_FOOD_FEMALE);

		if (food > 25)
			food = 25;

		return food;
	}

	@Override
	public String toString() {
		return "Lion: " + super.toString() + "\n";
	}
}
