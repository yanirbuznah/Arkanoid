package animation;

import biuoop.DrawSurface;
import game.Consts;
import game.HighScoreTable;
import game.ScoreInfo;

import java.awt.*;


public class HighScoresAnimation implements Animation {
    private KeyPressStoppableAnimation keyPress;
    private HighScoreTable scoresTable;

    public HighScoresAnimation(HighScoreTable scores) {

        this.scoresTable = scores;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(new Color(130, 130, 130));
        d.fillRectangle(0, 0, Consts.W_WIDTH, Consts.W_HEIGHT);
        d.setColor(Color.orange);
        d.fillRectangle(100,110,500,5);
        d.setColor(Color.BLACK);
        d.drawText(100, 100, "Player", Consts.PAUSE_FONT_SIZE);
        d.drawText(400, 100, "Score", Consts.PAUSE_FONT_SIZE);
        d.drawLine(100, 110, 600, 110);
        d.drawLine(100, 115, 600, 115);

        for (int i = 0; i < scoresTable.getHighScores().size(); i++) {
            ScoreInfo scoreInfo = scoresTable.getHighScores().get(i);
            d.drawText(60, 100 + 50 * (i + 1), ""+(i+1), Consts.PAUSE_FONT_SIZE);
            d.drawText(100, 100 + 50 * (i + 1), scoreInfo.getName(), Consts.PAUSE_FONT_SIZE);
            d.drawText(400, 100 + 50 * (i + 1), "" + scoreInfo.getScore(), Consts.PAUSE_FONT_SIZE);
        }
    }

    @Override
    public boolean shouldStop() {
        return false;
    }

}