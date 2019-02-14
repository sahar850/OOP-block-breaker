import java.io.Serializable;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sahar on 02/06/2016.
 */
class HighScoresTable implements Serializable {
    private int size;
    private List<ScoreInfo> highScoresList;

    /**
     * @param size the table size
     */
    // Create an empty high-scores table with the specified size.
    // The size means that the table holds up to size top scores.
    public HighScoresTable(int size) {
        this.size = size;
        this.highScoresList = new ArrayList<>(this.size);
    }
    /**
     * @param score the current score info
     */
    // Add a high-score.
    public void add(ScoreInfo score) {
        if (getRank(score.getScore()) > this.size) {
            return;
        }
        this.highScoresList.add(getRank(score.getScore()) - 1, score);
        while (this.highScoresList.size() > this.size) {
            this.highScoresList.remove(this.highScoresList.size() - 1);
        }
    }

    /**
     * @return table size.
     */
    public int size() {
        return this.size;
    }

    /**
     * @return the current high scores.
     */
    // Return the current high scores.
    // The list is sorted such that the highest
    // scores come first.
    public List<ScoreInfo> getHighScores() {
        return this.highScoresList;
    }

    /**
     * @param score the current score
     * @return the rank of the current score: where will it
     */
    // return the rank of the current score: where will it
    // be on the list if added?
    // Rank 1 means the score will be highest on the list.
    // Rank `size` means the score will be lowest.
    // Rank > `size` means the score is too low and will not
    //      be added to the list.
    public int getRank(int score) {
        int i;
        for (i = 0; i < this.highScoresList.size(); i++) {
            if (score > this.highScoresList.get(i).getScore()) {
                break;
            }
        }
        return i + 1;
    }

    /**
     *
     */
    // Clears the table
    public void clear() {
        this.highScoresList.clear();

    }

    /**
     * @param filename the table file name
     * @throws IOException if cant read or find the file
     */
    // Load table data from file.
    // Current table data is cleared.
    public void load(File filename) throws IOException {
        HighScoresTable tmp;
        FileInputStream file = new FileInputStream(filename.getName());
        ObjectInputStream inFile = null;
        try {
            inFile = new ObjectInputStream(file);
            tmp = (HighScoresTable) inFile.readObject();
            this.highScoresList = tmp.highScoresList;
            this.size = tmp.size;
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file: " + filename.getName());
            HighScoresTable emptyTable = new HighScoresTable(5);
            emptyTable.save(filename);
            this.highScoresList = emptyTable.highScoresList;
            this.size = emptyTable.size;
        } catch (ClassNotFoundException c) {
            System.out.println("Class Not Found Exception");
        } finally {
            try {
                if (inFile != null) {
                    inFile.close();
                }
            } catch (IOException e) {
                System.out.println("Failed closing the file!");
            }
        }

    }

    /**
     * @param filename the table file name
     * @throws IOException if cant read or find the file
     */
    // Save table data to the specified file.
    public void save(File filename) throws IOException {
        FileOutputStream file = new FileOutputStream(filename);
        ObjectOutputStream outFile = null;
        try {
            outFile = new ObjectOutputStream(file);
            outFile.writeObject(this);
        } catch (IOException e) {
            System.out.printf("something went wrong while wrighting");
            throw e;
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException e) {
                System.out.println("Failed closing the file!");
            }
        }
    }

    /**
     * @param filename the table file name
     * @return the table from the file or an empty one
     */
    // Read a table from file and return it.
    // If the file does not exist, or there is a problem with
    // reading it, an empty table is returned.
    public static HighScoresTable loadFromFile(File filename) {
        HighScoresTable tmpTable = new HighScoresTable(5);
        if (!filename.exists()) {
            return new HighScoresTable(5);
        }
        try {
            tmpTable.load(filename);
        } catch (IOException e) {
            return new HighScoresTable(5);
        }
        return tmpTable;
    }

}