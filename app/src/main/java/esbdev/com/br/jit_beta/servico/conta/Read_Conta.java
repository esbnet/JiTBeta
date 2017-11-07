package esbdev.com.br.jit_beta.servico.conta;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import esbdev.com.br.jit_beta.model.Conta;

/**
 * Created by edmilson on 05/11/2017.
 */


public class Read_Conta extends SQLiteOpenHelper {

    //Definições do banco de dados
    private static final String NOME_DB = "jit_db";
    private static final int VERSAO_DB = 1;

    //Caminho do banco
    private static final String CAMINHO_BANCO = "/data/user/0/esbdev.com.br.jit_beta/database/jit_db";

    //Definições de tabelas
    private static final String TABELA_CONTA = "conta";
    private static final String TABELA_ESTABELECIMENTO = "estabelecimento";
    private static final String TABELA_AGENDAMENTO = "agendamento";
    private static final String TABELA_SERVICO = "servico";
    private static final String TABELA_CATEGORIA_SERVICO = "servico";

    private Context mContext;
    private SQLiteDatabase db;

    public Read_Conta(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
        this.mContext = context;

        db = getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void openDB() {
        if(!db.isOpen()){
            db = mContext.openOrCreateDatabase(CAMINHO_BANCO,SQLiteDatabase.OPEN_READWRITE,null);
        }
    }

    public ArrayList<Conta> getConta() {
        openDB();
        ArrayList<Conta> contas = new ArrayList<>();
        String getContas = "SELECT * FROM " + TABELA_CONTA ;

        try{
            Cursor c = db.rawQuery(getContas,null);

            if(c.moveToFirst()){
                do {
                    Conta conta = new Conta();
                    conta.setNome(c.getString(0));
                    conta.setEmail(c.getString(1));
                    conta.setCelular(c.getString(2));
                    conta.setSenha(c.getString(3));
                    contas.add(conta);
                }while (c.moveToNext());
                c.close();
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            db.close();
        }
        return contas;
    }
}
