package com.hackerRank.solutions;

import java.util.*;

public class Solution2 {

    public static class Player{

        int innings;

        int run;

        String player;

        public int getInnings() {
            return innings;
        }

        public int getRun() {
            return run;
        }

        public void setRun(int run) {
            this.run = run;
        }

        public void setInnings(int innings) {
            this.innings = innings;
        }

        public String getPlayer() {
            return player;
        }

        public void setPlayer(String player) {
            this.player = player;
        }
    }

    public static class PlayerStatisticsCollectorImpl implements PlayerStatisticsCollector {

        Map<String,Player> mapOfPlayer=new HashMap<String,Player>();
        @Override
        public void putNewInnings(String player, int runs){

            if(mapOfPlayer.containsKey(player)){
                Player playerObject= mapOfPlayer.get(player);
                playerObject.setInnings(playerObject.getInnings()+1);
                playerObject.setRun(playerObject.getRun()+runs);

            }else{
                Player playerObject =new Player();
                playerObject.setPlayer(player);
                playerObject.setInnings(1);
                playerObject.setRun(runs);
                mapOfPlayer.put(player,playerObject);
            }

            // YOUR CODE HERE
        }

        @Override
        public double getAverageRuns(String player){

            double average=0.0;
            Player playerObject=mapOfPlayer.get(player);
            if(playerObject!=null){
                average= (double) playerObject.getRun()/playerObject.getInnings();
            }
            return average;
        }

        @Override
        public int getInningsCount(String player){
            Player playerObject=mapOfPlayer.get(player);
           return playerObject.getInnings();
        }
    }

    ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

    public interface PlayerStatisticsCollector {
        // This is an input. Make note of this player inning.  Runs is a non negative integer.
        void putNewInnings(String player, int runs);

        // Get the runs average(mathematical average) for a player
        double getAverageRuns(String player);

        // Get the total number of innings for the player
        int getInningsCount(String player);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLines = Integer.parseInt(scanner.nextLine());
        int currentLine = 0;
        while (currentLine++ < numLines) {
            final PlayerStatisticsCollector stats = new PlayerStatisticsCollectorImpl();
            final Set<String> players = new TreeSet<>();

            String line = scanner.nextLine();
            String[] inputs = line.split(",");
            for (int i = 0; i < inputs.length; ++i) {
                String[] tokens = inputs[i].split(" ");
                final String player = tokens[0];
                players.add(player);
                final int runs = Integer.parseInt(tokens[1]);

                stats.putNewInnings(player, runs);

            }

            for (String player : players) {
                System.out.println(
                        String.format("%s %.4f %d", player, stats.getAverageRuns(player), stats.getInningsCount(player)));
            }

        }
        scanner.close();

    }
}
