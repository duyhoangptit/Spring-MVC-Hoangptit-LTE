package vn.hoangptit.learningframework.configs;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * author Hoangptit
 * Date 9/12/2016
 */
public class PdfRevenueReportView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map model, Document document,
                                    PdfWriter pdfWriter, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        Map<String,String> revenueData = (Map<String,String>) model.get("revenueData");

        Table table = new Table(2);
        table.addCell("Month");
        table.addCell("Revenue");

        for (Map.Entry<String, String> entry : revenueData.entrySet()) {
            table.addCell(entry.getKey());
            table.addCell(entry.getValue());
        }

        document.add(table);
    }
}
