package cn.alapi.javasdk;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Objects;

/**
 * ALAPI 请求客户端
 * @author yeliulee
 * Created at 2021/6/22 14:26
 */
public class AlapiClient {
    private String endpoint = "https://v2.alapi.cn";
    private String token = "";
    static private final OkHttpClient client = new OkHttpClient();
    static private final JSONParser parser = new JSONParser();

    public AlapiClient setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    public AlapiClient setToken(String token) {
        this.token = token;
        return this;
    }

    public AlapiResponse execute(AlapiRequest request) throws IOException, ParseException {
        Request pendingRequest = request.build(endpoint, token);
        Response response = client.newCall(pendingRequest).execute();
        String jsonString = Objects.requireNonNull(response.body()).string();
        JSONObject jsonValue = (JSONObject) parser.parse(jsonString);
        AlapiResponse targetResponse = new AlapiResponse();
        targetResponse.setCode((Long) jsonValue.get("code"));
        targetResponse.setMsg((String) jsonValue.get("msg"));
        targetResponse.setData(jsonValue.get("data"));
        targetResponse.setTime((Long) jsonValue.get("time"));
        targetResponse.setLogID(jsonValue.get("log_id").toString());
        return targetResponse;
    }
}
