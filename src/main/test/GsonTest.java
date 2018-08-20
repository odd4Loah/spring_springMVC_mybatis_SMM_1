
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.lihoo.ssm.gai.model.UserX;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

/**
 * #Title: GsonTest
 * #ProjectName spring_springMVC_mybatis_SMM_JSON
 * #Description: 0000
 * #author lihoo
 * #date 2018/8/14-15:43
 */

@SuppressWarnings("unused")
public class GsonTest {

    @Test
    public void test1() {
        Gson gson = new Gson();
        UserX userX = new UserX(1, 20, "AA", new Date());

        System.out.println("Bean->转换为JSON字符串:");

        String jsonStr = gson.toJson(userX);
        System.out.println(jsonStr);
        System.out.println("安排");
    }

    @Test
    public void test2() {
        Gson gson = new Gson();
        String jsonStr = "{\"id\":1,\"age\":20,\"userName\":\"AA\",\"birthday\":\"Nov 14, 2016 4:52:38 PM\"}";
        System.out.println("字符串->转换成Bean对象");

        UserX UserX = gson.fromJson(jsonStr, UserX.class);

        System.out.println(UserX);
        System.out.println("反向");
    }

    @Test
    public void test3() {
        Gson gson = new Gson();
        System.out.println("json转换复杂的bean，比如List，Set,Map:");
        String json = "[{\"id\":\"1\",\"name\":\"Json技术\"},{\"id\":\"2\",\"name\":\"java技术\"}]";

        List list = gson.fromJson(json, new TypeToken<List>() {
        }.getType());
        Set set = gson.fromJson(json, new TypeToken<Set>() {
        }.getType());
        System.out.println(list);
        System.out.println(set);
        System.out.println("皮一下");
    }

    @Test
    public void test4() {
        Gson gson = new Gson();
        String json = "[{\"id\":\"1\",\"name\":\"Json技术\"},{\"id\":\"2\",\"name\":\"java技术\"}]";
        System.out.println("格式化JSON:");
        gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(json);
        json = gson.toJson(je);
        System.out.println(json);
        System.out.println("JSON板正");

    }

    @Test
    public void test5() {
        System.out.println("判断字符串是否是json,通过捕捉的异常来判断是否是json");
        String json = "[{\"id\":\"1\",\"name\":\"Json技术\"},{\"id\":\"2\",\"name\":\"java技术\"}]";
        boolean jsonFlag;
        try {
            new JsonParser().parse(json).getAsJsonObject();
            jsonFlag = true;
        } catch (Exception e) {
            jsonFlag = false;
        }
        System.out.println(jsonFlag + ":" + jsonFlag);
        System.out.println("对错");
    }

    @Test
    public void test6() {
        System.out.println("从json串中获取属性");
        String json = "{\"id\":\"1\",\"name\":\"Json技术\"}";
        String propertyName = "id";
        String propertyValue = "";
        try {
            JsonParser jsonParser = new JsonParser();
            JsonElement element = jsonParser.parse(json);
            JsonObject jsonObj = element.getAsJsonObject();
            propertyValue = jsonObj.get(propertyName).toString();
            System.out.println("propertyValue:" + propertyValue);
        } catch (Exception e) {
            propertyValue = null;
        }
        System.out.println();
    }

    @Test
    public void test7() {
        System.out.println("除去json中的某个属性");
        String json = "{\"id\":\"1\",\"name\":\"Json技术\"}";
        String propertyName = "name";
        JsonParser jsonParser = new JsonParser();
        JsonElement element = jsonParser.parse(json);
        JsonObject jsonObj = element.getAsJsonObject();
        jsonObj.remove(propertyName);
        json = jsonObj.toString();
        System.out.println("json：" + json);
        System.out.println();
    }

    @Test
    public void test8() {
        System.out.println("向json中添加属性");
        String json = "{\"id\":\"1\",\"name\":\"Json技术\"}";
        String propertyName = "desc";
        Object propertyValue = "json各种技术的调研";
        JsonParser jsonParser = new JsonParser();
        JsonElement element = jsonParser.parse(json);
        JsonObject jsonObj = element.getAsJsonObject();
        jsonObj.addProperty(propertyName, new Gson().toJson(propertyValue));
        json = jsonObj.toString();
        System.out.println("json:" + json);
        System.out.println();
    }

    @Test
    public void test9() {
        System.out.println("修改json中的属性");
        String json = "{\"id\":\"1\",\"name\":\"Json技术\"}";
        String propertyName = "name";
        Object propertyValue = "json各种技术的调研";
        JsonParser jsonParser = new JsonParser();
        JsonElement element = jsonParser.parse(json);
        JsonObject jsonObj = element.getAsJsonObject();
        jsonObj.remove(propertyName);
        jsonObj.addProperty(propertyName, new Gson().toJson(propertyValue));
        json = jsonObj.toString();
        System.out.println("json:" + json);
        System.out.println();
    }

    @Test
    public void test10() {
        System.out.println("判断json中是否有属性");
        String json = "{\"id\":\"1\",\"name\":\"Json技术\"}";
        String propertyName = "age";
        boolean isContains = false;
        JsonParser jsonParser = new JsonParser();
        JsonElement element = jsonParser.parse(json);
        JsonObject jsonObj = element.getAsJsonObject();
        isContains = jsonObj.has(propertyName);
        System.out.println("isContains:" + isContains);
        System.out.println();
    }

    @Test
    public void test11() {
        System.out.println("json中日期格式的处理");
        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat("yyyy-MM-dd");
        Gson gson = builder.create();
        UserX UserX = new UserX();
        UserX.setBirthday(new Date());
        String json = gson.toJson(UserX);
        System.out.println("json:" + json);
        System.out.println();
    }

    @Test
    public void test12() {
        System.out.println("json中对于Html的转义");
        GsonBuilder builder = new GsonBuilder();
        builder.disableHtmlEscaping();
        Gson gson = builder.create();
        System.out.println();
    }

}