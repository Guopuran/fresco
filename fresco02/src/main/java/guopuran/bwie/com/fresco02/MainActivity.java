package guopuran.bwie.com.fresco02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        listView = findViewById(R.id.listview);
        List<Bean> list=new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add(new Bean("https://img02.sogoucdn.com/app/a/100520024/8e0ccfe848be0081f097681193912f64","如倒影水中的鲜花"+i));
        }
        listAdapter adapter=new listAdapter(this);
        listView.setAdapter(adapter);
        adapter.setList(list);
    }
}
