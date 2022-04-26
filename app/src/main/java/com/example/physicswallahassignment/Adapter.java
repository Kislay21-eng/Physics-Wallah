package com.example.physicswallahassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater inflater;
    List<Faculty> faculties;

    public Adapter(Context ctx, List<Faculty> faculties){
        this.inflater = LayoutInflater.from(ctx);
        this.faculties = faculties;
    }

    @NonNull
   // @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_list_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(faculties.get(position).getName());
        holder.subject.setText(faculties.get(position).getSubject());
        holder.college.setText(faculties.get(position).getCollege());
        Picasso.get().load(faculties.get(position).getPersonURL()).into(holder.faculty_image);

    }

    @Override
    public int getItemCount() {
        return faculties.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,subject,college;
        ImageView faculty_image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tv_name);
            subject = itemView.findViewById(R.id.tv_subject);
            college = itemView.findViewById(R.id.tv_college);
            faculty_image = itemView.findViewById(R.id.iv_person);

        }
    }

}
