package org.techtown.registerlogin;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.BundleCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.chip.Chip;

import org.techtown.registerlogin.R;

import java.util.ArrayList;

public class Menu_closet extends Fragment {

    private View view;
    private ViewPager viewPager;
    private static final int MY_CAMERA_REQUEST_CODE = 100;
    TextView textView;
    private Chip chipSpring, chipSummer, chipFall, chipWinter;

    private Button btnApply;
    private ArrayList<String> selectedChipData;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.menu_closet, container, false);

        Button btn_add = (Button) view.findViewById(R.id.add);
        final Button btn_allouter = (Button) view.findViewById(R.id.allouter);
        Button btn_alltop = (Button) view.findViewById(R.id.alltop);
        Button btn_allpant = (Button) view.findViewById(R.id.allpant);
//      final ImageView image = (ImageView) view.findViewById(R.id.imageView);


        ViewPager viewPager = (ViewPager) view.findViewById(R.id.myViewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity());
        viewPager.setAdapter(viewPagerAdapter);

        ViewPager viewPager2 = (ViewPager) view.findViewById(R.id.myViewPager2);
        ViewPagerAdapter2 viewPagerAdapter2 = new ViewPagerAdapter2(getActivity());
        viewPager2.setAdapter(viewPagerAdapter2);

        ViewPager viewPager3 = (ViewPager) view.findViewById(R.id.myViewPager3);
        ViewPagerAdapter3 viewPagerAdapter3 = new ViewPagerAdapter3(getActivity());
        viewPager3.setAdapter(viewPagerAdapter3);


/*
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //setContentView(R.layout.menu_closet);

            chipSpring = view.findViewById(R.id.chipSpring);
            chipSummer = view.findViewById(R.id.chipSummer);
            chipFall = view.findViewById(R.id.chipFall);
            chipWinter = view.findViewById(R.id.chipWinter);

            selectedChipData = new ArrayList<>();
            CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        selectedChipData.add(buttonView.getText().toString());
                    } else {
                        selectedChipData.remove(buttonView.getText().toString());
                    }
                }
            };


            chipSpring.setOnCheckedChangeListener(checkedChangeListener);
            chipSummer.setOnCheckedChangeListener(checkedChangeListener);
            chipFall.setOnCheckedChangeListener(checkedChangeListener);
            chipWinter.setOnCheckedChangeListener(checkedChangeListener);
        }

*/

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int permissionCheck=ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.CAMERA);
                if(permissionCheck==PackageManager.PERMISSION_DENIED){
                    ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CAMERA},0);

                }else{
                    Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(i, 1);
                }
            }

        });

        btn_allouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Menu_allouter.class);
                startActivity(intent);
            }
        });
        btn_alltop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Menu_alltop.class);
                startActivity(intent);
            }
        });
        btn_allpant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Menu_allpant.class);
                startActivity(intent);
            }
        });

        return view;
    }
}



