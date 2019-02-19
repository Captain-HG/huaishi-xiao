package com.qilinxx.huaishixiao.utils.topdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class TextParser {
    private static TextParser parser = null;

    private TextParser() {
    }
    public static synchronized TextParser getInstance() {
        if (parser == null) {
            parser = new TextParser();
        }
        return parser;
    }

    public void text2pdf(String sourceAddress ,String targetAddress) throws DocumentException, IOException {
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);

        FileOutputStream out = new FileOutputStream(targetAddress);

        Rectangle rect = new Rectangle(PageSize.A4.rotate());

        Document doc = new Document(rect);


        PdfWriter writer = PdfWriter.getInstance(doc, out);

        doc.open();
        Paragraph p = new Paragraph();
        p.setFont(FontChinese);

        BufferedReader read = new BufferedReader(new FileReader(sourceAddress));

        String line = read.readLine();
        while (line != null) {
            p.add(line + "\n");
            line = read.readLine();
        }
        read.close();

        doc.add(p);

        doc.close();

    }
}