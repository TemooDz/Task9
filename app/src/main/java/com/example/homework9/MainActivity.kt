package com.example.homework9

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val uploadWorkRequest = OneTimeWorkRequest.from(FetchAndCache::class.java)
        val delete = OneTimeWorkRequest.from(Delete::class.java)
        val listener = WorkManager
            .getInstance(this)
            .beginWith(uploadWorkRequest)
            .then(delete)
        listener.enqueue()
        listener.workInfosLiveData.observe(this) {
            Thread {
                val users = App.instance.db.appDao().loadAllUsers()
                runOnUiThread {
                    val recycler = findViewById<RecyclerView>(R.id.recyclerView)
                    recycler.layoutManager = LinearLayoutManager(this)
                    recycler.adapter = UserAdapter(users)
                }
            }.start()
        }
    }
}