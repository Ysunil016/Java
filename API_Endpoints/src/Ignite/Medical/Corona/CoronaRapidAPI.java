package Ignite.Medical.Corona;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import Ignite.Interfaces.Medical.CoronaInterface;

@PropertySource("classpath:corona.properties")
public class CoronaRapidAPI implements CoronaInterface {

	@Value("${CORONA.RAPID_API}")
	private String CORONA_RAPID_API;
	@Value(value = "${CORONA.RAPID_HOST}")
	private String CORONA_RAPID_HOST;
	@Value(value = "${CORONA.RAPID_KEY}")
	private String CORONA_RAPID_KEY;
	@Value(value = "${CORONA.SAVE_RAPID_STAT_ALL}")
	private String CORONA_SAVE_RAPID_STAT_ALL;

	@Override
	public HttpResponse<String> getAllStastic() {

		HttpResponse<String> response = null;
		try {
			response = Unirest.get(CORONA_RAPID_API).header("x-rapidapi-host", CORONA_RAPID_HOST)
					.header("x-rapidapi-key", CORONA_RAPID_KEY).asString();

		} catch (UnirestException e) {
			e.printStackTrace();
		}

		if (response != null) {
			File file = new File("/Users/sunil016/Documents/Corona_Update.json");
			try {
				file.createNewFile();
				FileWriter writeInsideFile = new FileWriter(file);
				writeInsideFile.write(response.getBody());
				writeInsideFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		if (response != null)
			return response;

		return null;
	}

	@Override
	public HttpResponse<String> getAllStasticByCountry() {
		// TODO Auto-generated method stub
		return null;
	}

}
