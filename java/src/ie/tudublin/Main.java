package ie.tudublin;

import processing.core.PApplet;
import example.AudioBandsVisual; // Add the missing import statement
import ie.tudublin.C22338873.RachealVisual;


public class Main {

    public void startUI() {
        String[] a = { "MAIN" };
        PApplet.runSketch(a, new RachealVisual());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.startUI();
    }
}

