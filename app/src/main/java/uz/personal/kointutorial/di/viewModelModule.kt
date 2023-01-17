package uz.personal.kointutorial.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import uz.personal.kointutorial.ui.MainViewModel

val viewModelModule = module {
    viewModel {
        MainViewModel(get())
    }
}