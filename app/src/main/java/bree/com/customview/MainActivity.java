package bree.com.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ( (TitleLayout) findViewById(R.id.title_layout)).setOnFunctionClickListener(new TitleLayout.OnFunctionClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(MainActivity.this,"真的v可以吗",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
