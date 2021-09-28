package com.dcgabriel.myuark.di

import com.dcgabriel.myuark.Networking.CallApi
import com.dcgabriel.myuark.Networking.EventsService
import com.dcgabriel.myuark.Networking.NewsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    //todo create only one instance of retrofit


    @Provides
    @Singleton
    fun provideNewsService(): NewsService {
        val retrofit =
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://campusdata.uark.edu/")
                .build()
        return retrofit.create(NewsService::class.java)
    }

    @Provides
    @Singleton
    fun provideEventsService(): EventsService {
        val retrofit =
            Retrofit.Builder()
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .baseUrl("https://calendars.uark.edu/")
                .build()
        return retrofit.create(EventsService::class.java)
    }

    @Provides
    @Singleton
    fun provideCallApi(newsService: NewsService, eventsService: EventsService): CallApi {
        return CallApi(newsService, eventsService)
    }





}