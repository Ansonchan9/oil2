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
//宜蘭縣
			String loca91 = item2.getElementsByTag("locationName").get(7).text();
			String wx91 = item2.getElementsByTag("parameterName").get(105).text();
			String wx92 = item2.getElementsByTag("parameterName").get(106).text();
			String wx93 = item2.getElementsByTag("parameterName").get(107).text();
			String pop91 = item2.getElementsByTag("parameterName").get(108).text();
			String pop92 = item2.getElementsByTag("parameterName").get(109).text();
			String pop93 = item2.getElementsByTag("parameterName").get(110).text();
			String mt91 = item2.getElementsByTag("parameterName").get(111).text();
			String mt92 = item2.getElementsByTag("parameterName").get(112).text();
			String mt93 = item2.getElementsByTag("parameterName").get(113).text();
			String ci91 = item2.getElementsByTag("parameterName").get(114).text();
			String ci92 = item2.getElementsByTag("parameterName").get(115).text();
			String ci93 = item2.getElementsByTag("parameterName").get(116).text();
			String ht91 = item2.getElementsByTag("parameterName").get(117).text();
			String ht92 = item2.getElementsByTag("parameterName").get(118).text();
			String ht93 = item2.getElementsByTag("parameterName").get(119).text();
//苗栗縣
			String loca101 = item2.getElementsByTag("locationName").get(8).text();
			String wx101 = item2.getElementsByTag("parameterName").get(120).text();
			String wx102 = item2.getElementsByTag("parameterName").get(121).text();
			String wx103 = item2.getElementsByTag("parameterName").get(122).text();
			String pop101 = item2.getElementsByTag("parameterName").get(123).text();
			String pop102 = item2.getElementsByTag("parameterName").get(124).text();
			String pop103 = item2.getElementsByTag("parameterName").get(125).text();
			String mt101 = item2.getElementsByTag("parameterName").get(126).text();
			String mt102 = item2.getElementsByTag("parameterName").get(127).text();
			String mt103 = item2.getElementsByTag("parameterName").get(128).text();
			String ci101 = item2.getElementsByTag("parameterName").get(129).text();
			String ci102 = item2.getElementsByTag("parameterName").get(130).text();
			String ci103 = item2.getElementsByTag("parameterName").get(131).text();
			String ht101 = item2.getElementsByTag("parameterName").get(132).text();
			String ht102 = item2.getElementsByTag("parameterName").get(133).text();
			String ht103 = item2.getElementsByTag("parameterName").get(134).text();
//雲林縣
			String loca111 = item2.getElementsByTag("locationName").get(9).text();
			String wx111 = item2.getElementsByTag("parameterName").get(135).text();
			String wx112 = item2.getElementsByTag("parameterName").get(136).text();
			String wx113 = item2.getElementsByTag("parameterName").get(137).text();
			String pop111 = item2.getElementsByTag("parameterName").get(138).text();
			String pop112 = item2.getElementsByTag("parameterName").get(139).text();
			String pop113 = item2.getElementsByTag("parameterName").get(140).text();
			String mt111 = item2.getElementsByTag("parameterName").get(141).text();
			String mt112 = item2.getElementsByTag("parameterName").get(142).text();
			String mt113 = item2.getElementsByTag("parameterName").get(143).text();
			String ci111 = item2.getElementsByTag("parameterName").get(144).text();
			String ci112 = item2.getElementsByTag("parameterName").get(145).text();
			String ci113 = item2.getElementsByTag("parameterName").get(146).text();
			String ht111 = item2.getElementsByTag("parameterName").get(147).text();
			String ht112 = item2.getElementsByTag("parameterName").get(148).text();
			String ht113 = item2.getElementsByTag("parameterName").get(149).text();
//花蓮縣
			String loca121 = item2.getElementsByTag("locationName").get(10).text();
			String wx121 = item2.getElementsByTag("parameterName").get(150).text();
			String wx122 = item2.getElementsByTag("parameterName").get(151).text();
			String wx123 = item2.getElementsByTag("parameterName").get(152).text();
			String pop121 = item2.getElementsByTag("parameterName").get(153).text();
			String pop122 = item2.getElementsByTag("parameterName").get(154).text();
			String pop123 = item2.getElementsByTag("parameterName").get(155).text();
			String mt121 = item2.getElementsByTag("parameterName").get(156).text();
			String mt122 = item2.getElementsByTag("parameterName").get(157).text();
			String mt123 = item2.getElementsByTag("parameterName").get(158).text();
			String ci121 = item2.getElementsByTag("parameterName").get(159).text();
			String ci122 = item2.getElementsByTag("parameterName").get(160).text();
			String ci123 = item2.getElementsByTag("parameterName").get(161).text();
			String ht121 = item2.getElementsByTag("parameterName").get(162).text();
			String ht122 = item2.getElementsByTag("parameterName").get(163).text();
			String ht123 = item2.getElementsByTag("parameterName").get(164).text();
