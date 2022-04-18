package DailyCodingProblem.Dictionary;

import java.util.*;

public class Dictionary {
    static Trie trie = new Trie();
    public static List<String> originalSentence(Set<String> dictionary, String words){
        for(String w: dictionary){
            trie.insert(w);
        }
        return dfs(new LinkedList(), words);
    }

    public static List<String> dfs(LinkedList<String> temp, String words){
        if(words.length() == 0){
            return new ArrayList(temp);
        }
        for(int i = 1; i<= words.length(); i++){
            String subWord = words.substring(0,i);
            if(trie.findWord(subWord) != null) {
                temp.add(subWord);
                List<String> result = dfs(temp, words.substring(i));
                if (result.size() != 0) {
                    return result;
                }
                temp.removeLast();
            }
        }

        return new ArrayList();
    }

    public static void main(String[] args){
        String[] input = new String[]{"bed", "bath", "bedbath","and", "beyond"};
        String words = "bedbathandbeyond";
//        String words = "bedandb";
        Set<String> dictionary =  new HashSet<String>(Arrays.asList(input));
        List<String> result = Dictionary.originalSentence(dictionary,words);
        System.out.println(result.toString());
    }



}
