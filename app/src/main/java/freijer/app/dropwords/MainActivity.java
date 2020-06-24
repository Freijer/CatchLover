package freijer.app.dropwords;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.preference.PreferenceManager;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.ListView;
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

    ListView QuestList, QuestList2;


    ArrayList<String> Quest;
    ArrayList<String> Quest2;
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;


    TaskListing tasker = new TaskListing();
    Random rand = new Random();
    private int indexTask;
    protected String wordTask;
    protected ArrayList <String> listTask = new ArrayList <String>();



    protected Button butClose, butCloseTask, but2, but3;
    private AlertDialog OptionDialog;
    private AlertDialog TaskDialog;


    protected int textFlag;
    public int getTextFlag() {
        return textFlag;
    }
    public void setTextFlag(int textFlag) {
        this.textFlag = textFlag;
    }


    private int TestFlag = 1;

    public int getTestFlag() {
        return TestFlag;
    }

    public void setTestFlag(int testFlag) {
        TestFlag = testFlag;
    }

    protected int f001;
    protected int x002;

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

    protected TextView QAWord, textSee, textClock, score, textView2, textView3, textView4, task_1, task_2;
    protected TextView textButton1, textButton2, textButton3, textButton4, textButton5, textButton6, textButton7, textButton8, textButton9, textButton10;
    protected Button progress,  faq, task, start, starter, reset, pr1, pr2, pr3, pr4, pr5, pr6, pr7, pr8, pr9, pr10, pr11, pr12, pr13, pr14;
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
    protected Chronometer mChronometer;

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

    private int speed;
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }



    SharedPreferences sharedPreferences;

    protected int shiftLiterals =60;//миещние букв в лево
    private int defaultinterval;


    protected int list_2;
    protected int list_3;
    protected int list_4;
    protected int list_5;
    protected int list_6;
    protected int list_7;
    protected int list_8;
    protected int list_9;
    protected int list_10;

    protected int worrdcount_1;


    public int getList_2() {
        return list_2;
    }
    public void setList_2(int list_2) {
        this.list_2 = list_2;
    }
    public int getList_3() {
        return list_3;
    }
    public void setList_3(int list_3) {
        this.list_3 = list_3;
    }
    public int getList_4() {
        return list_4;
    }
    public void setList_4(int list_4) {
        this.list_4 = list_4;
    }
    public int getList_5() {
        return list_5;
    }
    public void setList_5(int list_5) {
        this.list_5 = list_5;
    }
    public int getList_6() {
        return list_6;
    }
    public void setList_6(int list_6) {
        this.list_6 = list_6;
    }
    public int getList_7() {
        return list_7;
    }
    public void setList_7(int list_7) {
        this.list_7 = list_7;
    }
    public int getList_8() {
        return list_8;
    }
    public void setList_8(int list_8) {
        this.list_8 = list_8;
    }
    public int getList_9() {
        return list_9;
    }
    public void setList_9(int list_9) {
        this.list_9 = list_9;
    }
    public int getList_10() {
        return list_10;
    }
    public void setList_10(int list_10) {
        this.list_10 = list_10;
    }

    public int getWorrdcount_1() {
        return worrdcount_1;
    }
    public void setWorrdcount_1(int worrdcount_1) {
        this.worrdcount_1 = worrdcount_1;
    }





    protected TextView text_2_inner, text_3_inner, text_4_inner, text_5_inner, text_6_inner, text_7_inner, text_8_inner, text_9_inner, text_10_inner;

    public Point viewLocatedAt(View v) {
        int[] location = new int[2];
        v.getLocationOnScreen(location);
        int x = location[0];
        int y = location[1];
        return new Point(x, y);
    } //определние координат


    Achives aa = new Achives();




    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        tasker.GetMoreTask();

//        SetSpeedFromSheredPref(PreferenceManager.getDefaultSharedPreferences(this));

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
        reset = findViewById(R.id.reset);
        faq = findViewById(R.id.faq);
        task = findViewById(R.id.task);

        clock = findViewById(R.id.clock);

        textButton1 = findViewById(R.id.textButton1);

        progress = findViewById(R.id.progress);

        score = findViewById(R.id.score);
        textClock = findViewById(R.id.textClock);
        Colo = findViewById(R.id.Colo);
        dropLayout = findViewById(R.id.dropLayout);

        QAWord = findViewById(R.id.textButton1);

        mChronometer = findViewById(R.id.chronometer);



        ListXUpFull(); // заполняем листы координат
        ControlWordsfinFail(); // читаем проверочные слова
        ReadWords(); // читаем ключевык
        Randomizator(); // разиваем на буквы
        GoneButnnons(); //все кнопки изначально не видимы
