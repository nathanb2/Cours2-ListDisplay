package com.example.cours2_listdisplay;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<User> users = initUserList();
        RecyclerView recyclerView = initRecyclerView();
        UserAdapter userAdapter = new UserAdapter(users);
        recyclerView.setAdapter(userAdapter);

        initListener(userAdapter, users);
    }

    private void initListener(UserAdapter adapter, ArrayList<User> users) {
        findViewById(R.id.AM_add_btn).setOnClickListener(view -> {
         users.addAll(users);
         adapter.notifyDataSetChanged();
        });
    }

    private ArrayList<User> initUserList() {
        ArrayList<User> users = new ArrayList<>();
        User user1 = new User(20, "patrick");
        User user2 = new User(21, "jean");
        User user3 = new User(22, "marie");
        User user4 = new User(23, "michel");
        User user5 = new User(24, "benoit");
        User user6 = new User(25, "jhon");
        User user7 = new User(26, "jack");
        User user8 = new User(27, "clementine");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);

        return users;
    }

    private RecyclerView initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.AM_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        return recyclerView;
    }
}