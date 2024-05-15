package project_ZOO;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ZooManger {
	private SortAnimals sort = new SortAnimals();

	private String zooName;
	private String zooAddress;

	private int money;
	static final int PRICE_PER_KILO_OF_MEAT = 10;
	static final int PRICE_PER_1_FISH_FOR_PENGUIN = 2;
	static final int PRICE_PER_FISH_FOOD = 3;
	static final int PRICE_PER_1_MANGO = 15;
	static final int PRICE_PER_1_MIX_FRUITS = 15;

	static final int PRICE_BUY_FISH = 20;
	static final int PRICE_BUY_PENGUIN = 50;
	static final int PRICE_BUY_TIGER = 100;
	static final int PRICE_BUY_LION = 150;
	static final int PRICE_BUY_LEMUR = 250;
	static final int PRICE_BUY_CERVUS = 150;

	private int supplayFoodForPenguin;
	private double supplayFoodForFish;
	private int supplayFoodForCarnivores;

	private SortAnimal alreadySorted = SortAnimal.HEIGHT;

	private ArrayList<Penguin> arrayListOfPengium = new ArrayList<Penguin>();
	private SortAnimal whatSortDidTheUserSelect = SortAnimal.HEIGHT;
	private int foodForPenguin = 0;

	private ArrayList<Lion> arrayListOfLion = new ArrayList<Lion>();
	private int foodForLions = 0;

	private ArrayList<Tiger> arrayListOfTigers = new ArrayList<Tiger>();
	private int foodForTigers = 0;

	private ArrayList<AquariumFish> arrayListOfAquariumFish = new ArrayList<AquariumFish>();
	private int counterHowManyColorsInZoo = 0;
	private double foodForFish = 0;
	private FishColor arrayOfFishColor[] = FishColor.values();
	private boolean allCoolorsFishInMyZoo[] = new boolean[arrayOfFishColor.length];
	private int[] TheColorsThatAppearMostOftenInFish = new int[arrayOfFishColor.length];
	private StringBuffer allColorsOfFish = new StringBuffer();

	private ArrayList<GoldFish> arrayListOfGoldFish = new ArrayList<GoldFish>();
	private double foodForGoldFish = 0;

	private ArrayList<ClownFish> arrayListOfClownFish = new ArrayList<ClownFish>();
	private double foodForClownFish = 0;

	private ArrayList<Lemur> arrayListOfLemurs = new ArrayList<Lemur>();;
	private int suplayForLemurs;
	private int foodForLemurs = 0;

	private ArrayList<Cervus> arrayListOfCervus = new ArrayList<Cervus>();;
	private int foodForCervus = 0;
	private int supplayForCervus;

	// ...............................ZOO............................................//
	public ZooManger(String zooName, String zooAddress) {
		this.zooName = zooName;
		this.zooAddress = zooAddress;
		allColorsOfFish.append("\nAll the colors of the fish in your zoo are :\n\n");

		supplayFoodForFish = 300;
		supplayFoodForPenguin = 300;
		supplayFoodForCarnivores = 300;
		suplayForLemurs = 300;
		supplayForCervus = 300;
		money = 6000;

	}

	public String getZooName() {
		return zooName;

	}

	public String getZooAddress() {
		return zooAddress;
	}

	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("The name of the zoo is " + getZooName());
		str.append(" address is " + getZooAddress());
		str.append("\nThe number of animals in the whole zoo is: " + numberOfAllAnimals());
		str.append("\nThe number of penguins: " + arrayListOfPengium.size());
		str.append("\nThe number of lions: " + arrayListOfLion.size());
		str.append("\nThe number of tigers: " + arrayListOfTigers.size());
		str.append("\nThe number of fishs: " + arrayListOfAquariumFish.size());
		str.append("\nThe number of gold fish : " + arrayListOfGoldFish.size());
		str.append("\nThe number of clown fish : " + arrayListOfClownFish.size());
		str.append("\nThe number of lemurs :" + arrayListOfLemurs.size());
		str.append("\nThe number of cervus :" + arrayListOfCervus.size());

		return str.toString();

	}

	public String feedAllAnimalsInZoo() {
		updatingTheAmountOfFoodForAnimal(); // Updating the total amount of food for each type of animal
		double sumOfFishFood = foodForFish + foodForGoldFish + foodForClownFish;
		int sumOfCarnivores = (foodForLions + foodForTigers);

		boolean fishProblom = false, penguinProblom = false, carnivoresProblom = false, lemurProblem = false,
				cervusProblem = false;
		if (supplayFoodForFish - sumOfFishFood >= 0) {
			if (supplayFoodForPenguin - foodForPenguin >= 0) {
				if (supplayFoodForCarnivores - sumOfCarnivores >= 0) {
					if (suplayForLemurs - foodForLemurs >= 0) {
						if (supplayForCervus - foodForCervus >= 0) {

							supplayFoodForFish -= sumOfFishFood;
							supplayFoodForPenguin -= foodForPenguin;
							supplayFoodForCarnivores -= (foodForLions + foodForTigers);
							suplayForLemurs -= foodForLemurs;
							supplayForCervus -= foodForCervus;
							StringBuffer str = new StringBuffer();
							str.append("Animal feeding was done successfully and all the animals are happy!\n\n");
							str.append("The food eaten by Penguins is: " + foodForPenguin + " fish");
							str.append("\nThe food eaten by Lions is: " + foodForLions + " kg of meat");
							str.append("\nThe food eaten by Tigers is: " + foodForTigers + " kg of meat");
							str.append("\nThe food eaten by Aquarium Fiah is " + foodForFish + " food for fish");
							str.append("\nThe food eaten by Gold Fish is " + foodForGoldFish + " food for fish");
							str.append("\nThe food eaten by Clown Fish is " + foodForClownFish + " food for fish");
							str.append("\nThe food eaten by Lemurs is :" + foodForLemurs + " kg mangos");
							str.append("\nThe food eaten by Cervus is :" + foodForCervus + "  kg mix fruits");
							str.append("\n\n curret food supplay is \n" + getSupplayInZoo());

							// increase of an happiness to 100
							increaseHappinessTo100();

							return str.toString();
						}
					}
				}
			}
		}

		// If you came here you will have a problem with the supply of at least one of
		// the animals
		penguinProblom = (supplayFoodForPenguin - foodForPenguin) < 0;
		carnivoresProblom = (supplayFoodForCarnivores - (foodForLions + foodForTigers)) < 0;
		fishProblom = supplayFoodForFish - sumOfFishFood < 0;
		lemurProblem = suplayForLemurs - foodForLemurs < 0;
		cervusProblem = supplayForCervus - foodForCervus < 0;

		return getMassageAboutNotEnothFood(fishProblom, penguinProblom, carnivoresProblom, lemurProblem, cervusProblem);
	}

	public void updatingTheAmountOfFoodForAnimal() {

		foodForPenguin = 0;
		foodForLions = 0;
		foodForTigers = 0;
		foodForFish = 0;
		foodForGoldFish = 0;
		foodForClownFish = 0;
		foodForLemurs = 0;
		foodForCervus = 0;

		if (!arrayListOfPengium.isEmpty())
			for (int i = 0; i < arrayListOfPengium.size(); i++)
				foodForPenguin += (int) arrayListOfPengium.get(i).feed();

		if (!arrayListOfLion.isEmpty())
			for (int i = 0; i < arrayListOfLion.size(); i++)
				foodForLions += (int) arrayListOfLion.get(i).feed();

		if (!arrayListOfTigers.isEmpty())
			for (int i = 0; i < arrayListOfTigers.size(); i++)
				foodForTigers += (int) arrayListOfTigers.get(i).feed();

		if (!arrayListOfAquariumFish.isEmpty())
			for (int i = 0; i < arrayListOfAquariumFish.size(); i++)
				foodForFish += Double.parseDouble(new DecimalFormat("##.##").format(arrayListOfGoldFish.get(i).feed()));

		if (!arrayListOfGoldFish.isEmpty())
			for (int i = 0; i < arrayListOfGoldFish.size(); i++)
				foodForGoldFish += Double
						.parseDouble(new DecimalFormat("##.##").format(arrayListOfGoldFish.get(i).feed()));

		if (!arrayListOfClownFish.isEmpty())
			for (int i = 0; i < arrayListOfClownFish.size(); i++)
				foodForClownFish += Double
						.parseDouble(new DecimalFormat("##.##").format(arrayListOfClownFish.get(i).feed()));

		if (!arrayListOfLemurs.isEmpty())
			for (int i = 0; i < arrayListOfLemurs.size(); i++)
				foodForLemurs += (int) arrayListOfLemurs.get(i).feed();

		if (!arrayListOfCervus.isEmpty())
			for (int i = 0; i < arrayListOfCervus.size(); i++)
				foodForCervus += (int) arrayListOfCervus.get(i).feed();

	}

	private void increaseHappinessTo100() {
		HappinessIncrease100<Object> happiness100 = new HappinessIncrease100<Object>();
		happiness100.animalAgeOneYear(arrayListOfPengium);
		happiness100.animalAgeOneYear(arrayListOfLion);
		happiness100.animalAgeOneYear(arrayListOfTigers);

		happiness100.animalAgeOneYear(arrayListOfAquariumFish);
		happiness100.animalAgeOneYear(arrayListOfGoldFish);
		happiness100.animalAgeOneYear(arrayListOfClownFish);

		happiness100.animalAgeOneYear(arrayListOfLemurs);
		happiness100.animalAgeOneYear(arrayListOfCervus);

	}

	private String getMassageAboutNotEnothFood(boolean fishProblom, boolean penguinProblom, boolean carnivoresProblom,
			boolean lemurProblem, boolean cervusProblem) {
		double sumOfFishFood = foodForFish + foodForGoldFish + foodForClownFish;
		int sumOfCarnivores = (foodForLions + foodForTigers);

		StringBuffer ThereIsNotEnoughFood = new StringBuffer();
		ThereIsNotEnoughFood.append("Sorry you don't have enough food to feed the animals\n");
		if (fishProblom) {
			ThereIsNotEnoughFood.append("you need " + sumOfFishFood);
			ThereIsNotEnoughFood.append(" fish food but you have only " + supplayFoodForFish);
			ThereIsNotEnoughFood.append(" food for fish");
			ThereIsNotEnoughFood.append(" please add " + (sumOfFishFood - supplayFoodForFish) + " food for fish\n");
		}
		if (penguinProblom) {
			ThereIsNotEnoughFood.append("you need " + foodForPenguin);
			ThereIsNotEnoughFood.append(" penguin food but you have only " + supplayFoodForPenguin);
			ThereIsNotEnoughFood.append(" food for penguibn");
			ThereIsNotEnoughFood
					.append(" please add " + (foodForPenguin - supplayFoodForPenguin) + " food for penguin");
		}
		if (carnivoresProblom) {
			ThereIsNotEnoughFood.append("you need " + sumOfCarnivores);
			ThereIsNotEnoughFood.append(" carnivores food but you have only " + supplayFoodForCarnivores);
			ThereIsNotEnoughFood.append(" food for carnivores");
			ThereIsNotEnoughFood.append(" please add " + (sumOfCarnivores - supplayFoodForCarnivores) + " kg of meat ");

		}
		if (lemurProblem) {
			ThereIsNotEnoughFood.append("you need " + foodForLemurs);
			ThereIsNotEnoughFood.append(" mangos  but you have only " + suplayForLemurs);
			ThereIsNotEnoughFood.append(" food for carnivores");
			ThereIsNotEnoughFood.append(" please add " + (foodForLemurs - suplayForLemurs) + " mangos");
		}

		if (cervusProblem) {
			ThereIsNotEnoughFood.append("you need " + foodForCervus);
			ThereIsNotEnoughFood.append(" mangos  but you have only " + supplayForCervus);
			ThereIsNotEnoughFood.append(" food for carnivores");
			ThereIsNotEnoughFood.append(" please add " + (foodForCervus - supplayForCervus) + " mix fruits");
		}

		return ThereIsNotEnoughFood.toString();

	}

	public String allMakeNoise() {
		StringBuffer allMakeNoiseAllAnimal = new StringBuffer();
		allMakeNoiseAllAnimal.append(allMakeNoiseTypeAnimal(arrayListOfPengium));
		allMakeNoiseAllAnimal.append(allMakeNoiseTypeAnimal(arrayListOfLion));
		allMakeNoiseAllAnimal.append(allMakeNoiseTypeAnimal(arrayListOfTigers));

		allMakeNoiseAllAnimal.append(allMakeNoiseTypeAnimal(arrayListOfAquariumFish));
		allMakeNoiseAllAnimal.append(allMakeNoiseTypeAnimal(arrayListOfGoldFish));
		allMakeNoiseAllAnimal.append(allMakeNoiseTypeAnimal(arrayListOfClownFish));

		allMakeNoiseAllAnimal.append(allMakeNoiseTypeAnimal(arrayListOfLemurs));
		allMakeNoiseAllAnimal.append(allMakeNoiseTypeAnimal(arrayListOfCervus));

		if (allMakeNoiseAllAnimal.isEmpty())
			allMakeNoiseAllAnimal.append("EROR: There are no animals in the zoo\n");

		return allMakeNoiseAllAnimal.toString();

	}

	public <T extends Animal> String allMakeNoiseTypeAnimal(ArrayList<T> animals) {
		StringBuffer allMakeNoiseTypeAnimal = new StringBuffer();

		for (int i = 0; i < animals.size(); i++) {
			allMakeNoiseTypeAnimal.append(animals.get(i).makeNoise() + " ");
		}
		return allMakeNoiseTypeAnimal.toString();
	}

	public int numberOfAllAnimals() {

		return arrayListOfPengium.size() + arrayListOfLion.size() + arrayListOfTigers.size()
				+ arrayListOfAquariumFish.size() + arrayListOfGoldFish.size() + arrayListOfClownFish.size()
				+ arrayListOfLemurs.size() + arrayListOfCervus.size();
	}

	private void addFoodSupplayForZoo(double supplayFoodForFish, int supplayFoodForPenguin,
			int supplayFoodForCarnivores, int supplayForLemurs, int supplayForCervus) {
		this.supplayFoodForFish += supplayFoodForFish;
		this.supplayFoodForPenguin += supplayFoodForPenguin;
		this.supplayFoodForCarnivores += supplayFoodForCarnivores;
		this.suplayForLemurs += supplayForLemurs;
		this.supplayForCervus += supplayForCervus;

	}

	public String getHowManyFoodYouCanBuy() {
		StringBuffer str = new StringBuffer();
		str.append("with your monet [" + getMoney() + "$]");
		str.append("\nyou can buy in max " + (getMoney() / PRICE_PER_1_FISH_FOR_PENGUIN));
		str.append(" unit of food for pengiun");
		str.append("\nor you can buy in max " + (getMoney() / PRICE_PER_FISH_FOOD));
		str.append(" unit food for fish");
		str.append("\nor you can buy in max  " + (getMoney() / PRICE_PER_KILO_OF_MEAT));
		str.append(" kg of meat for lions/tigers");
		str.append("\nor you can buy in max  " + (getMoney() / PRICE_PER_1_MANGO));
		str.append(" kg of mango for lemur");
		str.append("\nor you can buy in max  " + (getMoney() / PRICE_PER_1_MIX_FRUITS));
		str.append(" kg of mango for cervus\n");

		str.append("the optimal is :");
		int sum = PRICE_PER_1_FISH_FOR_PENGUIN + PRICE_PER_FISH_FOOD + PRICE_PER_KILO_OF_MEAT + PRICE_PER_1_MANGO
				+ PRICE_PER_1_MIX_FRUITS;
		str.append(getMoney() / sum + " unit from each\n\n");
		return str.toString();
	}

	public String getSupplayInZoo() {
		StringBuffer str = new StringBuffer();
		str.append("supplay left for fish " + supplayFoodForFish);
		str.append(" food left for fish");
		str.append("\nsupplay left for Penguin " + supplayFoodForPenguin);
		str.append(" fish");
		str.append("\nsupplay left for carnivores " + supplayFoodForCarnivores);
		str.append(" kg of meat");
		str.append("\nsupplay left for lemurs " + suplayForLemurs);
		str.append(" mangos ");
		str.append("\nsupplay left for cervus " + supplayForCervus);
		str.append(" mix fruits ");

		return str.toString();
	}

	public <T extends Animal> String ageOneYear() {
		StringBuffer str = new StringBuffer();
		int countRemovAnimals = 0;
		AnimalAgeOneYear<?> temp = new AnimalAgeOneYear();
		ZooManger manger = this;

		if (numberOfAllAnimals() == 0) {
			str.append("There are no animals in the zoo");
			return str.toString();
		}

		if (arrayListOfPengium.size() != 0)
			str.append(temp.animalAgeOneYear(arrayListOfPengium, manger));
		if (arrayListOfLion.size() != 0)
			str.append(temp.animalAgeOneYear(arrayListOfLion, manger));
		if (arrayListOfTigers.size() != 0)
			str.append(temp.animalAgeOneYear(arrayListOfTigers, manger));

		if (arrayListOfAquariumFish.size() != 0)
			str.append(temp.animalAgeOneYear(arrayListOfAquariumFish, manger));
		if (arrayListOfGoldFish.size() != 0)
			str.append(temp.animalAgeOneYear(arrayListOfGoldFish, manger));
		if (arrayListOfClownFish.size() != 0)
			str.append(temp.animalAgeOneYear(arrayListOfClownFish, manger));

		if (arrayListOfLemurs.size() != 0)
			str.append(temp.animalAgeOneYear(arrayListOfLemurs, manger));
		if (arrayListOfCervus.size() != 0)
			str.append(temp.animalAgeOneYear(arrayListOfCervus, manger));

		if (str.isEmpty())
			str.append("The operation was performed\n");
		
		for (int i = 0; i < 3; i++)  //-->>  in our project "passed"  3 month
			AddingMoneyToTheZooEveryMonth();

		return str.toString();

	}

	public <A extends Animal> String showingAllTypeAnimalInZoo(ArrayList<A> arrayList, String stringTypeAnimal) {
		StringBuffer str = new StringBuffer();

		str.append("\nThe number of " + stringTypeAnimal + "s in the zoo is: " + arrayList.size() + "\n");

		for (int i = 0; i < arrayList.size(); i++)
			str.append("#" + (i + 1) + " " + arrayList.get(i));

		return str.toString();
	}

	// ..................................sorting..........................................//

	public String chooseSortAnimalsArrayList(int choose) {
		StringBuffer str = new StringBuffer();

		if (choose == 1) {
			whatSortDidTheUserSelect = SortAnimal.HEIGHT;
			arrayListOfPengium = sort.sortAnmimalsByHeightOrAgeInMergeSort(arrayListOfPengium, SortAnimal.HEIGHT);
			arrayListOfLemurs = sort.sortAnmimalsByHeightOrAgeInMergeSort(arrayListOfLemurs, SortAnimal.HEIGHT);
			arrayListOfCervus = sort.sortAnmimalsByHeightOrAgeInMergeSort(arrayListOfCervus, SortAnimal.HEIGHT);
			str.append("now the animals sort by height");

		} else if (choose == 2) {
			whatSortDidTheUserSelect = SortAnimal.ABC;
			sort.sortAnimalsByABC(arrayListOfPengium);
			sort.sortAnimalsByABC(arrayListOfLemurs);
			sort.sortAnimalsByABC(arrayListOfCervus);
			str.append("now the animals sort by abc");

		}

		else if (choose == 3) {
			whatSortDidTheUserSelect = SortAnimal.AGE;
			arrayListOfPengium = sort.sortAnmimalsByHeightOrAgeInMergeSort(arrayListOfPengium, SortAnimal.AGE);
			arrayListOfLemurs = sort.sortAnmimalsByHeightOrAgeInMergeSort(arrayListOfLemurs, SortAnimal.AGE);
			arrayListOfCervus = sort.sortAnmimalsByHeightOrAgeInMergeSort(arrayListOfCervus, SortAnimal.AGE);
			str.append("now the animals sort by age");

		}
		return str.toString();

	}

	private <T extends Animal> void addAnimalToSystem(ArrayList<T> arrayListOfAnimals, T newAnimal) {
		// 2 of 3 methods work at O(log n)
		if (alreadySorted.equals(SortAnimal.HEIGHT)) {
			sort.addOneNewAnimalWhenAllOtherAnimalSortByHeightOrAge(arrayListOfAnimals, newAnimal,
					Comparator.comparing(Animal::getHeight));
			alreadySorted = SortAnimal.HEIGHT;

		} else if (alreadySorted.equals(SortAnimal.AGE)) {
			sort.addOneNewAnimalWhenAllOtherAnimalSortByHeightOrAge(arrayListOfAnimals, newAnimal,
					Comparator.comparing(Animal::getAge));
			alreadySorted = SortAnimal.AGE;
		} else {
			arrayListOfAnimals.add(newAnimal); // -> this only method work at O(n*log n)
			alreadySorted = SortAnimal.ABC;
			sort.sortAnimalsByABC(arrayListOfAnimals);
		}

	}

	// ......................................money...................................................//
	public boolean IsThereMoneyToBuyFoodForAnimals(double supplayFoodForFish, int supplayFoodForPenguin,
			int supplayFoodForCarnivores, int supplayForLemurs, int supplayForCervus) {
		double expenses = supplayFoodForFish * PRICE_PER_1_FISH_FOR_PENGUIN;
		expenses += supplayFoodForPenguin * PRICE_PER_FISH_FOOD;
		expenses += supplayFoodForCarnivores * PRICE_PER_KILO_OF_MEAT;
		expenses += supplayForLemurs * PRICE_PER_1_MANGO;
		expenses += supplayForCervus * PRICE_PER_1_MIX_FRUITS;

		if (this.money >= expenses) {
			this.money -= expenses;
			addFoodSupplayForZoo(supplayFoodForFish, supplayFoodForPenguin, supplayFoodForCarnivores, supplayForLemurs,
					supplayForCervus);
			return true;

		}
		return false;

	}

	public <T> boolean CheckingIfThereIsMoneyToBuyAnimals(T newAnimal) {
		if (newAnimal instanceof Fish) {
			if (this.money >= PRICE_BUY_FISH) {
				this.money -= PRICE_BUY_FISH;
				addFishToSystem((Fish) newAnimal);
				return true;
			}
		} else if (newAnimal instanceof Penguin) {
			if (this.money >= PRICE_BUY_PENGUIN) {
				this.money -= PRICE_BUY_PENGUIN;
				addPenguinToSystem((Penguin) newAnimal);
				return true;
			}
		} else if (newAnimal instanceof Lion) {
			if (this.money >= PRICE_BUY_LION) {
				this.money -= PRICE_BUY_LION;
				addCarnivoreToSystem((Carnivore) newAnimal);
				return true;
			}
		} else if (newAnimal instanceof Tiger) {
			if (this.money >= PRICE_BUY_TIGER) {
				this.money -= PRICE_BUY_TIGER;
				addCarnivoreToSystem((Carnivore) newAnimal);
				return true;
			}
		} else if (newAnimal instanceof Lemur) {
			if (this.money >= PRICE_BUY_LEMUR) {
				this.money -= PRICE_BUY_LEMUR;
				addNewLemurToSystem((Lemur) newAnimal);
				return true;
			}
		} else if (newAnimal instanceof Cervus) {
			if (this.money >= PRICE_BUY_CERVUS) {
				this.money -= PRICE_BUY_CERVUS;
				addNewCervusToSystem((Cervus) newAnimal);
				return true;
			}
		}
		return false;
	}

	public int getMoney() {
		return this.money;
	}

	public String getMoneyWithMassage() {
		StringBuffer str = new StringBuffer();
		str.append("The money left in the zoo is : " + this.money + "$");
		return str.toString();
	}

	public void AddingMoneyToTheZooEveryMonth() {
		int counterFishTotal = arrayListOfAquariumFish.size() + arrayListOfClownFish.size()
				+ arrayListOfGoldFish.size();
		int incomeFromFish = (int) (0.4 * PRICE_BUY_FISH * counterFishTotal);
		int incomeFromPenguins = (int) (0.6 * PRICE_BUY_PENGUIN * arrayListOfPengium.size());
		int incomeFromTigers = (int) (0.7 * PRICE_BUY_TIGER * arrayListOfTigers.size());
		int incomeFromLions = (int) (0.8 * PRICE_BUY_LION * arrayListOfLion.size());
		int incomeFromLemurs = (int) (3 * PRICE_BUY_LEMUR * arrayListOfLemurs.size()); // --> evry one love King Julian
		int incomeFromCervus = (int) (PRICE_BUY_CERVUS * arrayListOfCervus.size());

		this.money += incomeFromFish + incomeFromPenguins + incomeFromTigers + incomeFromLions + incomeFromLemurs
				+ incomeFromCervus;

	}

	public String getPriceMenuForEverythingYouCanBuy() {
		StringBuffer str = new StringBuffer();
		str.append("~~~~~~~~~~~~price menue~~~~~~~~~~~~~~~~~~\n\n");
		str.append("~~~~~~~~~~~~~~Food~~~~~~~~~~~~ :\n");
		str.append("1-kg of meat " + PRICE_PER_KILO_OF_MEAT + "$\n");
		str.append("1 food for fish " + PRICE_PER_FISH_FOOD + "$\n");
		str.append("1 food for penguins " + PRICE_PER_1_FISH_FOR_PENGUIN + "$\n");
		str.append("1 Mango for lemurs " + PRICE_PER_1_MANGO + "$\n");
		str.append("1 mix fruits for lemurs " + PRICE_PER_1_MIX_FRUITS + "$\n\n");

		str.append("~~~~~~~~~~~~~~anumals~~~~~~~~~~~~ :\n");
		str.append("new fish = " + PRICE_BUY_FISH + "$\n");
		str.append("new lion = " + PRICE_BUY_LION + "$\n");
		str.append("new tiger = " + PRICE_BUY_TIGER + "$\n");
		str.append("new penguin = " + PRICE_BUY_PENGUIN + "$\n");
		str.append("new lemur = " + PRICE_BUY_LEMUR + "$\n");
		str.append("new cervus = " + PRICE_BUY_CERVUS + "$\n");

		return str.toString();
	}

	// ................................Penguin........................................//

	public void addPenguinToSystem(Penguin newPenguin) {
		addAnimalToSystem(arrayListOfPengium, newPenguin);
	}

	public float getLeaderHeadPenguin() {
		if (arrayListOfPengium.isEmpty()) {
			Penguin.heightLeaderPenguin = 0;
			return 0;
		}

		if (whatSortDidTheUserSelect.equals(SortAnimal.HEIGHT)) {
			Penguin.heightLeaderPenguin = arrayListOfPengium.get(0).getHeight();
			return Penguin.heightLeaderPenguin;

		}
		ArrayList<Penguin> leaderOfPEnguins = sort.sortAnmimalsByHeightOrAgeInMergeSort(arrayListOfPengium,
				SortAnimal.HEIGHT);
		Penguin.heightLeaderPenguin = leaderOfPEnguins.get(0).getHeight();

		return Penguin.heightLeaderPenguin;
	}

	public String showAllPenguinInZoo() {
		StringBuffer str = new StringBuffer();
		int index = 1;

		str.append("The number of penguins in the zoo is: " + arrayListOfPengium.size() + "\n");
		str.append("the sort is by :" + whatSortDidTheUserSelect + "\n");
		for (int i = 0; i < arrayListOfPengium.size(); i++) {
			str.append("Penguin #" + index + ": " + arrayListOfPengium.get(i).toString());
			index++;
		}

		return str.toString();
	}

	// ...............................Carnivore.....................................//

	public void addCarnivoreToSystem(Carnivore NewCarnivore) {

		SortAnimal temp = alreadySorted;

		if (NewCarnivore instanceof Lion) {
			// arrayListOfLion.add((Lion) NewCarnivore);
			alreadySorted = SortAnimal.AGE;
			addAnimalToSystem(arrayListOfLion, (Lion) NewCarnivore);
			alreadySorted = temp;
			// System.out.println(alreadySorted);

		} else {
			alreadySorted = SortAnimal.AGE;
			addAnimalToSystem(arrayListOfTigers, (Tiger) NewCarnivore);
			alreadySorted = temp;

		}
		// arrayListOfTigers.add((Tiger) NewCarnivore);
	}

	public String showAllCarnivoreZoo() {
		StringBuffer str = new StringBuffer();
		str.append("sort is by AGE");

		return str + showingAllTypeAnimalInZoo(arrayListOfLion, "Lion")
				+ showingAllTypeAnimalInZoo(arrayListOfTigers, "Tiger");
	}

	// .........................Fish......................................................//

	public void cheakAgainAllColorsInZooAfterDealeteFish() {
		for (int i = 0; i < allCoolorsFishInMyZoo.length; i++) {
			allCoolorsFishInMyZoo[i] = false; // -> in this func i "restart" all colors to 0 and then cheak the colors
												// after deleting the fish
			TheColorsThatAppearMostOftenInFish[i] = 0; // -> It's an array of int that in the future I count the 2
														// dominant colors in the fish
		}
		allColorsOfFish.setLength(0);
		counterHowManyColorsInZoo = 0;

		for (int i = 0; i < arrayListOfAquariumFish.size(); i++) {
			ChecksAllTheColorsOfTheFish(arrayListOfAquariumFish.get(i).getFishColor(),
					arrayListOfAquariumFish.get(i).getFishColorLength());

			the2ColorsThatAppearThMmostInFish(arrayListOfAquariumFish.get(i).getFishColor(),
					arrayListOfAquariumFish.get(i).getFishColorLength());
		}

		for (int i = 0; i < arrayListOfGoldFish.size(); i++) {
			ChecksAllTheColorsOfTheFish(arrayListOfGoldFish.get(i).getFishColor(),
					arrayListOfGoldFish.get(i).getFishColorLength());

			the2ColorsThatAppearThMmostInFish(arrayListOfGoldFish.get(i).getFishColor(),
					arrayListOfGoldFish.get(i).getFishColorLength());

		}

		for (int i = 0; i < arrayListOfClownFish.size(); i++) {
			ChecksAllTheColorsOfTheFish(arrayListOfClownFish.get(i).getClownFishColor(),
					arrayListOfClownFish.get(i).getFishColorLength());

			the2ColorsThatAppearThMmostInFish(arrayListOfClownFish.get(i).getClownFishColor(),
					arrayListOfClownFish.get(i).getFishColorLength());

		}

	}

	public <T extends Fish> void addFishToSystem(T newFish) {

		if (newFish instanceof GoldFish) {
			addNewGoldFishToSystem((GoldFish) newFish);
		} else if (newFish instanceof ClownFish) {
			addNewClownFishToSystem((ClownFish) newFish);
		} else if (newFish instanceof AquariumFish) {
			addNewAquariumFishToSystem((AquariumFish) newFish);
		}
	}

	private void addNewAquariumFishToSystem(AquariumFish newAquariumFish) {

		ChecksAllTheColorsOfTheFish(newAquariumFish.getFishColor(), newAquariumFish.getFishColorLength());
		the2ColorsThatAppearThMmostInFish(newAquariumFish.getFishColor(), newAquariumFish.getFishColorLength());
		arrayListOfAquariumFish.add(newAquariumFish);
	}

	private void addNewGoldFishToSystem(GoldFish newGoldFish) {

		ChecksAllTheColorsOfTheFish(newGoldFish.getFishColor(), newGoldFish.getFishColorLength());
		the2ColorsThatAppearThMmostInFish(newGoldFish.getFishColor(), newGoldFish.getFishColorLength());
		arrayListOfGoldFish.add(newGoldFish);

	}

	private void addNewClownFishToSystem(ClownFish newClownFish) {

		ChecksAllTheColorsOfTheFish(newClownFish.getClownFishColor(), newClownFish.getFishColorLength());
		the2ColorsThatAppearThMmostInFish(newClownFish.getClownFishColor(), newClownFish.getFishColorLength());
		arrayListOfClownFish.add(newClownFish);

	}

	private <T> void ChecksAllTheColorsOfTheFish(ArrayList<T> curretColor, int size) {
		if (counterHowManyColorsInZoo == allCoolorsFishInMyZoo.length)
			return;

		if (size == 0)
			return;

		for (int i = 0; i < allCoolorsFishInMyZoo.length; i++) {
			if (arrayOfFishColor[i].name() == curretColor.get(size - 1).toString() && !allCoolorsFishInMyZoo[i]) {
				counterHowManyColorsInZoo++;
				allCoolorsFishInMyZoo[i] = true;
				allColorsOfFish.append(curretColor.get(size - 1) + ", ");
			}
		}

		ChecksAllTheColorsOfTheFish(curretColor, size - 1);

	}

	private <T> void the2ColorsThatAppearThMmostInFish(ArrayList<T> curretColor, int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < allCoolorsFishInMyZoo.length; j++) {

				if (arrayOfFishColor[j].name().equals(curretColor.get(i).toString()))
					TheColorsThatAppearMostOftenInFish[j] += 1;

			}
		}

	}

	private int select(int[] arrOfColorsOfFish, int index, int maxiumum) {
		for (int i = 0; i < arrOfColorsOfFish.length; i++) {
			if (arrOfColorsOfFish[i] > index) {
				if (arrOfColorsOfFish[i] < maxiumum)
					index = arrOfColorsOfFish[i];
			}

		}
		return index;
	}

	// Here I check a number of things
	// 1- What is the maximum number of shows in which the fish appeared
	// 2- The limit of the number of colors that I am allowed to check
	// 3- If the fish before it is null or if it is the same color as the fish
	// before it
	private String getTheColorOfTheTishThatAppearTheMostTimes(int index, int maximum, String previousColor) {
		FishColor color = null;
		for (int i = 0; i < TheColorsThatAppearMostOftenInFish.length; i++) {
			if (TheColorsThatAppearMostOftenInFish[i] > index) {
				if (TheColorsThatAppearMostOftenInFish[i] < maximum) {
					if (previousColor == null) {
						index = TheColorsThatAppearMostOftenInFish[i];
						color = arrayOfFishColor[i];
					} else if (!(previousColor.equals(arrayOfFishColor[i].toString().trim()))) {
						index = TheColorsThatAppearMostOftenInFish[i];
						color = arrayOfFishColor[i];
					}
				}
			}
		}
		if (color == null)
			return "";

		return color.toString();
	}

	public String getthe2ColorsThatAppearThMmostInFish() {
		StringBuffer str = new StringBuffer();
		int max1, max2;
		int maxIndex = TheColorsThatAppearMostOftenInFish.length - 1;
		max1 = select(TheColorsThatAppearMostOftenInFish, 0, maxIndex);
		if (max1 == 1)
			max2 = 1;
		else
			max2 = select(TheColorsThatAppearMostOftenInFish, 0, max1);
		String colorA = getTheColorOfTheTishThatAppearTheMostTimes(0, max1 + 1, null);
		String colorB = getTheColorOfTheTishThatAppearTheMostTimes(0, max2 + 1, colorA);
		if (colorB.isEmpty()) {
			str.append("The colors that appear most often in fish ");
			str.append(max1 + " " + colorA);
			return str.toString();
		}

		str.append("The colors that appear most often in fish ");
		str.append(max1 + " " + colorA + "  " + max2 + " " + colorB);
		return str.toString();
	}

	private String getAllColorsInMyZoo() {
		StringBuffer str = new StringBuffer();
		str.append("\n\nin total you have : " + this.counterHowManyColorsInZoo);
		str.append(" different colors of fish");
		return this.allColorsOfFish.toString() + str.toString();

	}

	public String showAllFishInZoo() {
		StringBuffer str = new StringBuffer();

		str.append(showingAllTypeAnimalInZoo(arrayListOfAquariumFish, "AquariumFish"));
		str.append(showingAllTypeAnimalInZoo(arrayListOfGoldFish, "GoldFish"));
		str.append(showingAllTypeAnimalInZoo(arrayListOfClownFish, "ClownFish"));

		return str.toString() + getAllColorsInMyZoo();

	}

//..........................................Lemurs........................................................//

	public void addNewLemurToSystem(Lemur newLemur) {

		addAnimalToSystem(arrayListOfLemurs, newLemur);
	}

	public String showingAllLemursInZoo() {
		StringBuffer str = new StringBuffer();
		str.append("the sort is by :" + whatSortDidTheUserSelect);
		return str.toString() + showingAllTypeAnimalInZoo(arrayListOfLemurs, "Lemur");
	}

	// ..................................................Cervus........................//
	public void addNewCervusToSystem(Cervus newCervus) {

		addAnimalToSystem(arrayListOfCervus, newCervus);
	}

	public String showingAllCervusInZoo() {
		StringBuffer str = new StringBuffer();
		str.append("the sort is by :" + whatSortDidTheUserSelect);
		return str.toString() + showingAllTypeAnimalInZoo(arrayListOfCervus, "Cervus");
	}
}
