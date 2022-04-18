package DailyCodingProblem;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    public class TrieNode{
        TrieNode[] childs = new TrieNode[26];
        String word;
    }
    TrieNode root = new TrieNode();


    public void insert(String word){
        TrieNode current = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(current.childs[index] == null){
                current.childs[index] = new TrieNode();
            }
            current = current.childs[index];
        }
        current.word= word;
    }

    public List<String> searchByPrefix(String prefix){
        TrieNode current = root;
        for(char c: prefix.toCharArray()){
            if(current.childs[c-'a'] == null){
                return new ArrayList();
            }
            current = current.childs[c-'a'];
        }
        List<String> result = new ArrayList();
        dfs(current,result );
        return result;
    }

    public void dfs(TrieNode node, List<String> result){
        if(node == null) return;
        if(node.word != null){
            result.add(node.word);
        }
        for(TrieNode child: node.childs){
            dfs(child, result);
        }
    }

    public static void main(String[] args){
        String[] dictionary = new String[]{"deep","dee","de"};
        Trie trie = new Trie();
        for(String word:dictionary){
            trie.insert(word);
        }

        List<String> result = trie.searchByPrefix("dee");
        System.out.println(result);

    }


}
