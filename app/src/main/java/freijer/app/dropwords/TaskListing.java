package freijer.app.dropwords;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;


public class TaskListing  {





    Random rand = new Random();
    private int indexWord;
    protected String word;
    protected ArrayList <String> list = new ArrayList <String>();

    protected String task_1;
    protected String task_2;

    public void GetMoreTask(){
        ListUp();
        GetTask_1();
        GetTask_2();

    }

    public void ListUp() {
        list.add("Собрать 3 слова из 3 букв");
        list.add("Собрать 1 слово из 5 букв");
        list.add("Собрать 1 слово из 4 букв");
        list.add("Собрать слова без повторов");
    }


    public void GetTask_1(){
        if (!list.isEmpty()) {
            this.indexWord = rand.nextInt(list.size());
            this.word = list.get(indexWord);
            this.list.remove(this.word);
        } else if (list.isEmpty()) {
          // this.word = "конец";
           ListUp();
        }
         this.task_1 =  this.word;
  }
    public void GetTask_2(){
        if (!list.isEmpty()) {
            this.indexWord = rand.nextInt(list.size());
            this.word = list.get(indexWord);
            this.list.remove(this.word);
        } else if (list.isEmpty()) {
            ListUp();
        }
        this.task_2 = this.word;
    }

    protected void Goze() {



//        AlertDialog.Builder builder1 = new AlertDialog.Builder(TaskListing);
//        builder1.setMessage("Write your message here.");
//        builder1.setCancelable(true);
//
//        builder1.setPositiveButton(
//                "Yes",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                    }
//                });
//
//        builder1.setNegativeButton(
//                "No",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                    }
//                });
//
//        AlertDialog alert11 = builder1.create();
//        alert11.show();
    }


}

