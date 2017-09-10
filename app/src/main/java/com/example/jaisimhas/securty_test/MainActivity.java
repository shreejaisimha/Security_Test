/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jaisimhas.securty_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class MainActivity extends AppCompatActivity {

    private static final String STEST = "MainActivity";
    private AESEncryption aes;
    private RSAEncryption rsa;
    private EditText etOriginal;
    private TextView tvEncrypted;
    private TextView tvDecrypted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aes = new AESEncryption();
        rsa = new RSAEncryption();
        setContentView(R.layout.activity_main);
        etOriginal = (EditText)findViewById(R.id.string_original);
        tvEncrypted = (TextView)findViewById(R.id.string_encrypted);
        tvDecrypted = (TextView)findViewById(R.id.string_decrypted);


//        String original = "Encryption test";
//        Log.w (STEST,"original" + original);
//        String encrypted = aes.crypt(Cipher.ENCRYPT_MODE,original,aes.getKey());
//        Log.w(STEST,"encrypted" + encrypted);
//        String decrypted = aes.crypt(Cipher.DECRYPT_MODE,encrypted,aes.getKey());
//        Log.w(STEST,"decrypted" + decrypted);

//        byte[]  keyBytes = aes.getKeyBytes();
 //       String keyString = Arrays.toString(keyBytes);
//        Log.w(STEST,"original key:" + keyBytes + ":" + keyString);

//        SecretKey reconstructKey = new SecretKeySpec(keyBytes,"AES");
 //       byte[] bytesFromReconstructedKey = reconstructKey.getEncoded();
 //       String stringFromReconstructedKey = Arrays.toString(bytesFromReconstructedKey);
  //      Log.w(STEST,"recontructed key" + bytesFromReconstructedKey + " : " + stringFromReconstructedKey);
    }


    /*Below is triggered by the onClick event trigger*/
    public void encryptAndDecryptAES(View v)
    {
        EditText et = (EditText) findViewById(R.id.string_original);
        String original = et.getText().toString();
        String encrypted = aes.crypt(Cipher.ENCRYPT_MODE, original, aes.getKey());
        TextView tvEncrypted = (TextView) findViewById(R.id.string_encrypted);
        tvEncrypted.setText(encrypted);
        TextView tvDecrypted = (TextView)findViewById(R.id.string_decrypted);
        String decrypted = aes.crypt(Cipher.DECRYPT_MODE, encrypted, aes.getKey());
        tvDecrypted.setText(decrypted);

    }

    /*Below is triggered by the onClick event trigger*/
    public void encryptAndDecryptRSA1(View v)
    {
        String original = etOriginal.getText().toString();
        String encrypted = rsa.crypt(Cipher.ENCRYPT_MODE, original, rsa.getPrivateKey());
        TextView tvEncrypted = (TextView) findViewById(R.id.string_encrypted);
        tvEncrypted.setText(encrypted);
        TextView tvDecrypted = (TextView)findViewById(R.id.string_decrypted);
        String decrypted = rsa.crypt(Cipher.DECRYPT_MODE, encrypted, rsa.getPublicKey());
        tvDecrypted.setText(decrypted);
    }

    /*Below is triggered by the onClick event trigger*/
    public void encryptAndDecryptRSA2(View v)
    {
        String original = etOriginal.getText().toString();
        String encrypted = rsa.crypt(Cipher.ENCRYPT_MODE, original, rsa.getPublicKey());
        TextView tvEncrypted = (TextView) findViewById(R.id.string_encrypted);
        tvEncrypted.setText(encrypted);
        TextView tvDecrypted = (TextView)findViewById(R.id.string_decrypted);
        String decrypted = rsa.crypt(Cipher.DECRYPT_MODE, encrypted, rsa.getPrivateKey());
        tvDecrypted.setText(decrypted);
    }



}
