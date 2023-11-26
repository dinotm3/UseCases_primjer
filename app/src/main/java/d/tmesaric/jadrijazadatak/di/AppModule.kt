package d.tmesaric.jadrijazadatak.di

import android.app.Application
import androidx.room.Room
import d.tmesaric.jadrijazadatak.data.ZadatakDAO
import d.tmesaric.jadrijazadatak.data.ZadatakDB
import d.tmesaric.jadrijazadatak.data.repository.ZadatakRepositoryImpl
import d.tmesaric.jadrijazadatak.domain.repository.ZadatakRepository
import d.tmesaric.jadrijazadatak.domain.use_case.AddZadatakUseCase
import d.tmesaric.jadrijazadatak.domain.use_case.DeleteZadatakUseCase
import d.tmesaric.jadrijazadatak.domain.use_case.GetZadaciUseCase
import d.tmesaric.jadrijazadatak.domain.use_case.ZadatakUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideZadatakDB(app: Application): ZadatakDB {
        return Room.databaseBuilder(
            app,
            ZadatakDB::class.java,
            ZadatakDB.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideZadatakRepository(db: ZadatakDB): ZadatakRepository {
        return ZadatakRepositoryImpl(db.zadatakDao)
    }

    @Provides
    @Singleton
    fun provideZadatakUseCases(repository: ZadatakRepository): ZadatakUseCases {
        return ZadatakUseCases(
            getZadaciUseCase = GetZadaciUseCase(repository),
            deleteZadatakUseCase = DeleteZadatakUseCase(repository),
            addZadatakUseCase = AddZadatakUseCase(repository)
        )
    }
}