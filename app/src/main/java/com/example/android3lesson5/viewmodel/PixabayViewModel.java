package com.example.android3lesson5.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android3lesson5.local.PreferencesHelper;
import com.example.android3lesson5.local.RoomHelper;
import com.example.android3lesson5.local.room.models.CategoryModel;
import com.example.android3lesson5.local.room.models.WordModel;
import com.example.android3lesson5.models.network_model.Hits;
import com.example.android3lesson5.models.network_model.RapidHits;
import com.example.android3lesson5.repository.PixabayRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class PixabayViewModel extends ViewModel {
    public MutableLiveData<List<Hits>> imageList = new MutableLiveData<>();
    public MutableLiveData<List<RapidHits>> translationList = new MutableLiveData<>();
    public LiveData<List<CategoryModel>> categoryList = new MutableLiveData<>();
    public LiveData<List<WordModel>> wordsList = new MutableLiveData<>();
    PixabayRepository repository;
    PreferencesHelper preferencesHelper;
    RoomHelper roomHelper;

    @Inject
    public PixabayViewModel(PixabayRepository repository, PreferencesHelper preferencesHelper, RoomHelper roomHelper) {
        this.repository = repository;
        this.preferencesHelper = preferencesHelper;
        this.roomHelper = roomHelper;
    }


    public MutableLiveData<List<Hits>> getImages(String word) {
        imageList = repository.getImages(word);
        return imageList;
    }

    public MutableLiveData<List<RapidHits>> getTranslation(String word) {
        translationList = repository.getTranslation(word);
        return translationList;

    }

    public boolean getBoolean() {
        return preferencesHelper.getBoolean();
    }

    public void setBoolean(boolean isShown) {
        preferencesHelper.setBoolean(isShown);
    }

    public void insertCategory(CategoryModel categoryModel) {
        roomHelper.insertCategory(categoryModel);
    }

    public LiveData<List<CategoryModel>> getCategories() {
        return categoryList = repository.getCategories();
    }

    public void insertWord(WordModel wordModel) {
        roomHelper.insertWord(wordModel);

    }

    public LiveData<List<WordModel>> getWords(String userCategory) {
        return wordsList = repository.getWords(userCategory);
    }
}




