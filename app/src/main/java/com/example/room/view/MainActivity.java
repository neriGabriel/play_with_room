package com.example.room.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.room.R;
import com.example.room.adapters.PlayGamesAdapter;
import com.example.room.database.DatabaseConnection;
import com.example.room.model.PlayGame;

import java.util.ArrayList;
import java.util.List;

/*
* Utilizando o room
* primeiro temos que fazer os imports dentro do build.gradle
 def room_version = "2.2.5"
 implementation "androidx.room:room-runtime:$room_version"
 annotationProcessor "androidx.room:room-compiler:$room_version"
*  depois criamos uma model, com todos os annotations referentes a biblioteca room
*  depois criamos uma interface, que terá como objetivo executar os métodos de banco
*  e depois criamos uma classe de conexao (padrão singleton), que iniciara o banco seguindo restrições e conterá uma referencia da interface (uma para cada entidade do banco)
*  depois instanciamos seguindo o padrão singleton na main, e referenciamos a referencia de cada entidade realizando as funções
* */
public class MainActivity extends AppCompatActivity {

    Button btnInsert;
    Button btnGetAll;
    RecyclerView recyclerView;
    PlayGamesAdapter playGamesAdapter;

    List<PlayGame> playGameList = new ArrayList<>();

    DatabaseConnection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnInsert = findViewById(R.id.buttonInsert);
        this.btnGetAll = findViewById(R.id.btnGetAll);
        this.recyclerView = findViewById(R.id.recyclerView);

        this.connection = DatabaseConnection.getInstance(this);


        this.playGamesAdapter = new PlayGamesAdapter(this.playGameList);

        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setAdapter(this.playGamesAdapter);

        this.btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayGame playGame = new PlayGame("Wings of Misadventures", 500, "Its a game");
                connection.playGameDao().insert(playGame);
            }
        });

        this.btnGetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playGameList.clear();
                playGameList.addAll(connection.playGameDao().getAllGames());
                playGamesAdapter.notifyDataSetChanged();
            }
        });
        /*
        * O delete vai ser igual o insert,
        * chama o método da connection playGameDao.delete, passando o playGame
        * ai vai deletar do banco
        * tira da lista (pode tirar da lista primeiro e depois deletar do banco)
        * atualiza o dataset
        * */
    }
}
