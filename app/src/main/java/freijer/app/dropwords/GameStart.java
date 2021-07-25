package freijer.app.dropwords;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.animation.AnimatorSet;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;

import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.recyclerview.widget.GridLayoutManager;
import java.util.ArrayList;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import freijer.app.dropwords.DataBase.DataHelper;
import static android.view.View.GONE;
import static android.view.View.VISIBLE;



//** АВТОЧТЕНИЕ из БАЗЫ ДАННЫХ в кноаку СТАРТ ИГРЫ




public class GameStart extends AppCompatActivity  {



    protected ArrayList<Integer> list_lvl;
    protected int currentMaxProgress = 0;
    int currentLVL = 0;


    protected int lenght_minus_minus;
    private int lenght_plus; //переменная отвечающая за хранение последовательносит увеличения длинны слов на +1


    //переменная отвечающая за хранение последовательносит уменьшения длинны слов на -1
    public int getLenght_plus() {
        return lenght_plus;
    }
    public void setLenght_plus(int lenght_plus) {
        this.lenght_plus = lenght_plus;
    }
    public int getLenght_minus_minus() {
        return lenght_minus_minus;
    }
    public void setLenght_minus_minus(int lenght_minus_minus) {
        this.lenght_minus_minus = lenght_minus_minus;
    }

    ArrayList<String> lenght_plus_com;
    ArrayList<String> lenght_minus_com;

    Supports supportClass = new Supports();

    String read = "";
    String readWrong = "";
    String writeTrue = "";
    String writeWrong = "";

    private String text_plus_lenght;
    private String text_minus_lenght;

    //ачивки выводить не текстом, а "иконками" или не все, а только часть. Например за каждую 10 ачивку.
    DataHelper dbHelper;


    protected int flag = 0;
    protected int exp = 0;



    public int getFlag() {
        return flag;
    }
    public void setFlag(int flag) {
        this.flag = flag;
    }
    public int getExp() {
        return exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }


    protected int number_change_word = 5;

    int number_word_3 = 0;
    int number_word_4 = 0;
    int number_word_5 = 0;
    int number_word_6 = 0;
    int number_word_7 = 0;
    int number_word_8 = 0;
    int number_word_9 = 0;
    int number_word_10 = 0;


    String addsc;
    String addlvl;
    String addtryss;

    public String getAddsc() {
        return addsc;
    }
    public void setAddsc(String addsc) {
        this.addsc = addsc;
    }
    public String getAddlvl() {
        return addlvl;
    }
    public void setAddlvl(String addlvl) {
        this.addlvl = addlvl;
    }
    public String getAddtryss() {
        return addtryss;
    }
    public void setAddtryss(String addtryss) {
        this.addtryss = addtryss;
    }

    public int getNumber_word_3() {
        return number_word_3;
    }
    public void setNumber_word_3(int number_word_3) {
        this.number_word_3 = number_word_3;
    }
    public int getNumber_word_4() {
        return number_word_4;
    }
    public void setNumber_word_4(int number_word_4) {
        this.number_word_4 = number_word_4;
    }
    public int getNumber_word_5() {
        return number_word_5;
    }
    public void setNumber_word_5(int number_word_5) {
        this.number_word_5 = number_word_5;
    }
    public int getNumber_word_6() {
        return number_word_6;
    }
    public void setNumber_word_6(int number_word_6) {
        this.number_word_6 = number_word_6;
    }
    public int getNumber_word_7() {
        return number_word_7;
    }
    public void setNumber_word_7(int number_word_7) {
        this.number_word_7 = number_word_7;
    }
    public int getNumber_word_8() {
        return number_word_8;
    }
    public void setNumber_word_8(int number_word_8) {
        this.number_word_8 = number_word_8;
    }
    public int getNumber_word_9() {
        return number_word_9;
    }
    public void setNumber_word_9(int number_word_9) {
        this.number_word_9 = number_word_9;
    }
    public int getNumber_word_10() {
        return number_word_10;
    }
    public void setNumber_word_10(int number_word_10) {
        this.number_word_10 = number_word_10;
    }


    //Правильные ответы
    ListView Thru_answer_1;
    ListView Thru_answer_2;
    ListView Thru_answer_3;
    ListView Thru_answer_4;

    ArrayList<String> thru_list_1;
    ArrayList<String> thru_list_2;
    ArrayList<String> thru_list_3;
    ArrayList<String> thru_list_4;

    ArrayAdapter<String> adapter_thru_1;
    ArrayAdapter<String> adapter_thru_2;
    ArrayAdapter<String> adapter_thru_3;
    ArrayAdapter<String> adapter_thru_4;
    //

    //Не правильные ответы
    ListView Wrong_answer_1;

    ArrayList<String> Wrong_list_1;

    ArrayAdapter<String> adapter_wrong_1;
    //

    ArrayList<String> bufferReadList;

    List<String> Alfas;
    List<String> WrongSwitch;
    ArrayList<String> TYU;
    ArrayList<String> ListBuffer;
    ArrayList<String> ListReadBuffer;

    FileOutputStream outputStream;
    String  myText;

    protected Button butClose, butCloseTask, butClose_mission;
    private AlertDialog OptionDialog, TaskDialog, MissionsDialog, OptionMenuDialog;


    protected int textFlag;
    public int getTextFlag() {
        return textFlag;
    }
    public void setTextFlag(int textFlag) {
        this.textFlag = textFlag;
    }

    protected int f001;


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

    protected ProgressBar progressBar, word_bar_all, word_bar_3, word_bar_4, word_bar_5, word_bar_6, word_bar_7, word_bar_8, word_bar_9, word_bar_10, word_bar_11, word_bar_12, word_bar_13, word_bar_14;
    protected TextView lvlview, textClock, score, thisWordShow, textLvl, textScore, tryChange, word_stat_lit_all,
            word_stat_lit_3, word_stat_lit_4,word_stat_lit_5,word_stat_lit_6,word_stat_lit_7,word_stat_lit_8,word_stat_lit_9,word_stat_lit_10,word_stat_lit_11,word_stat_lit_12,word_stat_lit_13,word_stat_lit_14;
    protected Button menu, starter, faq, task,  reset, pr1, pr2, pr3, pr4, pr5, pr6, pr7, pr8, pr9, pr10, pr11, pr12, pr13, pr14;
    protected Button  quest, resetWord, butCloseOption;
    private ImageView img_nextlvl, change_img, score_img;
    protected ArrayList<String> MainListWord = new ArrayList<>();// при нажатии кнопки собисрется слово
    protected ArrayList<Integer> ListCoordinateX_1 = new ArrayList<Integer>();
    protected ArrayList<Integer> LineY_1 = new ArrayList<Integer>();
    private ArrayList<String> list;
    protected ArrayList<String> listControl;
    protected ArrayList<String> listBuffer = new ArrayList<String>();
    protected Chronometer mChronometer;
    protected RelativeLayout chars_layout, engine_buttons, topLayout;


    private int img0, img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15, img16, img17, img18, img19, img20, img21, img22, img23, img24, img25, img26,
            img27, img28, img29, img30, img31, img32, img33, img34, img35, img36, img37, img38 = R.drawable.star;

    int a0, a1, a2, a3, a4, a5, a6,  a7,  a8,  a9,  a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22, a23, a24, a25, a26, a27, a28, a29, a30, a31, a32, a33, a34, a35, a36, a37, a38 = 0;

    RecyclerViewAdapter adapter;
    ArrayList<Model> myValues = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;





    protected TextView char_1, char_2, char_3, char_4, char_5, char_6, char_7, char_8, char_9, char_10, char_11, char_12, char_13, char_14;
    private int indexWord;
    private String word;
    private Random r = new Random();
    protected String[] Original;
    protected String[] OriginalWord; //бавзовое слово
    protected String[] MixedleWord; //смешение
    protected String Control;
    private MotionLayout Colo;
    private final int USERID = 6000;
    private int countID;
    protected int numsofliteralsinword;

    protected int list_2;
    protected int list_3;
    protected int list_4;
    protected int list_5;
    protected int list_6;
    protected int list_7;
    protected int list_8;
    protected int list_9;
    protected int list_10;
    protected int list_11;
    protected int list_12;
    protected int list_13;
    protected int list_14;


    protected int list_sum;

    protected int speed_a;
    public int getSpeed_a() {
        return speed_a;
    }
    public void setSpeed_a(int speed_a) {
        this.speed_a = speed_a;
    }

    public String getControl() {
        return Control;
    }
    public void setControl(String control) {
        Control = control;
    }


