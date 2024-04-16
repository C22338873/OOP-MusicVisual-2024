package ie.tudublin;

import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;
<<<<<<< HEAD
import ie.tudublin.C22338873.Waveform3D;
=======
>>>>>>> 7556433eaf5818b08c4d0bbc1c6dab6fc9c78a57


public class Main {

    public void startUI() {
        String[] a = { "MAIN" };
<<<<<<< HEAD
        processing.core.PApplet.runSketch(a, new Waveform3D());
=======
        processing.core.PApplet.runSketch(a, new RotatingAudioBands());
>>>>>>> 7556433eaf5818b08c4d0bbc1c6dab6fc9c78a57
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.startUI();
    }
}