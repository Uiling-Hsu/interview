package DailyCodingProblem.Dictionary;

public class Trie {
    class Node{
        Node[] childs = new Node[26];
        String word;
    }
    Node root ;

    public Trie( ){
        root = new Node();
    }

    public void insert(String word){
        Node current = root;
        for(char c: word.toCharArray()){
            if(current.childs[c-'a'] == null){
                current.childs[c-'a']  = new Node();
            }
            current = current.childs[c-'a'] ;
        }
        current.word = word;

    }

    public String findWord(String word){
        Node current = root;
        for(char c: word.toCharArray()){
            if(current.childs[c-'a'] == null) return null;
            current = current.childs[c-'a'];
        }
        return current.word;
    }

}
