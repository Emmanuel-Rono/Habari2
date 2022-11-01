package mvvmApp.db

import androidx.room.TypeConverter
import mvvmApp.models.Source



class Converters
{
    @TypeConverter
    fun fromSource(source: Source):String
    {
        return source.name
    }
fun tosource (name:String): Source
{
    return Source (name, name)

}


}