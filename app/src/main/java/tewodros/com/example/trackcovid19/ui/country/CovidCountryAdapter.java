package tewodros.com.example.trackcovid19.ui.country;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import tewodros.com.example.trackcovid19.R;

public class CovidCountryAdapter extends RecyclerView.Adapter<CovidCountryAdapter.ViewHolder> {

    ArrayList<CovidCountry> covidCountries;
    private Context context;

    public CovidCountryAdapter(ArrayList<CovidCountry> covidCountries,Context context){
        this.covidCountries = covidCountries;
        this.context = context;
    }
    @NonNull
    @Override
    public CovidCountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_covid_country,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CovidCountryAdapter.ViewHolder holder, int position) {
        CovidCountry covidCountry = covidCountries.get(position);
        holder.tvTotalCases.setText(covidCountry.getmCases());
        holder.tvCountryName.setText(covidCountry.getmCovidCountry());

        Glide.with(context)
                .load(covidCountry.getmFlag())
                .apply(new RequestOptions().override(240,160))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return covidCountries.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTotalCases,tvCountryName;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTotalCases=itemView.findViewById(R.id.tvTotalCases);
            tvCountryName=itemView.findViewById(R.id.tvCountryName);
            imageView = itemView.findViewById(R.id.imgCountryFlag);
        }
    }
}
