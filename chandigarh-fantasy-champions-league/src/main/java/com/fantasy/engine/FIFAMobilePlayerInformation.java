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

	@SuppressWarnings({ "resource", "unused" })
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

			WebTarget target = client.target(fifaMobileRequestBody);
			Response response = target.request(MediaType.APPLICATION_JSON).get();
			String responseS = response.readEntity(String.class);
			// System.out.println(responseS);

			JsonParser parser = new JsonParser();
			JsonObject fullInfoPlayerSuite = parser.parse(responseS).getAsJsonObject();
			// String weight = fullInfoPlayerSuite.get("weight").getAsString().replace("kg",
			// "");
			String height = fullInfoPlayerSuite.get("height").getAsString().substring(5, 10).replace("(", "");
			String skillMove2 = fullInfoPlayerSuite.get("skillMove2").getAsString();
			String attWorkRate = fullInfoPlayerSuite.get("workRates").getAsString().split("/")[0];
			String defWorkRate = fullInfoPlayerSuite.get("workRates").getAsString().split("/")[1];
			String totalStats = fullInfoPlayerSuite.get("totalStats").getAsString();

			JsonObject stats = fullInfoPlayerSuite.getAsJsonObject("stats");
			String acceleration = stats.get("acc").getAsString();
			String aggression = stats.get("agg").getAsString();
			String agility = stats.get("agi").getAsString();
			String curve = stats.get("cur").getAsString();
			String dribbling = stats.get("dri").getAsString();
			String finishing = stats.get("fin").getAsString();
			String freeKick = stats.get("frk").getAsString();
			String heading = stats.get("hea").getAsString();
			String interceptions = stats.get("awr").getAsString();
			String jumping = stats.get("jmp").getAsString();
			String marking = stats.get("mrk").getAsString();
			String penalties = stats.get("pen").getAsString();
			String shotPower = stats.get("sho").getAsString();
			String sprintSpeed = stats.get("spd").getAsString();
			String strength = stats.get("str").getAsString();

			String mainTrait = "";
			JsonArray traits = fullInfoPlayerSuite.getAsJsonArray("traits");
			for (JsonElement trait : traits) {
				mainTrait = trait.getAsString();
				if (mainTrait.toString().equalsIgnoreCase("null")) {
					mainTrait = "";
				}
				break;
			}

			playerData = /* retrivedPlayerId + "\t" + */mainTrait + "\t" + height + "\t" + skillMove2 + "\t"
					+ attWorkRate + "\t" + defWorkRate + "\t" + totalStats + "\t" + acceleration + "\t" + aggression
					+ "\t" + agility + "\t" + curve + "\t" + dribbling + "\t" + finishing + "\t" + freeKick + "\t"
					+ heading + "\t" + interceptions + "\t" + jumping + "\t" + marking + "\t" + penalties + "\t"
					+ shotPower + "\t" + sprintSpeed + "\t" + strength + "\n";

			System.out.print(playerData);
		}
	}

}
