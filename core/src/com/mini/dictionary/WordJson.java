package com.mini.dictionary;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

public class WordJson extends ApplicationAdapter {

        @Override
        public void create() {

            Json json = new Json();
            json.setElementType(Character.class, "items", Item.class);  // 指定Character中的item数据类型
            Character character = json.fromJson(Character.class, Gdx.files.internal("character.json"));    // 从Json文件中创建一个Charactor对象
            System.out.println(character);
        }

        public static class Item {
            private String word;
            private String cn;

            public String toWord() {
                return word;
            }
        }

        public static class Character {
            public Array<Item> items = new Array<Item>();

            public String toString() {
                String string = new String();
                for (Item item : items) {
                    string += item.toString() + " ";
                }

                return string;
            }
        }
}
