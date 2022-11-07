package com.example.cardtransaction.models

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cardtransaction.databinding.ItemTransactionRvBinding


class MyTransactionRvAdapter (var list: List<MyTransaction>,var appDatabase: AppDatabase) : RecyclerView.Adapter<MyTransactionRvAdapter.VP_Vh>() {

    inner class VP_Vh(var itemListBinding: ItemTransactionRvBinding):
        RecyclerView.ViewHolder(itemListBinding.root) {
        fun onBind(myTransaction: MyTransaction) {

            itemListBinding.apply {
                tvSumma.text=myTransaction.summa.toString()+"so'm"
                tvData.text=myTransaction.data
                tvCardTo.text=appDatabase.myDao().getCardById(myTransaction.toCard!!).name
                tvCardFrom.text=appDatabase.myDao().getCardById(myTransaction.fromCardId!!).name
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VP_Vh {
        return VP_Vh(ItemTransactionRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    }

    override fun onBindViewHolder(holder: VP_Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size



}