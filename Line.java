import java.awt.*;

public class Line {

    private Color color;
    private int length;

    public Line(Color color, int length) {
        this.color = color;
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    public Color getColor() {
        return this.color;
    }

}