    protected int stepOnNextLvl = currentLVL; // ЧТЕНИЕ и ЗАПИСЬ В БД сохрание Уровня
    public int getStepOnNextLvl() {
        return stepOnNextLvl;
    }
    public void setStepOnNextLvl(int stepOnNextLvl) {
        this.stepOnNextLvl = stepOnNextLvl;
    }

    int counter; // ЧТЕНИЕ и ЗАПИСЬ В БД сохрание Очков
    public int getCounter() {
        return counter;
    }
    public void setCounter(int counter) {
        this.counter = counter;
    }



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
    public int getList_11() {
        return list_11;
    }
    public void setList_11(int list_11) {
        this.list_11 = list_11;
    }
    public int getList_12() {
        return list_12;
    }
    public void setList_12(int list_12) {
        this.list_12 = list_12;
    }
    public int getList_13() {
        return list_13;
    }
    public void setList_13(int list_13) {
        this.list_13 = list_13;
    }
    public int getList_14() {
        return list_14;
    }
    public void setList_14(int list_14) {
        this.list_14 = list_14;
    }
    public int getList_sum() {
        return list_sum;
    }
    public void setList_sum(int list_sum) {
        this.list_sum = list_sum;
    }


    protected int tryChenge = 0;
    public int getTryChenge() {
        return tryChenge;
    }
    public void setTryChenge(int tryChenge) {
        this.tryChenge = tryChenge;
    }

    protected TextView text_3_inner, text_4_inner, text_5_inner, text_6_inner, text_7_inner, text_8_inner, text_9_inner, text_10_inner, text_11_inner, text_12_inner, text_13_inner, text_14_inner, text_sum_inner;

    public Point viewLocatedAt(View v) {
        int[] location = new int[2];
        v.getLocationOnScreen(location);
        int x = location[0];
        int y = location[1];
        return new Point(x, y);
    } //определние координат

    List<String> taskList = new ArrayList<>();


    SharedPreferences prefs = null;

    private int seconds = 0;
    private boolean running;

    @SuppressLint({"SourceLockedOrientationActivity", "SetTextI18n"})
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        dbHelper = new DataHelper(this);
        setTextFlag(1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_start);
        chars_layout = findViewById(R.id.chars_layout);
        engine_buttons = findViewById(R.id.engine_buttons);
        topLayout = findViewById(R.id.topLayout);
        quest = findViewById(R.id.quest);

        lenght_plus_com = new ArrayList<>();
        lenght_minus_com = new ArrayList<>();


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
        lvlview = findViewById(R.id.lvlview);

        score = findViewById(R.id.score);

        textClock = findViewById(R.id.textClock);
        Colo = findViewById(R.id.Colo);
        mChronometer = findViewById(R.id.chronometer);
        resetWord = findViewById(R.id.resetWord);

        change_img = findViewById(R.id.change_img);
//        score_img = findViewById(R.id.score_img);


        menu = findViewById(R.id.menu);
        textLvl = findViewById(R.id.textLvl);
        textScore = findViewById(R.id.textScore);
        tryChange = findViewById(R.id.tryChange);

        char_1 = findViewById(R.id.char_1);
        char_2 = findViewById(R.id.char_2);
        char_3 = findViewById(R.id.char_3);
        char_4 = findViewById(R.id.char_4);
        char_5 = findViewById(R.id.char_5);
        char_6 = findViewById(R.id.char_6);
        char_7 = findViewById(R.id.char_7);
        char_8 = findViewById(R.id.char_8);
        char_9 = findViewById(R.id.char_9);
        char_10 = findViewById(R.id.char_10);
        char_11 = findViewById(R.id.char_11);
        char_12 = findViewById(R.id.char_12);
        char_13 = findViewById(R.id.char_13);
        char_14 = findViewById(R.id.char_14);


        GoneButnnons(); //все кнопки изначально не видимы

        thru_list_1 = new ArrayList<>();
        thru_list_2 = new ArrayList<>();
        thru_list_3 = new ArrayList<>();
        thru_list_4 = new ArrayList<>();

        Wrong_list_1 = new ArrayList<>();

        list_lvl = new ArrayList();
        list_lvl.add(0);
        list_lvl.add(20);
        list_lvl.add(50);
        list_lvl.add(80);
        list_lvl.add(110);
        list_lvl.add(150);


        bufferReadList = new ArrayList<>();

        Alfas = new ArrayList<>();
        WrongSwitch= new ArrayList<>();


        TYU = new ArrayList<>();
        ListReadBuffer = new ArrayList<>();
        ListBuffer = new ArrayList<>();


        progressBar = findViewById(R.id.progressBar);

        progressBar.setProgress(getCounter());
        newLvlFromProgressBar();
        ProgressBarNextLvl();

//        resetWord.setVisibility(GONE);
//        menu.setVisibility(GONE);
//        reset.setVisibility(GONE);

//        engine_buttons.setVisibility(GONE);
//        chars_layout.setVisibility(GONE);

        prefs = android.preference.PreferenceManager.getDefaultSharedPreferences(this);


        SharedPreferences.Editor e = prefs.edit();
        e.apply();


        ControlWordsfinFail(); // читаем проверочные слова
        ReadWords(); // читаем ключевык
        Randomizator(); // разиваем на буквы


        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String income1 = bundle.getString("setSpeed_buttons");
            setSpeed_a(Integer.parseInt(income1));
            Log.d("SPEED2", ""+getSpeed_a());
        }

        ClockWork();



    }



    @RequiresApi(api = Build.VERSION_CODES.O)
    public void LetsGo(View v){



        score.setText(getCounter()+"/"+progressBar.getMax());
        textClock.setText(""+getTryChenge());
        lvlview.setText(""+getStepOnNextLvl());

        ReadfromDB();
        ReadfromDB_lenght();

        score.setText(getCounter()+"/"+progressBar.getMax());
        textClock.setText(""+getTryChenge());
        lvlview.setText(""+getStepOnNextLvl());

        newLvlFromProgressBar();
        ProgressBarNextLvl();
//        score.setVisibility(VISIBLE);
//        lvlview.setVisibility(VISIBLE);
//
//        textClock.setVisibility(VISIBLE);
//
//
//        textLvl.setVisibility(VISIBLE);
//        textScore.setVisibility(VISIBLE);
//        tryChange.setVisibility(VISIBLE);
        //--
//        resetWord.setVisibility(VISIBLE);
//        menu.setVisibility(VISIBLE);
//        reset.setVisibility(VISIBLE);

//        topLayout.setVisibility(VISIBLE);
//        engine_buttons.setVisibility(VISIBLE);
//        chars_layout.setVisibility(VISIBLE);





        ListXUpFull(); // заполняем листы координат
//        ControlWordsfinFail(); // читаем проверочные слова
//        ReadWords(); // читаем ключевык
//        Randomizator(); // разиваем на буквы
        GoneButnnons(); //все кнопки изначально не видимы

        SetLiteralsonButtons(); //установка букв на слова
      //  Creates(); //активация и движеение кнопок

        ShowButtons();
        starter.setVisibility(GONE);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                f001 = viewLocatedAt(chars_layout).y - (chars_layout.getHeight()/8);
                LineY_1.clear();
                LineY_1.add(f001);
            }
        }, 500);

        thru_list_1.clear();
        thru_list_2.clear();
        thru_list_3.clear();
        thru_list_4.clear();

        Wrong_list_1.clear();




        try {
            LoadText();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReadFromTxtWrong();

        onClickStart();//старт часов



    }  // СТАРТ, часы




    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            LoadText();
