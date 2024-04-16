package ie.tudublin;

import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;
import ie.tudublin.C22338873.Waveform3D;


public class Main {

    public void startUI() {
        String[] a = { "MAIN" };
        processing.core.PApplet.runSketch(a, new Waveform3D());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.startUI();
    }
}