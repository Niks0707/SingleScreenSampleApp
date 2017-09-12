package idea.engineering.com.singlescreensampleapp.data_layer.requests;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseRequest<T> {

    public static final String HOST = "http://www.mocky.io/v2/";
    private static final int CONNECT_TIMEOUT = 35;
    private static final int WRITE_TIMEOUT = 35;
    private static final int READ_TIMEOUT = 80;

    public List<T> objects = new ArrayList<>();

    public BaseRequest() {
        setupService();
    }

    protected Retrofit getRetrofit() {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
//        JavaNetCookieJar jncj = new JavaNetCookieJar(cookieManager);
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
//                .addInterceptor(interceptor)
//                .cookieJar(jncj)
                .build();

        return new Retrofit.Builder()
                .baseUrl(HOST)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public abstract void setupService();

    public interface CompletionHandler<T> {
        void completionHandler(T objects);

        void completionHandlerWithError(String error);
    }
}
