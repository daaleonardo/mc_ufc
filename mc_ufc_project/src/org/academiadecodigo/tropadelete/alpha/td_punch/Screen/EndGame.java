package org.academiadecodigo.tropadelete.alpha.td_punch.Screen;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class EndGame {

    private Picture redWinnerPos1;
    private Picture redWinnerPos2;
    private Picture blueWinnerPos1;
    private Picture blueWinnerPos2;

    private Picture redWins;
    private Picture redWins2;
    private Picture blueWins;
    private Picture blueWins2;

    private int count;

    public void redNeck() {
        redWinnerPos1 = new Picture(445, 80, "Resources/fighters/red-winner-pos-1.png");
        redWinnerPos2 = new Picture(445, 80, "Resources/fighters/red-winner-pos-2.png");
        redWins = new Picture(100, 40, "Resources/fighters/redneck-wins.png");
        redWins2 = new Picture(790, 40, "Resources/fighters/redneck-wins.png");

        try {
            while (true) {
                redWins.draw();
                redWins2.draw();
                redWinnerPos1.draw();
                Thread.sleep(500);
                redWins.translate(0, -20);
                redWins2.translate(0, -20);
                redWinnerPos1.delete();
                redWinnerPos2.draw();
                Thread.sleep(500);
                redWins.translate(0, 20);
                redWins2.translate(0, 20);
                redWinnerPos2.delete();

                count++;

                if (count == 10) {
                    redWins.delete();
                    redWins2.delete();
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void latino() {
        blueWinnerPos1 = new Picture(445, 80, "Resources/fighters/blue-winner-pos-1.png");
        blueWinnerPos2 = new Picture(445, 80, "Resources/fighters/blue-winner-pos-2.png");
        blueWins = new Picture(70, 40, "Resources/fighters/latino-wins.png");
        blueWins2 = new Picture(800, 40, "Resources/fighters/latino-wins.png");

        try {
            while (true) {
                blueWins.draw();
                blueWins2.draw();
                blueWinnerPos1.draw();
                Thread.sleep(500);
                blueWins.translate(0, -20);
                blueWins2.translate(0, -20);
                blueWinnerPos1.delete();
                blueWinnerPos2.draw();
                Thread.sleep(500);
                blueWins.translate(0, 20);
                blueWins2.translate(0, 20);
                blueWinnerPos2.delete();

                count++;

                if (count == 10) {
                    blueWins.delete();
                    blueWins2.delete();
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
