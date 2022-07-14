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
		//南投縣
		Document document17 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E5%8D%97%E6%8A%95%E7%B8%A3").get();
		Elements items17 = document17.getElementsByTag("dataset");
		for (Element item : items17) {
			String list = item.getElementsByTag("datasetDescription").get(0).text();
			String loca1 = item.getElementsByTag("locationName").get(0).text();
			String st1 = item.getElementsByTag("startTime").get(0).text();
			String et1 = item.getElementsByTag("endTime").get(0).text();
			String st2 = item.getElementsByTag("startTime").get(1).text();
			String et2 = item.getElementsByTag("endTime").get(1).text();
			String st3 = item.getElementsByTag("startTime").get(2).text();
			String et3 = item.getElementsByTag("endTime").get(2).text();
			String wx1 = item.getElementsByTag("parameterName").get(0).text();
			String wx2 = item.getElementsByTag("parameterName").get(1).text();
			String wx3 = item.getElementsByTag("parameterName").get(2).text();
			String pop1 = item.getElementsByTag("parameterName").get(3).text();
			String pop2 = item.getElementsByTag("parameterName").get(4).text();
			String pop3 = item.getElementsByTag("parameterName").get(5).text();
			String mt1 = item.getElementsByTag("parameterName").get(6).text();
			String mt2 = item.getElementsByTag("parameterName").get(7).text();
			String mt3 = item.getElementsByTag("parameterName").get(8).text();
			String ht1 = item.getElementsByTag("parameterName").get(12).text();
			String ht2 = item.getElementsByTag("parameterName").get(13).text();
			String ht3 = item.getElementsByTag("parameterName").get(14).text();
			String ci1 = item.getElementsByTag("parameterName").get(9).text();
			String ci2 = item.getElementsByTag("parameterName").get(10).text();
			String ci3 = item.getElementsByTag("parameterName").get(11).text();
			JSONObject body = new JSONObject();
			JSONArray messages = new JSONArray();
			JSONObject message = new JSONObject();
			message.put("type", "天氣 南投縣");
			message.put("text",list + "\n" + loca1 + "\n" + st1 + "～" + et1 + "\n" + "氣溫：" + mt1 + "度" + "~" + ht1 + "度" + "\n"+ "氣候：" + wx1 + "\n" + "降雨機率：" + pop1 + "%" + "\n"  + "舒適度：" + ci1 + "\n"
					+ st2 + "～" + et2 + "\n"  + "氣溫：" + mt2 + "度" + "~" + ht2 + "度" + "\n"+ "氣候：" + wx2 + "\n" + "降雨機率：" + pop2 + "%" + "\n" + "舒適度：" + ci2 + "\n"
					+ st3 + "～" + et3 + "\n" + "氣溫：" + mt3 + "度" + "~" + ht3 + "度" + "\n"+ "氣候：" + wx3 + "\n" + "降雨機率：" + pop3 + "%" + "\n"  + "舒適度：" + ci3 + "\n");
			messages.put(message);
			messages.put(message);
			body.put("replyToken", replyToken);
			body.put("messages", messages);
			sendLinePlatform(body);
		}
//雲林縣
		Document document18 = Jsoup.connect("https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-C61A529F-C4D3-499A-8DFC-D1C585AED84A&format=XML&locationName=%E9%9B%B2%E6%9E%97%E7%B8%A3").get();
		Elements items18 = document18.getElementsByTag("dataset");
		for (Element item18 : items18) {
			String list = item18.getElementsByTag("datasetDescription").get(0).text();
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
				case "天氣 屏東縣":
					message.put("text", list + "\n" + loca211 + "\n" + st211 + "～" + et211 + "\n" + "氣溫：" + mt211 + "度" + "~" + ht211 + "度" + "\n" + "氣候：" + wx211 + "\n" + "降雨機率：" + pop211 + "%" + "\n" + "舒適度：" + ci211 + "\n"
							+ st212 + "～" + et212 + "\n" + "氣溫：" + mt212 + "度" + "~" + ht212 + "度" + "\n" + "氣候：" + wx212 + "\n" + "降雨機率：" + pop212 + "%" + "\n" + "舒適度：" + ci212 + "\n"
							+ st213 + "～" + et213 + "\n" + "氣溫：" + mt213 + "度" + "~" + ht213 + "度" + "\n" + "氣候：" + wx213 + "\n" + "降雨機率：" + pop213 + "%" + "\n" + "舒適度：" + ci213 + "\n");
					break;
				case "天氣 嘉義市":
					message.put("text", list + "\n" + loca201 + "\n" + st201 + "～" + et201 + "\n" + "氣溫：" + mt201 + "度" + "~" + ht201 + "度" + "\n" + "氣候：" + wx201 + "\n" + "降雨機率：" + pop201 + "%" + "\n" + "舒適度：" + ci201 + "\n"
							+ st202 + "～" + et202 + "\n" + "氣溫：" + mt202 + "度" + "~" + ht202 + "度" + "\n" + "氣候：" + wx202 + "\n" + "降雨機率：" + pop202 + "%" + "\n" + "舒適度：" + ci202 + "\n"
							+ st203 + "～" + et203 + "\n" + "氣溫：" + mt203 + "度" + "~" + ht203 + "度" + "\n" + "氣候：" + wx203 + "\n" + "降雨機率：" + pop203 + "%" + "\n" + "舒適度：" + ci203 + "\n");
					break;
				case "天氣 雲林縣":
					message.put("text", list + "\n" + loca181 + "\n" + st181 + "～" + et181 + "\n" + "氣溫：" + mt181 + "度" + "~" + ht181 + "度" + "\n" + "氣候：" + wx181 + "\n" + "降雨機率：" + pop181 + "%" + "\n" + "舒適度：" + ci181 + "\n"
							+ st182 + "～" + et182 + "\n" + "氣溫：" + mt182 + "度" + "~" + ht182 + "度" + "\n" + "氣候：" + wx182 + "\n" + "降雨機率：" + pop182 + "%" + "\n" + "舒適度：" + ci182 + "\n"
							+ st183 + "～" + et183 + "\n" + "氣溫：" + mt183 + "度" + "~" + ht183 + "度" + "\n" + "氣候：" + wx183 + "\n" + "降雨機率：" + pop183 + "%" + "\n" + "舒適度：" + ci183 + "\n");
					break;
				default:
					message.put("text", "我還看不懂，我目前只看得懂以下指令" + "\n" + ":下周油價" + "\n" + ":音樂推薦");
					break;
			}
			messages.put(message);
			body.put("replyToken", replyToken);
			body.put("messages", messages);
			sendLinePlatform(body);
		}}}
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
