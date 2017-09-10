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

import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.Cipher;

/**
 * Created by jaisimhas on 3/7/2017.
 */

public class RSAEncryption {

    public static String ALGORITHM ="RSA";
    private Cipher cipher;
    private Key privateKey;
    private Key publicKey;

    public RSAEncryption() {
        try {
            cipher = Cipher.getInstance(ALGORITHM);
            KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITHM);
            generator.initialize(1024);
            KeyPair keyPair = generator.genKeyPair();
            privateKey = keyPair.getPrivate();
            publicKey = keyPair.getPublic();
        } catch (GeneralSecurityException gse) {
        }
    }
        public Key getPrivateKey()
        {
         return privateKey;
        }

        public Key getPublicKey()
        {
            return publicKey;
        }

        public byte [ ] getPrivateKeyBytes()
        {
            return privateKey.getEncoded();
        }

        public byte [ ] getPublicKeyBytes()
        {
            return publicKey.getEncoded();
        }


        public String crypt(int opMode, String message, Key key)
        {
            try{
                cipher.init(opMode,key);
                byte[ ]  messageBytes = message.getBytes("ISO-8859-1");
                byte [ ] encryptedBytes = cipher.doFinal(messageBytes);
                String encrypted = new String (encryptedBytes, "ISO-8859-1");
                return encrypted;
            }
            catch (Exception e)
            {
                return null;
            }

        }
}




