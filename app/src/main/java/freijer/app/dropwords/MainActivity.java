package freijer.app.dropwords;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity  {

    //на кард лайоут перемещаем, кнопка исчезает и появялется буква на текстовом поле,  и можно перемещать перелистывать

    //ctrl+shift+ - все свернуть


    protected Button but1, but2, but3;
    private AlertDialog OptionDialog;


    protected int textFlag;
    public int getTextFlag() {
        return textFlag;
    }
    public void setTextFlag(int textFlag) {
        this.textFlag = textFlag;
    }


    protected int f001;
    protected int y002;


    ObjectAnimator  button1;
    ObjectAnimator  button2;
    ObjectAnimator  button3;
    ObjectAnimator  button4;
    ObjectAnimator  button5;
    ObjectAnimator  button6;
    ObjectAnimator  button7;
    ObjectAnimator  button8;
    ObjectAnimator  button9;
    ObjectAnimator  button10;
    ObjectAnimator  button11;
    ObjectAnimator  button12;
    ObjectAnimator  button13;
    ObjectAnimator  button14;

    protected TextView textSee, textClock, score, textView2, textView3, textView4;
    protected TextView textButton1, textButton2, textButton3, textButton4, textButton5, textButton6, textButton7, textButton8, textButton9, textButton10;
    protected Button progress,  faq, start, starter, reset, pr1, pr2, pr3, pr4, pr5, pr6, pr7, pr8, pr9, pr10, pr11, pr12, pr13, pr14;
    protected Button copy_pr1, copy_pr2, copy_pr3, copy_pr4, copy_pr5, copy_pr6, copy_pr7, copy_pr8, copy_pr9, copy_pr10, copy_pr11, copy_pr12, copy_pr13, copy_pr14;
    private Button chek1, chek2, chek3, chek4, chek5, chek6, chek7, chek8, chek9, chek10;
    private ImageView  clock;
    protected ArrayList<String> MainListWord = new ArrayList<String>();// при нажатии кнопки собисрется слово
    protected ArrayList<Integer> ListCoordinateX_1 = new ArrayList<Integer>();
    protected ArrayList<Integer> LineY_1 = new ArrayList<Integer>();
    protected ArrayList<Integer> MooveToEdgeDropLayout = new ArrayList<Integer>();
    private ArrayList<String> list;
    protected ArrayList<String> listControl;
    protected ArrayList<String> listBuffer = new ArrayList<String>();;
    protected ConstraintLayout dropLayout;

    int counter;
    public int getCounter() {
        return counter;
    }
    public void setCounter(int counter) {
        this.counter = counter;
    }


    private int indexWord;
    private String word;
    private Random r = new Random();
    protected String[] Original;
    protected String[] OriginalWord; //бавзовое слово
    protected String[] MixedleWord; //смешение
    protected String Control;
    private ConstraintLayout Colo;
    private final int USERID = 6000;
    private int countID;
    protected int numsofliteralsinword;
    protected int speed;
    protected int shiftLiterals =60;//миещние букв в лево
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Point viewLocatedAt(View v) {
        int[] location = new int[2];
        v.getLocationOnScreen(location);
        int x = location[0];
        int y = location[1];
        return new Point(x, y);
    } //определние координат



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTextFlag(1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pr1 = findViewById(R.id.pr1);
        pr2 = findViewById(R.id.pr2);
        pr3 = findViewById(R.id.pr3);
        pr4 = findViewById(R.id.pr4);
        pr5 = findViewById(R.id.pr5);
        pr6 = findViewById(R.id.pr6);
        pr7 = findViewById(R.id.pr7);
        pr8 = findViewById(R.id.pr8);
        pr9 = findViewById(R.id.pr9);
        pr10 = findViewById(R.id.pr10);
        pr11 = findViewById(R.id.pr11);
        pr12 = findViewById(R.id.pr12);
        pr13 = findViewById(R.id.pr13);
        pr14 = findViewById(R.id.pr14);
        starter = findViewById(R.id.starter);
        faq = findViewById(R.id.faq);

        clock = findViewById(R.id.clock);
        textSee = findViewById(R.id.textSee);

        textButton1 = findViewById(R.id.textButton1);
        textButton2 = findViewById(R.id.textButton2);
        textButton3 = findViewById(R.id.textButton3);
        textButton4 = findViewById(R.id.textButton4);
        textButton5 = findViewById(R.id.textButton5);
        textButton6 = findViewById(R.id.textButton6);
        textButton7 = findViewById(R.id.textButton7);
        textButton8 = findViewById(R.id.textButton8);
        textButton9 = findViewById(R.id.textButton9);
        textButton10 = findViewById(R.id.textButton10);
        progress = findViewById(R.id.progress);

        score = findViewById(R.id.score);
        textClock = findViewById(R.id.textClock);
        Colo = findViewById(R.id.Colo);
        dropLayout = findViewById(R.id.dropLayout);

        ListXUpFull(); // заполняем листы координат
        ControlWordsfinFail(); // читаем проверочные слова
        ReadWords(); // читаем ключевык
        Randomizator(); // разиваем на буквы
        GoneButnnons(); //все кнопки изначально не видимы
//        ShowButtons(); // услвие появление кнопок зависитот кол-ва букв в слове
        SetLiteralsonButtons(); //установка букв на слова
        Creates(); //активация и движеение кнопок
        String gg = Integer.toString(numsofliteralsinword);


    }





    public void ListXUpFull(){
        ListCoordinateX_1.add(200);
        ListCoordinateX_1.add(200);
    } //координаты для первого слова
    public void GoneButnnons(){
        pr1.setVisibility(GONE);
        pr2.setVisibility(GONE);
        pr3.setVisibility(GONE);
        pr4.setVisibility(GONE);
        pr5.setVisibility(GONE);
        pr6.setVisibility(GONE);
        pr7.setVisibility(GONE);
        pr8.setVisibility(GONE);
        pr9.setVisibility(GONE);
        pr10.setVisibility(GONE);
        pr11.setVisibility(GONE);
        pr12.setVisibility(GONE);
        pr13.setVisibility(GONE);
        pr14.setVisibility(GONE);

        clock.setVisibility(GONE);

        textSee.setVisibility(GONE);
        textClock.setVisibility(GONE);

        textButton1.setEnabled(false);
        textButton2.setEnabled(false);
        textButton3.setEnabled(false);
        textButton4.setEnabled(false);
        textButton5.setEnabled(false);
        textButton6.setEnabled(false);
        textButton7.setEnabled(false);
        textButton8.setEnabled(false);
        textButton9.setEnabled(false);
        textButton10.setEnabled(false);

        textButton1.setVisibility(GONE);
        textButton2.setVisibility(GONE);
        textButton3.setVisibility(GONE);
        textButton4.setVisibility(GONE);
        textButton5.setVisibility(GONE);
        textButton6.setVisibility(GONE);
        textButton7.setVisibility(GONE);
        textButton8.setVisibility(GONE);
        textButton9.setVisibility(GONE);
        textButton10.setVisibility(GONE);

    } //убрать кнопки с экрана
    public void ShowButtons(){
        textButton1.setEnabled(true);
        switch (numsofliteralsinword){
            case 11:
                pr1.setVisibility(VISIBLE);
                pr2.setVisibility(VISIBLE);
                pr3.setVisibility(VISIBLE);
                pr4.setVisibility(VISIBLE);
                pr5.setVisibility(VISIBLE);
                pr6.setVisibility(VISIBLE);
                pr7.setVisibility(VISIBLE);
                pr8.setVisibility(VISIBLE);
                pr9.setVisibility(VISIBLE);
                pr10.setVisibility(VISIBLE);
                pr11.setVisibility(VISIBLE);
                //--
                button1.start();
                button2.start();
                button3.start();
                button4.start();
                button5.start();
                button6.start();
                button7.start();
                button8.start();
                button9.start();
                button10.start();
                button11.start();
                break;
            case 14:
                pr1.setVisibility(VISIBLE);
                pr2.setVisibility(VISIBLE);
                pr3.setVisibility(VISIBLE);
                pr4.setVisibility(VISIBLE);
                pr5.setVisibility(VISIBLE);
                pr6.setVisibility(VISIBLE);
                pr7.setVisibility(VISIBLE);
                pr8.setVisibility(VISIBLE);
                pr9.setVisibility(VISIBLE);
                pr10.setVisibility(VISIBLE);
                pr11.setVisibility(VISIBLE);
                pr12.setVisibility(VISIBLE);
                pr13.setVisibility(VISIBLE);
                pr14.setVisibility(VISIBLE);
                //--
                button1.start();
                button2.start();
                button3.start();
                button4.start();
                button5.start();
                button6.start();
                button7.start();
                button8.start();
                button9.start();
                button10.start();
                button11.start();
                button12.start();
                button13.start();
                button14.start();
                break;
        }
        clock.setVisibility(VISIBLE);
        textSee.setVisibility(VISIBLE);
        textClock.setVisibility(VISIBLE);
        starter.setVisibility(GONE);
        //--
        textButton1.setVisibility(VISIBLE);
        textButton2.setVisibility(VISIBLE);
        textButton3.setVisibility(VISIBLE);
        textButton4.setVisibility(VISIBLE);
        textButton5.setVisibility(VISIBLE);
        textButton6.setVisibility(VISIBLE);
        textButton7.setVisibility(VISIBLE);
        textButton8.setVisibility(VISIBLE);
        textButton9.setVisibility(VISIBLE);
        textButton10.setVisibility(VISIBLE);
    } // показ кнопок на экране
    public void ReadWords(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("sevrallwords.txt")));
            String str;
            this.list = new ArrayList<String>();
            while ((str = reader.readLine()) != null) {
                if (!str.isEmpty()) {
                    list.add(str);
                }
            }
