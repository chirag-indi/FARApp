package com.yikai.bitsandpizzas;


import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class AgentsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        String[] agentNames = new String[agents.agent.length];
        for (int i = 0; i < agentNames.length; i++) {
            agentNames[i] = agents.agent[i].getName();
        }

        int[] agentsImages = new int[agents.agent.length];
        for (int i = 0; i < agentsImages.length; i++) {
            agentsImages[i] = agents.agent[i].getImageId();
        }

        String[] agentIntro = new String[agents.agent.length];
        for (int i = 0; i < agentIntro.length; i++) {
            agentIntro[i] = agents.agent[i].getIntro();
        }

        final String[] agentPhone = new String[agents.agent.length];
        for (int i = 0; i < agentPhone.length; i++) {
            agentPhone[i] = agents.agent[i].getPhoneNumber();
        }


        RecyclerView agentsRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_agents, container, false);


        AgentsAdapter adapter = new AgentsAdapter(agentNames, agentsImages, agentIntro, agentPhone);
        agentsRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        agentsRecycler.setLayoutManager(layoutManager);


        adapter.setListener(new AgentsAdapter.Listener2() {
            public void onClick(int position) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(agentPhone[position]));
                startActivity(callIntent);
            }

        });

        return agentsRecycler;
    }

    @Override
    public void onStart() {
        super.onStart();
        Button buttons = (Button) this.getActivity().findViewById(R.id.phone_agents);
    }

}
