package freijer.app.dropwords;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Supports {
    int asd;
    static int pos_asd;


    ImageView img_nextlvl;

    protected int tr = 0;
    protected int flag_1;
    public int tryChenge = 10;


    ArrayList<String> Task = new ArrayList<>();
    static List<String> logQA = new ArrayList<>();
    static List<String> taskDone = new ArrayList<>();
    private static int TotalScore;

    public static int getTotalScore() {
        return TotalScore;
    }

    public void setTotalScore(int totalScore) {
        TotalScore = totalScore;
    }

    public static int countCorrectSeqLen(List<String> data) {
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
        return maxLength;
    }// последовательность +1 буква к следующему слову

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
    }// слов одинаковой длинны подряд

    protected int next_lvl = 1;

    protected int LVL_UP1(int income) {
        if (income >= 5 && income <= 20) {
            this.next_lvl = 2;
        } else if (income >= 21 && income <= 40) {
            this.next_lvl = 3;
        } else if (income >= 41 && income <= 60) {
            this.next_lvl = 4;
        }
        return next_lvl;
    }



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
    }
    // последовательность +1 буква к следующему слову
    //Вводим число  =   длинна последовательности. И если правильная, то возвращаем количество очков в 1.5 раза больше нужной последовательности.

    public void ShowTaskWelDone(List<String> incom) {
        for (String eachString : incom) {
            if (logQA.contains(eachString)) {
                taskDone.add(eachString);
                if (eachString.contains("Последовательность")) { // за послекдовательность 5 очков
                    //  setTry_change_word(getTry_change_word()+1);
                   // this.asd += 3;
                }
                //  setTry_change_word(getTry_change_word()+1);
                //tryChenge = tryChenge+ 1;
                this.asd += 2; //за обычный квест 2 очка
                logQA.remove(eachString);

            }
        }



//        this.pos_asd = Supports.CountCorrectSeqLen(Words)*2; //очки за последовательность увеличиваются
//        setTotalScore((Supports.CountCorrectSeqLen(Words)*2) + asd); //в два раза больше очков за последовательность

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

    public void TaskListing() {
        Task.add("Собрать слово из 3 букв 3 раза");
        Task.add("Собрать слово из 4 букв 3 раза");
    }




    protected static int LVL_UP(int income) {
        if (income >= 0 && income <= 3) {
            return 1;
        } else if (income >= 4 && income <= 7) {
            return 2;
        } else if (income >= 8 && income <= 15) {
            return 3;
        } else if (income >= 41 && income <= 60) {
            return 4;
        }
        return 1;
    }

    void printIfLeveledUp(int income) {
        int new_lvl = LVL_UP(income);
        if (new_lvl > next_lvl) {
            next_lvl = new_lvl;
            System.out.println(next_lvl);
        }
    }


}









