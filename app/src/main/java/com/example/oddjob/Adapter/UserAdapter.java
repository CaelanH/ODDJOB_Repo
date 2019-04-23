package com.example.oddjob.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oddjob.MessageActivity;
import com.example.oddjob.Model.User;
import com.example.oddjob.R;

import java.util.List;

public class UserAdapter //extends RecyclerView.Adapter<UserAdapter.ViewHolder>
         {
   /* private Context mContext;
    private List<User> mUsers;
    public UserAdapter(Context mContext,List<User> mUsers){
        this.mUsers = mUsers;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(mContext).inflate(R.layout.user_item, parent, false);
        return new UserAdapter.ViewHolder(view);
    }
    @Override
    public void onBlindViewHolder(@NonNull ViewHolder holder, int position){
        User user = mUsers.get(position);
        holder.username.setText(user.getUsername());
        if(user.getImageURL().equals("defualt")){
            holder.profile_image.setImageResource(R.mipmap.io_launcher);
        }else{
            Glide.with(mContext).load(user.getImageURL()).into(holder.profile_image);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(mContext, MessageActivity.class);
                intent.putExtra("userid", user.getID());
                mContext.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount(){
        return mUsers.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView username;
        public ImageView profile_image;
        public ViewHolder(View itemView){
            super(itemView);
            username = itemView.findViewById(R.id.username);
            profile_image = itemView.findViewById(R.id.profile_image);
        }
    }*/
}
