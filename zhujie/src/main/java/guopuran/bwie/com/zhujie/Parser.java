package guopuran.bwie.com.zhujie;

import android.app.Activity;
import android.nfc.Tag;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Parser {
    public static void setContent(Activity activity){
        setonclick(activity);
    }

    public static void bind(Activity activity){
        try{
            parse(activity);
            setonclick(activity);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void parse(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        View view=null;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field :fields){
            if (field.isAnnotationPresent(BindView.class)){
                BindView bindView=field.getAnnotation(BindView.class);
                int id = bindView.value();
                if (id<0){
                    throw new Exception("error");
                }else{
                    field.setAccessible(true);
                    if (object instanceof View){
                        view=((View)object).findViewById(id);
                    }else if (object instanceof Activity){
                        view=((Activity) object).findViewById(id);
                    }
                    field.set(object,view);
                }
            }

     }
    }
    public static void setonclick(final Activity activity) {
        Class clazz = activity.getClass();//第一种方式
        Class clazz2 = Activity.class;//第二种方式
        try {
            Class aClass = Class.forName("com.lixinyang.myreflect.MainActivity");//第三种方式
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //获取到里面的所有方法
        Method[] methods = clazz.getMethods();
        //foueach进行循环遍历
        for (final Method method : methods) {
            OnClick click = method.getAnnotation(OnClick.class);//通过反射api获取方法上面的注解
            if (click != null) {
                int[] value = click.value();
                for (int i : value) {
                    if (i == -1) {
                        return;
                    }
                    View view = activity.findViewById(i);//通过注解的值获取View控件
                    if (view == null){
                        return;
                    }
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                method.invoke(activity);//通过反射来调用被注解修饰的方法
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        }
    }
}
