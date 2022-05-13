
package com.sptech.slackintegrationfordemo;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SlackIntegrationTest {
    
    private static String webHookUrl = "https://hooks.slack.com/services/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";
    private static String oAuthToken = "xoxb-3492305501682-3485679261766-lSufO8TIUPu273t3YVP1FmNu";
    private static String slackChannel = "automationdemochannel";
    
    
    
    public static void main(String[] args)  {
        try {
            sendMessageToSlack("Ops! Notamos um alto consumo na sua memoria RAM!, nosso script de correção será executado");
        } catch (IOException ex) {
            Logger.getLogger(SlackIntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
