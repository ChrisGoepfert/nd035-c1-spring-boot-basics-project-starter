package com.udacity.jwdnd.course1.cloudstorage.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteListService {

    private List<String> notes;

    public NoteListService() {
        this.notes = new ArrayList<>();
    }

    public void addNote(String note) {
        notes.add(note);
    }

    public List<String> getNotes() {
        return new ArrayList<>(this.notes);
    }
}