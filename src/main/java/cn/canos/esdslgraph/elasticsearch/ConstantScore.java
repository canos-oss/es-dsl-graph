package cn.canos.esdslgraph.elasticsearch;

import com.google.gson.annotations.SerializedName;

/**
 * @author harriszhang@live.cn
 */
public class ConstantScore {
    @SerializedName("filter")
    public Filter Filter;

    @SerializedName("boost")
    public Float Boost;
}