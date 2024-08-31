package com.douwen.top.pretree;

import java.util.List;

public class ReplaceWords {

    public String replaceWords(List<String> dict, String sentence){
        Trie.TrieNode root = buildTrie(dict);

        String[] words = sentence.split(" ");
        for(int i = 0; i < words.length; i ++){
            String prefix = findPrefix(root,words[i]);
            if(!prefix.isEmpty()){
                words[i] = prefix;
            }
        }
        return String.join(" ",words);
    }
    private String findPrefix(Trie.TrieNode root, String word){
        Trie.TrieNode node = root;
        StringBuilder builder = new StringBuilder();
        for(char ch : word.toCharArray()){
            if(node.isWord || node.children[ch-'a'] == null){
                break;
            }
            builder.append(ch);
            node = node.children[ch-'a'];
        }
        return node.isWord ? builder.toString() : "";
    }

    private Trie.TrieNode buildTrie(List<String> dict){
        Trie.TrieNode root = new Trie.TrieNode();
        for(String word : dict){
            Trie.TrieNode node = root;
            for(char ch : word.toCharArray()){
                if(node.children[ch-'a'] == null){
                    node.children[ch-'a'] = new Trie.TrieNode();
                }
                node = node.children[ch-'a'];
            }
            node.isWord = true;
        }
        return root;
    }


}
