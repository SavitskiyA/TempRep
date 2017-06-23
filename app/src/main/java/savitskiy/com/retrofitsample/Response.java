package savitskiy.com.retrofitsample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by Andrey on 22.06.2017.
 */


public class Response {

    @SerializedName("data")
    @Expose
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Response withData(Data data) {
        this.data = data;
        return this;
    }

}