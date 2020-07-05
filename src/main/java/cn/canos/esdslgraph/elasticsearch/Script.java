package cn.canos.esdslgraph.elasticsearch;

import com.google.gson.annotations.SerializedName;

/**
 * @author harriszhang@live.cn
 */
public class Script {
    @SerializedName("script")
    public ScriptObject ScriptObject;

    @SerializedName("boost")
    public Float Boost;
}