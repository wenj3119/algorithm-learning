package com.douwen.top.pretree;

public class MapSum {
    static class TrieNode{
        public TrieNode[] children;
        public int value;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    private TrieNode root;
    public MapSum(){
        root = new TrieNode();
    }

    public void insert(String key, int val){
        TrieNode node = root;
        for(int i = 0; i < key.length(); i ++){
            char ch = key.charAt(i);
            if(node.children[ch - 'a'] == null){
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.value = val;
    }

    public int sum(String prefix){
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i ++){
            char ch = prefix.charAt(i);
            if(node.children[ch - 'a'] == null){
                return 0;
            }
            node = node.children[ch - 'a'];
        }
        return getSum(node);
    }
    private int getSum(TrieNode node){
        if(node == null){
            return 0;
        }
        int result = node.value;
        for(TrieNode child : node.children){
            result += getSum(child);
        }
        return result;
    }
}
