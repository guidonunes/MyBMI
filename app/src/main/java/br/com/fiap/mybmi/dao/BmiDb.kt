package br.com.fiap.mybmi.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.mybmi.model.Weight

@Database(entities = [Weight::class], version = 2, exportSchema = false)
abstract class BmiDb: RoomDatabase() {
    abstract fun weightDao(): WeightDao

    companion object {
        @Volatile
        private var INSTANCE: BmiDb? = null

        fun getDatabase(context: Context): BmiDb {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BmiDb::class.java,
                    "bmi_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
