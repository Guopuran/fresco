package guopuran.bwie.com.fresco;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SimpleDraweeView simpleDraweeView=findViewById(R.id.simple);
        Uri parse = Uri.parse("https://img02.sogoucdn.com/app/a/100520024/ad4741145c4dfd2c0f7c8afed8b1e029");
        simpleDraweeView.setImageURI(parse);
    }
}
