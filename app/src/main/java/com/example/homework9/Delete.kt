package com.example.homework9

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import okio.IOException

class Delete(appContext: Context, workerParameters: WorkerParameters) :
    Worker(appContext, workerParameters) {
    override fun doWork(): Result {
        return try {
            Thread {
                App.instance.db.appDao().delete()
            }.start()
            Result.success()
        } catch (e: IOException) {
            Result.failure()
        }
    }
}