package cn.alapi.javasdk;

import org.json.simple.parser.ParseException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yeliulee
 * Created at 2021/6/22 22:27
 */
@DisplayName("ALAPI 请求客户端测试")
class AlapiClientTest {

    /**
     * 空 token 测试
     */
    @Test
    public void testForEmptyToken() throws IOException, ParseException {
        AlapiClient client = new AlapiClient().setToken("");
        AlapiRequest request = new AlapiRequest();
        request.setApi("/api/joke/random");
        AlapiResponse response = client.execute(request);
        System.out.println(response.getMsg());
        assertEquals(101L, response.getCode());
    }
}