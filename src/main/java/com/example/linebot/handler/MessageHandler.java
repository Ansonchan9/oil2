package com.example.linebot.handler;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Component
public class MessageHandler {
	private OkHttpClient client = new OkHttpClient();
	@Value("${line.user.channel.token}")
	private String LINE_TOKEN;

	public void doAction(JSONObject event) throws IOException {
		switch (event.getJSONObject("message").getString("type")) {
		case "text":
			text(event.getString("replyToken"), event.getJSONObject("message").getString("text"));
			break;
		case "sticker":
			sticker(event.getString("replyToken"), event.getJSONObject("message").getString("packageId"),
					event.getJSONObject("message").getString("stickerId"));
			break;
		}
	}

	private void text(String replyToken, String text) throws IOException {

		Document document = Jsoup.connect("https://gas.goodlife.tw/").get();
		Element items = document.getElementById("fixlayer");
		Document document1 = Jsoup.connect("https://music-tw.line.me/chart/99").get();
		Element items1 = document1.getElementById("content");
//花蓮縣
		Document document2 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E8%8A%B1%E8%93%AE%E7%B8%A3").get();
		Elements items2 = document2.getElementsByTag("dataset");
		for (Element item2 : items2) {
			String list = item2.getElementsByTag("datasetDescription").get(0).text();
			String loca21 = item2.getElementsByTag("locationName").get(0).text();
			String st21 = item2.getElementsByTag("startTime").get(0).text();
			String et21 = item2.getElementsByTag("endTime").get(0).text();
			String st22 = item2.getElementsByTag("startTime").get(1).text();
			String et22 = item2.getElementsByTag("endTime").get(1).text();
			String st23 = item2.getElementsByTag("startTime").get(2).text();
			String et23 = item2.getElementsByTag("endTime").get(2).text();
			String wx21 = item2.getElementsByTag("parameterName").get(0).text();
			String wx22 = item2.getElementsByTag("parameterName").get(1).text();
			String wx23 = item2.getElementsByTag("parameterName").get(2).text();
			String pop21 = item2.getElementsByTag("parameterName").get(3).text();
			String pop22 = item2.getElementsByTag("parameterName").get(4).text();
			String pop23 = item2.getElementsByTag("parameterName").get(5).text();
			String mt21 = item2.getElementsByTag("parameterName").get(6).text();
			String mt22 = item2.getElementsByTag("parameterName").get(7).text();
			String mt23 = item2.getElementsByTag("parameterName").get(8).text();
			String ht21 = item2.getElementsByTag("parameterName").get(12).text();
			String ht22 = item2.getElementsByTag("parameterName").get(13).text();
			String ht23 = item2.getElementsByTag("parameterName").get(14).text();
			String ci21 = item2.getElementsByTag("parameterName").get(9).text();
			String ci22 = item2.getElementsByTag("parameterName").get(10).text();
			String ci23 = item2.getElementsByTag("parameterName").get(11).text();
//臺東縣
		Document document3 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E8%87%BA%E6%9D%B1%E7%B8%A3").get();
		Elements items3 = document3.getElementsByTag("dataset");
		for (Element item3 : items3) {
			String loca31 = item3.getElementsByTag("locationName").get(0).text();
			String st31 = item3.getElementsByTag("startTime").get(0).text();
			String et31 = item3.getElementsByTag("endTime").get(0).text();
			String st32 = item3.getElementsByTag("startTime").get(1).text();
			String et32 = item3.getElementsByTag("endTime").get(1).text();
			String st33 = item3.getElementsByTag("startTime").get(2).text();
			String et33 = item3.getElementsByTag("endTime").get(2).text();
			String wx31 = item3.getElementsByTag("parameterName").get(0).text();
			String wx32 = item3.getElementsByTag("parameterName").get(1).text();
			String wx33 = item3.getElementsByTag("parameterName").get(2).text();
			String pop31 = item3.getElementsByTag("parameterName").get(3).text();
			String pop32 = item3.getElementsByTag("parameterName").get(4).text();
			String pop33 = item3.getElementsByTag("parameterName").get(5).text();
			String mt31 = item3.getElementsByTag("parameterName").get(6).text();
			String mt32 = item3.getElementsByTag("parameterName").get(7).text();
			String mt33 = item3.getElementsByTag("parameterName").get(8).text();
			String ht31 = item3.getElementsByTag("parameterName").get(12).text();
			String ht32 = item3.getElementsByTag("parameterName").get(13).text();
			String ht33 = item3.getElementsByTag("parameterName").get(14).text();
			String ci31 = item3.getElementsByTag("parameterName").get(9).text();
			String ci32 = item3.getElementsByTag("parameterName").get(10).text();
			String ci33 = item3.getElementsByTag("parameterName").get(11).text();
//澎湖縣
		Document document4 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E6%BE%8E%E6%B9%96%E7%B8%A3").get();
		Elements items4 = document4.getElementsByTag("dataset");
		for (Element item4 : items4) {
			String loca41 = item4.getElementsByTag("locationName").get(0).text();
			String st41 = item4.getElementsByTag("startTime").get(0).text();
			String et41 = item4.getElementsByTag("endTime").get(0).text();
			String st42 = item4.getElementsByTag("startTime").get(1).text();
			String et42 = item4.getElementsByTag("endTime").get(1).text();
			String st43 = item4.getElementsByTag("startTime").get(2).text();
			String et43 = item4.getElementsByTag("endTime").get(2).text();
			String wx41 = item4.getElementsByTag("parameterName").get(0).text();
			String wx42 = item4.getElementsByTag("parameterName").get(1).text();
			String wx43 = item4.getElementsByTag("parameterName").get(2).text();
			String pop41 = item4.getElementsByTag("parameterName").get(3).text();
			String pop42 = item4.getElementsByTag("parameterName").get(4).text();
			String pop43 = item4.getElementsByTag("parameterName").get(5).text();
			String mt41 = item4.getElementsByTag("parameterName").get(6).text();
			String mt42 = item4.getElementsByTag("parameterName").get(7).text();
			String mt43 = item4.getElementsByTag("parameterName").get(8).text();
			String ht41 = item4.getElementsByTag("parameterName").get(12).text();
			String ht42 = item4.getElementsByTag("parameterName").get(13).text();
			String ht43 = item4.getElementsByTag("parameterName").get(14).text();
			String ci41 = item4.getElementsByTag("parameterName").get(9).text();
			String ci42 = item4.getElementsByTag("parameterName").get(10).text();
			String ci43 = item4.getElementsByTag("parameterName").get(11).text();
//金門縣
		Document document5 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E9%87%91%E9%96%80%E7%B8%A3").get();
		Elements items5 = document5.getElementsByTag("dataset");
		for (Element item5 : items5) {
			String loca51 = item5.getElementsByTag("locationName").get(0).text();
			String st51 = item5.getElementsByTag("startTime").get(0).text();
			String et51 = item5.getElementsByTag("endTime").get(0).text();
			String st52 = item5.getElementsByTag("startTime").get(1).text();
			String et52 = item5.getElementsByTag("endTime").get(1).text();
			String st53 = item5.getElementsByTag("startTime").get(2).text();
			String et53 = item5.getElementsByTag("endTime").get(2).text();
			String wx51 = item5.getElementsByTag("parameterName").get(0).text();
			String wx52 = item5.getElementsByTag("parameterName").get(1).text();
			String wx53 = item5.getElementsByTag("parameterName").get(2).text();
			String pop51 = item5.getElementsByTag("parameterName").get(3).text();
			String pop52 = item5.getElementsByTag("parameterName").get(4).text();
			String pop53 = item5.getElementsByTag("parameterName").get(5).text();
			String mt51 = item5.getElementsByTag("parameterName").get(6).text();
			String mt52 = item5.getElementsByTag("parameterName").get(7).text();
			String mt53 = item5.getElementsByTag("parameterName").get(8).text();
			String ht51 = item5.getElementsByTag("parameterName").get(12).text();
			String ht52 = item5.getElementsByTag("parameterName").get(13).text();
			String ht53 = item5.getElementsByTag("parameterName").get(14).text();
			String ci51 = item5.getElementsByTag("parameterName").get(9).text();
			String ci52 = item5.getElementsByTag("parameterName").get(10).text();
			String ci53 = item5.getElementsByTag("parameterName").get(11).text();
//連江縣
		Document document6 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E9%80%A3%E6%B1%9F%E7%B8%A3").get();
		Elements items6 = document6.getElementsByTag("dataset");
		for (Element item6 : items6) {
			String loca61 = item6.getElementsByTag("locationName").get(0).text();
			String st61 = item6.getElementsByTag("startTime").get(0).text();
			String et61 = item6.getElementsByTag("endTime").get(0).text();
			String st62 = item6.getElementsByTag("startTime").get(1).text();
			String et62 = item6.getElementsByTag("endTime").get(1).text();
			String st63 = item6.getElementsByTag("startTime").get(2).text();
			String et63 = item6.getElementsByTag("endTime").get(2).text();
			String wx61 = item6.getElementsByTag("parameterName").get(0).text();
			String wx62 = item6.getElementsByTag("parameterName").get(1).text();
			String wx63 = item6.getElementsByTag("parameterName").get(2).text();
			String pop61 = item6.getElementsByTag("parameterName").get(3).text();
			String pop62 = item6.getElementsByTag("parameterName").get(4).text();
			String pop63 = item6.getElementsByTag("parameterName").get(5).text();
			String mt61 = item6.getElementsByTag("parameterName").get(6).text();
			String mt62 = item6.getElementsByTag("parameterName").get(7).text();
			String mt63 = item6.getElementsByTag("parameterName").get(8).text();
			String ht61 = item6.getElementsByTag("parameterName").get(12).text();
			String ht62 = item6.getElementsByTag("parameterName").get(13).text();
			String ht63 = item6.getElementsByTag("parameterName").get(14).text();
			String ci61 = item6.getElementsByTag("parameterName").get(9).text();
			String ci62 = item6.getElementsByTag("parameterName").get(10).text();
			String ci63 = item6.getElementsByTag("parameterName").get(11).text();
//臺北市
		Document document7 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E8%87%BA%E5%8C%97%E5%B8%82").get();
		Elements items7 = document7.getElementsByTag("dataset");
		for (Element item7 : items7) {
			String loca71 = item7.getElementsByTag("locationName").get(0).text();
			String st71 = item7.getElementsByTag("startTime").get(0).text();
			String et71 = item7.getElementsByTag("endTime").get(0).text();
			String st72 = item7.getElementsByTag("startTime").get(1).text();
			String et72 = item7.getElementsByTag("endTime").get(1).text();
			String st73 = item7.getElementsByTag("startTime").get(2).text();
			String et73 = item7.getElementsByTag("endTime").get(2).text();
			String wx71 = item7.getElementsByTag("parameterName").get(0).text();
			String wx72 = item7.getElementsByTag("parameterName").get(1).text();
			String wx73 = item7.getElementsByTag("parameterName").get(2).text();
			String pop71 = item7.getElementsByTag("parameterName").get(3).text();
			String pop72 = item7.getElementsByTag("parameterName").get(4).text();
			String pop73 = item7.getElementsByTag("parameterName").get(5).text();
			String mt71 = item7.getElementsByTag("parameterName").get(6).text();
			String mt72 = item7.getElementsByTag("parameterName").get(7).text();
			String mt73 = item7.getElementsByTag("parameterName").get(8).text();
			String ht71 = item7.getElementsByTag("parameterName").get(12).text();
			String ht72 = item7.getElementsByTag("parameterName").get(13).text();
			String ht73 = item7.getElementsByTag("parameterName").get(14).text();
			String ci71 = item7.getElementsByTag("parameterName").get(9).text();
			String ci72 = item7.getElementsByTag("parameterName").get(10).text();
			String ci73 = item7.getElementsByTag("parameterName").get(11).text();
//新北市
		Document document8 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E8%87%BA%E5%8C%97%E5%B8%82").get();
		Elements items8 = document8.getElementsByTag("dataset");
		for (Element item8 : items8) {
			String loca81 = item8.getElementsByTag("locationName").get(0).text();
			String st81 = item8.getElementsByTag("startTime").get(0).text();
			String et81 = item8.getElementsByTag("endTime").get(0).text();
			String st82 = item8.getElementsByTag("startTime").get(1).text();
			String et82 = item8.getElementsByTag("endTime").get(1).text();
			String st83 = item8.getElementsByTag("startTime").get(2).text();
			String et83 = item8.getElementsByTag("endTime").get(2).text();
			String wx81 = item8.getElementsByTag("parameterName").get(0).text();
			String wx82 = item8.getElementsByTag("parameterName").get(1).text();
			String wx83 = item8.getElementsByTag("parameterName").get(2).text();
			String pop81 = item8.getElementsByTag("parameterName").get(3).text();
			String pop82 = item8.getElementsByTag("parameterName").get(4).text();
			String pop83 = item8.getElementsByTag("parameterName").get(5).text();
			String mt81 = item8.getElementsByTag("parameterName").get(6).text();
			String mt82 = item8.getElementsByTag("parameterName").get(7).text();
			String mt83 = item8.getElementsByTag("parameterName").get(8).text();
			String ht81 = item8.getElementsByTag("parameterName").get(12).text();
			String ht82 = item8.getElementsByTag("parameterName").get(13).text();
			String ht83 = item8.getElementsByTag("parameterName").get(14).text();
			String ci81 = item8.getElementsByTag("parameterName").get(9).text();
			String ci82 = item8.getElementsByTag("parameterName").get(10).text();
			String ci83 = item8.getElementsByTag("parameterName").get(11).text();
//桃園市
		Document document9 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E6%A1%83%E5%9C%92%E5%B8%82").get();
		Elements items9 = document9.getElementsByTag("dataset");
		for (Element item9 : items9) {
			String loca91 = item9.getElementsByTag("locationName").get(0).text();
			String st91 = item9.getElementsByTag("startTime").get(0).text();
			String et91 = item9.getElementsByTag("endTime").get(0).text();
			String st92 = item9.getElementsByTag("startTime").get(1).text();
			String et92 = item9.getElementsByTag("endTime").get(1).text();
			String st93 = item9.getElementsByTag("startTime").get(2).text();
			String et93 = item9.getElementsByTag("endTime").get(2).text();
			String wx91 = item9.getElementsByTag("parameterName").get(0).text();
			String wx92 = item9.getElementsByTag("parameterName").get(1).text();
			String wx93 = item9.getElementsByTag("parameterName").get(2).text();
			String pop91 = item9.getElementsByTag("parameterName").get(3).text();
			String pop92 = item9.getElementsByTag("parameterName").get(4).text();
			String pop93 = item9.getElementsByTag("parameterName").get(5).text();
			String mt91 = item9.getElementsByTag("parameterName").get(6).text();
			String mt92 = item9.getElementsByTag("parameterName").get(7).text();
			String mt93 = item9.getElementsByTag("parameterName").get(8).text();
			String ht91 = item9.getElementsByTag("parameterName").get(12).text();
			String ht92 = item9.getElementsByTag("parameterName").get(13).text();
			String ht93 = item9.getElementsByTag("parameterName").get(14).text();
			String ci91 = item9.getElementsByTag("parameterName").get(9).text();
			String ci92 = item9.getElementsByTag("parameterName").get(10).text();
			String ci93 = item9.getElementsByTag("parameterName").get(11).text();
//台南市
		Document document10 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E8%87%BA%E5%8D%97%E5%B8%82").get();
		Elements items10 = document10.getElementsByTag("dataset");
		for (Element item10 : items10) {
			String loca101 = item10.getElementsByTag("locationName").get(0).text();
			String st101 = item10.getElementsByTag("startTime").get(0).text();
			String et101 = item10.getElementsByTag("endTime").get(0).text();
			String st102 = item10.getElementsByTag("startTime").get(1).text();
			String et102 = item10.getElementsByTag("endTime").get(1).text();
			String st103 = item10.getElementsByTag("startTime").get(2).text();
			String et103 = item10.getElementsByTag("endTime").get(2).text();
			String wx101 = item10.getElementsByTag("parameterName").get(0).text();
			String wx102 = item10.getElementsByTag("parameterName").get(1).text();
			String wx103 = item10.getElementsByTag("parameterName").get(2).text();
			String pop101 = item10.getElementsByTag("parameterName").get(3).text();
			String pop102 = item10.getElementsByTag("parameterName").get(4).text();
			String pop103 = item10.getElementsByTag("parameterName").get(5).text();
			String mt101 = item10.getElementsByTag("parameterName").get(6).text();
			String mt102 = item10.getElementsByTag("parameterName").get(7).text();
			String mt103 = item10.getElementsByTag("parameterName").get(8).text();
			String ht101 = item10.getElementsByTag("parameterName").get(12).text();
			String ht102 = item10.getElementsByTag("parameterName").get(13).text();
			String ht103 = item10.getElementsByTag("parameterName").get(14).text();
			String ci101 = item10.getElementsByTag("parameterName").get(9).text();
			String ci102 = item10.getElementsByTag("parameterName").get(10).text();
			String ci103 = item10.getElementsByTag("parameterName").get(11).text();
//高雄市
		Document document11 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E9%AB%98%E9%9B%84%E5%B8%82").get();
		Elements items11 = document11.getElementsByTag("dataset");
		for (Element item11 : items11) {
			String loca111 = item11.getElementsByTag("locationName").get(0).text();
			String st111 = item11.getElementsByTag("startTime").get(0).text();
			String et111 = item11.getElementsByTag("endTime").get(0).text();
			String st112 = item11.getElementsByTag("startTime").get(1).text();
			String et112 = item11.getElementsByTag("endTime").get(1).text();
			String st113 = item11.getElementsByTag("startTime").get(2).text();
			String et113 = item11.getElementsByTag("endTime").get(2).text();
			String wx111 = item11.getElementsByTag("parameterName").get(0).text();
			String wx112 = item11.getElementsByTag("parameterName").get(1).text();
			String wx113 = item11.getElementsByTag("parameterName").get(2).text();
			String pop111 = item11.getElementsByTag("parameterName").get(3).text();
			String pop112 = item11.getElementsByTag("parameterName").get(4).text();
			String pop113 = item11.getElementsByTag("parameterName").get(5).text();
			String mt111 = item11.getElementsByTag("parameterName").get(6).text();
			String mt112 = item11.getElementsByTag("parameterName").get(7).text();
			String mt113 = item11.getElementsByTag("parameterName").get(8).text();
			String ht111 = item11.getElementsByTag("parameterName").get(12).text();
			String ht112 = item11.getElementsByTag("parameterName").get(13).text();
			String ht113 = item11.getElementsByTag("parameterName").get(14).text();
			String ci111 = item11.getElementsByTag("parameterName").get(9).text();
			String ci112 = item11.getElementsByTag("parameterName").get(10).text();
			String ci113 = item11.getElementsByTag("parameterName").get(11).text();
//基隆市
		Document document12 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E5%9F%BA%E9%9A%86%E5%B8%82").get();
		Elements items12 = document12.getElementsByTag("dataset");
		for (Element item12 : items12) {
			String loca121 = item12.getElementsByTag("locationName").get(0).text();
			String st121 = item12.getElementsByTag("startTime").get(0).text();
			String et121 = item12.getElementsByTag("endTime").get(0).text();
			String st122 = item12.getElementsByTag("startTime").get(1).text();
			String et122 = item12.getElementsByTag("endTime").get(1).text();
			String st123 = item12.getElementsByTag("startTime").get(2).text();
			String et123 = item12.getElementsByTag("endTime").get(2).text();
			String wx121 = item12.getElementsByTag("parameterName").get(0).text();
			String wx122 = item12.getElementsByTag("parameterName").get(1).text();
			String wx123 = item12.getElementsByTag("parameterName").get(2).text();
			String pop121 = item12.getElementsByTag("parameterName").get(3).text();
			String pop122 = item12.getElementsByTag("parameterName").get(4).text();
			String pop123 = item12.getElementsByTag("parameterName").get(5).text();
			String mt121 = item12.getElementsByTag("parameterName").get(6).text();
			String mt122 = item12.getElementsByTag("parameterName").get(7).text();
			String mt123 = item12.getElementsByTag("parameterName").get(8).text();
			String ht121 = item12.getElementsByTag("parameterName").get(12).text();
			String ht122 = item12.getElementsByTag("parameterName").get(13).text();
			String ht123 = item12.getElementsByTag("parameterName").get(14).text();
			String ci121 = item12.getElementsByTag("parameterName").get(9).text();
			String ci122 = item12.getElementsByTag("parameterName").get(10).text();
			String ci123 = item12.getElementsByTag("parameterName").get(11).text();
//新竹縣
		Document document13 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E6%96%B0%E7%AB%B9%E7%B8%A3").get();
		Elements items13 = document13.getElementsByTag("dataset");
		for (Element item13 : items13) {
			String loca131 = item13.getElementsByTag("locationName").get(0).text();
			String st131 = item13.getElementsByTag("startTime").get(0).text();
			String et131 = item13.getElementsByTag("endTime").get(0).text();
			String st132 = item13.getElementsByTag("startTime").get(1).text();
			String et132 = item13.getElementsByTag("endTime").get(1).text();
			String st133 = item13.getElementsByTag("startTime").get(2).text();
			String et133 = item13.getElementsByTag("endTime").get(2).text();
			String wx131 = item13.getElementsByTag("parameterName").get(0).text();
			String wx132 = item13.getElementsByTag("parameterName").get(1).text();
			String wx133 = item13.getElementsByTag("parameterName").get(2).text();
			String pop131 = item13.getElementsByTag("parameterName").get(3).text();
			String pop132 = item13.getElementsByTag("parameterName").get(4).text();
			String pop133 = item13.getElementsByTag("parameterName").get(5).text();
			String mt131 = item13.getElementsByTag("parameterName").get(6).text();
			String mt132 = item13.getElementsByTag("parameterName").get(7).text();
			String mt133 = item13.getElementsByTag("parameterName").get(8).text();
			String ht131 = item13.getElementsByTag("parameterName").get(12).text();
			String ht132 = item13.getElementsByTag("parameterName").get(13).text();
			String ht133 = item13.getElementsByTag("parameterName").get(14).text();
			String ci131 = item13.getElementsByTag("parameterName").get(9).text();
			String ci132 = item13.getElementsByTag("parameterName").get(10).text();
			String ci133 = item13.getElementsByTag("parameterName").get(11).text();
//新竹市
		Document document14 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E6%96%B0%E7%AB%B9%E5%B8%82").get();
		Elements items14 = document14.getElementsByTag("dataset");
		for (Element item14 : items14) {
			String loca141 = item14.getElementsByTag("locationName").get(0).text();
			String st141 = item14.getElementsByTag("startTime").get(0).text();
			String et141 = item14.getElementsByTag("endTime").get(0).text();
			String st142 = item14.getElementsByTag("startTime").get(1).text();
			String et142 = item14.getElementsByTag("endTime").get(1).text();
			String st143 = item14.getElementsByTag("startTime").get(2).text();
			String et143 = item14.getElementsByTag("endTime").get(2).text();
			String wx141 = item14.getElementsByTag("parameterName").get(0).text();
			String wx142 = item14.getElementsByTag("parameterName").get(1).text();
			String wx143 = item14.getElementsByTag("parameterName").get(2).text();
			String pop141 = item14.getElementsByTag("parameterName").get(3).text();
			String pop142 = item14.getElementsByTag("parameterName").get(4).text();
			String pop143 = item14.getElementsByTag("parameterName").get(5).text();
			String mt141 = item14.getElementsByTag("parameterName").get(6).text();
			String mt142 = item14.getElementsByTag("parameterName").get(7).text();
			String mt143 = item14.getElementsByTag("parameterName").get(8).text();
			String ht141 = item14.getElementsByTag("parameterName").get(12).text();
			String ht142 = item14.getElementsByTag("parameterName").get(13).text();
			String ht143 = item14.getElementsByTag("parameterName").get(14).text();
			String ci141 = item14.getElementsByTag("parameterName").get(9).text();
			String ci142 = item14.getElementsByTag("parameterName").get(10).text();
			String ci143 = item14.getElementsByTag("parameterName").get(11).text();
//苗栗縣
		Document document15 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E8%8B%97%E6%A0%97%E7%B8%A3").get();
		Elements items15 = document15.getElementsByTag("dataset");
		for (Element item15 : items15) {
			String loca151 = item15.getElementsByTag("locationName").get(0).text();
			String st151 = item15.getElementsByTag("startTime").get(0).text();
			String et151 = item15.getElementsByTag("endTime").get(0).text();
			String st152 = item15.getElementsByTag("startTime").get(1).text();
			String et152 = item15.getElementsByTag("endTime").get(1).text();
			String st153 = item15.getElementsByTag("startTime").get(2).text();
			String et153 = item15.getElementsByTag("endTime").get(2).text();
			String wx151 = item15.getElementsByTag("parameterName").get(0).text();
			String wx152 = item15.getElementsByTag("parameterName").get(1).text();
			String wx153 = item15.getElementsByTag("parameterName").get(2).text();
			String pop151 = item15.getElementsByTag("parameterName").get(3).text();
			String pop152 = item15.getElementsByTag("parameterName").get(4).text();
			String pop153 = item15.getElementsByTag("parameterName").get(5).text();
			String mt151 = item15.getElementsByTag("parameterName").get(6).text();
			String mt152 = item15.getElementsByTag("parameterName").get(7).text();
			String mt153 = item15.getElementsByTag("parameterName").get(8).text();
			String ht151 = item15.getElementsByTag("parameterName").get(12).text();
			String ht152 = item15.getElementsByTag("parameterName").get(13).text();
			String ht153 = item15.getElementsByTag("parameterName").get(14).text();
			String ci151 = item15.getElementsByTag("parameterName").get(9).text();
			String ci152 = item15.getElementsByTag("parameterName").get(10).text();
			String ci153 = item15.getElementsByTag("parameterName").get(11).text();
//彰化縣
		Document document16 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E5%BD%B0%E5%8C%96%E7%B8%A3").get();
		Elements items16 = document16.getElementsByTag("dataset");
		for (Element item16 : items16) {
			String loca161 = item16.getElementsByTag("locationName").get(0).text();
			String st161 = item16.getElementsByTag("startTime").get(0).text();
			String et161 = item16.getElementsByTag("endTime").get(0).text();
			String st162 = item16.getElementsByTag("startTime").get(1).text();
			String et162 = item16.getElementsByTag("endTime").get(1).text();
			String st163 = item16.getElementsByTag("startTime").get(2).text();
			String et163 = item16.getElementsByTag("endTime").get(2).text();
			String wx161 = item16.getElementsByTag("parameterName").get(0).text();
			String wx162 = item16.getElementsByTag("parameterName").get(1).text();
			String wx163 = item16.getElementsByTag("parameterName").get(2).text();
			String pop161 = item16.getElementsByTag("parameterName").get(3).text();
			String pop162 = item16.getElementsByTag("parameterName").get(4).text();
			String pop163 = item16.getElementsByTag("parameterName").get(5).text();
			String mt161 = item16.getElementsByTag("parameterName").get(6).text();
			String mt162 = item16.getElementsByTag("parameterName").get(7).text();
			String mt163 = item16.getElementsByTag("parameterName").get(8).text();
			String ht161 = item16.getElementsByTag("parameterName").get(12).text();
			String ht162 = item16.getElementsByTag("parameterName").get(13).text();
			String ht163 = item16.getElementsByTag("parameterName").get(14).text();
			String ci161 = item16.getElementsByTag("parameterName").get(9).text();
			String ci162 = item16.getElementsByTag("parameterName").get(10).text();
			String ci163 = item16.getElementsByTag("parameterName").get(11).text();
//南投縣
		Document document17 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E5%8D%97%E6%8A%95%E7%B8%A3").get();
		Elements items17 = document17.getElementsByTag("dataset");
		for (Element item17 : items17) {
			String loca171 = item17.getElementsByTag("locationName").get(0).text();
			String st171 = item17.getElementsByTag("startTime").get(0).text();
			String et171 = item17.getElementsByTag("endTime").get(0).text();
			String st172 = item17.getElementsByTag("startTime").get(1).text();
			String et172 = item17.getElementsByTag("endTime").get(1).text();
			String st173 = item17.getElementsByTag("startTime").get(2).text();
			String et173 = item17.getElementsByTag("endTime").get(2).text();
			String wx171 = item17.getElementsByTag("parameterName").get(0).text();
			String wx172 = item17.getElementsByTag("parameterName").get(1).text();
			String wx173 = item17.getElementsByTag("parameterName").get(2).text();
			String pop171 = item17.getElementsByTag("parameterName").get(3).text();
			String pop172 = item17.getElementsByTag("parameterName").get(4).text();
			String pop173 = item17.getElementsByTag("parameterName").get(5).text();
			String mt171 = item17.getElementsByTag("parameterName").get(6).text();
			String mt172 = item17.getElementsByTag("parameterName").get(7).text();
			String mt173 = item17.getElementsByTag("parameterName").get(8).text();
			String ht171 = item17.getElementsByTag("parameterName").get(12).text();
			String ht172 = item17.getElementsByTag("parameterName").get(13).text();
			String ht173 = item17.getElementsByTag("parameterName").get(14).text();
			String ci171 = item17.getElementsByTag("parameterName").get(9).text();
			String ci172 = item17.getElementsByTag("parameterName").get(10).text();
			String ci173 = item17.getElementsByTag("parameterName").get(11).text();
//雲林縣
		Document document18 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E9%9B%B2%E6%9E%97%E7%B8%A3").get();
		Elements items18 = document18.getElementsByTag("dataset");
		for (Element item18 : items18) {
			String loca181 = item18.getElementsByTag("locationName").get(0).text();
			String st181 = item18.getElementsByTag("startTime").get(0).text();
			String et181 = item18.getElementsByTag("endTime").get(0).text();
			String st182 = item18.getElementsByTag("startTime").get(1).text();
			String et182 = item18.getElementsByTag("endTime").get(1).text();
			String st183 = item18.getElementsByTag("startTime").get(2).text();
			String et183 = item18.getElementsByTag("endTime").get(2).text();
			String wx181 = item18.getElementsByTag("parameterName").get(0).text();
			String wx182 = item18.getElementsByTag("parameterName").get(1).text();
			String wx183 = item18.getElementsByTag("parameterName").get(2).text();
			String pop181 = item18.getElementsByTag("parameterName").get(3).text();
			String pop182 = item18.getElementsByTag("parameterName").get(4).text();
			String pop183 = item18.getElementsByTag("parameterName").get(5).text();
			String mt181 = item18.getElementsByTag("parameterName").get(6).text();
			String mt182 = item18.getElementsByTag("parameterName").get(7).text();
			String mt183 = item18.getElementsByTag("parameterName").get(8).text();
			String ht181 = item18.getElementsByTag("parameterName").get(12).text();
			String ht182 = item18.getElementsByTag("parameterName").get(13).text();
			String ht183 = item18.getElementsByTag("parameterName").get(14).text();
			String ci181 = item18.getElementsByTag("parameterName").get(9).text();
			String ci182 = item18.getElementsByTag("parameterName").get(10).text();
			String ci183 = item18.getElementsByTag("parameterName").get(11).text();
//嘉義縣
			Document document19 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E5%98%89%E7%BE%A9%E7%B8%A3").get();
			Elements items19 = document19.getElementsByTag("dataset");
			for (Element item19 : items19) {
				String loca191 = item19.getElementsByTag("locationName").get(0).text();
				String st191 = item19.getElementsByTag("startTime").get(0).text();
				String et191 = item19.getElementsByTag("endTime").get(0).text();
				String st192 = item19.getElementsByTag("startTime").get(1).text();
				String et192 = item19.getElementsByTag("endTime").get(1).text();
				String st193 = item19.getElementsByTag("startTime").get(2).text();
				String et193 = item19.getElementsByTag("endTime").get(2).text();
				String wx191 = item19.getElementsByTag("parameterName").get(0).text();
				String wx192 = item19.getElementsByTag("parameterName").get(1).text();
				String wx193 = item19.getElementsByTag("parameterName").get(2).text();
				String pop191 = item19.getElementsByTag("parameterName").get(3).text();
				String pop192 = item19.getElementsByTag("parameterName").get(4).text();
				String pop193 = item19.getElementsByTag("parameterName").get(5).text();
				String mt191 = item19.getElementsByTag("parameterName").get(6).text();
				String mt192 = item19.getElementsByTag("parameterName").get(7).text();
				String mt193 = item19.getElementsByTag("parameterName").get(8).text();
				String ht191 = item19.getElementsByTag("parameterName").get(12).text();
				String ht192 = item19.getElementsByTag("parameterName").get(13).text();
				String ht193 = item19.getElementsByTag("parameterName").get(14).text();
				String ci191 = item19.getElementsByTag("parameterName").get(9).text();
				String ci192 = item19.getElementsByTag("parameterName").get(10).text();
				String ci193 = item19.getElementsByTag("parameterName").get(11).text();
//嘉義市
		Document document20 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E5%98%89%E7%BE%A9%E5%B8%82").get();
		Elements items20 = document20.getElementsByTag("dataset");
		for (Element item20 : items20) {
			String loca201 = item20.getElementsByTag("locationName").get(0).text();
			String st201 = item20.getElementsByTag("startTime").get(0).text();
			String et201 = item20.getElementsByTag("endTime").get(0).text();
			String st202 = item20.getElementsByTag("startTime").get(1).text();
			String et202 = item20.getElementsByTag("endTime").get(1).text();
			String st203 = item20.getElementsByTag("startTime").get(2).text();
			String et203 = item20.getElementsByTag("endTime").get(2).text();
			String wx201 = item20.getElementsByTag("parameterName").get(0).text();
			String wx202 = item20.getElementsByTag("parameterName").get(1).text();
			String wx203 = item20.getElementsByTag("parameterName").get(2).text();
			String pop201 = item20.getElementsByTag("parameterName").get(3).text();
			String pop202 = item20.getElementsByTag("parameterName").get(4).text();
			String pop203 = item20.getElementsByTag("parameterName").get(5).text();
			String mt201 = item20.getElementsByTag("parameterName").get(6).text();
			String mt202 = item20.getElementsByTag("parameterName").get(7).text();
			String mt203 = item20.getElementsByTag("parameterName").get(8).text();
			String ht201 = item20.getElementsByTag("parameterName").get(12).text();
			String ht202 = item20.getElementsByTag("parameterName").get(13).text();
			String ht203 = item20.getElementsByTag("parameterName").get(14).text();
			String ci201 = item20.getElementsByTag("parameterName").get(9).text();
			String ci202 = item20.getElementsByTag("parameterName").get(10).text();
			String ci203 = item20.getElementsByTag("parameterName").get(11).text();
		//屏東縣
		Document document21 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E5%B1%8F%E6%9D%B1%E7%B8%A3").get();
		Elements items21 = document21.getElementsByTag("dataset");
		for (Element item21 : items21) {
			String loca211 = item21.getElementsByTag("locationName").get(0).text();
			String st211 = item21.getElementsByTag("startTime").get(0).text();
			String et211 = item21.getElementsByTag("endTime").get(0).text();
			String st212 = item21.getElementsByTag("startTime").get(1).text();
			String et212 = item21.getElementsByTag("endTime").get(1).text();
			String st213 = item21.getElementsByTag("startTime").get(2).text();
			String et213 = item21.getElementsByTag("endTime").get(2).text();
			String wx211 = item21.getElementsByTag("parameterName").get(0).text();
			String wx212 = item21.getElementsByTag("parameterName").get(1).text();
			String wx213 = item21.getElementsByTag("parameterName").get(2).text();
			String pop211 = item21.getElementsByTag("parameterName").get(3).text();
			String pop212 = item21.getElementsByTag("parameterName").get(4).text();
			String pop213 = item21.getElementsByTag("parameterName").get(5).text();
			String mt211 = item21.getElementsByTag("parameterName").get(6).text();
			String mt212 = item21.getElementsByTag("parameterName").get(7).text();
			String mt213 = item21.getElementsByTag("parameterName").get(8).text();
			String ht211 = item21.getElementsByTag("parameterName").get(12).text();
			String ht212 = item21.getElementsByTag("parameterName").get(13).text();
			String ht213 = item21.getElementsByTag("parameterName").get(14).text();
			String ci211 = item21.getElementsByTag("parameterName").get(9).text();
			String ci212 = item21.getElementsByTag("parameterName").get(10).text();
			String ci213 = item21.getElementsByTag("parameterName").get(11).text();
//臺中市
			Document document22 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E8%87%BA%E4%B8%AD%E5%B8%82").get();
			Elements items22 = document22.getElementsByTag("dataset");
			for (Element item22 : items22) {
				String loca221 = item22.getElementsByTag("locationName").get(0).text();
				String st221 = item22.getElementsByTag("startTime").get(0).text();
				String et221 = item22.getElementsByTag("endTime").get(0).text();
				String st222 = item22.getElementsByTag("startTime").get(1).text();
				String et222 = item22.getElementsByTag("endTime").get(1).text();
				String st223 = item22.getElementsByTag("startTime").get(2).text();
				String et223 = item22.getElementsByTag("endTime").get(2).text();
				String wx221 = item22.getElementsByTag("parameterName").get(0).text();
				String wx222 = item22.getElementsByTag("parameterName").get(1).text();
				String wx223 = item22.getElementsByTag("parameterName").get(2).text();
				String pop221 = item22.getElementsByTag("parameterName").get(3).text();
				String pop222 = item22.getElementsByTag("parameterName").get(4).text();
				String pop223 = item22.getElementsByTag("parameterName").get(5).text();
				String mt221 = item22.getElementsByTag("parameterName").get(6).text();
				String mt222 = item22.getElementsByTag("parameterName").get(7).text();
				String mt223 = item22.getElementsByTag("parameterName").get(8).text();
				String ht221 = item22.getElementsByTag("parameterName").get(12).text();
				String ht222 = item22.getElementsByTag("parameterName").get(13).text();
				String ht223 = item22.getElementsByTag("parameterName").get(14).text();
				String ci221 = item22.getElementsByTag("parameterName").get(9).text();
				String ci222 = item22.getElementsByTag("parameterName").get(10).text();
				String ci223 = item22.getElementsByTag("parameterName").get(11).text();
//宜蘭縣
				Document document23 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E5%AE%9C%E8%98%AD%E7%B8%A3").get();
				Elements items23 = document23.getElementsByTag("dataset");
				for (Element item23 : items23) {
					String loca231 = item23.getElementsByTag("locationName").get(0).text();
					String st231 = item23.getElementsByTag("startTime").get(0).text();
					String et231 = item23.getElementsByTag("endTime").get(0).text();
					String st232 = item23.getElementsByTag("startTime").get(1).text();
					String et232 = item23.getElementsByTag("endTime").get(1).text();
					String st233 = item23.getElementsByTag("startTime").get(2).text();
					String et233 = item23.getElementsByTag("endTime").get(2).text();
					String wx231 = item23.getElementsByTag("parameterName").get(0).text();
					String wx232 = item23.getElementsByTag("parameterName").get(1).text();
					String wx233 = item23.getElementsByTag("parameterName").get(2).text();
					String pop231 = item23.getElementsByTag("parameterName").get(3).text();
					String pop232 = item23.getElementsByTag("parameterName").get(4).text();
					String pop233 = item23.getElementsByTag("parameterName").get(5).text();
					String mt231 = item23.getElementsByTag("parameterName").get(6).text();
					String mt232 = item23.getElementsByTag("parameterName").get(7).text();
					String mt233 = item23.getElementsByTag("parameterName").get(8).text();
					String ht231 = item23.getElementsByTag("parameterName").get(12).text();
					String ht232 = item23.getElementsByTag("parameterName").get(13).text();
					String ht233 = item23.getElementsByTag("parameterName").get(14).text();
					String ci231 = item23.getElementsByTag("parameterName").get(9).text();
					String ci232 = item23.getElementsByTag("parameterName").get(10).text();
					String ci233 = item23.getElementsByTag("parameterName").get(11).text();


					String oilup = items.getElementsByClass("update").get(0).text();
			String oil = items.getElementsByClass("main").get(0).text();
			String rank = items1.getElementsByClass("text").get(0).text();
			String list1 = items1.getElementsByClass("end_title").get(0).text();
			String song1 = items1.getElementsByClass("link_text").get(0).text();
			String singer1 = items1.getElementsByClass("link_artist").get(0).text();
			String rank2 = items1.getElementsByClass("text").get(1).text();
			String song2 = items1.getElementsByClass("link_text").get(1).text();
			String singer2 = items1.getElementsByClass("link_artist").get(2).text();
			String rank3 = items1.getElementsByClass("text").get(2).text();
			String song3 = items1.getElementsByClass("link_text").get(2).text();
			String singer3 = items1.getElementsByClass("link_artist").get(4).text();
			String rank4 = items1.getElementsByClass("text").get(3).text();
			String song4 = items1.getElementsByClass("link_text").get(3).text();
			String singer4 = items1.getElementsByClass("link_artist").get(6).text();
			String rank5 = items1.getElementsByClass("text").get(4).text();
			String song5 = items1.getElementsByClass("link_text").get(4).text();
			String singer5 = items1.getElementsByClass("link_artist").get(8).text();

			JSONObject body = new JSONObject();
			JSONArray messages = new JSONArray();
			JSONObject message = new JSONObject();
			message.put("type", "text");
					String 台中 = list + "\n" + loca221 + "\n" + st221 + "\n" + "～" + "\n" + et221 + "\n" + "氣溫：" + mt221 + "度" + "~" + ht221 + "度" + "\n" + "氣候：" + wx221 + "\n" + "降雨機率：" + pop221 + "%" + "\n" + "舒適度：" + ci221 + "\n"+"--------"+"\n"
							+ st222 + "\n" + "～" + "\n" + et222 + "\n" + "氣溫：" + mt222 + "度" + "~" + ht222 + "度" + "\n" + "氣候：" + wx222 + "\n" + "降雨機率：" + pop222 + "%" + "\n" + "舒適度：" + ci222 + "\n"+"--------"+"\n"
							+ st223 + "\n" + "～" + "\n" + et223 + "\n" + "氣溫：" + mt223 + "度" + "~" + ht223 + "度" + "\n" + "氣候：" + wx223 + "\n" + "降雨機率：" + pop223 + "%" + "\n" + "舒適度：" + ci223 + "\n"+"--------";
					String 台東 = list + "\n" + loca31 + "\n" + st31 + "\n" + "～" + "\n" + et31 + "\n" + "氣溫：" + mt31 + "度" + "~" + ht31 + "度" + "\n" + "氣候：" + wx31 + "\n" + "降雨機率：" + pop31 + "%" + "\n" + "舒適度：" + ci31 + "\n"+"--------"+"\n"
							+ st32 + "\n" + "～" + "\n" + et32 + "\n" + "氣溫：" + mt32 + "度" + "~" + ht32 + "度" + "\n" + "氣候：" + wx32 + "\n" + "降雨機率：" + pop32 + "%" + "\n" + "舒適度：" + ci32 + "\n"+"--------"+"\n"
							+ st33 + "\n" + "～" + "\n" + et33 + "\n" + "氣溫：" + mt33 + "度" + "~" + ht33 + "度" + "\n" + "氣候：" + wx33 + "\n" + "降雨機率：" + pop33 + "%" + "\n" + "舒適度：" + ci33 + "\n"+"--------";
					String 台北 = list + "\n" + loca71 + "\n" + st71 + "\n" + "～" + "\n" + et71 + "\n" + "氣溫：" + mt71 + "度" + "~" + ht71 + "度" + "\n" + "氣候：" + wx71 + "\n" + "降雨機率：" + pop71 + "%" + "\n" + "舒適度：" + ci71 + "\n"+"--------"+"\n"
							+ st72 + "\n" + "～" + "\n" + et72 + "\n" + "氣溫：" + mt72 + "度" + "~" + ht72 + "度" + "\n" + "氣候：" + wx72 + "\n" + "降雨機率：" + pop72 + "%" + "\n" + "舒適度：" + ci72 + "\n"+"--------"+"\n"
							+ st73 + "\n" + "～" + "\n" + et73 + "\n" + "氣溫：" + mt73 + "度" + "~" + ht73 + "度" + "\n" + "氣候：" + wx73 + "\n" + "降雨機率：" + pop73 + "%" + "\n" + "舒適度：" + ci73 + "\n"+"--------";
					String 台南 = list + "\n" + loca101 + "\n" + st101 + "\n" + "～" + "\n" + et101 + "\n" + "氣溫：" + mt101 + "度" + "~" + ht101 + "度" + "\n" + "氣候：" + wx101 + "\n" + "降雨機率：" + pop101 + "%" + "\n" + "舒適度：" + ci101 + "\n"+"--------"+"\n"
							+ st102 + "\n" + "～" + "\n" + et102 + "\n" + "氣溫：" + mt102 + "度" + "~" + ht102 + "度" + "\n" + "氣候：" + wx102 + "\n" + "降雨機率：" + pop102 + "%" + "\n" + "舒適度：" + ci102 + "\n"+"--------"+"\n"
							+ st103 + "\n" + "～" + "\n" + et103 + "\n" + "氣溫：" + mt103 + "度" + "~" + ht103 + "度" + "\n" + "氣候：" + wx103 + "\n" + "降雨機率：" + pop103 + "%" + "\n" + "舒適度：" + ci103 + "\n"+"--------";
					switch (text) {
				case "你好":
					message.put("text", "哈囉，我是全能小幫手Bnson");
					break;
				case "下周油價":
					message.put("text", "下周油價：" + "\n" + oil + "\n" + oilup);
					break;
				case "下週油價":
					message.put("text", "下週油價：" + "\n" + oil + "\n" + oilup);
					break;
				case "華語歌曲推薦":
					message.put("text", list1 + "\n" + rank + "\n" + "歌名：" + song1 + "\n" + "演唱人：" + singer1 + "\n"
							+ rank2 + "\n" + "歌名：" + song2 + "\n" + "演唱人：" + singer2 + "\n"
							+ rank3 + "\n" + "歌名：" + song3 + "\n" + "演唱人：" + singer3 + "\n"
							+ rank4 + "\n" + "歌名：" + song4 + "\n" + "演唱人：" + singer4 + "\n"
							+ rank5 + "\n" + "歌名：" + song5 + "\n" + "演唱人：" + singer5);
					break;

				case "屏東縣 天氣":
					message.put("text", list + "\n" + loca211 + "\n" + st211 + "\n"+ "～" +"\n" + et211 + "\n" + "氣溫：" + mt211 + "度" + "~" + ht211 + "度" + "\n" + "氣候：" + wx211 + "\n" + "降雨機率：" + pop211 + "%" + "\n" + "舒適度：" + ci211 + "\n"+"--------"+"\n"
							+ st212 + "\n"+ "～" +"\n" + et212 + "\n" + "氣溫：" + mt212 + "度" + "~" + ht212 + "度" + "\n" + "氣候：" + wx212 + "\n" + "降雨機率：" + pop212 + "%" + "\n" + "舒適度：" + ci212 + "\n"+"--------"+"\n"
							+ st213 + "\n"+ "～" +"\n" + et213 + "\n" + "氣溫：" + mt213 + "度" + "~" + ht213 + "度" + "\n" + "氣候：" + wx213 + "\n" + "降雨機率：" + pop213 + "%" + "\n" + "舒適度：" + ci213 + "\n"+"--------");
					break;
				case "嘉義市 天氣":
					message.put("text", list + "\n" + loca201 + "\n" + st201 + "\n"+ "～" +"\n" + et201 + "\n" + "氣溫：" + mt201 + "度" + "~" + ht201 + "度" + "\n" + "氣候：" + wx201 + "\n" + "降雨機率：" + pop201 + "%" + "\n" + "舒適度：" + ci201 + "\n"+"--------"+"\n"
							+ st202 + "\n"+ "～" +"\n" + et202 + "\n" + "氣溫：" + mt202 + "度" + "~" + ht202 + "度" + "\n" + "氣候：" + wx202 + "\n" + "降雨機率：" + pop202 + "%" + "\n" + "舒適度：" + ci202 + "\n"+"--------"+"\n"
							+ st203 + "\n"+ "～" +"\n" + et203 + "\n" + "氣溫：" + mt203 + "度" + "~" + ht203 + "度" + "\n" + "氣候：" + wx203 + "\n" + "降雨機率：" + pop203 + "%" + "\n" + "舒適度：" + ci203 + "\n"+"--------");
					break;
				case "嘉義縣 天氣":
					message.put("text", list + "\n" + loca191 + "\n" + st191 + "\n"+ "～" +"\n" + et191 + "\n" + "氣溫：" + mt191 + "度" + "~" + ht191 + "度" + "\n"+ "氣候：" + wx191 + "\n" + "降雨機率：" + pop191 + "%" + "\n"  + "舒適度：" + ci191 + "\n"+"--------"+"\n"
							+ st192 + "\n"+ "～" +"\n" + et192 + "\n"  + "氣溫：" + mt192 + "度" + "~" + ht192 + "度" + "\n"+ "氣候：" + wx192 + "\n" + "降雨機率：" + pop192 + "%" + "\n" + "舒適度：" + ci192 + "\n"+"--------"+"\n"
							+ st193 + "\n"+ "～" +"\n" + et193 + "\n" + "氣溫：" + mt193 + "度" + "~" + ht193 + "度" + "\n"+ "氣候：" + wx193 + "\n" + "降雨機率：" + pop193 + "%" + "\n"  + "舒適度：" + ci193 + "\n"+"--------");
					break;
				case "天氣 雲林縣":
					message.put("text", list + "\n" + loca181 + "\n" + st181 + "\n"+ "～" +"\n" + et181 + "\n" + "氣溫：" + mt181 + "度" + "~" + ht181 + "度" + "\n" + "氣候：" + wx181 + "\n" + "降雨機率：" + pop181 + "%" + "\n" + "舒適度：" + ci181 + "\n"+"--------"+"\n"
							+ st182 + "\n"+ "～" +"\n" + et182 + "\n" + "氣溫：" + mt182 + "度" + "~" + ht182 + "度" + "\n" + "氣候：" + wx182 + "\n" + "降雨機率：" + pop182 + "%" + "\n" + "舒適度：" + ci182 + "\n"+"--------"+"\n"
							+ st183 + "\n"+ "～" +"\n" + et183 + "\n" + "氣溫：" + mt183 + "度" + "~" + ht183 + "度" + "\n" + "氣候：" + wx183 + "\n" + "降雨機率：" + pop183 + "%" + "\n" + "舒適度：" + ci183 + "\n"+"--------");
					break;
				case "南投縣 天氣":
					message.put("text",list + "\n" + loca171 + "\n" + st171 + "\n"+ "～" +"\n" + et171 + "\n" + "氣溫：" + mt171 + "度" + "~" + ht171 + "度" + "\n"+ "氣候：" + wx171 + "\n" + "降雨機率：" + pop171 + "%" + "\n"  + "舒適度：" + ci171 + "\n"+"--------"+"\n"
							+ st172 + "\n"+ "～" +"\n" + et172 + "\n"  + "氣溫：" + mt172 + "度" + "~" + ht172 + "度" + "\n"+ "氣候：" + wx172 + "\n" + "降雨機率：" + pop172 + "%" + "\n" + "舒適度：" + ci172 + "\n"+"--------"+"\n"
							+ st173 + "\n"+ "～" +"\n" + et173 + "\n" + "氣溫：" + mt173 + "度" + "~" + ht173 + "度" + "\n"+ "氣候：" + wx173 + "\n" + "降雨機率：" + pop173 + "%" + "\n"  + "舒適度：" + ci173 + "\n"+"--------");
					break;
				case "彰化縣 天氣":
					message.put("text", list + "\n" + loca161 + "\n" + st161 +"\n"+ "～" +"\n" + et161 + "\n" + "氣溫：" + mt161 + "度" + "~" + ht161 + "度" + "\n"+ "氣候：" + wx161 + "\n" + "降雨機率：" + pop161 + "%" + "\n"  + "舒適度：" + ci161 + "\n"+"--------"+"\n"
							+ st162 +"\n"+ "～" +"\n"+ et162 + "\n"  + "氣溫：" + mt162 + "度" + "~" + ht162 + "度" + "\n"+ "氣候：" + wx162 + "\n" + "降雨機率：" + pop162 + "%" + "\n" + "舒適度：" + ci162 + "\n"+"--------"+"\n"
							+ st163 +"\n"+ "～" +"\n"+ et163 + "\n" + "氣溫：" + mt163 + "度" + "~" + ht163 + "度" + "\n"+ "氣候：" + wx163 + "\n" + "降雨機率：" + pop163 + "%" + "\n"  + "舒適度：" + ci163 + "\n"+"--------");
					break;
				case "苗栗縣 天氣":
					message.put("text",list + "\n" + loca151 + "\n" + st151 +"\n"+ "～" +"\n" + et151 + "\n" + "氣溫：" + mt151 + "度" + "~" + ht151 + "度" + "\n"+ "氣候：" + wx151 + "\n" + "降雨機率：" + pop151 + "%" + "\n"  + "舒適度：" + ci151 + "\n"+"--------"+"\n"
							+ st152 + "\n"+ "～" +"\n" + et152 + "\n"  + "氣溫：" + mt152 + "度" + "~" + ht152 + "度" + "\n"+ "氣候：" + wx152 + "\n" + "降雨機率：" + pop152 + "%" + "\n" + "舒適度：" + ci152 + "\n"+"--------"+"\n"
							+ st153 + "\n"+ "～" +"\n"+ et153 + "\n" + "氣溫：" + mt153 + "度" + "~" + ht153 + "度" + "\n"+ "氣候：" + wx153 + "\n" + "降雨機率：" + pop153 + "%" + "\n"  + "舒適度：" + ci153 + "\n"+"--------");
					break;
				case "新竹市 天氣":
					message.put("text",list + "\n" + loca141 + "\n" + st141 + "\n"+ "～" +"\n" + et141 + "\n" + "氣溫：" + mt141 + "度" + "~" + ht141 + "度" + "\n"+ "氣候：" + wx141 + "\n" + "降雨機率：" + pop141 + "%" + "\n"  + "舒適度：" + ci141 + "\n"+"--------"+"\n"
							+ st142 + "\n"+ "～" +"\n" + et142 + "\n"  + "氣溫：" + mt142 + "度" + "~" + ht142 + "度" + "\n"+ "氣候：" + wx142 + "\n" + "降雨機率：" + pop142 + "%" + "\n" + "舒適度：" + ci142 + "\n"+"--------"+"\n"
							+ st143 + "\n"+ "～" +"\n" + et143 + "\n" + "氣溫：" + mt143 + "度" + "~" + ht143 + "度" + "\n"+ "氣候：" + wx143 + "\n" + "降雨機率：" + pop143 + "%" + "\n"  + "舒適度：" + ci143 + "\n"+"--------");
					break;
				case "新竹縣 天氣":
					message.put("text",list + "\n" + loca131 + "\n" + st131 + "\n"+ "～" +"\n" + et131 + "\n" + "氣溫：" + mt131 + "度" + "~" + ht131 + "度" + "\n"+ "氣候：" + wx131 + "\n" + "降雨機率：" + pop131 + "%" + "\n"  + "舒適度：" + ci131 + "\n"+"--------"+"\n"
							+ st132 + "\n"+ "～" +"\n" + et132 + "\n"  + "氣溫：" + mt132 + "度" + "~" + ht132 + "度" + "\n"+ "氣候：" + wx132 + "\n" + "降雨機率：" + pop132 + "%" + "\n" + "舒適度：" + ci132 + "\n"+"--------"+"\n"
							+ st133 + "\n"+ "～" +"\n" + et133 + "\n" + "氣溫：" + mt133 + "度" + "~" + ht133 + "度" + "\n"+ "氣候：" + wx133 + "\n" + "降雨機率：" + pop133 + "%" + "\n"  + "舒適度：" + ci133 + "\n"+"--------");
				break;
				case "基隆市 天氣":
					message.put("text",list + "\n" + loca121 + "\n" + st121 + "\n"+ "～" +"\n" + et121 + "\n" + "氣溫：" + mt121 + "度" + "~" + ht121 + "度" + "\n"+ "氣候：" + wx121 + "\n" + "降雨機率：" + pop121 + "%" + "\n"  + "舒適度：" + ci121 + "\n"+"--------"+"\n"
							+ st122 + "\n"+ "～" +"\n" + et122 + "\n"  + "氣溫：" + mt122 + "度" + "~" + ht122 + "度" + "\n"+ "氣候：" + wx122 + "\n" + "降雨機率：" + pop122 + "%" + "\n" + "舒適度：" + ci122 + "\n"+"--------"+"\n"
							+ st123 + "\n"+ "～" +"\n" + et123 + "\n" + "氣溫：" + mt123 + "度" + "~" + ht123 + "度" + "\n"+ "氣候：" + wx123 + "\n" + "降雨機率：" + pop123 + "%" + "\n"  + "舒適度：" + ci123 + "\n"+"--------");
				break;
				case "高雄市 天氣":
					message.put("text",list + "\n" + loca111 + "\n" + st111 + "\n"+ "～" +"\n" + et111 + "\n" + "氣溫：" + mt111 + "度" + "~" + ht111 + "度" + "\n"+ "氣候：" + wx111 + "\n" + "降雨機率：" + pop111 + "%" + "\n"  + "舒適度：" + ci111 + "\n"+"--------"+"\n"
							+ st112 + "\n"+ "～" +"\n" + et112 + "\n"  + "氣溫：" + mt112 + "度" + "~" + ht112 + "度" + "\n"+ "氣候：" + wx112 + "\n" + "降雨機率：" + pop112 + "%" + "\n" + "舒適度：" + ci112 + "\n"+"--------"+"\n"
							+ st113 + "\n"+ "～" +"\n" + et113 + "\n" + "氣溫：" + mt113 + "度" + "~" + ht113 + "度" + "\n"+ "氣候：" + wx113 + "\n" + "降雨機率：" + pop113 + "%" + "\n"  + "舒適度：" + ci113 + "\n"+"--------");
				break;
				case "台南市 天氣":
					message.put("text", 台南);
				break;
				case "臺南市 天氣":
							message.put("text", 台南);
				break;
				case "桃園市 天氣":
					message.put("text",list + "\n" + loca91 + "\n" + st91 + "\n"+ "～" +"\n" + et91 + "\n" + "氣溫：" + mt91 + "度" + "~" + ht91 + "度" + "\n"+ "氣候：" + wx91 + "\n" + "降雨機率：" + pop91 + "%" + "\n"  + "舒適度：" + ci91 + "\n"+"--------"+"\n"
							+ st92 + "\n"+ "～" +"\n" + et92 + "\n"  + "氣溫：" + mt92 + "度" + "~" + ht92 + "度" + "\n"+ "氣候：" + wx92 + "\n" + "降雨機率：" + pop92 + "%" + "\n" + "舒適度：" + ci92 + "\n"+"--------"+"\n"
							+ st93 + "\n"+ "～" +"\n" + et93 + "\n" + "氣溫：" + mt93 + "度" + "~" + ht93 + "度" + "\n"+ "氣候：" + wx93 + "\n" + "降雨機率：" + pop93 + "%" + "\n"  + "舒適度：" + ci93 + "\n"+"--------");
				break;
				case "新北市 天氣":
					message.put("text",list + "\n" + loca81 + "\n" + st81 + "\n"+ "～" +"\n" + et81 + "\n" + "氣溫：" + mt81 + "度" + "~" + ht81 + "度" + "\n"+ "氣候：" + wx81 + "\n" + "降雨機率：" + pop81 + "%" + "\n"  + "舒適度：" + ci81 + "\n"+"--------"+"\n"
							+ st82 + "\n"+ "～" +"\n" + et82 + "\n"  + "氣溫：" + mt82 + "度" + "~" + ht82 + "度" + "\n"+ "氣候：" + wx82 + "\n" + "降雨機率：" + pop82 + "%" + "\n" + "舒適度：" + ci82 + "\n"+"--------"+"\n"
							+ st83 + "\n"+ "～" +"\n" + et83 + "\n" + "氣溫：" + mt83 + "度" + "~" + ht83 + "度" + "\n"+ "氣候：" + wx83 + "\n" + "降雨機率：" + pop83 + "%" + "\n"  + "舒適度：" + ci83 + "\n"+"--------");
				break;
				case "臺北市 天氣":
					message.put("text", 台北);
				break;
				case "台北市 天氣":
							message.put("text", 台北);
				break;
				case "連江縣 天氣":
					message.put("text",list + "\n" + loca61 + "\n" + st61 + "\n"+ "～" +"\n" + et61 + "\n" + "氣溫：" + mt61 + "度" + "~" + ht61 + "度" + "\n"+ "氣候：" + wx61 + "\n" + "降雨機率：" + pop61 + "%" + "\n"  + "舒適度：" + ci61 + "\n"+"--------"+"\n"
							+ st62 + "\n"+ "～" +"\n" + et62 + "\n"  + "氣溫：" + mt62 + "度" + "~" + ht62 + "度" + "\n"+ "氣候：" + wx62 + "\n" + "降雨機率：" + pop62 + "%" + "\n" + "舒適度：" + ci62 + "\n"+"--------"+"\n"
							+ st63 + "\n"+ "～" +"\n" + et63 + "\n" + "氣溫：" + mt63 + "度" + "~" + ht63 + "度" + "\n"+ "氣候：" + wx63 + "\n" + "降雨機率：" + pop63 + "%" + "\n"  + "舒適度：" + ci63 + "\n"+"--------");
				break;
				case "金門縣 天氣":
					message.put("text",list + "\n" + loca51 + "\n" + st51 + "\n"+ "～" +"\n" + et51 + "\n" + "氣溫：" + mt51 + "度" + "~" + ht51 + "度" + "\n"+ "氣候：" + wx51 + "\n" + "降雨機率：" + pop51 + "%" + "\n"  + "舒適度：" + ci51 + "\n"+"--------"+"\n"
							+ st52 + "\n"+ "～" +"\n" + et52 + "\n"  + "氣溫：" + mt52 + "度" + "~" + ht52 + "度" + "\n"+ "氣候：" + wx52 + "\n" + "降雨機率：" + pop52 + "%" + "\n" + "舒適度：" + ci52 + "\n"+"--------"+"\n"
							+ st53 + "\n"+ "～" +"\n" + et53 + "\n" + "氣溫：" + mt53 + "度" + "~" + ht53 + "度" + "\n"+ "氣候：" + wx53 + "\n" + "降雨機率：" + pop53 + "%" + "\n"  + "舒適度：" + ci53 + "\n"+"--------");
				break;
				case "澎湖縣 天氣":
					message.put("text",list + "\n" + loca41 + "\n" + st41 + "\n"+ "～" +"\n" + et41 + "\n" + "氣溫：" + mt41 + "度" + "~" + ht41 + "度" + "\n"+ "氣候：" + wx41 + "\n" + "降雨機率：" + pop41 + "%" + "\n"  + "舒適度：" + ci41 + "\n"+"--------"+"\n"
							+ st42 + "\n"+ "～" +"\n" + et42 + "\n"  + "氣溫：" + mt42 + "度" + "~" + ht42 + "度" + "\n"+ "氣候：" + wx42 + "\n" + "降雨機率：" + pop42 + "%" + "\n" + "舒適度：" + ci42 + "\n"+"--------"+"\n"
							+ st43 + "\n"+ "～" +"\n" + et43 + "\n" + "氣溫：" + mt43 + "度" + "~" + ht43 + "度" + "\n"+ "氣候：" + wx43 + "\n" + "降雨機率：" + pop43 + "%" + "\n"  + "舒適度：" + ci43 + "\n"+"--------");
				break;
				case "臺東縣 天氣":
					message.put("text", 台東);
				break;
				case "台東縣 天氣":
							message.put("text", 台東);
				break;
				case "花蓮縣 天氣":
					message.put("text",list + "\n" + loca21 + "\n" + st21 + "\n"+ "～" +"\n" + et21 + "\n" + "氣溫：" + mt21 + "度" + "~" + ht21 + "度" + "\n"+ "氣候：" + wx21 + "\n" + "降雨機率：" + pop21 + "%" + "\n"  + "舒適度：" + ci21 + "\n"+"--------"+"\n"
							+ st22 + "\n"+ "～" +"\n" + et22 + "\n"  + "氣溫：" + mt22 + "度" + "~" + ht22 + "度" + "\n"+ "氣候：" + wx22 + "\n" + "降雨機率：" + pop22 + "%" + "\n" + "舒適度：" + ci22 + "\n"+"--------"+"\n"
							+ st23 + "\n"+ "～" +"\n" + et23 + "\n" + "氣溫：" + mt23 + "度" + "~" + ht23 + "度" + "\n"+ "氣候：" + wx23 + "\n" + "降雨機率：" + pop23 + "%" + "\n"  + "舒適度：" + ci23 + "\n"+"--------");
				break;
				case "臺中市 天氣":
					message.put("text", 台中);
				break;
				case "台中市 天氣":
					message.put("text", 台中);
					break;
				case "宜蘭縣 天氣":
					message.put("text",list + "\n" + loca231 + "\n" + st231 + "\n"+ "～" +"\n" + et231 + "\n" + "氣溫：" + mt231 + "度" + "~" + ht231 + "度" + "\n"+ "氣候：" + wx231 + "\n" + "降雨機率：" + pop231 + "%" + "\n"  + "舒適度：" + ci231 + "\n"+"--------"+"\n"
							+ st232 + "\n"+ "～" +"\n" + et232 + "\n"  + "氣溫：" + mt232 + "度" + "~" + ht232 + "度" + "\n"+ "氣候：" + wx232 + "\n" + "降雨機率：" + pop232 + "%" + "\n" + "舒適度：" + ci232 + "\n"+"--------"+"\n"
							+ st233 + "\n"+ "～" +"\n" + et233 + "\n" + "氣溫：" + mt233 + "度" + "~" + ht233 + "度" + "\n"+ "氣候：" + wx233 + "\n" + "降雨機率：" + pop233 + "%" + "\n"  + "舒適度：" + ci233 + "\n"+"--------");
				break;

				default:
					message.put("text", "我還看不懂，我目前只看得懂以下指令" + "\n" + ":縣市 天氣"+ "\n" + ":下周油價" + "\n" + ":華語歌曲推薦");
					break;
			}
			messages.put(message);
			body.put("replyToken", replyToken);
			body.put("messages", messages);
			sendLinePlatform(body);
		}}}}}}}}}}}}}}}}}}}}}}
		}


	private void sticker(String replyToken, String packageId, String stickerId) {
		JSONObject body = new JSONObject();
		JSONArray messages = new JSONArray();
		JSONObject message = new JSONObject();
		message.put("type", "sticker");
		message.put("packageId", packageId);
		message.put("stickerId", stickerId);
		messages.put(message);
		body.put("replyToken", replyToken);
		body.put("messages", messages);
		sendLinePlatform(body);
	}

	public void sendLinePlatform(JSONObject json) {
		Request request = new Request.Builder().url("https://api.line.me/v2/bot/message/reply")
				.header("Authorization", "Bearer {" + LINE_TOKEN + "}")
				.post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json.toString())).build();
		client.newCall(request).enqueue(new Callback() {

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				System.out.println(response.body());
			}

			@Override
			public void onFailure(Call call, IOException e) {
				System.err.println(e);
			}
		});
	}
}
