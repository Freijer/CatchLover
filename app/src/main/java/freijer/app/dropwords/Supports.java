package freijer.app.dropwords;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Supports {
    int asd;

    static List<String> logQA = new ArrayList<>();
    static List<String> taskDone = new ArrayList<>();


    public static int CountCorrectSeqLen(List<String> data) {
        double modifier_to_score = 1.5;
        int score = 0;
        int maxLength = 0;
        int currentLength = data.size() != 0 ? 1 : 0;
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).length() == data.get(i - 1).length() + 1) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }
        maxLength = Math.max(maxLength, currentLength);
        score = (int) (maxLength * modifier_to_score);
        //return score;
        return maxLength;
    }  // последовательность +1 буква к следующему слову
    public static int countStayWord(List<String> data) {
        int maxLength = 0;
        int currentLength = data.size() != 0 ? 1 : 0;
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).length() == data.get(i - 1).length() + 1) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 0;
            }
        }
        maxLength = Math.max(maxLength, currentLength);
        return maxLength;
    }// слов одинаковой длинны подряд
    public static int countWordMinus(List<String> data) {
        int maxLength = 0;
        int currentLength = data.size() != 0 ? 1 : 0;
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).length() == data.get(i - 1).length() - 1) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }
        maxLength = Math.max(maxLength, currentLength);
        return maxLength;
    }// слов одинаковой длинны уменьшение


    

    public void ShowTaskWelDone(List<String> incom) {
        for (String eachString : incom) {
            if (logQA.contains(eachString)) {
                taskDone.add(eachString);
                if (eachString.contains("Последовательность")) { // за послекдовательность 5 очков
                }
                this.asd += 2; //за обычный квест 2 очка
                logQA.remove(eachString);
            }
        }
    }

    protected static void Gos() {

        logQA.add("Слово из 3 букв собранно 3 раза");
        logQA.add("Слово из 3 букв собранно 4 раза");
        logQA.add("Слово из 3 букв собранно 5 раза");
        logQA.add("Слово из 3 букв собранно 6 раза");
        logQA.add("Слово из 3 букв собранно 7 раза");
        //
        logQA.add("Слово из 4 букв собранно 3 раза");
        logQA.add("Слово из 4 букв собранно 4 раза");
        logQA.add("Слово из 4 букв собранно 5 раза");
        logQA.add("Слово из 4 букв собранно 6 раза");
        logQA.add("Слово из 4 букв собранно 7 раза");
        //
        logQA.add("Слово из 5 букв собранно 3 раза");
        logQA.add("Слово из 5 букв собранно 4 раза");
        logQA.add("Слово из 5 букв собранно 5 раза");
        logQA.add("Слово из 5 букв собранно 6 раза");
        logQA.add("Слово из 5 букв собранно 7 раза");
        //
        logQA.add("Слово из 6 букв собранно 3 раза");
        logQA.add("Слово из 6 букв собранно 4 раза");
        logQA.add("Слово из 6 букв собранно 5 раза");
        logQA.add("Слово из 6 букв собранно 6 раза");
        logQA.add("Слово из 6 букв собранно 7 раза");
        //
        logQA.add("Слово из 7 букв собранно 3 раза");
        logQA.add("Слово из 7 букв собранно 4 раза");
        logQA.add("Слово из 7 букв собранно 5 раза");
        logQA.add("Слово из 7 букв собранно 6 раза");
        logQA.add("Слово из 7 букв собранно 7 раза");
        //
        logQA.add("Слово из 8 букв собранно 3 раза");
        logQA.add("Слово из 8 букв собранно 4 раза");
        logQA.add("Слово из 8 букв собранно 5 раза");
        logQA.add("Слово из 8 букв собранно 6 раза");
        logQA.add("Слово из 8 букв собранно 7 раза");
        //
        logQA.add("Последовательность из +1 буква длинной в 3 слов");
        logQA.add("Последовательность из +1 буква длинной в 4 слов");
        logQA.add("Последовательность из +1 буква длинной в 5 слов");

    }



}









