package com.mini.dictionary;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

public class WordJson extends ApplicationAdapter {

        public String init(String str,int num, int count) {
            Json json = new Json();
            json.setElementType(Character.class, "words", Item.class);
            Character character = json.fromJson(Character.class, Gdx.files.internal("character.json"));
            if (num == 1) // 查找单词
                return character.toExplain(str);
            else if (num == 2 || num ==4)
                return character.toEnCn(count, num);
            else // 查找长度
                return character.toLength();
        }

        public static class Item {  // 对象实体
            private String word;
            private String explain;

            public String toWord() {
                return word;
            }
            public String toExplain() {return explain;}
        }

        public static class Character { // 输出信息
            public Array<Item> words = new Array<Item>();
            String explain = "";
            String sign[] = {"n.","v.","vt.","vi.","adj.","adv.","int.","abbr."};

            public String toExplain(String str) {
                for (Item item : words) {
                    if (str.equals(item.toWord().substring(0,item.toWord().indexOf("&")))) {
                        explain = item.toExplain();
                        for (int i = 0; i < sign.length; i++) {
                            explain = explain.replace(sign[i], "\n" + sign[i]);
                        }
                    }
                }
                return explain;
            }

            public String toLength() {
                int count = 0;
                for (Item item : words)
                    count++;
                return String.valueOf(count);
            }

            public String toEnCn(int count, int num) {
                for (Item item : words)
                    if (count == 0) {
                        explain = item.toExplain();
                        for (int i = 0; i < sign.length; i++) {
                            if (num == 4) {
                                explain = explain.replace(sign[i], "\t" + sign[i]);
                            }else {
                                explain = explain.replace(sign[i], "\n" + sign[i]);
                            }
                        }
                        return item.toWord().replace("&", " ") + explain;
                    }else
                        count --;
                    return "";
            }

        }
}
