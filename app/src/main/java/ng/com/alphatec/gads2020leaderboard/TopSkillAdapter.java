package ng.com.alphatec.gads2020leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TopSkillAdapter extends RecyclerView.Adapter<TopSkillAdapter.ViewHolder> {
    LayoutInflater inflater;
    List<TopSkillHelperClass> posts;

    public TopSkillAdapter(Context context, List<TopSkillHelperClass> posts) {
        this.inflater = inflater.from(context);
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_centeral_recycle_row,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(posts.get(position).getName());
        holder.txtScore.setText(posts.get(position).getScore() +" skill IQ Score, "+posts.get(position).getCountry()+".");
        Picasso.get().load(posts.get(position).getBadgeUrl()).into(holder.postImage);
    }

    @Override
    public int getItemCount()  {
        return posts.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtScore, txtCountry;
        ImageView postImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtScore = itemView.findViewById(R.id.txtDuration);
            postImage = itemView.findViewById(R.id.postImage);
        }
    }
}
