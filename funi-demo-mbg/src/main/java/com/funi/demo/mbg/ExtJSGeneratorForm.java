package com.funi.demo.mbg;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.config.ColumnOverride;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.NullProgressCallback;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

/**
 * @author zhihuan.niu on 2017/4/26.
 */
public class ExtJSGeneratorForm extends JFrame {
    private JPanel panelHeader;
    private JComboBox comboBoxResource;
    private JComboBox comboBoxTable;
    private JComboBox comboBoxCode;
    private JTextArea textArea;
    private Map<String,IntrospectedTable> map=new HashMap<>();
    private static final String packagePrefix="app.demo";
    public ExtJSGeneratorForm() throws IOException, XMLParserException {
        this.setLayout(new BorderLayout());
        this.panelHeader =new JPanel();
        comboBoxResource =new JComboBox();
        comboBoxTable =new JComboBox();
        comboBoxCode =new JComboBox();
        panelHeader.setLayout(new FlowLayout());
        panelHeader.add(new JLabel("资源文件"));
        panelHeader.add(comboBoxResource);
        panelHeader.add(new JLabel("数据表"));
        panelHeader.add(comboBoxTable);
        panelHeader.add(new JLabel("代码"));
        panelHeader.add(comboBoxCode);
        comboBoxCode.addItem("清空");
        comboBoxCode.addItem("Model");
        comboBoxCode.addItem("Store");
        this.getContentPane().add("North", this.panelHeader);
        textArea=new JTextArea();
        getContentPane().add(textArea);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);//让窗体居中显示
        File[] files = new File(this.getClass().getClassLoader().getResource(".").getPath()).listFiles();
        for (File file:files){
            if(file.getName().endsWith(".cfg.xml")){
                comboBoxResource.addItem(file.getName());
            }
        }
        comboBoxResource.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resourceName=comboBoxResource.getSelectedItem().toString();
                try {
                    initCfgXML(resourceName);
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (XMLParserException e1) {
                    e1.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                } catch (NoSuchFieldException e1) {
                    e1.printStackTrace();
                }
            }
        });
        comboBoxCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem=comboBoxCode.getSelectedItem().toString();
                String selectedTable=comboBoxTable.getSelectedItem().toString();
                IntrospectedTable introspectedTable=map.get(selectedTable);
                String text="";
                if("清空".equals(selectedItem)){
                    textArea.setText("");
                }
                if("Model".equals(selectedItem)){
                    text = getModelString(introspectedTable);
                }
                if("Store".equals(selectedItem)){
                    text = getStoreString(introspectedTable);
                }
                textArea.setText(text);
            }
        });
    }

    /**
     * 获取ModelJS字符串
     * @param introspectedTable
     * @return
     */
    private String getModelString(IntrospectedTable introspectedTable) {
        String objectName = introspectedTable.getTableConfiguration().getDomainObjectName();
        String text="Ext.define('"+packagePrefix+".model."+objectName+"Model', {\n" +
                "\textend: 'Ext.data.Model',\n";
        if(introspectedTable.getPrimaryKeyColumns().size()>0) {
            text+="\tidProperty: '" + introspectedTable.getPrimaryKeyColumns().get(0).getJavaProperty() + "',\n";
        }
        text+="\tfields: [\n";
        for (IntrospectedColumn columnOverride:introspectedTable.getAllColumns()) {
            String type = columnOverride.getFullyQualifiedJavaType().getShortName().toLowerCase();
            String property = columnOverride.getJavaProperty();
            if (type.equals("date")) {
                text += "\t\t{name: '" + property + "',mapping: '" + property + "',  type: '" + type + "',dateFormat:'Y-m-d H:i:s'},\n";
            } else if (type.equals("integer")) {
                text += "\t\t{name: '" + property + "',mapping: '" + property + "',  type: 'int'},\n";
            } else {
                text += "\t\t{name: '" + property + "',mapping: '" + property + "',  type: '" + type + "'},\n";
            }
        }
        text+="\t]\n" +
                "});";
        return text;
    }
    /**
     * 获取StoreJS字符串
     * @param introspectedTable
     * @return
     */
    private String getStoreString(IntrospectedTable introspectedTable) {
        String objectName = introspectedTable.getTableConfiguration().getDomainObjectName();
        String text="Ext.define('"+packagePrefix+".model."+objectName+"Model', {\n" +
                "\textend: 'Ext.data.Model',\n";
        if(introspectedTable.getPrimaryKeyColumns().size()>0) {
            text+="\tidProperty: '" + introspectedTable.getPrimaryKeyColumns().get(0).getJavaProperty() + "',\n";
        }
        text+="\tfields: [\n";
        for (IntrospectedColumn columnOverride:introspectedTable.getAllColumns()) {
            String type = columnOverride.getFullyQualifiedJavaType().getShortName().toLowerCase();
            String property = columnOverride.getJavaProperty();
            if (type.equals("date")) {
                text += "\t\t{name: '" + property + "',mapping: '" + property + "',  type: '" + type + "',dateFormat:'Y-m-d H:i:s'},\n";
            } else if (type.equals("integer")) {
                text += "\t\t{name: '" + property + "',mapping: '" + property + "',  type: 'int'},\n";
            } else {
                text += "\t\t{name: '" + property + "',mapping: '" + property + "',  type: '" + type + "'},\n";
            }
        }
        text+="\t]\n" +
                "});";
        return text;
    }

    private void initCfgXML(String fileName) throws IOException, XMLParserException, SQLException, InterruptedException, NoSuchFieldException, IllegalAccessException {
        //初始化数据
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName);
        List<String> warnings = new ArrayList();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        List<Context> contextList=config.getContexts();
        map.clear();
        comboBoxTable.removeAllItems();
        ProgressCallback callback = new NullProgressCallback();
        for (Context context:contextList){
            context.introspectTables(callback, warnings, null);
            Field file=context.getClass().getDeclaredField("introspectedTables");
            file.setAccessible(true);
            List<IntrospectedTable> list=(List<IntrospectedTable>)file.get(context);
            for (IntrospectedTable introspectedTable:list){
                String tableName=introspectedTable.getTableConfiguration().getTableName();
                comboBoxTable.addItem(tableName);
                map.put(tableName,introspectedTable);
            }
        }
    }

    public static void main(String[] args) throws IOException, XMLParserException {
        ExtJSGeneratorForm from=new ExtJSGeneratorForm();
        from.pack();
        from.setSize(800, 600);
        from.setVisible(true);
    }
}
