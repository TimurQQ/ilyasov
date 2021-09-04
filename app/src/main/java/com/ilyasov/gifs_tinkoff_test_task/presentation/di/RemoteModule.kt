package com.ilyasov.gifs_tinkoff_test_task.presentation.di;

import com.ilyasov.gifs_tinkoff_test_task.data.db.remote.api.APIInterface
import com.ilyasov.gifs_tinkoff_test_task.data.db.remote.api.GifsAPI
import com.ilyasov.gifs_tinkoff_test_task.data.db.repository.RemoteRepository
import com.ilyasov.gifs_tinkoff_test_task.data.db.repository.RemoteRepositoryImpl
import com.ilyasov.gifs_tinkoff_test_task.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RemoteModule {
    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder().apply {
            addInterceptor(interceptor)
        }.build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideAPIInterface(retrofit: Retrofit): APIInterface =
        retrofit.create(GifsAPI::class.java)

    @Singleton
    @Provides
    fun providesRemoteRepository(service: APIInterface): RemoteRepository =
        RemoteRepositoryImpl(service)
}
