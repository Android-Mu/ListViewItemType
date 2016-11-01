package myapp.com.mjj.listviewitemtype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lv_main_activity);

        List<String> contents = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            contents.add("第 " + i + " 位工程师");
        }

        ListAdapter adapter = new ListAdapter(contents, this);
        listView.setAdapter(adapter);
    }
}
