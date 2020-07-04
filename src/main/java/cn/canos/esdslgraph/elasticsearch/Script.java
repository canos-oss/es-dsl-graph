package cn.canos.esdslgraph.elasticsearch;

import com.google.gson.annotations.SerializedName;

/**
 * @author harriszhang@live.cn
 * @date 2020/7/4.
 */
public class Script {
    @SerializedName("script")
    public ScriptObject ScriptObject;

    @SerializedName("boost")
    public Float Boost;
}