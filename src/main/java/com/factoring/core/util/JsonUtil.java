package com.factoring.core.util;

import java.io.*;
import java.net.URL;
import java.util.*;
import net.sf.json.*;

public class JsonUtil
{

    public JsonUtil()
    {
    }

    public static String dataListToJson(List list)
    {
        return JSONSerializer.toJSON(list).toString();
    }

    public static String dataMapToJson(Map map)
    {
        return JSONSerializer.toJSON(map).toString();
    }

    public static Map jsonToDataMap(String jsonStr)
    {
        Map map = new HashMap();
        JSONObject json = JSONObject.fromObject(jsonStr);
        for(Iterator iterator = json.keySet().iterator(); iterator.hasNext();)
        {
            Object k = iterator.next();
            Object v = json.get(k);
            if(v instanceof JSONArray)
            {
                List list = new ArrayList();
                JSONObject json2;
                for(Iterator it = ((JSONArray)v).iterator(); it.hasNext(); list.add(jsonToDataMap(json2.toString())))
                    json2 = (JSONObject)it.next();

                map.put(k.toString(), list);
            } else
            {
                map.put(k.toString(), v);
            }
        }

        return map;
    }

    public static List jsonToDataList(String jsonStr)
    {
        JSONArray jsonArr = JSONArray.fromObject(jsonStr);
        List list = new ArrayList();
        JSONObject json2;
        for(Iterator it = jsonArr.iterator(); it.hasNext(); list.add(jsonToDataMap(json2.toString())))
            json2 = (JSONObject)it.next();

        return list;
    }

    public static List getListByUrl(String url)
    {
        try
        {
            InputStream in = (new URL(url)).openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null) 
                sb.append(line);
            return jsonToDataList(sb.toString());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static Map getMapByUrl(String url)
    {
        try
        {
            InputStream in = (new URL(url)).openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null) 
                sb.append(line);
            return jsonToDataMap(sb.toString());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String s[])
    {
        String ss2 = "{\"abc\":[{\"aaa\":\"11\",\"bb\":\"22\"},{\"ddd\":\"44\",\"ccc\":\"33\"}],\"eee\":[{\"ttt\":\"11\",\"ggg\":\"22\"},{\"hhh\":\"44\",\"jjj\":\"33\"}]}";
        Map map = jsonToDataMap(ss2);
        List ls = (List)map.get("eee");
        System.err.println(ls.get(1));
    }
}