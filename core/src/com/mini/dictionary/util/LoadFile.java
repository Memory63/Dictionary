package com.mini.dictionary.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Disposable;

/**
 * Author Zzzxb
 * Date: Create in 2018/12/24 16:03
 * Description:
 */
public class LoadFile implements Disposable {
    private static BitmapFont font18;
    private static BitmapFont font28;
    private static BitmapFont dateFont;
    private static Texture dailySentenceTexture;
    private static Texture searchBoxTexture;
    private static Texture wordCardTexture;
    private static Texture progress;
    private static Texture progress1;
    private static Texture progress2;
    private static Texture menuTexture;
    private static Texture hintTexture;
    private static TextField searchBox;
    private static TextField numBox;
    private static int count; // 每日背单词数

    static{
        font18 = new BitmapFont(Gdx.files.internal("font/font18.fnt"),
                Gdx.files.internal("font/font18.png"),false);
        font28 = new BitmapFont(Gdx.files.internal("font/myfont.fnt"),
                Gdx.files.internal("font/myfont.png"),false);
        dateFont = new BitmapFont(Gdx.files.internal("font/dateFont.fnt")
                ,Gdx.files.internal("font/dateFont.png"),false);
        dailySentenceTexture = new Texture(Gdx.files.internal("icon/boundary.png"));
        searchBoxTexture = new Texture(Gdx.files.internal("icon/search.png"));
        wordCardTexture = new Texture(Gdx.files.internal("icon/wordcard.png"));
        progress = new Texture(Gdx.files.internal("icon/progress.png"));
        progress1 = new Texture(Gdx.files.internal("icon/progress1.png"));
        progress2 = new Texture(Gdx.files.internal("icon/progress2.png"));
        menuTexture = new Texture(Gdx.files.internal("icon/menu_background.png"));
        hintTexture = new Texture(Gdx.files.internal("icon/hint.png"));
        searchBox();
        setNumBox();
    }
    public static BitmapFont getFont28() { return font28;}
    public static BitmapFont getFont18() {
        return font18;
    }
    public static BitmapFont getDateFont() {return dateFont;}
    public static Texture getDailySentenceTexture() { return dailySentenceTexture; }
    public static Texture getSearchBoxTexture() { return searchBoxTexture;}
    public static Texture getWordCardTexture() {return wordCardTexture;}
    public static Texture getProgress(int n) {
        if (n == 0)
            return progress;
        else if (n == 1)
            return progress1;
        else if (n == 2)
            return progress2;
        return progress;
    }
    public static Texture getMenuTexture() {return menuTexture;}
    public static Texture getHintTexture() {return hintTexture;}
    /** 光标*/
    private static Texture createCursorTexture() {
        Pixmap pixmap = new Pixmap(1, 16, Pixmap.Format.RGBA8888);
        pixmap.setColor(0, 0, 0, 1);
        pixmap.fill();
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return texture;
    }
    /** 搜索框*/
    private static void searchBox() {
        searchBox = new TextField("", getTextFiledSytle());
        searchBox.setPosition(200,450);
        searchBox.setSize(500,50);
        searchBox.setMessageText("请输入需要查询的单词...");
    }
    public static void setNumBox() {
        numBox = new TextField("", getTextFiledSytle());
        numBox.setPosition(600,500);
        numBox.setSize(40,30);
        numBox.setMessageText("0");
    }

    private static TextField.TextFieldStyle getTextFiledSytle() {
        TextField.TextFieldStyle style = new TextField.TextFieldStyle();
        style.background = new TextureRegionDrawable(new TextureRegion(getSearchBoxTexture()));
        style.cursor = new TextureRegionDrawable(new TextureRegion(createCursorTexture()));
        style.font = getFont18();
        style.fontColor = new Color(1,1,1,1);
        return style;
    }
    public static TextField getNumBox() { return numBox; }

    public static TextField getSearchBox() { return searchBox; }
    public static void setCount(int n) {
        count = n;
    }
    public static int getCount() {
        return count;
    }

    @Override
    public void dispose() {
        dailySentenceTexture.dispose();
        searchBoxTexture.dispose();
        wordCardTexture.dispose();
        progress.dispose();
        progress1.dispose();
        progress2.dispose();
        menuTexture.dispose();
        hintTexture.dispose();
    }
}
