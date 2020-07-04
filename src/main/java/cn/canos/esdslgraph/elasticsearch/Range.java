package cn.canos.esdslgraph.elasticsearch;

import com.google.gson.annotations.SerializedName;

/**
 * @author harriszhang@live.cn
 * @date 2020/7/4.
 */
public class Range {
    /**
     * name
     */
    @SerializedName(NodeNames.Name)
    public String Name;

    /**
     * &gt;
     */
    @SerializedName(NodeNames.GreaterThan)
    public Long GreaterThan;

    /**
     * &gt;=
     */
    @SerializedName(NodeNames.GreaterEqualThan)
    public Long GreateEqualThan;

    /**
     * &lt;
     */
    @SerializedName(NodeNames.LessThan)
    public Long LessThan;

    /**
     * &lt;=
     */
    @SerializedName(NodeNames.LessEqualThan)
    public Long LessEqualThan;

    /**
     * from
     */
    @SerializedName(NodeNames.From)
    public Long From;

    /**
     * to
     */
    @SerializedName(NodeNames.To)
    public Long To;

    /**
     * boost
     */
    @SerializedName(NodeNames.Boost)
    public Float Boost;

    /**
     * include_lower
     */
    @SerializedName(NodeNames.IncludeLower)
    public Boolean IncludeLower;

    /**
     * include_upper
     */
    @SerializedName(NodeNames.IncludeUpper)
    public Boolean IncludeUpper;
}