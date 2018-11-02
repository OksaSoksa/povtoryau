package com.example.povtoryau;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    TextView nameT;
    TextView phoneT;
    TextView dateT;
    TextView idT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        nameT = findViewById(R.id.name);
        phoneT = findViewById(R.id.phone);
        dateT = findViewById(R.id.date);
        idT = findViewById(R.id.id);

        Intent getName = getIntent();
        String name = getName.getStringExtra("name");
        nameT.setText(name);

        Intent getPh = getIntent();
        String ph = getPh.getStringExtra("phone");
        phoneT.setText(ph);

        Intent getD = getIntent();
        String date = getD.getStringExtra("date");
        dateT.setText(date);

        Intent getIdT = getIntent();
        Integer id = getIdT.getIntExtra("id",0);
        idT.setText(id.toString());

    }
}
