package freijer.app.dropwords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        play = findViewById(R.id.play);
    }


    public void Play(View v) {
        Intent intent = new Intent(".GameStart");
        startActivity(intent);

    }
}
