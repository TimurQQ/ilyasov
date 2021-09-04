package com.ilyasov.gifs_tinkoff_test_task

import android.app.Application
import com.ilyasov.gifs_tinkoff_test_task.presentation.di.AppComponent
import com.ilyasov.gifs_tinkoff_test_task.presentation.di.AppModule
import com.ilyasov.gifs_tinkoff_test_task.presentation.di.DaggerAppComponent

class App: Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    private fun initializeDagger() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}