package ie.tudublin.D20123962;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import java.util.ArrayList;

public class NikitaVisual extends PApplet {
    Minim minim;
    AudioPlayer ap;
    AudioBuffer ab;

    float[] lerpedBuffer;
    ArrayList<MatrixCode> matrixCodes; // List for Matrix code elements

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        minim = new Minim(this);
        ap = minim.loadFile("data/Joji_-_SLOW_DANCING_IN_THE_DARK.mp3", 1024);
        ap.play();
        ab = ap.mix;
        colorMode(HSB);

        lerpedBuffer = new float[ab.size()];
        matrixCodes = new ArrayList<MatrixCode>();
        for (int i = 0; i < width / 20; i++) {
            matrixCodes.add(new MatrixCode(i * 20));
        }
    }

    public void keyPressed() {
        if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
    }

    public void draw() {
        background(0); // Clear the background to black

        // Display and update Matrix code elements
        for (MatrixCode code : matrixCodes) {
            code.display();
            code.update();
        }

        // Translate to the center of the screen
        translate(width / 2, height / 2);

        // Drawing mirrored waveform
        for (int i = 0; i < ab.size() - 1; i++) {
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
            float y1 = map(lerpedBuffer[i], 0, 1, 0, height / 2);
            float y2 = map(lerpedBuffer[i + 1], 0, 1, 0, height / 2);
            stroke(map(i, 0, ab.size(), 0, 255), 255, 255);
            line(i - width / 2, y1, (i + 1) - width / 2, y2);
            line(i - width / 2, -y1, (i + 1) - width / 2, -y2);
        }
    }

    class MatrixCode {
        ArrayList<Character> chars;
        float x;
        float y;
        float speed;
        int length;

        MatrixCode(float x) {
            this.x = x;
            chars = new ArrayList<Character>();
            y = random(-1000, 0);
            speed = random(2, 5);
            length = (int) random(10, 30);
            for (int i = 0; i < length; i++) {
                chars.add((char) (random(48, 128)));
            }
        }

        void update() {
            y += speed;
            if (y - length * 20 > height) {
                y = random(-500, 0);
                length = (int) random(10, 30);
                chars.clear();
                for (int i = 0; i < length; i++) {
                    chars.add((char) (random(48, 128)));
                }
            }
        }

        void display() {
            for (int i = chars.size() - 1; i >= 0; i--) {
                float alpha = map(i, 0, chars.size(), 50, 255);
                fill(random(0, 255), 255, 255, alpha);
                textSize(20);
                text(chars.get(i), x, y - i * 20);
            }
        }
    }
}
