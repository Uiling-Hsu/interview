package DailyCodingProblem.RegularExp;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    class Node{
        Map<Character,Node> childs = new HashMap();
        String expression;
    }

    public Node root = new Node();

    public Node getRoot(){
        return root;
    }
    public void insert(String exp){
        Node current = root;
        for(char c: exp.toCharArray()){
            if(current.childs.get(c) == null){
                current.childs.put(c,new Node());
            }
            current = current.childs.get(c);
        }
        current.expression = exp;
    }


    public boolean match(String word, Node node){
        Node current = node;
        int wordLength = word.toCharArray().length;
        for(int i =0; i < wordLength; ){
            // * : *bc, bbbc
            if(current.childs.get('*') != null){ // *bc, abbbbbc
                current = current.childs.get('*');

                for(int j = i; j < wordLength; j++){
                    if (current.childs.get(word.charAt(j))!=null) {
                        if (match(word.substring(j), current)) return true;
                    }
                }
                return false;

            }else if(current.childs.get('.') != null){
                current = current.childs.get('.');
                i++;
            }else if (current.childs.get(word.charAt(i)) != null){
                current = current.childs.get(word.charAt(i));
                i++;
            }else{
                return false;
            }
        }
        return current.expression != null? true: false;
    }

}
