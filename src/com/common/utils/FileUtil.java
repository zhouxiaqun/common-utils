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
	     * 创建目录
	     * 
	     * @param destDirName
	     *            目标目录名
	     * @return 目录创建成功返回true，否则返回false
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
	        // 创建单个目录
	        if (dir.mkdirs()) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    /**
	     * 删除文件
	     * 
	     * @param filePathAndName
	     *            String 文件路径及名称 如c:/fqf.txt
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
	            System.out.println("删除文件操作出错");
	            e.printStackTrace();

	        }

	    }

	    /**
	     * 读取到字节数组0
	     * 
	     * @param filePath //路径
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
	        // 确保所有数据均被读取
	        if (offset != buffer.length) {
	            throw new IOException("Could not completely read file "+ file.getName());
	        }
	        fi.close();
	        return buffer;
	    }

	    /**
	     * 读取到字节数组1
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
	     * 读取到字节数组2
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
	     * Mapped File way MappedByteBuffer 可以在处理大文件时，提升性能
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
	            retMap.put("msg", "目标路径文件已存在!");
	            return retMap;
	        }

	        try {
	            FileUtils.moveFile(tmpFile, targetFile);
	        } catch (IOException e) {
	            retMap.put("result", "fail");
	            retMap.put("msg", "mv文件异常!");
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
	                retMap.put("msg", "文件大小超过允许最大值!");
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
	            retMap.put("msg", "保存文件IO异常");
	            return retMap;
	        }
	    }

}
