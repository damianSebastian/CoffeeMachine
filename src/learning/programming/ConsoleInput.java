package learning.programming;

import java.util.Scanner;

public class ConsoleInput {
	private final Scanner scanner = new Scanner(System.in);

	public String getInput () {
		return scanner.nextLine();
	}
}
