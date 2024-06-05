package data;

import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

import data.MapMine;
import main.*;

public class SelectionProcessing {
    private static MapMine map = new MapMine();
    private static int M;
    private static int N;
    private Scanner sc = new Scanner(System.in);

    public SelectionProcessing() {

    }

    public void getMN(){
        while (true){
            try {
                M = Integer.parseInt(sc.nextLine());
                N = Integer.parseInt(sc.nextLine());
                if (M < 0 && M > 13 && N < 0 && N > 28){
                    System.out.println("format error");    
                } break;
            } catch (Exception e) {
                System.out.println("format error");
            }
        }
    }
}
