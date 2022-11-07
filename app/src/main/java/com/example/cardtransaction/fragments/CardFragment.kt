package com.example.cardtransaction.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RemoteViews
import android.widget.Toast
import com.example.cardtransaction.R
import com.example.cardtransaction.databinding.FragmentCardBinding
import com.example.cardtransaction.models.AppDatabase
import com.example.cardtransaction.models.MyCard
import com.example.cardtransaction.models.MyCardAdapter

class CardFragment : Fragment() {
    private lateinit var binding: FragmentCardBinding
    private lateinit var appDatabase: AppDatabase
    private lateinit var list: ArrayList<MyCard>
    private lateinit var myCardAdapter: MyCardAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentCardBinding.inflate(layoutInflater)

        appDatabase=AppDatabase.getInstance(binding.root.context)


            list= ArrayList()
        list.addAll(appDatabase.myDao().getCards())
        myCardAdapter= MyCardAdapter(list)


        binding.apply {
            rvCard.adapter=myCardAdapter
            saveButton.setOnClickListener {
                val myCard=MyCard(
              edtName.text.toString(),
                    edtNumber.text.toString().toLong()


                )
                appDatabase.myDao().addCard(myCard)
                Toast.makeText(context, "save", Toast.LENGTH_SHORT).show()
                list.add(myCard)
                myCardAdapter.notifyItemInserted(list.size-1)}
        }
        // Inflate the layout for this fragment
        return binding.root
    }


}