/**
 * 项目入口文件
 */
Ext.onReady(function () {
    Ext.Ajax.timeout = 60000 * 10;
    Ext.application({
        extend: 'Ext.app.Application',
        name: 'app',
        launch: function () {
            var me = this;
            me.callParent();
            //依赖行为基本配置
            Ext.Loader.setConfig({
                disableCaching: false
            });
            Ext.mainFrame = Ext.create('app.demo.Main');
        }
    });
});