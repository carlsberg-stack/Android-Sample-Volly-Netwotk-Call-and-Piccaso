package com.kepler.codechallenge.boilers;

import com.kepler.codechallenge.api.VolleyCallback;
import com.kepler.codechallenge.api.VolleyController;

import io.reactivex.rxjava3.observers.DisposableSingleObserver;

public interface MainFragmentCommunicator extends BaseFragmentCommunicator{
    void loadDeleiveries(DisposableSingleObserver disposableSingleObserver) ;
}