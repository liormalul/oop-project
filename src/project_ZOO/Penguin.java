package project_ZOO;

public class Penguin extends Animal {

	static float heightLeaderPenguin = 0; // if heightLeaderPenguin = 0 -> There is no penguin leader (meaning there
											// is no penguin in the zoo)
	protected float height;
	static final float MIN_HEIGHT_PENGUIN = 50;
	static final float MAX_HEIGHT_PENGUIN = 400;

	static final int LifeSpan = 6;

	public Penguin() {
		super();

	}

	public Penguin(String name, int age, float height) throws MyException, MyExceptionForHeight, MyExceptionAge {
		this.name = name;
		setAgePenguin(age);
		setHeightPenguin(height);
		super.setHappiness(100);

	}

	public void setAgePenguin(int age) throws MyExceptionAge {

		if (age < 0 || age > LifeSpan)
			throw new MyExceptionAge("EROR, Please enter a value between 0 and " + LifeSpan + " year\n");
		this.age = age;
	}

	public float getHeight() {
		return height;
	}

	public void setHeightPenguin(float height) throws MyException, MyExceptionForHeight {

		if (height < MIN_HEIGHT_PENGUIN)
			throw new MyException("EROR, The penguin must be above" + MIN_HEIGHT_PENGUIN + " cm\n");

		if (heightLeaderPenguin != 0 && height > heightLeaderPenguin)
			throw new MyExceptionForHeight(
					"EROR, This height is greater than the leader " + heightLeaderPenguin + " cm\n");

		this.height = height;
	}

	public String makeNoise() {

		return "squack";
	}

	public String toString() {
		return "Penguin: name is " + name + ", age=" + age + " years, height=" + height + " cm and happiness is "
				+ super.happiness + "\n";
	}

	@Override
	public Number feed() {

		return (int) 1;
	}

}
