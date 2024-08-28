package com.BajajAssign2;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;





public class App 
{
    public static void main( String[] args )
    {
        Gson gson = new Gson();
        String prnNo = "";
        String fp = "";
        if(args.length>1) {
        	prnNo = args[0];
        	fp = args[1];
        	
        	if(!prnNo.isEmpty() && !fp.isEmpty()) {
        		System.out.println(Arrays.toString(args));
        		File f = new File(fp);
        		System.out.println(f.exists());
        		try(FileReader reader = new FileReader(f)){
        			Type type = new TypeToken<Map<String, Object>>(){}.getType();
        			 Map<String, Object> map = gson.fromJson(reader, type);
        			 System.out.println(map.keySet());
        			
        			 for(var k:map.keySet()) {
        				 var o = map.get(k);
        				 System.out.println(o);
        				 if(o instanceof Map) {
        					 System.out.println("Instance of map");
        					 var nm = (Map) o;
        					 if(nm.containsKey("destination")) {
        						 System.out.println("destinations "+nm.get("destination"));
        					 }
        				 }
        				 
        				 
        			 }
        			 
        			 
        			
				} catch (Exception e) {
					
				}
        	}
        }
    }
}
