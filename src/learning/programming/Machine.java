package learning.programming;

import java.io.IOException;

public class Machine {

    public enum Menu {
        BUY_MENU(0),
        MAIN_MENU(-1);


        private final int var;

        Menu(int var) {
            this.var = var;
        }

        public int getVar() {
            return var;
        }
    }

    private enum State {

        CHOOSING_OPTION{
            @Override
            void process(Machine m, String input) throws IOException {
                switch (input) {
                    case "buy":
                        m.state = CHOOSING_PRODUCT;
                        m.output.printMenuOptions(Menu.BUY_MENU.getVar());
                        break;
                    case "exit" :
                        m.state = EXIT;
                        m.output.exiting();
                        break;
                    case "take" :
                        m.state = TAKE_MONEY;
                        m.state.process(m,null);
                        break;
                    case "remaining":
                        m.state = STATUS;
                        m.output.status();
                        m.state.process(m,null);

                        break;
                    case "fill" :
                        m.state = REFILL_WATER;
                        m.output.askForWater();
                        break;
                    default:
                        m.output.unknownCommand();
                        break;

                }

            }
        },

        CHOOSING_PRODUCT {
            @Override
            void process(Machine m, String input) throws IOException {
                m.chooseProduct(input);
                m.output.printMenuOptions(Menu.MAIN_MENU.getVar());
                m.state = CHOOSING_OPTION;
            }
        },

        REFILL_WATER {
            @Override
            void process(Machine m, String input) throws IOException {
                m.fillWater(input);
                m.state = REFILL_MILK;
                m.output.askForMilk();
            }
        },

        REFILL_MILK {
            @Override
            void process(Machine m, String input) throws IOException {
                m.fillMilk(input);
                m.state = REFILL_BEANS;
                m.output.askForBeans();
            }
        },

        REFILL_BEANS {
            @Override
            void process(Machine m, String input) throws IOException {
                m.fillBeans(input);
                m.state = REFILL_CUPS;
                m.output.askForCups();
            }
        },

        REFILL_CUPS {
            @Override
            void process(Machine m, String input) throws IOException {
                m.fillCups(input);
                m.state = CHOOSING_OPTION;
                m.output.printMenuOptions(Menu.MAIN_MENU.getVar());
            }
        },

        TAKE_MONEY {
            @Override
            void process(Machine m, String input) throws IOException {
                m.output.printMenuOptions(m.money);
                m.money = 0;
                m.state = CHOOSING_OPTION;
                m.output.printMenuOptions(Menu.MAIN_MENU.getVar());
            }
        },

        STATUS {
            @Override
            void process(Machine m, String input) throws IOException {
                m.printStatus();
                m.output.printMenuOptions(Menu.MAIN_MENU.getVar());
                m.state = CHOOSING_OPTION;
            }
        },

        EXIT {
            @Override
            void process(Machine m, String input) throws IOException {
                m.output.closeFile();
            }
        };

        abstract void process(Machine m,String input) throws IOException;
    }

    private State state;
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;
    private final Output output;

    public Machine(int water, int milk, int beans, int cups, int money, Output output) throws IOException {
        this.milk = milk;
        this.water = water;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
        this.output = output;

        this.state = State.CHOOSING_OPTION;
        output.printMenuOptions(Menu.MAIN_MENU.getVar());
    }

    private String getInput() {
        ConsoleInput consoleInput = new ConsoleInput();
        return consoleInput.getInput();
    }

    private void makeProduct(CoffeeType coffeeType) throws IOException{

        if (this.water < coffeeType.getWater()) {

            output.showNotEnoughWater();

        } else  if (this.beans < coffeeType.getBeans()) {
            output.showNotEnoughBeans();

        } else if (this.milk < coffeeType.getMilk()) {

            output.showNotEnoughMilk();

        } else if (this.cups < coffeeType.getCups()){

            output.showNotEnoughCups();

        } else {
            updateValues(coffeeType.getWater(), coffeeType.getMilk(), coffeeType.getBeans(), coffeeType.getPrice());
        }
    }

    private void updateValues(int water, int milk, int beans, int money){
        this.water -= water;
        this.milk -= milk;
        this.beans -= beans;
        this.money += money;
        this.cups --;
    }



    private void chooseProduct(String choice) throws IOException{
        int coffeeTypeIndex = Integer.parseInt(choice) - 1;
        CoffeeType x = CoffeeType.values()[coffeeTypeIndex];
        makeProduct(x);
    }

    protected void fillWater(String input) {

        water += Integer.parseInt(input);

    }
    protected void fillMilk(String input) {
        milk += Integer.parseInt(input);
    }
    protected void fillBeans(String input) {
        beans += Integer.parseInt(input);
    }
    protected void fillCups(String input) {
        cups += Integer.parseInt(input);
    }

    private void printStatus() throws IOException {
        output.printStatus(this.water,this.milk,this.beans,this.cups,this.money);
    }

    public void startMachine() throws IOException {
        String action = null;
        while(state != State.EXIT) {

            action = getInput().toLowerCase();


            state.process(this,action);
        }
    }
}