//            this.ReadWords = list.toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }// Читаем ключевые слова из файлика
    public void ControlWordsfinFail(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("sevrallmanywords.txt")));
            String str1;
            this.listControl = new ArrayList<String>();
            while ((str1 = reader.readLine()) != null) {
                if (!str1.isEmpty()) {
                    listControl.add(str1);
                }
            }
//            this.ReadWords = list.toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }// Читаем проверочные слова из файлика
    public void Randomizator(){
        if (!list.isEmpty()) {
            this.indexWord = r.nextInt(list.size());
            this.word = list.get(indexWord);
            list.remove(word);
        } else if (list.isEmpty()) {
            this.word = "конец";
            Randomizator();
        }
        this.Original = this.word.split("");//разбив по буквам
        List<String> list = new ArrayList<String>(Arrays.asList(Original));
        list.removeAll(Arrays.asList("", null));
        this.OriginalWord = list.toArray(new String[0]);
        String[] Literals = OriginalWord;
        List<String> shuffle = Arrays.asList(Literals);
        Collections.shuffle(shuffle);
        shuffle.toArray(Literals);
        this.MixedleWord = Literals;
        this.Control = this.word;
        this.numsofliteralsinword = MixedleWord.length;
    } //  Разбиваем слово на буквы
    protected void SetLiteralsonButtons(){
        switch (numsofliteralsinword) {
            case 11:
                pr1.setText(String.valueOf(MixedleWord[0]));
                pr2.setText(String.valueOf(MixedleWord[1]));
                pr3.setText(String.valueOf(MixedleWord[2]));
                pr4.setText(String.valueOf(MixedleWord[3]));
                pr5.setText(String.valueOf(MixedleWord[4]));
                pr6.setText(String.valueOf(MixedleWord[5]));
                pr7.setText(String.valueOf(MixedleWord[6]));
                pr8.setText(String.valueOf(MixedleWord[7]));
                pr9.setText(String.valueOf(MixedleWord[8]));
                pr10.setText(String.valueOf(MixedleWord[9]));
                pr11.setText(String.valueOf(MixedleWord[10]));
                break;
            case 14:
                pr1.setText(String.valueOf(MixedleWord[0]));
                pr2.setText(String.valueOf(MixedleWord[1]));
                pr3.setText(String.valueOf(MixedleWord[2]));
                pr4.setText(String.valueOf(MixedleWord[3]));
                pr5.setText(String.valueOf(MixedleWord[4]));
                pr6.setText(String.valueOf(MixedleWord[5]));
                pr7.setText(String.valueOf(MixedleWord[6]));
                pr8.setText(String.valueOf(MixedleWord[7]));
                pr9.setText(String.valueOf(MixedleWord[8]));
                pr10.setText(String.valueOf(MixedleWord[9]));
                pr11.setText(String.valueOf(MixedleWord[10]));
                pr12.setText(String.valueOf(MixedleWord[11]));
                pr13.setText(String.valueOf(MixedleWord[12]));
                pr14.setText(String.valueOf(MixedleWord[13]));
                break;
        }
    } //назначаем буквы на кнопки

    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("     Инструкция")
                .setMessage("По экрану движутся кнопки, нажимая на них ВЫ собираете слова, которые выстраиваются по цветным линиям. Собрал слово - нажал на галочку." + "\n"  +
                        "слово  меньше 3 букв - 1очко" + "\n"  +
                        "3 буквы +1" + "\n"  +
                        "4 буквы +2 " + "\n"  +
                        "5 букв +3" + "\n"  +
                        "6 букв +4" + "\n"  +
                        "каждое не правильное слово так же -1 очко")
                .setCancelable(false)
                .setNegativeButton("Все понятно, создатель этого приложения гений!",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    } //Всплывабщее окно

    public void LetsGo(View v){
        ShowButtons();
        starter.setVisibility(GONE);
        new CountDownTimer(120000, 1000) {
            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                textClock.setText("Сек :" + millisUntilFinished / 1000);
            }
            public void onFinish() {
                textClock.setText("done!");
                GoneButnnons();
            }
        }.start();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                f001 = viewLocatedAt(textButton1).y - (textButton1.getHeight()/2 );
                LineY_1.clear();
                LineY_1.add(f001);
            }
        }, 500);


    }  // СТАРТ, часы
    protected void HowScore(int A){
        switch (A){
            case 2:
                setCounter(getCounter()-1);
                break;
            case 3:
                setCounter(getCounter()+1);
                break;
            case 4:
                setCounter(getCounter()+2);
                break;
            case 5:
                setCounter(getCounter()+3);
            case 6:
                setCounter(getCounter()+4);
                break;
        }
    }//подсчет очков


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Chek_1(View v){
        String[] ArrayListWord = MainListWord.toArray(new String[0]);
        String KeyWord = (String.join("", ArrayListWord));
        if (listControl.contains(KeyWord) && !listBuffer.contains(KeyWord)) {
//            this.f001 = viewLocatedAt(textButton2).y - (pr1.getHeight()/4 );
//            LineY_1.clear();
//            LineY_1.add(f001);
//            this.ListCoordinateX_1.removeAll(ListCoordinateX_1);
            ListXUpFull();
            HowScore(ArrayListWord.length);
            score.setText(""+getCounter());
            textButton1.setBackgroundResource(R.drawable.textstyletrue);
        } else if (listBuffer.contains(KeyWord)){
//            this.f001 = viewLocatedAt(textButton2).y - (pr1.getHeight()/4 );
//            LineY_1.clear();
//            LineY_1.add(f001);
//            this.ListCoordinateX_1.removeAll(ListCoordinateX_1);
            ListXUpFull();
            setCounter(getCounter()-1);
            score.setText(""+getCounter());
            Toast.makeText(this, "Повтор слова, такое уже есть", Toast.LENGTH_SHORT).show();
            textButton1.setBackgroundResource(R.drawable.textstyle_false);
        }  else  {
//            this.f001 = viewLocatedAt(textButton2).y - (pr1.getHeight()/4 );
//            LineY_1.clear();
//            LineY_1.add(f001);
//            this.ListCoordinateX_1.removeAll(ListCoordinateX_1);
            ListXUpFull();
            setCounter(getCounter()-1);
            score.setText(""+getCounter());
            textButton1.setBackgroundResource(R.drawable.textstyle_false);
        }
        EneblendButtonsAffterPress();
        listBuffer.add(KeyWord);
        MainListWord.removeAll(MainListWord);
        textSee.setText(String.valueOf(MainListWord));
        setTextFlag(2);
        textButton2.setEnabled(true);
        textButton2.setText("Собери слово");
        textButton1.setEnabled(false);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Chek_2(View v){
        String[] ArrayListWord = MainListWord.toArray(new String[0]);
        String KeyWord = (String.join("", ArrayListWord));
        if (listControl.contains(KeyWord) && !listBuffer.contains(KeyWord)) {
            ListXUpFull();
            HowScore(ArrayListWord.length);
            score.setText(""+getCounter());
            textButton2.setBackgroundResource(R.drawable.textstyletrue);
        } else if (listBuffer.contains(KeyWord)){
            ListXUpFull();
            setCounter(getCounter()-1);
            score.setText(""+getCounter());
            Toast.makeText(this, "Повтор слова, такое уже есть", Toast.LENGTH_SHORT).show();
            textButton2.setBackgroundResource(R.drawable.textstyle_false);
        }  else  {
            ListXUpFull();
            setCounter(getCounter()-1);
            score.setText(""+getCounter());
            textButton2.setBackgroundResource(R.drawable.textstyle_false);
        }
        EneblendButtonsAffterPress();
        listBuffer.add(KeyWord);
        MainListWord.removeAll(MainListWord);
        textSee.setText(String.valueOf(MainListWord));
        setTextFlag(3);
        textButton3.setEnabled(true);
        textButton3.setText("Собери слово");
        textButton2.setEnabled(false);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Chek_3(View v){
        String[] ArrayListWord = MainListWord.toArray(new String[0]);
        String KeyWord = (String.join("", ArrayListWord));
        if (listControl.contains(KeyWord) && !listBuffer.contains(KeyWord)) {
            ListXUpFull();
            HowScore(ArrayListWord.length);
            score.setText(""+getCounter());
            textButton3.setBackgroundResource(R.drawable.textstyletrue);
        } else if (listBuffer.contains(KeyWord)){
            ListXUpFull();
            setCounter(getCounter()-1);
            score.setText(""+getCounter());
            Toast.makeText(this, "Повтор слова, такое уже есть", Toast.LENGTH_SHORT).show();
            textButton3.setBackgroundResource(R.drawable.textstyle_false);
        }  else  {
            ListXUpFull();
            setCounter(getCounter()-1);
            score.setText(""+getCounter());
            textButton3.setBackgroundResource(R.drawable.textstyle_false);
        }
        EneblendButtonsAffterPress();
        listBuffer.add(KeyWord);
        MainListWord.removeAll(MainListWord);
        textSee.setText(String.valueOf(MainListWord));
        setTextFlag(4);
        textButton4.setEnabled(true);
        textButton4.setText("Собери слово");
        textButton3.setEnabled(false);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Chek_4(View v){
        String[] ArrayListWord = MainListWord.toArray(new String[0]);
        String KeyWord = (String.join("", ArrayListWord));
        if (listControl.contains(KeyWord) && !listBuffer.contains(KeyWord)) {
            ListXUpFull();
            HowScore(ArrayListWord.length);
            score.setText(""+getCounter());
            textButton4.setBackgroundResource(R.drawable.textstyletrue);
        } else if (listBuffer.contains(KeyWord)){
            ListXUpFull();
            setCounter(getCounter()-1);
            score.setText(""+getCounter());
            Toast.makeText(this, "Повтор слова, такое уже есть", Toast.LENGTH_SHORT).show();
            textButton4.setBackgroundResource(R.drawable.textstyle_false);
        }  else  {
            ListXUpFull();
            setCounter(getCounter()-1);
            score.setText(""+getCounter());
            textButton4.setBackgroundResource(R.drawable.textstyle_false);
        }
        EneblendButtonsAffterPress();
        listBuffer.add(KeyWord);
        MainListWord.removeAll(MainListWord);
        textSee.setText(String.valueOf(MainListWord));
        setTextFlag(5);
        textButton5.setEnabled(true);
        textButton5.setText("Собери слово");
        textButton4.setEnabled(false);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Chek_5(View v){
        String[] ArrayListWord = MainListWord.toArray(new String[0]);
        String KeyWord = (String.join("", ArrayListWord));
        if (listControl.contains(KeyWord) && !listBuffer.contains(KeyWord)) {
            ListXUpFull();
            HowScore(ArrayListWord.length);
            score.setText(""+getCounter());
            textButton5.setBackgroundResource(R.drawable.textstyletrue);
        } else if (listBuffer.contains(KeyWord)){
            ListXUpFull();
            setCounter(getCounter()-1);
            score.setText(""+getCounter());
            Toast.makeText(this, "Повтор слова, такое уже есть", Toast.LENGTH_SHORT).show();
            textButton5.setBackgroundResource(R.drawable.textstyle_false);
        }  else  {
            ListXUpFull();
            setCounter(getCounter()-1);
            score.setText(""+getCounter());
            textButton5.setBackgroundResource(R.drawable.textstyle_false);
        }
        EneblendButtonsAffterPress();
        listBuffer.add(KeyWord);
        MainListWord.removeAll(MainListWord);
        textSee.setText(String.valueOf(MainListWord));
        setTextFlag(6);
        textButton6.setEnabled(true);
        textButton6.setText("Собери слово");
        textButton5.setEnabled(false);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Chek_6(View v){
        String[] ArrayListWord = MainListWord.toArray(new String[0]);
        String KeyWord = (String.join("", ArrayListWord));
        if (listControl.contains(KeyWord) && !listBuffer.contains(KeyWord)) {
            ListXUpFull();
            HowScore(ArrayListWord.length);
            score.setText(""+getCounter());
            textButton6.setBackgroundResource(R.drawable.textstyletrue);
        } else if (listBuffer.contains(KeyWord)){
            ListXUpFull();
            setCounter(getCounter()-1);
            score.setText(""+getCounter());
            Toast.makeText(this, "Повтор слова, такое уже есть", Toast.LENGTH_SHORT).show();
            textButton6.setBackgroundResource(R.drawable.textstyle_false);
        }  else  {
            ListXUpFull();
            setCounter(getCounter()-1);
            score.setText(""+getCounter());
            textButton6.setBackgroundResource(R.drawable.textstyle_false);
        }
        EneblendButtonsAffterPress();
        listBuffer.add(KeyWord);
        MainListWord.removeAll(MainListWord);
        textSee.setText(String.valueOf(MainListWord));
        setTextFlag(7);
        textButton7.setEnabled(true);
        textButton7.setText("Собери слово");
        textButton6.setEnabled(false);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Chek_7(View v){
        String[] ArrayListWord = MainListWord.toArray(new String[0]);
        String KeyWord = (String.join("", ArrayListWord));
        if (listControl.contains(KeyWord) && !listBuffer.contains(KeyWord)) {
            ListXUpFull();
            HowScore(ArrayListWord.length);
            score.setText(""+getCounter());
            textButton7.setBackgroundResource(R.drawable.textstyletrue);
        } else if (listBuffer.contains(KeyWord)){
            ListXUpFull();
            setCounter(getCounter()-1);
            score.setText(""+getCounter());
            Toast.makeText(this, "Повтор слова, такое уже есть", Toast.LENGTH_SHORT).show();
            textButton7.setBackgroundResource(R.drawable.textstyle_false);
        }  else  {
            ListXUpFull();
            setCounter(getCounter()-1);
            score.setText(""+getCounter());
            textButton7.setBackgroundResource(R.drawable.textstyle_false);
        }
        EneblendButtonsAffterPress();
        listBuffer.add(KeyWord);
        MainListWord.removeAll(MainListWord);
        textSee.setText(String.valueOf(MainListWord));
        setTextFlag(8);
        textButton8.setEnabled(true);
        textButton8.setText("Собери слово");
        textButton7.setEnabled(false);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Chek_8(View v){
        String[] ArrayListWord = MainListWord.toArray(new String[0]);
        String KeyWord = (String.join("", ArrayListWord));
        if (listControl.contains(KeyWord) && !listBuffer.contains(KeyWord)) {
            ListXUpFull();
            HowScore(ArrayListWord.length);
            score.setText(""+getCounter());
            textButton8.setBackgroundResource(R.drawable.textstyletrue);
        } else if (listBuffer.contains(KeyWord)){
            ListXUpFull();
            setCounter(getCounter()-1);
            score.setText(""+getCounter());
            Toast.makeText(this, "Повтор слова, такое уже есть", Toast.LENGTH_SHORT).show();
            textButton8.setBackgroundResource(R.drawable.textstyle_false);
        }  else  {
            ListXUpFull();
            setCounter(getCounter()-1);
            score.setText(""+getCounter());
            textButton8.setBackgroundResource(R.drawable.textstyle_false);
        }
        EneblendButtonsAffterPress();
        listBuffer.add(KeyWord);
        MainListWord.removeAll(MainListWord);
        textSee.setText(String.valueOf(MainListWord));
        setTextFlag(9);
        textButton9.setEnabled(true);
        textButton9.setText("Собери слово");
        textButton8.setEnabled(false);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Chek_9(View v){
        String[] ArrayListWord = MainListWord.toArray(new String[0]);
        String KeyWord = (String.join("", ArrayListWord));
        if (listControl.contains(KeyWord) && !listBuffer.contains(KeyWord)) {
            ListXUpFull();
            HowScore(ArrayListWord.length);
            score.setText(""+getCounter());
            textButton9.setBackgroundResource(R.drawable.textstyletrue);
        } else if (listBuffer.contains(KeyWord)){
            ListXUpFull();
            setCounter(getCounter()-1);
            score.setText(""+getCounter());
            Toast.makeText(this, "Повтор слова, такое уже есть", Toast.LENGTH_SHORT).show();
            textButton9.setBackgroundResource(R.drawable.textstyle_false);
        }  else  {
            ListXUpFull();
            setCounter(getCounter()-1);
            score.setText(""+getCounter());
            textButton9.setBackgroundResource(R.drawable.textstyle_false);
        }
        EneblendButtonsAffterPress();
        listBuffer.add(KeyWord);
        MainListWord.removeAll(MainListWord);
        textSee.setText(String.valueOf(MainListWord));
        setTextFlag(10);
        textButton10.setEnabled(true);
        textButton10.setText("Собери слово");
        textButton9.setEnabled(false);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Chek_10(View v){
        String[] ArrayListWord = MainListWord.toArray(new String[0]);
        String KeyWord = (String.join("", ArrayListWord));
        if (listControl.contains(KeyWord) && !listBuffer.contains(KeyWord)) {
            ListXUpFull();
            HowScore(ArrayListWord.length);
            score.setText(""+getCounter());
            textButton10.setBackgroundResource(R.drawable.textstyletrue);
        } else if (listBuffer.contains(KeyWord)){
            ListXUpFull();
            setCounter(getCounter()-1);
            score.setText(""+getCounter());
            Toast.makeText(this, "Повтор слова, такое уже есть", Toast.LENGTH_SHORT).show();
            textButton10.setBackgroundResource(R.drawable.textstyle_false);
        }  else  {
            ListXUpFull();
            setCounter(getCounter()-1);
            score.setText(""+getCounter());
            textButton10.setBackgroundResource(R.drawable.textstyle_false);
        }
        EneblendButtonsAffterPress();
        listBuffer.add(KeyWord);
        MainListWord.removeAll(MainListWord);
        textSee.setText(String.valueOf(MainListWord));
        textButton10.setEnabled(false);
    }
//    @RequiresApi(api = Build.VERSION_CODES.O)
//    public void Chek_2(View v){
//        String[] ArrayListWord = MainListWord.toArray(new String[0]);
//        String KeyWord = (String.join("", ArrayListWord));
//        if (listControl.contains(KeyWord) && !listBuffer.contains(KeyWord)) {
////            this.LineY_1.remove(0);
////            this.LineY_1.add(1620);
//            this.f001 = viewLocatedAt(textView4).y - (pr1.getHeight()/4 );
//            LineY_1.clear();
//            LineY_1.add(f001);
//            this.ListCoordinateX_1.removeAll(ListCoordinateX_1);
//            ListXUpFull();
//            chek2.setBackgroundResource(R.drawable.thrue);
//            HowScore(ArrayListWord.length);
//            score.setText(""+getCounter());
//        } else if (listBuffer.contains(KeyWord)){
////            this.LineY_1.remove(0);
////            this.LineY_1.add(1620);
//            this.f001 = viewLocatedAt(textView4).y - (pr1.getHeight()/4 );
//            LineY_1.clear();
//            LineY_1.add(f001);
//            this.ListCoordinateX_1.removeAll(ListCoordinateX_1);
//            ListXUpFull();
//            chek2.setBackgroundResource(R.drawable.wrong);
//            Toast.makeText(this, "Повтор слова, такое уже есть", Toast.LENGTH_SHORT).show();
//            setCounter(getCounter()-1);
//            score.setText(""+getCounter());
//        }  else  {
////            this.LineY_1.remove(0);
////            this.LineY_1.add(1620);
//            this.f001 = viewLocatedAt(textView4).y - (pr1.getHeight()/4 );
//            LineY_1.clear();
//            LineY_1.add(f001);
//            this.ListCoordinateX_1.removeAll(ListCoordinateX_1);
//            ListXUpFull();
//            chek2.setBackgroundResource(R.drawable.wrong);
//            setCounter(getCounter()-1);
//            score.setText(""+getCounter());
//        }
//        EneblendButtonsAffterPress();
//        listBuffer.add(KeyWord);
//        MainListWord.removeAll(MainListWord);
//        textSee.setText(String.valueOf(MainListWord));
//    }
//    @RequiresApi(api = Build.VERSION_CODES.O)
//    public void Chek_3(View v){
//        String[] ArrayListWord = MainListWord.toArray(new String[0]);
//        String KeyWord = (String.join("", ArrayListWord));
//        if (listControl.contains(KeyWord) && !listBuffer.contains(KeyWord)) {
////            this.LineY_1.remove(0);
////            this.LineY_1.add(1820);
//            this.f001 = viewLocatedAt(textView4).y - (pr1.getHeight()/4 );
//            LineY_1.clear();
//            LineY_1.add(f001);
//            this.ListCoordinateX_1.removeAll(ListCoordinateX_1);
//            ListXUpFull();
//            chek3.setBackgroundResource(R.drawable.thrue);
//            HowScore(ArrayListWord.length);
//            score.setText(""+getCounter());
//        } else if (listBuffer.contains(KeyWord)){
////            this.LineY_1.remove(0);
////            this.LineY_1.add(1820);
//            this.f001 = viewLocatedAt(textView4).y - (pr1.getHeight()/4 );
//            LineY_1.clear();
//            LineY_1.add(f001);
//            this.ListCoordinateX_1.removeAll(ListCoordinateX_1);
//            ListXUpFull();
//            chek3.setBackgroundResource(R.drawable.wrong);
//            Toast.makeText(this, "Повтор слова, такое уже есть", Toast.LENGTH_SHORT).show();
//            setCounter(getCounter()-1);
//            score.setText(""+getCounter());
//        }  else  {
////            this.LineY_1.remove(0);
////            this.LineY_1.add(1820);
//            this.f001 = viewLocatedAt(textView4).y - (pr1.getHeight()/4 );
//            LineY_1.clear();
//            LineY_1.add(f001);
//            this.ListCoordinateX_1.removeAll(ListCoordinateX_1);
//            ListXUpFull();
//            chek3.setBackgroundResource(R.drawable.wrong);
//            setCounter(getCounter()-1);
//            score.setText(""+getCounter());
//        }
//        EneblendButtonsAffterPress();
//        listBuffer.add(KeyWord);
//        MainListWord.removeAll(MainListWord);
//        textSee.setText(String.valueOf(MainListWord));
//    }
//    @RequiresApi(api = Build.VERSION_CODES.O)
//    public void Chek_4(View v){
//        String[] ArrayListWord = MainListWord.toArray(new String[0]);
//        String KeyWord = (String.join("", ArrayListWord));
//        if (listControl.contains(KeyWord) && !listBuffer.contains(KeyWord)) {
////            this.LineY_1.remove(0);
////            this.LineY_1.add(2020);
//            this.ListCoordinateX_1.removeAll(ListCoordinateX_1);
//            ListXUpFull();
//            chek4.setBackgroundResource(R.drawable.thrue);
//            HowScore(ArrayListWord.length);
//            score.setText(""+getCounter());
//        } else if (listBuffer.contains(KeyWord)){
////            this.LineY_1.remove(0);
////            this.LineY_1.add(2020);
//            this.ListCoordinateX_1.removeAll(ListCoordinateX_1);
//            ListXUpFull();
//            chek4.setBackgroundResource(R.drawable.wrong);
//            Toast.makeText(this, "Повтор слова, такое уже есть", Toast.LENGTH_SHORT).show();
//            setCounter(getCounter()-1);
//            score.setText(""+getCounter());
//        }  else  {
////            this.LineY_1.remove(0);
////            this.LineY_1.add(2020);
//            this.ListCoordinateX_1.removeAll(ListCoordinateX_1);
//            ListXUpFull();
//            chek4.setBackgroundResource(R.drawable.wrong);
//            setCounter(getCounter()-1);
//            score.setText(""+getCounter());
//        }
//        EneblendButtonsAffterPress();
//        listBuffer.add(KeyWord);
//        MainListWord.removeAll(MainListWord);
//        textSee.setText(String.valueOf(MainListWord));
//    }
    protected void EneblendButtonsAffterPress(){
        pr1.setEnabled(true);
        pr1.setBackgroundResource(R.drawable.forlessbutton);
        pr2.setEnabled(true);
        pr2.setBackgroundResource(R.drawable.forlessbutton);
        pr3.setEnabled(true);
        pr3.setBackgroundResource(R.drawable.forlessbutton);
        pr4.setEnabled(true);
        pr4.setBackgroundResource(R.drawable.forlessbutton);
        pr5.setEnabled(true);
        pr5.setBackgroundResource(R.drawable.forlessbutton);
        pr6.setEnabled(true);
        pr6.setBackgroundResource(R.drawable.forlessbutton);
        pr7.setEnabled(true);
        pr7.setBackgroundResource(R.drawable.forlessbutton);
        pr8.setEnabled(true);
        pr8.setBackgroundResource(R.drawable.forlessbutton);
        pr9.setEnabled(true);
        pr9.setBackgroundResource(R.drawable.forlessbutton);
        pr10.setEnabled(true);
        pr10.setBackgroundResource(R.drawable.forlessbutton);
        pr11.setEnabled(true);
        pr11.setBackgroundResource(R.drawable.forlessbutton);
        pr12.setEnabled(true);
        pr12.setBackgroundResource(R.drawable.forlessbutton);
        pr13.setEnabled(true);
        pr13.setBackgroundResource(R.drawable.forlessbutton);
        pr14.setEnabled(true);
        pr14.setBackgroundResource(R.drawable.forlessbutton);
    } //кнопки снова активны и имеют исходный стиль

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Creates(){
        button1 = ObjectAnimator.ofPropertyValuesHolder(pr1,
                PropertyValuesHolder.ofFloat("x", 0, 850),
                PropertyValuesHolder.ofFloat("y", 140, 1050));
        button1.setDuration(9000);
        button1.setRepeatCount(ObjectAnimator.INFINITE);
        button1.setRepeatMode(ObjectAnimator.REVERSE);
//        button1.start();
//2 кнопка
        button2 = ObjectAnimator.ofPropertyValuesHolder(pr2,
                PropertyValuesHolder.ofFloat("x", 200, 400),
                PropertyValuesHolder.ofFloat("y", 140, 1050));
        button2.setDuration(4400 +  getSpeed());
        button2.setRepeatCount(ObjectAnimator.INFINITE);
        button2.setRepeatMode(ObjectAnimator.REVERSE);
//        button2.start();
//3 кнопка
        button3 = ObjectAnimator.ofPropertyValuesHolder(pr3,
                PropertyValuesHolder.ofFloat("x", 0, 910),
                PropertyValuesHolder.ofFloat("y", 140, 140));
        button3.setDuration(5000 +  getSpeed());
        button3.setRepeatCount(ObjectAnimator.INFINITE);
        button3.setRepeatMode(ObjectAnimator.REVERSE);
//        button3.start();
//4 кнопка
        button4 = ObjectAnimator.ofPropertyValuesHolder(pr4,
                PropertyValuesHolder.ofFloat("x", 0, 910),
                PropertyValuesHolder.ofFloat("y", 500, 500));
        button4.setDuration(4600 +  getSpeed());
        button4.setRepeatCount(ObjectAnimator.INFINITE);
        button4.setRepeatMode(ObjectAnimator.REVERSE);
//        button4.start();
//5 кнопка
        button5 = ObjectAnimator.ofPropertyValuesHolder(pr5,
                PropertyValuesHolder.ofFloat("x", 0, 910),
                PropertyValuesHolder.ofFloat("y", 900, 900));
        button5.setDuration(5300 +  getSpeed());
        button5.setRepeatCount(ObjectAnimator.INFINITE);
        button5.setRepeatMode(ObjectAnimator.REVERSE);
//        button5.start();
//6 кнопка
        button6 = ObjectAnimator.ofPropertyValuesHolder(pr6,
                PropertyValuesHolder.ofFloat("x", 910, 0),
                PropertyValuesHolder.ofFloat("y", 300, 300));
        button6.setDuration(5600 +  getSpeed());
        button6.setRepeatCount(ObjectAnimator.INFINITE);
        button6.setRepeatMode(ObjectAnimator.REVERSE);
//        button6.start();
//7 кнопка
        button7 = ObjectAnimator.ofPropertyValuesHolder(pr7,
                PropertyValuesHolder.ofFloat("x", 910, 0),
                PropertyValuesHolder.ofFloat("y", 700, 700));
        button7.setDuration(4400 +  getSpeed());
        button7.setRepeatCount(ObjectAnimator.INFINITE);
        button7.setRepeatMode(ObjectAnimator.REVERSE);
//        button7.start();
//8 кнопка
        button8 = ObjectAnimator.ofPropertyValuesHolder(pr8,
                PropertyValuesHolder.ofFloat("x", 200, 650),
                PropertyValuesHolder.ofFloat("y", 1050, 140));
        button8.setDuration(3900 +  getSpeed());
        button8.setRepeatCount(ObjectAnimator.INFINITE);
        button8.setRepeatMode(ObjectAnimator.REVERSE);
//        button8.start();
//9 кнопка не настроил
        button9 = ObjectAnimator.ofPropertyValuesHolder(pr9,
                PropertyValuesHolder.ofFloat("x", 800, 800),
                PropertyValuesHolder.ofFloat("y", 1050, 140));
        button9.setDuration(4100 +  getSpeed());
        button9.setRepeatCount(ObjectAnimator.INFINITE);
        button9.setRepeatMode(ObjectAnimator.REVERSE);
//        button9.start();
//10 кнопка
        button10 = ObjectAnimator.ofPropertyValuesHolder(pr10,
                PropertyValuesHolder.ofFloat("x", 0, 250),
                PropertyValuesHolder.ofFloat("y", 1050, 140));
        button10.setDuration(4500 +  getSpeed());
        button10.setRepeatCount(ObjectAnimator.INFINITE);
        button10.setRepeatMode(ObjectAnimator.REVERSE);
//        button10.start();
//11 кнопка
        button11 = ObjectAnimator.ofPropertyValuesHolder(pr11,
                PropertyValuesHolder.ofFloat("x", 910, 100),
                PropertyValuesHolder.ofFloat("y", 140, 950));
        button11.setDuration(5700 +  getSpeed());
        button11.setRepeatCount(ObjectAnimator.INFINITE);
        button11.setRepeatMode(ObjectAnimator.REVERSE);
//        button11.start();
//12 кнопка
        button12 = ObjectAnimator.ofPropertyValuesHolder(pr12,
                PropertyValuesHolder.ofFloat("x", 700, 400),
                PropertyValuesHolder.ofFloat("y", 140, 1050));
        button12.setDuration(3600 +  getSpeed());
        button12.setRepeatCount(ObjectAnimator.INFINITE);
        button12.setRepeatMode(ObjectAnimator.REVERSE);
//        button12.start();

//13 кнопка
        button13 = ObjectAnimator.ofPropertyValuesHolder(pr13,
                PropertyValuesHolder.ofFloat("x", 910, 0),
                PropertyValuesHolder.ofFloat("y", 1100, 1050));
        button13.setDuration(5100 +  getSpeed());
        button13.setRepeatCount(ObjectAnimator.INFINITE);
        button13.setRepeatMode(ObjectAnimator.REVERSE);
//        button13.start();
//14 кнопка
        button14 = ObjectAnimator.ofPropertyValuesHolder(pr14,
                PropertyValuesHolder.ofFloat("x", 500, 500),
                PropertyValuesHolder.ofFloat("y", 140, 1050));
        button14.setDuration(4800 +  getSpeed());
        button14.setRepeatCount(ObjectAnimator.INFINITE);
        button14.setRepeatMode(ObjectAnimator.REVERSE);
//        button14.start();

//рерзевное создание через XML
//        set1 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper1); // диагональ, с 0
//        set2 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper2); // лево У 100, с0
//        set3 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper3); // верх, Х 30    с 1
//        set4 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper4); // низ   Х 350      с 1
//        set5 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper5); // прав
//        set6 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper1); // диагональ, с 0
//        set7 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper2); // лево У 100, с0
//        set8 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper3); // верх, Х 30    с 1
//        set9 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper4); // низ   Х 350      с 1
//        set10 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper5); // прав
//        set11 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper11); // диагональ, с 0
//        set12 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper2); // лево У 100, с0
//        set13 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper3); // верх, Х 30    с 1
//        set14 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper4); // низ   Х 350      с 1
//        //set1.setTarget(pr1);
//        set2.setTarget(pr2);
//        set3.setTarget(pr3);
//        set4.setTarget(pr4);
//        set5.setTarget(pr5);
//        set6.setTarget(pr6);
//        set7.setTarget(pr7);
//        set8.setTarget(pr8);
//        set9.setTarget(pr9);
//        set10.setTarget(pr10);
//        set11.setTarget(pr11);
//        set12.setTarget(pr12);
//        set13.setTarget(pr13);
//        set14.setTarget(pr14);
//        //set1.start();
//        set2.start();
//        set3.start();
////        set4.start();
////        set5.start();
////       set6.start();
////       set7.start();
////       set8.start();
////       set9.start();
////       set10.start();
//        set11.start();
////        set12.start();
////        set13.start();
////        set14.start();   ht

    } //движение кнопок

    protected void SwitchTextField(){
        switch(getTextFlag()){
            case 1:
                textButton1.setText(String.valueOf(MainListWord));
                break;
            case 2:
                textButton2.setText(String.valueOf(MainListWord));
                break;
            case 3:
                textButton3.setText(String.valueOf(MainListWord));
                break;
            case 4:
                textButton4.setText(String.valueOf(MainListWord));
                break;
            case 5:
                textButton5.setText(String.valueOf(MainListWord));
                break;
            case 6:
                textButton6.setText(String.valueOf(MainListWord));
                break;
            case 7:
                textButton7.setText(String.valueOf(MainListWord));
                break;
            case 8:
                textButton8.setText(String.valueOf(MainListWord));
                break;
            case 9:
                textButton9.setText(String.valueOf(MainListWord));
                break;
            case 10:
                textButton10.setText(String.valueOf(MainListWord));
                break;
        }
    } // изменение флага печати текста
    public void ClickButton1(View v){

        copy_pr1 = new Button(getApplicationContext());
        copy_pr1.setBackgroundResource(R.drawable.newpate);
        copy_pr1.setText(pr1.getText().toString() );
        copy_pr1.setId(USERID + countID);
        Colo.addView(copy_pr1);
        countID++;
        final ObjectAnimator button_copy_button1 = ObjectAnimator.ofPropertyValuesHolder(copy_pr1,
                PropertyValuesHolder.ofFloat("x", ListCoordinateX_1.get(0)),
                PropertyValuesHolder.ofFloat("y", LineY_1.get(0)));
        button_copy_button1.setDuration(1500);
        button_copy_button1.start();

        ListCoordinateX_1.remove(0);

        MainListWord.add(pr1.getText().toString());
        pr1.setBackgroundResource(R.drawable.acceptbutton);
        pr1.setEnabled(false);
        textSee.setText(String.valueOf(MainListWord));

        button_copy_button1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                button_copy_button1.ofFloat(copy_pr1, "alpha", 0f).setDuration(600).start();
            }
            @Override
            public void onAnimationCancel(Animator animation) {
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        SwitchTextField();
        ListXUpFull();

    } //кнопка 1
    public void ClickButton2(View v){

        copy_pr2 = new Button(getApplicationContext());
        copy_pr2.setBackgroundResource(R.drawable.newpate);
        copy_pr2.setText(pr2.getText().toString() );

        copy_pr2.setId(USERID + countID);
        Colo.addView(copy_pr2);
        countID++;
        final ObjectAnimator button_copy_button2 = ObjectAnimator.ofPropertyValuesHolder(copy_pr2,
                PropertyValuesHolder.ofFloat("x", ListCoordinateX_1.get(0)),
                PropertyValuesHolder.ofFloat("y", LineY_1.get(0)));
        button_copy_button2.setDuration(1500);
        button_copy_button2.start();
        ListCoordinateX_1.remove(0);

        MainListWord.add(pr2.getText().toString());
        pr2.setBackgroundResource(R.drawable.acceptbutton);
        pr2.setEnabled(false);
        textSee.setText(String.valueOf(MainListWord));

        button_copy_button2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                button_copy_button2.ofFloat(copy_pr2, "alpha", 0f).setDuration(600).start();
            }
            @Override
            public void onAnimationCancel(Animator animation) {
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        SwitchTextField();
        ListXUpFull();
    } //кнопка 2
    public void ClickButton3(View v){
        copy_pr3 = new Button(getApplicationContext());
        copy_pr3.setBackgroundResource(R.drawable.newpate);
        copy_pr3.setText(pr3.getText().toString() );

        copy_pr3.setId(USERID + countID);
        Colo.addView(copy_pr3);
        countID++;
        final ObjectAnimator button_copy_button3 = ObjectAnimator.ofPropertyValuesHolder(copy_pr3,
                PropertyValuesHolder.ofFloat("x", ListCoordinateX_1.get(0)),
                PropertyValuesHolder.ofFloat("y", LineY_1.get(0)));
        button_copy_button3.setDuration(1500);
        button_copy_button3.start();
        ListCoordinateX_1.remove(0);

        MainListWord.add(pr3.getText().toString());
        pr3.setBackgroundResource(R.drawable.acceptbutton);
        pr3.setEnabled(false);
        textSee.setText(String.valueOf(MainListWord));

        button_copy_button3.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                button_copy_button3.ofFloat(copy_pr3, "alpha", 0f).setDuration(600).start();
            }
            @Override
            public void onAnimationCancel(Animator animation) {
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        SwitchTextField();
        ListXUpFull();
    } //кнопка 3
    public void ClickButton4(View v){
        copy_pr4 = new Button(getApplicationContext());
        copy_pr4.setBackgroundResource(R.drawable.newpate);
        copy_pr4.setText(pr4.getText().toString() );

        copy_pr4.setId(USERID + countID);
        Colo.addView(copy_pr4);
        countID++;
        final ObjectAnimator button_copy_button4 = ObjectAnimator.ofPropertyValuesHolder(copy_pr4,
                PropertyValuesHolder.ofFloat("x", ListCoordinateX_1.get(0)),
                PropertyValuesHolder.ofFloat("y", LineY_1.get(0)));
        button_copy_button4.setDuration(1500);
        button_copy_button4.start();
        ListCoordinateX_1.remove(0);

        MainListWord.add(pr4.getText().toString());
        pr4.setBackgroundResource(R.drawable.acceptbutton);
        pr4.setEnabled(false);
        textSee.setText(String.valueOf(MainListWord));

        button_copy_button4.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                button_copy_button4.ofFloat(copy_pr4, "alpha", 0f).setDuration(600).start();
            }
            @Override
            public void onAnimationCancel(Animator animation) {
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        SwitchTextField();
        ListXUpFull();
    } //кнопка 4
    public void ClickButton5(View v){
        copy_pr5 = new Button(getApplicationContext());
        copy_pr5.setBackgroundResource(R.drawable.newpate);
        copy_pr5.setText(pr5.getText().toString() );

        copy_pr5.setId(USERID + countID);
        Colo.addView(copy_pr5);
        countID++;
        final ObjectAnimator button_copy_button5 = ObjectAnimator.ofPropertyValuesHolder(copy_pr5,
                PropertyValuesHolder.ofFloat("x", ListCoordinateX_1.get(0)),
                PropertyValuesHolder.ofFloat("y", LineY_1.get(0)));
        button_copy_button5.setDuration(1500);
        button_copy_button5.start();
        ListCoordinateX_1.remove(0);

        MainListWord.add(pr5.getText().toString());
        pr5.setBackgroundResource(R.drawable.acceptbutton);
        pr5.setEnabled(false);
        textSee.setText(String.valueOf(MainListWord));

        button_copy_button5.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                button_copy_button5.ofFloat(copy_pr5, "alpha", 0f).setDuration(600).start();
            }
            @Override
            public void onAnimationCancel(Animator animation) {
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        SwitchTextField();
        ListXUpFull();
    } //кнопка 5
    public void ClickButton6(View v){
        copy_pr6 = new Button(getApplicationContext());
        copy_pr6.setBackgroundResource(R.drawable.newpate);
        copy_pr6.setText(pr6.getText().toString() );

        copy_pr6.setId(USERID + countID);
        Colo.addView(copy_pr6);
        countID++;
        final ObjectAnimator button_copy_button6 = ObjectAnimator.ofPropertyValuesHolder(copy_pr6,
                PropertyValuesHolder.ofFloat("x", ListCoordinateX_1.get(0)),
                PropertyValuesHolder.ofFloat("y", LineY_1.get(0)));
        button_copy_button6.setDuration(1500);
        button_copy_button6.start();
        ListCoordinateX_1.remove(0);

        MainListWord.add(pr6.getText().toString());
        pr6.setBackgroundResource(R.drawable.acceptbutton);
        pr6.setEnabled(false);
        textSee.setText(String.valueOf(MainListWord));

        button_copy_button6.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                button_copy_button6.ofFloat(copy_pr6, "alpha", 0f).setDuration(600).start();
            }
            @Override
            public void onAnimationCancel(Animator animation) {
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        SwitchTextField();
        ListXUpFull();
    } //кнопка 6
    public void ClickButton7(View v){
        copy_pr7 = new Button(getApplicationContext());
        copy_pr7.setBackgroundResource(R.drawable.newpate);
        copy_pr7.setText(pr7.getText().toString() );

        copy_pr7.setId(USERID + countID);
        Colo.addView(copy_pr7);
        countID++;
        final ObjectAnimator button_copy_button7 = ObjectAnimator.ofPropertyValuesHolder(copy_pr7,
                PropertyValuesHolder.ofFloat("x", ListCoordinateX_1.get(0)),
                PropertyValuesHolder.ofFloat("y", LineY_1.get(0)));
        button_copy_button7.setDuration(1500);
        button_copy_button7.start();
        ListCoordinateX_1.remove(0);

        MainListWord.add(pr7.getText().toString());
        pr7.setBackgroundResource(R.drawable.acceptbutton);
        pr7.setEnabled(false);
        textSee.setText(String.valueOf(MainListWord));

        button_copy_button7.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                button_copy_button7.ofFloat(copy_pr7, "alpha", 0f).setDuration(600).start();
            }
            @Override
            public void onAnimationCancel(Animator animation) {
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        SwitchTextField();
        ListXUpFull();
    } //кнопка 7
    public void ClickButton8(View v){
        copy_pr8 = new Button(getApplicationContext());
        copy_pr8.setBackgroundResource(R.drawable.newpate);
        copy_pr8.setText(pr8.getText().toString() );

        copy_pr8.setId(USERID + countID);
        Colo.addView(copy_pr8);
        countID++;
        final ObjectAnimator button_copy_button8 = ObjectAnimator.ofPropertyValuesHolder(copy_pr8,
                PropertyValuesHolder.ofFloat("x", ListCoordinateX_1.get(0)),
                PropertyValuesHolder.ofFloat("y", LineY_1.get(0)));
        button_copy_button8.setDuration(1500);
        button_copy_button8.start();
        ListCoordinateX_1.remove(0);

        MainListWord.add(pr8.getText().toString());
        pr8.setBackgroundResource(R.drawable.acceptbutton);
        pr8.setEnabled(false);
        textSee.setText(String.valueOf(MainListWord));

        button_copy_button8.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                button_copy_button8.ofFloat(copy_pr8, "alpha", 0f).setDuration(600).start();
            }
            @Override
            public void onAnimationCancel(Animator animation) {
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        SwitchTextField();
        ListXUpFull();
    } //кнопка 8
    public void ClickButton9(View v){
        copy_pr9 = new Button(getApplicationContext());
        copy_pr9.setBackgroundResource(R.drawable.newpate);
        copy_pr9.setText(pr9.getText().toString() );

        copy_pr9.setId(USERID + countID);
        Colo.addView(copy_pr9);
        countID++;
        final ObjectAnimator button_copy_button9 = ObjectAnimator.ofPropertyValuesHolder(copy_pr9,
                PropertyValuesHolder.ofFloat("x", ListCoordinateX_1.get(0)),
                PropertyValuesHolder.ofFloat("y", LineY_1.get(0)));
        button_copy_button9.setDuration(1500);
        button_copy_button9.start();
        ListCoordinateX_1.remove(0);

        MainListWord.add(pr9.getText().toString());
        pr9.setBackgroundResource(R.drawable.acceptbutton);
        pr9.setEnabled(false);
        textSee.setText(String.valueOf(MainListWord));

        button_copy_button9.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                button_copy_button9.ofFloat(copy_pr9, "alpha", 0f).setDuration(600).start();
            }
            @Override
            public void onAnimationCancel(Animator animation) {
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        SwitchTextField();
        ListXUpFull();
    } //кнопка 9
    public void ClickButton10(View v){
        copy_pr10 = new Button(getApplicationContext());
        copy_pr10.setBackgroundResource(R.drawable.newpate);
        copy_pr10.setText(pr10.getText().toString() );

        copy_pr10.setId(USERID + countID);
        Colo.addView(copy_pr10);
        countID++;
        final ObjectAnimator button_copy_button10 = ObjectAnimator.ofPropertyValuesHolder(copy_pr10,
                PropertyValuesHolder.ofFloat("x", ListCoordinateX_1.get(0)),
                PropertyValuesHolder.ofFloat("y", LineY_1.get(0)));
        button_copy_button10.setDuration(1500);
        button_copy_button10.start();
        ListCoordinateX_1.remove(0);

        MainListWord.add(pr10.getText().toString());
        pr10.setBackgroundResource(R.drawable.acceptbutton);
        pr10.setEnabled(false);
        textSee.setText(String.valueOf(MainListWord));

        button_copy_button10.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                button_copy_button10.ofFloat(copy_pr10, "alpha", 0f).setDuration(600).start();
            }
            @Override
            public void onAnimationCancel(Animator animation) {
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        SwitchTextField();
        ListXUpFull();
    } //кнопка 10
    public void ClickButton11(View v){
        copy_pr11 = new Button(getApplicationContext());
        copy_pr11.setBackgroundResource(R.drawable.newpate);
        copy_pr11.setText(pr11.getText().toString() );

        copy_pr11.setId(USERID + countID);
        Colo.addView(copy_pr11);
        countID++;
        final ObjectAnimator button_copy_button11 = ObjectAnimator.ofPropertyValuesHolder(copy_pr11,
                PropertyValuesHolder.ofFloat("x", ListCoordinateX_1.get(0)),
                PropertyValuesHolder.ofFloat("y", LineY_1.get(0)));
        button_copy_button11.setDuration(1500);
        button_copy_button11.start();
        ListCoordinateX_1.remove(0);

        MainListWord.add(pr11.getText().toString());
        pr11.setBackgroundResource(R.drawable.acceptbutton);
        pr11.setEnabled(false);
        textSee.setText(String.valueOf(MainListWord));

        button_copy_button11.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                button_copy_button11.ofFloat(copy_pr11, "alpha", 0f).setDuration(600).start();
            }
            @Override
            public void onAnimationCancel(Animator animation) {
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        SwitchTextField();
        ListXUpFull();
    } //кнопка 11
    public void ClickButton12(View v){
        copy_pr12 = new Button(getApplicationContext());
        copy_pr12.setBackgroundResource(R.drawable.newpate);
        copy_pr12.setText(pr12.getText().toString() );

        copy_pr12.setId(USERID + countID);
        Colo.addView(copy_pr12);
        countID++;
        final ObjectAnimator button_copy_button12 = ObjectAnimator.ofPropertyValuesHolder(copy_pr12,
                PropertyValuesHolder.ofFloat("x", ListCoordinateX_1.get(0)),
                PropertyValuesHolder.ofFloat("y", LineY_1.get(0)));
        button_copy_button12.setDuration(1500);
        button_copy_button12.start();
        ListCoordinateX_1.remove(0);

        MainListWord.add(pr12.getText().toString());
        pr12.setBackgroundResource(R.drawable.acceptbutton);
        pr12.setEnabled(false);
        textSee.setText(String.valueOf(MainListWord));

        button_copy_button12.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                button_copy_button12.ofFloat(copy_pr12, "alpha", 0f).setDuration(600).start();
            }
            @Override
            public void onAnimationCancel(Animator animation) {
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        SwitchTextField();
        ListXUpFull();
    } //кнопка 12
    public void ClickButton13(View v){
        copy_pr13 = new Button(getApplicationContext());
        copy_pr13.setBackgroundResource(R.drawable.newpate);
        copy_pr13.setText(pr13.getText().toString() );

        copy_pr13.setId(USERID + countID);
        Colo.addView(copy_pr13);
        countID++;
        final ObjectAnimator button_copy_button13 = ObjectAnimator.ofPropertyValuesHolder(copy_pr13,
                PropertyValuesHolder.ofFloat("x", ListCoordinateX_1.get(0)),
                PropertyValuesHolder.ofFloat("y", LineY_1.get(0)));
        button_copy_button13.setDuration(1500);
        button_copy_button13.start();
        ListCoordinateX_1.remove(0);

        MainListWord.add(pr13.getText().toString());
        pr13.setBackgroundResource(R.drawable.acceptbutton);
        pr13.setEnabled(false);
        textSee.setText(String.valueOf(MainListWord));

        button_copy_button13.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                button_copy_button13.ofFloat(copy_pr13, "alpha", 0f).setDuration(600).start();
            }
            @Override
            public void onAnimationCancel(Animator animation) {
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        SwitchTextField();
        ListXUpFull();
    } //кнопка 13
    public void ClickButton14(View v){
        copy_pr14 = new Button(getApplicationContext());
        copy_pr14.setBackgroundResource(R.drawable.newpate);
        copy_pr14.setText(pr14.getText().toString() );

        copy_pr14.setId(USERID + countID);
        Colo.addView(copy_pr14);
        countID++;
        final ObjectAnimator button_copy_button14 = ObjectAnimator.ofPropertyValuesHolder(copy_pr14,
                PropertyValuesHolder.ofFloat("x", ListCoordinateX_1.get(0)),
                PropertyValuesHolder.ofFloat("y", LineY_1.get(0)));
        button_copy_button14.setDuration(1500);
        button_copy_button14.start();
        ListCoordinateX_1.remove(0);

        MainListWord.add(pr14.getText().toString());
        pr14.setBackgroundResource(R.drawable.acceptbutton);
        pr14.setEnabled(false);
        textSee.setText(String.valueOf(MainListWord));

        button_copy_button14.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                button_copy_button14.ofFloat(copy_pr14, "alpha", 0f).setDuration(600).start();
            }
            @Override
            public void onAnimationCancel(Animator animation) {
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        SwitchTextField();
        ListXUpFull();
    } //кнопка 14

    public void ShowStats(View v){
        Dialogus();
    }

    public void Dialogus(){

        OptionDialog = new AlertDialog.Builder(this).create();
        OptionDialog.setTitle("Статистика");
        LayoutInflater li = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = li.inflate(R.layout.stats_fragment, null, false);
        but1 =  v.findViewById(R.id.but1);
        but2 =  v.findViewById(R.id.but2);
        but3 =  v.findViewById(R.id.but3);

        OptionDialog.setView(v);
        OptionDialog.setCancelable(true);

        but2.setBackgroundColor(Color.CYAN);
        but2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                OptionDialog.dismiss();
            }

        });

        but3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                but3.setBackgroundColor(Color.YELLOW);
            }
        });


        OptionDialog.show();
    }

}
