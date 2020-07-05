package cn.canos.esdslgraph.elasticsearch;

import com.google.gson.annotations.SerializedName;

/**
 * @author harriszhang@live.cn
 */
public class Exists {
    @SerializedName("field")
    public String Field;

    @SerializedName("boost")
    public Float Boost;
}