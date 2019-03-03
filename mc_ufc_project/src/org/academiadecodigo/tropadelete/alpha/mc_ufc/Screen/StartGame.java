package org.academiadecodigo.tropadelete.alpha.mc_ufc.Screen;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class StartGame {

    private Picture menu;

    public StartGame() {

        menu = new Picture(10,10,"Resources/press-space.png");

    }

    public void show(){

        menu.draw();
    }

    public void delete(){
        menu.delete();
    }


}
