package uz.personal.kointutorial.di

import org.koin.dsl.module
import uz.personal.kointutorial.repository.NetworkRepository


val repoModule = module {
    single {
        NetworkRepository(get(), get())
    }
}







