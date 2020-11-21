package freijer.app.dropwords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button play;
    EditText login;
    String login_nameStart;
    String whyLogin;
    Supports supportClass = new Supports();
    String a1;

    public String getNewLogin() {
        return newLogin;
    }
    public void setNewLogin(String newLogin) {
        this.newLogin = newLogin;
    }

    String newLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        play = findViewById(R.id.play);
        login = findViewById(R.id.login);

    }


    public void Play(View v) {




        Intent intent = new Intent(this, GameStart.class);

        whyLogin = login.getText().toString();

        if (whyLogin.matches("")) {
            Toast.makeText(this, "Введите имя игрока", Toast.LENGTH_SHORT).show();
        } else {
            this.login_nameStart = login.getText().toString();
            intent.putExtra("login", login_nameStart);
            startActivity(intent);
        }
    }


    }


