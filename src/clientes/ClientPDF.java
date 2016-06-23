/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author LFOM
 */
//This class create PDF with all the clients in database
public class ClientPDF {
    
    // Creates a new pdf document
    Document document = new Document();
    
    /**     
    * Constructor creates a new document PDF to work with it 
    * @param  outFile name of file with pdf extension example.pdf
    * @throws java.io.FileNotFoundException
    * @throws com.itextpdf.text.DocumentException
    */
    public ClientPDF(String outFile) throws FileNotFoundException, DocumentException {
    
        // Creates a file with pdf extension (parameter outFile)
        FileOutputStream pdfFile = new FileOutputStream("C:/Users/"+System.getProperty("user.name")+"/Documents/"+outFile);
        // space between lines in pdf
        PdfWriter.getInstance(document,pdfFile).setInitialLeading(20);
        // Start the document to work with it
        document.open();
        
    }                    
    
    /**
    *Add the author
    *@param author PDF author
    */
    public void addAuthor (String author) {
        
        // add the author
        document.addAuthor(author);
    
    } //end addAuthor
    
    /**
    * Add new paragraph in PDF
    * @param paragraph the whole paragraph
    */
    public void addParagraph (String paragraph) throws DocumentException {
    
    //add new paragraph in pdf
    document.add(new Paragraph(paragraph));
    
    } //End addParagraph
    
    /**
    * add a new table in pdf document
    * @param columns number of columns for the table
    * @param rows number of rows or cells for the table
    * @param content content of each cell
    * @param contentTwo second content for each cell
    * @param contentThree third content for each cell
    * @param contentFour fourth content for each cell
    * @throws com.itextpdf.text.DocumentException
    */
    public void addTable (Integer columns, Integer rows, String content, String contentTwo, String contentThree, String contentFour, String contentFive ) throws DocumentException {
        
        PdfPTable table = new PdfPTable(columns);        
        for (int i = 0; i < rows; i++) {
            
            //add each content for each cell
            table.addCell(content);
            table.addCell(contentTwo);
            table.addCell(contentThree);
            table.addCell(contentFour);
            table.addCell(contentFive);
            
        } //End for 
        
        //add the table into the document
        document.add(table);
    
    } //end addTable
    
    /**
     *add image in PDF document
     * @param corporativeImage image transparent watermark URL
     */
    public void addImage(String corporativeImage) {
    
        try {
            
            //image watermark transparent URL
            Image image1 = Image.getInstance(corporativeImage);
            //absolute position
            image1.setAbsolutePosition(100f, 100f);
            document.add(image1);            
            
            //document.add(image2);
            
            } catch(DocumentException | IOException e){
                
        } //End try catch
        
    } //End addImage        
    
    /**
    * close and create the document 
    */
    public void closePDF() {
    
        document.close();
        
    } //End closePDF
    
} //End ClientPDF class
