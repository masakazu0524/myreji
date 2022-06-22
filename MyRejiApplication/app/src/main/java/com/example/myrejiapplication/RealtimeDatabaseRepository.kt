package com.example.myrejiapplication

import android.util.Log
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

open class RealtimeDatabaseRepository {

    suspend fun appFirebaseRealtime(database: DatabaseReference) {


        runBlocking {
            var tablenames: ArrayList<String> = ArrayList()
            val deferred = async {

                FirebaseHelper(database).retrieve()
                delay(3000)
                FirebaseHelper(database).tableList1
            }

            withContext(Dispatchers.Main) {
                tablenames = deferred.await() as ArrayList<String>

            }


            //   Log.d("TAG-c1-",mList.toList() .toString())
        }

    }

    //firedatabaseに接続


    // FirebaseHelper(database).addPostEventListener()


    //val firebaseDatabase = Firebase.database.reference

    // FirebaseDatabaseApp().addPostEventListener()
    //


    @OptIn(InternalCoroutinesApi::class)
    @FlowPreview
    @ExperimentalCoroutinesApi
    suspend fun zunDokoKiyoshi(): Flow<String> = flow {

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

    //     .onEach { println(it) }
    //      .collect()

    // }

//}


//
    // .takeWhile { it != KI_YO_SHI }


}