package freijer.app.dropwords;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewViewHolder> {

    private ArrayList<RecyclerViewItem> arrayList;

    public static class RecyclerViewViewHolder extends RecyclerView.ViewHolder {




    public ImageView imageView_1;
    public TextView textview_1;


        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_1 = itemView.findViewById(R.id.imageView_1);
            textview_1 = itemView.findViewById(R.id.textview_1);
        }
    }


    public RecyclerViewAdapter(ArrayList<RecyclerViewItem> arrayList){
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
            RecyclerViewViewHolder recyclerViewViewHolder= new RecyclerViewViewHolder(view);
            return  recyclerViewViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder recyclerViewViewHolder, int position) {
        RecyclerViewItem recyclerViewItem = arrayList.get(position);
            recyclerViewViewHolder.imageView_1.setImageResource(recyclerViewItem.getImageResource());
            recyclerViewViewHolder.textview_1.setText(recyclerViewItem.getText_1());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }












}
