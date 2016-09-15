package com.yikai.bitsandpizzas;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View rootView = inflater.inflate(R.layout.fragment_top, container, false);

        View.OnClickListener a = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == getActivity().findViewById(R.id.button1)) {
                    ((MainActivity) getActivity()).forFragmentbutton(2);
                } else if (v == getActivity().findViewById(R.id.button2)) {
                    ((MainActivity) getActivity()).forFragmentbutton(1);
                } else if (v == getActivity().findViewById(R.id.button3)) {
                    ((MainActivity) getActivity()).forFragmentbutton(3);
                }else if (v == getActivity().findViewById(R.id.button4)){
                    ((MainActivity) getActivity()).forFragmentbutton(4);
                }
            }
        };

        rootView.findViewById(R.id.button1).setOnClickListener(a);
        rootView.findViewById(R.id.button2).setOnClickListener(a);
        rootView.findViewById(R.id.button3).setOnClickListener(a);
        rootView.findViewById(R.id.button4).setOnClickListener(a);

        return rootView;

    }


}