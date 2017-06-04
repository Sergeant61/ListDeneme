package com.example.vektorel.listdeneme;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final List<Kisi> kisiler = new ArrayList<Kisi>();
    ListView listemiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listemiz = (ListView) findViewById(R.id.liste);


        kisiler.add(new Kisi("Ahmet Yılmaz", false));
        kisiler.add(new Kisi("Ayşe Küçük", true));
        kisiler.add(new Kisi("Fatma Bulgurcu", true));
        kisiler.add(new Kisi("İzzet Altınmeşe", false));
        kisiler.add(new Kisi("Melek Subaşı", true));
        kisiler.add(new Kisi("Selim Serdilli", false));
        kisiler.add(new Kisi("Halil İbrahim", false));

        OzelAdapter ozelAdapter = new OzelAdapter(this, kisiler);
        listemiz.setAdapter(ozelAdapter);

        listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this, kisiler.get(i).getIsim().toString(), Toast.LENGTH_SHORT).show();

                AlertDialog.Builder diyalogOlusturucu =
                        new AlertDialog.Builder(MainActivity.this);

                diyalogOlusturucu.setMessage(kisiler.get(i).getIsim().toString())
                        .setCancelable(false)
                        .setIcon(R.drawable.erkek)
                        .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                diyalogOlusturucu.create().show();


            }
        });
    }
}
