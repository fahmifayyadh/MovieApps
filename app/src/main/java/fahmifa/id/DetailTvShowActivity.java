package fahmifa.id;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailTvShowActivity extends AppCompatActivity {
    public static final String TV = "DetailTv";
    TextView judul,date,direktor,top,rate, genre, sinopsis;
    ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);
        judul=findViewById(R.id.tv_Judulx);
        date=findViewById(R.id.tv_date);
        direktor=findViewById(R.id.tv_director);
        top=findViewById(R.id.tv_top);
        rate=findViewById(R.id.tv_rate);
        genre = findViewById(R.id.tv_genre);
        sinopsis = findViewById(R.id.tv_sinopsis);
        photo=findViewById(R.id.img_Foto);


        TvData tv= getIntent().getParcelableExtra(TV);
        judul.setText(tv.getJudulTv());
        date.setText(tv.getDateTv());
        direktor.setText(tv.getDirectorTv());
        top.setText(tv.getTopTv());
        rate.setText(tv.getRateTv());
        genre.setText(tv.getGenreTv());
        sinopsis.setText(tv.getSinopsisTv());
        photo.setImageResource(tv.getPhotoTv());
    }
}
