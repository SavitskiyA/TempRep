package savitskiy.com.retrofitsample;

import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Andrey on 21.06.2017.
 */

public interface ILink {
    @FormUrlEncoded
    @POST("/language/translate/v2")
    Call<Object> translate(@FieldMap Map<String, String> map);
}
