package mvvmApp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import mvvmApp.models.Article
@Database(
    entities =[Article::class],
version=1
)
@TypeConverters(Converters::class)
abstract  class ArticleDatabase: RoomDatabase() {
    abstract val getDao: articleDao
    //Instance of an database
    //To ensure that we only have one unstance of database at a time
    companion object {

        @Volatile
        private var INSTANCE: ArticleDatabase? = null

        operator fun invoke(context: Context): ArticleDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ArticleDatabase::class.java,
                        "ArticleDatabase"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    //Initiating the new Instance with the instance
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
