package com.iharnoor.anthemconnection

import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject


val questionsList = listOf<String>("I feel like a valuable team member at Anthem:",
        "My work environment allows me to make progress at my job:",
        "I am comfortable asking coworkers and supervisors for help:",
        "If I get upset at work, I know who to talk to:",
        "I feel safe around my coworkers:",
        "When my coworkers are unhappy, I know how to help them:",
        "I rarely have issues working with groups:",
        "I feel like work is distributed evenly and fairly in my group projects:",
        "Goals are made faster when working in a group:",
        "I tend to be the leader of my group projects:")

var count = 1
var streaks = 0

//val answerlist= arrayListOf<>()
val jsonArray = JSONArray()
var selectedEmoji = "happy"
//var btnName ="/"
val hashmap = HashMap<String, String>()

fun pushFirebase(question: String, username: String, answer: String, uniqueKey: String) {


    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference()
    myRef.child("user").setValue(hashmap)
//    val ques1 = HashMap<String,String>()

//    val ques = Question(question,username,answer)
//    val question = HashMap<String, String>()

    hashmap.put("${uniqueKey}question", question)
    hashmap.put("${uniqueKey}username", username)
    hashmap.put("${uniqueKey}answer", answer)

//    hashmap.put("array", hashmap)

//    database.("users").child(userId).setValue(user);
//    myRef.setValue(hashmap)
//    myRef.setValue(ques)
//     myRef.child("user").setValue(hashmap)
}

//val database = FirebaseDatabase.getInstance()!!
//val myRef = database.getReference()!!

//fun pushFirebase(question: String, username: String, answer: String) {
//    val ques = Question(question, username, answer)
////    val ques1 = HashMap<String,String>()
//
////    val ques = Question(question,username,answer)
////    val question = HashMap<String, String>()
//
////    hashmap.put("question", question)
////    hashmap.put("username", username)
////    hashmap.put("answer", answer)
//
//    myRef.child("messsage").child(question).setValue(ques)
////    mDatabase.child("users").child(userId).setValue(user);
////    hashmap.put("array", hashmap)
//
////    database.("users").child(userId).setValue(user);
////    myRef.setValue(hashmap)
////    myRef.setValue(ques)
//}