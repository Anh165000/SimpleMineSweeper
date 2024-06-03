package data;

import java.util.Random;

public class MapMine {
    private final int MINE = 75;
    private final int N = 29;
    private final int M = 14;
    private final int MINENAME = 9;
    private final int NOTMINENAME_FIRSTCHOICE = 10;
    private boolean checkState[][] = new boolean[N][M];
    private char cC = '#';
    private char cO = '.';
    private int remainingMines = 0;
    private int a[][] = new int[N][M];
    private Random rand = new Random();

    public MapMine() {
    }

    public void setFirst_State() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                checkState[i][j] = false;
            }
        }
    }

    public void setCheckState(int n, int m, boolean set_stage) {
        checkState[n][m] = set_stage;
    }

    public int[][] getA() {
        return a;
    }

    public int getMINENAME() {
        return MINENAME;
    }

    public int getNOTMINENAME_FIRSTCHOICE() {
        return NOTMINENAME_FIRSTCHOICE;
    }

    public void setA(int n, int m, int temp) {
        a[n - 1][m - 1] = temp;
    }

    public void setRemainingMines(int remainingMines) {
        this.remainingMines = remainingMines;
    }

    public void getRandomMine() {
        int temp = rand.nextInt(405) + 1;
        for (int i = 0; i < MINE; i++) {
            while (true) {
                if (a[temp / 14][temp % 14] != MINENAME && a[temp / 14][temp % 14] != NOTMINENAME_FIRSTCHOICE
                        && checkState[temp / 14][temp % 14] != true) {
                    a[temp / 14][temp % 14] = MINENAME;
                    break;
                } else {
                    temp = rand.nextInt(405) + 1;
                }
            }
        }
    }

    public void checkMine() {
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                if (a[i][j] != MINENAME)
                    a[i][j] = countMineAround(i, j);
            }
        }
    }

    public int countMineAround(int i, int j) {
        int countMineAroundI = 0;
        if ((i > 0 && j > 0) && (i < 27 && j < 12)) {
            if (a[i - 1][j - 1] == MINENAME)
                countMineAroundI += 1;
            else if (a[i - 1][j] == MINENAME)
                countMineAroundI += 1;
            else if (a[i - 1][j + 1] == MINENAME)
                countMineAroundI += 1;
            else if (a[i][j - 1] == MINENAME)
                countMineAroundI += 1;
            else if (a[i][j + 1] == MINENAME)
                countMineAroundI += 1;
            else if (a[i + 1][j - 1] == MINENAME)
                countMineAroundI += 1;
            else if (a[i + 1][j] == MINENAME)
                countMineAroundI += 1;
            else if (a[i + 1][j + 1] == MINENAME)
                countMineAroundI += 1;
        } else if (i == 0 && (j > 0 && j < 12)) {
            if (a[i][j - 1] == MINENAME)
                countMineAroundI += 1;
            else if (a[i][j + 1] == MINENAME)
                countMineAroundI += 1;
            else if (a[i + 1][j - 1] == MINENAME)
                countMineAroundI += 1;
            else if (a[i + 1][j] == MINENAME)
                countMineAroundI += 1;
            else if (a[i + 1][j + 1] == MINENAME)
                countMineAroundI += 1;
        } else if (i == 27 && (j > 0 && j < 12)) {
            if (a[i - 1][j - 1] == MINENAME)
                countMineAroundI += 1;
            else if (a[i - 1][j] == MINENAME)
                countMineAroundI += 1;
            else if (a[i - 1][j + 1] == MINENAME)
                countMineAroundI += 1;
            else if (a[i][j - 1] == MINENAME)
                countMineAroundI += 1;
            else if (a[i][j + 1] == MINENAME)
                countMineAroundI += 1;
        } else if ((j == 0) && (i > 0 && i < 27)) {
            if (a[i - 1][j] == MINENAME)
                countMineAroundI += 1;
            else if (a[i - 1][j + 1] == MINENAME)
                countMineAroundI += 1;
            else if (a[i][j + 1] == MINENAME)
                countMineAroundI += 1;
            else if (a[i + 1][j] == MINENAME)
                countMineAroundI += 1;
            else if (a[i + 1][j + 1] == MINENAME)
                countMineAroundI += 1;
        } else if ((j == 12 && (i > 0 && i < 27))) {
            if (a[i - 1][j - 1] == MINENAME)
                countMineAroundI += 1;
            else if (a[i - 1][j] == MINENAME)
                countMineAroundI += 1;
            else if (a[i][j - 1] == MINENAME)
                countMineAroundI += 1;
            else if (a[i + 1][j - 1] == MINENAME)
                countMineAroundI += 1;
            else if (a[i + 1][j] == MINENAME)
                countMineAroundI += 1;
        } else if (i == 0 && j == 0) {
            if (a[i][j + 1] == MINENAME)
                countMineAroundI += 1;
            else if (a[i + 1][j] == MINENAME)
                countMineAroundI += 1;
            else if (a[i + 1][j + 1] == MINENAME)
                countMineAroundI += 1;
        } else if (i == 27 && j == 0) {
            if (a[i - 1][j] == MINENAME)
                countMineAroundI += 1;
            else if (a[i - 1][j + 1] == MINENAME)
                countMineAroundI += 1;
            else if (a[i][j + 1] == MINENAME)
                countMineAroundI += 1;
        } else if (i == 0 && j == 12) {
            if (a[i][j - 1] == MINENAME)
                countMineAroundI += 1;
            else if (a[i + 1][j - 1] == MINENAME)
                countMineAroundI += 1;
            else if (a[i + 1][j] == MINENAME)
                countMineAroundI += 1;
        } else if (i == 27 && j == 12) {
            if (a[i - 1][j - 1] == MINENAME)
                countMineAroundI += 1;
            else if (a[i - 1][j] == MINENAME)
                countMineAroundI += 1;
            else if (a[i][j - 1] == MINENAME)
                countMineAroundI += 1;
        }
        return countMineAroundI;
    }

    public int getRemainingMines() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (a[i][j] == MINENAME)
                    remainingMines += 1;
            }
        }
        return remainingMines;
    }

    public void outputMapMine() {
        for (int i = 0; i < N; i++) {
            System.out.printf("%-2d ", i);
            for (int j = 1; j < M; j++) {
                if (i == 0)
                    System.out.printf("%-2d ", j);
                else
                    System.out.printf("%-2d ", a[i - 1][j - 1]);
            }
            System.out.println();
        }
    }

    public void print_OpenRules_AllAround(int i, int j) {
        // neeus a[i][j] = 0 mowis xet tiep, khong thif de quy in soo min xung quanh no
        // top left edge
        if (i == 0 && j == 0) {
            if (a[i][j] == 0) {
                checkState[i][j + 1] = true;
                print_OpenRules_AllAround(i, j + 1);
                checkState[i + 1][j] = true;
                print_OpenRules_AllAround(i + 1, j);
                checkState[i + 1][j + 1] = true;
                print_OpenRules_AllAround(i + 1, j + 1);
            } else {
                checkState[i][j] = true;
            }
        } // top right edge
        else if (i == 0 && j == 12) {
            if (a[i][j] == 0) {
                checkState[i][j - 1] = true;
                print_OpenRules_AllAround(i, j - 1);
                checkState[i + 1][j - 1] = true;
                print_OpenRules_AllAround(i + 1, j - 1);
                checkState[i + 1][j] = true;
                print_OpenRules_AllAround(i + 1, j);
            } else {
                checkState[i][j] = true;
            }
        } // bot left edge
        else if (i == 27 && j == 0) {
            if (a[i][j] == 0) {
                checkState[i - 1][j] = true;
                print_OpenRules_AllAround(i - 1, j);
                checkState[i - 1][j + 1] = true;
                print_OpenRules_AllAround(i - 1, j + 1);
                checkState[i][j + 1] = true;
                print_OpenRules_AllAround(i, j + 1);
            } else {
                checkState[i][j] = true;
            }
        } // bot right edge
        else if (i == 27 && j == 12) {
            if (a[i][j] == 0) {
                checkState[i - 1][j - 1] = true;
                print_OpenRules_AllAround(i - 1, j - 1);
                checkState[i - 1][j] = true;
                print_OpenRules_AllAround(i - 1, j);
                checkState[i][j - 1] = true;
                print_OpenRules_AllAround(i, j - 1);
            } else {
                checkState[i][j] = true;
            }
        } // top edge
        else if (i == 0 && j > 0 && j < 12) {
            if (a[i][j] == 0) {
                checkState[i][j - 1] = true;
                print_OpenRules_AllAround(i, j - 1);
                checkState[i][j + 1] = true;
                print_OpenRules_AllAround(i, j + 1);
                checkState[i + 1][j - 1] = true;
                print_OpenRules_AllAround(i + 1, j - 1);
                checkState[i + 1][j] = true;
                print_OpenRules_AllAround(i + 1, j);
                checkState[i + 1][j + 1] = true;
                print_OpenRules_AllAround(i + 1, j + 1);
            } else {
                checkState[i][j] = true;
            }
        } // bot edge
        else if (i == 27 && j > 0 && j < 12) {
            if (a[i][j] == 0) {
                checkState[i - 1][j - 1] = true;
                print_OpenRules_AllAround(i - 1, j - 1);
                checkState[i - 1][j] = true;
                print_OpenRules_AllAround(i - 1, j);
                checkState[i - 1][j + 1] = true;
                print_OpenRules_AllAround(i - 1, j + 1);
                checkState[i][j - 1] = true;
                print_OpenRules_AllAround(i, j - 1);
                checkState[i][j + 1] = true;
                print_OpenRules_AllAround(i, j + 1);
            } else {
                checkState[i][j] = true;
            }
        } // lefy edge
        else if (j == 0 && i > 0 && i < 12) {
            if (a[i][j] == 0) {
                checkState[i - 1][j] = true;
                print_OpenRules_AllAround(i - 1, j);
                checkState[i - 1][j + 1] = true;
                print_OpenRules_AllAround(i - 1, j + 1);
                checkState[i][j + 1] = true;
                print_OpenRules_AllAround(i, j + 1);
                checkState[i + 1][j] = true;
                print_OpenRules_AllAround(i + 1, j);
                checkState[i + 1][j + 1] = true;
                print_OpenRules_AllAround(i + 1, j + 1);
            } else {
                checkState[i][j] = true;
            }
        } // right edge
        else if (j == 12 && i > 0 && i < 12) {
            if (a[i][j] == 0) {
                checkState[i - 1][j - 1] = true;
                print_OpenRules_AllAround(i - 1, j - 1);
                checkState[i - 1][j] = true;
                print_OpenRules_AllAround(i - 1, j);
                checkState[i][j - 1] = true;
                print_OpenRules_AllAround(i, j - 1);
                checkState[i + 1][j - 1] = true;
                print_OpenRules_AllAround(i + 1, j - 1);
                checkState[i + 1][j] = true;
                print_OpenRules_AllAround(i + 1, j);
            } else {
                checkState[i][j] = true;
            }
        } else {
            
        }
    }

    public void outputPlayMap() {
        // for (int i = 0; i < N; i++) {
        // // System.out.printf("%-2d ", i);
        // for (int j = 1; j < M; j++) {
        // if (i == 0) {
        // } else {
        // if (checkState[i - 1][j - 1] == true) {
        // print_OpenRules_AllAround(i - 1, j - 1);
        // }
        // }
        // }
        // System.out.println();
        // }
        for (int i = 0; i < N; i++) {
            System.out.printf("%-2d ", i);
            for (int j = 1; j < M; j++) {
                if (i == 0)
                    System.out.printf("%-2d ", j);
                else {
                    if (checkState[i - 1][j - 1] == true) {
                        if (a[i - 1][j - 1] != 0)
                            System.out.printf("%-2d ", a[i - 1][j - 1]);
                        else
                            System.out.printf("%-2c ", cO);
                    } else {
                        System.out.printf("%-2c ", cC);
                    }
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        MapMine map = new MapMine();
        map.getRandomMine();
        map.checkMine();
        map.outputMapMine();
        System.out.println(map.getRemainingMines());
    }
}
