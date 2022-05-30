
package com.mycompany.controltec.slack;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SlackIntegrationTest {
    
    private static String webHookUrl = "https://hooks.slack.com/services/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";
    private static String oAuthToken = "xoxb-3492305501682-3485679261766-vj0MeGCmQiTgOgL0x9VRA9R8";
    private static String slackChannel = "automationdemochannel";
    
  public static void sendMessageToSlack(String message) throws IOException{
      
      try{
          
           StringBuilder msgbuilder = new StringBuilder();
      msgbuilder.append(message);
      
      Payload payload = Payload.builder().channel(slackChannel).text(msgbuilder.toString()).build();
      
      WebhookResponse wbResp = Slack.getInstance().send(webHookUrl, payload);
          
      }catch(Exception e){
          e.printStackTrace();
      }
          
      
     
      
  }
  
    
}
