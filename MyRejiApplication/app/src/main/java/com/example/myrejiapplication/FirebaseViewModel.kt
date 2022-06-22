package com.example.myrejiapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect


class FirebaseViewModel ():ViewModel(){

     var database: DatabaseReference= Firebase.database.reference
    val count = MutableLiveData<String>()

    fun  firebaseData(){
        viewModelScope.launch (Dispatchers.IO){


            RealtimeDatabaseRepository().appFirebaseRealtime(database)

        }
    }





    @OptIn(FlowPreview::class)
    fun example1() {
        viewModelScope.launch(Dispatchers.Main) {
            RealtimeDatabaseRepository().zunDokoKiyoshi()



//.collect{count.value=it}

           // runBlocking {
    println(count.value)

//}

            // IOバックグラウンドスレッドで実行する処理
        }
    }




}

