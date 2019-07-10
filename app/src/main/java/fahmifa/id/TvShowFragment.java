package fahmifa.id;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TvShowFragment extends Fragment {
    private String[] judulTv, genreTv, sinopsis, director, top, rate, date;
    private TypedArray photo;
    private ArrayList<TvData> tvs;
    View view;
    private List<TvData> list;
    public TvShowFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
        prepare();
        addItem();
        list=tvs;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_tv_show, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv_category);
        TvShowAdaptor recycle= new TvShowAdaptor(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycle);
        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent i = new Intent(getActivity(), DetailMovieActivity.class);
                i.putExtra(DetailTvShowActivity.TV,tvs.get(position));
                startActivity(i);
            }
        });
        return view;
    }
    private void prepare(){
        judulTv=getResources().getStringArray(R.array.JudulTv);
        genreTv=getResources().getStringArray(R.array.GenreTv);
        sinopsis=getResources().getStringArray(R.array.sinopsisTv);
        director=getResources().getStringArray(R.array.directorTv);
        top=getResources().getStringArray(R.array.topTv);
        photo=getResources().obtainTypedArray(R.array.posterTvShow);
        rate=getResources().getStringArray(R.array.rateTv);
        date = getResources().getStringArray(R.array.dateTv);


    }
    private void addItem(){
        tvs=new ArrayList<>();
        for (int i =0; i<judulTv.length;i++){
            TvData tv= new TvData();
            tv.setJudulTv(judulTv[i]);
            tv.setDateTv(date[i]);
            tv.setSinopsisTv(sinopsis[i]);
            tv.setDirectorTv(director[i]);
            tv.setTopTv(top[i]);
            tv.setPhotoTv(photo.getResourceId(i,-1));
            tv.setRateTv(rate[i]);
            tv.setGenreTv(genreTv[i]);
            tvs.add(tv);
        }
    }
}