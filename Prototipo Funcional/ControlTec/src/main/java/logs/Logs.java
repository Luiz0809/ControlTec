package logs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logs {

    public void captarLogs(String captar) {
        File diretorio = new File("Logs");
        diretorio.mkdir();
        String arquivoData = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());
        String arquivoNome = String.format("Logs/%s.txt", arquivoData);
        String dataRegistro = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());

        File arquivo = new File(arquivoNome);

        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(arquivo, true), true);
            writer.print(dataRegistro);
            writer.println(captar);

            writer.close();
        } catch (IOException e) {
            System.out.println(" Error: Ocorreu um erro ao gerar os logs.");
            e.printStackTrace();

        }
    }

}