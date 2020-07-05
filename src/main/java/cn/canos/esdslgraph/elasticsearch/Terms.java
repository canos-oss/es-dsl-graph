package cn.canos.esdslgraph.elasticsearch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author harriszhang@live.cn
 */
public class Terms {
    @SerializedName("name")
    public String Name;

    @SerializedName("values")
    public List<Object> Values;

    @SerializedName("boost")
    public Float Boost;
}