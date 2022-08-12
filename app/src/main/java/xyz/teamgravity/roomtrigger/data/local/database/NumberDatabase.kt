package xyz.teamgravity.roomtrigger.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import xyz.teamgravity.roomtrigger.data.local.constant.NumberConst
import xyz.teamgravity.roomtrigger.data.local.dao.NumberDao
import xyz.teamgravity.roomtrigger.data.local.entity.CountEntity
import xyz.teamgravity.roomtrigger.data.local.entity.NumberEntity

@Database(
    entities = [NumberEntity::class, CountEntity::class],
    version = NumberConst.VERSION,
    exportSchema = false
)
abstract class NumberDatabase : RoomDatabase() {

    abstract fun numberDao(): NumberDao
}