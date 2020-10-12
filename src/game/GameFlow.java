package game;

import animation.*;
import biuoop.DialogManager;
import biuoop.KeyboardSensor;
import biuoop.GUI;
import levels.LevelInformation;


import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * The type Game flow.
 * the class who in charge of the flow of the game.
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private GUI gui;
    private Counter score = new Counter();
    private Counter lives = new Counter();
    private boolean win = true;
    private HighScoreTable table;
    private File highScores;

    /**
     * Instantiates a new Game flow.
     *
     * @param ar  the animation.AnimationRunner
     * @param ks  the ks the KeyboardSensor
     * @param gui the GUI window.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui, HighScoreTable table, File highScores) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.gui = gui;
        this.table = table;
        this.highScores = highScores;
    }

    /**
     * Run levels.
     *
     * @param levels the list of the levels that method should run one after one.
     */
    public void runLevels(List<LevelInformation> levels) {
        lives.increase(Consts.LIVES);
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(gui, levelInfo, keyboardSensor, animationRunner, score, lives);
            level.initialize();
            while (level.getLives().getValue() != 0 && level.getRemainingBlocks().getValue() != 0) {
                level.playOneTurn();
            }

            if (level.getLives().getValue() == 0) {
                win = false;
                break;
            }
        }
        this.animationRunner.run(
                new KeyPressStoppableAnimation(this.keyboardSensor, "space", new EndScreen(win, score)));
        if (table.getRank(score.getValue()) < table.size()) {
            DialogManager dialog = gui.getDialogManager();
            String name = dialog.showQuestionDialog("Name", "What is your name?", "");
            table.add(new ScoreInfo(name, score.getValue()));
            try {
                table.save(this.highScores);
            }catch (IOException exception){
                System.out.println(exception);
            }

        }
        this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, "space", new HighScoresAnimation(table)));
    }

}
