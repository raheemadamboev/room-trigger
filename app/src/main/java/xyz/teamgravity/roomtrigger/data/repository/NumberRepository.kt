package xyz.teamgravity.roomtrigger.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import xyz.teamgravity.roomtrigger.data.local.dao.NumberDao
import xyz.teamgravity.roomtrigger.data.mapper.toEntity
import xyz.teamgravity.roomtrigger.data.mapper.toModel
import xyz.teamgravity.roomtrigger.data.model.CountModel
import xyz.teamgravity.roomtrigger.data.model.NumberModel

class NumberRepository(
    private val dao: NumberDao,
) {

    ///////////////////////////////////////////////////////////////////////////
    // INSERT
    ///////////////////////////////////////////////////////////////////////////

    suspend fun insertNumber(number: NumberModel) {
        withContext(Dispatchers.IO) {
            dao.insertNumber(number.toEntity())
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // GET
    ///////////////////////////////////////////////////////////////////////////

    fun getCount(): Flow<CountModel?> {
        return dao.getCount().map { it?.toModel() }
    }
}