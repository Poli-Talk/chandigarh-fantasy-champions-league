package com.fantasy.engine;

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

public class StartEngine {

	public static void main(String[] args) {

		StartEngine startEngine = new StartEngine();

		Client client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();
		WebTarget target = client.target(Endpoints.PLAYERS_ENDPOINT);
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		String responseS = response.readEntity(String.class);
		// System.out.println(responseS);

		JsonParser parser = new JsonParser();
		JsonObject fullEndpointDataofAllPlayers = parser.parse(responseS).getAsJsonObject();
		JsonObject listofAllPlayersObject = fullEndpointDataofAllPlayers.getAsJsonObject("data").getAsJsonObject()
				.getAsJsonObject("value");
		JsonArray listofAllPlayersArray = listofAllPlayersObject.getAsJsonArray("playerList");

		for (JsonElement player : listofAllPlayersArray) {
			JsonObject playerObject = player.getAsJsonObject();
			String playerId = playerObject.get("id").getAsString();
			String playerFullName = playerObject.get("pFName").getAsString();
			String playerTeamName = playerObject.get("tName").getAsString();
			String playerPrice = playerObject.get("value").getAsString();
			String playerTotalPoints = playerObject.get("totPts").getAsString();
			String playerSkill = playerObject.get("skill").getAsString();
			System.out.print(playerId + "\t" + playerFullName + "\t" + playerTeamName + "\t"
					+ startEngine.returnFullSkillName(playerSkill) + "\t" + playerPrice + "\t" + playerTotalPoints
					+ "\t" + (Float.valueOf(playerTotalPoints) / Float.valueOf(playerPrice)) + "\t");
			startEngine.displayMatchDayPoints(startEngine.returnPlayerIdReplacedInEndpoint(playerId));
			System.out.println();
		}
	}

	public String returnPlayerIdReplacedInEndpoint(String id) {
		String localPlayerPopUpEndpoint = Endpoints.PLAYER_POP_UP_STATS_ENDPOINT;
		return localPlayerPopUpEndpoint.replaceAll("playerid", id);
	}

	public String returnFullSkillName(String skill) {
		switch (skill) {
		case "1":
			return "Goalkeeper";
		case "2":
			return "Defender";
		case "3":
			return "Midfielder";
		case "4":
			return "Forward";
		}
		return "";
	}

	public void displayMatchDayPoints(String playerPopUpEndpoint) {
		Client client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();
		WebTarget target = client.target(playerPopUpEndpoint);
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		String responseS = response.readEntity(String.class);
		// System.out.println(responseS);

		JsonParser parser = new JsonParser();
		JsonObject fullEndpointDataofPlayer = parser.parse(responseS).getAsJsonObject();
		JsonObject fullMatchdayPointsofPlayer = fullEndpointDataofPlayer.getAsJsonObject("data").getAsJsonObject()
				.getAsJsonObject("value").getAsJsonObject();
		JsonArray matchdayPoints = fullMatchdayPointsofPlayer.getAsJsonArray("matchdayPoints");

		if (matchdayPoints.size() > 0) {
			for (JsonElement matchday : matchdayPoints) {
				String eachMatchdayPoints;
				try {
					JsonObject eachmatchday = matchday.getAsJsonObject();
					eachMatchdayPoints = eachmatchday.get("tPoints").getAsString();
				} catch (IllegalStateException e) {
					eachMatchdayPoints = "0";
				}
				System.out.print(eachMatchdayPoints + "\t");
			}
		}
	}
}
