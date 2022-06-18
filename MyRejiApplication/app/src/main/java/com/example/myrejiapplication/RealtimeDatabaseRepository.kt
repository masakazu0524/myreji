package com.example.myrejiapplication

import android.util.Log
import androidx.compose.ui.input.key.Key.Companion.F
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.sendBlocking
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.scan

open class RealtimeDatabaseRepository {

    fun appFirebaseRealtime(){

        val firebaseDatabase = Firebase.database.reference

        FirebaseDatabaseApp().addPostEventListener()
        Log.d("TAG-c",FirebaseDatabaseApp().addPostEventListener().toString())
    }



    @OptIn(InternalCoroutinesApi::class)
    @FlowPreview
    @ExperimentalCoroutinesApi
    suspend fun zunDokoKiyoshi() : Flow<String> = flow{

       // val sample = Sample()
        val zunZunZunZunDoko = listOf("ズン", "ズン", "ズン", "ズン", "ドコ")
        val KI_YO_SHI = "キ・ヨ・シ！"

     //   flow {
            val source = listOf("ズン", "ドコ")
          //  while (true) {
                emit(source.shuffled().first())
                delay(500)
         //   }
       // }
        //  .scan(emptyList<String>()) { list, s -> (list + s).takeLast(5) }
        //  .dropWhile { it.isEmpty() }
      //   .flatMapConcat { scanned ->
      //  flow {
      //      emit(scanned.last())
            //if (scanned == zunZunZunZunDoko) {
            //     delay(500)
            //   emit(KI_YO_SHI)
            }
        }
       //     .onEach { println(it) }
      //      .collect()

   // }

//}




//
    // .takeWhile { it != KI_YO_SHI }


