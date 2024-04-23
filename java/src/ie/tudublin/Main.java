package ie.tudublin;

import processing.core.PApplet;
import ie.tudublin.C22506249.LiutaurasVisual;


public class Main {

    public void startUI() {
        String[] a = { "MAIN" };
        PApplet.runSketch(a, new LiutaurasVisual());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.startUI();
    }
}

