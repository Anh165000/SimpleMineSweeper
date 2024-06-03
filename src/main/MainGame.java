package main;

import data.*;
import java.util.Scanner;

public class MainGame {
    private static Scanner scanner = new Scanner(System.in);
    private static MapMine mapMine = new MapMine();
    private static SelectionProcessing selection = new SelectionProcessing();
    private static final String STATUS_CHOICE = "enter your choice ";
    private static final String STATUS_CHOICE_ERROR = "format error, enter your choice again ";
    private static final String WIN = "Congratulations, you won!";
    private static final String LOSS = "You lost!";
    private static final int N = 28;
    private static final int M = 13;
    private static int a[][] = new int[N][M];
    private static int choiceN;
    private static int choiceM;
    private static int state;

    public MainGame() {
    }

    public static void main(String[] args) {
        // mapMine.outputPlayMap();
        getMN();
        mapMine.setFirst_State();
        mapMine.setCheckState(choiceN - 1, choiceM - 1, true);
        mapMine.setA(choiceN, choiceM, mapMine.getNOTMINENAME_FIRSTCHOICE());
        getMapMine_MainGame();
        mapMine.print_OpenRules_AllAround(choiceN - 1, choiceM - 1);
        mapMine.outputPlayMap();
        //selectionProcessing();
    }

    public static void getMapMine_MainGame() {
        //set around first choice == notmine
        if (choiceN - 1 == 0 && choiceM - 1 == 0) {
            mapMine.setCheckState(choiceN - 1, choiceM, true);
            mapMine.setCheckState(choiceN, choiceM - 1, true);
            mapMine.setCheckState(choiceN, choiceM, true);
        } // top right edge
        else if (choiceN - 1 == 0 && choiceM - 1 == 12) {
            mapMine.setCheckState(choiceN - 1, choiceM - 2, true);
            mapMine.setCheckState(choiceN, choiceM - 2, true);
            mapMine.setCheckState(choiceN, choiceM - 1, true);
        } // top edge
        else if (choiceN - 1 == 0 && choiceM - 1 > 0 && choiceM - 1 < 12) {
            mapMine.setCheckState(choiceN - 1, choiceM - 2, true);
            mapMine.setCheckState(choiceN - 1, choiceM, true);
            mapMine.setCheckState(choiceN, choiceM - 2, true);
            mapMine.setCheckState(choiceN, choiceM - 1, true);
            mapMine.setCheckState(choiceN, choiceM, true);
        } // bot left edge
        else if (choiceN - 1 == 27 && choiceM - 1 == 0) {
            mapMine.setCheckState(choiceN - 2, choiceM - 1, true);
            mapMine.setCheckState(choiceN - 2, choiceM, true);
            mapMine.setCheckState(choiceN - 1, choiceM, true);
        } // bot right edge
        else if (choiceN - 1 == 27 && choiceM - 1 == 12) {
            mapMine.setCheckState(choiceN - 2, choiceM - 2, true);
            mapMine.setCheckState(choiceN - 2, choiceM - 1, true);
            mapMine.setCheckState(choiceN - 1, choiceM - 2, true);
        } // bot edge
        else if (choiceN - 1 == 27 && choiceM - 1 > 0 && choiceM - 1 < 12) {
            mapMine.setCheckState(choiceN - 2, choiceM - 2, true);
            mapMine.setCheckState(choiceN - 2, choiceM - 1, true);
            mapMine.setCheckState(choiceN - 2, choiceM, true);
            mapMine.setCheckState(choiceN - 1, choiceM - 2, true);
            mapMine.setCheckState(choiceN - 1, choiceM, true);
        } // left edge
        else if (choiceM - 1 == 0 && choiceN - 1 > 0 && choiceN - 1 < 12) {
            mapMine.setCheckState(choiceN - 2, choiceM - 1, true);
            mapMine.setCheckState(choiceN - 2, choiceM, true);
            mapMine.setCheckState(choiceN - 1, choiceM, true);
            mapMine.setCheckState(choiceN, choiceM - 1, true);
            mapMine.setCheckState(choiceN, choiceM, true);
        } // right edge
        else if (choiceM - 1 == 12 && choiceN - 1 > 0 && choiceN < 12) {
            mapMine.setCheckState(choiceN - 2, choiceM - 2, true);
            mapMine.setCheckState(choiceN - 2, choiceM - 1, true);
            mapMine.setCheckState(choiceN - 1, choiceM - 2, true);
            mapMine.setCheckState(choiceN, choiceM - 2, true);
            mapMine.setCheckState(choiceN, choiceM - 1, true);
        } else {
            mapMine.setCheckState(choiceN - 2, choiceM - 2, true);
            mapMine.setCheckState(choiceN - 2, choiceM - 1, true);
            mapMine.setCheckState(choiceN - 2, choiceM, true);
            mapMine.setCheckState(choiceN - 1, choiceM - 2, true);
            mapMine.setCheckState(choiceN - 1, choiceM, true);
            mapMine.setCheckState(choiceN, choiceM - 2, true);
            mapMine.setCheckState(choiceN, choiceM - 1, true);
            mapMine.setCheckState(choiceN, choiceM, true);
        }
        mapMine.getRandomMine();
        mapMine.checkMine();
        a = mapMine.getA();
    }

    public static void getMN() {
        while (true) {
            try {
                System.out.println(STATUS_CHOICE);
                choiceN = scanner.nextInt();
                choiceM = scanner.nextInt();
                if (choiceM > M || choiceM < 1 || choiceN > N || choiceN < 1) {

                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(STATUS_CHOICE_ERROR);
            }
        }
    }

    public static int getState() {
        while (true) {
            try {
                System.out.println(STATUS_CHOICE);
                System.out.println("1. Open");
                System.out.println("2. Flag");
                state = scanner.nextInt();
                if (state > 2 || state < 1) {

                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(STATUS_CHOICE_ERROR);
            }
        }
        return state;
    }

    public static void selectionProcessing() {
        mapMine.outputPlayMap();
        getMN();
        mapMine.setFirst_State();
        mapMine.setCheckState(choiceN - 1, choiceM - 1, true);
        getMapMine_MainGame();
        while (true) {
            mapMine.outputPlayMap();
            getMN();
            switch (getState()) {
                case 1:
                    if (a[choiceN - 1][choiceM - 1] == mapMine.getMINENAME()) {
                        System.out.println(LOSS);
                        mapMine.outputMapMine();
                    } else {
                        mapMine.setCheckState(choiceN - 1, choiceM - 1, true);
                    }
                    break;
                case 2:

                    break;
            }
            // if (a[choiceN - 1][choiceM - 1] == mapMine.getMINENAME()) {
            // break;
            // }

        }
    }
}