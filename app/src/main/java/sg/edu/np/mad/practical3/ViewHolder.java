package sg.edu.np.mad.practical3;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder{
    TextView name;
    TextView description;
    ImageView userIcon;
    ImageView sevenImage;

    public ViewHolder(View itemView){
        super(itemView);
        name = itemView.findViewById(R.id.recyclerName);
        description = itemView.findViewById(R.id.recyclerDescription);
        userIcon = itemView.findViewById(R.id.recyclerUserIcon);
        sevenImage = itemView.findViewById(R.id.digitSeven);

    }
}
