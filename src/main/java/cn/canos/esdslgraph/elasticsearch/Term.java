package cn.canos.esdslgraph.elasticsearch;

import com.google.gson.annotations.SerializedName;

/**
 * @author harriszhang@live.cn
 */
public class Term {
    @SerializedName("name")
    public String Name;

    @SerializedName("value")
    public Object Value;

    @SerializedName("boost")
    public Float Boost;
}