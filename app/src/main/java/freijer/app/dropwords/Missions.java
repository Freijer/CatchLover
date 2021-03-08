package freijer.app.dropwords;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Missions extends AppCompatActivity {

    protected TextView mis_1, mis_2, mis_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missions);

        mis_1 = findViewById(R.id.mis_1);
        mis_2 = findViewById(R.id.mis_2);
        mis_3 = findViewById(R.id.mis_3);

            TextOnButton();
    }



    public void TextOnButton(){
        mis_1.setText("Слово из 3 букв");
        mis_2.setText("Слово из 4 букв");
        mis_3.setText("С * Р А"); //СЕРА
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Выйти из приложения на главный жкран?")
                .setMessage("Вы действительно хотите выйти?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        //SomeActivity - имя класса Activity для которой переопределяем onBackPressed();

                    }
                }).create().show();
    } //переназнчание кнопки назад
}
