package com.fantasy.endpoints;

public class Endpoints {

	public static final String PLAYERS_ENDPOINT = "https://gaming.uefa.com/en/uclfantasy/services/feeds/players/players_30_en_1.json";
	public static final String PLAYER_POP_UP_STATS_ENDPOINT = "https://gaming.uefa.com/en/uclfantasy/services/feeds/popupstats/popupstats_30_playerid.json";
	public static final String FIXTURES_ENDPOINT = "https://gaming.uefa.com/en/uclfantasy/services/feeds/fixtures/fixtures_30_en.json";

	public static final String FIFA_MOBILE_ENDPOINT = "https://fifarenderz.com/backend/pages/player-list/21/filter";
	public static final String FIFA_MOBILE_REQUEST_BODY = "{\"sortDirection\":\"DESC\",\"sortType\":\"rating\",\"page\":pageNum,\"gkStats\":false}";
	public static final String FIFA_MOBILE_PLAYER_DATA = "https://fifarenderz.com/backend/pages/player/21/info?id=playerid";
}
