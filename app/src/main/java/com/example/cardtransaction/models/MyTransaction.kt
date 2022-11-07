package com.example.cardtransaction.models

import android.annotation.SuppressLint
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

@Entity
class MyTransaction {


    @PrimaryKey(autoGenerate = true)
    var id:Int?=null


    var fromCardId:Int?=null
    var toCard:Int?=null

    constructor(fromCardId: Int?, toCard: Int?, summa: Double?) {
        this.fromCardId = fromCardId
        this.toCard = toCard
        this.summa = summa
    }

    var summa:Double?=null
    @SuppressLint("SimpleDateFormat")
    var data=SimpleDateFormat("dd.MM.yyyy HH.mm.ss").format(Date())
}