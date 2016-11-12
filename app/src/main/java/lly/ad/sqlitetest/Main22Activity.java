package lly.ad.sqlitetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main22Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);

        ListView listView = (ListView) findViewById(R.id.listview);

        listView.setAdapter(new MyAdapter());

    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        //getView 为listview增添条目
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //判断缓冲池中是否有view

            ViewHolder viewHolder;
            if(convertView == null){
                //创建新的view
                //生成view对象的方法
                //1、xml生成布局
                //2、通过Activity创建
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ll, null);
                viewHolder = new ViewHolder();
                viewHolder.textview =(TextView)convertView.findViewById(R.id.textView);
                convertView.setTag(viewHolder);
            }
            else{

                viewHolder = (ViewHolder)convertView.getTag();

            }
            //使用viewholder，添加条目布局组件

            viewHolder.textview.setText("abcd" + position);



            return convertView;
        }

        public class ViewHolder{
            TextView textview;
        }
    }
}
