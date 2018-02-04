package com.kwapisz.nai.scheduled;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
	private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(cron="*/10 * * * * *")
	public void reportCurrentTime(){
		log.info("The time in now {}", dateFormat.format(new Date()));
	}
}
