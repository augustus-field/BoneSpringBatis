package com.bone.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bone.entity.Result;
import com.bone.service.BoneService;
import com.bone.service.impl.BoneServiceImpl;
import com.bone.util.TimeLogger;

@Component("InfoDbTest")
public class InfoDbTest extends HttpServlet{
	Log logger = LogFactory.getLog(this.getClass());
	@Autowired
	BoneService boneService;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");
		if(act==null){
			act="";
		}else {
			act = act.trim().toLowerCase();
		}
		String message = null;
		TimeLogger tl = new TimeLogger();
			
		if(act.equals("insert")){
			int entries = Integer.parseInt(request.getParameter("num"));
			boneService.addDummyBones(entries);
			message=String.format("Inserting %d entries in H2 takes time: %d.", 
					entries, tl.getTimeDiff());
		}else{
			message="request success";
		}
		
		PrintWriter writer = response.getWriter();
		JSONObject jobj = JSONObject.fromObject(message);
		writer.append(jobj.toString());
		writer.close();
	}

	private static final long serialVersionUID = 1L;
	
}
