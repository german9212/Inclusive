package com.example.inclusive.viewmodel.auth

import android.app.Application
import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import com.example.inclusive.model.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser


class AuthViewModel :ViewModel{

    private var authRepository:AuthRepository

    private var _userData: MutableLiveData<FirebaseUser>
      val getuserData:MutableLiveData<FirebaseUser>
       get() = _userData



    private var _loggerStatus: MutableLiveData<Boolean>
    val loggerStatus:MutableLiveData<Boolean>
        get() = _loggerStatus

    constructor(){
        authRepository=AuthRepository()
        _userData= authRepository.firebaseUserMutableLiveData
        _loggerStatus=authRepository.userLoggedMutableLiveData
    }

    fun register(correo:String,contraseña:String,context: Context){
        authRepository.register(correo,contraseña,context)
    }
    fun sigin(correo:String,contraseña:String,context: Context){
        authRepository.sigin(correo,contraseña,context)
    }
    fun logout(){
        authRepository.logout()
    }


}