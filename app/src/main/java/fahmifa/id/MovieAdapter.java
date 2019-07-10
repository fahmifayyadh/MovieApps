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

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private Context context;
    private List<MovieData> movies;

    MovieAdapter(Context context, List<MovieData> movies) {
        this.context = context;
        this.movies= movies;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_list, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.title.setText(movies.get(i).getJudul());
        myViewHolder.genre.setText(movies.get(i).getGenre());
        myViewHolder.poster.setImageResource(movies.get(i).getPhoto());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title,genre;
        private ImageView poster;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title= itemView.findViewById(R.id.tv_Judulx);
            genre= itemView.findViewById(R.id.tv_genre);
            poster= itemView.findViewById(R.id.img_Foto);

        }
    }
}
