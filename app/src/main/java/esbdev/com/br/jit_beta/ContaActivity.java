package esbdev.com.br.jit_beta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import esbdev.com.br.jit_beta.conta.Update_Conta;
import esbdev.com.br.jit_beta.model.Conta;

public class ContaActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtNome, edtEmail, edtCelular, edtSenha;

    Button btnGravar, btnCancelar;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta);

        edtNome = (EditText) findViewById(R.id.nome_id);
        edtEmail = (EditText) findViewById(R.id.email_id);
        edtCelular = (EditText) findViewById(R.id.celular_id);
        edtSenha = (EditText) findViewById(R.id.senha_id);

        btnGravar = (Button) findViewById(R.id.bt_conta_gravar_id);
        btnCancelar = (Button) findViewById(R.id.bt_conta_cancelar_id);

        btnGravar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.bt_conta_gravar_id) {
            Conta c = new Conta();

            c.setNome( edtNome.getText().toString());
            c.setEmail(edtEmail.getText().toString());
            c.setCelular(edtCelular.getText().toString());
            c.setSenha(edtSenha.getText().toString());

            Update_Conta uc = new Update_Conta(getApplicationContext());

            if(uc.insertConta(c)) {
                Toast.makeText(this, "Bem vindo ao mundo JiT", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this, "Erro ao criar a conta.", Toast.LENGTH_LONG).show();
            };

        }else if(view.getId() == R.id.bt_conta_cancelar_id){

        }



    }
}
