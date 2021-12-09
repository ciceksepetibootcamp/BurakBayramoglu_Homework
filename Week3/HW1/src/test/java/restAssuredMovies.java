import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

// API DOCUMENTATION CAN BE FOUND AT https://developers.themoviedb.org/3/

public class restAssuredMovies {
    public static String API_KEY = "f52ebe574870228a35caed91f09beba5"; // Setting the API Key as Public variable in order of usage at other classes.
    public static String Base_URL = "https://api.themoviedb.org/3"; // Setting the Base URL as Public variable in order of usage at other classes.
    String Language =  "&language=en-US"; //OPTIONAL
    String request_token = "none";

    @Test
    public void createRequestToken(){
        String EndPoint = "/authentication/token/new";
        Response response = when()
                .get(Base_URL+EndPoint+"?=api_key=" + API_KEY)
                .then()
                .statusCode(200) // Check if response code equals to 200
                .body("success", equalTo(true)) // Check the success condition that returned from JSON
                .extract().response(); // Extract the response to save the request token from JSON
        request_token = response.jsonPath().getString("request_token");
        System.out.print("Request Token: "+request_token+"\n");
    }

    @Test public void loginRequest(){

        String EndPoint = "/authentication/token/validate_with_login";
        JSONObject map = new JSONObject();
        map.put("username","burkisilin");
        map.put("password","1234");
        map.put("request_token",request_token);

        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(map.toString()) // Sets the body for post method.
                .when()
                .post(Base_URL+EndPoint+"?=api_key=" + API_KEY)
                .then()
                .statusCode(200); // Checks the status code. If you got 200, it means you have logged in. If you got 401 it means you have used wrong credentials.
    }


    @Test // Testing of the if 2nd and 3rd movie got higher rating then 5.0
    public void goodRatedMovieTest(){
        for(int i = 2; i < 4; i++) { // Create an integer i variable to use at the request.
            Response response = when()
                    .get(Base_URL + "/movie/" + String.valueOf(i) + "?=api_key=" + API_KEY + Language) // Do the request.
                    .then()
                    .statusCode(200) // Check if response code equals to 200
                    .body("vote_average", greaterThan(5F)) // Check if movie got higher rating then 5.0
                    .extract().response(); // Extract the value for the usage of printing out title of movie and average note from JSON.
            String average_vote = response.jsonPath().getString("vote_average");
            String title = response.jsonPath().getString("title");
            System.out.print("Title: "+title+" -- > "+average_vote+"\n");
        }
    }

    @Test
    public void checkTheThirdTopRatedTVSeriesName(){ // Checks if the top rated 3rd TV Series is Arcane: League Of Legends
        String EndPoint = "/tv/top_rated";
        when()
                .get(Base_URL+EndPoint+"?=api_key=" + API_KEY)
                .then()
                .statusCode(200) // Check if response code equals to 200
                .body("results[2].name", equalTo("Arcane: League of Legends"));
    }


    @Test
    public void checkGenres(){ //Tests and validates first and last genre at response.
        String EndPoint = "/genre/movie/list";
        when()
                .get(Base_URL+EndPoint+"?=api_key=" + API_KEY)
                .then()
                .statusCode(200) // Check if response code equals to 200
                .body("genres[0].name", equalTo("Action")) // Check if first genre is Action
                .body("genres[-1].name", equalTo("Western")) // Check if last genre is Western
                .time(lessThan(4000L)); // Check if request takes less then 4 seconds.
    }

}
