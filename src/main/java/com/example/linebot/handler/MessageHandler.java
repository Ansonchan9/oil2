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
		Elements items = document.getElementsByClass("scroll");
		Document document1 = Jsoup.connect("https://music-tw.line.me/chart/99").get();
		Elements items1 = document1.getElementsByClass("scroll");

		for (Element item : items) {
			String title1 = item.getElementsByClass("main").get(0).getElementsByTag("p").get(0).text();
			String title = item.getElementsByClass("main").get(0).getElementsByTag("h2").get(0).text();
			String quote = "";
			if (item.getElementsByClass("quote").size() > 0) {
				quote = item.getElementsByClass("quote").get(0).text();
			}

		JSONObject body = new JSONObject();
		JSONArray messages = new JSONArray();
		JSONObject message = new JSONObject();
		message.put("type", "text");
		switch (text){
			case "你好":
				message.put("text", "哈囉，我是油價小幫手");
				break;
			case "下周油價":
				message.put("text", "下周油價："+"\n"+title1+title);
				break;
			case "下週油價":
				message.put("text", "下週油價："+"\n"+title1+title);
				break;
	
		}
		messages.put(message);
		body.put("replyToken", replyToken);
		body.put("messages", messages);
		sendLinePlatform(body);
			}
			
			for (Element item : items1) {
				String title1 = item.getElementsByClass("title_badge_wrap").get(0).text();
				String title = item.getElementsByClass("title_badge_wrap").get(0).text();
				String quote = "";
				if (item.getElementsByClass("quote").size() > 0) {
					quote = item.getElementsByClass("quote").get(0).text();
				}
	
			JSONObject body = new JSONObject();
			JSONArray messages = new JSONArray();
			JSONObject message = new JSONObject();
			message.put("type", "text");
			switch (text){
				case "排行":
					message.put("text", "哈囉，我是油價小幫手");
					break;
				case "下周油價":
					message.put("text", "下周油價："+"\n"+title1+title);
					break;
				case "下週油價":
					message.put("text", "下週油價："+"\n"+title1+title);
					break;
		
			}
			messages.put(message);
			body.put("replyToken", replyToken);
			body.put("messages", messages);
			sendLinePlatform(body);
				}
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
