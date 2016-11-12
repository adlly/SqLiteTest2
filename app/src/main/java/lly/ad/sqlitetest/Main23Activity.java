package lly.ad.sqlitetest;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

public class Main23Activity extends AppCompatActivity {

    private static final String DB_NAME = "second.db";
    private static final String TABLE = "second";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main23);

        SqLiteTest sqLiteTest = new SqLiteTest(this, DB_NAME, null, 2);
        SQLiteDatabase writableDatabase = sqLiteTest.getWritableDatabase();
        Cursor cursor = writableDatabase.query(TABLE, null, null, null, null, null, null);
        List<Map<String,String>> lists = new ArrayList<>();
        while(cursor.moveToNext()){

            int columnCount = cursor.getColumnCount();
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < columnCount; i++) {
                map.put(cursor.getColumnName(i),cursor.getString(i));
            }
            lists.add(map);

        }

        ListView ll =  (ListView) findViewById(R.id.listview2);
//        ll.setAdapter(new MyAdapter(lists));

//        ll.setAdapter(new ArrayAdapter<>(this, R.layout.yy, R.id.name, lists.toArray()));

//        ll.setAdapter(new SimpleAdapter(this, lists, R.layout.yy, new String[]{
//                "name", "salary", "phone"
//        }, new int[]{
//                R.id.name, R.id.salary, R.id.phone
//        }));
        ll.setAdapter(new SimpleCursorAdapter(this, R.layout.yy,
                cursor, new String[]{
                "_id", "name", "salary", "phone"
        }, new int[]{
                R.id.id, R.id.name, R.id.salary, R.id.phone
        }, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER));
//        Arrays.asList()
    }

    private class MyAdapter extends BaseAdapter {
        List<Map<String, String>> lists;


        public MyAdapter(List<Map<String, String>> lists) {
            this.lists = lists;
        }

        @Override
        public int getCount() {
            return lists.size();
        }

        @Override
        public Object getItem(int position) {
            return lists.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null){
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.yy,null);
                holder = new ViewHolder();
                holder.name = (TextView) convertView.findViewById(R.id.name);
                holder.salary = (TextView) convertView.findViewById(R.id.salary);
                holder.phone = (TextView) convertView.findViewById(R.id.phone);
                convertView.setTag(holder);

            }else{
                holder = (ViewHolder) convertView.getTag();
            }
            holder.name.setText(lists.get(position).get("name"));
            holder.salary.setText(lists.get(position).get("salary"));
            holder.phone.setText(lists.get(position).get("phone"));


            return convertView;
        }

        public class ViewHolder{
            TextView name;
            TextView salary;
            TextView phone;

        }
    }
}

