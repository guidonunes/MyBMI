package br.com.fiap.mybmi.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.mybmi.model.Weight

@Database(entities = [Weight::class], version = 1)
abstract class BmiDb: RoomDatabase() {
    companion object {
        private lateinit var instance: BmiDb
        fun getDatabase(context: Context): BmiDb {
            if (!::instance.isInitialized) {
                instance = Room.databaseBuilder(
                    context,
                    BmiDb::class.java,
                    "bmi.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}