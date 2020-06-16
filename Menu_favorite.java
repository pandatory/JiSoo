package org.techtown.registerlogin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Menu_favorite extends Fragment {

    private View view;
    private int[] imageIDs = new int[] {
            R.drawable.fav,
            R.drawable.fav,
            R.drawable.fav,
            R.drawable.fav,
            R.drawable.fav,
            R.drawable.fav,
            R.drawable.fav,
            R.drawable.fav,
            R.drawable.fav,
            R.drawable.fav,
            R.drawable.fav,
            R.drawable.fav,
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.menu_favorite,container,false);

        GridView gridViewImages = (GridView)view.findViewById(R.id.gridViewImages);
        ImageGridAdapter imageGridAdapter = new ImageGridAdapter(getActivity(), imageIDs);
        gridViewImages.setAdapter(imageGridAdapter);

        return view;
    }
}



