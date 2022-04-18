import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tire {
    class Node{
        Node[] childs = new Node[26];
        String word;
    }

    Node root = new Node();

    public void insert(String word){// notice case-insensitive
        char[] charArray = word.toLowerCase().toCharArray();
        Node current = root;
        for(char c: charArray){
            int index = c-'a';
            if(current.childs[index] == null){
                current.childs[index] = new Node();
            }
            current = current.childs[index];
        }
        current.word = word;
    }

    public List<String> searchByPrefix(String prefix){
        // find the final prefix node , O(len(prefix))
        char[] charArray = prefix.toLowerCase().toCharArray();
        Node current = root;
        for(char c: charArray){
            if(current.childs[c-'a'] == null){
                return new ArrayList(); // no word with prefix exist, return null or empty list
            }
            current = current.childs[c-'a'];
        }

        // preorder traverse the node to find all words
        List<String> wordsWithPrefix = preOrderTraverse(current, new ArrayList<String>());
        return wordsWithPrefix;

    }


    /**
     *  return String by lexicographic ordering because lexicographic ordering of subNode in Node
     *  O(n) = 26 ^ (L-P), L is the maximum length of words, P is the maximum length of prefix
     */

    public List<String> preOrderTraverse(Node root, List<String> result){
        if(root == null){
            return result;
        }
        if(root.word != null){
            result.add(root.word);
        }
        for(Node n: root.childs){
            preOrderTraverse(n,result);
        }
        return result;
    }

    public static void main(String[] args){
        Tire trie = new Tire();
        List<String> dictionary = Arrays.asList(new String[]{"A","aBc","abcD","abcde","abcdEfg","abcdA"});
        for(String s: dictionary){
            trie.insert(s);
        }
        List<String> wordWithPrefix =trie.searchByPrefix("abcd");
        System.out.println(wordWithPrefix);
    }
}

