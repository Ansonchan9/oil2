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
		String oil = items.getElementsByClass("main").get(0).text();String rank=items1.getElementsByClass("text").get(0).text();
			String list=items1.getElementsByClass("end_title").get(0).text();
			String song1=items1.getElementsByClass("link_text").get(0).text();
			String singer1=items1.getElementsByClass("link_artist").get(0).text();
			String rank2=items1.getElementsByClass("text").get(1).text();
			String song2=items1.getElementsByClass("link_text").get(1).text();
			String singer2=items1.getElementsByClass("link_artist").get(2).text();
			String rank3=items1.getElementsByClass("text").get(2).text();
			String song3=items1.getElementsByClass("link_text").get(2).text();
			String singer3=items1.getElementsByClass("link_artist").get(4).text();
			String rank4=items1.getElementsByClass("text").get(3).text();
			String song4=items1.getElementsByClass("link_text").get(3).text();
			String singer4=items1.getElementsByClass("link_artist").get(6).text();
			String rank5=items1.getElementsByClass("text").get(4).text();
			String song5=items1.getElementsByClass("link_text").get(4).text();
			String singer5=items1.getElementsByClass("link_artist").get(8).text();

		JSONObject body = new JSONObject();
		JSONArray messages = new JSONArray();
		JSONObject message = new JSONObject();
		message.put("type", "text");
		switch (text){
			case "你好":
				message.put("text", "哈囉，我是全能小幫手Bnson");
				break;
			case "下周油價":
				message.put("text", "下周油價："+"\n"+oil+"\n"+oilup);
				break;
			case "下週油價":
				message.put("text", "下週油價："+"\n"+oil+"\n"+oilup);
				break;
			case "華語歌曲推薦":
				message.put("text", list+"\n"+rank+"\n"+"歌名："+song1+"\n"+"演唱人："+singer1+"\n"
						+rank2+"\n"+"歌名："+song2+"\n"+"演唱人："+singer2+"\n"
						+rank3+"\n"+"歌名："+song3+"\n"+"演唱人："+singer3+"\n"
						+rank4+"\n"+"歌名："+song4+"\n"+"演唱人："+singer4+"\n"
						+rank5+"\n"+"歌名："+song5+"\n"+"演唱人："+singer5);
				break;
			default:
				message.put("text", "我還看不懂，我目前只看得懂以下指令"+"\n"+":下周油價"+"\n"+":音樂推薦");
			break;
		}
		messages.put(message);
		body.put("replyToken", replyToken);
		body.put("messages", messages);
		sendLinePlatform(body);

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
