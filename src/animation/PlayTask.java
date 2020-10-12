package animation;

import game.GameFlow;
import levels.LevelInformation;

import java.util.List;

public class PlayTask implements Task<Void> {
    private GameFlow gameFlow;
    private List<LevelInformation> levels;

    public PlayTask(GameFlow gameFlow, List<LevelInformation> levelInformations) {
        this.gameFlow = gameFlow;
        this.levels = levelInformations;
    }

    @Override
    public Void run() {
        gameFlow.runLevels(levels);
        return null;
    }
}
