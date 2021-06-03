package com.hackerRank.solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Player {
    String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

class Checker implements Comparator<Player> {
  	// complete this method
	public int compare(Player a, Player b) {

//	    if(a.name==null && b.name==null){
//	        return 0;
//        }

        int value = a.score == b.score ? 0 : a.score > b.score ? -1 : 1;
       // System.out.println(a.score == b.score);
       // System.out.println("value :" + value);

        if (value != 0) {
            return value;
        } else {
         //   System.out.println("Values : " + a.name + " : " + b.name);
            return a.name.compareTo(b.name);

        }
    }
}


public class SolutionComparator {

    static File file =
            new File("C:\\Users\\611263856\\GRADLE_WORKSPACE\\WLMS2Client_package\\SolutionComparator.txt");

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        int n = scan.nextInt();
        Player[] player = new Player[n];
        Checker checker = new Checker();
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();
        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}