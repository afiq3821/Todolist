package com.mochamadahya.mytodolist.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mochamadahya.mytodolist.R;

public class MyMenuViewHolder extends RecyclerView.ViewHolder{
    TextView txtmenuitem;
    ImageView imgmenuitem;

    public MyMenuViewHolder(View itemView) {
        super(itemView);
        txtmenuitem = (TextView) itemView.findViewById(R.id.txtmenuitem);
        imgmenuitem = (ImageView) itemView.findViewById(R.id.imgmenuitem);
    }
}
