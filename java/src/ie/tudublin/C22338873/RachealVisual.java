package ie.tudublin.C22338873;

import processing.core.PApplet;
import ddf.minim.*;
import ddf.minim.analysis.*;

public class RachealVisual extends PApplet {
    Minim minim;
    AudioPlayer song;
    FFT fft;

    float specLow = 0.03f; // 3%
    float specMid = 0.125f; // 12.5%
    float specHi = 0.20f; // 20%
    float scoreLow = 0;
    float scoreMid = 0;
    float scoreHi = 0;
    float oldScoreLow = scoreLow;
    float oldScoreMid = scoreMid;
    float oldScoreHi = scoreHi;
    float scoreDecreaseRate = 25;
    int nbCircles;
    Circle[] circles;

    public void settings() {
        size(800, 800, P3D);
    }

    public void setup() {
        minim = new Minim(this);
        song = minim.loadFile("data/Joji_-_SLOW_DANCING_IN_THE_DARK.mp3");
        fft = new FFT(song.bufferSize(), song.sampleRate());
        nbCircles = (int) (fft.specSize() * specHi);
        circles = new Circle[nbCircles];

        for (int i = 0; i < nbCircles; i++) {
            circles[i] = new Circle();
        }

        background(0);
        song.play(0);
    }

    public void draw() {
        fft.forward(song.mix);
        oldScoreLow = scoreLow;
        oldScoreMid = scoreMid;
        oldScoreHi = scoreHi;
        scoreLow = 0;
        scoreMid = 0;
        scoreHi = 0;

        for (int i = 0; i < fft.specSize() * specLow; i++) {
            scoreLow += fft.getBand(i);
        }

        for (int i = (int) (fft.specSize() * specLow); i < fft.specSize() * specMid; i++) {
            scoreMid += fft.getBand(i);
        }

        for (int i = (int) (fft.specSize() * specMid); i < fft.specSize() * specHi; i++) {
            scoreHi += fft.getBand(i);
        }

        if (oldScoreLow > scoreLow) {
            scoreLow = oldScoreLow - scoreDecreaseRate;
        }

        if (oldScoreMid > scoreMid) {
            scoreMid = oldScoreMid - scoreDecreaseRate;
        }

        if (oldScoreHi > scoreHi) {
            scoreHi = oldScoreHi - scoreDecreaseRate;
        }

        float scoreGlobal = 0.66f * scoreLow + 0.8f * scoreMid + 1f * scoreHi;
        background(scoreLow / 100, scoreMid / 100, scoreHi / 100);

        for (int i = 0; i < nbCircles; i++) {
            float bandValue = fft.getBand(i);
            circles[i].display(scoreLow, scoreMid, scoreHi, bandValue, scoreGlobal);
        }
    }

    class Circle {
        float startingZ = -10000;
        float maxZ = 1000;
        float x, y, z;
        float sumRotX, sumRotY, sumRotZ;

        Circle() {
            x = random(width);
            y = random(height);
            z = random(startingZ, maxZ);
        }

        void display(float scoreLow, float scoreMid, float scoreHi, float intensity, float scoreGlobal) {
            int displayColor = color(scoreLow * 0.67f, scoreMid * 0.67f, scoreHi * 0.67f, intensity * 5);
            fill(displayColor, 255);
            int strokeColor = color(255, 150 - (20 * intensity)); // Declare the strokeColor variable
            stroke(strokeColor);
            strokeWeight(1 + (scoreGlobal / 300));
            pushMatrix();
            translate(x, y, z);
            sumRotX += intensity * (random(0.01f, 0.1f) / 1000);
            sumRotY += intensity * (random(0.01f, 0.1f) / 1000);
            sumRotZ += intensity * (random(0.01f, 0.1f) / 1000);
            rotateX(sumRotX);
            rotateY(sumRotY);
            rotateZ(sumRotZ);
            ellipse(0, 0, 100 + (intensity / 2), 100 + (intensity / 2));
            popMatrix();
            z += (1 + (intensity / 5) + (pow((scoreGlobal / 150), 2)));
            if (z >= maxZ) {
                x = random(width);
                y = random(height);
                z = startingZ;
            }
        }
    }

    
}



