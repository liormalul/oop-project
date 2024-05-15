package project_ZOO;

import java.util.Random;

@SuppressWarnings("rawtypes")
public abstract class Animal implements Actions {

	static final int MIN_AGE_ANIMAL = 0;

	protected int age;
	protected int happiness;
	protected float height;
	protected String name;
	Random rand = new Random();

	public Animal() {
		this.happiness = 100;

	}

	public Animal(String name, int age, float height) {

		this.age = age;
		this.happiness = 100;
		this.height = height;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public float getHeight() {
		return height;
	}

	public void setAge(int age) {

		this.age = age;
	}

	public void setLenthOrHeight(float height) {
		this.height = height;
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public void ageOneYear() {
		this.age++;
		happiness = happiness - (rand.nextInt(40) + 1);
		if (happiness < 0)
			happiness = 0;

	}

}
