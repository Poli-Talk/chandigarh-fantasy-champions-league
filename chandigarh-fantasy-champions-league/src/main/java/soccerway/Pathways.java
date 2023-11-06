package soccerway;

public class Pathways {

    public static final String UCL_PAGE = "https://int.soccerway.com/international/europe/uefa-champions-league/20232024/group-stage/r77196/";
    public static final String XPATH_ALL_UCL_TEAMS_URLS = "//div[@id='page_competition_1_block_competition_matches_summary_9']//a[contains(@href,'teams')]";
    public static final String XPATH_SQUAD = "//a[contains(text(),'Squad')]";
    public static final String XPATH_STATS_TABLE_ROW_SIZE = "//div[@id='page_team_1_block_team_squad_7']//tr";
    public static final String XPATH_TEMPLATE_SHIRT_NUMBER = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='shirtnumber']";
    public static final String XPATH_TEMPLATE_NAME = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='name large-link']";
    public static final String XPATH_TEMPLATE_AGE = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='number age']";
    public static final String XPATH_TEMPLATE_POSITION = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='position large-link']";
    public static final String XPATH_TEMPLATE_MINUTES = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='number statistic game-minutes available']";
    public static final String XPATH_TEMPLATE_APPEARANCE = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='number statistic appearances available']";
    public static final String XPATH_TEMPLATE_LINEUP = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='number statistic lineups available']";
    public static final String XPATH_TEMPLATE_SUB_IN = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='number statistic subs-in available']";
    public static final String XPATH_TEMPLATE_SUB_OUT = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='number statistic subs-out available']";
    public static final String XPATH_TEMPLATE_SUB_ON_BENCH = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='number statistic subs-on-bench available']";
    public static final String XPATH_TEMPLATE_GOALS = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='number statistic goals available']";
    public static final String XPATH_TEMPLATE_ASSISTS = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[contains(@class,'assists')]";
    public static final String XPATH_TEMPLATE_YELLOW = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='number statistic yellow-cards available']";
    public static final String XPATH_TEMPLATE_SECOND_YELLOW = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='number statistic 2nd-yellow-cards available']";
    public static final String XPATH_TEMPLATE_RED = "((//div[@id='page_team_1_block_team_squad_7']//tr)[ROW_NUM])//td[@class='number statistic red-cards available']";
    public static final String XPATH_TEAM_NAME = "//h1";

}
