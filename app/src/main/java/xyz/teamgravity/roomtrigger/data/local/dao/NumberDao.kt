package xyz.teamgravity.roomtrigger.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import xyz.teamgravity.roomtrigger.data.local.constant.NumberConst.TABLE_COUNT
import xyz.teamgravity.roomtrigger.data.local.entity.CountEntity
import xyz.teamgravity.roomtrigger.data.local.entity.NumberEntity

@Dao
interface NumberDao {

    ///////////////////////////////////////////////////////////////////////////
    // INSERT
    ///////////////////////////////////////////////////////////////////////////

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNumber(number: NumberEntity)

    ///////////////////////////////////////////////////////////////////////////
    // GET
    ///////////////////////////////////////////////////////////////////////////

    @Query("SELECT * FROM $TABLE_COUNT LIMIT 1")
    fun getCount(): Flow<CountEntity?>
}