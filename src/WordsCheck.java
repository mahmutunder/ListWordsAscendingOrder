
import java.util.Arrays;
public class WordsCheck {

    private String words;

    public WordsCheck() {
        words = "";
    }

    public WordsCheck(String words) {
        setWords(words);
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public String checkWords() {
        words=words.trim();
        String[] divideWords = words.split(" ");

        for (int i = 0; i < divideWords.length; i++) {
            String newWord = "";
            for (int j = 0; j < divideWords[i].length(); j++) {


                if (Character.isLetter(divideWords[i].charAt(j))) {
                    newWord += divideWords[i].charAt(j);
                }

            }

            if (!newWord.isEmpty()) {
                divideWords[i] = newWord;
            }

        }
        for (int i = 0; i < divideWords.length; i++) {

            for (int j = 0; j < divideWords.length - 1 - i; j++) {


                if (divideWords[j].length() > divideWords[j + 1].length()) {
                    String temp = divideWords[j];
                    divideWords[j] = divideWords[j + 1];
                    divideWords[j + 1] = temp;

                }

            }
        }


        System.out.println(Arrays.toString(divideWords));
        String allWords = "";
        for (int i = 0; i < divideWords.length; i++) {


            boolean flag = false;
            for (int j = 0; j < divideWords[i].length(); j++) {


                if (Character.isLetter(divideWords[i].charAt(j))) {
                    flag = true;
                    if (j == 0 && i == 0) {
                        allWords += (divideWords[i].charAt(j) + "").toUpperCase();
                    } else {
                        allWords += (divideWords[i].charAt(j) + "").toLowerCase();
                    }


                }


            }
            if (i == divideWords.length - 1) {
                allWords += ".";
            } else if (flag) {
                allWords += " ";
            }

        }


         return  allWords;
    }


    public static void main(String[] args) {
        WordsCheck check = new WordsCheck("Blizzard is a place I want 2 work @t!");
        check.checkWords();
    }
}
