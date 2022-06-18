package com.example.myrejiapplication

import android.service.autofill.UserData
import android.util.Log
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class FirebaseDatabaseApp() {


    fun addPostEventListener() {
        //
        val userData = UserData()
        //リスナー設定
        //共通リファランス
        val firebaseDatabase = Firebase.database.reference
        FirebaseDatabase.getInstance().getReference()
        //val postReference: DatabaseReference=firebaseDatabase

        val postReference = firebaseDatabase.child("shop")// .getReference()

        val refMap: DatabaseReference = Firebase.database.getReference("shop")
        // refMap.child("TableList").addChildEventListener(object : ChildEventListener {

        refMap.child("TableName").addValueEventListener(object : ValueEventListener {
            // val postListener = object : ValueEventListener {

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.d("TAG-pitems", "items.values.toString()")
                // Log.w("TAG--loadPost:onCancelled", databaseError.toException())
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                //
                val items: HashMap<String, String>? =
                    dataSnapshot.child("shop").getValue(object :
                        GenericTypeIndicator<HashMap<String, String>>() {})


                // val   map= mapOf(dataSnapshot.key)
                //     val  map1=map.filterKeys { key -> "Kotlin" in key }


                if (items != null) {
                    Log.d("TAG-pitems", items.values.toString())
                }

                if (items != null) {
                    Log.d("TAG-pitems", items.keys.toString())
                }
            }
        })
    }
}


//リスナーをTableListに設置、実装
        // postReference.child("TableList").addValueEventListener(postListener)
     //   postReference.addValueEventListener(postListener)
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
// }