package xyz.teamgravity.roomtrigger.injection.provide

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.teamgravity.roomtrigger.data.local.callback.NumberCallback
import xyz.teamgravity.roomtrigger.data.local.constant.NumberConst
import xyz.teamgravity.roomtrigger.data.local.dao.NumberDao
import xyz.teamgravity.roomtrigger.data.local.database.NumberDatabase
import xyz.teamgravity.roomtrigger.data.repository.NumberRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideNumberCallback(): NumberCallback = NumberCallback()

    @Provides
    @Singleton
    fun provideNumberDatabase(application: Application, numberCallback: NumberCallback): NumberDatabase =
        Room.databaseBuilder(application, NumberDatabase::class.java, NumberConst.NAME)
            .addCallback(numberCallback)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideNumberDao(numberDatabase: NumberDatabase): NumberDao = numberDatabase.numberDao()

    @Provides
    @Singleton
    fun provideNumberRepository(numberDao: NumberDao): NumberRepository = NumberRepository(numberDao)
}