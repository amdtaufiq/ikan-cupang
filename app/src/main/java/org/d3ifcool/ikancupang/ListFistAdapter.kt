package org.d3ifcool.ikancupang

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListFistAdapter(val listFish: ArrayList<Fish>) : RecyclerView.Adapter<ListFistAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent,false )

        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listFish.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, type, photo, desc) = listFish[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.img)

        holder.tvName.text = "Nama\t: "+name
        holder.tvType.text = "Jenis\t\t: "+type

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, DetailFishActivity::class.java)
            moveDetail.putExtra(DetailFishActivity.EXTRA_NAME, name)
            moveDetail.putExtra(DetailFishActivity.EXTRA_TYPE, type)
            moveDetail.putExtra(DetailFishActivity.EXTRA_PHOTO, photo)
            moveDetail.putExtra(DetailFishActivity.EXTRA_DESC, desc)
            mContext.startActivity(moveDetail)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvName: TextView = itemView.findViewById(R.id.name)
        var tvType: TextView = itemView.findViewById(R.id.type)
        var img: ImageView = itemView.findViewById(R.id.imageView)
    }
}