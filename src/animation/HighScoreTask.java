package animation;

import biuoop.GUI;
import game.HighScoreTable;

import java.io.File;

public class HighScoreTask  implements Task<Void>{
private AnimationRunner animationRunner;
private GUI gui;
private File highScoresFile;
public HighScoreTask(AnimationRunner ar, GUI gui, File highScores){
    this.animationRunner = ar;
    this.gui = gui;
    this.highScoresFile = highScores;
}

    @Override
    public Void run() {
        HighScoreTable table = HighScoreTable.loadFromFile(highScoresFile);
        animationRunner.run(new KeyPressStoppableAnimation(gui.getKeyboardSensor(), "space",
                new HighScoresAnimation(table)));
    return null;
    }
}
