package com.example.cours2_listdisplay;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<User> users = initUserList(); //creation d'une liste d'objet
        RecyclerView recyclerView = initRecyclerView();// recuperation de la recyclerview configure
        UserAdapter userAdapter = new UserAdapter(users);//creation de l'adapter avec la liste d'objets en parametre
        recyclerView.setAdapter(userAdapter);//association de l'adapter a la recyclerView

        initListener(userAdapter, users);
    }

    private void initListener(UserAdapter adapter, ArrayList<User> users) {
        findViewById(R.id.AM_add_btn).setOnClickListener(view -> {
         users.addAll(users);
         adapter.notifyDataSetChanged();//informe l'adapter que la liste d'objet qu'il traite a ete modifie
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
        RecyclerView recyclerView = findViewById(R.id.AM_rv);//la recyclerView est la vue contener qui permet d'acceuillir l'affichage d'items (qui seront crees dans l'adapter)
        //Je set un linearlayoutManager a la recyclerView afin de lui indiquer comment organiser les vues qu'elle va acceuillire, soit afficher les items les un a cotes des autres ou les un sous les autres comme ici avec VERTICAL
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        return recyclerView;
    }
}