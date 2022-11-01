package mvvmApp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mvvmApp.models.Article

@Dao
interface articleDao
{
    //Each parameter for an @Insert method must be either an instance of a Room data entity class
    // annotated with @Entity or a collection of data entity class instances.
    // When an @Insert method is called,
    // Room inserts each passed entity instance into the corresponding database table.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(article: Article):Long
    @Query("SELECT * FROM newsTable")
    suspend fun getAllArticles():LiveData<List<Article>>
    @Delete
    suspend fun  deletearticle(article: Article)



}