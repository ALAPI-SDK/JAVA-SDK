package cn.alapi.javasdk;

import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.Assert;

import java.io.IOException;

/**
 * @author yeliulee
 * Created at 2021/6/22 21:29
 */
public class AlapiClientTest {

    /**
     * test for empty token
     */
    @Test
    public void testForEmptyToken() throws IOException, ParseException {
        AlapiClient client = new AlapiClient().setToken("");
        AlapiRequest request = new AlapiRequest();
        request.setApi("/api/joke/random");
        AlapiResponse response = client.execute(request);
        Assert.assertEquals(101L, response.getCode());
    }
}
