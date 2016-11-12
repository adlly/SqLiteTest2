package lly.ad.sqlitetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String DB_NAME = "second.db";
    private static final String TABLE_NAME = "second";

    SQLiteDatabase writableDatabase;

    private LinearLayout ll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SqLiteTest sqLiteTest = new SqLiteTest(MainActivity.this,"second.db",null,2);
         writableDatabase = sqLiteTest.getWritableDatabase();
        insert();
        select();
        transaction();


        initView();
//        writableDatabase.execSQL("");
    }

    private void initView() {
        ll = (LinearLayout) findViewById(R.id.ll);

        SqLiteTest sqLiteTest = new SqLiteTest(this, DB_NAME, null, 2);
        SQLiteDatabase db = sqLiteTest.getWritableDatabase();

        Cursor query = db.query(false, TABLE_NAME, null, null, null, null, null, null, null);

        while(query.moveToNext()){
            int columnCount = query.getColumnCount();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < columnCount; i++) {
                String columnName = query.getString(i);
                sb.append(columnName + "\t");
            }

            TextView tv = new TextView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            );
            tv.setLayoutParams(layoutParams);

            tv.setText(sb);
            ll.addView(tv);
        }

        db.close();
    }

    protected  void insert(){
        writableDatabase.execSQL("insert into second (name,salary,phone) values (?,?,?)",new Object[]{"ll",123,124578});
        writableDatabase.execSQL("insert into second (name,salary,phone) values (?,?,?)",new Object[]{"22",123,124578});
        writableDatabase.execSQL("insert into second (name,salary,phone) values (?,?,?)",new Object[]{"33",123,124578});

        writableDatabase.execSQL("insert into second (name,salary,phone) values (?,?,?)",new Object[]{"44",123,124578});

        ContentValues contentValues = new ContentValues();
        contentValues.put("name","333");
        contentValues.put("salary","444");
        contentValues.put("phone","1234556");

        writableDatabase.insert("person",null,contentValues);

    }
    protected  void select(){
//        Cursor cursor = writableDatabase.rawQuery("select * from second",null);
        Cursor cursor = writableDatabase.query("second",null,null,null,null,null,null);
        while(cursor.moveToNext()){
            String name = cursor.getString(0);
            String salary = cursor.getString(1);
            String phone = cursor.getString(2);
            System.out.println(name+";"+salary+";"+phone);
        }
    }
    protected  void transaction(){
        writableDatabase.beginTransaction();

        ContentValues values = new ContentValues();
        values.put("name", "abc");
        values.put("salary", "123");
//        values.put("phone", "zxc");

        writableDatabase.insert("second", null, values);

        writableDatabase.setTransactionSuccessful();
        writableDatabase.endTransaction();
    }


}
