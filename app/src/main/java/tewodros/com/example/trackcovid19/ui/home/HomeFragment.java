package tewodros.com.example.trackcovid19.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import tewodros.com.example.trackcovid19.R;
import tewodros.com.example.trackcovid19.ui.ChartFragment;
import tewodros.com.example.trackcovid19.ui.GlobalCases;

public class HomeFragment extends Fragment {

    private TextView tvTotalConfirmed,tvTotalDeaths,tvTotalRecovered,tvLastUpdated;
    private ProgressBar progressBar;
    private ChartFragment chartFragment;
    float cases,deaths,recovered;
    public static GlobalCases globalCases;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        tvTotalConfirmed = root.findViewById(R.id.tvTotalConfirmed);
        tvTotalDeaths = root.findViewById(R.id.tvTotalDeaths);
        tvTotalRecovered = root.findViewById(R.id.tvTotalRecovered);
        tvLastUpdated = root.findViewById(R.id.tvLastUpdated);
        progressBar = root.findViewById(R.id.progress_circular_home);

        getData();
        return root;
    }
    private String getDate(long milliseconds){
        SimpleDateFormat format=new SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss aaa");
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(milliseconds);

        return format.format(calendar.getTime());
    }
    private void getData() {
        RequestQueue queue = Volley.newRequestQueue(getActivity());

        String url = "https://corona.lmao.ninja/v2/all";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);

                try {
                    JSONObject jsonObject = new JSONObject(response.toString());

                    tvTotalConfirmed.setText(jsonObject.getString("cases"));
                    tvTotalDeaths.setText(jsonObject.getString("deaths"));
                    tvTotalRecovered.setText(jsonObject.getString("recovered"));
                    tvLastUpdated.setText("Last updated"+"\n"+getDate(jsonObject.getLong("updated")));

                    cases = Float.parseFloat(jsonObject.getString("cases"));
                    deaths = Float.parseFloat(jsonObject.getString("deaths"));
                    recovered = Float.parseFloat(jsonObject.getString("recovered"));

                    globalCases=new GlobalCases(cases,deaths,recovered);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Log.d("Error Response",error.toString());
            }
        });

        queue.add(stringRequest);
    }

}
