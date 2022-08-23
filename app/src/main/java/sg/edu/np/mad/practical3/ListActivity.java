package sg.edu.np.mad.practical3;

import static java.lang.Math.abs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    ArrayList<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        for (int i = 1; i <= 20; i++){
            User user = new User();
            user.name = "Name" + String.valueOf(new Random().nextInt());
            user.description = "Description " + String.valueOf(new Random().nextInt());
            user.id = i;
            user.followed = false;
            userList.add(user);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        adapter myAdapter = new adapter(userList);
        LinearLayoutManager myLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(myLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);
    }
}