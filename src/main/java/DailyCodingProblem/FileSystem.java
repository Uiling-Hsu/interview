package DailyCodingProblem;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
    static class Tuple {
        int num;
        String name;
        public List<Tuple> childs = new ArrayList();

        Tuple(int num, String name) {
            this.num = num;
            this.name = name;
        }
    }

    public static String findLongestPath(String input) {
        String[] entities = input.split("\\\\n");
        int index = 0;
        Tuple[] levelEntities = new Tuple[entities.length];
        for (int i = 0; i < entities.length; i++) {
            levelEntities[i] = countLevel(entities[i]);
            if (levelEntities[index].num <= levelEntities[i].num) index = i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(levelEntities[index].name);
        int currentLevel = levelEntities[index].num;
        for (int i = index - 1; i >= 0; i--) {
            if (levelEntities[i].num < currentLevel) {
                sb.insert(0, "\\");
                sb.insert(0, levelEntities[i].name);
                currentLevel = levelEntities[i].num;
            }
        }
        return sb.toString();

    }



    public static Tuple countLevel(String entity) {
        int count = 0;
        String current = entity;
        while (current.indexOf("\\t") != -1) {
            count++;
            current = current.substring(current.indexOf("\\t") + 2);
        }
        return new Tuple(count, current);
    }

    public static void main(String[] args) {
        String result = FileSystem.findLongestPath("dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2" +
                ".ext\\n\\tsubdir33\\n\\t\\tsubsubdir33\\n\\t\\t\\tfile33.ext");
        System.out.println(result); // dir/subdir2/subsubdir2/file2.ext
    }
}
