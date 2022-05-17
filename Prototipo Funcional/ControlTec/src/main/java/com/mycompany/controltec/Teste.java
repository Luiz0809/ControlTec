
package com.mycompany.controltec;

import com.mycompany.controltec.slack.SlackIntegrationTest;
import java.io.IOException;

public class Teste {
    public static void main(String[] args) throws IOException {
        SlackIntegrationTest.sendMessageToSlack("Bom dia negão");
    }
}
