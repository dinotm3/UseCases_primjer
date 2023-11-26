package d.tmesaric.jadrijazadatak.data

import androidx.room.Database
import androidx.room.RoomDatabase
import d.tmesaric.jadrijazadatak.domain.model.Zadatak


@Database(
    entities = [Zadatak::class],
    version = 1
)
abstract class ZadatakDB : RoomDatabase() {

    abstract val zadatakDao: ZadatakDAO

    companion object {
        const val DATABASE_NAME = "zadatak_db"
    }
}