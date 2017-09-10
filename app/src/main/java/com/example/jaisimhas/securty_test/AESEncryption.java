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

import android.util.Log;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * Created by jaisimhas on 2/18/2017.
 */

public class AESEncryption {
    public static String ALGORITHM = "AES";
    private SecretKey secretKey;
    private Cipher cipher;
    private SecureRandom rand;

        /*Constructor for the class*/
    public AESEncryption() {
        try {
            cipher = Cipher.getInstance(ALGORITHM); /*get the instance*/
            rand = new SecureRandom(); /*get the random number*/
            KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM); /*generate the instance to key*/
            keyGen.init(256); /*initialize the key*/
            secretKey = keyGen.generateKey(); /*generate key for encryption*/
        } catch (GeneralSecurityException gse) {
            Log.d("AES", "Error");
        }

    }

    public String crypt (int opMode, String message, SecretKey key)
    {

        try{
            cipher.init(opMode, key, rand);
            byte[] messageBytes = message.getBytes("ISO-8859-1"); //convert to ISO standard
            byte[] encodedBytes = cipher.doFinal(messageBytes); //transform bytes
            String encoded = new String(encodedBytes, "ISO-8859-1"); //conver to ISO standard
            return encoded;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public SecretKey getKey()
    {
        return secretKey;
    }

    public byte[] getKeyBytes()
    {
        return secretKey.getEncoded();
    }
}

