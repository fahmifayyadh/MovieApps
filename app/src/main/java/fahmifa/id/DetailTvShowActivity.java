package fahmifa.id;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailTvShowActivity extends AppCompatActivity {
    public static final String tvss ="Movie";
    TextView judulTv, genreTv, sinopsisTv, directorTv, topTv, rateTv, dateTv;
    ImageView photoTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);
        judulTv=findViewById(R.id.judultv);
        genreTv=findViewById(R.id.genretv);
        sinopsisTv=findViewById(R.id.sinopsistv);
        directorTv=findViewById(R.id.directortv);
        topTv=findViewById(R.id.toptv);
        rateTv=findViewById(R.id.ratetv);
        dateTv=findViewById(R.id.datetv);
        photoTv=findViewById(R.id.phototv);

        TvData tv = getIntent().getParcelableExtra(tvss);
        judulTv.setText(tv.getJudulTv());
        genreTv.setText(tv.getGenreTv());
        sinopsisTv.setText(tv.getSinopsisTv());
        directorTv.setText(tv.getDirectorTv());
        topTv.setText(tv.getTopTv());
        rateTv.setText(tv.getRateTv());
        dateTv.setText(tv.getDateTv());
        photoTv.setImageResource(tv.getPhotoTv());

    }
}
