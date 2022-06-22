package com.example.myrejiapplication

import android.service.autofill.UserData
import android.util.Log
import android.widget.ArrayAdapter
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class TableName  //EMPTY CONSTR
{
    var name: String? = null
}


class FirebaseHelper(var db: DatabaseReference) {
    var saved: Boolean? = null
    var tablenames: ArrayList<String> = ArrayList()
    var tablenames1: HashMap<String, String>? = HashMap()
    var tableList: MutableList<Any> = mutableListOf()
    var tableList1: MutableList<String> = mutableListOf()
    //SAVE
    fun save(spacecraft: TableName?): Boolean? {
        saved = if (spacecraft == null) {
            false
        } else {
            try {
                db.child("Spacecraft").push().setValue(spacecraft)
                true
            } catch (e: DatabaseException) {
                e.printStackTrace()
                false
            }
        }
        return saved
    }

    //READ
    //特定の場所のデータsnapshot
    fun retrieve(): MutableList<String> {
        db.child("shop").child("TableName") .addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(dataSnapshot: DataSnapshot, s: String?) {

               fetchDataToList(dataSnapshot)
                Log.d("TAG-pitems/add",dataSnapshot.toString())
            }

            override fun onChildChanged(dataSnapshot: DataSnapshot, s: String?) {
                tableList1.clear()
                Log.d("TAG-pitems/cange", dataSnapshot.childrenCount .toString())
                fetchDataToList(dataSnapshot)

            }

            override fun onChildRemoved(dataSnapshot: DataSnapshot) {}
            override fun onChildMoved(dataSnapshot: DataSnapshot, s: String?) {}
            override fun onCancelled(databaseError: DatabaseError) {}
        })

        return tableList1
    }

    private fun fetchData(dataSnapshot: DataSnapshot) {
        tableList.clear()
        val childName = "TableName"
        for (ds in dataSnapshot.children) {
            Log.d("TAG-pitems/dskey", ds.key.toString())
            Log.d("TAG-pitems/dsval", ds.value.toString())


            if (ds.key == childName) {

                val items: HashMap<String, String>? =
                    ds.getValue(object :
                        GenericTypeIndicator<HashMap<String, String>>() {})

                if (items != null) {
                    items.map {
                        tableList.add(it.value).toString()


                        Log.d("TAG-tanamap", tableList.toString())



                    }
                }
                Log.d("TAG-tana", tablenames.toString())
            }

        }

    }

    private fun fetchDataToList(dataSnapshot: DataSnapshot) {

        val aaa=dataSnapshot.value.toString()
        tableList1.add(aaa)
        Log.d("TAG-tanamap", tableList1.toString())
    }

    //ValueEventListenerはデータのリスト全体が単一の DataSnapshot として返される
     fun addPostEventListener() {

     //    val postReference: DatabaseReference=databaseReference.child("shop")
     //    db.addValueEventListener(object : ValueEventListener {

        // [START post_value_event_listener]
        //val postListener = object : ValueEventListener {
      //      override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                // val post = dataSnapshot.getValue<Post>()
                // ...
//
      //          fetchData(dataSnapshot)

     //       }

       //     override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                //Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
              }
     //   db.child("shop").child("TableName") .addValueEventListener(postListener)
     //   Log.d("TAG-post",postListener.toString())
        // [END post_value_event_listener]
     //    ) }

//}







