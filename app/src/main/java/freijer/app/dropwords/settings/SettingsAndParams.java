package freijer.app.dropwords.settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import freijer.app.dropwords.DataBase.DataHelper;
import freijer.app.dropwords.GameStart;
import freijer.app.dropwords.MainActivity;
import freijer.app.dropwords.R;

public class SettingsAndParams extends AppCompatActivity {

    protected Button reset_no, reset_yes;
    protected Button total_resset, standart_game, time_game, no_idea_game;
    protected SwitchCompat switch_fast, switch_slow, switch_mediun;
    private AlertDialog ResetDialog;



    FileOutputStream outputStream;
    DataHelper dbHelper;
    private int speed_settings;
    public int getSpeed_settings() {
        return speed_settings;
    }
    public void setSpeed_settings(int speed_settings) {
        this.speed_settings = speed_settings;
    }



    public void notNow(View v){
        Toast toast = Toast.makeText(this, "В разработке!",Toast.LENGTH_SHORT);
        toast.show();
    }

    public void sentRecent(View v){
        Intent telegram = new Intent(Intent.ACTION_VIEW , Uri.parse("https://t.me/Freijer"));
        startActivity(telegram);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_and_params);

        switch_fast = findViewById(R.id.switch_fast);
        switch_slow = findViewById(R.id.switch_slow);
        switch_mediun = findViewById(R.id.switch_mediun);



                total_resset = findViewById(R.id. total_resset);
        standart_game = findViewById(R.id.standart_game);
                time_game = findViewById(R.id.time_game);

                no_idea_game = findViewById(R.id.no_idea_game);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String income1 = bundle.getString("setSpeed_buttons");
            setSpeed_settings(Integer.parseInt(income1));
            Log.d("SPEED2", ""+getSpeed_settings());
        }

        if (getSpeed_settings() == 5500) {
            switch_mediun.setChecked(false);
            switch_fast.setChecked(false);
            switch_slow.setChecked(true);
        } else if (getSpeed_settings() == 0) {
            switch_fast.setChecked(false);
            switch_slow.setChecked(false);
            switch_mediun.setChecked(true);
        } else if (getSpeed_settings() == -2500) {
            switch_mediun.setChecked(false);
            switch_slow.setChecked(false);
            switch_fast.setChecked(true);
        }

        switch_slow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    switch_mediun.setChecked(false);
                    switch_fast.setChecked(false);
                    setSpeed_settings(5500);
                }else if(!switch_fast.isChecked() &!switch_slow.isChecked()) {
                    switch_mediun.setChecked(true);
                }
            }
        });

        switch_mediun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    switch_fast.setChecked(false);
                    switch_slow.setChecked(false);
                    setSpeed_settings(0);
                } else if(!switch_fast.isChecked() &!switch_slow.isChecked()) {
                    switch_mediun.setChecked(true);
                }
            }
        });

        switch_fast.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    switch_mediun.setChecked(false);
                    switch_slow.setChecked(false);
                    setSpeed_settings(-2500);
                }else if(!switch_fast.isChecked() &!switch_slow.isChecked()) {
                    switch_mediun.setChecked(true);
                }
            }
        });
    }








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

