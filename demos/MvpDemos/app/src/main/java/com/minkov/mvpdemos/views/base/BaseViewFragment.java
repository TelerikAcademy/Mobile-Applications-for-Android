package com.minkov.mvpdemos.views.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.minkov.mvpdemos.MvpApplication;
import com.minkov.mvpdemos.ui.ModalFactory;
import com.minkov.mvpdemos.ui.Notifier;
import com.minkov.mvpdemos.utils.UIOperationsHandler;

import javax.inject.Inject;

public class BaseViewFragment extends Fragment {
    @Inject
    Notifier notifier;

    @Inject
    ModalFactory modalFactory;

    @Inject
    UIOperationsHandler uiOperationsHandler;

    public BaseViewFragment() {
        //empty constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onStart();
        ((MvpApplication) this.getActivity().getApplication())
                .getComponent()
                .inject(this);
    }

    public void notify(final String message) {
        notifier.notifySuccess(this.getActivity(), message);
    }

    public ModalFactory getModalFactory() {
        return modalFactory;
    }

    public UIOperationsHandler getUIOperationsHandler() {
        return this.uiOperationsHandler;
    }
}
