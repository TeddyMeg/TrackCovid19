package tewodros.com.example.trackcovid19.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import tewodros.com.example.trackcovid19.R;

public class CallAdapter extends ArrayAdapter<HotlineContact> {
    private Context context;
    private ArrayList<HotlineContact> calls;

    public CallAdapter(@NonNull Context context, ArrayList<HotlineContact> list) {
        super(context, android.R.layout.simple_list_item_1,list);
        this.context=context;
        calls=list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View root;
        if(convertView!=null){
            root=convertView;
        }
        else{
            root= LayoutInflater.from(getContext()).inflate(R.layout.call_list_item, null, false);

        }

        HotlineContact call = calls.get(position);
        TextView tvName=root.findViewById(R.id.country);
        TextView tvPhone=root.findViewById(R.id.phone);
        tvName.setText(call.getCountryName());
        tvPhone.setText(call.getPhone());

        return root;
    }
}
