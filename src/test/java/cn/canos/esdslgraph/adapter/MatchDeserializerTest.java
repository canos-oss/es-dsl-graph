package cn.canos.esdslgraph.adapter;

import cn.canos.esdslgraph.elasticsearch.Match;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

public class MatchDeserializerTest {

    @Test
    public void deserialize() {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Match.class, new MatchDeserializer());
        Gson gson = gsonBuilder.create();

        String json = "{\n" +
                "\"match\": {\n" +
                "  \"linked_pinyin.edge_ngram_5\": {\n" +
                "    \"query\": \"北海道\",\n" +
                "    \"operator\": \"AND\",\n" +
                "    \"analyzer\": \"edge_ngram_5\",\n" +
                "    \"prefix_length\": 0,\n" +
                "    \"max_expansions\": 50,\n" +
                "    \"fuzzy_transpositions\": true,\n" +
                "    \"lenient\": false,\n" +
                "    \"zero_terms_query\": \"NONE\",\n" +
                "    \"auto_generate_synonyms_phrase_query\": true,\n" +
                "    \"boost\": 15\n" +
                "  }\n" +
                "}\n" +
                "}";
        MatchWrapper wrapper = gson.fromJson(json, MatchWrapper.class);

        String newJson = new Gson().toJson(wrapper);
        System.out.println(newJson);

    }
}