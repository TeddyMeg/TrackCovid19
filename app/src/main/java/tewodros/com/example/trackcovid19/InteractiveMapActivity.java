package tewodros.com.example.trackcovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class InteractiveMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interactive_map);
        WebView wv = findViewById(R.id.root_web_view);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("file:///android_asset/index2.html");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
