package freijer.app.dropwords.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import freijer.app.dropwords.DataBase.DataHelper;
import freijer.app.dropwords.GameStart;
import freijer.app.dropwords.MainActivity;
import freijer.app.dropwords.R;

public class SettingsAndParams extends AppCompatActivity {

    protected Button fast, medium, slow, reset_no, reset_yes;
    protected ImageView fast_view, medium_view, slow_view;
    protected Button speed_game, total_resset, standart_game, time_game, languache_game, no_idea_game;
    private AlertDialog SpeedDialog, ResetDialog;



    FileOutputStream outputStream;
    DataHelper dbHelper;
    private int speed_settings;
    public int getSpeed_settings() {
        return speed_settings;
    }
    public void setSpeed_settings(int speed_settings) {
        this.speed_settings = speed_settings;
    }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_and_params);

        speed_game = findViewById(R.id.speed_game);
                total_resset = findViewById(R.id. total_resset);
        standart_game = findViewById(R.id.standart_game);
                time_game = findViewById(R.id.time_game);
        languache_game = findViewById(R.id.languache_game);
                no_idea_game = findViewById(R.id.no_idea_game);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String income1 = bundle.getString("setSpeed_buttons");
            setSpeed_settings(Integer.parseInt(income1));
            Log.d("SPEED2", ""+getSpeed_settings());
        }
    }

    public void Change_speed(View v) {
        SpeedDialog = new AlertDialog.Builder(this).create();
        LayoutInflater tasks = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        assert tasks != null;
        @SuppressLint("InflateParams") View view = tasks.inflate(R.layout.speed_dialog, null, false);
        fast = view.findViewById(R.id.fast);
        medium = view.findViewById(R.id.medium);
        slow = view.findViewById(R.id.slow);
        fast_view = view.findViewById(R.id.fast_view);
        medium_view = view.findViewById(R.id.medium_view);
        slow_view = view.findViewById(R.id.slow_view);

        SpeedDialog.setView(view);
        SpeedDialog.setCancelable(true);

        fast_view.setVisibility(View.GONE);
        medium_view.setVisibility(View.GONE);
        slow_view.setVisibility(View.GONE);

        fast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSpeed_settings(-2500);
                Log.d("speed_f", String.valueOf(getSpeed_settings()));
                SpeedDialog.dismiss();
            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSpeed_settings(0);
                Log.d("speed_f", String.valueOf(getSpeed_settings()));
                SpeedDialog.dismiss();
            }
        });

        slow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSpeed_settings(5500);
                Log.d("speed_f", String.valueOf(getSpeed_settings()));
                SpeedDialog.dismiss();
            }
        });

        if (getSpeed_settings() == 5500) {
            fast_view.setVisibility(View.GONE);
            medium_view.setVisibility(View.GONE);
            slow_view.setVisibility(View.VISIBLE);
        } else if (getSpeed_settings() == 0) {
            fast_view.setVisibility(View.GONE);
            medium_view.setVisibility(View.VISIBLE);
            slow_view.setVisibility(View.GONE);
        } else if (getSpeed_settings() == -2500) {
            fast_view.setVisibility(View.VISIBLE);
            medium_view.setVisibility(View.GONE);
            slow_view.setVisibility(View.GONE);
         }
            SpeedDialog.show();
        }  // список собранных слов



    public void Totaly_reset_progress(View v) throws IOException {

        ResetDialog = new AlertDialog.Builder(this).create();
        LayoutInflater tasks = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        assert tasks != null;
        @SuppressLint("InflateParams") View view = tasks.inflate(R.layout.reset_resultats, null, false);
        reset_no = view.findViewById(R.id.reset_no);
        reset_yes = view.findViewById(R.id.reset_yes);

        dbHelper = new DataHelper(this);

        ResetDialog.setView(view);
        ResetDialog.setCancelable(true);

        reset_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResetDialog.dismiss();
            }
        });

        reset_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ClearData();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ResetDialog.dismiss();
                Intent intentBacks = new Intent(SettingsAndParams.this, MainActivity.class);
                String output_msg =  String.valueOf(getSpeed_settings());
                intentBacks.putExtra("setSpeed", output_msg);
                startActivity(intentBacks);
                finish();
            }
        });
        ResetDialog.show();
    }
    public void ClearData() throws IOException {
        dbHelper.DeleteDB();
            outputStream = openFileOutput("text_true_dio_1.txt", MODE_PRIVATE);
            outputStream.write("".getBytes());
            outputStream.close();
                outputStream = openFileOutput("text_true_dio_2.txt", MODE_PRIVATE);
                outputStream.write("".getBytes());
                outputStream.close();
                    outputStream = openFileOutput("text_true_dio_3.txt", MODE_PRIVATE);
                    outputStream.write("".getBytes());
                    outputStream.close();
                        outputStream = openFileOutput("text_true_dio_4.txt", MODE_PRIVATE);
                        outputStream.write("".getBytes());
                        outputStream.close();
        outputStream = openFileOutput("text_wrong_dio_1.txt", MODE_PRIVATE);
        outputStream.write("".getBytes());
        outputStream.close();
            outputStream = openFileOutput("text_wrong_dio_2.txt", MODE_PRIVATE);
            outputStream.write("".getBytes());
            outputStream.close();
                outputStream = openFileOutput("text_wrong_dio_3.txt", MODE_PRIVATE);
                outputStream.write("".getBytes());
                outputStream.close();
                    outputStream = openFileOutput("text_wrong_dio_4.txt", MODE_PRIVATE);
                    outputStream.write("".getBytes());
                    outputStream.close();

        dbHelper.DeleteDB_lenght();
            outputStream = openFileOutput("taskDoneList.txt", MODE_PRIVATE);
            outputStream.write("".getBytes());
            outputStream.close();

        outputStream = openFileOutput("txt_plus.txt", MODE_PRIVATE);
        outputStream.write("".getBytes());
        outputStream.close();
            outputStream = openFileOutput("txt_minus.txt", MODE_PRIVATE);
            outputStream.write("".getBytes());
            outputStream.close();

    }
    public void Back(View v){
        Intent intentBack = new Intent(SettingsAndParams.this, MainActivity.class);
        String output_msg =  String.valueOf(getSpeed_settings());
        intentBack.putExtra("setSpeed", output_msg);
        startActivity(intentBack);
    }
    @Override
    public void onBackPressed() {
        Intent intentBacks = new Intent(SettingsAndParams.this, MainActivity.class);
        String output_msg =  String.valueOf(getSpeed_settings());
        intentBacks.putExtra("setSpeed", output_msg);
        startActivity(intentBacks);
        finish();
    }///переназнчание кнопки назад
}