//        ShowButtons(); // услвие появление кнопок зависитот кол-ва букв в слове
        SetLiteralsonButtons(); //установка букв на слова
        Creates(); //активация и движеение кнопок
        String gg = Integer.toString(numsofliteralsinword);
        reset.setVisibility(GONE);
        score.setText("" + aa.WORD_3(4));  //ТЕСТОВАЯ ОБРАБОТКА!!!!!


      QuestList = findViewById(R.id.QuestList);
      Quest = new ArrayList<>();

        QuestList2 = findViewById(R.id.QuestList);
        Quest2 = new ArrayList<>();


    }

//    private void SetSpeedFromSheredPref(SharedPreferences sharedPreferences){
//        defaultinterval = sharedPreferences.getInt("speed", 0);
//        setSpeed(defaultinterval);
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuinflater = getMenuInflater();
        menuinflater.inflate(R.menu.speed_menu, menu);
        return true;
    } // добавить МЕНЮ 1

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_settings){
            Intent openSettings  = new Intent(this, SetingsActivity.class);
            startActivity(openSettings);
            return  true;
        }
        return super.onOptionsItemSelected(item);
    } // отработка нажтий на МЕНЮ элементе 2


    public void ListXUpFull(){
        ListCoordinateX_1.add(textButton1.getHeight()/8);
        ListCoordinateX_1.add(200);
        ListCoordinateX_1.add(200);
        ListCoordinateX_1.add(200);
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


        textClock.setVisibility(GONE);

        textButton1.setEnabled(false);


        textButton1.setVisibility(GONE);


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

        textClock.setVisibility(VISIBLE);
        starter.setVisibility(GONE);
        //--
        textButton1.setVisibility(VISIBLE);

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
        Clocks();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                f001 = viewLocatedAt(textButton1).y - (textButton1.getHeight()/8);
                LineY_1.clear();
                LineY_1.add(f001);
            }
        }, 500);

