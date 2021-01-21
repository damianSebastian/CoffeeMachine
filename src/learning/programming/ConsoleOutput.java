package learning.programming;

public class ConsoleOutput implements Output {


	@Override
	public void printStatus(int water, int milk, int beans, int cups, int money) {
		System.out.printf(StringConstant.REMAINING,water,milk,beans,cups,money);
	}


	@Override
	public void showNotEnoughWater() {
		System.out.println(StringConstant.SORRY_FOR_WATER);
	}

	@Override
	public void showNotEnoughMilk() {
		System.out.println(StringConstant.SORRY_FOR_MILK);
	}

	@Override
	public void showNotEnoughBeans() {
		System.out.println(StringConstant.SORRY_FOR_BEANS);
	}

	@Override
	public void showNotEnoughCups() {
		System.out.println(StringConstant.SORRY_FOR_CUPS);
	}

	@Override
	public void askForWater() {
		System.out.println(StringConstant.ASK_FOR_WATER);
	}

	@Override
	public void askForMilk() {
		System.out.println(StringConstant.ASK_FOR_MILK);
	}

	@Override
	public void askForBeans() {
		System.out.println(StringConstant.ASK_FOR_BEANS);
	}

	@Override
	public void askForCups() {
		System.out.println(StringConstant.ASK_FOR_CUPS);
	}

	@Override
	public void unknownCommand() {
		System.out.println(StringConstant.UNKNOWN_COMMAND);
	}

	@Override
	public void printMenuOptions(int x) {
		switch (x) {
			case -1:
				System.out.println(StringConstant.ASK_FOR_ACTION);
				break;
			case 0:
				System.out.println(StringConstant.ASK_FOR_PRODUCT);
				break;
			default:
				System.out.println(StringConstant.TAKE_MONEY + x);
				break;


		}
	}

	@Override
	public void status(){
		System.out.println(StringConstant.STATUS);
	}

	@Override
	public void exiting() {
		System.out.println(StringConstant.EXITING);
	}

	@Override
	public void closeFile() { }
}
