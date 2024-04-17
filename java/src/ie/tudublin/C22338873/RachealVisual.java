package ie.tudublin.C22338873;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class RachealVisual extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int mode = 0;

    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    public void keyPressed() {
        if (key >= '0' && key <= '9') {
            mode = key - '0';
        }
        if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
    }

    public void settings()
    {
        size(800, 800, P3D);

    }

    public void setup()
    {
        minim = new Minim(this);
        // Uncomment this to use the microphone
        // ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        // ab = ai.mix; 
        ap = minim.loadFile("data/Joji_-_SLOW_DANCING_IN_THE_DARK.mp3", 1024);
        ap.play();
        ab = ap.mix;
        colorMode(HSB);

        y = height / 2;
        smoothedY = y;

        lerpedBuffer = new float[ab.size()];
    }

    float off = 0;

    public void draw() {
        background(0);
        stroke(255);
    
        // Calculate the average amplitude
        float total = 0;
        for (int i = 0; i < ab.size(); i++) {
            total += abs(ab.get(i));
        }
        float average = total / ab.size();
    
        // Use the average amplitude to determine the number of circles
        int numberOfCircles = (int) map(average, 0, 1, 10, 100);
    
        // Draw the waves
        drawWaves(width / 2, height / 2, numberOfCircles);
    }
    
    // Method to draw the waves in 3D
    private void drawWaves(float centerX, float centerY, int numberOfCircles) {
        float maxDiameter = min(width, height) * 0.8f;
        float angleOffset = 0;
        for (int i = 0; i < numberOfCircles; i++) {
            float diameter = map(i, numberOfCircles, 0, 0, maxDiameter); // Map the circle index from numberOfCircles to 0
            stroke(map(i, 0, numberOfCircles, 0, 255), 255, 255);
            strokeWeight(map(i, 0, numberOfCircles, 1, 5));
            noFill(); // Make the inside of the circles transparent
            pushMatrix();
            // Adjust the y-coordinate based on a sine wave that changes over time
            float y = centerY + sin(angleOffset + frameCount * 0.01f) * 200; // Increase the multiplier to 200
            translate(centerX, y, map(i, 0, numberOfCircles, -100, 100)); // Decrease the range of the z-coordinate to -100 to 100
            rotateX(radians(85)); // Rotate the view by 85 degrees
            ellipse(0, 0, diameter, diameter);
            popMatrix();
            angleOffset += 0.1; // Adjust this to get different wave effects
        }
    }
}



    



