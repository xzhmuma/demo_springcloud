package com.example.util;

import com.example.entity.base.BaseEntity;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class Common {
    /**
     * 判断对象为空
     *
     * @param obj 对象名
     * @return 是否为空
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if ((obj instanceof List)) {
            return ((List) obj).size() == 0;
        }
        if ((obj instanceof String)) {
            return ((String) obj).trim().equals("");
        }
        return false;
    }

    /**
     * 判断对象不为空
     *
     * @param obj 对象名
     * @return 是否不为空
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     * 使用率计算
     *
     * @return
     */
    public static String fromUsage(long free, long total) {
        Double d = new BigDecimal(free * 100 / total).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        return String.valueOf(d);
    }

    /**
     * 返回当前时间　格式：yyyy-MM-dd hh:mm:ss
     *
     * @return String
     */
    public static String fromDateH() {
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format1.format(new Date());
    }

    /**
     * 返回当前时间　格式：yyyy-MM-dd
     *
     * @return String
     */
    public static String fromDateY() {
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        return format1.format(new Date());
    }

    /**
     * 用来去掉List中空值和相同项的。
     *
     * @param list
     * @return
     */
    public static List<String> removeSameItem(List<String> list) {
        List<String> difList = new ArrayList<String>();
        for (String t : list) {
            if (t != null && !difList.contains(t)) {
                difList.add(t);
            }
        }
        return difList;
    }

    /**
     * 返回用户的IP地址
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 传入原图名称，，获得一个以时间格式的新名称
     *
     * @param fileName 　原图名称
     * @return
     */
    public static String generateFileName(String fileName) {
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String formatDate = format.format(new Date());
        int random = new Random().nextInt(10000);
        int position = fileName.lastIndexOf(".");
        String extension = fileName.substring(position);
        return formatDate + random + extension;
    }

    /**
     * 取得html网页内容 UTF8编码
     *
     * @param urlStr 网络地址
     * @return String
     */
    public static String getInputHtmlUTF8(String urlStr) {
        URL url = null;
        try {
            url = new URL(urlStr);
            HttpURLConnection httpsURLConnection = (HttpURLConnection) url.openConnection();

            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setConnectTimeout(5 * 1000);
            httpsURLConnection.connect();
            if (httpsURLConnection.getResponseCode() == 200) {
                // 通过输入流获取网络图片
                InputStream inputStream = httpsURLConnection.getInputStream();
                String data = readHtml(inputStream, "UTF-8");
                inputStream.close();
                return data;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;

    }

    /**
     * 取得html网页内容 GBK编码
     *
     * @param urlStr 网络地址
     * @return String
     */
    public static String getInputHtmlGBK(String urlStr) {
        URL url = null;
        try {
            url = new URL(urlStr);
            HttpURLConnection httpsURLConnection = (HttpURLConnection) url.openConnection();

            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setConnectTimeout(5 * 1000);
            httpsURLConnection.connect();
            if (httpsURLConnection.getResponseCode() == 200) {
                // 通过输入流获取网络图片
                InputStream inputStream = httpsURLConnection.getInputStream();
                String data = readHtml(inputStream, "GBK");
                inputStream.close();
                return data;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        return null;

    }

    /**
     * @param inputStream
     * @param uncode      编码 GBK 或 UTF-8
     * @return
     * @throws Exception
     */
    public static String readHtml(InputStream inputStream, String uncode) throws Exception {
        InputStreamReader input = new InputStreamReader(inputStream, uncode);
        BufferedReader bufReader = new BufferedReader(input);
        String line = "";
        StringBuilder contentBuf = new StringBuilder();
        while ((line = bufReader.readLine()) != null) {
            contentBuf.append(line);
        }
        return contentBuf.toString();
    }

    /**
     * @return 返回资源的二进制数据 @
     */
    public static byte[] readInputStream(InputStream inputStream) {

        // 定义一个输出流向内存输出数据
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // 定义一个缓冲区
        byte[] buffer = new byte[1024];
        // 读取数据长度
        int len = 0;
        // 当取得完数据后会返回一个-1
        try {
            while ((len = inputStream.read(buffer)) != -1) {
                // 把缓冲区的数据 写到输出流里面
                byteArrayOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        // 得到数据后返回
        return byteArrayOutputStream.toByteArray();

    }

    // 磁盘读写初始数据 用于计算读写速率
    private static Map<String, String> diskWritesAndReadsOnInit = new HashMap<String, String>();
    private static long initTime;
    /*static {
        initTime = System.currentTimeMillis();
		*//*resetClasspath();*//*
        Sigar sigar = null;
		try {

			sigar = new Sigar();
			FileSystem fslist[] = sigar.getFileSystemList();
			FileSystemUsage usage = null;
			for (int i = 0; i < fslist.length; i++) {
				FileSystem fs = fslist[i];
				if (fs.getType() != 2)
					continue;
				usage = sigar.getFileSystemUsage(fs.getDirName());
				diskWritesAndReadsOnInit.put(fs.getDevName(), usage.getDiskReadBytes() + "|" + usage.getDiskWriteBytes());
			}
		} catch (Exception e) {
		} finally {
			if (sigar != null)
				sigar.close();
		}
	}*/

    /**
     * ， 重新设置CLASSPATH,加入sigar，以支持dll,so等文件的加入与读取
     */
    /*private static void resetClasspath() {
        String libPath = System.getProperty("java.library.path");
		String classpath = ServerInfoController.class.getResource("/").getPath();
		System.setProperty("java.library.path", classpath + File.separator + "sigar" + File.pathSeparator + libPath);
	}*/


	/*public static void getServerCpuInfo(Sigar sigar, ServerStatus status) {
        try {
			CpuInfo infos[] = sigar.getCpuInfoList();
			CpuPerc cpuList[] = sigar.getCpuPercList();
			double totalUse = 0L;
			for (int i = 0; i < infos.length; i++) {
				CpuPerc perc = cpuList[i];
				ServerStatus.CpuInfoVo cpuInfo = new ServerStatus.CpuInfoVo();
				cpuInfo.setId(infos[i].hashCode() + "");
				cpuInfo.setCacheSize(infos[i].getCacheSize());
				cpuInfo.setModel(infos[i].getModel());
				cpuInfo.setUsed(CpuPerc.format(perc.getCombined()));
				cpuInfo.setUsedOrigVal(perc.getCombined());
				cpuInfo.setIdle(CpuPerc.format(perc.getIdle()));
				cpuInfo.setTotalMHz(infos[i].getMhz());
				cpuInfo.setVendor(infos[i].getVendor());
				status.getCpuInfos().add(cpuInfo);
				totalUse += perc.getCombined();
			}
			String cpuu = CpuPerc.format(totalUse / status.getCpuInfos().size());
			cpuu = cpuu.substring(0,cpuu.length()-1);
			status.setCpuUsage(cpuu);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}*/


    /**
     * 获取当前认证通过的用户名
     *
     * @return
     */
    public static String getAuthenticatedUsername() {
        String username = "";


//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null) {
//            Object principal = authentication.getPrincipal();
//            if (principal instanceof UserDetails) {
//                username = ((UserDetails) principal).getUsername();
//            } else {
//                username = principal.toString();
//            }
//        }

        return username;
    }

    public static BaseEntity setUpdated(BaseEntity baseEntity) {
        Date data = new Date();
        String username = getAuthenticatedUsername();
        if (isEmpty(baseEntity.getCreatedBy())) {

            baseEntity.setCreatedBy(username);
            baseEntity.setCreatedDate(data);
        }
        baseEntity.setUpdatedBy(username);
        baseEntity.setUpdatedDate(data);


        return baseEntity;
    }

}
