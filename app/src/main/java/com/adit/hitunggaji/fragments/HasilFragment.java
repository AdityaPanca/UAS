package com.adit.hitunggaji.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.adit.hitunggaji.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HasilFragment extends Fragment {


    private OnFragmentInteractionListener mListener;
    String informasi;

    public void setInformasi(String informasi){

        this.informasi = informasi;
    }

    public HasilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hasil, container, false);
        TextView informasiText = view.findViewById(R.id.textHasil);
        informasiText.setText(informasi);

        Button hitungLagi = view.findViewById(R.id.buttonHitungLagi);
        hitungLagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null){
                    mListener.buttonHitungLagi("Lembur");
                }
            }
        });
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void buttonHitungLagi(String tag);
    }
}
