package DailyCodingProblem.RegularExp;

public class RegularExp {
    public boolean regExp(String exp, String word){
        Trie trie = new Trie();
        trie.insert(exp);
        return trie.match(word,trie.getRoot());
    }

    public static void main(String[] arg){
        RegularExp regularExp = new RegularExp();
        boolean result = regularExp.regExp(".*at","aat");
        System.out.println(result);

    }

}
