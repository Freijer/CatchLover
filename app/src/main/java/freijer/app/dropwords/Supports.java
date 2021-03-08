package freijer.app.dropwords;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Supports {
    int asd;

    static int counter_plus = 0;
    static int plusLenght = 0;
    static int counter_stay = 0;
    static int stayLenght = 0;


    protected int plusLength; //+1 буква в слове
    private int stayLength; //слова той же длинны подряд раз
    private int minusLength; //-1 буква в слове
    protected  ArrayList<String> Alfas = new ArrayList<>(); //вхоящий прогресс


    static List<String> logQA = new ArrayList<>();
    static List<String> taskDone = new ArrayList<>();


    private void add_plus (int input) {
        if (input > 2) {
            counter_plus++;
        }
        plusLenght = input;
    } //счетчик увеличения длинны слов
    private void add_stay (int input, int param) {
        if (input == param) {
            counter_stay++;
        }
        stayLenght = input;
    } //счетчик слов равной длинны


    public int CountCorrectSeqLen(List<String> data) {
        int currentLength = data.size() != 0 ? 1 : 0;
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).length() == data.get(i - 1).length() + 1) {
                currentLength++;
            } else {
                plusLength = Math.max(plusLength, currentLength);
                currentLength = 1;
            }
        }
        plusLength = Math.max(plusLength, currentLength);
        return plusLength;
    }  // последовательность +1 буква к следующему слову
    public int countStayWord(List<String> data) {
        int currentLength = data.size() != 0 ? 0 : 0;
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).length() == data.get(i - 1).length()) {
                currentLength++;
            } else {
                stayLength = Math.max(stayLength, currentLength);
                currentLength = 0;
            }
        }
        stayLength = Math.max(stayLength, currentLength);
        return stayLength;
    }// слов одинаковой длинны подряд.
    public int countWordMinus(List<String> data) {
        int currentLength = data.size() != 0 ? 1 : 0;
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).length() == data.get(i - 1).length() - 1) {
                currentLength++;
            } else {
                minusLength = Math.max(minusLength, currentLength);
                currentLength = 1;
            }
        }
        minusLength = Math.max(minusLength, currentLength);
        return minusLength;
    }// слов  длинны уменьшение



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









