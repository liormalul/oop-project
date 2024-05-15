package project_ZOO;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class MainUser {
	static JOptionPane IO = new JOptionPane();

	public static void main(String[] args) throws MyException, MyExceptionForHeight, MyExceptionAge {

		StringBuffer inputOutputText = new StringBuffer();
		ZooManger manger = new ZooManger("Ramat Gan Zoo", "Sderot Zvi 1 Ramat Gan");
		userInputOutput userInpt = new userInputOutput(manger);
		HandlingOfExceptions exp = new HandlingOfExceptions();

		Scanner scan = new Scanner(System.in);

		hardCode(manger, userInpt);

		final long TIME_TO_WAIT_FOR_ADD_MONEY = 5 * 60 * 1000; // <- in real its 1 month in our project its 5 minutes
		long lastActionTime = System.currentTimeMillis();

		boolean selectSortForPenguinsAtFirst = false;

		int choose = 0;
		while (choose != -1) {

			// .......A function that automatically adds money to the zoo..............//

			long currentTime = System.currentTimeMillis();
			if (currentTime - lastActionTime >= TIME_TO_WAIT_FOR_ADD_MONEY) {
				inputOutputText.setLength(0);

				manger.AddingMoneyToTheZooEveryMonth();
				inputOutputText.append("Payday has arrived: now you have " + manger.getMoney() + "$\n");
				IO.showMessageDialog(null, inputOutputText);
				lastActionTime = currentTime;
			}
			// .......A function that automatically adds money to the zoo..............//

			choose = chooseMenu(scan);
			inputOutputText.setLength(0);
			switch (choose) {
			case 1:
				IO.showMessageDialog(null, manger.toString());
				break;
			case 2:
				userInpt.addOfPenguin();
				break;
			case 3:
				inputOutputText.setLength(0);
				inputOutputText.append("prees 1 to sort by HEIGHT \n");
				inputOutputText.append("prees 2 to sort by ABC\n");
				inputOutputText.append("prees 3 to sort by AGE");
				int chooseSort = exp.tryCatchFuncNumbers(1, 3, inputOutputText.toString());
				IO.showMessageDialog(null, manger.chooseSortAnimalsArrayList(chooseSort));
				selectSortForPenguinsAtFirst = true;
				break;
			case 4:
				if (!selectSortForPenguinsAtFirst)
					manger.chooseSortAnimalsArrayList(1);
				IO.showMessageDialog(null, manger.showAllPenguinInZoo());
				break;
			case 5:
				IO.showMessageDialog(null, manger.showAllCarnivoreZoo());

				break;

			case 6:
				userInpt.SelectingTheCarnivoreTheUserWants();
				break;
			case 7:
				IO.showMessageDialog(null, manger.showAllFishInZoo());
				break;

			case 8:
				inputOutputText.append("Press 1 to add fish randomly\n");
				inputOutputText.append("Press 2 to add fish manually\n");
				choose = exp.tryCatchFuncNumbers(1, 2, inputOutputText.toString());

				if (choose == 1) {
					inputOutputText.setLength(0);
					inputOutputText.append("How many fish do you want to add to the zoo?");
					int numberOfFish = exp.tryCatchFuncNumbers(0, inputOutputText.toString());
					userInpt.addRandomFishToZoo(numberOfFish, true);
				} else
					userInpt.SelectingTheFishTheUserWants();
				break;

			case 9:
				IO.showMessageDialog(null, manger.showingAllLemursInZoo());
				break;

			case 10:
				userInpt.addLenurToTheZoo();
				break;

			case 11:
				IO.showMessageDialog(null, manger.showingAllCervusInZoo());
				break;

			case 12:
				userInpt.addCervusToTheZoo();
				break;

			case 13:
				inputOutputText.append("press 1 to feed all animals in the zoo\n");
				inputOutputText.append("press 2 to see your supplay in your zoo\n");
				inputOutputText.append("press 3 to add supplay for the zoo\n");
				inputOutputText.append("press 4 to see price menue\n");
				choose = exp.tryCatchFuncNumbers(1, 4, inputOutputText.toString());
				inputOutputText.setLength(0);
				if (choose == 1) {
					inputOutputText.append(manger.feedAllAnimalsInZoo());
					IO.showMessageDialog(null, inputOutputText);
				} else if (choose == 2) {
					inputOutputText.append(manger.getSupplayInZoo());
					IO.showMessageDialog(null, inputOutputText);

				} else if (choose == 3)
					userInpt.addSupplayForZoo();
				else if (choose == 4) {
					inputOutputText.append(manger.getPriceMenuForEverythingYouCanBuy());
					IO.showMessageDialog(null, inputOutputText);

				}

				break;
			case 14:
				inputOutputText.append(manger.allMakeNoise());
				IO.showMessageDialog(null, inputOutputText);
				break;

			case 15:
				inputOutputText.append(manger.getthe2ColorsThatAppearThMmostInFish());
				IO.showMessageDialog(null, inputOutputText);
				break;

			case 16:
				IO.showMessageDialog(null, manger.ageOneYear());

				break;
			case 17:
				inputOutputText.append(manger.getMoneyWithMassage());
				IO.showMessageDialog(null, inputOutputText);

				break;
			case 18:
				inputOutputText.append(manger.getPriceMenuForEverythingYouCanBuy());
				IO.showMessageDialog(null, inputOutputText);

				break;

			case -1:
				break;

			default:
				IO.showMessageDialog(null, "Error, select one of the menu options again");

			}

		}
		IO.showMessageDialog(null, "\nBye Bye");

	}

	static int chooseMenu(Scanner scan) {
		boolean finished = false;
		int choose = 0;
		StringBuffer str = new StringBuffer();
		str.append("Enter one of the menu options: \n");
		str.append("1) Displaying zoo details\n");
		str.append("2) Adding a new penguin\n"); // <-
		str.append("3) to choose how to  sort animals**  (see patch notes)\n");
		str.append("4) See all the penguins in the zoo according to your sorting selection (defult by height)\n");
		str.append("5) Showing the details of the carnivore\n");
		str.append("6) Adding a new carnivore\n");
		str.append(
				"7) Displaying the details of the fish in the aquarium and a list of their colors without duplication\n");
		str.append("8) Adding new fish\n");
		str.append("9) show all lemurs in zoo\n");
		str.append("10) add new lemur\n");
		str.append("11) show all cervus in zoo\n");
		str.append("12) add new cervus\n");
		str.append("13) To feed all the animals \n");
		str.append("14) Listening to all animals \n");
		str.append("15) To see the 2 dominant colors in the fish \n");
		str.append("16) A year has passed \n");
		str.append("17) see your money\n");
		str.append("18) price nenue\n ");
		str.append("-1) EXIT\n");

		while (!finished) {
			try {
				String input = IO.showInputDialog(str);
				if (input == null) {
					choose = -1;
					break;
				}
				choose = Integer.parseInt(input);
				finished = true;
			} catch (InputMismatchException e) {
				IO.showMessageDialog(null, "Please enter a valid number");
			} catch (Exception e) { // A exception that we didn't think about.
				IO.showMessageDialog(null, "EROR, Please enter number again");

			}

		}
		return choose;

	}

	private static void hardCode(ZooManger manger, userInputOutput userInpt)
			throws MyException, MyExceptionForHeight, MyExceptionAge {

		// Penguin
		Penguin penguins[] = new Penguin[5];
		penguins[0] = new Penguin("Nelly", 5, 200);
		penguins[1] = new Penguin("Skipper", 1, 50);
		penguins[2] = new Penguin("Pingy", 3, 100);
		penguins[3] = new Penguin("Lior", 4, 70);
		penguins[4] = new Penguin("Orian", 2, 120);
		for (int i = 0; i < penguins.length; i++)
			manger.addPenguinToSystem(penguins[i]);

		// Lion
		Lion lions[] = new Lion[4];
		lions[0] = new Lion("Simba", Gender.MALE, 5, 175);
		lions[1] = new Lion("Kafir", Gender.MALE, 7, 200);
		lions[2] = new Lion("Lala", Gender.FEMALE, 5, 175);
		lions[3] = new Lion("Lali", Gender.FEMALE, 1, 100);

		for (int i = 0; i < lions.length; i++)
			manger.addCarnivoreToSystem(lions[i]);

		// Fish
		userInpt.addRandomFishToZoo(10, false);

		// Lemur
		Lemur lemurs[] = new Lemur[3];
		lemurs[0] = new Lemur("King Julian", 4, 38);
		lemurs[1] = new Lemur("Morris", 6, 35);
		lemurs[2] = new Lemur("Mort", 2, 30);
		for (int i = 0; i < lemurs.length; i++)
			manger.addNewLemurToSystem(lemurs[i]);

		// Cervus
		Cervus cervus[] = new Cervus[2];
		cervus[0] = new Cervus("Eyal", Gender.MALE, 4, 0.2);
		cervus[1] = new Cervus("Ayala", Gender.MALE, 0, 0);
		for (int i = 0; i < cervus.length; i++)
			manger.addNewCervusToSystem(cervus[i]);
	}

}
