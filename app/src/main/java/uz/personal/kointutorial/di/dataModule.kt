package uz.personal.kointutorial.di

import org.koin.dsl.module
import uz.personal.kointutorial.remote.retrofitBuilder.RetrofitBuilder
import uz.personal.kointutorial.room.appDatabase.AppDatabase

val dataModule = module {
    single {
        RetrofitBuilder.retrofitBuilder()
    }

    single {
        AppDatabase.getDataDB(context = get())
    }

    single {
        get<AppDatabase>().dao()
    }
}