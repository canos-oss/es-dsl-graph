package cn.canos.esdslgraph.adapter;

import cn.canos.esdslgraph.elasticsearch.Range;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

public class RangeDeserializerTest {

    @Test
    public void deserialize() {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Range.class, new RangeDeserializer());
        Gson gson = gsonBuilder.create();

        String json = "{\n" +
                "\"range\": {\n" +
                "  \"rmb_sale_price\": {\n" +
                "    \"from\": 12,\n" +
                "    \"to\": null,\n" +
                "    \"include_lower\": true,\n" +
                "    \"include_upper\": true,\n" +
                "    \"boost\": 1\n" +
                "  }\n" +
                "}\n" +
                "}";
        RangeWrapper wrapper = gson.fromJson(json, RangeWrapper.class);

        String newJson = new Gson().toJson(wrapper);
        System.out.println(newJson);
    }
}