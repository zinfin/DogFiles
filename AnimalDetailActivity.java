package com.bignerdranch.android.animals.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bignerdranch.android.animals.R;
import com.bignerdranch.android.animals.model.GalleryItem;

public class AnimalDetailActivity extends AppCompatActivity {
    private static final String EXTRA_GALLERY_ITEM = 
            "AnimalDetailActivity.GALLERY_ITEM";

    public static Intent newIntent(Context context, GalleryItem galleryItem) {
        Intent intent = new Intent(context, AnimalDetailActivity.class);
        intent.putExtra(EXTRA_GALLERY_ITEM, galleryItem);
        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        GalleryItem galleryItem = (GalleryItem) getIntent()
                .getSerializableExtra(EXTRA_GALLERY_ITEM);

        if (savedInstanceState == null) {
            AnimalDetailFragment fragment = 
                    AnimalDetailFragment.newInstance(galleryItem);
            getFragmentManager().beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }
    }
}
