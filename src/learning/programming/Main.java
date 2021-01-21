package learning.programming;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		Machine machine = new Machine(500,200,50,9,150,new ConsoleOutput());

		machine.startMachine();

	}

}
