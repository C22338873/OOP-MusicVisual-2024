package ie.tudublin;

import processing.core.PApplet;
import ie.tudublin.C21371071.ZansVisual;
import ie.tudublin.C22338873.RachealVisual;
import ie.tudublin.C22506249.LiutaurasVisual;
import ie.tudublin.D20123962.NikitaVisual;

public class Main extends PApplet {
    private PApplet[] sketches;

    public void settings() {
        size(800, 600, P3D);
    }

    public void setup() {
        String[] a = { "RachealVisual", "LiutaurasVisual", "NikitaVisual", "ZansVisual" };
        sketches = new PApplet[]{new RachealVisual(), new LiutaurasVisual(), new NikitaVisual(), new ZansVisual()};
        for (int i = 0; i < sketches.length; i++) {
            PApplet.runSketch(new String[]{a[i]}, sketches[i]);
        }
    }

    public void draw() {
        // Run the current sketch
        if (sketches[0] != null) {
            sketches[0].draw();
        }
    }

    public void keyPressed() {
        switch (key) {
            case '1':
                // Switch to the first sketch
                sketches[0] = new RachealVisual();
                break;
            case '2':
                // Switch to the second sketch
                sketches[0] = new LiutaurasVisual();
                break;
            case '3':
                // Switch to the third sketch
                sketches[0] = new NikitaVisual();
                break;
            case '4':
                // Switch to the fourth sketch
                sketches[0] = new ZansVisual();
                break;
        }
        // Re-run the current sketch
        if (sketches[0] != null) {
            PApplet.runSketch(new String[]{sketches[0].getClass().getSimpleName()}, sketches[0]);
        }
    }
}