//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//        String melodyName = sharedPreferences.getString("speed_but", "fast");
//        if (melodyName.equals("slow")) {
//            setSpeed(-5500);
//        } else if (melodyName.equals("midle")) {
//            setSpeed(0);
//        } else if (melodyName.equals("fast")) {
//            setSpeed(5500);
//        }
//        score.setText(""+getSpeed());


    }  // СТАРТ, часы





    @RequiresApi(api = Build.VERSION_CODES.O)
    public void NewWord(){
        starter.setVisibility(GONE);
        reset.setVisibility(GONE);
        ControlWordsfinFail(); // читаем проверочные слова
        ReadWords(); // читаем ключевык
        Randomizator(); // разиваем на буквы
        SetLiteralsonButtons(); //установка букв на слова
        ListXUpFull(); // заполняем листы координат
        ShowButtons(); // услвие появление кнопок зависитот кол-ва букв в слове
        Creates(); //активация и движеение кнопок
        Clocks();
    } // следующее слово

    public void Clocks(){


//        new CountDownTimer(120000, 1000) {
//            @SuppressLint("SetTextI18n")
//            public void onTick(long millisUntilFinished) {
//                textClock.setText("Сек :" + millisUntilFinished / 1000);
//            }
//            public void onFinish() {
//                textClock.setText("done!");
//                GoneButnnons();
////                Dialogus();
//               reset.setVisibility(VISIBLE);
////                ResetREesetr();
////                setTextFlag(0);
//
//            }
//        }.start();
    }





    @RequiresApi(api = Build.VERSION_CODES.O)
    public void ResTart(View v){
        NewWord();
    }
    @SuppressLint("SetTextI18n")
    protected void HowScore(int A){
        switch (A){
            case 2:
                setCounter(getCounter()-1);
                setList_2(getList_3()-1);
                break;
            case 3:
                setCounter(getCounter()+1);
                setList_3(getList_3()+1);
                break;
            case 4:
                setCounter(getCounter()+2);
                setList_4(getList_4()+1);
                break;
            case 5:
                setCounter(getCounter()+3);
                setList_5(getList_4()+1);
                break;
            case 6:
                setCounter(getCounter()+4);
                setList_6(getList_4()+1);
                break;
            case 7:
                setCounter(getCounter()+4);
                setList_7(getList_4()+1);
                break;
            case 8:
                setCounter(getCounter()+4);
                setList_8(getList_4()+1);
                break;
            case 9:
                setCounter(getCounter()+4);
                setList_9(getList_4()+1);
                break;
            case 10:
                setCounter(getCounter()+4);
                setList_10(getList_10()+1);
                break;
        }
    }//подсчет очков

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Chek_1(View v){



//анимация альфа канала (прозрачности от 0 до 1)
        Animation animation = new AlphaAnimation(0.0f, 1.0f);
//длительность анимации 1/10 секунды
        animation.setDuration(300);
//сдвижка начала анимации (с середины)
        animation.setStartOffset(50);
//режим повтора - сначала или в обратном порядке
        animation.setRepeatMode(Animation.REVERSE);
//режим повтора (бесконечно)
       animation.setRepeatCount(0);
//накладываем анимацию на TextView

//анимация альфа канала (прозрачности от 0 до 1)
        Animation animation2 = new TranslateAnimation(-10, 30, 0, 30);
//длительность анимации 1/10 секунды
        animation2.setDuration(300);
//сдвижка начала анимации (с середины)
        animation2.setStartOffset(50);
//режим повтора - сначала или в обратном порядке
        animation2.setRepeatMode(Animation.REVERSE);
//режим повтора (бесконечно
        animation2.setInterpolator(new BounceInterpolator());
        animation2.setRepeatCount(1);
//накладываем анимацию на TextView




        String[] ArrayListWord = MainListWord.toArray(new String[0]);
        String KeyWord = (String.join("", ArrayListWord));
        if (listControl.contains(KeyWord) && !listBuffer.contains(KeyWord)) {
            ListXUpFull();
            HowScore(ArrayListWord.length);
            score.setText(""+getCounter());
//            textButton1.setBackgroundResource(R.drawable.textstyletrue);
            Quest.add(KeyWord);
            textButton1.startAnimation(animation);
        } else if (listBuffer.contains(KeyWord)){
            ListXUpFull();
            setCounter(getCounter()-1);
            score.setText(""+getCounter());
            Toast.makeText(this, "Повтор слова, такое уже есть", Toast.LENGTH_SHORT).show();
//            textButton1.setBackgroundResource(R.drawable.textstyle_false);
            Quest2.add(KeyWord);
            textButton1.startAnimation(animation2);
        }  else  {
            ListXUpFull();
            setCounter(getCounter()-1);
            score.setText(""+getCounter());
//            textButton1.setBackgroundResource(R.drawable.textstyle_false);
            Quest2.add(KeyWord);
            textButton1.startAnimation(animation2);
        }
        EneblendButtonsAffterPress();
        listBuffer.add(KeyWord);
        MainListWord.removeAll(MainListWord);
//        textSee.setText(String.valueOf(MainListWord));
       // setTextFlag(2);
//        textButton2.setEnabled(true);
          textButton1.setText("Собери слово");
//        textButton1.setEnabled(false);


    }


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

    int a;
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Creates(){
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String melodyName = sharedPreferences.getString("speed_but", "midle");
        if (melodyName.equals("slow")) {
            this.a = 5500;
        } else if (melodyName.equals("midle")) {
            this.a = 0;
        } else if (melodyName.equals("fast")) {
            this.a = -5500;
        }
        score.setText(""+this.a);


        button1 = ObjectAnimator.ofPropertyValuesHolder(pr1,
                PropertyValuesHolder.ofFloat("x", 0, 850),
                PropertyValuesHolder.ofFloat("y", 140, 1050));
        button1.setDuration(6000 +this.a);
        button1.setRepeatCount(ObjectAnimator.INFINITE);
        button1.setRepeatMode(ObjectAnimator.REVERSE);
//        button1.start();
//2 кнопка
        button2 = ObjectAnimator.ofPropertyValuesHolder(pr2,
                PropertyValuesHolder.ofFloat("x", 200, 400),
                PropertyValuesHolder.ofFloat("y", 140, 1050));
        button2.setDuration(6300+this.a);
        button2.setRepeatCount(ObjectAnimator.INFINITE);
        button2.setRepeatMode(ObjectAnimator.REVERSE);
//        button2.start();
//3 кнопка
        button3 = ObjectAnimator.ofPropertyValuesHolder(pr3,
                PropertyValuesHolder.ofFloat("x", 0, 910),
                PropertyValuesHolder.ofFloat("y", 140, 140));
        button3.setDuration(7500+this.a);
        button3.setRepeatCount(ObjectAnimator.INFINITE);
        button3.setRepeatMode(ObjectAnimator.REVERSE);
//        button3.start();
//4 кнопка
        button4 = ObjectAnimator.ofPropertyValuesHolder(pr4,
                PropertyValuesHolder.ofFloat("x", 0, 910),
                PropertyValuesHolder.ofFloat("y", 500, 500));
        button4.setDuration(8000+this.a);
        button4.setRepeatCount(ObjectAnimator.INFINITE);
        button4.setRepeatMode(ObjectAnimator.REVERSE);
//        button4.start();
//5 кнопка
        button5 = ObjectAnimator.ofPropertyValuesHolder(pr5,
                PropertyValuesHolder.ofFloat("x", 0, 910),
                PropertyValuesHolder.ofFloat("y", 900, 900));
        button5.setDuration(5300+this.a);
        button5.setRepeatCount(ObjectAnimator.INFINITE);
        button5.setRepeatMode(ObjectAnimator.REVERSE);
//        button5.start();
//6 кнопка
        button6 = ObjectAnimator.ofPropertyValuesHolder(pr6,
                PropertyValuesHolder.ofFloat("x", 910, 0),
                PropertyValuesHolder.ofFloat("y", 300, 300));
        button6.setDuration(5600 +this.a);
        button6.setRepeatCount(ObjectAnimator.INFINITE);
        button6.setRepeatMode(ObjectAnimator.REVERSE);
//        button6.start();
//7 кнопка
        button7 = ObjectAnimator.ofPropertyValuesHolder(pr7,
                PropertyValuesHolder.ofFloat("x", 910, 0),
                PropertyValuesHolder.ofFloat("y", 700, 700));
        button7.setDuration(4400 +this.a);
        button7.setRepeatCount(ObjectAnimator.INFINITE);
        button7.setRepeatMode(ObjectAnimator.REVERSE);
//        button7.start();
//8 кнопка
        button8 = ObjectAnimator.ofPropertyValuesHolder(pr8,
                PropertyValuesHolder.ofFloat("x", 200, 650),
                PropertyValuesHolder.ofFloat("y", 1050, 140));
        button8.setDuration(3900 +this.a);
        button8.setRepeatCount(ObjectAnimator.INFINITE);
        button8.setRepeatMode(ObjectAnimator.REVERSE);
//        button8.start();
//9 кнопка не настроил
        button9 = ObjectAnimator.ofPropertyValuesHolder(pr9,
                PropertyValuesHolder.ofFloat("x", 800, 800),
                PropertyValuesHolder.ofFloat("y", 1050, 140));
        button9.setDuration(4100 +this.a);
        button9.setRepeatCount(ObjectAnimator.INFINITE);
        button9.setRepeatMode(ObjectAnimator.REVERSE);
//        button9.start();
//10 кнопка
        button10 = ObjectAnimator.ofPropertyValuesHolder(pr10,
                PropertyValuesHolder.ofFloat("x", 0, 250),
                PropertyValuesHolder.ofFloat("y", 1050, 140));
        button10.setDuration(4500 +this.a);
        button10.setRepeatCount(ObjectAnimator.INFINITE);
        button10.setRepeatMode(ObjectAnimator.REVERSE);
//        button10.start();
//11 кнопка
        button11 = ObjectAnimator.ofPropertyValuesHolder(pr11,
                PropertyValuesHolder.ofFloat("x", 910, 100),
                PropertyValuesHolder.ofFloat("y", 140, 950));
        button11.setDuration(5700 +this.a);
        button11.setRepeatCount(ObjectAnimator.INFINITE);
        button11.setRepeatMode(ObjectAnimator.REVERSE);
//        button11.start();
//12 кнопка
        button12 = ObjectAnimator.ofPropertyValuesHolder(pr12,
                PropertyValuesHolder.ofFloat("x", 700, 400),
                PropertyValuesHolder.ofFloat("y", 140, 1050));
        button12.setDuration(3600 +this.a);
        button12.setRepeatCount(ObjectAnimator.INFINITE);
        button12.setRepeatMode(ObjectAnimator.REVERSE);
//        button12.start();

//13 кнопка
        button13 = ObjectAnimator.ofPropertyValuesHolder(pr13,
                PropertyValuesHolder.ofFloat("x", 910, 0),
                PropertyValuesHolder.ofFloat("y", 1100, 1050));
        button13.setDuration(5100 +this.a);
        button13.setRepeatCount(ObjectAnimator.INFINITE);
        button13.setRepeatMode(ObjectAnimator.REVERSE);
//        button13.start();
//14 кнопка
        button14 = ObjectAnimator.ofPropertyValuesHolder(pr14,
                PropertyValuesHolder.ofFloat("x", 500, 500),
                PropertyValuesHolder.ofFloat("y", 140, 1050));
        button14.setDuration(4800 +this.a);
        button14.setRepeatCount(ObjectAnimator.INFINITE);
        button14.setRepeatMode(ObjectAnimator.REVERSE);
//        button14.start();
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

       // ListCoordinateX_1.remove(0);

        MainListWord.add(pr1.getText().toString());
        pr1.setBackgroundResource(R.drawable.acceptbutton);
        pr1.setEnabled(false);
//        textSee.setText(String.valueOf(MainListWord));

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
//        textSee.setText(String.valueOf(MainListWord));

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
//        textSee.setText(String.valueOf(MainListWord));

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
//        textSee.setText(String.valueOf(MainListWord));

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
//        textSee.setText(String.valueOf(MainListWord));

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
//        textSee.setText(String.valueOf(MainListWord));

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
//        textSee.setText(String.valueOf(MainListWord));

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
//        textSee.setText(String.valueOf(MainListWord));

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
//        textSee.setText(String.valueOf(MainListWord));

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
//        textSee.setText(String.valueOf(MainListWord));

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
//        textSee.setText(String.valueOf(MainListWord));

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
//        textSee.setText(String.valueOf(MainListWord));

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
//        textSee.setText(String.valueOf(MainListWord));

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

    } //открытие статистики
    public void TaskShow(View v){
        TaskDialog();



    } //кнопка открытия заадний
    public void Dialogus(){

        OptionDialog = new AlertDialog.Builder(this).create();
        OptionDialog.setTitle("Статистика");
        LayoutInflater li = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = li.inflate(R.layout.stats_fragment, null, false);
        butClose =  v.findViewById(R.id.butClose);
        text_2_inner = v.findViewById(R.id.text_2_inner);
        text_3_inner = v.findViewById(R.id.text_3_inner);
        text_4_inner = v.findViewById(R.id.text_4_inner);
        text_5_inner = v.findViewById(R.id.text_5_inner);
        text_6_inner = v.findViewById(R.id.text_6_inner);
        text_7_inner = v.findViewById(R.id.text_7_inner);
        text_8_inner = v.findViewById(R.id.text_8_inner);
        text_9_inner = v.findViewById(R.id.text_9_inner);
        text_10_inner = v.findViewById(R.id.text_10_inner);

        text_2_inner.setText(String.valueOf(getList_2()));
        text_3_inner.setText(String.valueOf(getList_3()));
        text_4_inner.setText(String.valueOf(getList_4()));
        text_5_inner.setText(String.valueOf(getList_5()));
        text_6_inner.setText(String.valueOf(getList_6()));
        text_7_inner.setText(String.valueOf(getList_7()));
        text_8_inner.setText(String.valueOf(getList_8()));
        text_9_inner.setText(String.valueOf(getList_9()));
        text_10_inner.setText(String.valueOf(getList_10()));
        OptionDialog.setView(v);
        OptionDialog.setCancelable(true);

        butClose.setBackgroundColor(Color.CYAN);
        butClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                OptionDialog.dismiss();
            }

        });
//        but2 =  v.findViewById(R.id.butClose);
//        but3.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                but3.setBackgroundColor(Color.YELLOW);
//            }
//        });

        OptionDialog.show();
    }  // окно статистика


    public void TaskDialog(){

        TaskDialog = new AlertDialog.Builder(this).create();
        LayoutInflater tasks = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = tasks.inflate(R.layout.task_fragment, null, false);
        butCloseTask =  v.findViewById(R.id.butCloseTask);
        QuestList = v.findViewById(R.id.QuestList);
        QuestList2 = v.findViewById(R.id.QuestList2);


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Quest);
        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Quest2);
        QuestList.setAdapter(adapter);
        QuestList2.setAdapter(adapter2);

        TaskDialog.setView(v);
        TaskDialog.setCancelable(true);

        butCloseTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskDialog.dismiss();
//                Quest.clear();
            }
        });
        TaskDialog.show();
    }  // список собранных слов

    public void ResetField(View v){
        MainListWord.clear();
        EneblendButtonsAffterPress();
        switch (getTextFlag()){
            case 1:
                textButton1.setText("Собери слово");
                break;
        }
    } //сброс кнопок





    }



