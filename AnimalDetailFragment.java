package com.bignerdranch.android.animals.controller;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.android.animals.R;
import com.bignerdranch.android.animals.model.GalleryItem;
import com.bumptech.glide.Glide;

public class AnimalDetailFragment extends Fragment {
    private static final String ARG_GALLERY_ITEM = 
            "AnimalDetailFragment.GALLERY_ITEM";

    ImageView mImageView;
    TextView mTextView;
    GalleryItem mGalleryItem;

    public static AnimalDetailFragment newInstance(GalleryItem galleryItem) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_GALLERY_ITEM, galleryItem);
        AnimalDetailFragment animalDetailFragment = new AnimalDetailFragment();
        animalDetailFragment.setArguments(args);
        return animalDetailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_animal_detail, container, false);

        mGalleryItem = (GalleryItem) getArguments().getSerializable(ARG_GALLERY_ITEM);

        mImageView = (ImageView) view
                .findViewById(R.id.fragment_animal_detail_image_view);
        mTextView = (TextView) view
                .findViewById(R.id.fragment_animal_detail_text_view);

        mTextView.setText(mGalleryItem.getCaption());
        Glide.with(getActivity())
                .load(mGalleryItem.getUrl())
                .fitCenter()
                .into(mImageView);

        return view;
    }
}
