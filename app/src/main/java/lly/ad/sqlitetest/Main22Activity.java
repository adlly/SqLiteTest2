package lly.ad.sqlitetest;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main22Activity extends AppCompatActivity {


    private static final String DB_NAME = "second.db";
    private static final String TABLE_NAME = "second";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);

        ListView listView = (ListView) findViewById(R.id.listview);


        //1、获取数据列表
        //2、将数据列表中得元素插入listview中
        List<Map<String, String>> lists = new ArrayList<>();

        SqLiteTest sqLiteTest = new SqLiteTest(this, DB_NAME, null, 2);
        SQLiteDatabase writableDatabase = sqLiteTest.getWritableDatabase();
        Cursor cursor = writableDatabase.query(TABLE_NAME, null, null, null, null, null, null);

        while(cursor.moveToNext()){

            int columnCount = cursor.getColumnCount();

//            Second second = new Second();

            Map<String, String> map = new HashMap<>();

            for (int i = 0; i < columnCount; i++) {
                String string = cursor.getString(i);
                /**
                 * name
                 * xx
                 * phone
                 * */

            map.put(cursor.getColumnName(i), cursor.getString(i));

//
//                Map map = new HashMap();
//                map.put("s" + i, string);
//                Object[] o = new Object[columnCount];
//                o[i] = string;

            }

            lists.add(map);

//            Log.e("XXX", map.toString());


        }

//        Log.e("YY", lists.toString());


        listView.setAdapter(new MyAdapter(lists));


    }

    private class MyAdapter extends BaseAdapter {

        private List<Map<String, String>> lists;

        public MyAdapter(List<Map<String, String>> lists) {
            this.lists = lists;
        }

        @Override
        public int getCount() {
            return lists.size();
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
            View view;

            ViewHolder viewHolder;
            if(convertView == null){
                //创建新的view
                //生成view对象的方法
                //1、xml生成布局
                //2、通过Activity创建
//                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ll, null);
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ll, null);

                viewHolder = new ViewHolder();
//                viewHolder.tv_name =(TextView)convertView.findViewById(R.id.tv_name);
//                viewHolder.tv_salary =(TextView)convertView.findViewById(R.id.tv_salary);
//                viewHolder.tv_phone =(TextView)convertView.findViewById(R.id.tv_phone);
                viewHolder.tv_name =(TextView)view.findViewById(R.id.tv_name);
                viewHolder.tv_salary =(TextView)view.findViewById(R.id.tv_salary);
                viewHolder.tv_phone =(TextView)view.findViewById(R.id.tv_phone);

                convertView.setTag(viewHolder);
            }
            else{
                view = convertView;

                viewHolder = (ViewHolder)convertView.getTag();

            }
            //使用viewholder，添加条目布局组件

            Map<String, String> stringStringMap = lists.get(position);
            String name = stringStringMap.get("name");
            String salary = stringStringMap.get("salary");
            String phone = stringStringMap.get("phone");

            viewHolder.tv_name.setText(name);
            viewHolder.tv_salary.setText(salary);
            viewHolder.tv_phone.setText(phone);




            return convertView;
        }

        public class ViewHolder{
            TextView tv_name;
            TextView tv_salary;
            TextView tv_phone;
        }
    }
}
