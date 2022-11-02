package mvvmApp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import okio.Source


@Entity(
    tableName="newsTable")
data class Article(
    @PrimaryKey(autoGenerate = true)
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)