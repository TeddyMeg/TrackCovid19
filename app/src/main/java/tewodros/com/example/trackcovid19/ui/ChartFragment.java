package tewodros.com.example.trackcovid19.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import tewodros.com.example.trackcovid19.IMainPresenter;
import tewodros.com.example.trackcovid19.MainPresenterImpl;
import tewodros.com.example.trackcovid19.R;
import tewodros.com.example.trackcovid19.Status;

public class ChartFragment extends Fragment implements IMainPresenter.View {





    private TextView tvError;


    private BarChart barChart;

    private MainPresenterImpl mainPresenter;





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_chart,container,false);



        tvError = root.findViewById(R.id.tv_error_g);

        barChart =  root.findViewById(R.id.bar_chart_g);

        mainPresenter = new MainPresenterImpl(this);


        return root;

    }

    @Override
    public void onResume() {
        super.onResume();
        mainPresenter.downloadData();
    }
    @Override
    public void showError(String error) {

        tvError.setVisibility(View.VISIBLE);
        barChart.setVisibility(View.GONE);
        barChart.setBackgroundColor(Color.LTGRAY);
        barChart.setDrawGridBackground(false);



        tvError.setText(error);
    }

    @Override
    public void dataDownloadedSuccessfully(ArrayList<String> datesArrayList, ArrayList<Status> statusArrayList) {
        ArrayList<BarEntry> barEntryArrayList = new ArrayList<>();
        for (int i = 0; i < datesArrayList.size(); i++) {
            barEntryArrayList.add(new BarEntry(new float[]{statusArrayList.get(i).getDeaths(),statusArrayList.get(i).getRecovered(),statusArrayList.get(i).getConfirmed()},i));
        }

        BarDataSet barDataSet = new BarDataSet(barEntryArrayList, "");

        barDataSet.setStackLabels(new String[]{"Death","Recovered","Confirmed"});

        barDataSet.setValueTextSize(10f);
        barDataSet.setBarSpacePercent(20f);
        barDataSet.setValueTextColor(Color.WHITE);
        barDataSet.setDrawValues(true);

        barDataSet.setColors(new int[]{Color.RED,Color.GRAY,Color.GREEN});

        BarData barData = new BarData(datesArrayList,barDataSet);
        barChart.setData(barData);
        barChart.animateY(3000);

    }
}

