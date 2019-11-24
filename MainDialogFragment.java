package com.senai.yuri.basicdialogfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;

import com.senai.yuri.basicdialogfragment.databinding.DialogFragmentAlertMessageBinding;

public class MainDialogFragment extends DialogFragment {
    private DialogFragmentAlertMessageBinding binding;

    static final String NAME = "username";
    static final String MESSAGE = "message_to_username";

    String name;
    String message;


    static MainDialogFragment newInstance(@NonNull String name, @NonNull String message){
        MainDialogFragment dialogFragment = new MainDialogFragment();
        Bundle arguments = new Bundle();
        arguments.putString(NAME,name);
        arguments.putString(MESSAGE,message);
        dialogFragment.setArguments(arguments);
        return dialogFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        name = getArguments().getString(NAME);
        message = getArguments().getString(MESSAGE);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DataBindingUtil.inflate(inflater,R.layout.dialog_fragment_alert_message,container,false);

        binding.name.setText(name);
        binding.message.setText(message);

        return binding.getRoot();
    }
}
