package sg.edu.np.mad.practical3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<ViewHolder> {
    ArrayList<User> userList;
    public adapter (ArrayList<User> uList) {
        userList = uList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler, parent, false);
        return new ViewHolder(item);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = userList.get(position);
        String Name = user.name;
        String Description = user.description;
        if (!Name.endsWith("7")) {
            holder.sevenImage.setVisibility(View.GONE);
        }
        else {
            holder.sevenImage.setVisibility(View.VISIBLE);
        }

        holder.name.setText(Name);
        holder.description.setText(Description);
        holder.userIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Profile");
                builder.setMessage(Name);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent profile = new Intent(view.getContext(), MainActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("name", Name);
                        bundle.putString("description", Description);
                        bundle.putInt("id", user.id);
                        bundle.putBoolean("followed", user.followed);
                        profile.putExtras(bundle);
                        view.getContext().startActivity(profile);
                    }
                });
                builder.setNegativeButton("Close", null);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    public int getItemCount() { return userList.size(); }
}