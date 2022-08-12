package xyz.teamgravity.roomtrigger.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import xyz.teamgravity.roomtrigger.data.local.constant.NumberConst

@Entity(tableName = NumberConst.TABLE_COUNT)
data class CountEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long,

    val count: Int,
)
