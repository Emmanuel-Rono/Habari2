package mvvmApp.Adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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



   class viewHolder(itemview: View):RecyclerView.ViewHolder(itemview) {
        val image = itemview.findViewById<ImageView>(R.id.ivArticleImage)
        val text1 = itemview.findViewById<TextView>(R.id.tvSource)
        val text2 = itemview.findViewById<TextView>(R.id.tvTitle)
        val text3 = itemview.findViewById<TextView>(R.id.tvDescription)
        val text4 = itemview.findViewById<TextView>(R.id.tvPublishedAt)
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
            return viewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.fragment_article,
                    parent,
                    false
                )
            )
        }

        override fun onBindViewHolder(holder: viewHolder, position: Int) {
            //get current article
            val currentarticle = differ.currentList[position]
            // so we can reference our views
            holder.itemView.apply {

                Glide.with(this).load(currentarticle.urlToImage).into(.image)

            }

        }

        override fun getItemCount(): Int {
            return differ.currentList.size

        }

    }
