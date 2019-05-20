package ru.r3tam.roompet.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.r3tam.roompet.data.dao.CardDao
import ru.r3tam.roompet.data.dao.CustomerDao
import ru.r3tam.roompet.data.entity.Card
import ru.r3tam.roompet.data.entity.Customer

@Database(
    entities = [Customer::class, Card::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun customerDao(): CustomerDao

    abstract fun cardDao(): CardDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        /**
         * Получаем инстанс БД
         * В виде синглтона
         */
        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "App_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}