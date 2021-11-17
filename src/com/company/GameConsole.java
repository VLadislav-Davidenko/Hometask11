package com.company;

public class GameConsole implements Powered {
    static String brand = "Sony";
    final static String model = "PS5";
    static String serial = "XC675WeQR";
    Gamepad firstGamepad;
    Gamepad secondGamepad;
    static boolean isOn;
    Game activeGame;
    int waitingCounter;

    @Override
    public void powerOn() {
        isOn = true;
    }

    @Override
    public void powerOff() {
        isOn = false;
    }

    public class Gamepad implements Powered{
        String brand;
        String consoleSerial;
        int connectedNumber;
        Color color;
        double chargeLevel = 100.0;
        boolean isOn;

        public Gamepad(String brand, int connectedNumber) {
            this.brand = brand;
            this.connectedNumber = connectedNumber;
            this.consoleSerial = GameConsole.serial;
        }

        public void loadGame(Game game){
            System.out.println("Игра " + game + " загружается");
        }
        public void playGame(Game game){
            System.out.println("Играем в " + game + " загружается");
            if (firstGamepad.isOn) {
                System.out.println(firstGamepad.chargeLevel + "%");
            }
            else {
                System.out.println(secondGamepad.chargeLevel + "%");
            }
            checkStatus();
            if(chargeLevel <= 0){
                GameConsole.isOn = false;
            }else{
                chargeLevel -= 10;
            }

        }

        private void checkStatus(){
            if(firstGamepad.isOn){
               waitingCounter = 0;
            } else if(secondGamepad.isOn){
                waitingCounter = 0;
            } else{
                waitingCounter++;
            }
            if (waitingCounter >= 5){
                GameConsole.isOn = false;
                System.out.println("Приставка завершает работу из-за \n" +
                        "отсутствия активности");
            }
        }

        @Override
        public void powerOn() {
            isOn = true;
            GameConsole.isOn = true;
        }

        @Override
        public void powerOff() {
            isOn = false;
        }

    }
    public GameConsole(String brand, String serial) {
        GameConsole.brand = brand;
        GameConsole.serial = serial;
        this.firstGamepad = new Gamepad(GameConsole.brand, 1);
        this.secondGamepad = new Gamepad(GameConsole.brand, 2);
        if(firstGamepad.isOn){
            firstGamepad = secondGamepad;
        }

    }



    public static String getBrand() {
        return brand;
    }

    public static void setBrand(String brand) {
        GameConsole.brand = brand;
    }

    public static String getSerial() {
        return serial;
    }

    public static void setSerial(String serial) {
        GameConsole.serial = serial;
    }

    public Gamepad getFirstGamepad() {
        return firstGamepad;
    }

    public void setFirstGamepad(Gamepad firstGamepad) {
        this.firstGamepad = firstGamepad;
    }

    public Gamepad getSecondGamepad() {
        return secondGamepad;
    }

    public void setSecondGamepad(Gamepad secondGamepad) {
        this.secondGamepad = secondGamepad;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }


}
