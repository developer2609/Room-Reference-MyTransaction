package com.example.cardtransaction.models

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cardtransaction.databinding.ItemCardBinding


class MyCardAdapter (var list: List<MyCard>) : RecyclerView.Adapter<MyCardAdapter.VP_Vh>() {

    inner class VP_Vh(var itemListBinding: ItemCardBinding):
        RecyclerView.ViewHolder(itemListBinding.root) {
        fun onBind(myCard: MyCard) {
          itemListBinding.tvName.text=myCard.name
            itemListBinding.tvNumber.text=myCard.Cardnumber.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VP_Vh {
        return VP_Vh(ItemCardBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    }

    override fun onBindViewHolder(holder: VP_Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size



}