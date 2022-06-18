package com.example.myrejiapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

class FirebaseViewModel ():ViewModel(){



    val count = MutableLiveData<String>()

    fun asd(){

        RealtimeDatabaseRepository().appFirebaseRealtime()
    }


    @OptIn(FlowPreview::class)
    fun example1() {
        viewModelScope.launch(Dispatchers.Main) {
            RealtimeDatabaseRepository().zunDokoKiyoshi()



.collect{count.value=it}

           // runBlocking {
    println(count.value)

//}

            // IOバックグラウンドスレッドで実行する処理
        }
    }




}

