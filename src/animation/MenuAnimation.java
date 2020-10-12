package animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuAnimation implements Menu<Task<Void>> {
    private String title;
    private KeyboardSensor key;
    private AnimationRunner runner;
    private HashMap<String, Task<Void>> menu = new HashMap<String, Task<Void>>();
    private List<String> massages = new ArrayList<>();
    private List<String> keys = new ArrayList<>();
    public MenuAnimation(String title, KeyboardSensor key, AnimationRunner runner) {
        this.key = key;
        this.title = title;
        this.runner = runner;

    }

    @Override
    public void addSelection(String key, String message, Task<Void> returnVal) {
        keys.add(key);
        menu.put(key,returnVal);
        massages.add(message);
    }


    @Override
    public Task<Void> getStatus() {
        for (String currentKey : keys) {
            if (this.key.isPressed(currentKey)) {
                if (menu.containsKey(currentKey)) {
                    return menu.get(currentKey);
                }
            }
        }
        return null;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        try {
                Image backgroundImage = ImageIO.read(new File("images\\nuEV97.jpg"));
                d.drawImage(0, 0, backgroundImage);

        } catch (IOException ioException) {
            ;
        }
        d.setColor(new Color(0xEFE6E0));
        d.drawText(20, 40, title, 30);
        d.drawText(20, 85, "Please press one of the Following keys:", 20);

        d.setColor(new Color(0xEFE7B0));
        for (int i = 0; i < keys.size(); i= i+3) {
            d.drawText(20, (i/3 * 50) + 130, '(' + keys.get(i) + ')', 25);
            d.drawText(60, (i/3 * 50) + 130, massages.get(i), 25);
        }
    }

    @Override
    public boolean shouldStop() {
        for (String string : keys) {
            if (this.key.isPressed(string)) {
                return true;
            }
        }
        return false;
    }
}
