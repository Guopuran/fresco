package guopuran.bwie.com.fresco02;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class listAdapter extends BaseAdapter {
    private Context context;
    private List<Bean> list;

    public listAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    public void setList(List<Bean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Bean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView=View.inflate(context,R.layout.item,null);
            viewHolder=new ViewHolder(convertView);

        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.getdata(getItem(position));
        return convertView;
    }
    class ViewHolder{
        private SimpleDraweeView simpleDraweeView;
        private TextView textView;

        public ViewHolder(View convertView) {
            simpleDraweeView=convertView.findViewById(R.id.image);
            textView=convertView.findViewById(R.id.textview);
            convertView.setTag(this);
        }

        public void getdata(Bean item) {
           //设置图片
            simpleDraweeView.setImageURI( Uri.parse(item.getImage_url()));
            textView.setText(item.getTitle());
        }
    }
}
