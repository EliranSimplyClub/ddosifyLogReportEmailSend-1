import Utilities.EmailHandling;
import Utilities.LogFileHandling;

import java.io.*;



public class Main {

    public static void main(String[] args) {

        String JenkinsLogLocation = "C:\\Users\\User\\IdeaProjects\\ddosify_0.7.5_windows_amd64\\ddosifyLogFile.txt";
        String EmailLog_dosifyLogFile = "C:\\Users\\User\\IdeaProjects\\ddosify_0.7.5_windows_amd64\\LogFile\\EmailLog_dosifyLogFile.txt";

        LogFileHandling.DeleteFile("EmailLog_dosifyLogFile", "C:\\Users\\User\\IdeaProjects\\ddosify_0.7.5_windows_amd64");
        LogFileHandling.CreateFile("EmailLog_ddosifyLogFile", "C:\\Users\\User\\IdeaProjects\\ddosify_0.7.5_windows_amd64");

        String line = null;

        String encoding = "UTF-8";
        File file = new File(JenkinsLogLocation);

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding))) {

                while ((line = br.readLine()) != null) {
                    //System.out.println(line);
                    LogFileHandling.WriteToFile("EmailLog_dosifyLogFile", line, "C:\\Users\\User\\IdeaProjects\\ddosify_0.7.5_windows_amd64");

                }
                String l = br.lines().toString();
                //System.out.println(EmailLog_dosifyLogFile);
                EmailHandling.sendEnmail(EmailLog_dosifyLogFile, "Jenkins_ddosifyLog");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("file doesn't exist");
        }


    }//end main

}
