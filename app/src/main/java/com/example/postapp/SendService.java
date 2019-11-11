package com.example.postapp;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendService extends AsyncTask<String, Void, String> {


    @Override
    protected String doInBackground(String... strings) {
        String data = "";
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(strings[0]).openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            DataOutputStream enviar = new DataOutputStream(connection.getOutputStream());
            enviar.writeBytes(strings[1]);
            enviar.flush();
            enviar.close();

            InputStream receber = connection.getInputStream();
            InputStreamReader receberLeitura = new InputStreamReader(receber);

            int tamanhoBytes = receberLeitura.read();
            while (tamanhoBytes != -1) {
                char leitura = (char) (tamanhoBytes);
                tamanhoBytes = receberLeitura.read();
                data += leitura;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null)
                connection.disconnect();
        }

        return data;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
