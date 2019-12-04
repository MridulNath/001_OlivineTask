package com.example.olivinetask;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.olivinetask.entities.Student;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonRecyclerViewList extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    Student student;
    Context context;
    private MyAdapter myAdapter;

    onRecyclerListener listener;




    int[] images={R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,R.drawable.bangladesh,
            R.drawable.bangladesh,R.drawable.bangladesh};

    String[] name=getResources().getStringArray(R.array.Country_name);
    String[] pass=getResources().getStringArray(R.array.pass);
    String[] emaail=getResources().getStringArray(R.array.Email);

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
        listener= (onRecyclerListener) context;
    }

    public PersonRecyclerViewList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person_recycler_view_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recylerView);

        recyclerView.setHasFixedSize(true);


        // use a linear layout manager
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    public interface onRecyclerListener{
        public void registrationButtonClidked();
    }




}
