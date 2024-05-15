package project_ZOO;

import java.util.ArrayList;

import project_ZOO.FishColor.ClownFishColor;

public class ClownFish extends Fish {

	static final double MIN_LENGTH_CLOWN = 0.2;
	static final double MAX_LENGTH_CLOWN = 10;
	static final int LifeSpan = 8;

	public ClownFish() {
		this.hisTrait = CharacteristicOfAFish.Stripes;
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return super.getAge();
	}

	@Override
	public void setAge(int ageOfFish) {
		// TODO Auto-generated method stub
		super.setAge(ageOfFish);
	}

	public ArrayList<Object> getClownFishColor() {
		return super.getFishColor();
	}

	public void setFishColor(ClownFishColor hisColor) {
		super.setFishColor(hisColor);

	}

	@Override
	public int getFishColorLength() {
		// TODO Auto-generated method stub
		return super.getFishColorLength();
	}

	@Override
	public CharacteristicOfAFish getFishTrait() {
		// TODO Auto-generated method stub
		return super.getFishTrait();
	}

	@Override
	public void setFishLength(double fishLength) {

		super.setFishLength(fishLength);
	}

	@Override
	public double getFishLength() {
		// TODO Auto-generated method stub
		return super.getFishLength();
	}

	@Override
	public String toString() {
		return "< Clown fish > : " + super.toString() + "\n";
	}

	@Override
	public Number feed() {

		return (double) 2;
	}

}
