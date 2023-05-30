package com.example.notes10112934.ui.dashboard;

/*
    NIM     : 101119234
    NAMA    : ARHAM JUSNI INDRAWAN
    KELAS   : IF-4
 */

import android.database.Cursor;

public interface Interface {
    public Cursor read();
    public boolean create(Note note);
    public boolean update(Note note);
    public boolean delete(String id);
}
