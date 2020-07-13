package com.milad.diver.di

import com.milad.diver.data.repository.InformationRepository
import org.koin.dsl.module

val repositoryModule= module {

    factory { InformationRepository(get()) }
}