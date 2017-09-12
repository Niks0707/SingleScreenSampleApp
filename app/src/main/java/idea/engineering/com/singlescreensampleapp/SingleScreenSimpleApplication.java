package idea.engineering.com.singlescreensampleapp;

import android.app.Application;
import android.support.text.emoji.EmojiCompat;
import android.support.text.emoji.FontRequestEmojiCompatConfig;
import android.support.v4.provider.FontRequest;

public class SingleScreenSimpleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        final FontRequest fontRequest = new FontRequest(
                "com.google.android.gms.fonts",
                "com.google.android.gms",
                "Noto Color Emoji Compat",
                R.array.com_google_android_gms_fonts_certs);
        EmojiCompat.Config config = new FontRequestEmojiCompatConfig(getApplicationContext(), fontRequest)
                .setReplaceAll(true);
        EmojiCompat.init(config);
    }
}
