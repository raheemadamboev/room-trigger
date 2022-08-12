package xyz.teamgravity.roomtrigger.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import xyz.teamgravity.roomtrigger.data.local.constant.NumberConst

@Entity(tableName = NumberConst.TABLE_NUMBER)
data class NumberEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long,

    val number: Int,
)
