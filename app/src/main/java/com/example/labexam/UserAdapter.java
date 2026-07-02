package com.example.labexam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.tvId.setText("ID: " + user.getId());
        holder.tvName.setText("Name: " + user.getName());
        holder.tvGender.setText("Gender: " + user.getGender());
        holder.tvLocation.setText("Location: " + user.getLocation());
        holder.tvPassword.setText("Password: " + user.getPassword());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvName, tvGender, tvLocation, tvPassword;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvName = itemView.findViewById(R.id.tvName);
            tvGender = itemView.findViewById(R.id.tvGender);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvPassword = itemView.findViewById(R.id.tvPassword);
        }
    }
}