package com.example.room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.room.model.PlayGame;

//Padrão singleton
//Essa classe ñ pode ser exposta
//Annotation para falar que é uma classe de database
@Database(entities = {PlayGame.class}, version = 1, exportSchema = false)
public abstract class DatabaseConnection extends RoomDatabase {

  private static DatabaseConnection instance;

   //Preciso pq ai n tenho que ficar instanciando objetos a rodo
   //olha no mainactivty como ta toppppp
   public abstract PlayGameDao playGameDao();

   //"Abrindo" a classe para acesso externo
   public static DatabaseConnection getInstance(Context context) {
      //Verifico se já existe uma instancia da classe, se não existir realizo todo o processo de instanciação
      //senão retorno o objeto
      if(instance == null) {
          instance = Room.databaseBuilder(context, DatabaseConnection.class, "playgames_database")
                         .allowMainThreadQueries()
                         .build();
      }

      return instance;
  }

}
