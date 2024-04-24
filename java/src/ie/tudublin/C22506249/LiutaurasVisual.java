package ie.tudublin.C22506249;

import ddf.minim.Minim;
import ddf.minim.AudioPlayer;
import processing.core.PApplet;

public class LiutaurasVisual extends PApplet {
    Minim minim;
    AudioPlayer mySound;
    float n4;
    float n6;

    public void settings() {
        fullScreen(P3D);
    }

    public void setup() {
        minim = new Minim(this);
        mySound = minim.loadFile("data/Joji_-_SLOW_DANCING_IN_THE_DARK.mp3", 1024);
        mySound.play();
        noCursor();
        smooth();
        frameRate(24);
    }
    

    public void draw() {
        fill(0, 50);
        noStroke();
        rect(0, 0, width, height);
        translate(width / 2, height / 2);

        for (int i = 0; i < mySound.bufferSize() - 1; i++) {

            float angle = sin(i + n4) * 10;
            float angle2 = sin(i + n6) * 300;

            float x = sin(radians(i)) * (angle2 + 30);
            float y = cos(radians(i)) * (angle2 + 30);

            float x3 = sin(radians(i)) * (500 / angle);
            float y3 = cos(radians(i)) * (500 / angle);

            fill(255); // Blue
            ellipse(x, y, mySound.left.get(i) * 10, mySound.left.get(i) * 10);

            fill(0, 0, 255, 90); // White
            rect(x3, y3, mySound.left.get(i) * 20, mySound.left.get(i) * 10);

            fill(255); // Orange
            rect(x, y, mySound.right.get(i) * 10, mySound.left.get(i) * 10);

            fill(255, 165, 0, 90); // White
            rect(x3, y3, mySound.right.get(i) * 10, mySound.right.get(i) * 20);
        }

        n4 += 0.008;
        n6 += 0.04;
    }

    public static void main(String[] args) {
        PApplet.main("ie.tudublin.C22506249.LiutaurasVisual");
    }
}

