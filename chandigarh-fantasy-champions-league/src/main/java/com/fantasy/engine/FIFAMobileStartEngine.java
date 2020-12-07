package com.fantasy.engine;

import java.io.FileWriter;
import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.MultiPartFeature;

import com.fantasy.endpoints.Endpoints;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FIFAMobileStartEngine {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		FileWriter fWriter = null;
		String allFMPlayers = "/home/henry/git/chandigarh-fantasy-champions-league/chandigarh-fantasy-champions-league/src/main/resources/output/allFMplayers.txt";
		String playerData = "";
		fWriter = new FileWriter(allFMPlayers, true);

		Client client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();
		WebTarget target = client.target(Endpoints.FIFA_MOBILE_ENDPOINT);

		for (int i = 1; i < 1300; i++) {

			String fifaMobileRequestBody = Endpoints.FIFA_MOBILE_REQUEST_BODY;
			fifaMobileRequestBody = fifaMobileRequestBody.replaceAll("pageNum", String.valueOf(i));

			Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.json(fifaMobileRequestBody));
			String responseS = response.readEntity(String.class);
			// System.out.println(responseS);

			JsonParser parser = new JsonParser();
			JsonObject fullEndpointDataofAllPlayers = parser.parse(responseS).getAsJsonObject();
			JsonArray listofAllPlayersArray = fullEndpointDataofAllPlayers.getAsJsonArray("players");

			for (JsonElement player : listofAllPlayersArray) {
				JsonObject playerObject = player.getAsJsonObject();
				String id = playerObject.get("id").getAsString();
				String cardName = playerObject.get("cardName").getAsString();
				String leagueName = playerObject.get("leagueName").getAsString();
				String nationName = playerObject.get("nationName").getAsString();
				String position = playerObject.get("position").getAsString();
				String rating = playerObject.get("rating").getAsString();
				String skillBoost = playerObject.get("skillBoost").getAsString();

				JsonObject avgStats = playerObject.getAsJsonObject("avgStats");

				String PAC = avgStats.get("avg1").getAsString();
				String SHO = avgStats.get("avg2").getAsString();
				String PAS = avgStats.get("avg3").getAsString();
				String DRI = avgStats.get("avg4").getAsString();
				String DEF = avgStats.get("avg5").getAsString();
				String PHY = avgStats.get("avg6").getAsString();

				playerData = id + "\t" + cardName + "\t" + rating + "\t" + position + "\t" + nationName + "\t"
						+ leagueName + "\t" + skillBoost + "\t" + PAC + "\t" + SHO + "\t" + PAS + "\t" + DRI + "\t"
						+ DEF + "\t" + PHY + "\n";

				System.out.print(playerData);

				try {
					fWriter.append(playerData);
					fWriter.flush();
				} catch (IOException ioEx) {
					// TODO Auto-generated catch block
					ioEx.printStackTrace();
				}

			}
		}
	}

}
