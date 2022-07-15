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

//天氣
		Document document2 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML").get();
		Elements items2 = document2.getElementsByTag("dataset");
		for (Element item2 : items2) {
//嘉義縣
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
			String ci21 = item2.getElementsByTag("parameterName").get(9).text();
			String ci22 = item2.getElementsByTag("parameterName").get(10).text();
			String ci23 = item2.getElementsByTag("parameterName").get(11).text();
			String ht21 = item2.getElementsByTag("parameterName").get(12).text();
			String ht22 = item2.getElementsByTag("parameterName").get(13).text();
			String ht23 = item2.getElementsByTag("parameterName").get(14).text();
//新北市
			String loca31 = item2.getElementsByTag("locationName").get(1).text();
			String wx31 = item2.getElementsByTag("parameterName").get(15).text();
			String wx32 = item2.getElementsByTag("parameterName").get(16).text();
			String wx33 = item2.getElementsByTag("parameterName").get(17).text();
			String pop31 = item2.getElementsByTag("parameterName").get(18).text();
			String pop32 = item2.getElementsByTag("parameterName").get(19).text();
			String pop33 = item2.getElementsByTag("parameterName").get(20).text();
			String mt31 = item2.getElementsByTag("parameterName").get(21).text();
			String mt32 = item2.getElementsByTag("parameterName").get(22).text();
			String mt33 = item2.getElementsByTag("parameterName").get(23).text();
			String ci31 = item2.getElementsByTag("parameterName").get(24).text();
			String ci32 = item2.getElementsByTag("parameterName").get(25).text();
			String ci33 = item2.getElementsByTag("parameterName").get(26).text();
			String ht31 = item2.getElementsByTag("parameterName").get(27).text();
			String ht32 = item2.getElementsByTag("parameterName").get(28).text();
			String ht33 = item2.getElementsByTag("parameterName").get(29).text();
//嘉義市
			String loca41 = item2.getElementsByTag("locationName").get(2).text();
			String wx41 = item2.getElementsByTag("parameterName").get(30).text();
			String wx42 = item2.getElementsByTag("parameterName").get(31).text();
			String wx43 = item2.getElementsByTag("parameterName").get(32).text();
			String pop41 = item2.getElementsByTag("parameterName").get(33).text();
			String pop42 = item2.getElementsByTag("parameterName").get(34).text();
			String pop43 = item2.getElementsByTag("parameterName").get(35).text();
			String mt41 = item2.getElementsByTag("parameterName").get(36).text();
			String mt42 = item2.getElementsByTag("parameterName").get(37).text();
			String mt43 = item2.getElementsByTag("parameterName").get(38).text();
			String ci41 = item2.getElementsByTag("parameterName").get(39).text();
			String ci42 = item2.getElementsByTag("parameterName").get(40).text();
			String ci43 = item2.getElementsByTag("parameterName").get(41).text();
			String ht41 = item2.getElementsByTag("parameterName").get(42).text();
			String ht42 = item2.getElementsByTag("parameterName").get(43).text();
			String ht43 = item2.getElementsByTag("parameterName").get(44).text();
//新竹縣
			String loca51 = item2.getElementsByTag("locationName").get(3).text();
			String wx51 = item2.getElementsByTag("parameterName").get(45).text();
			String wx52 = item2.getElementsByTag("parameterName").get(46).text();
			String wx53 = item2.getElementsByTag("parameterName").get(47).text();
			String pop51 = item2.getElementsByTag("parameterName").get(48).text();
			String pop52 = item2.getElementsByTag("parameterName").get(49).text();
			String pop53 = item2.getElementsByTag("parameterName").get(50).text();
			String mt51 = item2.getElementsByTag("parameterName").get(51).text();
			String mt52 = item2.getElementsByTag("parameterName").get(52).text();
			String mt53 = item2.getElementsByTag("parameterName").get(53).text();
			String ci51 = item2.getElementsByTag("parameterName").get(54).text();
			String ci52 = item2.getElementsByTag("parameterName").get(55).text();
			String ci53 = item2.getElementsByTag("parameterName").get(56).text();
			String ht51 = item2.getElementsByTag("parameterName").get(57).text();
			String ht52 = item2.getElementsByTag("parameterName").get(58).text();
			String ht53 = item2.getElementsByTag("parameterName").get(59).text();
//新竹市
			String loca61 = item2.getElementsByTag("locationName").get(4).text();
			String wx61 = item2.getElementsByTag("parameterName").get(60).text();
			String wx62 = item2.getElementsByTag("parameterName").get(61).text();
			String wx63 = item2.getElementsByTag("parameterName").get(62).text();
			String pop61 = item2.getElementsByTag("parameterName").get(63).text();
			String pop62 = item2.getElementsByTag("parameterName").get(64).text();
			String pop63 = item2.getElementsByTag("parameterName").get(65).text();
			String mt61 = item2.getElementsByTag("parameterName").get(66).text();
			String mt62 = item2.getElementsByTag("parameterName").get(67).text();
			String mt63 = item2.getElementsByTag("parameterName").get(68).text();
			String ci61 = item2.getElementsByTag("parameterName").get(69).text();
			String ci62 = item2.getElementsByTag("parameterName").get(70).text();
			String ci63 = item2.getElementsByTag("parameterName").get(71).text();
			String ht61 = item2.getElementsByTag("parameterName").get(72).text();
			String ht62 = item2.getElementsByTag("parameterName").get(73).text();
			String ht63 = item2.getElementsByTag("parameterName").get(74).text();
//新竹市
			String loca71 = item2.getElementsByTag("locationName").get(5).text();
			String wx71 = item2.getElementsByTag("parameterName").get(75).text();
			String wx72 = item2.getElementsByTag("parameterName").get(76).text();
			String wx73 = item2.getElementsByTag("parameterName").get(77).text();
			String pop71 = item2.getElementsByTag("parameterName").get(78).text();
			String pop72 = item2.getElementsByTag("parameterName").get(79).text();
			String pop73 = item2.getElementsByTag("parameterName").get(80).text();
			String mt71 = item2.getElementsByTag("parameterName").get(81).text();
			String mt72 = item2.getElementsByTag("parameterName").get(82).text();
			String mt73 = item2.getElementsByTag("parameterName").get(83).text();
			String ci71 = item2.getElementsByTag("parameterName").get(84).text();
			String ci72 = item2.getElementsByTag("parameterName").get(85).text();
			String ci73 = item2.getElementsByTag("parameterName").get(86).text();
			String ht71 = item2.getElementsByTag("parameterName").get(87).text();
			String ht72 = item2.getElementsByTag("parameterName").get(88).text();
			String ht73 = item2.getElementsByTag("parameterName").get(89).text();
//新竹市
			String loca81 = item2.getElementsByTag("locationName").get(6).text();
			String wx81 = item2.getElementsByTag("parameterName").get(90).text();
			String wx82 = item2.getElementsByTag("parameterName").get(91).text();
			String wx83 = item2.getElementsByTag("parameterName").get(92).text();
			String pop81 = item2.getElementsByTag("parameterName").get(93).text();
			String pop82 = item2.getElementsByTag("parameterName").get(94).text();
			String pop83 = item2.getElementsByTag("parameterName").get(95).text();
			String mt81 = item2.getElementsByTag("parameterName").get(96).text();
			String mt82 = item2.getElementsByTag("parameterName").get(97).text();
			String mt83 = item2.getElementsByTag("parameterName").get(98).text();
			String ci81 = item2.getElementsByTag("parameterName").get(99).text();
			String ci82 = item2.getElementsByTag("parameterName").get(100).text();
			String ci83 = item2.getElementsByTag("parameterName").get(101).text();
			String ht81 = item2.getElementsByTag("parameterName").get(102).text();
			String ht82 = item2.getElementsByTag("parameterName").get(103).text();
			String ht83 = item2.getElementsByTag("parameterName").get(104).text();


			JSONObject body = new JSONObject();
			JSONArray messages = new JSONArray();
			JSONObject message = new JSONObject();
			message.put("type", "text");
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
				case "嘉義縣天氣":
					message.put("text", list +"\n" +loca21+"\n"+st21+"\n"+"~"+"\n"+et21+"\n"+"氣溫："+mt21+"度"+"~"+ht21+"度"+"\n"+"天氣狀況："+wx21+"\n"+"降雨機率："+pop21+"%"+"\n"+"體感："+ci21+"\n"+"-"+"\n"
							+st22+"\n"+"~"+"\n"+et22+"\n"+"氣溫："+mt22+"度"+"~"+ht22+"度"+"\n"+"天氣狀況："+wx22+"\n"+"降雨機率："+pop22+"%"+"\n"+"體感："+ci22+"\n"+"-"+"\n"
							+st23+"\n"+"~"+"\n"+et23+"\n"+"氣溫："+mt23+"度"+"~"+ht23+"度"+"\n"+"天氣狀況："+wx23+"\n"+"降雨機率："+pop23+"%"+"\n"+"體感："+ci23+"\n"+"-"+"\n"
					);
					break;
				case "新北市天氣":
							message.put("text", list +"\n" +loca31+"\n"+st21+"\n"+"~"+"\n"+et21+"\n"+"氣溫："+mt31+"度"+"~"+ht31+"度"+"\n"+"天氣狀況："+wx31+"\n"+"降雨機率："+pop31+"%"+"\n"+"體感："+ci31+"\n"+"-"+"\n"
									+st22+"\n"+"~"+"\n"+et22+"\n"+"氣溫："+mt32+"度"+"~"+ht32+"度"+"\n"+"天氣狀況："+wx32+"\n"+"降雨機率："+pop32+"%"+"\n"+"體感："+ci32+"\n"+"-"+"\n"
									+st23+"\n"+"~"+"\n"+et23+"\n"+"氣溫："+mt33+"度"+"~"+ht33+"度"+"\n"+"天氣狀況："+wx33+"\n"+"降雨機率："+pop33+"%"+"\n"+"體感："+ci33+"\n"+"-"+"\n"
							);
					break;
				case "嘉義市天氣":
							message.put("text", list +"\n" +loca41+"\n"+st21+"\n"+"~"+"\n"+et21+"\n"+"氣溫："+mt41+"度"+"~"+ht41+"度"+"\n"+"天氣狀況："+wx41+"\n"+"降雨機率："+pop41+"%"+"\n"+"體感："+ci41+"\n"+"-"+"\n"
									+st22+"\n"+"~"+"\n"+et22+"\n"+"氣溫："+mt42+"度"+"~"+ht42+"度"+"\n"+"天氣狀況："+wx42+"\n"+"降雨機率："+pop42+"%"+"\n"+"體感："+ci42+"\n"+"-"+"\n"
									+st23+"\n"+"~"+"\n"+et23+"\n"+"氣溫："+mt43+"度"+"~"+ht43+"度"+"\n"+"天氣狀況："+wx43+"\n"+"降雨機率："+pop43+"%"+"\n"+"體感："+ci43+"\n"+"-"+"\n"
							);
					break;
				case "新竹縣天氣":
							message.put("text", list +"\n" +loca51+"\n"+st21+"\n"+"~"+"\n"+et21+"\n"+"氣溫："+mt51+"度"+"~"+ht51+"度"+"\n"+"天氣狀況："+wx51+"\n"+"降雨機率："+pop51+"%"+"\n"+"體感："+ci51+"\n"+"-"+"\n"
									+st22+"\n"+"~"+"\n"+et22+"\n"+"氣溫："+mt52+"度"+"~"+ht52+"度"+"\n"+"天氣狀況："+wx52+"\n"+"降雨機率："+pop52+"%"+"\n"+"體感："+ci52+"\n"+"-"+"\n"
									+st23+"\n"+"~"+"\n"+et23+"\n"+"氣溫："+mt53+"度"+"~"+ht53+"度"+"\n"+"天氣狀況："+wx53+"\n"+"降雨機率："+pop53+"%"+"\n"+"體感："+ci53+"\n"+"-"+"\n"
							);
				break;
				case "新竹市天氣":
							message.put("text", list +"\n" +loca61+"\n"+st21+"\n"+"~"+"\n"+et21+"\n"+"氣溫："+mt61+"度"+"~"+ht61+"度"+"\n"+"天氣狀況："+wx61+"\n"+"降雨機率："+pop61+"%"+"\n"+"體感："+ci61+"\n"+"-"+"\n"
									+st22+"\n"+"~"+"\n"+et22+"\n"+"氣溫："+mt62+"度"+"~"+ht62+"度"+"\n"+"天氣狀況："+wx62+"\n"+"降雨機率："+pop62+"%"+"\n"+"體感："+ci62+"\n"+"-"+"\n"
									+st23+"\n"+"~"+"\n"+et23+"\n"+"氣溫："+mt63+"度"+"~"+ht63+"度"+"\n"+"天氣狀況："+wx63+"\n"+"降雨機率："+pop63+"%"+"\n"+"體感："+ci63+"\n"+"-"+"\n"
							);
				break;
				case "台北市天氣":
							message.put("text",list +"\n" +loca71+"\n"+st21+"\n"+"~"+"\n"+et21+"\n"+"氣溫："+mt71+"度"+"~"+ht71+"度"+"\n"+"天氣狀況："+wx71+"\n"+"降雨機率："+pop71+"%"+"\n"+"體感："+ci71+"\n"+"-"+"\n"
									+st22+"\n"+"~"+"\n"+et22+"\n"+"氣溫："+mt72+"度"+"~"+ht72+"度"+"\n"+"天氣狀況："+wx72+"\n"+"降雨機率："+pop72+"%"+"\n"+"體感："+ci72+"\n"+"-"+"\n"
									+st23+"\n"+"~"+"\n"+et23+"\n"+"氣溫："+mt73+"度"+"~"+ht73+"度"+"\n"+"天氣狀況："+wx73+"\n"+"降雨機率："+pop73+"%"+"\n"+"體感："+ci73+"\n"+"-"+"\n"
							);
				break;
				case "台南市天氣":
							message.put("text", list +"\n" +loca81+"\n"+st21+"\n"+"~"+"\n"+et21+"\n"+"氣溫："+mt81+"度"+"~"+ht81+"度"+"\n"+"天氣狀況："+wx81+"\n"+"降雨機率："+pop81+"%"+"\n"+"體感："+ci81+"\n"+"-"+"\n"
									+st22+"\n"+"~"+"\n"+et22+"\n"+"氣溫："+mt82+"度"+"~"+ht82+"度"+"\n"+"天氣狀況："+wx82+"\n"+"降雨機率："+pop82+"%"+"\n"+"體感："+ci82+"\n"+"-"+"\n"
									+st23+"\n"+"~"+"\n"+et23+"\n"+"氣溫："+mt83+"度"+"~"+ht83+"度"+"\n"+"天氣狀況："+wx83+"\n"+"降雨機率："+pop83+"%"+"\n"+"體感："+ci83+"\n"+"-"+"\n"
							);
				break;

				default:
					message.put("text", "我還看不懂，我目前只看得懂以下指令" + "\n" + ":縣市天氣"+ "\n" + ":下周油價" + "\n" + ":華語歌曲推薦");
					break;
			}
			messages.put(message);
			body.put("replyToken", replyToken);
			body.put("messages", messages);
			sendLinePlatform(body);
		}}



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
