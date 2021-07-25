package freijer.app.dropwords;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class achives_stats extends AppCompatActivity {

    private TextView word_stat_lit_1;
    private Button butClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achives_stats);

        word_stat_lit_1 = findViewById(R.id.word_stat_lit_1);
        butClose = findViewById(R.id.butClose);


        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String all_literals = bundle.getString("sum_literals");
            word_stat_lit_1.setText(all_literals);

        }

    }


    public void back(View v){
        Intent intent = new Intent(this, GameStart.class);
        startActivity(intent);
    }


}
