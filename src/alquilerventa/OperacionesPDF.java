/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilerventa;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alber
 */
public class OperacionesPDF {
    
    public OperacionesPDF() {}
    
    public String generatePDF(String piso, int mes, int anio, String directorio) throws FileNotFoundException, DocumentException, ClassNotFoundException, SQLException {
        OperacionesBD o = new OperacionesBD();
        
        String month = o.obtainMes(mes);
        String ruta_pdf = directorio + "/factura_piso" + piso + "_" + month + "_" + anio + ".pdf";

        try {
            ArrayList<String> ar = o.obtainInvoiceData(piso, month, anio);
            
            if(ar.size() > 1) {
                Document doc = new Document(PageSize.A4);

                PdfWriter.getInstance(doc, new FileOutputStream(ruta_pdf));
                doc.open();

                doc.add(new Paragraph(" "));
                doc.add( Chunk.NEWLINE );

                Font f = new Font(Font.FontFamily.TIMES_ROMAN,24,Font.BOLD);

                Paragraph par = new Paragraph();
                par.setAlignment(Element.ALIGN_CENTER);
                par.setFont(f);
                par.add("FACTURA PISO");
                doc.add(par);

                doc.add( Chunk.NEWLINE );
                doc.add( Chunk.NEWLINE );

                f = new Font(Font.FontFamily.TIMES_ROMAN, 13f);

                ArrayList<Object> a = o.obtainPiso(piso);

                // Relleno domicilio
                par = new Paragraph();
                par.setFont(f);
                par.add("DOMICILIO: " + a.get(0));
                doc.add(par);

                // Relleno inquilino
                par = new Paragraph();
                par.setFont(f);
                par.add("INQUILINO: " + ar.get(4));
                doc.add(par);
                
                doc.add( Chunk.NEWLINE );
                doc.add( Chunk.NEWLINE );
                doc.add( Chunk.NEWLINE );

                // Relleno precio vivienda
                par = new Paragraph();
                par.setFont(f);
                par.add("Vivienda: " + ar.get(0) + " €");
                doc.add(par);
                
                // Relleno precio agua
                par = new Paragraph();
                par.setFont(f);
                par.add("Agua: " + ar.get(1) + " €");
                doc.add(par);
                
                // Relleno precio luz
                par = new Paragraph();
                par.setFont(f);
                par.add("Luz: " + ar.get(2) + " €");
                doc.add(par);
                
                // Relleno precio basura
                par = new Paragraph();
                par.setFont(f);
                par.add("Basura: " + ar.get(3) + " €");
                doc.add(par);
                
                doc.add( Chunk.NEWLINE );
                doc.add( Chunk.NEWLINE );
                
                // Total mes
                Float t = 0.0f;
                for(int i=0;i<4;i++) t += Float.parseFloat(ar.get(i));
                
                par = new Paragraph();
                par.setFont(f);
                par.add("Total: " + String.format("%.2f", t) + " €");
                doc.add(par);
                
                doc.close();

                return "";
            }
            else return ar.get(0);
        } catch (DocumentException | FileNotFoundException e) {
            return "error";
        }
    }
}
