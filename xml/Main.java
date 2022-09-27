
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.Scanner;

public class Main {
    public static String Task;

    public static void main(String[] args) {


        System.out.println("EZTask (Pre Release V 1.0)");

        Scanner scanner = new Scanner(System.in);
        int selection = 9;
        while (selection != 0){
            try {

                System.out.println("0 - Close the program");
                System.out.println("1 - View contents of a file");
                System.out.println("2 - Delete a file");
                System.out.println("3 - Create a File");

                System.out.println("Input a relevant integer to continue:");

                selection = scanner.nextInt();

                if (selection == 0){
                    System.out.println("Closing Program...");
                }
                else if (selection == 1){
                    System.out.println("select which file you want to open");
                }
                else if (selection == 2){
                    System.out.println("select which file you want to Delete");
                }
                else if (selection == 3){
                    System.out.println("select the name for the file");


                    Task = scanner.next();
                    System.out.println(Task);

                    CreateFile();
                }
                else;{
                    System.out.println("Not a valid integer, please input a valid integer");
                }
            }

            catch( Exception e){
                System.out.println("Input is invalid! please input a single digit integer");
                scanner.next();

            }


        }
    }


    static void CreateFile(){

        Scanner scanner = new Scanner(System.in);

         String xmlFilePath = "C:\\Uni\\S2 2022\\building systems\\XML Tasks\\" + Main.Task + ".xml";


          int LoopLimit;
          int counter = 1;
          String NewTask;
            try {

                System.out.println("how many tasks will you have?: ");

                LoopLimit = scanner.nextInt();

                DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

                DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

                Document document = documentBuilder.newDocument();

                // root element
                Element root = document.createElement("Tasks");
                document.appendChild(root);
                while (counter <= LoopLimit) {
                    // employee element
                    Element Tasks = document.createElement("Completed");

                    root.appendChild(Tasks);

                    // set an attribute to staff element
                    Attr attr = document.createAttribute("id");
                    attr.setValue("0");
                    Tasks.setAttributeNode(attr);

                    //you can also use staff.setAttribute("id", "1") for this

                    System.out.println("what is task " + counter +": ");
                    NewTask = scanner.next();
                    // firstname element
                    Element Task = document.createElement("Task");
                    Task.appendChild(document.createTextNode(NewTask));
                    Tasks.appendChild(Task);

                    counter++;
                }
                // create the xml file
                //transform the DOM Object to an XML File
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();

                DOMSource domSource = new DOMSource(document);
                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                StreamResult streamResult = new StreamResult(new File(xmlFilePath));

                // If you use
                // StreamResult result = new StreamResult(System.out);
                // the output will be pushed to the standard output ...
                // You can use that for debugging

                transformer.transform(domSource, streamResult);

                System.out.println("Done creating XML File");

            } catch (ParserConfigurationException pce) {
                pce.printStackTrace();
            } catch (TransformerException tfe) {
                tfe.printStackTrace();
            }
        }

    }






