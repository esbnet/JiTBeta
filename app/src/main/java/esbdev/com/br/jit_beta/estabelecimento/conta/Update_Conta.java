package esbdev.com.br.jit_beta.estabelecimento.conta;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import esbdev.com.br.jit_beta.model.Conta;

/**
 * Created by edmilson on 05/11/2017.
 */


public class Update_Conta extends SQLiteOpenHelper {

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

    public Update_Conta(Context context) {
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

    public boolean insertConta (Conta conta) {
        openDB();

        try {
            ContentValues cv = new ContentValues();
            cv.put("nome",conta.getNome());
            cv.put("email",conta.getEmail());
            cv.put("celular",conta.getCelular());
            cv.put("senha",conta.getSenha());
            db.insert(TABELA_CONTA,null,cv);

            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            db.close();
        }
    }

    public boolean updateConta (Conta conta) {
        openDB();

        try {
            String where = "nome = '"+conta.getNome()+"'";
            ContentValues cv = new ContentValues();
            cv.put("nome",conta.getNome());
            cv.put("email",conta.getEmail());
            cv.put("celular",conta.getCelular());
            cv.put("senha",conta.getSenha());

            db.update(TABELA_CONTA,cv,where,null);

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
