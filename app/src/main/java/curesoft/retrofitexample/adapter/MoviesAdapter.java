package curesoft.retrofitexample.adapter;

import android.content.Context;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import curesoft.retrofitexample.R;
import curesoft.retrofitexample.model.Result;

import static android.media.CamcorderProfile.get;

/**
 * Created by Prabin kumar mallick on 12-09-2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieHolder>
{
    List<Result> movie;
    Context context;



    public MoviesAdapter(Context context,List<Result> movie) {
        this.movie = movie;
        this.context = context;

    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,null,false);
        return new MovieHolder(view);

    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
     Result movies=movie.get(position);
        holder.tt.setText(movies.getOriginalTitle());
        holder.td.setText(movies.getOriginalLanguage());
        holder.tdes.setText(movies.getOverview());

    }

    @Override
    public int getItemCount() {
        return movie.size();
    }
    class MovieHolder extends RecyclerView.ViewHolder {
        TextView tt;
        TextView td;
        TextView tdes;
        public MovieHolder(View itemView) {
            super(itemView);
           tt= (TextView) itemView.findViewById(R.id.texttitle);
            td= (TextView) itemView.findViewById(R.id.date);
            tdes= (TextView) itemView.findViewById(R.id.description);

        }
    }
}
