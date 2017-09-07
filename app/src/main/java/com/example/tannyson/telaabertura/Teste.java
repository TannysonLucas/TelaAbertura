package com.example.tannyson.telaabertura;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

/**
 * Created by Tannyson on 07/09/2017.
 */

public class Teste extends Activity
{
    //Usa-se esse comando apra chamar a tela splashscreen
    @Override
    protected void onCreate (Bundle savedIntanceState)
    {
     super.onCreate (savedIntanceState);
     setContentView(R.layout.tela_splashscreen);

        // Usa-se para chamar a tela de abertura por um curto periodo de tempo e logo em seguinda chamar a tela principal
     Thread timerThread = new Thread() {
         @RequiresApi(api = Build.VERSION_CODES.KITKAT)
         public void run()
         { try {
             sleep(3000);

         } catch(InterruptedException e) {
               e.printStackTrace();
         } finally {
             Intent bloqueio = new Intent(Teste.this, TelaAbertura.class);
             startActivity(bloqueio);
         }

         }
     };
     //Começar a função de abertura
     timerThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
