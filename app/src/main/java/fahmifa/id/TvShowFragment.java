package fahmifa.id;


import android.content.Intent;
import android.content.res.TypedArray;
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
    private String[] judulTv, genreTv, sinopsisTv, directorTv, topTv, rateTv, dateTv;
    private TypedArray photoTv;
    private ArrayList<TvData> tvs;
    View view;
    private List<TvData>list;

    public TvShowFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list= new ArrayList<>();
        list=tvs;
        prepare();
        addItem();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tv_show, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv_tvshow);
        TvAdapter recycle = new TvAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycle);
        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener(){
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v){
                Intent i =new Intent(getActivity(),DetailTvShowActivity.class);
                i.putExtra(DetailTvShowActivity.tvs, tvs.get(position));
                startActivity(i);
            }
        });
        return view;
    }

    private void prepare(){
        judulTv=getResources().getStringArray(R.array.JudulTv);
        genreTv=getResources().getStringArray(R.array.GenreTv);
        sinopsisTv=getResources().getStringArray(R.array.sinopsisTv);
        directorTv=getResources().getStringArray(R.array.directorTv);
        topTv=getResources().getStringArray(R.array.topTv);
        rateTv=getResources().getStringArray(R.array.rateTv);
        dateTv=getResources().getStringArray(R.array.dateTv);
        photoTv=getResources().obtainTypedArray(R.array.posterTvShow);
    }
    private void addItem(){
        tvs=new ArrayList<>();
        for(int i=0; i<judulTv.length; i++){
            TvData tv = new TvData();
            tv.setJudulTv(judulTv[i]);
            tv.setGenreTv(genreTv[i]);
            tv.setSinopsisTv(sinopsisTv[i]);
            tv.setDirectorTv(directorTv[i]);
            tv.setTopTv(topTv[i]);
            tv.setRateTv(rateTv[i]);
            tv.setDateTv(dateTv[i]);
            tv.setPhotoTv(photoTv.getResourceId(i,-1));
            tvs.add(tv);
        }
    }



}
