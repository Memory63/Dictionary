package com.mini.dictionary.util;

public class MenuInformation {
    // 菜单的位置
    public static final int FRAMEHEIGHT = 430; // 跟hint.png图片高度有关
    public static final int BUTTONHEIGHT = 45; // 跟select.png图片的高度相同
    // 按钮开关 true为启用按钮，反之
    public static final boolean OPENBUTTON[] = {true,true,true,false,false,false,true};
    // 默认选项
    public static int defaultOptionOn = 0; // 默认选中按钮 0 - 5 其中一个
    // 设置选项的按钮位置
    public static final int SETTINGBUTTONPOSITION[] = {10,10};
    // 按钮0-5 的显示文本
    public static final String BUTTONTEXT[] = {"查单词","背单词","单词列表","4","5","6"};
    // 按钮0-6的按钮以及设置按钮的纹理路径
    public static final String BUTTONONEPATH[] = {"dict","dict-hover", "select"};
    public static final String BUTTONTWOPATH[] = {"wb","wb-hover", "select"};
    public static final String BUTTONTHREEPATH[] = {"wb","wb-hover", "select"};
    public static final String BUTTONFOURPATH[] = {"wb","wb-hover", "select"};
    public static final String BUTTONFIVEPATH[] = {"wb","wb-hover", "select"};
    public static final String BUTTONSIXPATH[] = {"wb","wb-hover", "select"};
    public static final String SETTINGBUTTONPATH[] = {"wb-setting-normal","wb-setting-hover"};
    // 字体路径
    public static final String FONTPATH[] = {"font/default.fnt","font/default.png"};
}
