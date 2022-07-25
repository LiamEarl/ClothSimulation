package main;

import Rendering.Renderer;
import processing.core.PApplet;

import java.util.HashMap;
import java.util.Map;

public class Simulation extends PApplet {

    private static final int SCREEN_WIDTH = 1000;                         // WIDTH OF SIMULATION WINDOW
    private static final int SCREEN_HEIGHT = (int) (SCREEN_WIDTH * 0.75); // 4:3 ASPECT RATIO

    private static final int CLOTH_WIDTH = 5;  // NUMBER OF CLOTH GRID SPACES HORIZONTALLY
    private static final int CLOTH_HEIGHT = 5; // NUMBER OF CLOTH GRID SPACES VERTICALLY

    private static final int CLOTH_SEGMENT_DIST = 40; // HOW FAR APART CLOTH SEGMENTS ARE CREATED

    Renderer renderer; // OBJECT THAT HANDLES GRAPHICS

    Map<String, int[]> colors; // HASHMAP CONTAINING COLORS (RBG)

    float[][][] cloth; // THREE DIMENSIONAL ARRAY CONTAINING THE POSITIONS OF EACH CLOTH SEGMENT

    public static void main(String... args) {
        PApplet.main(Simulation.class);
    }

    @Override
    public void settings() {
        size(SCREEN_WIDTH, SCREEN_HEIGHT);



        colors = new HashMap<String, int[]>(); // HASHMAP CONTAINING COLORS (RBG)
        colors.put("RED", new int[] {255, 0, 0});
        colors.put("GREEN", new int[] {0, 255, 0});
        colors.put("BLUE", new int[] {0, 0, 255});
        colors.put("YELLOW", new int[] {255, 255, 0});
        colors.put("WHITE", new int[] {255, 255, 255});
        colors.put("BLACK", new int[] {0, 0, 0});
        colors.put("PINK", new int[] {255, 192, 203});

        Renderer.RendererBuilder built = Renderer.builder() // UTILIZING LOMBOK OBJECT BUILDER
        .magnification(1f)                                  // ASSIGNING MAGNIFICATION
        .clothColor(colors.get("PINK"))                     // ASSIGNING COLOR OF CLOTH
        .backgroundColor(colors.get("WHITE"))               // ASSIGNING BACKGROUND COLOR
        .pApplet(this);                                     // ASSIGNING CORRECT INSTANCE OF "PApplet"
        renderer = built.build();                           // ASSIGNING THE NEW OBJECT TO "renderer"

        cloth = new float[CLOTH_HEIGHT][CLOTH_WIDTH][2];
        for(int i = 0; i < CLOTH_HEIGHT; i++) {
            for(int j = 0; j < CLOTH_WIDTH; j++) {
                cloth[i][j] = new float[] {(SCREEN_WIDTH / 2f) - ((CLOTH_WIDTH * CLOTH_SEGMENT_DIST) / 2f), SCREEN_HEIGHT / 4f};
            }
        }



    }

    private void simulateCloth() {



    }



    @Override
    public void draw() {
        renderer.renderSimulation(cloth); // DISPLAYING THE SIMULATION ON THE WINDOW

    }
}
