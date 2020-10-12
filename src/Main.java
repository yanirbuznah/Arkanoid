

import animation.*;
import biuoop.GUI;
import game.Consts;
import game.GameFlow;
import game.HighScoreTable;
import levels.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Ass 6 game.
 * Arkanoid game,biu oop.
 */
public class Main {

    /**
     * Levels list.
     *
     * @param args the args from the user
     * @return the list of the level that the game should run.
     */
    private static List<LevelInformation> levels(String[] args) {
        LevelInformation[] levelInformations = {new Level1(), new Level2(), new Level3(), new Level4()};
        List<LevelInformation> levels = new ArrayList<>();
        for (String arg : args) {
            try {
                int userNumber = Integer.parseInt(arg);
                if (userNumber >= Consts.FIRST_LEVEL && userNumber <= Consts.NUMBER_OF_LEVELS) {
                    levels.add(levelInformations[userNumber - 1]);
                }
            } catch (Exception ignored) {
                ;
            }
        }
        if (levels.isEmpty()) {
            levels.addAll(Arrays.asList(levelInformations).subList(0, Consts.NUMBER_OF_LEVELS));
        }

        return levels;
    }

    /**
     * The entry point of application. initialize and run the game.
     *
     * @param args the input arguments from the user (not in use).
     */
    public static void main(String[] args) throws IOException {
        HighScoreTable table = new HighScoreTable(5);

        File highScores = new File("HighScores.txt");
        if (highScores.exists()) {
            table = table.loadFromFile(highScores);
        }
        else{
             table.save(highScores);
        }
        GUI gui = new GUI("OOP Game - Arkanoid", Consts.W_WIDTH, Consts.W_HEIGHT);
        MenuAnimation menu = new MenuAnimation("Main menu",
                gui.getKeyboardSensor(),new AnimationRunner(gui,Consts.FRAME_PER_SECOND));
        AnimationRunner animationRunner = new AnimationRunner(gui, Consts.FRAME_PER_SECOND);
        GameFlow gameFlow = new GameFlow(
                animationRunner, gui.getKeyboardSensor(), gui,table,highScores);
        menu.addSelection("s", "Start Game", new PlayTask(gameFlow,levels(args)));
        menu.addSelection("S", "Start Game", new PlayTask(gameFlow,levels(args)));
        menu.addSelection("ד", "Start Game", new PlayTask(gameFlow,levels(args)));

        menu.addSelection("h", "high scores",
                new HighScoreTask(animationRunner,gui,highScores));

        menu.addSelection("h", "high scores",
                new HighScoreTask(animationRunner,gui,highScores));

        menu.addSelection("h", "high scores",
                new HighScoreTask(animationRunner,gui,highScores));
        menu.addSelection("q", "quit", new QuitTask());
        menu.addSelection("q", "quit", new QuitTask());
        menu.addSelection("q", "quit", new QuitTask());
        while (true) {
            animationRunner.run(menu);
            Task<Void> task = menu.getStatus();
            task.run();
        }

    }

}

