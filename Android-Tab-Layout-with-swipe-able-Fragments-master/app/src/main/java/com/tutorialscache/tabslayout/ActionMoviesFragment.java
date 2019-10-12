package com.tutorialscache.tabslayout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ActionMoviesFragment extends Fragment {
    ListView listView;
    ArrayAdapter<String> arrayAdapter;

    String[] actionMovies = {"Final Score","Venom","Overlord","Hunter Killer","Beirut","Tomb Raider","Den of Thieves","Upgrade",
            "Aquaman","Mohawk","Braven","Mandy","Black Panther","The Commuter","Revenge"};

    public ActionMoviesFragment(){
    //constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_action,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = view.findViewById(R.id.listView);

        arrayAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,actionMovies);

        //setting ArrayAdapter on listView
        listView.setAdapter(arrayAdapter);
    }
}
