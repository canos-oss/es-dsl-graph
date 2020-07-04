package cn.canos.esdslgraph.adapter;

import cn.canos.esdslgraph.elasticsearch.Terms;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

public class TermsDeserializerTest {
    @Test
    public void deserialize() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Terms.class, new TermsDeserializer());
        Gson gson = gsonBuilder.create();

        String json = "{\n" +
                "    \"terms\" : {\n" +
                "        \"user\" : [\"kimchy\", \"elasticsearch\"],\n" +
                "        \"boost\" : 1.0\n" +
                "    }\n" +
                "}";
        TermsWrapper wrapper = gson.fromJson(json, TermsWrapper.class);

        String newJson = new Gson().toJson(wrapper);
        System.out.println(newJson);
    }
}