//台中市
			String loca131 = item2.getElementsByTag("locationName").get(11).text();
			String wx131 = item2.getElementsByTag("parameterName").get(165).text();
			String wx132 = item2.getElementsByTag("parameterName").get(166).text();
			String wx133 = item2.getElementsByTag("parameterName").get(167).text();
			String pop131 = item2.getElementsByTag("parameterName").get(168).text();
			String pop132 = item2.getElementsByTag("parameterName").get(169).text();
			String pop133 = item2.getElementsByTag("parameterName").get(170).text();
			String mt131 = item2.getElementsByTag("parameterName").get(171).text();
			String mt132 = item2.getElementsByTag("parameterName").get(172).text();
			String mt133 = item2.getElementsByTag("parameterName").get(173).text();
			String ci131 = item2.getElementsByTag("parameterName").get(174).text();
			String ci132 = item2.getElementsByTag("parameterName").get(175).text();
			String ci133 = item2.getElementsByTag("parameterName").get(176).text();
			String ht131 = item2.getElementsByTag("parameterName").get(177).text();
			String ht132 = item2.getElementsByTag("parameterName").get(178).text();
			String ht133 = item2.getElementsByTag("parameterName").get(179).text();
//台東縣
			String loca141 = item2.getElementsByTag("locationName").get(12).text();
			String wx141 = item2.getElementsByTag("parameterName").get(180).text();
			String wx142 = item2.getElementsByTag("parameterName").get(181).text();
			String wx143 = item2.getElementsByTag("parameterName").get(182).text();
			String pop141 = item2.getElementsByTag("parameterName").get(183).text();
			String pop142 = item2.getElementsByTag("parameterName").get(184).text();
			String pop143 = item2.getElementsByTag("parameterName").get(185).text();
			String mt141 = item2.getElementsByTag("parameterName").get(186).text();
			String mt142 = item2.getElementsByTag("parameterName").get(187).text();
			String mt143 = item2.getElementsByTag("parameterName").get(188).text();
			String ci141 = item2.getElementsByTag("parameterName").get(189).text();
			String ci142 = item2.getElementsByTag("parameterName").get(190).text();
			String ci143 = item2.getElementsByTag("parameterName").get(191).text();
			String ht141 = item2.getElementsByTag("parameterName").get(192).text();
			String ht142 = item2.getElementsByTag("parameterName").get(193).text();
			String ht143 = item2.getElementsByTag("parameterName").get(194).text();
//桃園市
			String loca151 = item2.getElementsByTag("locationName").get(13).text();
			String wx151 = item2.getElementsByTag("parameterName").get(195).text();
			String wx152 = item2.getElementsByTag("parameterName").get(196).text();
			String wx153 = item2.getElementsByTag("parameterName").get(197).text();
			String pop151 = item2.getElementsByTag("parameterName").get(198).text();
			String pop152 = item2.getElementsByTag("parameterName").get(199).text();
			String pop153 = item2.getElementsByTag("parameterName").get(200).text();
			String mt151 = item2.getElementsByTag("parameterName").get(201).text();
			String mt152 = item2.getElementsByTag("parameterName").get(202).text();
			String mt153 = item2.getElementsByTag("parameterName").get(203).text();
			String ci151 = item2.getElementsByTag("parameterName").get(204).text();
			String ci152 = item2.getElementsByTag("parameterName").get(205).text();
			String ci153 = item2.getElementsByTag("parameterName").get(206).text();
			String ht151 = item2.getElementsByTag("parameterName").get(207).text();
			String ht152 = item2.getElementsByTag("parameterName").get(208).text();
			String ht153 = item2.getElementsByTag("parameterName").get(209).text();
