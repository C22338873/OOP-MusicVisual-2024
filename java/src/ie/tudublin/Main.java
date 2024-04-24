package ie.tudublin;

import processing.core.PApplet;
import ie.tudublin.C22506249.LiutaurasVisual;
import example.AudioBandsVisual; // Add the missing import statement
import ie.tudublin.D20123962.NikitaVisual;


public class Main {

    public void startUI() {
        String[] a = { "MAIN" };
        PApplet.runSketch(a, new LiutaurasVisual());
        PApplet.runSketch(a, new NikitaVisual());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.startUI();
    }
}

