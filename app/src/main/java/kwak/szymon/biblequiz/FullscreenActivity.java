package kwak.szymon.biblequiz;

import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;


public class FullscreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide(); //ukryj TitleBar
        setContentView(R.layout.activity_fullscreen);

        //Zmiana koloru navigationBar'a
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));
    }
}
