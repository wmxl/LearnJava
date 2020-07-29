package BiShiTi.HuaWei;

import java.util.ArrayList;
import java.util.HashMap;

public class Main22 {
    class TrieNode{
        char value;
        int freqs;
        int hasChild;
        HashMap<Character, TrieNode> map;
        ArrayList<Character> keyList;
        TrieNode(char value, int freqs, int hasChild, HashMap map, ArrayList keyList){
            this.value = value;
            this.freqs = freqs;
            this.hasChild = hasChild;
            this.map = map;
            this.keyList = keyList;
        }
    }
    public void buildTree(int[] labels, int[] haschlid, int[] pouds, int[] value, int[] key) {
        int len = labels.length;
        int[] v = new int[len];
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (haschlid[i] == 0) {
                v[i] = value[cnt++];
            } else {
                v[i] = -1;
            }
        }
//        System.out.println(Arrays.toString(labels));
//        System.out.println(Arrays.toString(haschlid));
//        System.out.println(Arrays.toString(pouds));
//        System.out.println(Arrays.toString(v));
//        System.out.println(Arrays.toString(key));
        for (int i = 0; i < len; i++) {
            if(haschlid[i] == 0){
                new TrieNode((char)labels[i], 0, haschlid[i], null, null);
            }else {
                new TrieNode((char)labels[i], 0, haschlid[i], null, null);
            }
        }


    }
    public static void main(String[] args) {
        int[] labels = new int[]{115,112,116,97,111,121,114,101,105,112,121,114,102,115,116};
        int[] haschlid = new int[]{0,0,0,1,1,0,1,0,0,0,0,1,1,1,1};
        int[] pouds = new int[]{1,1,0,1,0,1,1,1,0,0,0,1,1,0,0};
        int[] value = new int[]{1,2,3,4,5,6,7,8};
        int[] key = new int[]{116,114,112};

        Main22 m22 = new Main22();
        m22.buildTree(labels, haschlid, pouds, value, key);



    }
}
