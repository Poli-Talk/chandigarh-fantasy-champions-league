package soccerway;

public class Pathways {

    //public static final String UCL_PAGE = "https://int.soccerway.com/national/europe/uefa-champions-league/20252026/league-stage/fc0a20b6-5d01-419b-ae18-e100da0fb506/tables/";
    public static final String UCL_PAGE = "https://www.soccerway.com/europe/champions-league/standings/#/UiRZST3U/standings/overall/";
    //public static final String XPATH_ALL_UCL_TEAMS_URLS = "//div[@id='page_competition_1_block_competition_matches_summary_10']//a[contains(@href,'teams')]";
//    public static final String XPATH_ALL_UCL_TEAMS_URLS = "//div[@class='sc-94e50ec4-0 jjgGhB']//a[@class='sc-22ef6ec-0 boVFdS']";
    public static final String XPATH_ALL_UCL_TEAMS_URLS = "//div[@class='ui-table']//a[@class='tableCellParticipant__name']";
    //public static final String XPATH_ALL_UCL_TEAMS_URLS = "//div[@class='sc-94e50ec4-0 jjgGhB']//a[contains(@href,'teams')";
    public static final String XPATH_SQUAD = "//a[contains(text(),'Squad')]";
    //public static final String XPATH_SQUAD = "(//span[contains(text(),'Squad')])[1]";
    public static final String XPATH_STATISTICS = "(//span[contains(text(),'Statistics')])[2]";
    //public static final String XPATH_STATS_TABLE_ROW_SIZE = "//div[@id='page_team_1_block_team_squad_7']//tr";
    //public static final String XPATH_TEMPLATE_SHIRT_NUMBER = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='shirtnumber']";
    //public static final String XPATH_TEMPLATE_NAME = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='name large-link']";
    //public static final String XPATH_TEMPLATE_AGE = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='number age']";
    public static final String XPATH_TEMPLATE_POSITION = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='position large-link']";
    //public static final String XPATH_TEMPLATE_MINUTES = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='number statistic game-minutes available']";
    //public static final String XPATH_TEMPLATE_APPEARANCE = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='number statistic appearances available']";
    //public static final String XPATH_TEMPLATE_LINEUP = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='number statistic lineups available']";
    //public static final String XPATH_TEMPLATE_SUB_IN = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='number statistic subs-in available']";
    //public static final String XPATH_TEMPLATE_SUB_OUT = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='number statistic subs-out available']";
    //public static final String XPATH_TEMPLATE_SUB_ON_BENCH = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='number statistic subs-on-bench available']";
    //public static final String XPATH_TEMPLATE_GOALS = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='number statistic goals available']";
    //public static final String XPATH_TEMPLATE_ASSISTS = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[contains(@class,'assists')]";
    //public static final String XPATH_TEMPLATE_YELLOW = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='number statistic yellow-cards available']";
    //public static final String XPATH_TEMPLATE_SECOND_YELLOW = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='number statistic 2nd-yellow-cards available']";
    //public static final String XPATH_TEMPLATE_RED = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='number statistic red-cards available']";
    //public static final String XPATH_TEAM_NAME = "//h1";
    public static final String XPATH_TEAM_NAME = "//div[@class='heading__name']";
    public static final String XPATH_CONSENT = "//p[contains(text(),'Consent')]";
    //public static final String XPATH_STATS_TABLE_ROW_SIZE = "//div[@class='sc-94e50ec4-0 wUawN body']";
    //public static final String XPATH_STATS_TABLE_ROW_SIZE = "//div[@id='league-04lKZTBr-table']";
    //public static final String XPATH_STATS_TABLE_ROW_SIZE = "//div[@class='lineup']";
    public static final String XPATH_STATS_TABLE_ROW_SIZE = "(//div[contains(@class,'squad-table')])[1]//div[@class='lineupTable__row']";
    //public static final String XPATH_TEMPLATE_SHIRT_NUMBER = "(//div[@class='sc-94e50ec4-0 wUawN body'])[ROW_NUM]//span[contains(@class,'jersay')]";
    public static final String XPATH_TEMPLATE_SHIRT_NUMBER = "((//div[contains(@class,'squad-table')])[1]//div[@class='lineupTable__row'])[ROW_NUM]//div[contains(@class,'lineupTable__cell--jersey')]";
    //public static final String XPATH_TEMPLATE_NAME = "(//div[@class='sc-94e50ec4-0 wUawN body'])[ROW_NUM]//span[contains(@class,'name more')]";
    public static final String XPATH_TEMPLATE_NAME = "((//div[contains(@class,'squad-table')])[1]//div[@class='lineupTable__row'])[ROW_NUM]//div[contains(@class,'lineupTable__cell--name')]";
    //public static final String XPATH_TEMPLATE_MINUTES = "(//div[@class='sc-94e50ec4-0 wUawN body'])[ROW_NUM]//span[contains(@class,'running-time-row')]";
    public static final String XPATH_TEMPLATE_MINUTES = "((//div[contains(@class,'squad-table')])[1]//div[@class='lineupTable__row'])[ROW_NUM]//div[contains(@class,'lineupTable__cell--minutesPlayed')]";
    //public static final String XPATH_TEMPLATE_AGE = "((//div[@class='sc-94e50ec4-0 wUawN body'])[ROW_NUM]//span[contains(@class,'item-row')])[1]";
    public static final String XPATH_TEMPLATE_AGE = "((//div[contains(@class,'squad-table')])[1]//div[@class='lineupTable__row'])[ROW_NUM]//div[contains(@class,'lineupTable__cell--age')]";
    //public static final String XPATH_TEMPLATE_APPEARANCE = "((//div[@class='sc-94e50ec4-0 wUawN body'])[ROW_NUM]//span[contains(@class,'item-row')])[2]";
    public static final String XPATH_TEMPLATE_APPEARANCE = "((//div[contains(@class,'squad-table')])[1]//div[@class='lineupTable__row'])[ROW_NUM]//div[contains(@class,'lineupTable__cell--matchesPlayed')]";
    public static final String XPATH_TEMPLATE_LINEUP = "((//div[@class='sc-94e50ec4-0 wUawN body'])[ROW_NUM]//span[contains(@class,'item-row')])[3]";
    public static final String XPATH_TEMPLATE_SUB_IN = "((//div[@class='sc-94e50ec4-0 wUawN body'])[ROW_NUM]//span[contains(@class,'item-row')])[4]";
    public static final String XPATH_TEMPLATE_SUB_OUT = "((//div[@class='sc-94e50ec4-0 wUawN body'])[ROW_NUM]//span[contains(@class,'item-row')])[5]";
    public static final String XPATH_TEMPLATE_SUB_ON_BENCH = "((//div[@class='sc-94e50ec4-0 wUawN body'])[ROW_NUM]//span[contains(@class,'item-row')])[6]";
    //public static final String XPATH_TEMPLATE_GOALS = "((//div[@class='sc-94e50ec4-0 wUawN body'])[ROW_NUM]//span[contains(@class,'item-row')])[7]";
    public static final String XPATH_TEMPLATE_GOALS = "((//div[contains(@class,'squad-table')])[1]//div[@class='lineupTable__row'])[ROW_NUM]//div[contains(@class,'lineupTable__cell--goal')]";
    //public static final String XPATH_TEMPLATE_ASSISTS = "((//div[@class='sc-94e50ec4-0 wUawN body'])[ROW_NUM]//span[contains(@class,'item-row')])[8]";
    public static final String XPATH_TEMPLATE_ASSISTS = "((//div[contains(@class,'squad-table')])[1]//div[@class='lineupTable__row'])[ROW_NUM]//div[contains(@class,'lineupTable__cell--assist')]";
    //public static final String XPATH_TEMPLATE_YELLOW = "((//div[@class='sc-94e50ec4-0 wUawN body'])[ROW_NUM]//span[contains(@class,'item-row')])[9]";
    public static final String XPATH_TEMPLATE_YELLOW = "((//div[contains(@class,'squad-table')])[1]//div[@class='lineupTable__row'])[ROW_NUM]//div[contains(@class,'lineupTable__cell--yellowCard')]";
    public static final String XPATH_TEMPLATE_SECOND_YELLOW = "((//div[@class='sc-94e50ec4-0 wUawN body'])[ROW_NUM]//span[contains(@class,'item-row')])[10]";
    //public static final String XPATH_TEMPLATE_RED = "((//div[@class='sc-94e50ec4-0 wUawN body'])[ROW_NUM]//span[contains(@class,'item-row')])[11]";
    public static final String XPATH_TEMPLATE_RED = "((//div[contains(@class,'squad-table')])[1]//div[@class='lineupTable__row'])[ROW_NUM]//div[contains(@class,'lineupTable__cell--redCard')]";
}


