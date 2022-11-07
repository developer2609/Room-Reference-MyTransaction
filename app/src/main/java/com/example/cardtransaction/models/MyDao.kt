package com.example.cardtransaction.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface MyDao {

    @Insert
    fun addCard(card: MyCard)


    @Insert
    fun addTransaction(myTransaction: MyTransaction)


     @Query("select *from mycard")
    fun getCards():List<MyCard>


    @Query("select *from mytransaction")
     fun getTransaction():List<MyTransaction>

     @Query("select * from mycard where id=:id")
     fun getCardById(id:Int):MyCard

}