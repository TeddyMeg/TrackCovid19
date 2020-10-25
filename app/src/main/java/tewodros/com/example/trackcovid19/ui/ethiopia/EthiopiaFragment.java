package tewodros.com.example.trackcovid19.ui.ethiopia;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import tewodros.com.example.trackcovid19.R;
import tewodros.com.example.trackcovid19.ui.country.CovidCountry;

public class EthiopiaFragment extends Fragment {

    private TextView tvTotalConfirmed,tvTotalDeaths,tvTotalRecovered;
    private ProgressBar progressBar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_ethiopia, container, false);

        tvTotalConfirmed = root.findViewById(R.id.tvTotalConfirmed);
        tvTotalDeaths = root.findViewById(R.id.tvTotalDeaths);
        tvTotalRecovered = root.findViewById(R.id.tvTotalRecovered);


        progressBar = root.findViewById(R.id.progress_circular_home);

        getData();
        return root;
    }

    private void getData() {
        RequestQueue queue = Volley.newRequestQueue(getActivity());

        String url = "https://corona.lmao.ninja/v2/countries";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);

                try {


                    JSONArray jsonArray = new JSONArray(response.toString());
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject data = jsonArray.getJSONObject(i);
                        if(data.getString("country").equals("Ethiopia")){
                            tvTotalConfirmed.setText(data.getString("cases"));
                            tvTotalDeaths.setText(data.getString("deaths"));
                            tvTotalRecovered.setText(data.getString("recovered"));

                        }

                    }

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
