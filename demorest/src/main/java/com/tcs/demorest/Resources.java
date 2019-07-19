package com.tcs.demorest;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ws.rs.core.MediaType;

import org.glassfish.hk2.api.Proxiable;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/abcd")
public class Resources {

	@GET
	@Path("/xyz")
	@Produces(MediaType.APPLICATION_JSON)
	public String getFileContent() throws IOException {
		String content = Files.readString(Paths.get("myfile.txt"));
		return content;
	}
	
	@POST
	@Path("/xyz/{/messange}")
	public void postContent(@PathParam("messange") String msg) throws NumberFormatException, IOException {
		File myfile= new File("myfile.txt");
		PrintWriter writer = new PrintWriter(myfile);
		writer.write(msg);
		writer.close();
	}
	
}
