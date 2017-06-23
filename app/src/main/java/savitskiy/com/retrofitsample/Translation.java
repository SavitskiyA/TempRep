package savitskiy.com.retrofitsample;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Andrey on 22.06.2017.
 */



public class Translation {

    @SerializedName("translatedText")
    @Expose
    private String translatedText;

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    public Translation withTranslatedText(String translatedText) {
        this.translatedText = translatedText;
        return this;
    }

}