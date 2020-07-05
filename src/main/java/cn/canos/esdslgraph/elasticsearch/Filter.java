package cn.canos.esdslgraph.elasticsearch;

import com.google.gson.annotations.SerializedName;

/**
 * @author harriszhang@live.cn
 */
public class Filter {
    @SerializedName("terms")
    public Terms Terms;

    @SerializedName("term")
    public Term Term;

    @SerializedName("exists")
    public Exists Exists;

    @SerializedName("match_phrase")
    public MatchPhrase MatchPhrase;

    @SerializedName("bool")
    public BoolQuery BoolQuery;

    @SerializedName("match")
    public Match Match;

    @SerializedName("multi_match")
    public MultiMatch MultiMatch;

    @SerializedName("constant_score")
    public ConstantScore ConstantScore;
}