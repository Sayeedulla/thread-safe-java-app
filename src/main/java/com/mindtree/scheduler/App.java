package com.mindtree.scheduler;
import com.mindtree.scheduler.service.impl.ThreadServiceImpl;
import com.mindtree.scheduler.service.ThreadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public class App {
   private static final Logger LOGGER=LoggerFactory.getLogger(App.class);
    public static void main(String[] args) throws InterruptedException {

      ThreadService threadService=new ThreadServiceImpl();
      Scanner scan=new Scanner(System.in);

      LOGGER.info("Enter the No of data To be written On Map");

       threadService.writeDataToMap(scan.nextInt());

    }
}
