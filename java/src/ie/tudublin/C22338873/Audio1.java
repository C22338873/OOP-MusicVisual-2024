package ie.tudublin.C22338873;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
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

    public void draw(){

    float halfH = height / 2;
    float average = 0;
    float sum = 0;
    off += 1;
    
    // Calculate sum and average of the samples
    // Also lerp each element of buffer;
    for(int i = 0 ; i < ab.size() ; i ++)
    {
        sum += abs(ab.get(i));
        lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.05f);
    }
    average = sum / (float) ab.size();
    smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);
    
    switch (mode) {
        case 0:
            background(0);
            drawWaves(width / 2, height / 2, 200); // Call drawWaves method
            break;
    }
}

    // Method to draw the waves
    private void drawWaves(float centerX, float centerY, int numberOfCircles) {
        float maxDiameter = min(width, height) * 0.8f;
        float angleOffset = 0;
        for (int i = 0; i < numberOfCircles; i++) {
            float diameter = map(i, 0, numberOfCircles, 0, maxDiameter);
            stroke(map(i, 0, numberOfCircles, 0, 255), 255, 255);
            strokeWeight(map(i, 0, numberOfCircles, 1, 5));
            beginShape();
            for (float angle = 0; angle < TWO_PI; angle += radians(1)) {
                float xOff = cos(angle + angleOffset) * diameter / 2;
                float yOff = sin(angle + angleOffset) * diameter / 2;
                vertex(centerX + xOff, centerY + yOff);
            }
            endShape(CLOSE);
            angleOffset += 0.1; // Adjust this to get different wave effects
        }
    }

}


    