//南投縣
			String loca161 = item2.getElementsByTag("locationName").get(14).text();
			String wx161 = item2.getElementsByTag("parameterName").get(210).text();
			String wx162 = item2.getElementsByTag("parameterName").get(211).text();
			String wx163 = item2.getElementsByTag("parameterName").get(212).text();
			String pop161 = item2.getElementsByTag("parameterName").get(213).text();
			String pop162 = item2.getElementsByTag("parameterName").get(214).text();
			String pop163 = item2.getElementsByTag("parameterName").get(215).text();
			String mt161 = item2.getElementsByTag("parameterName").get(216).text();
			String mt162 = item2.getElementsByTag("parameterName").get(217).text();
			String mt163 = item2.getElementsByTag("parameterName").get(218).text();
			String ci161 = item2.getElementsByTag("parameterName").get(219).text();
			String ci162 = item2.getElementsByTag("parameterName").get(220).text();
			String ci163 = item2.getElementsByTag("parameterName").get(221).text();
			String ht161 = item2.getElementsByTag("parameterName").get(222).text();
			String ht162 = item2.getElementsByTag("parameterName").get(223).text();
			String ht163 = item2.getElementsByTag("parameterName").get(224).text();
//高雄市
			String loca171 = item2.getElementsByTag("locationName").get(15).text();
			String wx171 = item2.getElementsByTag("parameterName").get(225).text();
			String wx172 = item2.getElementsByTag("parameterName").get(226).text();
			String wx173 = item2.getElementsByTag("parameterName").get(227).text();
			String pop171 = item2.getElementsByTag("parameterName").get(228).text();
			String pop172 = item2.getElementsByTag("parameterName").get(229).text();
			String pop173 = item2.getElementsByTag("parameterName").get(230).text();
			String mt171 = item2.getElementsByTag("parameterName").get(231).text();
			String mt172 = item2.getElementsByTag("parameterName").get(232).text();
			String mt173 = item2.getElementsByTag("parameterName").get(233).text();
			String ci171 = item2.getElementsByTag("parameterName").get(234).text();
			String ci172 = item2.getElementsByTag("parameterName").get(235).text();
			String ci173 = item2.getElementsByTag("parameterName").get(236).text();
			String ht171 = item2.getElementsByTag("parameterName").get(237).text();
			String ht172 = item2.getElementsByTag("parameterName").get(238).text();
			String ht173 = item2.getElementsByTag("parameterName").get(239).text();
//金門縣
			String loca181 = item2.getElementsByTag("locationName").get(16).text();
			String wx181 = item2.getElementsByTag("parameterName").get(240).text();
			String wx182 = item2.getElementsByTag("parameterName").get(241).text();
			String wx183 = item2.getElementsByTag("parameterName").get(242).text();
			String pop181 = item2.getElementsByTag("parameterName").get(243).text();
			String pop182 = item2.getElementsByTag("parameterName").get(244).text();
			String pop183 = item2.getElementsByTag("parameterName").get(245).text();
			String mt181 = item2.getElementsByTag("parameterName").get(246).text();
			String mt182 = item2.getElementsByTag("parameterName").get(247).text();
			String mt183 = item2.getElementsByTag("parameterName").get(248).text();
			String ci181 = item2.getElementsByTag("parameterName").get(249).text();
			String ci182 = item2.getElementsByTag("parameterName").get(250).text();
			String ci183 = item2.getElementsByTag("parameterName").get(251).text();
			String ht181 = item2.getElementsByTag("parameterName").get(252).text();
			String ht182 = item2.getElementsByTag("parameterName").get(253).text();
			String ht183 = item2.getElementsByTag("parameterName").get(254).text();
//屏東縣
			String loca191 = item2.getElementsByTag("locationName").get(17).text();
			String wx191 = item2.getElementsByTag("parameterName").get(255).text();
			String wx192 = item2.getElementsByTag("parameterName").get(256).text();
			String wx193 = item2.getElementsByTag("parameterName").get(257).text();
			String pop191 = item2.getElementsByTag("parameterName").get(258).text();
			String pop192 = item2.getElementsByTag("parameterName").get(259).text();
			String pop193 = item2.getElementsByTag("parameterName").get(260).text();
			String mt191 = item2.getElementsByTag("parameterName").get(261).text();
			String mt192 = item2.getElementsByTag("parameterName").get(262).text();
			String mt193 = item2.getElementsByTag("parameterName").get(263).text();
			String ci191 = item2.getElementsByTag("parameterName").get(264).text();
			String ci192 = item2.getElementsByTag("parameterName").get(265).text();
			String ci193 = item2.getElementsByTag("parameterName").get(266).text();
			String ht191 = item2.getElementsByTag("parameterName").get(267).text();
			String ht192 = item2.getElementsByTag("parameterName").get(268).text();
			String ht193 = item2.getElementsByTag("parameterName").get(269).text();
