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

public class MovieFragment extends Fragment {
    private String[] judul, genre, sinopsis, director, top, rate, date;
    private TypedArray photo;
    private ArrayList<MovieData> movies;
    View view;
    private List<MovieData> list;
    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
        prepare();
        addItem();
        list=movies;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=  inflater.inflate(R.layout.fragment_movie, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv_category);
        MovieAdapter recycle= new MovieAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycle);
        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent i = new Intent(getActivity(),DetailMovieActivity.class);
                i.putExtra(DetailMovieActivity.moviess,movies.get(position));
                startActivity(i);
            }
        });
        return view;
    }

    private void prepare() {
        judul = getResources().getStringArray(R.array.Judul);
        genre = getResources().getStringArray(R.array.Genre);
        sinopsis = getResources().getStringArray(R.array.Sinopsis);
        director = getResources().getStringArray(R.array.director);
        top = getResources().getStringArray(R.array.Top);
        photo = getResources().obtainTypedArray(R.array.photo);
        rate = getResources().getStringArray(R.array.Rate);
        date = getResources().getStringArray(R.array.Date);
    }

    private void addItem(){
        movies=new ArrayList<>();
        for (int i =0; i<judul.length;i++){
            MovieData movie= new MovieData();
            movie.setJudul(judul[i]);
            movie.setDate(date[i]);
            movie.setSinopsis(sinopsis[i]);
            movie.setDirector(director[i]);
            movie.setTop(top[i]);
            movie.setPhoto(photo.getResourceId(i,-1));
            movie.setRate(rate[i]);
            movie.setGenre(genre[i]);
            movies.add(movie);
        }
    }

}
