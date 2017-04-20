Ext.define('app.demo.Main', {
    extend: 'Ext.Viewport',
    layout: 'border',
    uses : [
    ],
    initComponent: function () {
        var me = this;
        Ext.applyIf(this, {
            name:'bordercontainer',
            layout: 'border',
            items: [
                {
                    region: "north",
                    itemId: 'maintop',
                    height: 50,
                    margin: '0 0 0 0',
                    padding: '0px',
                    collapsible: false,
                    xtype: 'toolbar',
                    style: {
                        backgroundColor : 'rgb(165, 199, 245)'
                    },
                    border: false,
                    defaults: {
                        //xtype: 'buttontransparent'
                    },
                    items: [
                        {xtype:'label',text:'demo',
                            style: {fontSize: '23px',color: '#fff'},
                        },
                        '->', '->', '->', '->',
                        {
                            xtype: 'displayfield',
                            labelAlign: "right",
                            fieldLabel: '当前用户:',
                            itemId: 'userName',
                        },
                        {
                            text: '修改密码',
                            style: {color:' #fff'},
                            handler: function () {}
                        },
                        {
                            text: '退出登录',
                            handler: function () {
                                me.logout();
                            }
                        },
                    ]
                },
                {
                    region: "west", border: true, padding: '0px', split: true, margin: '0', collapsible: true, collapsed: false,
                    xtype: 'treepanel',
                    itemId:'menuTree',
                    title: '菜单',
                    width: 200,
                    lines:false,    //展开图标之间时候有连线
                    useArrows: true,    //箭头图标展开
                    store:this.__createMenuStore(),
                    rootVisible: false, //根节点是否可见，默认为Root
                    listeners:{
                        scope:this,
                        itemclick:function(source, record, item, index, e, eOpts){
                            me.__openIframeView(record.data.text,record.data.name);
                        }
                    }
                },
                {
                    itemId: 'centerBox', region: "center", layout: 'fit', border: true, margin: '0 0 0 0', collapsible: false,
                    id:'centerBox',
                    xtype: 'tabpanel',
                    enableTabScroll:true,
                    deferredRender:false,
                    items:[{
                        title:'首页',
                    }]
                }
            ],
            listeners:{
                afterrender:function(){
                    Ext.Ajax.on('requestcomplete',function(conn,response,options) {
                        if(response && response.getResponseHeader && response.getResponseHeader('_timeout')){
                            Ext.Msg.alert('提示', '用户超时，请重新登录!', function(){
                                me.logout();
                            });
                        }
                    })
                }
            }
        });
        var userName = Ext.util.Cookies.get("userName");
        this.callParent(arguments);
    },
    __openIframeView: function (viewClsName, url, config) {
        config = config || {};
        var newView = {};
        if(url != ''  &&  url!=undefined){
            var v = Ext.mainFrame.findView(viewClsName);
            if (v) {
                Ext.mainFrame.getComponent("centerBox").setActiveTab(v);
                return v;
            }else{
                newView = Ext.create(url, config);
                newView.viewClassName = viewClsName;
            }
            newView.closable = true;
            newView.title = viewClsName;
            var tab = Ext.mainFrame.getComponent("centerBox").add(newView);
            Ext.mainFrame.getComponent("centerBox").setActiveTab(tab);
            Ext.mainFrame.doLayout();
            return newView;
        }
    },
    findView: function (viewClassName) {
        var result = false;
        Ext.mainFrame.getComponent("centerBox").items.each(function (item, index, length) {
            if (item.title && item.title == viewClassName) {
                result = item;
                return result;
            }
        });
        return result;
    },
    logout:function(){
        var action = Ext.create('Ext.form.Basic',this,{
            standardSubmit:true
        })
        action.submit({
            url: '/demo/logout',
            clientValidation: false
        });
    },
    __createMenuStore:function(){
        var root;
        Ext.Ajax.request({
            url: '/demo/user/mbg',
            async: false,
            success: function (response) {
                var result = Ext.util.JSON.decode(response.responseText);
                root= result.root
            }
        });
        var treeStore = Ext.create('Ext.data.TreeStore', {
            root: root
        });
        return treeStore;
    }
});
/*添加tab*/
function addTab(title,className, config) {
    config = config || {};
    var result = false;
    var tabs = Ext.mainFrame.getComponent("centerBox");
    console.log('title[' + title + ']' + 'className[' + className + ']' + 'config[' + config + ']')
    tabs.items.each(function (item, index, length) {
        if (item.title && item.title == title) {
            result = item;
            if(Ext.String.endsWith(className,'ListView')) {
                tabs.setActiveTab(result);
                console.log('active tab:' + title);
            }else {
                tabs.remove(result);
                console.log('remove tab:' + title);
                addTab(title,className, config);
            }
        }
    });
    if(result==false) {
        console.log('create view' + title);
        var newView = Ext.create(className, config);
        newView.closable = true;
        newView.title = title;
        var tab = tabs.add(newView);
        tabs.setActiveTab(tab);
        Ext.mainFrame.doLayout();
    }
}
/*移除tab*/
function removeTab(title){
    var tabs = Ext.mainFrame.getComponent("centerBox");
    tabs.items.each(function (item, index, length) {
        if (item.title && item.title == title) {
            tabs.remove(item);
            console.log('remove tab:' + title);
        }
    });
}
