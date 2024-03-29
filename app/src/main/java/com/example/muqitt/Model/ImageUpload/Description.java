
package com.example.muqitt.Model.ImageUpload;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Description {

    @SerializedName("raw")
    @Expose
    private String raw;
    @SerializedName("rendered")
    @Expose
    private String rendered;

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getRendered() {
        return rendered;
    }

    public void setRendered(String rendered) {
        this.rendered = rendered;
    }

}
