package cn.canos.esdslgraph.elasticsearch;

import com.google.gson.annotations.SerializedName;

/**
 * @author harriszhang@live.cn
 * @date 2020/7/4.
 */
public class ConstantScore {
    @SerializedName("filter")
    public Filter Filter;

    @SerializedName("boost")
    public Float Boost;
}