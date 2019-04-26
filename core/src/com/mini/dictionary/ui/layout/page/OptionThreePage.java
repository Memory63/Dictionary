package com.mini.dictionary.ui.layout.page;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mini.dictionary.WordJson;
import com.mini.dictionary.ui.layout.page.dao.OptionPageDao;
import com.mini.dictionary.util.LoadFile;

public class OptionThreePage implements OptionPageDao {
    private Stage stage;
    private Label label;
    private WordJson wordJson;

    public OptionThreePage(Stage stage) {
        this.stage = stage;
        init();
    }

    private int length;
    private int y;

    @Override
    public void init() {
        wordJson = new WordJson();
        length = Integer.parseInt(wordJson.init("",3,0)) - 8;

        y = -18 * 2 * (length+1);

        label = new Label(showWords(), new Label.LabelStyle(LoadFile.getFont18(), null));
        label.setPosition(180,y);
    }

    public String showWords() {
        String string = new String();
        for (int i = 0; i < length; i++) {
            string += wordJson.init("",4, i) + "\n\n";
        }

        return string;
    }

    @Override
    public void addToStage() {
        stage.addActor(label);
    }

    private int index = 0;
    private boolean flage = true;

    @Override
    public void showMessage() {
        scrollBar();
    }

    public void scrollBar() {
        if (Gdx.input.isTouched()) {
            if (flage) {
                index = Gdx.input.getY();
                flage = false;
            }
            y += index - Gdx.input.getY();
            if (y < (-18 * 2 * (length +1) )) {
                y = (-18 * 2 * (length + 1));
            }else if (y > (-18 * 2 * (length + 1)) + (18 * 2 * (length + 1))){
                y = (-18 * 2 * (length + 1)) + (18 * 2 * (length + 1));
            }
            label.setPosition(180, y);
            index = Gdx.input.getY();
        }else{
            flage = true;
        }
    }
}