//            Load_Lenght_plus();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReadFromTxtWrong();
    }

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
        ListCoordinateX_1.add(chars_layout.getHeight()/8);
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

        char_1.setVisibility(GONE);
        char_2.setVisibility(GONE);
        char_3.setVisibility(GONE);
        char_4.setVisibility(GONE);
        char_5.setVisibility(GONE);
        char_6.setVisibility(GONE);
        char_7.setVisibility(GONE);
        char_8.setVisibility(GONE);
        char_9.setVisibility(GONE);
        char_10.setVisibility(GONE);
        char_11.setVisibility(GONE);
        char_12.setVisibility(GONE);
        char_13.setVisibility(GONE);
        char_14.setVisibility(GONE);


    } //убрать кнопки с экрана
    public void ShowButtons(){

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
//                button1.start();
//                button2.start();
//                button3.start();
//                button4.start();
//                button5.start();
//                button6.start();
//                button7.start();
//                button8.start();
//                button9.start();
//                button10.start();
//                button11.start();
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
//                button1.start();
//                button2.start();
//                button3.start();
//                button4.start();
//                button5.start();
//                button6.start();
//                button7.start();
//                button8.start();
//                button9.start();
//                button10.start();
//                button11.start();
//                button12.start();
//                button13.start();
//                button14.start();
                break;

        }

        starter.setVisibility(GONE);
        char_1.setVisibility(VISIBLE);
        char_2.setVisibility(VISIBLE);
        char_3.setVisibility(VISIBLE);

        //--

    } // показ кнопок на экране
    public void ReadWords(){
        String str;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("sevrallwords.txt")));

            this.list = new ArrayList<>();
            while ((str = reader.readLine()) != null) {
                if (!str.isEmpty()) {
                    list.add(str);
                }
            }
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
            setControl(this.word);  // <= ВАЖНО setControl должен быть тут!!!
            Log.d("QQW1", this.word);
        } else if (list.isEmpty()) {
            ReadWords(); //- заново
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
//        this.Control = this.word;
//        setControl(list.get(indexWord));
        this.numsofliteralsinword = MixedleWord.length;

    } //разбив слова на буквы
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
                pr12.setVisibility(GONE);
                pr13.setVisibility(GONE);
                pr14.setVisibility(GONE);
                break;
            case 14:
                pr12.setVisibility(VISIBLE);
                pr13.setVisibility(VISIBLE);
                pr14.setVisibility(VISIBLE);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(GameStart.this);
        builder.setTitle("     Инструкция")
                .setMessage("По экрану движутся кнопки, нажимая на них нужно собрать слово" + "\n"  +
                        "за каждое правильно собранное слово  " + "\n"  +
                        "Вы получаете очки" + "\n"  +
                        "и очки смены слова." + "\n"  +
                        "За не верные слова и повторные " + "\n"  +
                        "вы теряете -1 очко " + "\n"  +
                        "При смене слова вы рандомно получете новый набор букв." + "\n"
                )
                .setCancelable(false)
                .setNegativeButton("Все понятно, создатель этого приложения гений!",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    } //Всплывающая инструкция



    @RequiresApi(api = Build.VERSION_CODES.O)
    public void NewWord(){

        ControlWordsfinFail(); // читаем проверочные слова
        ReadWords(); // читаем ключевык
        Randomizator(); // разиваем на буквы
        SetLiteralsonButtons(); //установка букв на слова
        ListXUpFull(); // заполняем листы координат
        ShowButtons(); // услвие появление кнопок зависитот кол-ва букв в слове
      //  Creates(); //активация и движеение кнопок
    } // следующее слово
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void ResTart(View v){
        EneblendButtonsAffterPress();
        if (getTryChenge()> 0){
//            reset.setEnabled(true);
            NewWord();
            setTryChenge(getTryChenge()-1);
            Toast.makeText(this, "Слово сменилось", Toast.LENGTH_SHORT).show();
        } else if (getTryChenge()<1){
            Toast.makeText(this, "Нет попыток, добудте еще ачивку", Toast.LENGTH_SHORT).show();
        }
        textClock.setText(""+getTryChenge());//2
        ressetChars();
    }  //Включить новое слово
    @SuppressLint("SetTextI18n")

    protected void HowScore(int A){
        switch (A){
            case 2:
                setCounter(getCounter()+0);
                break;
            case 3:
                setCounter(getCounter()+1);
                break;
            case 4:
                setCounter(getCounter()+2);
                break;
            case 5:
                setCounter(getCounter()+3);
                break;
            case 6:
                setCounter(getCounter()+4);
                break;
            case 7:
                setCounter(getCounter()+4);
                break;
            case 8:
                setCounter(getCounter()+4);
                break;
            case 9:
                setCounter(getCounter()+4);
                break;
            case 10:
                setCounter(getCounter()+4);
                break;
        }

    }//подсчет очков за Ачивки
    protected void HowLenght (int incom1){
        switch (incom1){
            case 2:
                setList_2(getList_2()+0);
                break;
            case 3:
                setList_3(getList_3()+1);
                break;
            case 4:
                setList_4(getList_4()+1);
                break;
            case 5:
                setList_5(getList_5()+1);
                break;
            case 6:
                setList_6(getList_6()+1);
                break;
            case 7:
                setList_7(getList_7()+1);
                break;
            case 8:
                setList_8(getList_8()+1);
                break;
            case 9:
                setList_9(getList_9()+1);
                break;
            case 10:
                setList_10(getList_10()+1);
                break;
            case 11:
                setList_11(getList_10()+1);
                break;
            case 12:
                setList_12(getList_10()+1);
                break;
            case 13:
                setList_13(getList_10()+1);
                break;
            case 14:
                setList_14(getList_10()+1);
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void howLenght_plus(String keyWord_lenght){
//        String[] listWord_lenght = MainListWord.toArray(new String[0]);
//        String keyWord_lenght = (String.join("", listWord_lenght));
        lenght_plus_com.add(keyWord_lenght);
        setLenght_plus(supportClass.CountCorrectSeqLen(lenght_plus_com));
        lenght_minus_com.add(keyWord_lenght);
        setLenght_minus_minus(supportClass.countWordMinus(lenght_minus_com));

        Log.d("uuui_plus", String.valueOf(getLenght_plus()));
    } //Если я читаю это секйчас, пожалуйста, не думай зачем я это все писал. Главное, что это работает

    protected void howLenght_minus(String keyWord_lenght){
        lenght_minus_com.add(keyWord_lenght);
        setLenght_minus_minus(supportClass.countWordMinus(lenght_minus_com));

        Log.d("uuui_minus", String.valueOf(getLenght_minus_minus()));
    } //Если я читаю это секйчас, пожалуйста, не думай зачем я это все писа


    @SuppressLint("SetTextI18n")
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

        String[] ArrayListWord = MainListWord.toArray(new String[0]);
        String KeyWord = (String.join("", ArrayListWord));

        // Toast.makeText(this, KeyWord, Toast.LENGTH_SHORT).show();
        if (listControl.contains(KeyWord) && !listBuffer.contains(KeyWord) && !Switch_answer().contains(KeyWord)) {
            ListXUpFull();
            HowScore(ArrayListWord.length); // Передача ОЧКОВ
            HowLenght(ArrayListWord.length);
            howLenght_plus(KeyWord);
            howLenght_minus(KeyWord);
            Switch_answer().add(KeyWord);
            setCounter(getCounter()+1);
            setExp(getExp()+4);

            progressBar.setProgress(getCounter());
            newLvlFromProgressBar();
            ProgressBarNextLvl();


            chars_layout.startAnimation(animation);
        } else if (listBuffer.contains(KeyWord)){
            ListXUpFull();
            setCounter(getCounter()-1);
            setExp(getExp()-2);
            progressBar.setProgress(getCounter());
            newLvlFromProgressBar();
            ProgressBarNextLvl();
            Toast.makeText(this, "Повтор слова, такое уже есть", Toast.LENGTH_SHORT).show();
            Wrong_Switch_answer().add(KeyWord);
            chars_layout.startAnimation(animation2);
            ressetChars();
        } else{
            ListXUpFull();
            setCounter(getCounter()-1);
            setExp(getExp()-1);
            progressBar.setProgress(getCounter());
            newLvlFromProgressBar();
            ProgressBarNextLvl();
            Wrong_Switch_answer().add(KeyWord);
            chars_layout.startAnimation(animation2);
            ressetChars();
        }


        EneblendButtonsAffterPress();
        listBuffer.add(KeyWord);
        MainListWord.removeAll(MainListWord);

        MainListWord.clear();
        char_1.setText("");
        char_2.setText("");
        char_3.setText("");
        char_4.setText("");
        char_5.setText("");
        char_6.setText("");
        char_7.setText("");
        char_8.setText("");
        char_9.setText("");
        char_10.setText("");
        char_11.setText("");
        char_12.setText("");
        char_13.setText("");
        char_14.setText("");


        supportClass.ShowTaskWelDone(taskList);


        score.setText(getCounter()+"/"+progressBar.getMax()); // ФИНАЛЬНЫЕ данные очки
        textClock.setText(""+getTryChenge());// ФИНАЛЬНЫЕ данные попыток смены
        lvlview.setText(""+getStepOnNextLvl()); // ФИНАЛЬНЫЕ данные уровень

        AddDB();
        SaveText();
        WriteWrong();
        AddDB_lenght();

//        howAchivites();


        char_4.setVisibility(GONE);
        char_5.setVisibility(GONE);
        char_6.setVisibility(GONE);
        char_7.setVisibility(GONE);
        char_8.setVisibility(GONE);
        char_9.setVisibility(GONE);
        char_10.setVisibility(GONE);
        char_11.setVisibility(GONE);
        char_12.setVisibility(GONE);
        char_13.setVisibility(GONE);
        char_14.setVisibility(GONE);
        //--Показ очков сразу при получении авчивки
        score.setText(getCounter()+"/"+progressBar.getMax()); // ФИНАЛЬНЫЕ данные очки
        textClock.setText(""+getTryChenge());// ФИНАЛЬНЫЕ данные попыток смены
        lvlview.setText(""+getStepOnNextLvl()); // ФИНАЛЬНЫЕ данные уровень

        AddDB();

    } //проверка


    //------------таймер
    public void ClockWork(){

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, secs);

                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
    public void onClickStart() {
        running = true;

    } //старт
    public void onClickStop() {
        running = false;
    } //стоп, пауза
    //-------------




    public void ProgressBarNextLvl() {
        progressBar.setProgress(getCounter());
       if (progressBar.getProgress() >= 10){
           progressBar.setMax(20);
           setCounter(0);
           progressBar.setProgress(getCounter());
           setTryChenge(getTryChenge()+5);
           setStepOnNextLvl(1);
       } else if (progressBar.getProgress() >= 20){
            progressBar.setMax(35);
            setCounter(0);
           progressBar.setProgress(getCounter());
            setStepOnNextLvl(2);
           setTryChenge(getTryChenge()+5);
       } else if (progressBar.getProgress() >= 35){
           progressBar.setMax(50);
           setCounter(0);
           progressBar.setProgress(getCounter());
           setStepOnNextLvl(3);
           setTryChenge(getTryChenge()+5);
       }
    }

    public void newLvlFromProgressBar() {
        switch (progressBar.getMax()){
            case 10:
                progressBar.setMax(20);
                break;
            case 20:
                progressBar.setMax(35);
                break;
            case 35:
                progressBar.setMax(50);
                break;
        }
    }


//    protected void ShowNewLvl(){
//        setTryChenge(getTryChenge()+5);
//        ObjectAnimator scaleXAnimation = ObjectAnimator.ofFloat(img_nextlvl, "scaleX", 0.3f, 2.5f);
//        scaleXAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
//        scaleXAnimation.setDuration(1900);
//        ObjectAnimator scaleYAnimation = ObjectAnimator.ofFloat(img_nextlvl, "scaleY", 0.3f, 2.5f);
//        scaleYAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
//        scaleYAnimation.setDuration(1900);
//        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(img_nextlvl, "alpha", 1F, 0F);
//        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
//        alphaAnimation.setDuration(2500);
//
//
//        AnimatorSet animationSet = new AnimatorSet();
//        animationSet.play(scaleXAnimation).with(scaleYAnimation).with(alphaAnimation);
//        animationSet.start();
//    } //показать уведомление о новом уровне

    protected void EneblendButtonsAffterPress(){
        pr1.setEnabled(true);
        pr1.setBackgroundResource(R.drawable.main_note_press);
        pr2.setEnabled(true);
        pr2.setBackgroundResource(R.drawable.main_note_press);
        pr3.setEnabled(true);
        pr3.setBackgroundResource(R.drawable.main_note_press);
        pr4.setEnabled(true);
        pr4.setBackgroundResource(R.drawable.main_note_press);
        pr5.setEnabled(true);
        pr5.setBackgroundResource(R.drawable.main_note_press);
        pr6.setEnabled(true);
        pr6.setBackgroundResource(R.drawable.main_note_press);
        pr7.setEnabled(true);
        pr7.setBackgroundResource(R.drawable.main_note_press);
        pr8.setEnabled(true);
        pr8.setBackgroundResource(R.drawable.main_note_press);
        pr9.setEnabled(true);
        pr9.setBackgroundResource(R.drawable.main_note_press);
        pr10.setEnabled(true);
        pr10.setBackgroundResource(R.drawable.main_note_press);
        pr11.setEnabled(true);
        pr11.setBackgroundResource(R.drawable.main_note_press);
        pr12.setEnabled(true);
        pr12.setBackgroundResource(R.drawable.main_note_press);
        pr13.setEnabled(true);
        pr13.setBackgroundResource(R.drawable.main_note_press);
        pr14.setEnabled(true);
        pr14.setBackgroundResource(R.drawable.main_note_press);
    } //кнопки снова активны и имеют исходный стиль

//    @RequiresApi(api = Build.VERSION_CODES.O)
//    public void Creates(){
//
//        button1 = ObjectAnimator.ofPropertyValuesHolder(pr1,
//                PropertyValuesHolder.ofFloat("x", 0, 850),
//                PropertyValuesHolder.ofFloat("y", 140, 1050));
//                    button1.setDuration(6000 +getSpeed_a());
//                        button1.setRepeatCount(ObjectAnimator.INFINITE);
//                        button1.setRepeatMode(ObjectAnimator.REVERSE);
//
////        button1.start();
////2 кнопка
//        button2 = ObjectAnimator.ofPropertyValuesHolder(pr2,
//                PropertyValuesHolder.ofFloat("x", 200, 400),
//                PropertyValuesHolder.ofFloat("y", 140, 1050));
//        button2.setDuration(6300+getSpeed_a());
//        button2.setRepeatCount(ObjectAnimator.INFINITE);
//        button2.setRepeatMode(ObjectAnimator.REVERSE);
////        button2.start();
////3 кнопка
//        button3 = ObjectAnimator.ofPropertyValuesHolder(pr3,
//                PropertyValuesHolder.ofFloat("x", 0, 850),
//                PropertyValuesHolder.ofFloat("y", 140, 140));
//        button3.setDuration(7500+getSpeed_a());
//        button3.setRepeatCount(ObjectAnimator.INFINITE);
//        button3.setRepeatMode(ObjectAnimator.REVERSE);
////        button3.start();
////4 кнопка
//        button4 = ObjectAnimator.ofPropertyValuesHolder(pr4,
//                PropertyValuesHolder.ofFloat("x", 0, 850),
//                PropertyValuesHolder.ofFloat("y", 500, 500));
//        button4.setDuration(8000+getSpeed_a());
//        button4.setRepeatCount(ObjectAnimator.INFINITE);
//        button4.setRepeatMode(ObjectAnimator.REVERSE);
////        button4.start();
////5 кнопка
//        button5 = ObjectAnimator.ofPropertyValuesHolder(pr5,
//                PropertyValuesHolder.ofFloat("x", 0, 850),
//                PropertyValuesHolder.ofFloat("y", 900, 900));
//        button5.setDuration(5300+getSpeed_a());
//        button5.setRepeatCount(ObjectAnimator.INFINITE);
//        button5.setRepeatMode(ObjectAnimator.REVERSE);
////        button5.start();
////6 кнопка
//        button6 = ObjectAnimator.ofPropertyValuesHolder(pr6,
//                PropertyValuesHolder.ofFloat("x", 850, 0),
//                PropertyValuesHolder.ofFloat("y", 300, 300));
//        button6.setDuration(5600 +getSpeed_a());
//        button6.setRepeatCount(ObjectAnimator.INFINITE);
//        button6.setRepeatMode(ObjectAnimator.REVERSE);
////        button6.start();
////7 кнопка
//        button7 = ObjectAnimator.ofPropertyValuesHolder(pr7,
//                PropertyValuesHolder.ofFloat("x", 850, 0),
//                PropertyValuesHolder.ofFloat("y", 700, 700));
//        button7.setDuration(4400 +getSpeed_a());
//        button7.setRepeatCount(ObjectAnimator.INFINITE);
//        button7.setRepeatMode(ObjectAnimator.REVERSE);
////        button7.start();
////8 кнопка
//        button8 = ObjectAnimator.ofPropertyValuesHolder(pr8,
//                PropertyValuesHolder.ofFloat("x", 200, 650),
//                PropertyValuesHolder.ofFloat("y", 1050, 140));
//        button8.setDuration(3900 +getSpeed_a());
//        button8.setRepeatCount(ObjectAnimator.INFINITE);
//        button8.setRepeatMode(ObjectAnimator.REVERSE);
////        button8.start();
////9 кнопка не настроил
//        button9 = ObjectAnimator.ofPropertyValuesHolder(pr9,
//                PropertyValuesHolder.ofFloat("x", 800, 800),
//                PropertyValuesHolder.ofFloat("y", 1050, 140));
//        button9.setDuration(4100 +getSpeed_a());
//        button9.setRepeatCount(ObjectAnimator.INFINITE);
//        button9.setRepeatMode(ObjectAnimator.REVERSE);
////        button9.start();
////10 кнопка
//        button10 = ObjectAnimator.ofPropertyValuesHolder(pr10,
//                PropertyValuesHolder.ofFloat("x", 0, 250),
//                PropertyValuesHolder.ofFloat("y", 1050, 140));
//        button10.setDuration(4500 +getSpeed_a());
//        button10.setRepeatCount(ObjectAnimator.INFINITE);
//        button10.setRepeatMode(ObjectAnimator.REVERSE);
////        button10.start();
////11 кнопка
//        button11 = ObjectAnimator.ofPropertyValuesHolder(pr11,
//                PropertyValuesHolder.ofFloat("x", 850, 100),
//                PropertyValuesHolder.ofFloat("y", 140, 950));
//        button11.setDuration(5700 +getSpeed_a());
//        button11.setRepeatCount(ObjectAnimator.INFINITE);
//        button11.setRepeatMode(ObjectAnimator.REVERSE);
////        button11.start();
////12 кнопка
//        button12 = ObjectAnimator.ofPropertyValuesHolder(pr12,
//                PropertyValuesHolder.ofFloat("x", 700, 400),
//                PropertyValuesHolder.ofFloat("y", 140, 1050));
//        button12.setDuration(3600 +getSpeed_a());
//        button12.setRepeatCount(ObjectAnimator.INFINITE);
//        button12.setRepeatMode(ObjectAnimator.REVERSE);
////        button12.start();
//
////13 кнопка
//        button13 = ObjectAnimator.ofPropertyValuesHolder(pr13,
//                PropertyValuesHolder.ofFloat("x", 850, 0),
//                PropertyValuesHolder.ofFloat("y", 1100, 1050));
//        button13.setDuration(5100 +getSpeed_a());
//        button13.setRepeatCount(ObjectAnimator.INFINITE);
//        button13.setRepeatMode(ObjectAnimator.REVERSE);
////        button13.start();
////14 кнопка
//        button14 = ObjectAnimator.ofPropertyValuesHolder(pr14,
//                PropertyValuesHolder.ofFloat("x", 500, 500),
//                PropertyValuesHolder.ofFloat("y", 140, 1050));
//        button14.setDuration(4800 +getSpeed_a());
//        button14.setRepeatCount(ObjectAnimator.INFINITE);
//        button14.setRepeatMode(ObjectAnimator.REVERSE);
////        button14.start();
//    } //движение кнопок



    protected void SwitchTextField(){
//        switch(getTextFlag()){
//            case 1:
//                textButton1.setText(String.valueOf(MainListWord));
//                break;
//            case 2:
//                textButton2.setText(String.valueOf(MainListWord));
//                break;
//            case 3:
//                textButton3.setText(String.valueOf(MainListWord));
//                break;
//            case 4:
//                textButton4.setText(String.valueOf(MainListWord));
//                break;
//            case 5:
//                textButton5.setText(String.valueOf(MainListWord));
//                break;
//            case 6:
//                textButton6.setText(String.valueOf(MainListWord));
//                break;
//            case 7:
//                textButton7.setText(String.valueOf(MainListWord));
//                break;
//            case 8:
//                textButton8.setText(String.valueOf(MainListWord));
//                break;
//            case 9:
//                textButton9.setText(String.valueOf(MainListWord));
//                break;
//            case 10:
//                textButton10.setText(String.valueOf(MainListWord));
//                break;
//        }


// Старое назначение букв на выход     // ста

        // старое назначение букв на вывод на виюшку


        if (MainListWord.size() == 1){
            char_1.setText(MainListWord.get(0));
            char_2.setText("");
            char_3.setText("");
            char_4.setText("");
            char_5.setText("");
            char_6.setText("");
            char_7.setText("");
            char_8.setText("");
            char_9.setText("");
            char_10.setText("");
            char_11.setText("");
            char_12.setText("");
            char_13.setText("");
            char_14.setText("");
        } else if (MainListWord.size() == 2){
            char_1.setText(MainListWord.get(0));
            char_2.setText(MainListWord.get(1));
            char_3.setText("");
            char_4.setText("");
            char_5.setText("");
            char_6.setText("");
            char_7.setText("");
            char_8.setText("");
            char_9.setText("");
            char_10.setText("");
            char_11.setText("");
            char_12.setText("");
            char_13.setText("");
            char_14.setText("");
        } else if (MainListWord.size() == 3){
            char_1.setText(MainListWord.get(0));
            char_2.setText(MainListWord.get(1));
            char_3.setText(MainListWord.get(2));
            char_4.setText("");
            char_5.setText("");
            char_6.setText("");
            char_7.setText("");
            char_8.setText("");
            char_9.setText("");
            char_10.setText("");
            char_11.setText("");
            char_12.setText("");
            char_13.setText("");
            char_14.setText("");
            char_4.setVisibility(VISIBLE);
        } else if (MainListWord.size() == 4){
            char_1.setText(MainListWord.get(0));
            char_2.setText(MainListWord.get(1));
            char_3.setText(MainListWord.get(2));
            char_4.setText(MainListWord.get(3));
            char_5.setText("");
            char_6.setText("");
            char_7.setText("");
            char_8.setText("");
            char_9.setText("");
            char_10.setText("");
            char_11.setText("");
            char_12.setText("");
            char_13.setText("");
            char_14.setText("");
            char_5.setVisibility(VISIBLE);
        } else if (MainListWord.size() == 5){
            char_1.setText(MainListWord.get(0));
            char_2.setText(MainListWord.get(1));
            char_3.setText(MainListWord.get(2));
            char_4.setText(MainListWord.get(3));
            char_5.setText(MainListWord.get(4));
            char_6.setText("");
            char_7.setText("");
            char_8.setText("");
            char_9.setText("");
            char_10.setText("");
            char_11.setText("");
            char_12.setText("");
            char_13.setText("");
            char_14.setText("");
            char_6.setVisibility(VISIBLE);
        } else if (MainListWord.size() == 6){
            char_1.setText(MainListWord.get(0));
            char_2.setText(MainListWord.get(1));
            char_3.setText(MainListWord.get(2));
            char_4.setText(MainListWord.get(3));
            char_5.setText(MainListWord.get(4));
            char_6.setText(MainListWord.get(5));
            char_7.setText("");
            char_8.setText("");
            char_9.setText("");
            char_10.setText("");
            char_11.setText("");
            char_12.setText("");
            char_13.setText("");
            char_14.setText("");
            char_7.setVisibility(VISIBLE);
        } else if (MainListWord.size() == 7){
            char_1.setText(MainListWord.get(0));
            char_2.setText(MainListWord.get(1));
            char_3.setText(MainListWord.get(2));
            char_4.setText(MainListWord.get(3));
            char_5.setText(MainListWord.get(4));
            char_6.setText(MainListWord.get(5));
            char_7.setText(MainListWord.get(6));
            char_8.setText("");
            char_9.setText("");
            char_10.setText("");
            char_11.setText("");
            char_12.setText("");
            char_13.setText("");
            char_14.setText("");
            char_8.setVisibility(VISIBLE);
        } else if (MainListWord.size() == 8){
            char_1.setText(MainListWord.get(0));
            char_2.setText(MainListWord.get(1));
            char_3.setText(MainListWord.get(2));
            char_4.setText(MainListWord.get(3));
            char_5.setText(MainListWord.get(4));
            char_6.setText(MainListWord.get(5));
            char_7.setText(MainListWord.get(6));
            char_8.setText(MainListWord.get(7));
            char_9.setText("");
            char_10.setText("");
            char_11.setText("");
            char_12.setText("");
            char_13.setText("");
            char_14.setText("");
            char_9.setVisibility(VISIBLE);
        } else if (MainListWord.size() == 9){
            char_1.setText(MainListWord.get(0));
            char_2.setText(MainListWord.get(1));
            char_3.setText(MainListWord.get(2));
            char_4.setText(MainListWord.get(3));
            char_5.setText(MainListWord.get(4));
            char_6.setText(MainListWord.get(5));
            char_7.setText(MainListWord.get(6));
            char_8.setText(MainListWord.get(7));
            char_9.setText(MainListWord.get(8));
            char_10.setText("");
            char_11.setText("");
            char_12.setText("");
            char_13.setText("");
            char_14.setText("");
            char_10.setVisibility(VISIBLE);
        }else if (MainListWord.size() == 10){
            char_1.setText(MainListWord.get(0));
            char_2.setText(MainListWord.get(1));
            char_3.setText(MainListWord.get(2));
            char_4.setText(MainListWord.get(3));
            char_5.setText(MainListWord.get(4));
            char_6.setText(MainListWord.get(5));
            char_7.setText(MainListWord.get(6));
            char_8.setText(MainListWord.get(7));
            char_9.setText(MainListWord.get(8));
            char_10.setText(MainListWord.get(9));
            char_11.setText("");
            char_12.setText("");
            char_13.setText("");
            char_14.setText("");
            if (numsofliteralsinword > 10) {
                char_11.setVisibility(VISIBLE);
            }
        } else if (MainListWord.size() == 11){
            char_1.setText(MainListWord.get(0));
            char_2.setText(MainListWord.get(1));
            char_3.setText(MainListWord.get(2));
            char_4.setText(MainListWord.get(3));
            char_5.setText(MainListWord.get(4));
            char_6.setText(MainListWord.get(5));
            char_7.setText(MainListWord.get(6));
            char_8.setText(MainListWord.get(7));
            char_9.setText(MainListWord.get(8));
            char_10.setText(MainListWord.get(9));
            char_11.setText(MainListWord.get(10));
            char_12.setText("");
            char_13.setText("");
            char_14.setText("");
            if (numsofliteralsinword == 14) {
                char_12.setVisibility(VISIBLE);
            }
        } else if (MainListWord.size() == 12){
            char_1.setText(MainListWord.get(0));
            char_2.setText(MainListWord.get(1));
            char_3.setText(MainListWord.get(2));
            char_4.setText(MainListWord.get(3));
            char_5.setText(MainListWord.get(4));
            char_6.setText(MainListWord.get(5));
            char_7.setText(MainListWord.get(6));
            char_8.setText(MainListWord.get(7));
            char_9.setText(MainListWord.get(8));
            char_10.setText(MainListWord.get(9));
            char_11.setText(MainListWord.get(10));
            char_12.setText(MainListWord.get(11));
            char_13.setText("");
            char_14.setText("");
            if (numsofliteralsinword == 14) {
                char_13.setVisibility(VISIBLE);
            }
        } else if (MainListWord.size() == 13){
            char_1.setText(MainListWord.get(0));
            char_2.setText(MainListWord.get(1));
            char_3.setText(MainListWord.get(2));
            char_4.setText(MainListWord.get(3));
            char_5.setText(MainListWord.get(4));
            char_6.setText(MainListWord.get(5));
            char_7.setText(MainListWord.get(6));
            char_8.setText(MainListWord.get(7));
            char_9.setText(MainListWord.get(8));
            char_10.setText(MainListWord.get(9));
            char_11.setText(MainListWord.get(10));
            char_12.setText(MainListWord.get(11));
            char_13.setText(MainListWord.get(12));
            char_14.setText("");
            if (numsofliteralsinword == 14) {
                char_14.setVisibility(VISIBLE);
            }
        } else if (MainListWord.size() == 14){
            char_1.setText(MainListWord.get(0));
            char_2.setText(MainListWord.get(1));
            char_3.setText(MainListWord.get(2));
            char_4.setText(MainListWord.get(3));
            char_5.setText(MainListWord.get(4));
            char_6.setText(MainListWord.get(5));
            char_7.setText(MainListWord.get(6));
            char_8.setText(MainListWord.get(7));
            char_9.setText(MainListWord.get(8));
            char_10.setText(MainListWord.get(9));
            char_11.setText(MainListWord.get(10));
            char_12.setText(MainListWord.get(11));
            char_13.setText(MainListWord.get(12));
            char_14.setText(MainListWord.get(13));
        }

    } // изменение флага печати текста

    public void ClickButton1(View v){

        countID++;
        MainListWord.add(pr1.getText().toString());
        pr1.setBackgroundResource(R.drawable.main_press);
        pr1.setEnabled(false);

        SwitchTextField();
        ListXUpFull();

    } //кнопка 1
    public void ClickButton2(View v){

        countID++;
        MainListWord.add(pr2.getText().toString());
        pr2.setBackgroundResource(R.drawable.main_press);
        pr2.setEnabled(false);

        SwitchTextField();
        ListXUpFull();
    } //кнопка 2
    public void ClickButton3(View v){
        countID++;
        MainListWord.add(pr3.getText().toString());
        pr3.setBackgroundResource(R.drawable.main_press);
        pr3.setEnabled(false);

        SwitchTextField();
        ListXUpFull();

    } //кнопка 3
    public void ClickButton4(View v){
        countID++;
        MainListWord.add(pr4.getText().toString());
        pr4.setBackgroundResource(R.drawable.main_press);
        pr4.setEnabled(false);

        SwitchTextField();
        ListXUpFull();
    } //кнопка 4
    public void ClickButton5(View v){
        countID++;
        MainListWord.add(pr5.getText().toString());
        pr5.setBackgroundResource(R.drawable.main_press);
        pr5.setEnabled(false);

        SwitchTextField();
        ListXUpFull();
    } //кнопка 5
    public void ClickButton6(View v){
        countID++;
        MainListWord.add(pr6.getText().toString());
        pr6.setBackgroundResource(R.drawable.main_press);
        pr6.setEnabled(false);

        SwitchTextField();
        ListXUpFull();
    } //кнопка 6
    public void ClickButton7(View v){
        countID++;
        MainListWord.add(pr7.getText().toString());
        pr7.setBackgroundResource(R.drawable.main_press);
        pr7.setEnabled(false);

        SwitchTextField();
        ListXUpFull();
    } //кнопка 7
    public void ClickButton8(View v){
        countID++;
        MainListWord.add(pr8.getText().toString());
        pr8.setBackgroundResource(R.drawable.main_press);
        pr8.setEnabled(false);

        SwitchTextField();
        ListXUpFull();
    } //кнопка 8
    public void ClickButton9(View v){
        countID++;
        MainListWord.add(pr9.getText().toString());
        pr9.setBackgroundResource(R.drawable.main_press);
        pr9.setEnabled(false);

        SwitchTextField();
        ListXUpFull();
    } //кнопка 9
    public void ClickButton10(View v){
        countID++;
        MainListWord.add(pr10.getText().toString());
        pr10.setBackgroundResource(R.drawable.main_press);
        pr10.setEnabled(false);

        SwitchTextField();
        ListXUpFull();
    } //кнопка 10
    public void ClickButton11(View v){
        countID++;
        MainListWord.add(pr11.getText().toString());
        pr11.setBackgroundResource(R.drawable.main_press);
        pr11.setEnabled(false);

        SwitchTextField();
        ListXUpFull();
    } //кнопка 11
    public void ClickButton12(View v){
        countID++;
        MainListWord.add(pr12.getText().toString());
        pr12.setBackgroundResource(R.drawable.main_press);
        pr12.setEnabled(false);

        SwitchTextField();
        ListXUpFull();
    } //кнопка 12
    public void ClickButton13(View v){
        countID++;
        MainListWord.add(pr13.getText().toString());
        pr13.setBackgroundResource(R.drawable.main_press);
        pr13.setEnabled(false);

        SwitchTextField();
        ListXUpFull();
    } //кнопка 13
    public void ClickButton14(View v){
        countID++;
        MainListWord.add(pr14.getText().toString());
        pr14.setBackgroundResource(R.drawable.main_press);
        pr14.setEnabled(false);

        SwitchTextField();
        ListXUpFull();
    } //кнопка 14


    public void ResetField(View v){
        ressetChars();
    } //сброс кнопок

    private void ressetChars(){
        MainListWord.clear();
        char_1.setText("");
        char_2.setText("");
        char_3.setText("");
        char_4.setText("");
        char_5.setText("");
        char_6.setText("");
        char_7.setText("");
        char_8.setText("");
        char_9.setText("");
        char_10.setText("");
        char_11.setText("");
        char_12.setText("");
        char_13.setText("");
        char_14.setText("");

        EneblendButtonsAffterPress();

        char_4.setVisibility(GONE);
        char_5.setVisibility(GONE);
        char_6.setVisibility(GONE);
        char_7.setVisibility(GONE);
        char_8.setVisibility(GONE);
        char_9.setVisibility(GONE);
        char_10.setVisibility(GONE);
        char_11.setVisibility(GONE);
        char_12.setVisibility(GONE);
        char_13.setVisibility(GONE);
        char_14.setVisibility(GONE);
    }






    public void TaskShow(View v){
        TaskDialog();
        onClickStop();
    } //кнопка открытия заадний





    public void TaskDialog(){
        TaskDialog = new AlertDialog.Builder(this).create();
        LayoutInflater tasks = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = tasks.inflate(R.layout.task_fragment, null, false);
        butCloseTask =  v.findViewById(R.id.butCloseTask);


        thisWordShow = v.findViewById(R.id.thisWordShow);
        Thru_answer_1 = v.findViewById(R.id.Thru_answer_1);
        Thru_answer_2 = v.findViewById(R.id.Thru_answer_2);
        Thru_answer_3 = v.findViewById(R.id.Thru_answer_3);
        Thru_answer_4 = v.findViewById(R.id.Thru_answer_4);
        adapter_thru_1 = new ArrayAdapter<>(this, R.layout.simple_list_item_my, thru_list_1);
        adapter_thru_2 = new ArrayAdapter<>(this, R.layout.simple_list_item_my, thru_list_2);
        adapter_thru_3 = new ArrayAdapter<>(this, R.layout.simple_list_item_my, thru_list_3);
        adapter_thru_4 = new ArrayAdapter<>(this, R.layout.simple_list_item_my, thru_list_4);
        Thru_answer_1.setAdapter(adapter_thru_1);
        Thru_answer_2.setAdapter(adapter_thru_2);
        Thru_answer_3.setAdapter(adapter_thru_3);
        Thru_answer_4.setAdapter(adapter_thru_4);

        Wrong_answer_1 = v.findViewById(R.id.Wrong_answer_1);
        adapter_wrong_1 = new ArrayAdapter<>(this, R.layout.simple_list_item_my, Wrong_list_1);
        Wrong_answer_1.setAdapter(adapter_wrong_1);



        TaskDialog.setView(v);
        TaskDialog.setCancelable(true);

        butCloseTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickStart();
                TaskDialog.dismiss();
            }
        });

        thisWordShow.setText(getControl());

        if (getControl().equalsIgnoreCase("котлисаслон")) {
            Thru_answer_1.setVisibility(View.VISIBLE);
            Thru_answer_2.setVisibility(View.GONE);
            Thru_answer_3.setVisibility(View.GONE);
            Thru_answer_4.setVisibility(View.GONE);
            Wrong_answer_1.setVisibility(View.VISIBLE);
        } else if (getControl().equalsIgnoreCase("распределитель")) {
            Thru_answer_1.setVisibility(View.GONE);
            Thru_answer_2.setVisibility(View.VISIBLE);
            Thru_answer_3.setVisibility(View.GONE);
            Thru_answer_4.setVisibility(View.GONE);
            Wrong_answer_1.setVisibility(View.VISIBLE);
        } else if (getControl().equalsIgnoreCase("стенографистка")) {
            Thru_answer_1.setVisibility(View.GONE);
            Thru_answer_2.setVisibility(View.GONE);
            Thru_answer_3.setVisibility(View.VISIBLE);
            Thru_answer_4.setVisibility(View.GONE);
            Wrong_answer_1.setVisibility(View.VISIBLE);
        } else if (getControl().equalsIgnoreCase("простокваша")) {
            Thru_answer_1.setVisibility(View.GONE);
            Thru_answer_2.setVisibility(View.GONE);
            Thru_answer_3.setVisibility(View.GONE);
            Thru_answer_4.setVisibility(View.VISIBLE);
            Wrong_answer_1.setVisibility(View.VISIBLE);
        }
        TaskDialog.show();

    }  // список собранных слов






    public void AddDB()   {
        String a1, a2, a3;
        a1 = String.valueOf(getCounter()); // очки
        a2 = String.valueOf(getStepOnNextLvl()); // уровень
        a3 = String.valueOf(getTryChenge()); // попыток смены
        dbHelper.WriteDB(a1, a2, a3);
        //dbHelper.UpdateDB(a1, a2, a3);
        // Toast.makeText(this, a1+" "+a2+" "+a3, Toast.LENGTH_SHORT).show();
    } // добавить запись
    public void ReadfromDB() {
        dbHelper.ReadDB();
        setCounter(dbHelper.getValueScore());
        setStepOnNextLvl(dbHelper.getValueLvl());
        setTryChenge(dbHelper.getValueTrys());

        Log.d("prob", ""+getCounter()+""+getTryChenge() + ""+getStepOnNextLvl());
    } // прочесть последнюю запись
    public void DeleteDB(View v) {
        CleareDB();
    }
    public void CleareDB() {
        dbHelper.DeleteDB();
        setCounter(0);   //чтение и запись БД очки
        setStepOnNextLvl(0); //чтение и запись БД уровень
        setTryChenge(0); //чтение и запись БД попыток смены слов
        setAddsc(""+0);
        setAddlvl(""+0);
        setAddtryss(""+0);
    }// удалить

    //---работа с таблицей длинны слов букв
    public void AddDB_lenght(){
        String  b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b_plus, b_minus;
        b3 = String.valueOf(getList_3());
        b4 = String.valueOf(getList_4());
        b5 = String.valueOf(getList_5());
        b6 = String.valueOf(getList_6());
        b7 = String.valueOf(getList_7());
        b8 = String.valueOf(getList_8());
        b9 = String.valueOf(getList_9());
        b10 = String.valueOf(getList_10());
        b11 = String.valueOf(getList_11());
        b12 = String.valueOf(getList_12());
        b13 = String.valueOf(getList_13());
        b14 = String.valueOf(getList_14());
        b_plus = String.valueOf(getLenght_plus());
        b_minus = String.valueOf(getLenght_minus_minus());

        dbHelper.WriteDB_lenght(b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b_plus, b_minus);
    }
    public void ReadfromDB_lenght() {
        dbHelper.ReadDB_lenght();
        setList_3(dbHelper.getLENGHT_3());
        setList_4(dbHelper.getLENGHT_4());
        setList_5(dbHelper.getLENGHT_5());
        setList_6(dbHelper.getLENGHT_6());
        setList_7(dbHelper.getLENGHT_7());
        setList_8(dbHelper.getLENGHT_8());
        setList_9(dbHelper.getLENGHT_9());
        setList_10(dbHelper.getLENGHT_10());
        setList_11(dbHelper.getLENGHT_11());
        setList_12(dbHelper.getLENGHT_12());
        setList_13(dbHelper.getLENGHT_13());
        setList_14(dbHelper.getLENGHT_14());
        setList_sum(getList_3()+getList_4()+getList_5()+getList_6()+getList_7()+getList_8()+getList_9()+getList_10()+getList_11()+getList_12()+getList_13()+getList_14());
        setLenght_plus(dbHelper.getLENGHT_PLUS());
        setLenght_minus_minus(dbHelper.getLENGHT_MINUS());



    } // прочесть последнюю запись
    //--


    //--------------сохранение-чтение списка собравнных слов
    public List<String> Switch_answer() {
        if (getControl().equalsIgnoreCase("котлисаслон")) {
            this.Alfas = thru_list_1;
            return this.Alfas;
        } else if (getControl().equalsIgnoreCase("распределитель")) {
            this.Alfas = thru_list_2;
            return this.Alfas;
        } else if (getControl().equalsIgnoreCase("стенографистка")) {
            this.Alfas = thru_list_3;
            return this.Alfas;
        } else  {
            this.Alfas = thru_list_4;
        }
        Log.d("QQW", getControl());
        return this.Alfas;
    }
    private String array2str(List<String> strings){
        StringBuilder sb = new StringBuilder();
        for (String s : strings){
            sb.append(s+ "\n");
        }
        return sb.toString();
    } //запись в тхт
    public void SaveText()  {
        myText = array2str(Switch_answer());
        if (getControl().equalsIgnoreCase("котлисаслон")) {
            this.writeTrue = "text_true_dio_1.txt";
        } else if (getControl().equalsIgnoreCase("распределитель")) {
            this.writeTrue = "text_true_dio_2.txt";
        } else if (getControl().equalsIgnoreCase("стенографистка")) {
            this.writeTrue = "text_true_dio_3.txt";
        } else if (getControl().equalsIgnoreCase("простокваша")) {
            this.writeTrue = "text_true_dio_4.txt";
        }
        try {
            outputStream = openFileOutput(writeTrue, MODE_PRIVATE);
            outputStream.write(myText.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();                   //если КОТЛИСАСЛОН - запись в файл кот.тхт, если другое, то в другое.тхт и показ того же списка.
        }
    } //запись в тхт
    public void LoadText() throws IOException {
        String line;
        if (getControl().equalsIgnoreCase("котлисаслон")) {
            this.read = "text_true_dio_1.txt";
        } else if (getControl().equalsIgnoreCase("распределитель")) {
            this.read = "text_true_dio_2.txt";
        } else if (getControl().equalsIgnoreCase("стенографистка")) {
            this.read = "text_true_dio_3.txt";
        } else if (getControl().equalsIgnoreCase("простокваша")) {
            this.read = "text_true_dio_4.txt";
        }
        try {
            FileInputStream in = openFileInput(read);
            InputStreamReader inputStreamReader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
//                        sb.append(line);
                if (getControl().equalsIgnoreCase("котлисаслон")) {
                    thru_list_1.add(line);
                } else if (getControl().equalsIgnoreCase("распределитель")) {
                    thru_list_2.add(line);
                } else if (getControl().equalsIgnoreCase("стенографистка")) {
                    thru_list_3.add(line);
                } else if (getControl().equalsIgnoreCase("простокваша")) {
                    thru_list_4.add(line);
                }
                inputStreamReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //-------
    public List<String> Wrong_Switch_answer() {
        this.WrongSwitch = Wrong_list_1;
        return this.WrongSwitch;
    }
    private String array2strWrong(List<String> strings){
        StringBuilder sb = new StringBuilder();
        for (String s : strings){
            sb.append(s+ "\n");
        }
        return sb.toString();
    } //запись в тхт НЕ ВЕРНО
    public void WriteWrong(){
        myText = array2strWrong(Wrong_Switch_answer());
        this.writeWrong = "text_wrong_dio_1.txt";
        try {
            outputStream = openFileOutput(writeWrong, MODE_PRIVATE);
            outputStream.write(myText.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();                   //если КОТЛИСАСЛОН - запись в файл кот.тхт, если другое, то в другое.тхт и показ того же списка.
        }
    } //запись в тхт
    public void ReadFromTxtWrong(){
        String lineWrong;
        this.readWrong = "text_wrong_dio_1.txt";

        try {
            FileInputStream in = openFileInput(readWrong);
            InputStreamReader inputStreamReader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            while ((lineWrong = bufferedReader.readLine()) != null) {
                sb.append(lineWrong);
//                        sb.append(line);
                if (getControl().equalsIgnoreCase("котлисаслон")) {
                    Wrong_list_1.add(lineWrong);
                } else if (getControl().equalsIgnoreCase("распределитель")) {
                    Wrong_list_1.add(lineWrong);
                } else if (getControl().equalsIgnoreCase("стенографистка")) {
                    Wrong_list_1.add(lineWrong);
                } else if (getControl().equalsIgnoreCase("простокваша")) {
                    Wrong_list_1.add(lineWrong);
                }
                inputStreamReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    protected void onDestroy() {
        SaveText();
//        Save_lenght_plus();
        AddDB();
        AddDB_lenght();


        super.onDestroy();
    }


    public void Mission_random_lenght(View v) {
        MissionDialogStart();
        onClickStop();


    }
    public void MissionDialogStart(){

        LayoutInflater li = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View tasks = li.inflate(R.layout.achivs_fragment, null, false);

        MissionsDialog = new AlertDialog.Builder(this).create();
        MissionsDialog.setTitle("Статистика");
        butClose_mission =  tasks.findViewById(R.id.butClose);
            word_stat_lit_all = tasks.findViewById(R.id.word_stat_lit_all);
            word_stat_lit_3 = tasks.findViewById(R.id.word_stat_lit_3);
            word_stat_lit_4 = tasks.findViewById(R.id.word_stat_lit_4);
            word_stat_lit_5 = tasks.findViewById(R.id.word_stat_lit_5);
            word_stat_lit_6 = tasks.findViewById(R.id.word_stat_lit_6);
            word_stat_lit_7 = tasks.findViewById(R.id.word_stat_lit_7);
            word_stat_lit_8 = tasks.findViewById(R.id.word_stat_lit_8);
            word_stat_lit_9 = tasks.findViewById(R.id.word_stat_lit_9);
            word_stat_lit_10 = tasks.findViewById(R.id.word_stat_lit_10);
            word_stat_lit_11 = tasks.findViewById(R.id.word_stat_lit_11);
            word_stat_lit_12 = tasks.findViewById(R.id.word_stat_lit_12);
            word_stat_lit_13 = tasks.findViewById(R.id.word_stat_lit_13);
            word_stat_lit_14 = tasks.findViewById(R.id.word_stat_lit_14);


                word_stat_lit_3.setText(""+getList_3());
                word_stat_lit_4.setText(""+getList_4());
                word_stat_lit_5.setText(""+getList_5());
                word_stat_lit_6.setText(""+getList_6());
                word_stat_lit_7.setText(""+getList_7());
                word_stat_lit_8.setText(""+getList_8());
                word_stat_lit_9.setText(""+getList_9());
                word_stat_lit_10.setText(""+getList_10());
                word_stat_lit_11.setText(""+getList_11());
                word_stat_lit_12.setText(""+getList_12());
                word_stat_lit_13.setText(""+getList_13());
                word_stat_lit_14.setText(""+getList_14());
                word_stat_lit_all.setText(""+getList_sum());

                        word_bar_all = tasks.findViewById(R.id.word_bar_all);
                        word_bar_3 = tasks.findViewById(R.id.word_bar_3);
                        word_bar_4 = tasks.findViewById(R.id.word_bar_4);
                        word_bar_5 = tasks.findViewById(R.id.word_bar_5);
                        word_bar_6 = tasks.findViewById(R.id.word_bar_6);
                        word_bar_7 = tasks.findViewById(R.id.word_bar_7);
                        word_bar_8 = tasks.findViewById(R.id.word_bar_8);
                        word_bar_9 = tasks.findViewById(R.id.word_bar_9);
                        word_bar_10 = tasks.findViewById(R.id.word_bar_10);
                        word_bar_11 = tasks.findViewById(R.id.word_bar_11);
                        word_bar_12 = tasks.findViewById(R.id.word_bar_12);
                        word_bar_13 = tasks.findViewById(R.id.word_bar_13);
                        word_bar_14 = tasks.findViewById(R.id.word_bar_14);

                            word_bar_all.setMax(3141);
                                word_bar_all.setProgress(getList_sum());
                            word_bar_3.setMax(511);
                                word_bar_3.setProgress(getList_3());
                             word_bar_4.setMax(765);
                                word_bar_4.setProgress(getList_4());
                            word_bar_5.setMax(792);
                                word_bar_5.setProgress(getList_5());
                            word_bar_6.setMax(534);
                                word_bar_6.setProgress(getList_6());
                            word_bar_7.setMax(307);
                                word_bar_7.setProgress(getList_7());
                            word_bar_8.setMax(158);
                                word_bar_8.setProgress(getList_8());
                            word_bar_9.setMax(40);
                                word_bar_9.setProgress(getList_9());
                            word_bar_10.setMax(21);
                                word_bar_10.setProgress(getList_10());
                            word_bar_11.setMax(1);
                                word_bar_11.setProgress(getList_11());
                            word_bar_12.setMax(4);
                                word_bar_12.setProgress(getList_12());
                            word_bar_13.setMax(5);
                                word_bar_13.setProgress(getList_13());
                            word_bar_14.setMax(3);
                                word_bar_14.setProgress(getList_14());



        MissionsDialog = new AlertDialog.Builder(this).create();






        butClose = tasks.findViewById(R.id.butClose);
        MissionsDialog.setView(tasks);
        MissionsDialog.setCancelable(true);

        butClose.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                MissionsDialog.dismiss();
            }
        });
        MissionsDialog.show();

//        howAchivites();

        butClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickStart();
                MissionsDialog.dismiss();
            }
        });
    }


    public void open_menu(View v){
        OptionMenu();
    }
    public void OptionMenu(){
        OptionDialog = new AlertDialog.Builder(this).create();
        LayoutInflater menuOpt = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = menuOpt.inflate(R.layout.option_menu, null, false);
        butCloseOption =  v.findViewById(R.id.butCloseOption);

        butClose_mission =  v.findViewById(R.id.butCloseOption);

        task = v.findViewById(R.id.task);
        quest = v.findViewById(R.id.quest);
        faq = v.findViewById(R.id.faq);



        OptionDialog.setView(v);


        butCloseOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickStart();
                OptionDialog.dismiss();
            }
        });


        OptionDialog.show();

    }  // список собранных слов










    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Выйти из приложения на главный жкран?")
                .setMessage("Вы действительно хотите выйти?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        //SomeActivity - имя класса Activity для которой переопределяем onBackPressed();

                        Intent intent = new Intent(GameStart.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                }).create().show();
    } //переназнчание кнопки назад

}


//Ачивка за сбор  слова (3 раза словао из 3 букв ,только если они верные) сделать. сейчас все слова в зачет идут.



