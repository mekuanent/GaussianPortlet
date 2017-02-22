package com.saigia.gaussian;

import java.util.Map;

import okhttp3.RequestBody;

import com.saigia.gaussian.vo.CheckStatusResponse;
import com.saigia.gaussian.vo.CreateTaskRequest;
import com.saigia.gaussian.vo.CreateTaskResponse;
import com.saigia.gaussian.vo.UploadFilesResponse;





//import retrofit.Call;
import retrofit.RestAdapter;
//import retrofit.Retrofit;
import retrofit.client.OkClient;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.PartMap;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.mime.TypedFile;

public interface Connection {

	final RestAdapter.Builder builder = new RestAdapter.Builder()
    .setEndpoint("http://151.97.41.43:8888/v1.0");
	
//	static Retrofit retrofit = new Retrofit.Builder()
//    .baseUrl("https://futuregateway_server/")
//    .build();
	
	public static Connection apiService = builder.build().create(Connection.class);
	
	@POST("/tasks")
	public CreateTaskResponse createTask(@Query("user") String user,  @Body CreateTaskRequest creteTaskRequest);
	
	@Multipart
	@POST("/tasks/{id}/input")
	public UploadFilesResponse uploadFiles(@Path("id") String id, @Query("user") String user, @PartMap Map<String, TypedFile> files);

	@GET("/tasks/{id}")
	public CheckStatusResponse checkStatus(@Path("id") long id);
	
	
}
