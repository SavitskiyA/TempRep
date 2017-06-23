package savitskiy.com.retrofitsample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by Andrey on 22.06.2017.
 */

import java.util.List;


public class Data {

    @SerializedName("translations")
    @Expose
    private List<Translation> translations = null;

    public List<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }

    public Data withTranslations(List<Translation> translations) {
        this.translations = translations;
        return this;
    }

}