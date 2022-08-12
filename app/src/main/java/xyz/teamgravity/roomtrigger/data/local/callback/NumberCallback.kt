package xyz.teamgravity.roomtrigger.data.local.callback

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import xyz.teamgravity.roomtrigger.data.local.constant.NumberConst.TABLE_COUNT
import xyz.teamgravity.roomtrigger.data.local.constant.NumberConst.TABLE_NUMBER

class NumberCallback : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        db.execSQL("INSERT INTO $TABLE_COUNT (id, count) VALUES (0, 0);")
        db.execSQL("CREATE TRIGGER updateCount AFTER INSERT ON $TABLE_NUMBER BEGIN UPDATE $TABLE_COUNT SET count = (SELECT COUNT(*) FROM $TABLE_NUMBER); END;")
    }
}