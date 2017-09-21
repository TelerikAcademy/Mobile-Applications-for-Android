package com.minkov.mvpdemos.ui;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.minkov.mvpdemos.R;

public class ModalFactory {
    public Dialog getAddNameModal(Context context, ModalFactoryPositiveHandler onPositiveHandler) {
        return this.getAddNameModal(context, onPositiveHandler, null);
    }

    public Dialog getAddNameModal(Context context, ModalFactoryNegativeHandler onNegativeHandler) {
        return this.getAddNameModal(context, null, onNegativeHandler);
    }

    public Dialog getAddNameModal(Context context) {
        return this.getAddNameModal(context, null, null);
    }

    public Dialog getAddNameModal(Context context, final ModalFactoryPositiveHandler onPositiveHandler, final ModalFactoryNegativeHandler onNegativeHandler) {
        return new MaterialDialog.Builder(context)
                .title("Add")
                .content("Are you sure?")
                .positiveText("Yes")
                .negativeText("No")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        if (onPositiveHandler == null) {
                            return;
                        }

                        onPositiveHandler.onPositive();
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        if (onNegativeHandler == null) {
                            return;
                        }
                        onNegativeHandler.onNegative();
                    }
                })
                .build();
    }

    public interface ModalFactoryPositiveHandler {
        void onPositive();
    }

    public interface ModalFactoryNegativeHandler {
        void onNegative();
    }
}
