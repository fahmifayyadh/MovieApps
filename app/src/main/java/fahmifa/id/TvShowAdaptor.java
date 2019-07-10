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

public class TvShowAdaptor extends RecyclerView.Adapter<TvShowAdaptor.MyViewHolder> {

    private Context context;
    private List<TvData> tv;

    TvShowAdaptor(Context context, List<TvData> tv) {
        this.context = context;
        this.tv= tv;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.tv_show_list, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.judulTv.setText(tv.get(i).getJudulTv());
        myViewHolder.genreTv.setText(tv.get(i).getGenreTv());
        myViewHolder.photoTv.setImageResource(tv.get(i).getPhotoTv());
    }

    @Override
    public int getItemCount() {
        return tv.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView judulTv,genreTv;
        private ImageView photoTv;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            judulTv= itemView.findViewById(R.id.tv_Judulx);
            genreTv= itemView.findViewById(R.id.tv_genre);
            photoTv=itemView.findViewById(R.id.img_Foto);

        }
    }
}
