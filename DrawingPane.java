import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawingPane extends JPanel {

    public ArrayList<Line> lineList;

    public DrawingPane(ArrayList<Line> lineList) {

        this.lineList = lineList;
        this.setSize(1920, 1500);
        this.setBackground(Color.BLACK);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        int xValue = 0;
        int yValue = 0;


        for (int x = 0; x < lineList.size(); x++) {

            Color c = lineList.get(x).getColor();
            int length = lineList.get(x).getLength();

            //make the assumption that all lines start at x = 0, y = 0 and stay two pixels apart (depending on length will depend on y value)

            System.out.println();
            g.setColor(c);
            g.drawLine(xValue, yValue, xValue, yValue + length);

            xValue = xValue + 2;

        }
    }


    }

