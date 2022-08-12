package xyz.teamgravity.roomtrigger.data.mapper

import xyz.teamgravity.roomtrigger.data.local.entity.NumberEntity
import xyz.teamgravity.roomtrigger.data.model.NumberModel

fun NumberModel.toEntity(): NumberEntity {
    return NumberEntity(
        id = id,
        number = number
    )
}