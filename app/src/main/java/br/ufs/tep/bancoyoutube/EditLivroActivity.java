package br.ufs.tep.bancoyoutube;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class EditLivroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_livro);

        final Realm realm = Realm.getDefaultInstance();

        Intent intent = getIntent();
        final int id = intent.getIntExtra("ID", 0);
        final Livro livro = realm.where(Livro.class).equalTo("id", id).findFirst();

        final EditText nome = (EditText) findViewById(R.id.edNome);
        final EditText autor = (EditText) findViewById(R.id.edAutor);
        final EditText ano = (EditText) findViewById(R.id.edAno);
        nome.setText(livro.getTitulo());
        autor.setText(livro.getAutor());
        ano.setText(String.valueOf(livro.getAno()));

        Button alterar = (Button) findViewById(R.id.btnEditLivro);
        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm.beginTransaction();
                livro.setTitulo(nome.getText().toString());
                livro.setAutor(autor.getText().toString());
                livro.setAno(Integer.parseInt(ano.getText().toString()));
                realm.copyToRealm(livro);
                realm.commitTransaction();
                Toast.makeText(getBaseContext(), "Livro alterado com sucesso.", Toast.LENGTH_SHORT).show();
            }
        });

        Button remover = (Button) findViewById(R.id.btnDeleteLivro);
        remover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm.beginTransaction();
                livro.deleteFromRealm();
                realm.commitTransaction();
                Toast.makeText(getBaseContext(), "Livro removido com sucesso.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
