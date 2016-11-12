package lly.ad.sqlitetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView listView = (ListView) findViewById(R.id.listview);
//        ArrayAdapter<String> objectArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
//            android.R.id.text1, new String[]{"aaa"});
//        objectArrayAdapter.add("666a");
//        objectArrayAdapter.add("666b");
//        objectArrayAdapter.add("666c");
//        objectArrayAdapter.add("666d");

        listView.setAdapter(new MAdapter());
    }

    class MAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return 10000;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) { // 0 - count-1

            ViewXX xx;
            if(convertView == null){
                xx = new ViewXX();
                convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, null);
                xx.tv = (TextView) convertView.findViewById(android.R.id.text1);
                convertView.setTag(xx); // viewholder
            }

//            View inflate = Main2Activity.this.getLayoutInflater().inflate(android.R.layout.simple_list_item_2, parent);

            xx = (ViewXX) convertView.getTag(); // viewholder
//            TextView viewById = (TextView) convertView.findViewById(android.R.id.text1);
            xx.tv.setText("pos " + position);
            return convertView;


            /**
             *  1. programlly create view
             *  2. 本方法
             *  3. 服用convertView
             *  4. VIewHolder
             *
             *
             *
             *
             *
             * */

            /*View view;
            if(convertView != null){

                view = convertView;
            }else {
                view = ..;
            }*/
        }

        class ViewXX{
            public TextView tv;
        }
    }


}
