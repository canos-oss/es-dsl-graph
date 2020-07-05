package cn.canos.esdslgraph.elasticsearch;

import com.google.gson.annotations.SerializedName;

/**
 * @author harriszhang@live.cn
 */
public class Query {
    @SerializedName("bool")
    public BoolQuery BoolQuery;
}