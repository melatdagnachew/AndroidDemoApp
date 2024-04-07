package com.gebeya.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RouterAdapter extends RecyclerView.Adapter<RouterAdapter.myHolder> {

    List<Route> routers;
    private Context context;

    public RouterAdapter(List<Route> routers, Context context) {
        this.routers = routers;
        this.context = context;
    }



    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_layout_for_router,parent,false);
        myHolder myHolder = new myHolder(view);
        return myHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {

        Route route = routers.get(position);
        holder.routeNameTextView.setText(route.getRouteName());
        String deliveredStop = String.valueOf(route.totalStops);
        holder.numberOfStops.setText(deliveredStop);
        holder.time.setText(route.routeTime);
        //System.out.println("route" + route + routers.size() + route.deliveredStops);

        holder.menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(context, holder.menuIcon);
                popupMenu.inflate(R.menu.menu_main);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.action_create:
                                Toast.makeText(context, "Edit", Toast.LENGTH_SHORT).show();
//
                                break;
                            case R.id.action_rename:
                                Toast.makeText(context, "Edit", Toast.LENGTH_SHORT).show();
//
                                break;
                            case R.id.action_delete:
//                                routers.remove(position);
                                notifyDataSetChanged();
                                Toast.makeText(context, "delete", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }

                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return routers.size();
    }

    public class myHolder extends RecyclerView.ViewHolder {
        TextView time,numberOfStops,routeNameTextView;
        ImageView menuIcon;
        public myHolder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
            numberOfStops = itemView.findViewById(R.id.number_of_stops);
            menuIcon = itemView.findViewById(R.id.menu_icon);
            routeNameTextView =  itemView.findViewById(R.id.route_name_text_view);
        }

    }
}
