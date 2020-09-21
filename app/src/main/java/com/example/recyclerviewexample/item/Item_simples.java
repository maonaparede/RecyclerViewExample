package com.example.recyclerviewexample.item;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.recyclerviewexample.R;

import com.squareup.picasso.Picasso;
import com.xwray.groupie.Item;
import com.xwray.groupie.ViewHolder;


//todo / Prestar atenção - tem que exterder a Classe "Item<ViewHolder>", que pertence a api do Groupie
public class Item_simples extends Item<ViewHolder> {

   //dados
    private final String name;
    private final String image;

    //construtor recebe e seta os dados
    public Item_simples(String name, String image) {
        this.name = name;
        this.image = image;
    }


    //Aqui o layout é tratado, serve como um "onCreate" do item
    @Override
    public void bind(@NonNull ViewHolder viewHolder, int position) {

        //pega o id dos elementos do layout "item_simples"
        ImageView imageView = viewHolder.itemView.findViewById(R.id.imageView);
        TextView meetingName = viewHolder.itemView.findViewById(R.id.item_simple_text);

        //Glide.with(viewHolder.itemView).load("http://via.placeholder.com/300.png").into(imageView);

        //se a imagem não está vazia coloca ela na imagemView
        //todo / Atenção se a imagem não estiver mostranado, "check Internet permission in manifaest"
        Log.d("image" , image);
        if(!image.isEmpty()) {
            Picasso.get().load(image).into(imageView);
        }


        //Coloca o texto na TextView
        meetingName.setText(name);
    }


    @Override
    public int getLayout() {
        //todo / IMPORTANTE - Aqui é que se coloca qual layout vai aparecer quando add esse item
        return R.layout.item_simples;
    }


    public String getName() {
        return name;
    }
}
