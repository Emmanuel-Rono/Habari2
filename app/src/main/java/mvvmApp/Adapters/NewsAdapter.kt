package mvvmApp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.habari2.R
import mvvmApp.models.Article

class NewsAdapter:RecyclerView.Adapter<NewsAdapter.viewHolder> ()
{
    private val diffUtil=object: DiffUtil.ItemCallback<Article>() {

        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == oldItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }
    val differ=AsyncListDiffer(this, diffUtil)



    inner class viewHolder(itemview: View):RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder( LayoutInflater.from(parent.context).inflate(
            R.layout.fragment_article,
            parent,
            false) )
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {


    }

    override fun getItemCount(): Int
    {
return differ.currentList.size

    }


}