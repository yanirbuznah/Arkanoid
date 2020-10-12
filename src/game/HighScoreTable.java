package game;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HighScoreTable {
    private int size;
    private List<ScoreInfo> highScores;

    // Create an empty high-scores table with the specified size.
    // The size means that the table holds up to size top scores.
    public HighScoreTable(int size) {
        this.size = size;
        this.highScores = new ArrayList<ScoreInfo>(size);
    }

    // Read a table from file and return it.
    // If the file does not exist, or there is  a problem with
    // reading it, an empty table is returned.
    public static HighScoreTable loadFromFile(File filename) {
        HighScoreTable table = new HighScoreTable(0);
        try {
            table.load(filename);
            return table;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Add a high-score.
    public void add(ScoreInfo score) {
        int rank = getRank(score.getScore()) -1;
        if (rank <= this.size) {
            this.highScores.add(rank, score);
        }
        if (this.highScores.size() > this.size) {
            this.highScores.remove(size );
        }
    }

    // Return table size.
    public int size() {
        return size;
    }

    // Return the current high scores.
    // The list is sorted such that the highest
    // scores come first.
    public List<ScoreInfo> getHighScores() {
        return highScores;
    }

    // return the rank of the current score: where will it
    // be on the list if added?
    // Rank 1 means the score will be highest on the list.
    // Rank `size` means the score will be lowest.
    // Rank > `size` means the score is too low and will not
    //      be added to the list.
    public int getRank(int score) {
        for (int i = 0; i < this.size; i++) {
            if (i < this.highScores.size()) {
                ScoreInfo si = this.getHighScores().get(i);
                if (si.getScore() < score) {
                    return i + 1;
                }
            } else {
                return i + 1;
            }
        }
        return this.highScores.size() + 1;
    }

    // Clears the table
    public void clear() {
        this.highScores = new ArrayList<ScoreInfo>(size);
    }

    // Load table data from file.
    // Current table data is cleared.
    public void load(File filename) throws IOException {
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(filename));
        this.size = Integer.parseInt(reader.readLine());
        String scoresCSV = reader.readLine();
        if (scoresCSV != null && !scoresCSV.isEmpty()) {
            String[] scores = scoresCSV.split(";");
            for (String scoreInfoAsString : scores) {
                if (scoreInfoAsString != null
                        && !scoreInfoAsString.isEmpty()) {
                    String[] info = scoreInfoAsString.split(",");
                    this.highScores.add(new ScoreInfo(info[0],
                            Integer.parseInt(info[1])));
                }
            }
        }
        reader.close();

    }

    // Save table data to the specified file.
    public void save(File filename) throws IOException {
        StringBuilder scoresCSV = new StringBuilder();
        for (ScoreInfo score : this.highScores) {
            scoresCSV.append(score.getName())
                    .append(",")
                    .append(score.getScore())
                    .append(";");
        }

        OutputStreamWriter writer = null;
        try {
            writer = new OutputStreamWriter(new FileOutputStream(filename));
            writer.write(String.valueOf(this.size));
            writer.write("\n");
            writer.write(scoresCSV.toString());
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }

        writer.close();
    }

}