package com.chenmo.photo.util;

import java.io.InputStream;

import org.json.JSONException;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.rs.PutPolicy;
import com.qiniu.api.rs.RSClient;


/**
 *  使用七牛云存储
 *
 */

public class FileUtils {

    private  static final String ACCESS_KEY = "g6M3x4__a9ipDJ2QHvcHlFF5EKtPGTSqeQhMMKGB";
    private static final String SECRET_KEY = "5UwYQ4YLVaael13jbmZM1IP1PldybkW83Y8soZ2I";
    private static final String BUCKET_NAME = "photo";


    public static void upload(InputStream reader, String fileName) {

        String uptoken;
        try {
            Mac mac = new Mac(ACCESS_KEY, SECRET_KEY);
            PutPolicy putPolicy = new PutPolicy(BUCKET_NAME);
            uptoken = putPolicy.token(mac);
            IoApi.Put(uptoken, fileName, reader, null);
        } catch (AuthException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void delete( String key) {
        Mac mac = new Mac(ACCESS_KEY, SECRET_KEY);
        RSClient client = new RSClient(mac);
        client.delete(BUCKET_NAME, key);
    }

}
