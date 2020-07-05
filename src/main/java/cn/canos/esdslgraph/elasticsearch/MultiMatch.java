package cn.canos.esdslgraph.elasticsearch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author harriszhang@live.cn
 */
public class MultiMatch {
    @SerializedName("query")
    public String Query;

    @SerializedName("fields")
    public List<String> Fields;

    @SerializedName("type")
    public String Type;

    @SerializedName("operator")
    public String Operator;

    @SerializedName("analyzer")
    public String Analyzer;

    @SerializedName("slop")
    public int Slop;

    @SerializedName("prefix_length")
    public int PrefixLength;

    @SerializedName("max_expansions")
    public int MaxExpansions;

    @SerializedName("minimum_should_match")
    public String MinimumShouldMatch;

    @SerializedName("tie_breaker")
    public double TieBreaker;

    @SerializedName("lenient")
    public Boolean Lenient;

    @SerializedName("zero_terms_query")
    public String ZeroTermsQuery;

    @SerializedName("boost")
    public Float Boost;
}