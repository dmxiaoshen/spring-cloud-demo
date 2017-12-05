package com.dmxiaoshen;

import com.dmxiaoshen.client.DateServiceClient;
import com.dmxiaoshen.entity.Music;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableFeignClients
public class SpringCloudDateConsumerFeignApplicationTests {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private DateServiceClient dateServiceClient;

	@Test
	public void testGetMusic(){
		Music music = new Music();
		music.setName("上海滩");
		music.setPublishDate(new Date());
		music.setCreateTime(new Date());
		music.setUpdateTime(new Date());
		Music result = dateServiceClient.getMusic(music);
		logger.info("music is:{}",result.toString());
	}

	@Test
	public void testQueryMusic(){
		Music music = dateServiceClient.queryMusic(new Date());
		logger.info("music is:{}",music.toString());
	}

	@Test
	public void testAdd(){
		Music music = new Music();
		music.setName("忘情水");
		music.setDescription("一首好歌");
		music.setPublishDate(new Date());
		music.setCreateTime(new Date());
		music.setUpdateTime(new Date());
		Music result = dateServiceClient.add(music);
		logger.info("music is:{}",result.toString());
	}

}
