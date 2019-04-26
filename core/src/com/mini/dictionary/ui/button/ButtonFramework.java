package com.mini.dictionary.ui.button;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Disposable;
import com.mini.dictionary.ui.button.entity.ButtonInformation;
import com.mini.dictionary.util.LoadFile;


/** 创建ImageTextButton的框架*/
public class ButtonFramework implements Disposable {
    public ButtonInformation buttonMessage; // 设置按钮信息

    private BitmapFont font;
    private ImageTextButton button;
    private ImageTextButton.ImageTextButtonStyle style;
    private String upTexture;
    private String overTexture;
    private String downTexture;

    public ButtonFramework() {
        buttonMessage = new ButtonInformation();
    }

    /** 创建按钮*/
    public ImageTextButton createButton() {
        setTextures();
        setFont();
        setStyle();
        setButton();
        return button;
    }

    /** 设置按钮*/
    public void setButton() {
        button = new ImageTextButton(buttonMessage.getText(),style);
        button.setPosition(buttonMessage.getxAxis(),buttonMessage.getyAxis());
    }

    /** 设置按钮风格 */
    public void setStyle() {
        style = new ImageTextButton.ImageTextButtonStyle();
        style.font = font;
        if (upTexture != null)
            style.imageUp = new TextureRegionDrawable(LoadFile.atlas.findRegion(upTexture));
        if (overTexture != null) {
            style.imageOver =
                    new TextureRegionDrawable(LoadFile.atlas.findRegion(overTexture));
            style.imageChecked =
                    new TextureRegionDrawable( LoadFile.atlas.findRegion(overTexture));
        }
        if (downTexture != null)
            style.checked =
                    new TextureRegionDrawable( LoadFile.atlas.findRegion(downTexture));
    }

    /** 为按钮添加字体文件*/
    public void setFont() {
        font = new BitmapFont(Gdx.files.internal(buttonMessage.getFontFntPath()),
                Gdx.files.internal(buttonMessage.getFontPngPath()),false);
    }

    public void setFont(BitmapFont font) {
        this.font = buttonMessage.setFont(font);
    }

    /** 设置按钮纹理 */
    public void setTextures() {
        upTexture = buttonMessage.getUpTexturePath();
        overTexture = buttonMessage.getOverTexturePath();
        downTexture = buttonMessage.getDownTexturePath();
    }

    /** 释放资源 */
    @Override
    public void dispose () {
    }
}
