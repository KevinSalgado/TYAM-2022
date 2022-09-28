package mx.uv.sbc.uifragmentsbased;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ReviewDAO {

    @Query ("SELECT * FROM Reviews")
    List<Reviews> getAll ();

    @Query ("SELECT * FROM Reviews WHERE article_id = :id")
    Reviews findReviewById (int id);

    @Insert
    void insertAll (Reviews...reviews);

}
