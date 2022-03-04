package com.example.android3lesson5.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.android3lesson5.databinding.WordsHolderBinding;
import com.example.android3lesson5.local.room.models.WordModel;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordHolder> {
    List<WordModel> list = new ArrayList<>();


    public WordAdapter(List<WordModel> list) {
        this.list = list;

    }

    @NonNull
    @Override
    public WordHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WordHolder(WordsHolderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WordHolder holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class WordHolder extends RecyclerView.ViewHolder {
        WordsHolderBinding binding;


        public WordHolder(@NonNull WordsHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(WordModel wordModel) {
            binding.tvWords.setText(wordModel.getWord());
            binding.imgWords.setImageResource(wordModel.getImage());

        }
    }
}
