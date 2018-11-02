package com.example.povtoryau;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Администратор on 02.11.2018.
 */

public class UserListAdapter extends ArrayAdapter<User> {

    Activity context;
    List<User> userList;

    public UserListAdapter(Activity context, List<User> userList) {
        super(context, R.layout.custom_user,userList);
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View UsersList = inflater.inflate(R.layout.custom_user,null,true);
        TextView nameText = UsersList.findViewById(R.id.nameId);
        TextView dateText = UsersList.findViewById(R.id.dateId);
        TextView phoneText = UsersList.findViewById(R.id.phoneId);
        TextView idText = UsersList.findViewById(R.id.Id);

        User user = userList.get(position);
        nameText.setText(user.getName());
        phoneText.setText(user.getPhone());
        dateText.setText(user.getDate());
        idText.setText(user.getId().toString());

        return UsersList;
    }
}
