package freijer.app.dropwords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

import freijer.app.dropwords.settings.SettingsAndParams;

public class MainActivity extends AppCompatActivity {

    protected Button play;
    protected String income;
    protected int speed;
    protected String login_nameStart;
    protected String whyLogin;

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        play = findViewById(R.id.play);
        income= null;

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String income1 = bundle.getString("setSpeed");
            setSpeed(Integer.parseInt(income1));
            Log.d("SPEED", ""+getSpeed());
        }






    }


    public void Play(View v) {
        Intent intent = new Intent(this, GameStart.class);
            whyLogin = "player";
                this.login_nameStart = "player";
                String output_msg =  String.valueOf(getSpeed());
                    intent.putExtra("login", login_nameStart);
                    intent.putExtra("setSpeed_buttons", output_msg);
                        startActivity(intent);
    }


    public void Settings_and_params(View v){
        Intent intent_settings = new Intent(this, SettingsAndParams.class);
        String output_msg =  String.valueOf(getSpeed());
        intent_settings.putExtra("setSpeed_buttons", output_msg);
        startActivity(intent_settings);
    }

}