/*
    class FirebaseDatabaseApp(var databaseReference: DatabaseReference) {

        private val postReference: DatabaseReference=databaseReference.child("shop")
        fun addPostEventListener() {

            val postListener = object : ValueEventListener {

                override fun onCancelled(databaseError: DatabaseError) {
                    // Getting Post failed, log a message
                    Log.d("TAG-pitems", "items.values.toString()")
                    Log.w("TAG--loadPost:onCancelled", databaseError.toException())
                }

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                        // Get Post object and use the values to update the UI
                        //
                        val items: HashMap<String, String>? =
                            dataSnapshot.child("shop").getValue(object :
                                GenericTypeIndicator<HashMap<String, String>>() {})


                        // val   map= mapOf(dataSnapshot.key)
                        //     val  map1=map.filterKeys { key -> "Kotlin" in key }

                        Log.d("TAG-pitems/1", items.toString())

                        if (items != null) {
                            Log.d("TAG-pitems", items.values.toString())
                        }

                        if (items != null) {
                            Log.d("TAG-pitems", items.keys.toString())
                        }
                }




//            }



       // }

           // val userData = UserData()

            //リスナー設定
            //共通リファランス

           // FirebaseDatabase.getInstance().getReference("shop")

            //  val postReference = firebaseDatabase.getReference()//.child("shop")

            //val refMap: DatabaseReference = Firebase.database.getReference("shop")
            // refMap.child("TableList").addChildEventListener(object : ChildEventListener {

           // refMap.addValueEventListener(object : ValueEventListener {
           // postReference.child("TableList").addChildEventListener(object : ChildEventListener {
            //postReference.addValueEventListener(object : ValueEventListener {





         //   }
      //  })

      //  } postReference.addValueEventListener(postListener)













//リスナーをTableListに設置、実装
        // postReference.child("TableList").addValueEventListener(postListener)
     //
// Listen
        // firebaseDatabase.getReference(NOTIFICATION_REFERENCE).addValueEventListener(postListener)








// val fireDatabase = Firebase.database.reference
// val postRef = FirebaseDatabase.getInstance().getReference("shop")
//
// val postListener = object : ValueEventListener {
// override fun onCancelled(error: DatabaseError) {
// // error
// }
//
// override fun onDataChange(dataSnapshot: DataSnapshot) {
// //  val items = dataSnapshot.children.map { ds -> ds.getValue(StoredNotification::class.java).apply { this?.psteRef = ds.key } }
// // items is the result
// }
// // Listen
// // firebaseDatabase.getReference(NOTIFICATION_REFERENCE).addValueEventListener(postListener)
//
// }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
// class right() {
//
//
// val tableList: MutableList<String> = mutableListOf()
// val list = writeNewItem()
// //firebaseに書き込み
//
//
// fun writeNewItem() {
//
//
// //    val postsRef: DatabaseReference = postReference.ref.child("TableList")
// // Generate a reference to a new location and add some data using push()
// //    val pushedPostRef: DatabaseReference = postsRef.push()
//
// var _binding: FragmentTableDetailBinding? = null
// //   val binding get() = _binding!!
//
// val fireDatabase = Firebase.database.reference
// //新規追加書き込みする（push）
// //  text=binding.
// // fireDatabase.child("shop").child("TableName").push().setValue(addTableName)
//
//
// //    fireDatabase.child("shop"). child("TableList").push().setValue(tableList)
//
// //子要素にアクセス
//
//
// val refMap: DatabaseReference = Firebase.database.getReference("shop")
//
//
//
// refMap.child("TableList").addChildEventListener(object : ChildEventListener {
// override fun onChildAdded(dataSnapshot: DataSnapshot, s: String?) {
// // 子要素が追加された時に呼ばれる
// // dataSnapshot : 追加された要素のKey-Value
// // s:追加された要素の一つ前の要素のkey名
// Log.d("TAG-seit", "ValueEventListener#onChildAdded")
// Log.d("TAG-s0", dataSnapshot.toString())
// Log.d("TAG-s1", dataSnapshot.key.toString())
// Log.d("TAG-s2", dataSnapshot.value.toString())
// Log.d(
// "TAG-s3",
// (dataSnapshot.key.toString() to dataSnapshot.value.toString()).toString()
// )
// Log.d("TAG-s4", s.toString())
// Log.d("TAG-s5", dataSnapshot.child("TableList").toString())
// Log.d("TAG-s5", dataSnapshot.child("TableList").value.toString())
//
// //   mutableList.add(dataSnapshot.value.toString())
//
//
// val a = dataSnapshot.key.toString() to dataSnapshot.value.toString()
//
// val items: HashMap<String, String>? = dataSnapshot.child("shop").getValue(object :
// GenericTypeIndicator<HashMap<String, String>>() {})
//
//
// }
//
// override fun onChildChanged(dataSnapshot: DataSnapshot, s: String?) {
// // 子要素に変化があった場合に呼ばれる
// // dataSnapshot : 変化のあった子要素のKey-Value
// // s:変化のあった子要素の一つ前の子要素のKey名
// Log.d("seit", "ValueEventListener#onChildChanged")
// }
//
// override fun onChildRemoved(dataSnapshot: DataSnapshot) {
// // 子要素が削除された
// Log.d("seit", "ValueEventListener#onChildRemoved")
// }
//
// override fun onChildMoved(dataSnapshot: DataSnapshot, s: String?) {
// // 子要素の順番が変化した
// Log.d("seit", "ValueEventListener#onChildMoved")
// }
//
// override fun onCancelled(databaseError: DatabaseError) {
// // サーバーエラーかもしくはセキュリティとデータべースルールによってデータにアクセスできない
// Log.d("seit", "ValueEventListener#onCancelled")
// }
//
// })
// }

hh
hhj
 */