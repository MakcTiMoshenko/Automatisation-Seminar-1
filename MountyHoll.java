package org.max.homework;

import java.util.Random;

public class MountyHoll {
    static  final int NUM_DOORS = 3;
    static  final int CAR_DOOR = 1;

    private Random random;

    public MountyHoll(){
        random = new Random();
    }

    public  int chooseDoor(){
        return random.nextInt(NUM_DOORS) + 1;
    }

    public  int openDoor(int chosenDoor){
        int openedDoor;
        do{
            openedDoor = random.nextInt(NUM_DOORS) + 1;
        }
        while (openedDoor == chosenDoor || openedDoor == CAR_DOOR);
        return openedDoor;
    }

    public  int switchDoor(int chosenDoor, int openedDoor){
        int newDoor;
        do{
            newDoor = random.nextInt(NUM_DOORS) + 1;
        }
        while (newDoor == chosenDoor || newDoor == openedDoor);
        return newDoor;
    }

    public void playGame(int numIterations){
        int switchWins = 0;
        int stayWins = 0;

        for(int i = 0; i < numIterations; i++){
            int chosenDoor = chooseDoor();
            int openedDoor = openDoor(chosenDoor);
            int switchedDoor = switchDoor(chosenDoor,openedDoor);

            if (chosenDoor == CAR_DOOR){

                stayWins++;

            }
            else if (switchedDoor == CAR_DOOR){
                switchWins++;

            }

        }
        getResult(numIterations, switchWins, stayWins);
    }
    public void getResult(int totalIterations, int switchWins, int stayWins){
        double switchWinPercentage = (switchWins * 100.0) / totalIterations;
        double stayWinPercentage = (stayWins * 100.0) / totalIterations;

        System.out.println("С призом выиграл при смене двери: " + switchWinPercentage + "%");
        System.out.println("Выиграло игорков сменивших выбор: " + switchWins);
        System.out.println("С призом выиграл при первоначальном выборе: " + stayWinPercentage + "%");
        System.out.println("Выиграло игорков оставивших выбор: " + stayWins);
    }

    public static void main(String[] arg){
        MountyHoll game = new MountyHoll();
        game.playGame(1000);
    }


}


