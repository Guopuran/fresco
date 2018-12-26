package guopuran.bwie.com.zhujie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.button)
    Button mbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parser.bind(this);

    }
    @OnClick(R.id.button)
    public void aa(){
        Toast.makeText(this, "点击事件", Toast.LENGTH_SHORT).show();
    }
}
