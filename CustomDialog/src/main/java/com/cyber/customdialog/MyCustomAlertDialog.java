package com.cyber.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cyber.customdialog.databinding.DialogLayoutCustomBinding;

public class MyCustomAlertDialog extends Dialog {

    private  OnClickListener okBtnListener;
    private OnClickListener cancelButtonListener;
    DialogLayoutCustomBinding binding;



    public MyCustomAlertDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.binding = DialogLayoutCustomBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setContentView(binding.getRoot());



        binding.dialogButtonOk.setOnClickListener(v->{
            if(okBtnListener != null){
                okBtnListener.onClick(this, DialogInterface.BUTTON_POSITIVE);
            }
        });

        binding.dialogButtonCancel.setOnClickListener(v->{
            if(cancelButtonListener != null){
                cancelButtonListener.onClick(this, DialogInterface.BUTTON_NEGATIVE);
            }
        });
    }

    public void setOnOKClickListener(OnClickListener listener){
        okBtnListener = listener;
    }

    public void setCancelButtonListener(OnClickListener listener){
        binding.dialogButtonCancel.setVisibility(View.VISIBLE);
        cancelButtonListener = listener;
    }

    public void setOkButtonText(String text){
        binding.dialogButtonOk.setText(text);
    }

    public void setCancelButtonText(String text){
        binding.dialogButtonCancel.setVisibility(View.VISIBLE);
        binding.dialogButtonCancel.setText(text);
    }

    public void setDialogTitle(String text){
        binding.dialogTitle.setText(text + "");
    }






}