//基隆市
			String loca201 = item2.getElementsByTag("locationName").get(18).text();
			String wx201 = item2.getElementsByTag("parameterName").get(270).text();
			String wx202 = item2.getElementsByTag("parameterName").get(271).text();
			String wx203 = item2.getElementsByTag("parameterName").get(272).text();
			String pop201 = item2.getElementsByTag("parameterName").get(273).text();
			String pop202 = item2.getElementsByTag("parameterName").get(274).text();
			String pop203 = item2.getElementsByTag("parameterName").get(275).text();
			String mt201 = item2.getElementsByTag("parameterName").get(276).text();
			String mt202 = item2.getElementsByTag("parameterName").get(277).text();
			String mt203 = item2.getElementsByTag("parameterName").get(278).text();
			String ci201 = item2.getElementsByTag("parameterName").get(279).text();
			String ci202 = item2.getElementsByTag("parameterName").get(280).text();
			String ci203 = item2.getElementsByTag("parameterName").get(281).text();
			String ht201 = item2.getElementsByTag("parameterName").get(282).text();
			String ht202 = item2.getElementsByTag("parameterName").get(283).text();
			String ht203 = item2.getElementsByTag("parameterName").get(284).text();
//澎湖縣
			String loca211 = item2.getElementsByTag("locationName").get(19).text();
			String wx211 = item2.getElementsByTag("parameterName").get(285).text();
			String wx212 = item2.getElementsByTag("parameterName").get(286).text();
			String wx213 = item2.getElementsByTag("parameterName").get(287).text();
			String pop211 = item2.getElementsByTag("parameterName").get(288).text();
			String pop212 = item2.getElementsByTag("parameterName").get(289).text();
			String pop213 = item2.getElementsByTag("parameterName").get(290).text();
			String mt211 = item2.getElementsByTag("parameterName").get(291).text();
			String mt212 = item2.getElementsByTag("parameterName").get(292).text();
			String mt213 = item2.getElementsByTag("parameterName").get(293).text();
			String ci211 = item2.getElementsByTag("parameterName").get(294).text();
			String ci212 = item2.getElementsByTag("parameterName").get(295).text();
			String ci213 = item2.getElementsByTag("parameterName").get(296).text();
			String ht211 = item2.getElementsByTag("parameterName").get(297).text();
			String ht212 = item2.getElementsByTag("parameterName").get(298).text();
			String ht213 = item2.getElementsByTag("parameterName").get(299).text();
//彰化市
			String loca221 = item2.getElementsByTag("locationName").get(20).text();
			String wx221 = item2.getElementsByTag("parameterName").get(300).text();
			String wx222 = item2.getElementsByTag("parameterName").get(301).text();
			String wx223 = item2.getElementsByTag("parameterName").get(302).text();
			String pop221 = item2.getElementsByTag("parameterName").get(303).text();
			String pop222 = item2.getElementsByTag("parameterName").get(304).text();
			String pop223 = item2.getElementsByTag("parameterName").get(305).text();
			String mt221 = item2.getElementsByTag("parameterName").get(306).text();
			String mt222 = item2.getElementsByTag("parameterName").get(307).text();
			String mt223 = item2.getElementsByTag("parameterName").get(308).text();
			String ci221 = item2.getElementsByTag("parameterName").get(309).text();
			String ci222 = item2.getElementsByTag("parameterName").get(310).text();
			String ci223 = item2.getElementsByTag("parameterName").get(311).text();
			String ht221 = item2.getElementsByTag("parameterName").get(312).text();
			String ht222 = item2.getElementsByTag("parameterName").get(313).text();
			String ht223 = item2.getElementsByTag("parameterName").get(314).text();
