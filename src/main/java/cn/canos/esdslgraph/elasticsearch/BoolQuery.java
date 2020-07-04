package cn.canos.esdslgraph.elasticsearch;

import com.google.gson.annotations.SerializedName;

/**
 * @author harriszhang@live.cn
 * @date 2020/7/4.
 */
public class BoolQuery {
    @SerializedName("must")
    public ConditionCollection Musts;

    @SerializedName("filter")
    public ConditionCollection Filter;

    @SerializedName("should")
    public ConditionCollection Shoulds;

    @SerializedName("disable_coord")
    public Boolean DisableCoord;

    @SerializedName("adjust_pure_negative")
    public Boolean AdjustPureNegative;

    @SerializedName("boost")
    public Float Boost;
}