package com.tuboshu.common;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.List;
public class TBSResult {
	private static final ObjectMapper MAPPER = new ObjectMapper();
	  private Integer status;
	  private String msg;
	  private Object data;
	  
	  public static TBSResult build(Integer status, String msg, Object data)
	  {
	    return new TBSResult(status, msg, data);
	  }
	  
	  public static TBSResult ok(Object data)
	  {
	    return new TBSResult(data);
	  }
	  
	  public static TBSResult ok()
	  {
	    return new TBSResult(null);
	  }
	  
	  public TBSResult() {}
	  
	  public static TBSResult build(Integer status, String msg)
	  {
	    return new TBSResult(status, msg, null);
	  }
	  
	  public TBSResult(Integer status, String msg, Object data)
	  {
	    this.status = status;
	    this.msg = msg;
	    this.data = data;
	  }
	  
	  public TBSResult(Object data)
	  {
	    this.status = Integer.valueOf(200);
	    this.msg = "OK";
	    this.data = data;
	  }
	  
	  public Integer getStatus()
	  {
	    return this.status;
	  }
	  
	  public void setStatus(Integer status)
	  {
	    this.status = status;
	  }
	  
	  public String getMsg()
	  {
	    return this.msg;
	  }
	  
	  public void setMsg(String msg)
	  {
	    this.msg = msg;
	  }
	  
	  public Object getData()
	  {
	    return this.data;
	  }
	  
	  public void setData(Object data)
	  {
	    this.data = data;
	  }
	  
	  public static TBSResult formatToPojo(String jsonData, Class<?> clazz)
	  {
	    try
	    {
	      if (clazz == null) {
	        return (TBSResult)MAPPER.readValue(jsonData, TBSResult.class);
	      }
	      JsonNode jsonNode = MAPPER.readTree(jsonData);
	      JsonNode data = jsonNode.get("data");
	      Object obj = null;
	      if (clazz != null) {
	        if (data.isObject()) {
	          obj = MAPPER.readValue(data.traverse(), clazz);
	        } else if (data.isTextual()) {
	          obj = MAPPER.readValue(data.asText(), clazz);
	        }
	      }
	      return build(Integer.valueOf(jsonNode.get("status").intValue()), jsonNode.get("msg").asText(), obj);
	    }
	    catch (Exception e) {}
	    return null;
	  }
	  
	  public static TBSResult format(String json)
	  {
	    try
	    {
	      return (TBSResult)MAPPER.readValue(json, TBSResult.class);
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	    return null;
	  }
	  
	  public static TBSResult formatToList(String jsonData, Class<?> clazz)
	  {
	    try
	    {
	      JsonNode jsonNode = MAPPER.readTree(jsonData);
	      JsonNode data = jsonNode.get("data");
	      Object obj = null;
	      if ((data.isArray()) && (data.size() > 0)) {
	        obj = MAPPER.readValue(data.traverse(), MAPPER
	          .getTypeFactory().constructCollectionType(List.class, clazz));
	      }
	      return build(Integer.valueOf(jsonNode.get("status").intValue()), jsonNode.get("msg").asText(), obj);
	    }
	    catch (Exception e) {}
	    return null;
	  }
}
