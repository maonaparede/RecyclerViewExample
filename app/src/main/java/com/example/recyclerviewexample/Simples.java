package com.example.recyclerviewexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.recyclerviewexample.item.Item_simples;
import com.squareup.picasso.Picasso;
import com.xwray.groupie.GroupAdapter;
import com.xwray.groupie.Item;
import com.xwray.groupie.OnItemClickListener;

public class Simples extends AppCompatActivity {

    private RecyclerView recycler;
    private GroupAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simples);



        recycler = findViewById(R.id.simple_recyclerview);
        adapter = new GroupAdapter();
        recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        recycler.setAdapter(adapter);

        //Se clica em cima de um item esse método é chamado
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull Item item, @NonNull View view) {
                itemFoiCLicado(item);
            }
        });



        //Jeito fácil de entender
        addItemNaRecyclerView();

        //jeito que eu recomendo fazer
        addItemNaRecyclerView2();

    }




    private void addItemNaRecyclerView() {
        //dados
        String nome = "Joaozinho";
        String image = "https://penpas.files.wordpress.com/2016/12/final-fantasy-xv-logo-wallpaper.jpg?w=584&h=400";

        //Os dados que vão no item são instanciados - Ver Classe "item_simples" na pasta item
        Item_simples item = new Item_simples(nome, image);

        //O item é colocado na recyclerview
        adapter.add(item);
    }


    private void addItemNaRecyclerView2(){
        adapter.add(new Item_simples("Joaozinho 2" ,
                "https://cdna.artstation.com/p/assets/images/images/030/014/916/large/ekaterina-trofimova-vengeance.jpg?1599332024"));
    }

    



    private void itemFoiCLicado(Item item){
        Item_simples itemSimples = (Item_simples) item;

        //pega o nome
        String nome = itemSimples.getName();

        //mostra o nome num Toast
        Toast.makeText(this, nome, Toast.LENGTH_SHORT).show();

    }
}