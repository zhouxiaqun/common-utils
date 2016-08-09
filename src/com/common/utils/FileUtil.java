package com.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;


public class FileUtil {
	
	 public static final int BUFFER_SIZE = 8192;

	    /**
	     * ����Ŀ¼
	     * 
	     * @param destDirName
	     *            Ŀ��Ŀ¼��
	     * @return Ŀ¼�����ɹ�����true�����򷵻�false
	     */
	    public static boolean createDir(String destDirName) {
	        if(StringUtil.isEmpty(destDirName))
	            return false;
	        if (!destDirName.endsWith(File.separator)) {
	            destDirName = destDirName + File.separator;
	        }
	        File dir = new File(destDirName);
	        if (dir.exists()) {
	            return false;
	        }
	        // ��������Ŀ¼
	        if (dir.mkdirs()) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    /**
	     * ɾ���ļ�
	     * 
	     * @param filePathAndName
	     *            String �ļ�·�������� ��c:/fqf.txt
	     * @param fileContent
	     *            String
	     * @return boolean
	     */
	    public static void delFile(String filePathAndName) {
	        try {
	            String filePath = filePathAndName;
	            filePath = filePath.toString();
	            java.io.File myDelFile = new java.io.File(filePath);
	            myDelFile.delete();

	        } catch (Exception e) {
	            System.out.println("ɾ���ļ���������");
	            e.printStackTrace();

	        }

	    }

	    /**
	     * ��ȡ���ֽ�����0
	     * 
	     * @param filePath //·��
	     * @throws IOException
	     */
	    @SuppressWarnings("resource")
	    public static byte[] getContent(String filePath) throws IOException {
	        File file = new File(filePath);
	        long fileSize = file.length();
	        if (fileSize > Integer.MAX_VALUE) {
	            System.out.println("file too big...");
	            return null;
	        }
	        FileInputStream fi = new FileInputStream(file);
	        byte[] buffer = new byte[(int) fileSize];
	        int offset = 0;
	        int numRead = 0;
	        while (offset < buffer.length
	                && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
	            offset += numRead;
	        }
	        // ȷ���������ݾ�����ȡ
	        if (offset != buffer.length) {
	            throw new IOException("Could not completely read file "+ file.getName());
	        }
	        fi.close();
	        return buffer;
	    }

	    /**
	     * ��ȡ���ֽ�����1
	     * 
	     * @param filePath
	     * @return
	     * @throws IOException
	     */
	    public static byte[] toByteArray(String filePath) throws IOException {

	        File f = new File(filePath);
	        if (!f.exists()) {
	            throw new FileNotFoundException(filePath);
	        }
	        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
	        BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
	        try {
	            int buf_size = 1024;
	            byte[] buffer = new byte[buf_size];
	            int len = 0;
	            while (-1 != (len = in.read(buffer, 0, buf_size))) {
	                bos.write(buffer, 0, len);
	            }
	            return bos.toByteArray();
	        } catch (IOException e) {
	            e.printStackTrace();
	            throw e;
	        } finally {
	            try {
	                in.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            bos.close();
	        }
	    }

	    /**
	     * ��ȡ���ֽ�����2
	     * 
	     * @param filePath
	     * @return
	     * @throws IOException
	     */
	    public static byte[] toByteArray2(String filePath) throws IOException {

	        File f = new File(filePath);
	        if (!f.exists()) {
	            throw new FileNotFoundException(filePath);
	        }

	        FileChannel channel = null;
	        FileInputStream fs = null;
	        fs = new FileInputStream(f);
	        channel = fs.getChannel();
	        try {
	            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
	            while ((channel.read(byteBuffer)) > 0) {
	                // do nothing
	                // System.out.println("reading");
	            }
	            return byteBuffer.array();
	        } catch (IOException e) {
	            e.printStackTrace();
	            throw e;
	        } finally {
	            try {
	                channel.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            try {
	                fs.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    /**
	     * Mapped File way MappedByteBuffer �����ڴ�����ļ�ʱ����������
	     * 
	     * @param filename
	     * @return
	     * @throws IOException
	     */
	    public static byte[] toByteArray3(String filePath) throws IOException {

	        RandomAccessFile rf = new RandomAccessFile(filePath, "r");
	        FileChannel fc = rf.getChannel();
	        try {
	            MappedByteBuffer byteBuffer = fc.map(MapMode.READ_ONLY, 0,
	                    fc.size()).load();
	            byte[] result = new byte[(int) fc.size()];
	            if (byteBuffer.remaining() > 0) {
	                byteBuffer.get(result, 0, byteBuffer.remaining());
	            }
	            return result;
	        } catch (IOException e) {
	            e.printStackTrace();
	            throw e;
	        } finally {
	            try {
	                rf.close();
	                fc.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    public static String getFormat(String name) {
	        if (null == name || "".equals(name)) {
	            return "";
	        }

	        int dot = name.lastIndexOf('.');
	        if (dot>=0 && dot<name.length()) {
	            return name.substring(dot+1);
	        } else {
	            return "";
	        }
	    }

	    public static String getName(String name) {
	        if (null == name || "".equals(name)) {
	            return "";
	        }

	        int dot = name.lastIndexOf('.');
	        if (dot>=0 && dot<name.length()) {
	            return name.substring(0, dot);
	        } else {
	            return name;
	        }
	    }

	    public static String getFileName(String path) {
	        if (null == path || "".equals(path)) {
	            return "";
	        }

	        String tmpPath = path.replaceAll("\\\\", "/");
	        int slash = tmpPath.lastIndexOf('/');
	        if (slash>=0 && slash<path.length()) {
	            return path.substring(slash+1);
	        } else {
	            return path;
	        }
	    }

	    public static File getTmpFile() {
	        File tmpDir = FileUtils.getTempDirectory();
	        String tmpFileName = (Math.random() * 10000 + "").replace(".", "");
	        return new File(tmpDir, tmpFileName);
	    }

	    public static Map<String, Object> saveTmpFile(File tmpFile, String path) {
	        Map<String, Object> retMap = new HashMap<String, Object>();
	        File targetFile = new File(path);

	        if (targetFile.canWrite()) {
	            retMap.put("result", "fail");
	            retMap.put("msg", "Ŀ��·���ļ��Ѵ���!");
	            return retMap;
	        }

	        try {
	            FileUtils.moveFile(tmpFile, targetFile);
	        } catch (IOException e) {
	            retMap.put("result", "fail");
	            retMap.put("msg", "mv�ļ��쳣!");
	            return retMap;
	        }

	        retMap.put( "result", "success");
	        retMap.put( "size", targetFile.length());
	        retMap.put( "title", targetFile.getName() );
	        return retMap;
	    }

	    public static Map<String, Object> saveFileByInputStream(InputStream is, String path,
	            long maxSize) {

	        Map<String, Object> retMap = new HashMap<String, Object>();

	        File tmpFile = getTmpFile();

	        byte[] dataBuf = new byte[ 2048 ];
	        BufferedInputStream bis = new BufferedInputStream(is, BUFFER_SIZE);

	        try {
	            BufferedOutputStream bos = new BufferedOutputStream(
	                    new FileOutputStream(tmpFile), BUFFER_SIZE);

	            int count = 0;
	            while ((count = bis.read(dataBuf)) != -1) {
	                bos.write(dataBuf, 0, count);
	            }
	            bos.flush();
	            bos.close();

	            if (tmpFile.length() > maxSize) {
	                tmpFile.delete();
	                retMap.put("result", "fail");
	                retMap.put("msg", "�ļ���С�����������ֵ!");
	                return retMap;
	            }

	            Map<String, Object> saveRetMap = saveTmpFile(tmpFile, path);

	            String result = (String)saveRetMap.get("result");
	            if ("success".equals(result)) {
	                tmpFile.delete();
	            }

	            retMap.putAll(saveRetMap);
	            return saveRetMap;

	        } catch (IOException e) {
	            retMap.put("result", "fail");
	            retMap.put("msg", "�����ļ�IO�쳣");
	            return retMap;
	        }
	    }

}
