import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonView extends JPanel {

    private JButton quickSort;
    private JButton mergeSort;
    private JButton insertionSort;
    private JButton selectionSort;
    private JLabel welcome;
    private ArrayList<Line> lineList;

    public ButtonView(ArrayList<Line> lineList) {

        welcome = new JLabel("Please select a sorting algorithm:");
        quickSort = new JButton("Quick Sort");
        mergeSort = new JButton("Merge Sort");
        insertionSort = new JButton("Insertion Sort");
        selectionSort = new JButton("Selection Sort");

        this.setLayout(new BorderLayout());
        JPanel topPane = new JPanel();
        topPane.setLayout(new BorderLayout());
        topPane.add(welcome, BorderLayout.CENTER);

        JPanel bottomPane = new JPanel();
        bottomPane.setLayout(new GridLayout(2, 2));
        bottomPane.add(quickSort);
        bottomPane.add(mergeSort);
        bottomPane.add(insertionSort);
        bottomPane.add(selectionSort);

        quickSort.addActionListener(new ButtonListener());

        this.add(topPane, BorderLayout.PAGE_START);
        this.add(bottomPane, BorderLayout.CENTER);

        this.lineList = lineList;


    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JButton buttonClicked = (JButton)e.getSource();

            if (buttonClicked.getText().equals("Quick Sort")) {

            }
        }
    }


}
