package learning.programming;

import java.io.*;

public class FileOutput implements Output {
	private PrintWriter printWriter;

	{
		try {
			File file = new File("D:\\programming\\Test\\src\\file.txt");
			printWriter = new PrintWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void printStatus(int water, int milk, int beans, int cups, int money) {
		printWriter.printf(StringConstant.REMAINING,water,milk,beans,cups,money);
	}

	@Override
	public void showNotEnoughWater() {
		printWriter.println(StringConstant.SORRY_FOR_WATER);
	}

	@Override
	public void showNotEnoughMilk() {
		printWriter.println(StringConstant.SORRY_FOR_MILK );
	}

	@Override
	public void showNotEnoughBeans() {
		printWriter.println(StringConstant.SORRY_FOR_BEANS);
	}

	@Override
	public void showNotEnoughCups(){
		printWriter.println(StringConstant.SORRY_FOR_CUPS);
	}

	@Override
	public void askForWater() {
		printWriter.println(StringConstant.ASK_FOR_WATER);
	}

	@Override
	public void askForMilk() {
		printWriter.println(StringConstant.ASK_FOR_MILK);
	}

	@Override
	public void askForBeans() {
		printWriter.println(StringConstant.ASK_FOR_BEANS);
	}

	@Override
	public void askForCups() {
		printWriter.println(StringConstant.ASK_FOR_CUPS);
	}

	@Override
	public void unknownCommand() {
		printWriter.println(StringConstant.UNKNOWN_COMMAND);
	}

	@Override
	public void printMenuOptions(int choice)  {
		switch (choice) {
			case -1:
				printWriter.println(StringConstant.ASK_FOR_ACTION + "\n");
				break;
			case 0:
				printWriter.println(StringConstant.ASK_FOR_PRODUCT + "\n");
				break;
			default:
				printWriter.println(StringConstant.TAKE_MONEY + choice + "\n");
				break;
		}

	}

	@Override
	public void status(){
		printWriter.println(StringConstant.STATUS);
	}

	@Override
	public void exiting()  {
		printWriter.println(StringConstant.EXITING);
	}

	@Override
	public void closeFile() {
		printWriter.close();
	}
}
