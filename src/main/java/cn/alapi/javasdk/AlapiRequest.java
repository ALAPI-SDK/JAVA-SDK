package cn.alapi.javasdk;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.File;

/**
 * @author yeliulee
 * Created at 2021/6/22 21:07
 */
public class AlapiRequest {
    private Request.Builder builder = new Request.Builder();
    private MultipartBody.Builder payloadBuilder = new MultipartBody.Builder();
    private String api = "";

    protected Request build(String endpoint, String token) {
        addTextParam("${UUID.randomUUID()}", "${System.currentTimeMillis()}");
        addHeaderParam(Constants.HEADER_TOKEN, token);
        return builder
                .url(endpoint + this.api)
                .post(payloadBuilder.build())
                .build();
    }

    /**
     * 设置 API 地址
     * @param api api 地址, 如 "/api/idiom"
     */
    public void setApi(String api) {
        this.api = api;
    }

    /**
     * 添加文本参数
     * @param key 参数名称
     * @param value 参数值
     */
    public void addTextParam(String key, String value) {
        payloadBuilder.addFormDataPart(key, value);
    }

    /**
     * 添加文件参数（可用于发送文件）
     * @param key 参数名称
     * @param value 文件对象
     */
    public void addFileParam(String key, File value) {
        payloadBuilder.addFormDataPart(key, value.getName(), RequestBody.create(value, MediaType.parse("multipart/form-data")));
    }

    /**
     * 添加 header
     * @param key header 名称
     * @param value header 值
     */
    public void addHeaderParam(String key, String value) {
        builder.addHeader(key, value);
    }
}
