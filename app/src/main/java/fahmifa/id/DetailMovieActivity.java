package fahmifa.id;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String moviess = "MOVIE";
    TextView title,genre,direktor,actor,sinopsis, date,rate;
    ImageView poto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        title=findViewById(R.id.tv_Judulx);
        genre=findViewById(R.id.tv_genre);
        direktor=findViewById(R.id.tv_director);
        actor=findViewById(R.id.tv_top);
        sinopsis=findViewById(R.id.tv_sinopsis);
        poto=findViewById(R.id.img_Foto);
        date = findViewById(R.id.tv_date);
        rate = findViewById(R.id.tv_rate);

        MovieData movie= getIntent().getParcelableExtra(moviess);
        title.setText(movie.getJudul());
        genre.setText(movie.getGenre());
        direktor.setText(movie.getDirector());
        actor.setText(movie.getTop());
        sinopsis.setText(movie.getSinopsis());
        poto.setImageResource(movie.getPhoto());
        date.setText(movie.getDate());
        rate.setText(movie.getRate());
    }
}