//連江縣
			String loca231 = item2.getElementsByTag("locationName").get(21).text();
			String wx231 = item2.getElementsByTag("parameterName").get(315).text();
			String wx232 = item2.getElementsByTag("parameterName").get(316).text();
			String wx233 = item2.getElementsByTag("parameterName").get(317).text();
			String pop231 = item2.getElementsByTag("parameterName").get(318).text();
			String pop232 = item2.getElementsByTag("parameterName").get(319).text();
			String pop233 = item2.getElementsByTag("parameterName").get(320).text();
			String mt231 = item2.getElementsByTag("parameterName").get(321).text();
			String mt232 = item2.getElementsByTag("parameterName").get(322).text();
			String mt233 = item2.getElementsByTag("parameterName").get(323).text();
			String ci231 = item2.getElementsByTag("parameterName").get(324).text();
			String ci232 = item2.getElementsByTag("parameterName").get(325).text();
			String ci233 = item2.getElementsByTag("parameterName").get(326).text();
			String ht231 = item2.getElementsByTag("parameterName").get(327).text();
			String ht232 = item2.getElementsByTag("parameterName").get(328).text();
			String ht233 = item2.getElementsByTag("parameterName").get(329).text();


			JSONObject body = new JSONObject();
			JSONArray messages = new JSONArray();
			JSONObject message = new JSONObject();
			message.put("type", "text");
			String 台東 = list + "\n" + loca141 + "\n" + st21 + "\n" + "~" + "\n" + et21 + "\n" + "氣溫：" + mt141 + "度" + "~" + ht141 + "度" + "\n" + "天氣狀況：" + wx141 + "\n" + "降雨機率：" + pop141 + "%" + "\n" + "體感：" + ci141 + "\n" + "-" + "\n"
					+ st22 + "\n" + "~" + "\n" + et22 + "\n" + "氣溫：" + mt142 + "度" + "~" + ht142 + "度" + "\n" + "天氣狀況：" + wx142 + "\n" + "降雨機率：" + pop142 + "%" + "\n" + "體感：" + ci142 + "\n" + "-" + "\n"
					+ st23 + "\n" + "~" + "\n" + et23 + "\n" + "氣溫：" + mt143 + "度" + "~" + ht143 + "度" + "\n" + "天氣狀況：" + wx143 + "\n" + "降雨機率：" + pop143 + "%" + "\n" + "體感：" + ci143 + "\n" + "-" + "\n";
			String 台中 = list + "\n" + loca131 + "\n" + st21 + "\n" + "~" + "\n" + et21 + "\n" + "氣溫：" + mt131 + "度" + "~" + ht131 + "度" + "\n" + "天氣狀況：" + wx131 + "\n" + "降雨機率：" + pop131 + "%" + "\n" + "體感：" + ci131 + "\n" + "-" + "\n"
					+ st22 + "\n" + "~" + "\n" + et22 + "\n" + "氣溫：" + mt132 + "度" + "~" + ht132 + "度" + "\n" + "天氣狀況：" + wx132 + "\n" + "降雨機率：" + pop132 + "%" + "\n" + "體感：" + ci132 + "\n" + "-" + "\n"
					+ st23 + "\n" + "~" + "\n" + et23 + "\n" + "氣溫：" + mt133 + "度" + "~" + ht133 + "度" + "\n" + "天氣狀況：" + wx133 + "\n" + "降雨機率：" + pop133 + "%" + "\n" + "體感：" + ci133 + "\n" + "-" + "\n";
			String 台南 = list + "\n" + loca81 + "\n" + st21 + "\n" + "~" + "\n" + et21 + "\n" + "氣溫：" + mt81 + "度" + "~" + ht81 + "度" + "\n" + "天氣狀況：" + wx81 + "\n" + "降雨機率：" + pop81 + "%" + "\n" + "體感：" + ci81 + "\n" + "-" + "\n"
					+ st22 + "\n" + "~" + "\n" + et22 + "\n" + "氣溫：" + mt82 + "度" + "~" + ht82 + "度" + "\n" + "天氣狀況：" + wx82 + "\n" + "降雨機率：" + pop82 + "%" + "\n" + "體感：" + ci82 + "\n" + "-" + "\n"
					+ st23 + "\n" + "~" + "\n" + et23 + "\n" + "氣溫：" + mt83 + "度" + "~" + ht83 + "度" + "\n" + "天氣狀況：" + wx83 + "\n" + "降雨機率：" + pop83 + "%" + "\n" + "體感：" + ci83 + "\n" + "-" + "\n";
			String 台北 = list + "\n" + loca71 + "\n" + st21 + "\n" + "~" + "\n" + et21 + "\n" + "氣溫：" + mt71 + "度" + "~" + ht71 + "度" + "\n" + "天氣狀況：" + wx71 + "\n" + "降雨機率：" + pop71 + "%" + "\n" + "體感：" + ci71 + "\n" + "-" + "\n"
					+ st22 + "\n" + "~" + "\n" + et22 + "\n" + "氣溫：" + mt72 + "度" + "~" + ht72 + "度" + "\n" + "天氣狀況：" + wx72 + "\n" + "降雨機率：" + pop72 + "%" + "\n" + "體感：" + ci72 + "\n" + "-" + "\n"
					+ st23 + "\n" + "~" + "\n" + et23 + "\n" + "氣溫：" + mt73 + "度" + "~" + ht73 + "度" + "\n" + "天氣狀況：" + wx73 + "\n" + "降雨機率：" + pop73 + "%" + "\n" + "體感：" + ci73 + "\n" + "-" + "\n";
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
							message.put("text", 台北
							);
				break;
				case "臺北市天氣":
					message.put("text", 台北
					);
					break;
				case "台南市天氣":
							message.put("text", 台南
							);
				break;
				case "臺南市天氣":
					message.put("text", 台南
					);
					break;
						case "宜蘭縣天氣":
						message.put("text",list +"\n" +loca91+"\n"+st21+"\n"+"~"+"\n"+et21+"\n"+"氣溫："+mt91+"度"+"~"+ht91+"度"+"\n"+"天氣狀況："+wx91+"\n"+"降雨機率："+pop91+"%"+"\n"+"體感："+ci91+"\n"+"-"+"\n"
								+st22+"\n"+"~"+"\n"+et22+"\n"+"氣溫："+mt92+"度"+"~"+ht92+"度"+"\n"+"天氣狀況："+wx92+"\n"+"降雨機率："+pop92+"%"+"\n"+"體感："+ci92+"\n"+"-"+"\n"
								+st23+"\n"+"~"+"\n"+et23+"\n"+"氣溫："+mt93+"度"+"~"+ht93+"度"+"\n"+"天氣狀況："+wx93+"\n"+"降雨機率："+pop93+"%"+"\n"+"體感："+ci93+"\n"+"-"+"\n"
						);
						break;
						case "苗栗縣天氣":
							message.put("text",list +"\n" +loca101+"\n"+st21+"\n"+"~"+"\n"+et21+"\n"+"氣溫："+mt101+"度"+"~"+ht101+"度"+"\n"+"天氣狀況："+wx101+"\n"+"降雨機率："+pop101+"%"+"\n"+"體感："+ci101+"\n"+"-"+"\n"
									+st22+"\n"+"~"+"\n"+et22+"\n"+"氣溫："+mt102+"度"+"~"+ht102+"度"+"\n"+"天氣狀況："+wx102+"\n"+"降雨機率："+pop102+"%"+"\n"+"體感："+ci102+"\n"+"-"+"\n"
									+st23+"\n"+"~"+"\n"+et23+"\n"+"氣溫："+mt103+"度"+"~"+ht103+"度"+"\n"+"天氣狀況："+wx103+"\n"+"降雨機率："+pop103+"%"+"\n"+"體感："+ci103+"\n"+"-"+"\n"
							);
							break;
						case "雲林縣天氣":
							message.put("text",list +"\n" +loca111+"\n"+st21+"\n"+"~"+"\n"+et21+"\n"+"氣溫："+mt111+"度"+"~"+ht111+"度"+"\n"+"天氣狀況："+wx111+"\n"+"降雨機率："+pop111+"%"+"\n"+"體感："+ci111+"\n"+"-"+"\n"
									+st22+"\n"+"~"+"\n"+et22+"\n"+"氣溫："+mt112+"度"+"~"+ht112+"度"+"\n"+"天氣狀況："+wx112+"\n"+"降雨機率："+pop112+"%"+"\n"+"體感："+ci112+"\n"+"-"+"\n"
									+st23+"\n"+"~"+"\n"+et23+"\n"+"氣溫："+mt113+"度"+"~"+ht113+"度"+"\n"+"天氣狀況："+wx113+"\n"+"降雨機率："+pop113+"%"+"\n"+"體感："+ci113+"\n"+"-"+"\n"
							);
							break;
						case "花蓮縣天氣":
							message.put("text",list +"\n" +loca121+"\n"+st21+"\n"+"~"+"\n"+et21+"\n"+"氣溫："+mt121+"度"+"~"+ht121+"度"+"\n"+"天氣狀況："+wx121+"\n"+"降雨機率："+pop121+"%"+"\n"+"體感："+ci121+"\n"+"-"+"\n"
									+st22+"\n"+"~"+"\n"+et22+"\n"+"氣溫："+mt122+"度"+"~"+ht122+"度"+"\n"+"天氣狀況："+wx122+"\n"+"降雨機率："+pop122+"%"+"\n"+"體感："+ci122+"\n"+"-"+"\n"
									+st23+"\n"+"~"+"\n"+et23+"\n"+"氣溫："+mt123+"度"+"~"+ht123+"度"+"\n"+"天氣狀況："+wx123+"\n"+"降雨機率："+pop123+"%"+"\n"+"體感："+ci123+"\n"+"-"+"\n"
							);
							break;
						case "台中市天氣":
							message.put("text", 台中
							);
							break;
				case "臺中市天氣":
					message.put("text", 台中
					);
					break;
						case "台東縣天氣":
							message.put("text", 台東
							);
							break;
						case "臺東縣天氣":
							message.put("text", 台東
							);
							break;
						case "桃園市天氣":
							message.put("text",list +"\n" +loca151+"\n"+st21+"\n"+"~"+"\n"+et21+"\n"+"氣溫："+mt151+"度"+"~"+ht151+"度"+"\n"+"天氣狀況："+wx151+"\n"+"降雨機率："+pop151+"%"+"\n"+"體感："+ci151+"\n"+"-"+"\n"
									+st22+"\n"+"~"+"\n"+et22+"\n"+"氣溫："+mt152+"度"+"~"+ht152+"度"+"\n"+"天氣狀況："+wx152+"\n"+"降雨機率："+pop152+"%"+"\n"+"體感："+ci152+"\n"+"-"+"\n"
									+st23+"\n"+"~"+"\n"+et23+"\n"+"氣溫："+mt153+"度"+"~"+ht153+"度"+"\n"+"天氣狀況："+wx153+"\n"+"降雨機率："+pop153+"%"+"\n"+"體感："+ci153+"\n"+"-"+"\n"
							);
							break;
						case "南投縣天氣":
							message.put("text",list +"\n" +loca161+"\n"+st21+"\n"+"~"+"\n"+et21+"\n"+"氣溫："+mt161+"度"+"~"+ht161+"度"+"\n"+"天氣狀況："+wx161+"\n"+"降雨機率："+pop161+"%"+"\n"+"體感："+ci161+"\n"+"-"+"\n"
									+st22+"\n"+"~"+"\n"+et22+"\n"+"氣溫："+mt162+"度"+"~"+ht162+"度"+"\n"+"天氣狀況："+wx162+"\n"+"降雨機率："+pop162+"%"+"\n"+"體感："+ci162+"\n"+"-"+"\n"
									+st23+"\n"+"~"+"\n"+et23+"\n"+"氣溫："+mt163+"度"+"~"+ht163+"度"+"\n"+"天氣狀況："+wx163+"\n"+"降雨機率："+pop163+"%"+"\n"+"體感："+ci163+"\n"+"-"+"\n"
							);
							break;
						case "高雄市天氣":
							message.put("text",list +"\n" +loca171+"\n"+st21+"\n"+"~"+"\n"+et21+"\n"+"氣溫："+mt171+"度"+"~"+ht171+"度"+"\n"+"天氣狀況："+wx171+"\n"+"降雨機率："+pop171+"%"+"\n"+"體感："+ci171+"\n"+"-"+"\n"
									+st22+"\n"+"~"+"\n"+et22+"\n"+"氣溫："+mt172+"度"+"~"+ht172+"度"+"\n"+"天氣狀況："+wx172+"\n"+"降雨機率："+pop172+"%"+"\n"+"體感："+ci172+"\n"+"-"+"\n"
									+st23+"\n"+"~"+"\n"+et23+"\n"+"氣溫："+mt173+"度"+"~"+ht173+"度"+"\n"+"天氣狀況："+wx173+"\n"+"降雨機率："+pop173+"%"+"\n"+"體感："+ci173+"\n"+"-"+"\n"
							);
							break;
						case "金門縣天氣":
							message.put("text",list +"\n" +loca181+"\n"+st21+"\n"+"~"+"\n"+et21+"\n"+"氣溫："+mt181+"度"+"~"+ht181+"度"+"\n"+"天氣狀況："+wx181+"\n"+"降雨機率："+pop181+"%"+"\n"+"體感："+ci181+"\n"+"-"+"\n"
									+st22+"\n"+"~"+"\n"+et22+"\n"+"氣溫："+mt182+"度"+"~"+ht182+"度"+"\n"+"天氣狀況："+wx182+"\n"+"降雨機率："+pop182+"%"+"\n"+"體感："+ci182+"\n"+"-"+"\n"
									+st23+"\n"+"~"+"\n"+et23+"\n"+"氣溫："+mt183+"度"+"~"+ht183+"度"+"\n"+"天氣狀況："+wx183+"\n"+"降雨機率："+pop183+"%"+"\n"+"體感："+ci183+"\n"+"-"+"\n"
							);
							break;
						case "屏東縣天氣":
							message.put("text",list +"\n" +loca191+"\n"+st21+"\n"+"~"+"\n"+et21+"\n"+"氣溫："+mt191+"度"+"~"+ht191+"度"+"\n"+"天氣狀況："+wx191+"\n"+"降雨機率："+pop191+"%"+"\n"+"體感："+ci191+"\n"+"-"+"\n"
									+st22+"\n"+"~"+"\n"+et22+"\n"+"氣溫："+mt192+"度"+"~"+ht192+"度"+"\n"+"天氣狀況："+wx192+"\n"+"降雨機率："+pop192+"%"+"\n"+"體感："+ci192+"\n"+"-"+"\n"
									+st23+"\n"+"~"+"\n"+et23+"\n"+"氣溫："+mt193+"度"+"~"+ht193+"度"+"\n"+"天氣狀況："+wx193+"\n"+"降雨機率："+pop193+"%"+"\n"+"體感："+ci193+"\n"+"-"+"\n"
							);
							break;
						case "基隆市天氣":
							message.put("text",list +"\n" +loca201+"\n"+st21+"\n"+"~"+"\n"+et21+"\n"+"氣溫："+mt201+"度"+"~"+ht201+"度"+"\n"+"天氣狀況："+wx201+"\n"+"降雨機率："+pop201+"%"+"\n"+"體感："+ci201+"\n"+"-"+"\n"
									+st22+"\n"+"~"+"\n"+et22+"\n"+"氣溫："+mt202+"度"+"~"+ht202+"度"+"\n"+"天氣狀況："+wx202+"\n"+"降雨機率："+pop202+"%"+"\n"+"體感："+ci202+"\n"+"-"+"\n"
									+st23+"\n"+"~"+"\n"+et23+"\n"+"氣溫："+mt203+"度"+"~"+ht203+"度"+"\n"+"天氣狀況："+wx203+"\n"+"降雨機率："+pop203+"%"+"\n"+"體感："+ci203+"\n"+"-"+"\n"
							);
							break;
						case "澎湖縣天氣":
							message.put("text",list +"\n" +loca211+"\n"+st21+"\n"+"~"+"\n"+et21+"\n"+"氣溫："+mt211+"度"+"~"+ht211+"度"+"\n"+"天氣狀況："+wx211+"\n"+"降雨機率："+pop211+"%"+"\n"+"體感："+ci211+"\n"+"-"+"\n"
									+st22+"\n"+"~"+"\n"+et22+"\n"+"氣溫："+mt212+"度"+"~"+ht212+"度"+"\n"+"天氣狀況："+wx212+"\n"+"降雨機率："+pop212+"%"+"\n"+"體感："+ci212+"\n"+"-"+"\n"
									+st23+"\n"+"~"+"\n"+et23+"\n"+"氣溫："+mt213+"度"+"~"+ht213+"度"+"\n"+"天氣狀況："+wx213+"\n"+"降雨機率："+pop213+"%"+"\n"+"體感："+ci213+"\n"+"-"+"\n"
							);
							break;
						case "彰化市天氣":
							message.put("text",list +"\n" +loca221+"\n"+st21+"\n"+"~"+"\n"+et21+"\n"+"氣溫："+mt221+"度"+"~"+ht221+"度"+"\n"+"天氣狀況："+wx221+"\n"+"降雨機率："+pop221+"%"+"\n"+"體感："+ci221+"\n"+"-"+"\n"
									+st22+"\n"+"~"+"\n"+et22+"\n"+"氣溫："+mt222+"度"+"~"+ht222+"度"+"\n"+"天氣狀況："+wx222+"\n"+"降雨機率："+pop222+"%"+"\n"+"體感："+ci222+"\n"+"-"+"\n"
									+st23+"\n"+"~"+"\n"+et23+"\n"+"氣溫："+mt223+"度"+"~"+ht223+"度"+"\n"+"天氣狀況："+wx223+"\n"+"降雨機率："+pop223+"%"+"\n"+"體感："+ci223+"\n"+"-"+"\n"
							);
							break;
						case "連江縣天氣":
							message.put("text",list +"\n" +loca231+"\n"+st21+"\n"+"~"+"\n"+et21+"\n"+"氣溫："+mt231+"度"+"~"+ht231+"度"+"\n"+"天氣狀況："+wx231+"\n"+"降雨機率："+pop231+"%"+"\n"+"體感："+ci231+"\n"+"-"+"\n"
									+st22+"\n"+"~"+"\n"+et22+"\n"+"氣溫："+mt232+"度"+"~"+ht232+"度"+"\n"+"天氣狀況："+wx232+"\n"+"降雨機率："+pop232+"%"+"\n"+"體感："+ci232+"\n"+"-"+"\n"
									+st23+"\n"+"~"+"\n"+et23+"\n"+"氣溫："+mt233+"度"+"~"+ht233+"度"+"\n"+"天氣狀況："+wx233+"\n"+"降雨機率："+pop233+"%"+"\n"+"體感："+ci233+"\n"+"-"+"\n"
							);
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
