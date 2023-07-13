package devandroid.gabriel.catologcourses;

import devandroid.gabriel.catologcourses.models.UdacityCatalog;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UdacityService {
    public static final String BASE_URL = "https://ah.we.imply.com/public-api/v0/";
    // https://www.udacity.com/courses/all
    // https://www.udacity.com/public-api/v0/
    @GET("courses")
    Call<UdacityCatalog> listCatalog();
}
