package com.mcnz.rps;

import javax.swing.JOptionPane;
import java.util.Vector;

public class DesktopGame {
    public enum Gesture { ROCK, PAPER, SCISSORS }

    public static void main(String[] args) {
        String prompt = "Will it be rock, paper, or scissors?";
        Score score = new Score();
        Vector<GameSummary> history = new Vector<>();

        while (true) {
            String result = "error";
            String input = JOptionPane.showInputDialog(prompt);

            switch (input.toLowerCase()) {
                case "scissors":
                    result = "lose";
                    score.increaseLosses();
                    break;
                case "paper":
                    result = "win";
                    score.increaseWins();
                    break;
                case "rock":
                    result = "tie";
                    score.increaseTies();
                    break;
                case "quit":
                    return;
            }

            GameSummary gs = new GameSummary(input, "rock", result);
            history.add(gs);

            JOptionPane.showMessageDialog(null, result);
            System.out.println(score);
            for (GameSummary gameSummary : history) {
                System.out.println(gameSummary);
            }
        }
    }
}
