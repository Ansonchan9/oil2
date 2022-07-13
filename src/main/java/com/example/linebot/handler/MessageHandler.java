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
		Document document1 = Jsoup.connect("https://www.kiss.com.tw/music/billboard.php").get();
		Element items1 = document1.getElementById("content");
		Document document2 = Jsoup.connect("https://www.kiss.com.tw/music/billboard.php?a=3").get();
		Element items2 = document1.getElementById("content");
		for (Element item : items) {
			String title1 = item.getElementsByClass("main").get(0).getElementsByTag("p").get(0).text();
			String title = item.getElementsByClass("main").get(0).getElementsByTag("h2").get(0).text();
//華語
			String page=items1.getElementsByClass("pagename").get(0).text();
			String list1 = items1.getElementsByTag("th").get(1).text();
			String list2 = items1.getElementsByTag("th").get(2).text();
			String list3 = items1.getElementsByTag("th").get(3).text();
			String singer11 = items1.getElementById("billboard").getElementsByTag("td").get(1).text();
			String singer12 = items1.getElementById("billboard").getElementsByTag("td").get(2).text();
			String singer13 = items1.getElementById("billboard").getElementsByTag("td").get(3).text();

			String singer21 = items1.getElementById("billboard").getElementsByTag("td").get(9).text();
			String singer22 = items1.getElementById("billboard").getElementsByTag("td").get(10).text();
			String singer23 = items1.getElementById("billboard").getElementsByTag("td").get(11).text();

			String singer31 = items1.getElementById("billboard").getElementsByTag("td").get(17).text();
			String singer32 = items1.getElementById("billboard").getElementsByTag("td").get(18).text();
			String singer33 = items1.getElementById("billboard").getElementsByTag("td").get(19).text();
			//西洋
			String page3=items2.getElementsByClass("pagename").get(0).text();
			String singer311 = items2.getElementById("billboard").getElementsByTag("td").get(1).text();
			String singer312 = items2.getElementById("billboard").getElementsByTag("td").get(2).text();
			String singer313 = items2.getElementById("billboard").getElementsByTag("td").get(3).text();

			String singer321 = items2.getElementById("billboard").getElementsByTag("td").get(9).text();
			String singer322 = items2.getElementById("billboard").getElementsByTag("td").get(10).text();
			String singer323 = items2.getElementById("billboard").getElementsByTag("td").get(11).text();

			String singer331 = items2.getElementById("billboard").getElementsByTag("td").get(17).text();
			String singer332 = items2.getElementById("billboard").getElementsByTag("td").get(18).text();
			String singer333 = items2.getElementById("billboard").getElementsByTag("td").get(19).text();
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
				message.put("text", "哈囉，我是全能小幫手");
				break;
			case "下周油價":
				message.put("text", "下周油價："+"\n"+title1+title);
				break;
			case "下週油價":
				message.put("text", "下週油價："+"\n"+title1+title);
				break;
			case "最新華語音樂排名":
				message.put("text", page+"\n"+"第一名："+list1 +":"+ singer11+"\n"+ list2 +":"+ singer12+"\n"+list3 +":"+ singer13+"\n"+
						"第二名："+list1 +":"+ singer21+"\n"+ list2 +":"+ singer22+"\n"+list3 +":"+ singer23+"\n"+
						"第三名："+list1 +":"+ singer31+"\n"+ list2 +":"+ singer32+"\n"+list3 +":"+ singer33+"\n"
				);
				break;
			case "最新西洋音樂排名":
				message.put("text", page+"\n"+"第一名："+list1 +":"+ singer311+"\n"+ list2 +":"+ singer312+"\n"+list3 +":"+ singer313+"\n"+
						"第二名："+list1 +":"+ singer321+"\n"+ list2 +":"+ singer322+"\n"+list3 +":"+ singer323+"\n"+
						"第三名："+list1 +":"+ singer331+"\n"+ list2 +":"+ singer332+"\n"+list3 +":"+ singer333+"\n"
				);
				break;
			default:
				message.put("text", "我還看不懂，我目前只看得懂以下指令"+"\n"+":下周油價");
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
