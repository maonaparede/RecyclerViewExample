package com.example.recyclerviewexample.item;


import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;


import com.example.recyclerviewexample.MultiClick;
import com.example.recyclerviewexample.R;
import com.squareup.picasso.Picasso;
import com.xwray.groupie.Item;
import com.xwray.groupie.ViewHolder;

//todo / Implementa onClickListener para cuidar do clique dentro do item
public class Item_click extends Item<ViewHolder> implements View.OnClickListener {

    public final String name;
    public final String image;
    private Integer positionRequest;
    private Item item;

    public Item_click(String name, String image) {
        this.name = name;
        this.image = image;
    }

    @Override
    public void bind(@NonNull ViewHolder viewHolder, int position) {

        TextView textView = viewHolder.itemView.findViewById(R.id.item_click_textview);
        textView.setText(name);

        ImageView imageView = viewHolder.itemView.findViewById(R.id.item_click_imageview);
        Picasso.get().load(image).into(imageView);

        positionRequest = position;
        item = viewHolder.getItem();

        //todo / Seta o onclickListener a cada elemento do layout
        viewHolder.itemView.findViewById(R.id.item_click_button_connect).setOnClickListener(this);
        viewHolder.itemView.findViewById(R.id.item_click_button_reject).setOnClickListener(this);
        viewHolder.itemView.findViewById(R.id.item_click_textview).setOnClickListener(this);
        viewHolder.itemView.findViewById(R.id.item_click_imageview).setOnClickListener(this);
        textView.setOnClickListener(this);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.item_click_button_connect:
                MultiClick.multiClickDentroDoItem(item, 0 , positionRequest);
                Log.d("Request" , "ACEITAR");
                break;

            case R.id.item_click_button_reject:
                MultiClick.multiClickDentroDoItem(item, 1, positionRequest);
                Log.d("Request" , "Rejeitar");
                break;

            default:
                MultiClick.multiClickDentroDoItem(item, 2, positionRequest);
                Log.d("Request" , "Default");
                break;
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public int getLayout() {
        return R.layout.item_click;
    }


}
