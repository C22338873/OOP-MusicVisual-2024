package ie.tudublin.C21371071;

import processing.core.PApplet;
import processing.core.PVector;
import ddf.minim.*;
import ddf.minim.analysis.*;

public class ZansVisual extends PApplet {
    Minim m;
    AudioPlayer player;
    FFT fft;

    Node[] nodes = new Node[1200];

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        m = new Minim(this);
        player = m.loadFile("data/Joji_-_SLOW_DANCING_IN_THE_DARK.mp3", 1024);
        fft = new FFT(player.bufferSize(), player.sampleRate());
        player.play();

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(random(width), random(height));
        }
    }

    public void draw() {
        noStroke();
        noCursor();
        background(0);
    
        fft.forward(player.mix);
    
        for (int i = 0; i < nodes.length; i++) {
            float freq = fft.getFreq((float) (dist(nodes[i].loc.x, nodes[i].loc.y, width / 2, height / 2) * 2.2));
    
            // Calculate the color based on the vertical position of the node
            float yPos = nodes[i].loc.y;
            float gradientFactor = yPos / height; // Normalized value between 0 and 1
            int gradientColor = lerpColor(color(255, 0, 0), color(255, 165, 0), gradientFactor); // Interpolate between red and orange
            strokeWeight(freq / 35);
            stroke(gradientColor);
    
            for (int j = i + 1; j < nodes.length; j++) {
                Node other = nodes[j];
                float d = nodes[i].loc.dist(other.loc);
                if (d > 0 && d < 45) {
                    line(nodes[i].loc.x, nodes[i].loc.y, other.loc.x, other.loc.y);
                }
            }
            stroke(255);
            nodes[i].run();
        }
    }
    

    class Node {
        PVector loc;
        PVector velocity = new PVector(random(-2, 2), random(-2, 2));
        float size = 10;

        Node(float x, float y) {
            this.loc = new PVector(x, y);
        }

        void run() {
            display();
            move();
            bounce();
        }

        void display() {
            point(loc.x, loc.y);
        }

        void move() {
            loc.add(velocity);
        }

        void bounce() {
            if ((loc.x > width) || (loc.x < 0)) {
                velocity.x *= -1;
            }
            if ((loc.y > height) || (loc.y < 0)) {
                velocity.y *= -1;
            }
        }
    }
}