package xyz.teamgravity.roomtrigger.data.mapper

import xyz.teamgravity.roomtrigger.data.local.entity.CountEntity
import xyz.teamgravity.roomtrigger.data.model.CountModel

fun CountEntity.toModel(): CountModel {
    return CountModel(
        id = id,
        count = count
    )
}