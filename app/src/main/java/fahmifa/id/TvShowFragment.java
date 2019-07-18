package fahmifa.id;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TvShowFragment extends Fragment {
    private String[] judul, genre, sinopsis, director, top, rate, date;
    private TypedArray photo;
    private ArrayList<TvData> tv;
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
        list=tv;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=  inflater.inflate(R.layout.fragment_tv_show, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv_tvshow);
        TvAdapter recycle= new TvAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycle);
        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent i = new Intent(getActivity(),DetailTvShowActivity.class);
                i.putExtra(DetailTvShowActivity.tvss,tv.get(position));
                startActivity(i);
            }
        });
        return view;
    }

    private void prepare() {
        judul = getResources().getStringArray(R.array.JudulTv);
        genre = getResources().getStringArray(R.array.GenreTv);
        sinopsis = getResources().getStringArray(R.array.sinopsisTv);
        director = getResources().getStringArray(R.array.directorTv);
        top = getResources().getStringArray(R.array.topTv);
        photo = getResources().obtainTypedArray(R.array.posterTvShow);
        rate = getResources().getStringArray(R.array.rateTv);
        date = getResources().getStringArray(R.array.dateTv);
    }

    private void addItem(){
        tv=new ArrayList<>();
        for (int i =0; i<judul.length;i++){
            TvData tvs= new TvData();
            tvs.setJudulTv(judul[i]);
            tvs.setDateTv(date[i]);
            tvs.setSinopsisTv(sinopsis[i]);
            tvs.setDirectorTv(director[i]);
            tvs.setTopTv(top[i]);
            tvs.setPhotoTv(photo.getResourceId(i,-1));
            tvs.setRateTv(rate[i]);
            tvs.setGenreTv(genre[i]);
            tv.add(tvs);
        }
    }

}
