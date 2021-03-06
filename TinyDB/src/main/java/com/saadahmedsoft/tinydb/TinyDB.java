/*
 * Copyright 2022 Saad Ahmed
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.saadahmedsoft.tinydb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Set;

/**
 * Custom Shared Preferences class.
 * Made by Saad Ahmed on 16-May-2022.
 * This class has been made to simplify the built-in Shared Preferences class.
 * Get extra features like putting and getting Object, Uri and Bitmap.
 */

public class TinyDB {

    private final SharedPreferences preferences;
    private final SharedPreferences.Editor editor;

    private TinyDB(Context context) {
        preferences = context.getSharedPreferences("TinyDB", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    @SuppressLint("StaticFieldLeak")
    volatile private static TinyDB instance = null;

    /**
     * Context is required to get the instance of Shared Preferences class
     *
     * @param context SharedPreferences key
     * @return Returns instance of TinyDB class
     */

    public static TinyDB getInstance(Context context) {
        if (instance == null) {
            instance = new TinyDB(context);
        }
        return instance;
    }

    /**
     * Put String value into SharedPreferences with 'key' and apply()
     *
     * @param key   SharedPreferences key
     * @param value String value to be added
     * @return Returns singletone instance of TinyDB class
     */

    public TinyDB putString(String key, String value) {
        editor.putString(key, value);
        return instance;
    }

    /**
     * Get String value from SharedPreferences at 'key'. If key not found, return 'defaultValue'
     *
     * @param key          SharedPreferences key
     * @param defaultValue Default value if key find nothing
     * @return String value at 'key' or 'defaultValue' if key not found
     */

    public String getString(String key, String defaultValue) {
        return preferences.getString(key, defaultValue);
    }

    /**
     * Put Integer value into SharedPreferences with 'key' and apply()
     *
     * @param key   SharedPreferences key
     * @param value Integer value to be added
     * @return Returns singletone instance of TinyDB class
     */

    public TinyDB putInt(String key, int value) {
        editor.putInt(key, value);
        return instance;
    }

    /**
     * Get Integer value Set from SharedPreferences at 'key'. If key not found, return 'defaultValue'
     *
     * @param key          SharedPreferences key
     * @param defaultValue SharedPreferences key
     * @return Integer value at 'key' or 'defaultValue' if key not found
     */

    public int getInt(String key, int defaultValue) {
        return preferences.getInt(key, defaultValue);
    }

    /**
     * Put Long value into SharedPreferences with 'key' and apply()
     *
     * @param key   SharedPreferences key
     * @param value Long value to be added
     * @return Returns singletone instance of TinyDB class
     */

    public TinyDB putLong(String key, long value) {
        editor.putLong(key, value);
        return instance;
    }

    /**
     * Get Long value Set from SharedPreferences at 'key'. If key not found, return 'defaultValue'
     *
     * @param key          SharedPreferences key
     * @param defaultValue SharedPreferences key
     * @return Long value at 'key' or 'defaultValue' if key not found
     */

    public long getLong(String key, long defaultValue) {
        return preferences.getLong(key, defaultValue);
    }

    /**
     * Put Float value into SharedPreferences with 'key' and apply()
     *
     * @param key   SharedPreferences key
     * @param value Float value to be added
     * @return Returns singletone instance of TinyDB class
     */

    public TinyDB putFloat(String key, float value) {
        editor.putFloat(key, value);
        return instance;
    }

    /**
     * Get Float value Set from SharedPreferences at 'key'. If key not found, return 'defaultValue'
     *
     * @param key          SharedPreferences key
     * @param defaultValue SharedPreferences key
     * @return Float value at 'key' or 'defaultValue' if key not found
     */

    public float getFloat(String key, float defaultValue) {
        return preferences.getFloat(key, defaultValue);
    }

    /**
     * Put Boolean value into SharedPreferences with 'key' and apply()
     *
     * @param key   SharedPreferences key
     * @param value Boolean value to be added
     * @return Returns singletone instance of TinyDB class
     */

    public TinyDB putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        return instance;
    }

    /**
     * Get Boolean value Set from SharedPreferences at 'key'. If key not found, return 'defaultValue'
     *
     * @param key          SharedPreferences key
     * @param defaultValue SharedPreferences key
     * @return Boolean value at 'key' or 'defaultValue' if key not found
     */

    public boolean getBoolean(String key, boolean defaultValue) {
        return preferences.getBoolean(key, defaultValue);
    }

    /**
     * Put String Set value into SharedPreferences with 'key' and apply()
     *
     * @param key   SharedPreferences key
     * @param value String Set value to be added
     * @return Returns singletone instance of TinyDB class
     */

    public TinyDB putStringSet(String key, Set<String> value) {
        editor.putStringSet(key, value);
        return instance;
    }

    /**
     * Get String Set from SharedPreferences at 'key'. If key not found, return 'defaultValue'
     *
     * @param key          SharedPreferences key
     * @param defaultValue SharedPreferences key
     * @return Set of String value at 'key' or 'defaultValue' if key not found
     */

    public Set<String> getStringSet(String key, Set<String> defaultValue) {
        return preferences.getStringSet(key, defaultValue);
    }

    /**
     * Put Object value into SharedPreferences with 'key' and apply()
     *
     * @param key    SharedPreferences key
     * @param object Object value to be added
     * @return Returns singletone instance of TinyDB class
     */

    public TinyDB putObject(String key, Object object) {
        Gson gson = new Gson();
        editor.putString(key, gson.toJson(object));
        return instance;
    }

    /**
     * Get Object from SharedPreferences at 'key'. If key not found, return 'blank'
     *
     * @param key SharedPreferences key
     * @param objectType Object of a class
     * @param <T> Object Class name
     * @return Object value at 'key' or 'blank' if key not found
     */

    @SuppressWarnings("unchecked")
    public <T> T getObject(String key, Class<?> objectType) {
        Gson gson = new Gson();
        return (T) gson.fromJson(preferences.getString(key, ""), objectType);
    }

    /**
     * Put Uri value into SharedPreferences with 'key' and apply()
     *
     * @param key SharedPreferences key
     * @param uri Uri value to be added
     * @return Returns singletone instance of TinyDB class
     */

    public TinyDB putImageUri(String key, Uri uri) {
        editor.putString(key, uri.toString());
        return instance;
    }

    /**
     * Get ImageUri from SharedPreferences at 'key'. If key not found, return 'blank'
     *
     * @param key SharedPreferences key
     * @return Uri value at 'key' or 'blank' if key not found
     */

    public Uri getImageUri(String key) {
        return Uri.parse(preferences.getString(key, ""));
    }

    /**
     * Put Bitmap value into SharedPreferences with 'key' and apply()
     *
     * @param key    SharedPreferences key
     * @param bitmap Bitmap value to be added
     * @return Returns singletone instance of TinyDB class
     */

    public TinyDB putImageBitmap(String key, Bitmap bitmap) {
        editor.putString(key, bitmapToString(bitmap));
        return instance;
    }

    /**
     * Get ImageBitmap from SharedPreferences at 'key'. If key not found, return 'blank'
     *
     * @param key SharedPreferences key
     * @return Bitmap value at 'key' or 'blank' if key not found
     */

    public Bitmap getImageBitmap(String key) {
        return stringToBitmap(preferences.getString(key, ""));
    }

    /**
     * apply() function apllies the shared preferences editor
     */

    public void apply() {
        editor.apply();
    }

    /**
     * Function bitmapToString returns image path of bitmap
     *
     * @param bitmap Bitmap to get path
     * @return String path of Bitmap
     */

    private String bitmapToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        return Base64.encodeToString(b, Base64.DEFAULT);
    }

    /**
     * Function stringToBitmap returns bitmap of image path
     *
     * @param encodedString String path to get Bitmap
     * @return bitmap of String path
     */

    private Bitmap stringToBitmap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            return BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
