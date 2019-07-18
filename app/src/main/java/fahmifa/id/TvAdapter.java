package fahmifa.id;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.MyViewHolder> {

    private Context context;
    private List<TvData> tv;

    TvAdapter(Context context, List<TvData> tv) {
        this.context = context;
        this.tv= tv;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.tvshow_list, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.title.setText(tv.get(i).getJudulTv());
        myViewHolder.genre.setText(tv.get(i).getGenreTv());
        myViewHolder.poster.setImageResource(tv.get(i).getPhotoTv());
    }

    @Override
    public int getItemCount() {
        return tv.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title,genre;
        private ImageView poster;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title= itemView.findViewById(R.id.judultv);
            genre= itemView.findViewById(R.id.genretv);
            poster= itemView.findViewById(R.id.phototv);

        }
    }
}
