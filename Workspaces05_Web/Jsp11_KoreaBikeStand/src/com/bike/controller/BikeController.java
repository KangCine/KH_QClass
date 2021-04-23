package com.bike.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bike.dao.BikeDao;
import com.bike.dto.BikeDto;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@WebServlet("/BikeController")
public class BikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("[" + command + "]");
		
		if(command.equals("view")) {
			response.sendRedirect("view.html");
		} else if(command.equals("getdata")) {
			BikeDao dao = new BikeDao();
			
			if(dao.delete()) {
				System.out.println("db 초기화 성공");
			} else {
				System.out.println("db 초기화 실패");
			}
			
			String mydata = request.getParameter("mydata");
			
			// Json : JsonObject, JsonArray, JsonPrimitive, JsonNull 값들을 모두 포함!
			JsonElement element = JsonParser.parseString(mydata);
			// JsonObject : key-value pair ({"String" : JsonElement} 형식)
			JsonObject jsonData = element.getAsJsonObject();
			
			// JsonObject jsonData = JsonParser.parseString(data).getAsJsonObject();
			
			
			
			JsonElement records = jsonData.get("records");
			JsonArray recordsArray = records.getAsJsonArray();
			
			List<BikeDto> list = new ArrayList<BikeDto>();
			JsonArray resultArray = new JsonArray();
			
			for(int i = 0; i < recordsArray.size(); i++) {
				/*
				JsonElement tempElement = recordsArray.get(i);
				JsonObject tempObject = tempElement.getAsJsonObject();
				JsonElement nameElement = tempOnject.get("자전거대여소명");
				String name = nameElement.getAsString();
				 */
				String name = recordsArray.get(i).getAsJsonObject().get("자전거대여소명").getAsString();
				String addr = null;
				if(recordsArray.get(i).getAsJsonObject().get("소재지도로명주소") != null) {
					addr = recordsArray.get(i).getAsJsonObject().get("소재지도로명주소").getAsString();
				} else {
					addr = recordsArray.get(i).getAsJsonObject().get("소재지지번주소").getAsString();
				}
				
				double latitude = recordsArray.get(i).getAsJsonObject().get("위도").getAsDouble();
				double longitude = recordsArray.get(i).getAsJsonObject().get("경도").getAsDouble();
				
				int bike_count = recordsArray.get(i).getAsJsonObject().get("자전거보유대수").getAsInt();
				
				BikeDto dto = new BikeDto(name, addr, latitude, longitude, bike_count);
				list.add(dto);
				
				Gson gson = new Gson();
				String jsonString = gson.toJson(dto);
				resultArray.add(JsonParser.parseString(jsonString));
			}
			
			if(dao.insert(list)) {
				System.out.println("db 저장 성공");
			}else {
				System.out.println("db 저장 실패");
			}
			
			JsonObject result = new JsonObject();
			result.add("result", resultArray);
			
			response.getWriter().append(result+"");
		}
	}

}
