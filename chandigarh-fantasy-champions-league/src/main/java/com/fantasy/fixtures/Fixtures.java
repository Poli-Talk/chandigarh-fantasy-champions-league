package com.fantasy.fixtures;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.MultiPartFeature;

import com.fantasy.endpoints.Endpoints;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Fixtures {

	public static void main(String[] args) {
		Client client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();
		WebTarget target = client.target(Endpoints.FIXTURES_ENDPOINT);
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		String responseS = response.readEntity(String.class);
		// System.out.println(responseS);

		JsonParser parser = new JsonParser();
		JsonObject fullEndpointDataofAllFixtures = parser.parse(responseS).getAsJsonObject();
		JsonArray allMatchDays = fullEndpointDataofAllFixtures.getAsJsonObject("data").getAsJsonArray("value");

		for (JsonElement matchday : allMatchDays) {
			JsonArray allGamesinEachMatchday = matchday.getAsJsonObject().getAsJsonArray("match");
			for (JsonElement game : allGamesinEachMatchday) {
				JsonObject gameObject = game.getAsJsonObject();
				String mdName = gameObject.get("mdName").getAsString();
				String groupName = gameObject.get("groupName").getAsString();
				String atName = gameObject.get("atName").getAsString();
				String htName = gameObject.get("htName").getAsString();

				System.out.println(mdName + "\t" + groupName + "\t" + atName + "\t" + htName);
			}
		}
	}
}
