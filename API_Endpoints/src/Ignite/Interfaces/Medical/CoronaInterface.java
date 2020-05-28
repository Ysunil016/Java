package Ignite.Interfaces.Medical;

import com.mashape.unirest.http.HttpResponse;

public interface CoronaInterface {

	HttpResponse<String> getAllStastic();

	HttpResponse<String> getAllStasticByCountry();

}
