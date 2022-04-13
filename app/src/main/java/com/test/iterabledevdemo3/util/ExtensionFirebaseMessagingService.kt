package com.test.iterabledevdemo3.util

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.iterable.iterableapi.IterableFirebaseMessagingService


class ExtensionFirebaseMessagingService : FirebaseMessagingService()  {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        var msg = "Yayy! we did it so good."
        val tok =
        IterableFirebaseMessagingService.handleMessageReceived(this, remoteMessage)
        Log.d("Refresh_Token", msg)
    }

    override fun onNewToken(s: String) {
        IterableFirebaseMessagingService.handleTokenRefresh()
    }

}