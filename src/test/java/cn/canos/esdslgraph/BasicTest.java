package cn.canos.esdslgraph;

import cn.canos.esdslgraph.adapter.*;
import cn.canos.esdslgraph.elasticsearch.*;
import cn.savory.health.elasticsearch.*;
import cn.savory.health.adapter.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;


public class BasicTest {

    @Test
    public void test() {

        GsonBuilder esGsonBuilder = new GsonBuilder();
        esGsonBuilder.registerTypeAdapter(Range.class, new RangeDeserializer());
        esGsonBuilder.registerTypeAdapter(Term.class, new TermDeserializer());
        esGsonBuilder.registerTypeAdapter(Terms.class, new TermsDeserializer());
        esGsonBuilder.registerTypeAdapter(ConditionCollection.class, new ConditionCollectionDeserializer());
        esGsonBuilder.registerTypeAdapter(Match.class, new MatchDeserializer());
        esGsonBuilder.registerTypeAdapter(MatchPhrase.class, new MatchPhraseDeserializer());
        Gson esGson = esGsonBuilder.create();
    }
}