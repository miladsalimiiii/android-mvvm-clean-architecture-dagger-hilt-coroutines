package com.milad.diver.di

import com.milad.diver.data.repository.InformationRepository
import com.milad.diver.data.repository.InformationRepositoryImle
import org.koin.dsl.module

val repositoryModule= module {

    factory { InformationRepositoryImle(get()) }
}