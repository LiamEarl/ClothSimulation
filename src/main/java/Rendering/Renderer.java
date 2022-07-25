package Rendering;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import processing.core.PApplet;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
public class Renderer extends PApplet {
    private float magnification;
    private int[] clothColor;
    private int[] backgroundColor;
    private PApplet pApplet;

    public void renderSimulation(float[][][] cloth) {
        this.pApplet.background(backgroundColor[0], backgroundColor[1], backgroundColor[2]);
        renderCloth(cloth);
    }

    private void renderCloth(float[][][] cloth) {

    }
}
