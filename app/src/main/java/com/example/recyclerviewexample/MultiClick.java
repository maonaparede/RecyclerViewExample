package com.example.recyclerviewexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recyclerviewexample.R;
import com.example.recyclerviewexample.item.Item_click;
import com.xwray.groupie.GroupAdapter;
import com.xwray.groupie.Item;
import com.xwray.groupie.OnItemClickListener;

public class MultiClick extends AppCompatActivity {

    private RecyclerView recycler;
    private static GroupAdapter adapter;
    private static Context context;

    //TODO / ATENÇÃO - PRA MULTICLICK FUNCIONAR, NO LAYOUT CADA ITEM TEM Q TER UMA PROPRIEDADE "android:clickable="false"
    //TODO / VEJA O LAYOUT "Item_click" e as propriedades dentro dos itens

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_click);

        context = this;

        recycler = findViewById(R.id.recycler_click);
        adapter = new GroupAdapter();

        //Se quiser que o layout fique na horizontal é só mudar de "LinearLayoutManager.VERTICAL"
        //Para "LinearLayoutManager.HORIZONTAL"
        recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        recycler.setAdapter(adapter);

        addItemNaRecyclerView2();
    }

    //msm coisa do "Simples"
    private void addItemNaRecyclerView2(){

        //todo / Presta atenção no exemplo "Simples" é "Item_simples" , aqui é o "Item_click"
        adapter.add(new Item_click("Pedrinho 1" ,
                "https://penpas.files.wordpress.com/2016/12/final-fantasy-xv-logo-wallpaper.jpg?w=584&h=400"));

        adapter.add(new Item_click("Pedrinho 2" ,
                "https://cdna.artstation.com/p/assets/images/images/030/014/916/large/ekaterina-trofimova-vengeance.jpg?1599332024"));
    }


    // todo / RESPONSÁVEL POR TRATAR OS CLICKS DENTRO DOS ITENS /Veja a classe "Item_click"
    public static void multiClickDentroDoItem(Item item , Integer state , final Integer position){
        Item_click request = (Item_click) item;
        switch (state){
            case 0:
                Toast.makeText(context, "aceitar " + request.getName(), Toast.LENGTH_SHORT).show();
                break;

            case 1:
                Toast.makeText(context, "Rejeitar " + request.getName(), Toast.LENGTH_SHORT).show();
                adapter.removeGroup(position);
                adapter.notifyItemChanged(position);
                break;

            default:
                Toast.makeText(context, "DEFAULT " + request.getName(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}