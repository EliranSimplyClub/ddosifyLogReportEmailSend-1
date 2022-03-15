import Utilities.EmailHandling;
import Utilities.InfrastructureMainFunction;
import Utilities.LogFileHandling;

import java.io.*;



public class Main {

    public static void main(String[] args) {

        createDirctory();

        String JenkinsLogLocation = "C:\\Simply\\QA_Automation\\ddosify_0.7.5_windows_amd64\\ddosifyLogFile.txt";
        System.out.println("1");
        String EmailLog_dosifyLogFile = "C:\\Simply\\QA_Automation\\ddosify_0.7.5_windows_amd64\\LogFile\\EmailLog_dosifyLogFile.txt";

        System.out.println("2");
        LogFileHandling.DeleteFile("EmailLog_dosifyLogFile", "C:\\Simply\\QA_Automation\\ddosify_0.7.5_windows_amd64");
        System.out.println("3");
        LogFileHandling.CreateFile("EmailLog_ddosifyLogFile", "C:\\Simply\\QA_Automation\\ddosify_0.7.5_windows_amd64");
        System.out.println("4");

        String line = null;

        String encoding = "UTF-8";
        File file = new File(JenkinsLogLocation);

        System.out.println("HOME_DIRECTORY: "+InfrastructureMainFunction.GetLocalDir());

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding))) {

                while ((line = br.readLine()) != null) {
                    //System.out.println(line);
                    LogFileHandling.WriteToFile("EmailLog_dosifyLogFile", line, "C:\\Simply\\QA_Automation\\ddosify_0.7.5_windows_amd64");

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

    private static void createDirctory(){
        File directory = new File("C:\\Simply\\QA_Automation\\ddosify_0.7.5_windows_amd64\\LogFile");
        if (! directory.exists()){
            directory.mkdir();
            // If you require it to make the entire directory path including parents,
            // use directory.mkdirs(); here instead.
        }
    }

}
