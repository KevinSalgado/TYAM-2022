package mx.uv.sbc.uifragmentsbased;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database (entities = {Reviews.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ReviewDAO reviewDAO ();
}
