import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Frame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public ArrayList<Line> lineList;
    static int comparisons = 0;
    private JLabel welcome;

    public Frame() {

            welcome = new JLabel("Please select a sorting algorithm:");
            JPanel topPane = new JPanel();
            topPane.setLayout(new BorderLayout());
            topPane.add(welcome, BorderLayout.CENTER);


            lineList = new ArrayList<Line>();
            populateArrayRandom(lineList);
            this.getContentPane().add(new DrawingPane(lineList), BorderLayout.CENTER);
            this.setSize(1500, 1000);
            this.setBackground(Color.BLACK);
    }


    void merge(ArrayList<Line> lineList, int l, int m, int r)
    {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 =  r - m;

        /* create temp arrays */
        ArrayList<Line> R = new ArrayList<>();
        ArrayList<Line> L = new ArrayList<>();

        /* Copy data to temp arrays L[] and R[] */
        for (i = 0; i < n1; ++i)
            L.add(lineList.get(l + i));
        for (j = 0; j < n2; ++j)
            R.add(lineList.get(m + 1 + j));

        /* Merge the temp arrays back into arr[l..r]*/
        i = 0; // Initial index of first subarray
        j = 0; // Initial index of second subarray
        k = l; // Initial index of merged subarray
        while (i < n1 && j < n2)
        {
            if (L.get(i).getLength() <= R.get(j).getLength())
            {
                lineList.set(k, L.get(i));
                i++;
            }
            else
            {
                lineList.set(k, R.get(j));
                j++;
            }
            this.revalidate();
            this.repaint();
            k++;
        }

    /* Copy the remaining elements of L[], if there
       are any */
        while (i < n1)
        {
            lineList.set(k, L.get(i));
            this.revalidate();
            this.repaint();
            i++;
            k++;
        }

    /* Copy the remaining elements of R[], if there
       are any */
        while (j < n2)
        {
            lineList.set(k, R.get(j));
            this.revalidate();
            this.repaint();
            j++;
            k++;
        }
    }

    void selectionSort()
    {
        int n = lineList.size();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (lineList.get(j).getLength() < lineList.get(min_idx).getLength())
                    min_idx = j;
            // Swap the found minimum element with the first
            // element
            Frame.comparisons = Frame.comparisons + 1;
            Line temp = lineList.get(min_idx);
            lineList.set(min_idx, lineList.get(i));
            this.revalidate();
            this.repaint();

            lineList.set(i, temp);
            this.revalidate();
            this.repaint();
        }
    }


    void mergeSort(ArrayList<Line> lineList, int l, int r)
    {
        if (l < r)
        {
            // Same as (l+r)/2, but avoids overflow for
            // large l and h
            int m = (l+r)/2;

            // Sort first and second halves
            mergeSort(lineList, l, m);

            this.revalidate();
            this.repaint();

            mergeSort(lineList, m+1, r);

            this.revalidate();
            this.repaint();

            merge(lineList, l, m, r);

            this.revalidate();
            this.repaint();
        }
    }

    public void insertionSort() {
        int i, j;
        Line key;

        for (i = 1; i < lineList.size(); i++) {
            key = lineList.get(i);
            j = i - 1;

            while (j >= 0 && lineList.get(j).getLength() > key.getLength()) {
                lineList.set(j + 1, lineList.get(j));
                j = j - 1;
                this.revalidate();
                this.repaint();
            }

            lineList.set(j + 1, key);
            this.revalidate();
            this.repaint();
        }
    }



    public void populateArrayRandom(ArrayList<Line> lineList) {


        for (int x = 0; x < 750; x++) {

            int randomHeight = x;

            Color c;

            if (randomHeight >= 0 && randomHeight < 100) {
                c = Color.PINK;
            }
            else if (randomHeight >= 100 && randomHeight < 200) {
                c = Color.RED;
            }
            else if (randomHeight >= 200 && randomHeight < 300) {
                c = Color.ORANGE;
            }
            else if (randomHeight >= 300 && randomHeight < 400) {
                c = Color.YELLOW;
            }
            else if (randomHeight >= 400 && randomHeight < 500) {
                c = Color.GREEN;
            }
            else if (randomHeight >= 500 && randomHeight < 600) {
                c = Color.CYAN;
            }
            else if (randomHeight >= 600 && randomHeight < 700) {
                c = Color.BLUE;
            }
            else {
                c = Color.MAGENTA;
            }


            Line newLine = new Line(c, randomHeight);

            lineList.add(newLine);

        }

        this.shuffleArray(lineList);

    }

    public ArrayList<Line> getLineList() {
        return lineList;
    }

    int partition(ArrayList<Line> lineList, int low, int high)
    {
        int pivot = lineList.get(high).getLength();
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (lineList.get(j).getLength() < pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                Line temp = lineList.get(i);
                lineList.set(i, lineList.get(j));

                this.revalidate();
                this.repaint();

                lineList.set(j, temp);

                this.revalidate();
                this.repaint();
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        Line temp = lineList.get(i+1);
        lineList.set(i+1, lineList.get(high));

        this.revalidate();
        this.repaint();

        lineList.set(high, temp);

        this.revalidate();
        this.repaint();

        return i+1;
    }

    public void shuffleArray(ArrayList<Line> lineList) {

        for (int x = lineList.size() - 1; x > 0; x--) {
            int random = (int)Math.floor((int)(Math.random() * (x+1)));
            Line temp = lineList.get(x);
            lineList.set(x, lineList.get(random));
            lineList.set(random, temp);

            this.revalidate();
            this.repaint();
        }
    }

    void quickSort(ArrayList<Line> lineList, int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(lineList, low, high);

            this.revalidate();
            this.repaint();

            // Recursively sort elements before
            // partition and after partition
           quickSort(lineList, low, pi-1);

            this.revalidate();
            this.repaint();

           quickSort(lineList, pi+1, high);

            this.revalidate();
            this.repaint();
        }
    }




    public static void main(String [] args) {

        Frame f = new Frame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setPreferredSize(new Dimension(1920, 1080));
        f.setVisible(true);

        //f.mergeSort(f.getLineList(), 0, f.getLineList().size() - 1);
        //f.insertionSort();
        //f.selectionSort();
        //f.quickSort(f.getLineList(), 0, f.getLineList().size() - 1);

    }

}
