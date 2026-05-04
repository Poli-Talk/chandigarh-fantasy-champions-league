package com.fantasy.engine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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

public class FIFAMobilePlayerInformation {

	public static void main(String[] args) throws IOException {

		String playerData;
		String myFMPlayers = "/home/henry/git/chandigarh-fantasy-champions-league/chandigarh-fantasy-champions-league/src/main/resources/output/myFMPlayers.txt";
		File file = new File(myFMPlayers);
		BufferedReader br = new BufferedReader(new FileReader(file));

		String retrivedPlayerId;
		while ((retrivedPlayerId = br.readLine()) != null) {

			Client client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();

			String fifaMobileRequestBody = Endpoints.FIFA_MOBILE_PLAYER_DATA;
			fifaMobileRequestBody = fifaMobileRequestBody.replaceAll("playerid", retrivedPlayerId);
			// System.out.println(fifaMobileRequestBody);

			WebTarget target = client.target(fifaMobileRequestBody);
			Response response;
			String responseS = null;
			try {
				response = target.request(MediaType.APPLICATION_JSON).get();
				responseS = response.readEntity(String.class);
				// System.out.println(responseS);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}

			JsonParser parser = new JsonParser();
			JsonObject fullInfoPlayerSuite = parser.parse(responseS).getAsJsonObject();
			// String weight = fullInfoPlayerSuite.get("weight").getAsString().replace("kg",
			// "");
			String height = fullInfoPlayerSuite.get("height").getAsString().substring(5, 10).replace("(", "");
			String skillMove2 = fullInfoPlayerSuite.get("skillMove2").getAsString();
			String attWorkRate = fullInfoPlayerSuite.get("workRates").getAsString().split("/")[0];
			String defWorkRate = fullInfoPlayerSuite.get("workRates").getAsString().split("/")[1];
			String totalStats = fullInfoPlayerSuite.get("totalStats").getAsString();
			String clubName = fullInfoPlayerSuite.get("clubName").getAsString();

			JsonObject avgStats = fullInfoPlayerSuite.getAsJsonObject("avgStats");
			String pace = avgStats.get("avg1").getAsString();

			JsonObject stats = fullInfoPlayerSuite.getAsJsonObject("stats");
			String positioningGK = stats.get("gkp").getAsString();
			String reflexes = stats.get("ref").getAsString();
			String reactions = stats.get("rea").getAsString();
			String marking = stats.get("mrk").getAsString();
			String heading = stats.get("hea").getAsString();
			String acceleration = stats.get("acc").getAsString();
			String positioning = stats.get("pos").getAsString();
			String aggression = stats.get("agg").getAsString();
			String slidingTackle = stats.get("slt").getAsString();
			String interceptions = stats.get("awr").getAsString();
			String longShot = stats.get("lsa").getAsString();
			String shotPower = stats.get("sho").getAsString();
			String ballControl = stats.get("bac").getAsString();
			String shortPassing = stats.get("spa").getAsString();
			String longPassing = stats.get("lpa").getAsString();
			String sprintSpeed = stats.get("spd").getAsString();
			String dribbling = stats.get("dri").getAsString();
			String finishing = stats.get("fin").getAsString();

			String mainTrait = "";
			JsonArray traits = fullInfoPlayerSuite.getAsJsonArray("traits");
			for (JsonElement trait : traits) {
				mainTrait = trait.getAsString();
				if (mainTrait.toString().equalsIgnoreCase("null")) {
					mainTrait = "";
				}
				break;
			}

			playerData = clubName + "\t" + mainTrait + "\t" + height + "\t" + skillMove2 + "\t" + attWorkRate + "\t"
					+ defWorkRate + "\t" + totalStats + "\t" + positioningGK + "\t" + reflexes + "\t" + reactions + "\t"
					+ marking + "\t" + heading + "\t" + pace + "\t" + acceleration + "\t" + positioning + "\t"
					+ aggression + "\t" + slidingTackle + "\t" + interceptions + "\t" + longShot + "\t" + shotPower
					+ "\t" + ballControl + "\t" + shortPassing + "\t" + longPassing + "\t" + sprintSpeed + "\t"
					+ dribbling + "\t" + finishing + "\n";

			System.out.print(playerData);
		}
	}

}
