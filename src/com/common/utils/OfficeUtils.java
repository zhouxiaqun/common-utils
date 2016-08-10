package com.common.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.w3c.dom.Document;

public class OfficeUtils {
	
	 /**
     * @Title: word2Html
     * @Description: 将word转为html工具
     * @param file
     *            word文件
     * @return html页面字符串
     * @throws TransformerException
     * @throws IOException
     * @throws ParserConfigurationException
     */
    public static String word2Html(InputStream file) throws TransformerException, IOException, ParserConfigurationException {
        HWPFDocument wordDocument = new HWPFDocument(file);
        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
        wordToHtmlConverter.processDocument(wordDocument);
        Document htmlDocument = wordToHtmlConverter.getDocument();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(out);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer = tf.newTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "GBK");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.METHOD, "html");
        serializer.transform(domSource, streamResult);
        out.close();
        return new String(out.toByteArray());
    }

    /**
     * @Title: html2Word
     * @Description: html 导出到输出到word输出流中
     * @param os
     *            word的输出流
     * @param content
     *            html页面内容
     * @throws IOException
     */
    public static void html2Word(OutputStream os, String content) throws IOException {
        POIFSFileSystem fs = new POIFSFileSystem();
        InputStream is = new ByteArrayInputStream(content.getBytes("UTF-8"));
        fs.createDocument(is, "WordDocument");
        fs.writeFilesystem(os);
        os.close();
        is.close();
    }

   

}
