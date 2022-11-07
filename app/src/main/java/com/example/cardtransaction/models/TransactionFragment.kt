package com.example.cardtransaction.models

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.cardtransaction.R
import com.example.cardtransaction.databinding.FragmentTransactionBinding

class TransactionFragment : Fragment() {
    private lateinit var binding: FragmentTransactionBinding
    private lateinit var cardList:ArrayList<MyCard>
    private lateinit var cardNameList:ArrayList<String>
    private lateinit var appDatabase: AppDatabase
    private lateinit var listTransaction:ArrayList<MyTransaction>
    private lateinit var myTransactionRvAdapter: MyTransactionRvAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentTransactionBinding.inflate(layoutInflater)


      appDatabase=AppDatabase.getInstance(binding.root.context)
        loadCard()
        setTransaction()
        showAllTransaction()
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setTransaction() {
        binding.saveButton.setOnClickListener {
            val myTransaction=MyTransaction(
               cardList[binding.spinnerFromCard.selectedItemPosition].id,
                cardList[binding.spinnerToCard.selectedItemPosition].id,
                binding.edtName.text.toString().toDouble()


            )

            appDatabase.myDao().addTransaction(myTransaction)
            showAllTransaction()
        }
    }
    fun showAllTransaction(){
   listTransaction= ArrayList()

        listTransaction.addAll(appDatabase.myDao().getTransaction())
        myTransactionRvAdapter= MyTransactionRvAdapter(listTransaction,appDatabase)
        binding.rvTransaction.adapter=myTransactionRvAdapter
    }

    private fun loadCard() {

        cardList= ArrayList()
        cardNameList=ArrayList()
        cardList.addAll(appDatabase.myDao().getCards())
        cardList.forEach {
            cardNameList.add(it.name!!)
        }

        var spinnerAdapter=ArrayAdapter<String>(binding.root.context, android.R.layout.simple_list_item_1,cardNameList )

        binding.spinnerToCard.adapter=spinnerAdapter
        binding.spinnerFromCard.adapter=spinnerAdapter
    }


}