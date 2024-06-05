package tw.nekomimi.nekogram;

import android.content.Context;
import android.content.SharedPreferences;

import org.telegram.messenger.ApplicationLoader;

import org.uzbek.messanger.NaConfig;

public class DialogConfig {
    private static final SharedPreferences preferences = ApplicationLoader.applicationContext.getSharedPreferences("nekodialogconfig", Context.MODE_PRIVATE);

    public static boolean isAutoTranslateEnable(long dialog_id, long topicId) {
        return preferences.getBoolean("autoTranslate_" + dialog_id + (topicId != 0 ? "_" + topicId : ""), NaConfig.INSTANCE.getAutoTranslate().Bool());
    }

    public static boolean hasAutoTranslateConfig(long dialog_id, long topicId) {
        return preferences.contains("autoTranslate_" + dialog_id + (topicId != 0 ? "_" + topicId : ""));
    }

    public static void setAutoTranslateEnable(long dialog_id, long topicId, boolean enable) {
        preferences.edit().putBoolean("autoTranslate_" + dialog_id + (topicId != 0 ? "_" + topicId : ""), enable).apply();
    }

    public static void removeAutoTranslateConfig(long dialog_id, long topicId) {
        preferences.edit().remove("autoTranslate_" + dialog_id + (topicId != 0 ? "_" + topicId : "")).apply();
    }
}
