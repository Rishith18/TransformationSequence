import java.util.ArrayList;

public class CodingChallenge {
    public static void main(String[] args) {
        ArrayList<String> test1 = new ArrayList<String>();
        String[] test1Array = {"a","b","c"};
        test1 = findShortestTransformation("a", "c", test1Array);
        System.out.println(test1);

        ArrayList<String> test2 = new ArrayList<String>();
        String[] test2Array = {"hot", "dot", "dog", "lot", "log", "cog"};
        test2 = findShortestTransformation("hit", "cog", test2Array);
        System.out.println(test2);

         ArrayList<String> test3 = new ArrayList<String>();
        String[] test3Array = {"hot", "dog"};
        test3 = findShortestTransformation("hot", "dog", test3Array);
        System.out.println(test3);
    }

    public static ArrayList<String> findShortestTransformation(String beginWord, String endWord, String[] wordList) {
        String currentWord = beginWord;
        ArrayList<String> transfList = new ArrayList<String>();
        transfList.add(beginWord);

        for (String word : wordList) {
            if (positionDifferBy1Char(currentWord, word) != -1) {
                transfList.add(word);
                currentWord = word;
            }
        }

        for (int i = 0; i < transfList.size() - 2; i++) {
            if (positionDifferBy1Char(transfList.get(i), transfList.get(i+1)) == 
            positionDifferBy1Char(transfList.get(i+1), transfList.get(i+2))) {
                transfList.remove(i+1);
                i = 0;
            }
        }

        if (transfList.size() == 1) {
            return new ArrayList<String>();
        }
        return transfList;
    }

    public static int positionDifferBy1Char(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                count++;
            } 
        }
        if (count == word1.length() - 1) {
            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    return i;
                } 
            }
        } 
        return -1;
    }
}