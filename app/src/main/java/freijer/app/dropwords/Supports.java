package freijer.app.dropwords;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

public class Supports {

    ImageView img_nextlvl;
    protected int next_lvl = 1;
    protected int tr = 0;


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


    protected int LVL_UP(int income) {
        if (income >= 3 && income <= 20) {
            this.next_lvl = 2;
        } else if (income >= 21 && income <= 40) {
            this.next_lvl = 3;
        } else if (income >= 41 && income <= 60) {
            this.next_lvl = 4;
        }  //увеличение уровня, подсчет
        return next_lvl;
    }
}



