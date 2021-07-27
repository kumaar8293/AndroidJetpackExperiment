package com.example.experiment.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * Most of code written inside Activity/Fragment lifecycle methods -> onCreate(), onResume() etc etc
 * Due to this Activity has multiple responsibilities
 * But there are scenario where we want to take action based on activity/fragment lifecycle.
 * For eg :- Access the user location ,Playing video, Downloading image etc etc
 */
class MyObserver : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.d("MyObserver", "onStart: ")
        // Initialize something
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        // Fetch user location
        Log.d("MyObserver", "onCreate: ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        // Resume location
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        // Stop fetching location
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        // Stop observer
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        // Cancel fetching location
    }
}