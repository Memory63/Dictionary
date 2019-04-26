package com.mini.dictionary.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
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
    private static BitmapFont dateFont;
    private static TextureAtlas.AtlasRegion progress;
    private static TextureAtlas.AtlasRegion progress1;
    private static TextureAtlas.AtlasRegion progress2;
    private static TextField searchBox;
    private static TextField numBox;
    private static int count; // 每日背单词数
    public static final TextureAtlas atlas;

    static{
        atlas = new TextureAtlas(Gdx.files.internal("icon/icons.atlas"));
        font18 = new BitmapFont(Gdx.files.internal("font/font18.fnt"),
                Gdx.files.internal("font/font18.png"),false);
        dateFont = new BitmapFont(Gdx.files.internal("font/dateFont.fnt")
                ,Gdx.files.internal("font/dateFont.png"),false);
        progress =  atlas.findRegion("progress");
        progress1 = atlas.findRegion("progress1");
        progress2 = atlas.findRegion("progress2");
        searchBox();
        setNumBox();
    }
    public static BitmapFont getFont18() {
        return font18;
    }
    public static BitmapFont getDateFont() {return dateFont;}
    public static TextureAtlas.AtlasRegion getDailySentenceTexture() {
        return atlas.findRegion("boundary"); }
    public static TextureAtlas.AtlasRegion getSearchBoxTexture() {
        return atlas.findRegion("search");}
    public static TextureAtlas.AtlasRegion getWordCardTexture() {
        return atlas.findRegion("wordcard");
    }
    public static TextureAtlas.AtlasRegion getProgress(int n) {
        if (n == 0)
            return progress;
        else if (n == 1)
            return progress1;
        else if (n == 2)
            return progress2;
        return progress;
    }
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
        style.background = new TextureRegionDrawable(getSearchBoxTexture());
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
    }
}
