package lly.ad.sqlitetest;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Main24Activity extends AppCompatActivity
            implements View.OnClickListener{

    private Button ok;
    private Button radio;
    private Button checkbox;
    private Button other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main24);

        initView();


    }

    private void initView() {
        ok = (Button) findViewById(R.id.ok);
        radio = (Button) findViewById(R.id.radio);
        checkbox = (Button) findViewById(R.id.checkbox);
        other = (Button) findViewById(R.id.other);
        ok.setOnClickListener(this);
        radio.setOnClickListener(this);
        checkbox.setOnClickListener(this);
        other.setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()){
            case R.id.ok:
                AlertDialog.Builder builder = new AlertDialog.Builder(this)
                        .setTitle("ok对话黄")
                        .setMessage("这是一个 对话框")
                        .setCancelable(false)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(), android.R.string.ok, Toast.LENGTH_SHORT).show();

                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(), android.R.string.cancel, Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.show();
                break;
            case R.id.radio:
                builder = new AlertDialog.Builder(this)
                        .setTitle("ok对话黄")
//                        .setMessage("这是一个 对话框")
                        .setCancelable(false)
                        .setSingleChoiceItems(R.array.arrays, 1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(), getString(android.R.string.ok) + which, Toast.LENGTH_SHORT).show();
                            }
                        })
//                        .setMessage("这是一个 对话框")

                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(), android.R.string.ok, Toast.LENGTH_SHORT).show();

                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(), android.R.string.cancel, Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.show();

                break;
            case R.id.checkbox:

                builder = new AlertDialog.Builder(this)
                        .setTitle("ok对话黄")
//                        .setMessage("这是一个 对话框")
                        .setCancelable(false)
//                        .setSingleChoiceItems(R.array.arrays, 1, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Toast.makeText(v.getContext(), getString(android.R.string.ok) + which, Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .setMessage("这是一个 对话框")
                        .setMultiChoiceItems(R.array.arrays, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(v.getContext(), getString(android.R.string.ok) + which, Toast.LENGTH_SHORT).show();
                            }
                        })
//                        .setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1), new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//
//                            }
//                        })

                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(), android.R.string.ok, Toast.LENGTH_SHORT).show();

                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(), android.R.string.cancel, Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.show();
                break;
            case R.id.other:
                builder = new AlertDialog.Builder(this)
                        .setTitle("ok对话黄")
//                        .setMessage("这是一个 对话框")
                        .setCancelable(false)
//                        .setSingleChoiceItems(R.array.arrays, 1, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Toast.makeText(v.getContext(), getString(android.R.string.ok) + which, Toast.LENGTH_SHORT).show();
//                            }
//                        })
////                        .setMessage("这是一个 对话框")
//                        .setMultiChoiceItems(R.array.arrays, null, new DialogInterface.OnMultiChoiceClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//                                Toast.makeText(v.getContext(), getString(android.R.string.ok) + which, Toast.LENGTH_SHORT).show();
//                            }
//                        })
                        .setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new String[]{
                                "aaa", "bb"
                        }), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })

                        .setIcon(R.mipmap.ic_launcher)

                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(), android.R.string.ok, Toast.LENGTH_SHORT).show();

                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(), android.R.string.cancel, Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.show();
                break;
            default:
                break;
        }
    }
}
