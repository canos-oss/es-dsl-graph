package cn.canos.esdslgraph.elasticsearch;

import com.google.gson.annotations.SerializedName;

/**
 * @author harriszhang@live.cn
 */
public class Condition {
    @SerializedName("constant_score")
    public ConstantScore ConstantScore;

    @SerializedName("bool")
    public BoolQuery BoolQuery;

    @SerializedName("terms")
    public Terms Terms;

    @SerializedName("term")
    public Term Term;

    @SerializedName("ids")
    public Ids Ids;

    @SerializedName("match")
    public Match Match;

    @SerializedName("multi_match")
    public MultiMatch MultiMatch;

    @SerializedName("script")
    public Script Script;

    @SerializedName("range")
    public Range Range;
}