package cn.canos.esdslgraph.elasticsearch;

import com.google.gson.annotations.SerializedName;

/**
 * @author harriszhang@live.cn
 */
public class Match {
    /**
     * name
     */
    @SerializedName(NodeNames.Name)
    public String Name;

    /**
     * query
     */
    @SerializedName(NodeNames.Query)
    public String Query;

    /**
     * operator
     */
    @SerializedName(NodeNames.Operator)
    public String Operator;

    /**
     * analyzer
     */
    @SerializedName(NodeNames.Analyzer)
    public String Analyzer;

    /**
     * prefix_length
     */
    @SerializedName(NodeNames.PrefixLength)
    public Integer PrefixLength;

    /**
     * max_expansions
     */
    @SerializedName(NodeNames.MaxExpansions)
    public Integer MaxExpansions;

    /**
     * minimum_should_match
     */
    @SerializedName(NodeNames.MinimumShouldMatch)
    public String MinimumShouldMatch;

    /**
     * fuzzy_transpositions
     */
    @SerializedName(NodeNames.FuzzyTranspositions)
    public Boolean FuzzyTranspositions;

    /**
     * lenient
     */
    @SerializedName(NodeNames.Lenient)
    public Boolean Lenient;

    /**
     * zero_terms_query
     */
    @SerializedName(NodeNames.ZeroTermsQuery)
    public String ZeroTermsQuery;

    /**
     * auto_generate_synonyms_phrase_query
     */
    @SerializedName(NodeNames.AutoGenerateSynonymsPhraseQuery)
    public Boolean AutoGenerateSynonymsPhraseQuery;

    /**
     * boost
     */
    @SerializedName(NodeNames.Boost)
    public Float Boost;
}