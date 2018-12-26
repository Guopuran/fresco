package guopuran.bwie.com.fanshe;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            Person person=new Person();
            Class cls=Class.forName(person.getClass().getCanonicalName());
            Method setName = cls.getDeclaredMethod("setName", String.class);
            setName.invoke(person,"其可缓缓未能预知");
            Method getName = cls.getDeclaredMethod("getName");
            Method[] declaredMethods = cls.getDeclaredMethods();
            Field[] declaredFields = cls.getDeclaredFields();
            System.out.print(getName.invoke(person,null));
            Log.i("TAG",getName.invoke(person,null)+"");
            Field data = cls.getDeclaredField("data");
            data.setAccessible(true);
            Object o = data.get(person);
//            String name = data.getName();
            Log.i("TAG",String.valueOf(o));
            data.set(person,"起来，不愿做奴隶的人们");
            Method getData = cls.getDeclaredMethod("getData");
            Log.i("TAG",getData.invoke(person,null)+"");
            for (int i=0;i<declaredFields.length;i++){
                Log.i("TAG",declaredFields[i]+"");
            }
            for (int i=0;i<declaredMethods.length;i++){
                Log.i("TAG",declaredMethods[i]+"");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
