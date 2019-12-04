package com.example.olivinetask;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.olivinetask.entities.Student;
import com.google.android.material.textfield.TextInputEditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {
    TextInputEditText nameET,passET,emailET;
    Button btn;
    Context context;
    onRegistrationListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
        listener= (onRegistrationListener) context;
    }


    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameET=view.findViewById(R.id.nameET);
        passET=view.findViewById(R.id.passET);
        emailET=view.findViewById(R.id.emailET);
        btn=view.findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nameET.getText().toString();
                String pass=passET.getText().toString();
                String email=emailET.getText().toString();

                Student student=new Student(name,pass,email);


                listener.registrationButtonClidked();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }


    public interface onRegistrationListener {
        public void registrationButtonClidked();
    }

}
