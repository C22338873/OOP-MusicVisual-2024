
package ie.tudublin.C22338873;

public class Waveform3D extends PApplet {
    int cols, rows;
    int scale = 20;
    float[][] terrain;

    public void settings() {
        size(800, 800, P3D);
    }

    public void setup() {
        cols = width / scale;
        rows = height / scale;
        terrain = new float[cols][rows];
    }

    public void draw() {
        background(0);
        stroke(255);
        noFill();

        translate(width/2, height/2);
        rotateX(PI/3);

        for (int r = 0; r < rows-1; r++) {
            beginShape(TRIANGLE_STRIP);
            for (int theta = 0; theta < cols; theta++) {
                float x = r * cos(theta);
                float y = r * sin(theta);
                vertex(x*scale, y*scale, terrain[theta][r]);
                vertex(x*scale, (y+1)*scale, terrain[theta][r+1]);
            }
            endShape();
        }

        // Update terrain
        for (int r = 0; r < rows; r++) {
            for (int theta = 0; theta < cols; theta++) {
                terrain[theta][r] = map(noise(theta*0.1f, r*0.1f), 0, 1, -100, 100);
            }
        }
    }
}
