package rk.spring.handson.coronavirustrackerjavabrains.services;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import rk.spring.handson.coronavirustrackerjavabrains.models.LocationStats;

@Service
public class CoronaVirusDataService {
	
	private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/UID_ISO_FIPS_LookUp_Table.csv";
	private List<LocationStats> allstats = new ArrayList<>();
	
	public List<LocationStats> getAllstats() {
		return allstats;
	}


	@PostConstruct
	public void fetchVirusData() throws IOException, InterruptedException {
		 List<LocationStats> newstats = new ArrayList<>();
		HttpClient client = HttpClient.newHttpClient();	
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(VIRUS_DATA_URL)).build();
		
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		StringReader csvbodyreader = new StringReader(response.body());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvbodyreader);
		for (CSVRecord record : records) {
			
		    LocationStats locationstat= new LocationStats();
		    		
			locationstat.setState(record.get("Province_State"));
		    locationstat.setCountry(record.get("Country_Region"));
		    locationstat.setpopulation(record.get("Population"));
		
		System.out.println(locationstat);
		newstats.add(locationstat);
	}
		this.allstats = newstats;

}
}
