package lly.ad.sqlitetest;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main25Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main25);
        Button ok = (Button) findViewById(R.id.ok);
        Button radio = (Button) findViewById(R.id.radio);
        Button checkbox = (Button) findViewById(R.id.checkbox);
        Button other = (Button) findViewById(R.id.other);
        ok.setOnClickListener(this);
        radio.setOnClickListener(this);
        checkbox.setOnClickListener(this);
        other.setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()){
            case R.id.ok:
                AlertDialog.Builder builder = new AlertDialog.Builder(this).setTitle("ok")
                        .setMessage("this is a dialogue!").setCancelable(false)
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(),android.R.string.cancel,Toast.LENGTH_SHORT).show();
                            }
                        }).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(),android.R.string.ok,Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.show();
                break;
            case R.id.radio:
                builder = new AlertDialog.Builder(this).setTitle("ok")
//                        .setMessage("this is a dialogue!").setCancelable(false)
                        .setSingleChoiceItems(R.array.array2, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(), android.R.string.ok + which, Toast.LENGTH_SHORT).show();

                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(), android.R.string.cancel, Toast.LENGTH_SHORT).show();
                            }
                        }).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(), android.R.string.ok, Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.show();
                break;
            case R.id.checkbox:
                builder = new AlertDialog.Builder(this).setTitle("ok")
//                        .setMessage("this is a dialogue!").setCancelable(false)
                        .setMultiChoiceItems(R.array.arrays, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(v.getContext(), android.R.string.ok + which, Toast.LENGTH_SHORT).show();

                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(), android.R.string.cancel, Toast.LENGTH_SHORT).show();
                            }
                        }).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(), android.R.string.ok, Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.show();
                break;
            case R.id.other:
                builder = new AlertDialog.Builder(this).setTitle("ok")
                        .setMessage("this is a dialogue!").setCancelable(false)
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(), android.R.string.cancel, Toast.LENGTH_SHORT).show();
                            }
                        }).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(), android.R.string.ok, Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.show();
                break;

        }
    }
}
