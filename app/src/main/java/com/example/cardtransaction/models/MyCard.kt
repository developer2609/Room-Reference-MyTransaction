package com.example.cardtransaction.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class MyCard {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null


    var name: String? = null
    var Cardnumber: Long? = null

    constructor(name: String?, Cardnumber: Long?) {
        this.name = name
        this.Cardnumber = Cardnumber
    }

    constructor()


}


