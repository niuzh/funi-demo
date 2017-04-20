package com.funi.demo.mbg;

import org.mybatis.generator.exception.ShellException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhihuan.niu on 2017/4/18.
 */
public class DemoShellCallback extends DefaultShellCallback {
    public DemoShellCallback(){
        super(false);
    }
    @Override
    public File getDirectory(String targetProject, String targetPackage) throws ShellException {
        File directory= super.getDirectory(targetProject, targetPackage);
        return directory;
    }

    @Override
    public String mergeJavaFile(String newFileSource, String existingFileFullPath, String[] javadocTags, String fileEncoding) throws ShellException {
        //获取custom内容
        List<String> appFile=readFileByLines(existingFileFullPath);
        List<String> fileSource= readFileSourceByLines(newFileSource);
        fileSource.remove(fileSource.size()-1);
        if(appFile.size()>0) {
            appFile.remove(appFile.size() - 1);
        }
        String custom="\r\n\t//"+this.custom;
        //覆盖java文件
        File fileDomainObject = new File(existingFileFullPath);
        try {
            writeFile(fileDomainObject,"",fileEncoding);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder sb=new StringBuilder();
        for (String str:fileSource){
            sb.append(str+"\n");
        }
        sb.append(custom+"\n");
        for (String str:appFile){
            sb.append(str+"\n");
        }
        sb.append("}");
        return sb.toString();
    }
    private String custom="自定义属性或方法";
    public List<String> readFileByLines(String fileName) {
        List<String> fileApp=new ArrayList<>();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("fileName："+fileName);
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            boolean isAppend=false;
            while ((tempString = reader.readLine()) != null) {
                if(tempString.indexOf(custom)>0){
                    isAppend=true;
                }
                if(isAppend&&tempString.indexOf(custom)<0){
                    fileApp.add(tempString);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return fileApp;
    }
    public List<String> readFileSourceByLines(String newFileSource) {
        List<String> stringList=new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new StringReader(newFileSource));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                stringList.add(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return stringList;
    }
    private void writeFile(File file, String content, String fileEncoding) throws IOException {
        FileOutputStream fos = new FileOutputStream(file, false);
        OutputStreamWriter osw;
        if (fileEncoding == null) {
            osw = new OutputStreamWriter(fos);
        } else {
            osw = new OutputStreamWriter(fos, fileEncoding);
        }
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write(content);
        bw.close();
    }
    @Override
    public void refreshProject(String project) {

    }

    @Override
    public boolean isMergeSupported() {
        return true;
    }

    @Override
    public boolean isOverwriteEnabled() {
        return false;
    }
}
