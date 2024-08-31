package com.douwen.top.pretree;

public class ShortTestWord {

    static class TrieNode{
        public TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    public int minimumLengthEncoding(String[] words){
        TrieNode root = buildTrie(words);
        int[] total = {0};
        dfs(root,1,total);
        return total[0];
    }
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode node = root;
            for(int i = word.length() - 1; i >= 0; i --){
                char ch = word.charAt(i);
                if(node.children[ch - 'a'] == null){
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
        }
        return root;
    }
    private void dfs(TrieNode root, int length,int[] total){
        boolean isLeaf = true;
        for(TrieNode child : root.children){
            if(child != null){
                isLeaf = false;
                dfs(child,length + 1,total);
            }
        }
        if(isLeaf){
            total[0] += length;
        }
    }

}
