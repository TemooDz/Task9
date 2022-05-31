package com.example.homework9

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.homework9.db.UserEntity
import okio.IOException

class FetchAndCache(appContext: Context, workerParameters: WorkerParameters) :
    Worker(appContext, workerParameters) {
    override fun doWork(): Result {
        return try {
            repeat(2) {
                ApiClient.getReqResApi.getUsers().execute().body()?.data?.let {
                    val entity = it.map { user ->
                        UserEntity(
                            id = user.id,
                            email = user.email,
                            firstName = user.firstName,
                            lastName = user.lastName
                        )
                    }.toTypedArray()
                    App.instance.db.appDao().insertAll(entity)
                }
            }
            Result.success()
        } catch (e: IOException) {
            Result.failure()
        }
    }
}