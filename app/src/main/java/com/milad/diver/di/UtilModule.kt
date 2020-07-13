package com.milad.diver.di

import com.milad.diver.ui.util.UtilDateAndTime
import org.koin.dsl.module

val utilModule= module {

    factory { UtilDateAndTime() }
}