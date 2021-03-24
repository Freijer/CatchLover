package freijer.app.dropwords;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    public ArrayList<Model> myValues = new ArrayList<>();
    public int img1;

    public RecyclerViewAdapter(int imgIn) {
        this.img1 = imgIn;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.myTextView.setText(myValues.get(position).getText());
        if (myValues.get(position).getPeremennaya() > 0)
            holder.img.setImageResource(R.drawable.star);
    }


    public void setList(ArrayList<Model> list) {
        myValues.clear();
        myValues.addAll(list);
        notifyDataSetChanged();
    }

    public void setImage(int position){
        myValues.get(position).setPeremennaya(1);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return myValues.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView myTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.textview_1);
            img = itemView.findViewById(R.id.imag);
        }
    }
}