package com.example.povtoryau;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MainActivity extends AppCompatActivity {
        List<User> userList = new ArrayList<>();
        ListView usersListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usersListView = findViewById(R.id.listId);

        DataSource dataSource = new DataSource();
        dataSource.execute();

        try {
            dataSource.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        setUserList(dataSource.resultJson);
        usersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String name;
                String date;
                String phone;
                Integer id;
                Intent putExtra = new Intent(MainActivity.this,Profile.class);
                name = userList.get(position).getName();
                phone = userList.get(position).getPhone();
                date = userList.get(position).getDate();
                id = userList.get(position).getId();
                putExtra.putExtra("name",name);
                putExtra.putExtra("phone",phone);
                putExtra.putExtra("date",date);
                putExtra.putExtra("id",id);
                startActivity(putExtra);


            }
        });
    }
    public void setUserList(String json){
        String name;
        String date;
        String phone;
        Integer id;

        try {
            JSONArray people = new JSONArray(json);

            for (int i=0; i<people.length();i++){
                JSONObject sad = people.getJSONObject(i);

                name = sad.getString("name");
                date = sad.getString("date");
                phone = sad.getString("phone");
                id = sad.getInt("id");

                userList.add(new User(name,phone,date,id));
            }
            ArrayAdapter adapter = new UserListAdapter(MainActivity.this,userList);
            usersListView.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
