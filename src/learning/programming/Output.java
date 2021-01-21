package learning.programming;

import java.io.IOException;

public interface Output {
	void printStatus(int water, int milk, int beans, int cups, int money) throws IOException;

	void askForWater();

	void askForMilk();

	void askForBeans();

	void askForCups();

	void unknownCommand();

	void printMenuOptions(int x) throws IOException;

	void closeFile() throws IOException;

	void showNotEnoughWater() throws IOException;

	void showNotEnoughMilk() throws IOException;

	void showNotEnoughBeans() throws IOException;

	void showNotEnoughCups() throws IOException;

	void exiting() throws IOException;

	void status() throws IOException;
}
