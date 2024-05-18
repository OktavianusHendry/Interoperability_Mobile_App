package com.okta.interoperability.ui

import android.content.Context
import androidx.lifecycle.ViewModel

//class ViewModelFactory private constructor(private val repository: Repository) {
//    ViewModelProvider.NewInstanceFactory() {
//
//        @Suppress("UNCHECKED_CAST")
//        override fun <T : ViewModel> create(modelClass: Class<T>): T {
//            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
//                return MainViewModel(pref) as T
//            }
//            throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
//        }
//
//        companion object {
//            @Volatile
//            private var instance: FavUserViewModelFactory? = null
//            fun getInstance(context: Context): FavUserViewModelFactory =
//                instance ?: synchronized(this) {
//                    instance ?: FavUserViewModelFactory(Injection.provideRepository(context))
//                }.also { instance = it }
//        }
//}