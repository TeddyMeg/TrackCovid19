package tewodros.com.example.trackcovid19.ui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;

import java.util.ArrayList;

import tewodros.com.example.trackcovid19.R;

public class CallFragment extends Fragment {
    ListView lv;
    ArrayList<HotlineContact> list=new ArrayList<>();
    CallAdapter adapter;
    String phone;
    public static final int REQUEST_CALL = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_call,container,false);
        list.add(new HotlineContact("Algeria","3030"));
        list.add(new HotlineContact("Angola","111"));
        list.add(new HotlineContact("Republic of Benin","+22995361104"));
        list.add(new HotlineContact("Botswana","+2673632273"));
        list.add(new HotlineContact("Burkina Faso","+2261608989"));
        list.add(new HotlineContact("Cameroon","1510"));
        list.add(new HotlineContact("Cape Verde","+2388001112"));
        list.add(new HotlineContact("Central African Republic","1212"));
        list.add(new HotlineContact("Chad","1313"));
        list.add(new HotlineContact("Comoros","+2694693641"));
        list.add(new HotlineContact("Côte d’Ivoire","144"));
        list.add(new HotlineContact("Democratic Republic of Congo","+243841363267"));
        list.add(new HotlineContact("Djibouti","1517"));
        list.add(new HotlineContact("Egypt","105"));
        list.add(new HotlineContact("Equatorial Guinea","1111"));
        list.add(new HotlineContact("Eswatin","977"));
        list.add(new HotlineContact("Ethiopia","8335"));

        list.add(new HotlineContact("Gabon","1410"));
        list.add(new HotlineContact("Gambia","1025"));

        list.add(new HotlineContact("Ghana","+233509497700"));
        list.add(new HotlineContact("Guinea","+224629995656"));
        list.add(new HotlineContact("Guinea Bissau","1919"));
        list.add(new HotlineContact("Kenya","+254800721316"));
        list.add(new HotlineContact("Lesotho","+26658862893"));
        list.add(new HotlineContact("Liberia","4455"));
        list.add(new HotlineContact("Libya","191"));
        list.add(new HotlineContact("Madagascar","910"));
        list.add(new HotlineContact("Malawi","+265887371288"));
        list.add(new HotlineContact("Mali","36061"));
        list.add(new HotlineContact("Mauritania","1155"));
        list.add(new HotlineContact("Mauritius","8924"));
        list.add(new HotlineContact("Morocco","+2120801004747"));
        list.add(new HotlineContact("Mozambique","84146"));
        list.add(new HotlineContact("Namibia","0800100100"));
        list.add(new HotlineContact("Niger","15"));
        list.add(new HotlineContact("Nigeria","+23480097000010"));
        list.add(new HotlineContact("Republic of the Congo","3434"));
        list.add(new HotlineContact("Senegal","+221800005050"));
        list.add(new HotlineContact("Seychelles","141"));
        list.add(new HotlineContact("Sierra Leone","117"));
        list.add(new HotlineContact("Somalia","449"));
        list.add(new HotlineContact("South Africa","0800111131"));
        list.add(new HotlineContact("South Sudan","6666"));
        list.add(new HotlineContact("Sudan","9090"));
        list.add(new HotlineContact("Tanzania","+255800110124"));
        list.add(new HotlineContact("Togo","+22822222073"));
        list.add(new HotlineContact("Tunisia","+21680101919"));
        list.add(new HotlineContact("Uganda","+256800203033"));
        list.add(new HotlineContact("Zambia","909"));
        list.add(new HotlineContact("Zimbabwe","+263714734593"));


        lv=root.findViewById(R.id.listView);
        adapter = new CallAdapter(getContext(),list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HotlineContact hotlineContact = list.get(position);
                phone = hotlineContact.getPhone();
                makePhoneCall();
            }
        });

        return root;
    }

    private void makePhoneCall() {
            if(phone.trim().length()>0){
                if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
                }else{
                    String dial="tel:"+phone;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                }
            }else{
                Toast.makeText(getActivity(),"Invalid Phone",Toast.LENGTH_SHORT).show();
            }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makePhoneCall();
            }
            else{
                Toast.makeText(getActivity(),"Permission Denied",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
