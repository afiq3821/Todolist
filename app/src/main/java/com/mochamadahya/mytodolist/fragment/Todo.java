package com.mochamadahya.mytodolist.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mochamadahya.mytodolist.R;
import com.mochamadahya.mytodolist.model.TodoJava;


/**
 * A simple {@link Fragment} subclass.
 */
public class Todo extends Fragment {


    public Todo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        TodoJava toodo = new TodoJava(1,"makan malam", "makan malam bersama teman", "besok", "todo");
//        //tampilkan nama
//        todoo.getNama();
//        //ubah nama
//        toodo.setNama("bermain bola");
//        //tampilkan nama
//        toodo.getNama();

        return inflater.inflate(R.layout.fragment_todo, container, false);
    }

}
