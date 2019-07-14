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
    private List<TvData>tvs;

    TvAdapter(Context context, List<TvData>tvs){
        this.context=context;
        this.tvs=tvs;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.tvshow_list, viewGroup ,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.judul.setText(tvs.get(i).getJudulTv());
        myViewHolder.genre.setText(tvs.get(i).getGenreTv());
        myViewHolder.photo.setImageResource(tvs.get(i).getPhotoTv());

    }

    @Override
    public int getItemCount() {
        return tvs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView judul, genre;
        private ImageView photo;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            judul=itemView.findViewById(R.id.judultv);
            genre=itemView.findViewById(R.id.genretv);
            photo=itemView.findViewById(R.id.phototv);
        }
    }
}
