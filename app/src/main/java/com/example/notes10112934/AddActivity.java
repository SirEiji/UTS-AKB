package com.example.notes10112934;

/*
    NIM     : 10119234
    NAMA    : ARHAM JUSNI INDRAWAN
    KELAS   : IF-4
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notes10112934.ui.dashboard.DatabaseHelper;
import com.example.notes10112934.ui.dashboard.Interface;
import com.example.notes10112934.ui.dashboard.Note;

import java.util.Date;

public class AddActivity extends AppCompatActivity {

    ImageButton btn;
    EditText editJudul, editKategori, editIsi;
    Button addBtn, delBtn;
    TextView addJudul;

    private Interface noteInterface;

    Note note = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);getSupportActionBar().hide();
        note = (Note) getIntent().getSerializableExtra("Note");
        btn = findViewById(R.id.back);
        editJudul = findViewById(R.id.title);
        editKategori = findViewById(R.id.category);
        editIsi = findViewById(R.id.txtIsi);
        addBtn = findViewById(R.id.btnAdd);
        delBtn = findViewById(R.id.btnDelete);
        addJudul = findViewById(R.id.txtAdd);
        noteInterface = new DatabaseHelper(this);

        btn.setOnClickListener(v -> {
            finish();
        });

        if (note == null){
            delBtn.setVisibility(View.GONE);

            addBtn.setOnClickListener(v -> {
                if (editJudul.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Judul Catatan perlu diisi !", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (editKategori.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Kategori Catatan perlu diisi !", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (editIsi.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Isi Catatan perlu diisi !", Toast.LENGTH_SHORT).show();
                }
                Date d = new Date();
                CharSequence date = DateFormat.format("EEEE, d MMM yyyy HH:mm", d.getTime());
                Note n = new Note(
                        d.getTime() + "",
                        editJudul.getText().toString(),
                        editKategori.getText().toString(),
                        editIsi.getText().toString() ,
                        "Catatan tertulis pada tanggal" + date + ""
                );

                noteInterface.create(n);
                finish();
                Toast.makeText(this, "Catatan telah ditambah", Toast.LENGTH_SHORT).show();
            });
        } else {
            editJudul.setText(note.getJudul());
            editKategori.setText(note.getKategori());
            editIsi.setText(note.getIsi());

            delBtn.setVisibility(View.VISIBLE);
            addJudul.setText("Edit Catatan");

            addBtn.setOnClickListener(v -> {
                if (editJudul.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Judul Catatan perlu diisi !", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (editKategori.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Kategori Catatan perlu diisi !", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (editIsi.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Isi Catatan perlu diisi !", Toast.LENGTH_SHORT).show();
                }

                Date d = new Date();
                CharSequence date = DateFormat.format("EEEE, d MMMM yyyy HH:mm",d.getTime());

                note.setJudul(editJudul.getText().toString());
                note.setKategori(editKategori.getText().toString());
                note.setIsi(editIsi.getText().toString());
                note.setTgl("di update pada tanggal " + date + "");
                noteInterface.update(note);
                finish();
                Toast.makeText(this, "Catatan telah diupdate", Toast.LENGTH_SHORT).show();
            });
        }

        delBtn.setOnClickListener(v-> {
            noteInterface.delete(note.getId());
            finish();
            Toast.makeText(this, "Catatan telah dihapus", Toast.LENGTH_SHORT).show();
        });
    }
}