package cn.canos.esdslgraph.servlet;

import cn.canos.esdslgraph.FormatRequest;
import cn.canos.esdslgraph.FormatResponse;
import cn.canos.esdslgraph.adapter.*;
import cn.canos.esdslgraph.elasticsearch.*;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author harriszhang@live.cn
 * @date 2020/7/4.
 */
public class FormatServlet extends BaseApiServlet {

    private final static Charset CHARSET = Charset.forName("UTF-8");

    private final Gson specialGson;
    private final Gson normalGson;

    public FormatServlet() {
        GsonBuilder esGsonBuilder = new GsonBuilder();
        esGsonBuilder.registerTypeAdapter(Range.class, new RangeDeserializer());
        esGsonBuilder.registerTypeAdapter(Term.class, new TermDeserializer());
        esGsonBuilder.registerTypeAdapter(Terms.class, new TermsDeserializer());
        esGsonBuilder.registerTypeAdapter(ConditionCollection.class, new ConditionCollectionDeserializer());
        esGsonBuilder.registerTypeAdapter(Match.class, new MatchDeserializer());
        esGsonBuilder.registerTypeAdapter(MatchPhrase.class, new MatchPhraseDeserializer());
        specialGson = esGsonBuilder.create();

        GsonBuilder normalGsonBuilder = new GsonBuilder();
        normalGsonBuilder.registerTypeAdapter(ConditionCollection.class, new ConditionCollectionSerializer());
        normalGson = normalGsonBuilder.create();
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        FormatRequest formatRequest = getFormatRequest(httpServletRequest);

        if (formatRequest == null || Strings.isNullOrEmpty(formatRequest.getContent())) {
            FormatResponse formatResponse = new FormatResponse();
            formatResponse.setMessage("invalid request");
            setResponse(httpServletResponse, formatResponse);
            return;
        }

        Request esRequest;
        String esRequestString;
        try {
            esRequest = specialGson.fromJson(formatRequest.getContent(), Request.class);
            esRequestString = normalGson.toJson(esRequest);
        } catch (Exception e) {
            FormatResponse formatResponse = new FormatResponse();
            formatResponse.setMessage("format error, maybe invalid es dsl.");
            setResponse(httpServletResponse, formatResponse);
            return;
        }

        StringBuilder builder = new StringBuilder();
        builder.append("{\"statusCode\":1,\"content\":");
        builder.append(esRequestString);
        builder.append("}");
        String content = builder.toString();

        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getOutputStream().write(content.getBytes(CHARSET));
        httpServletResponse.getOutputStream().close();
    }

    private FormatRequest getFormatRequest(HttpServletRequest httpServletRequest) {
        try {
            return parseRequest(httpServletRequest, FormatRequest.class);
        } catch (Exception e) {
            return null;
        }
    }
}