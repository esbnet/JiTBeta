package esbdev.com.br.jit_beta.categoria_servico.conta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import esbdev.com.br.jit_beta.model.Conta;

/**
 * Created by edmilson on 05/11/2017.
 */


public class Delete_Conta extends SQLiteOpenHelper {

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

    public Delete_Conta(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
        this.mContext = context;
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean deleteTable() {
        openDB();
        String deleteTabke = "DROP TABLE IF EXISTS " + TABELA_CONTA;

        try {
            db.execSQL(deleteTabke);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            db.close();
        }
    }

    public boolean deleteConta(Conta c) {
        openDB();

        String deleteConta = "nome = '" + c.getNome() +"'";
        try {
            db.delete(TABELA_CONTA, deleteConta,null);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            db.close();
        }
    }



    public void openDB() {
        if(!db.isOpen()){
            db = mContext.openOrCreateDatabase(CAMINHO_BANCO,SQLiteDatabase.OPEN_READWRITE,null);
        }
    }


}
