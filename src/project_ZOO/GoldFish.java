package project_ZOO;

import java.util.ArrayList;

import project_ZOO.FishColor.GoldFishColor;

public class GoldFish extends Fish {

	static final double MIN_LENGTH_GOLD = 0.1;
	static final double MAX_LENGTH_GOLD = 6;
	static final int LifeSpan = 12;

	public GoldFish() {
		this.hisTrait = CharacteristicOfAFish.Smooth;
	}

	@Override
	public void setFishLength(double fishLength) {

		super.setFishLength(fishLength);
	}

	@Override
	public void setAge(int ageOfFish) {
		super.setAge(ageOfFish);
	}

	public void setFishColor(GoldFishColor fishColor) {
		super.setFishColor(fishColor);
	}

	public ArrayList<Object> getFishColor() {
		return super.getFishColor();
	}

	public int getFishColorLength() {
		return super.getFishColorLength();
	}

	@Override
	public int getAge() {
		return super.getAge();
	}

	@Override
	public CharacteristicOfAFish getFishTrait() {
		// TODO Auto-generated method stub
		return super.getFishTrait();
	}

	@Override
	public String toString() {
		return "< Gold fish > : " + super.toString() + "\n";
	}

	@Override
	public Number feed() {

		return (double) 1;
	}

}
