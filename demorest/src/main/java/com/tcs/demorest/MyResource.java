package com.tcs.demorest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/myresource")
public class MyResource {
  
	//... code to get files in directory
	@GET
	@Path("/resource")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<File> getFileContent() throws IOException {
		ArrayList<File> allFiles = new ArrayList<File>();
		try {
			File[] allSubFiles = new File("S:\\Temp").listFiles();
			for(File file : allSubFiles) {
				allFiles.add(file);
			}
			
		}catch(Exception e) {
			e.getMessage();
		}
		return allFiles;
	}
	
	
	//... code to create in file and add content in file passed through URI
	@POST
	@Path("/resource/{someMsg}")
	@Produces(MediaType.APPLICATION_JSON)
	public File postContent(@PathParam("someMsg") String msg) throws NumberFormatException, IOException {
		File myfile= new File("myfile.txt");
		PrintWriter writer = new PrintWriter(myfile);
		writer.write(msg);
		writer.close();
		return myfile;
	}
	
	//... code to update existing file and add content in file passed through URI
	@PUT
	@Path("/resource/{someMsg}")
	@Produces(MediaType.APPLICATION_JSON)
	public String ChangeContent(@PathParam("someMsg") String msg) throws IOException {
		FileWriter fw = new FileWriter("myfile.txt",true);
		fw.write(msg);
		fw.close();
		return Files.readString(Paths.get("myfile.txt"));
	}
}
