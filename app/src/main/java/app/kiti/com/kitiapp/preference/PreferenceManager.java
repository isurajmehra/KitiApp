package app.kiti.com.kitiapp.preference;

import android.content.Context;
import android.content.SharedPreferences;

import app.kiti.com.kitiapp.main.KitiAppMain;

/**
 * Created by Ankit on 4/11/2018.
 */

public class PreferenceManager {

    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;
    private static PreferenceManager mInstance;
    private static final String PREF_NAME = "kiti_pref";

    public PreferenceManager() {

        preferences = KitiAppMain.getContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();

    }

    public static PreferenceManager getInstance() {
        if (mInstance == null) {
            mInstance = new PreferenceManager();
        }
        return mInstance;
    }

    public void clearPreferences() {
        editor.clear();
        editor.apply();
    }

    public void setLoggedIn(boolean loggedIn) {
        editor.putBoolean("isLoggedIn", loggedIn);
        editor.apply();
    }

    public boolean isLoggedIn() {
        return preferences.getBoolean("isLoggedIn", false);
    }

    public void setCurrentUserPhone(String userPhone) {
        editor.putString("userPhone", userPhone);
        editor.apply();
    }

    public String getUserPhone() {
        return preferences.getString("userPhone", "");
    }

    public void putBalance(String balance) {
        editor.putString("balance", balance);
        editor.apply();
    }

    public String getBalance() {
        return preferences.getString("balance", "");
    }

    public void setUsername(String username) {
        editor.putString("username", username);
        editor.apply();
    }

    public String getUsername() {
        return preferences.getString("username", "");
    }

    public void setBannerRate(int rate) {
        editor.putInt("banner_rate", rate);
        editor.apply();
    }

    public int getBannerRate() {
        return preferences.getInt("banner_rate", 0);
    }

    public void setInterstitalRate(int rate) {
        editor.putInt("interstital_rate", rate);
        editor.apply();
    }

    public int getInterstitalRate() {
        return preferences.getInt("interstital_rate", 0);
    }

    public static PreferenceManager getmInstance() {
        return mInstance;
    }

    public void setVideoRate(long rate) {
        editor.putLong("video_rate", rate);
        editor.apply();
    }

    public long getVideoRate() {
        return preferences.getLong("video_rate", 0);
    }

    public void saveUserToken(String token) {
        editor.putString("userToken", token);
        editor.apply();
    }

    public String getUserToken() {
        return preferences.getString("userToken", "");
    }

    public void tokenUpdatedToFirebase(boolean updated) {
        editor.putBoolean("tokenUpdated", updated);
        editor.apply();
    }

    public boolean isTokenUpdated() {
        return preferences.getBoolean("tokenUpdated", false);
    }

    public void saveTimeDifference(String diff) {
        editor.putString("time_diff",diff);
        editor.apply();
    }

    public String getTimeDiff(){
        return preferences.getString("time_diff","1"); //time is in min
    }

    public void saveMinAmountToRedeem(long min) {
        editor.putLong("min_to_redeem",min);
        editor.apply();
    }

    public long getMinToRedeem(){
        return preferences.getLong("min_to_redeem",100);
    }
}
