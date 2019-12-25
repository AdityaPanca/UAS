package com.adit.hitunggaji;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.adit.hitunggaji.fragments.HasilFragment;
import com.adit.hitunggaji.fragments.HitungGajiFragment;
import com.adit.hitunggaji.fragments.MenuFragment;

public class MainActivity extends AppCompatActivity implements
        MenuFragment.OnFragmentInteractionListener,
        HitungGajiFragment.OnFragmentInteractionListener,
        HasilFragment.OnFragmentInteractionListener {

    private MenuFragment menuFragment;
    private HitungGajiFragment hitungGajiFragment;
    private HasilFragment hasilFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuFragment = new MenuFragment();
        hasilFragment = new HasilFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, menuFragment)
                .commit();
        hitungGajiFragment = new HitungGajiFragment();
    }

    @Override
    public void buttonHitungLagi(String tag) {
        if (hitungGajiFragment == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HitungGajiFragment(),"Lembur")
                    .commit();
        }
        else {

//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fragment_container, new , "BMI_FRAGMENT")
//                    .commit();
        }

    }



    @Override
    public void onCalculateButtonGajiClicked(float index) {
        hasilFragment.setInformasi(String.format("Gaji anda adalah %.1f",index));
        hitungGajiFragment = (HitungGajiFragment) getSupportFragmentManager().findFragmentByTag("Lembur");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,hasilFragment)
//				.addToBackStack(null)
                .commit();

    }


    @Override
    public void onFragmentGajiKaryawanCliked() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, hitungGajiFragment)
                .commit();

    }
}
