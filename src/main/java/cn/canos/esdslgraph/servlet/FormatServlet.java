package cn.canos.esdslgraph.servlet;

import cn.canos.esdslgraph.adapter.*;
import cn.canos.esdslgraph.elasticsearch.*;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * @author harriszhang@live.cn
 * @date 2020/7/4.
 */
@WebServlet(urlPatterns = "/es-dsl-graph/format")
public class FormatServlet extends HttpServlet {

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
        try {
            esRequest = specialGson.fromJson(formatRequest.getContent(), Request.class);
        } catch (Exception e) {
            FormatResponse formatResponse = new FormatResponse();
            formatResponse.setMessage("format error, maybe invalid es dsl.");

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
            formatResponse.setStackTrace(stackTrace);

            setResponse(httpServletResponse, formatResponse);
            return;
        }

        String esRequestString;
        try {
            esRequestString = normalGson.toJson(esRequest);
        } catch (Exception e) {
            FormatResponse formatResponse = new FormatResponse();
            formatResponse.setMessage("format error, maybe invalid es dsl.");

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
            formatResponse.setStackTrace(stackTrace);

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

    private final static Gson GSON = new GsonBuilder().create();

    protected static <T> T parseRequest(HttpServletRequest request, Class<T> classOfT) throws IOException, IllegalAccessException, InstantiationException {

        //String defaultCharset = System.getProperty("sun.jnu.encoding");
        //Charset fileCharset = defaultCharset != null ? Charset.forName(defaultCharset) : Charset.defaultCharset();
        Scanner s = new Scanner(request.getInputStream(), CHARSET.name()).useDelimiter("\\A");
        String content = s.hasNext() ? s.next() : "";
        if (Strings.isNullOrEmpty(content)) {
            return classOfT.newInstance();
        }

        return GSON.fromJson(content, classOfT);
    }

    protected static void setResponse(HttpServletResponse response, Object item) throws IOException {

        response.setStatus(HttpServletResponse.SC_OK);

        if (item instanceof String) {
            response.setContentType("text/plain");
            response.getOutputStream().write(((String) item).getBytes(CHARSET));
            response.getOutputStream().close();
            return;
        }

        String content = GSON.toJson(item);
        response.setContentType("application/json;charset=UTF-8");
        response.getOutputStream().write(content.getBytes(CHARSET));
        response.getOutputStream().close();
    }

    protected static void setFileResponse(HttpServletResponse response, String fileName, String fileContent) throws IOException {

        response.setHeader("content-disposition", "attachment; filename=" + fileName);
        response.getOutputStream().write(fileContent.getBytes(CHARSET));
        response.getOutputStream().close();
    }
}