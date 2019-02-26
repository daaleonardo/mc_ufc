package org.academiadecodigo.tropadelete.alpha.mc_ufc;

import org.academiadecodigo.tropadelete.alpha.mc_ufc.directions.KeyboardListener;

public class Main {
    public static void main(String[] args) {


       Game game = new Game();


        KeyboardListener listener = new KeyboardListener(game);

       while (true){
           try{
           Thread.sleep(30);
           game.move();


           } catch (InterruptedException e){
               e.printStackTrace();
           }
       }
    }

}
