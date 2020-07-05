package cn.canos.esdslgraph.elasticsearch;

import com.google.gson.annotations.SerializedName;

/**
 * @author harriszhang@live.cn
 */
public class MatchPhrase {
    @SerializedName("name")
    public String Name;

    @SerializedName("query")
    public String Query;

    @SerializedName("analyzer")
    public String Analyzer;

    @SerializedName("slop")
    public Integer Slop;

    @SerializedName("boost")
    public Float Boost;
}